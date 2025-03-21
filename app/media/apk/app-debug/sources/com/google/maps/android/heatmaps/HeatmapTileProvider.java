package com.google.maps.android.heatmaps;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.collection.LongSparseArray;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.quadtree.PointQuadTree;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes.dex */
public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.7d;
    public static final int DEFAULT_RADIUS = 20;
    private static final int MAX_RADIUS = 50;
    private static final int MAX_ZOOM_LEVEL = 22;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 512;
    static final double WORLD_WIDTH = 1.0d;
    private Bounds mBounds;
    private int[] mColorMap;
    private double mCustomMaxIntensity;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private PointQuadTree<WeightedLatLng> mTree;

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private Collection<WeightedLatLng> data;
        private int radius = 20;
        private Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double opacity = 0.7d;
        private double intensity = 0.0d;

        public Builder data(Collection<LatLng> val) {
            return weightedData(HeatmapTileProvider.wrapData(val));
        }

        public Builder weightedData(Collection<WeightedLatLng> val) {
            this.data = val;
            if (val.isEmpty()) {
                throw new IllegalArgumentException("No input points.");
            }
            return this;
        }

        public Builder radius(int val) {
            this.radius = val;
            if (val < 10 || val > 50) {
                throw new IllegalArgumentException("Radius not within bounds.");
            }
            return this;
        }

        public Builder gradient(Gradient val) {
            this.gradient = val;
            return this;
        }

        public Builder opacity(double val) {
            this.opacity = val;
            if (val < 0.0d || val > 1.0d) {
                throw new IllegalArgumentException("Opacity must be in range [0, 1]");
            }
            return this;
        }

        public Builder maxIntensity(double val) {
            this.intensity = val;
            return this;
        }

        public HeatmapTileProvider build() {
            if (this.data == null) {
                throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
            }
            return new HeatmapTileProvider(this);
        }
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        this.mGradient = builder.gradient;
        this.mOpacity = builder.opacity;
        this.mCustomMaxIntensity = builder.intensity;
        int i = this.mRadius;
        this.mKernel = generateKernel(i, i / 3.0d);
        setGradient(this.mGradient);
        setWeightedData(this.mData);
    }

    public void setWeightedData(Collection<WeightedLatLng> data) {
        this.mData = data;
        if (data.isEmpty()) {
            throw new IllegalArgumentException("No input points.");
        }
        Bounds bounds = getBounds(this.mData);
        this.mBounds = bounds;
        this.mTree = new PointQuadTree<>(bounds);
        for (WeightedLatLng l : this.mData) {
            this.mTree.add(l);
        }
        this.mMaxIntensity = getMaxIntensities(this.mRadius);
    }

    public void setData(Collection<LatLng> data) {
        setWeightedData(wrapData(data));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> wrapData(Collection<LatLng> data) {
        ArrayList<WeightedLatLng> weightedData = new ArrayList<>();
        for (LatLng l : data) {
            weightedData.add(new WeightedLatLng(l));
        }
        return weightedData;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00cb  */
    @Override // com.google.android.gms.maps.model.TileProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.maps.model.Tile getTile(int r41, int r42, int r43) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.heatmaps.HeatmapTileProvider.getTile(int, int, int):com.google.android.gms.maps.model.Tile");
    }

    public void setGradient(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    public void setRadius(int radius) {
        this.mRadius = radius;
        this.mKernel = generateKernel(radius, radius / 3.0d);
        this.mMaxIntensity = getMaxIntensities(this.mRadius);
    }

    public void setOpacity(double opacity) {
        this.mOpacity = opacity;
        setGradient(this.mGradient);
    }

    public void setMaxIntensity(double intensity) {
        this.mCustomMaxIntensity = intensity;
        setWeightedData(this.mData);
    }

    private double[] getMaxIntensities(int radius) {
        double[] maxIntensityArray = new double[22];
        if (this.mCustomMaxIntensity != 0.0d) {
            for (int i = 0; i < 22; i++) {
                maxIntensityArray[i] = this.mCustomMaxIntensity;
            }
            return maxIntensityArray;
        }
        for (int i2 = 5; i2 < 11; i2++) {
            maxIntensityArray[i2] = getMaxValue(this.mData, this.mBounds, radius, (int) (Math.pow(2.0d, i2 - 3) * 1280.0d));
            if (i2 == 5) {
                for (int j = 0; j < i2; j++) {
                    maxIntensityArray[j] = maxIntensityArray[i2];
                }
            }
        }
        for (int i3 = 11; i3 < 22; i3++) {
            maxIntensityArray[i3] = maxIntensityArray[10];
        }
        return maxIntensityArray;
    }

    private static Tile convertBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bitmapdata = stream.toByteArray();
        return new Tile(512, 512, bitmapdata);
    }

    static Bounds getBounds(Collection<WeightedLatLng> points) {
        Iterator<WeightedLatLng> iter = points.iterator();
        WeightedLatLng first = iter.next();
        double minX = first.getPoint().x;
        double maxX = first.getPoint().x;
        double minY = first.getPoint().y;
        double maxY = first.getPoint().y;
        while (iter.hasNext()) {
            WeightedLatLng l = iter.next();
            double x = l.getPoint().x;
            double y = l.getPoint().y;
            if (x < minX) {
                minX = x;
            }
            if (x > maxX) {
                maxX = x;
            }
            if (y < minY) {
                minY = y;
            }
            if (y > maxY) {
                maxY = y;
            }
        }
        return new Bounds(minX, maxX, minY, maxY);
    }

    static double[] generateKernel(int radius, double sd) {
        double[] kernel = new double[(radius * 2) + 1];
        for (int i = -radius; i <= radius; i++) {
            kernel[i + radius] = Math.exp(((-i) * i) / ((2.0d * sd) * sd));
        }
        return kernel;
    }

    /* JADX WARN: Incorrect condition in loop: B:24:0x0078 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static double[][] convolve(double[][] r24, double[] r25) {
        /*
            Method dump skipped, instructions count: 190
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.heatmaps.HeatmapTileProvider.convolve(double[][], double[]):double[][]");
    }

    static Bitmap colorize(double[][] grid, int[] colorMap, double max) {
        int maxColor = colorMap[colorMap.length - 1];
        double colorMapScaling = (colorMap.length - 1) / max;
        int dim = grid.length;
        int[] colors = new int[dim * dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                double val = grid[j][i];
                int index = (i * dim) + j;
                int col = (int) (val * colorMapScaling);
                if (val != 0.0d) {
                    if (col < colorMap.length) {
                        colors[index] = colorMap[col];
                    } else {
                        colors[index] = maxColor;
                    }
                } else {
                    colors[index] = 0;
                }
            }
        }
        Bitmap tile = Bitmap.createBitmap(dim, dim, Bitmap.Config.ARGB_8888);
        tile.setPixels(colors, 0, dim, 0, 0, dim, dim);
        return tile;
    }

    static double getMaxValue(Collection<WeightedLatLng> points, Bounds bounds, int radius, int screenDim) {
        double minX = bounds.minX;
        double maxX = bounds.maxX;
        double minY = bounds.minY;
        double y = bounds.maxY;
        double boundsDim = maxX - minX > y - minY ? maxX - minX : y - minY;
        int nBuckets = (int) ((screenDim / (radius * 2)) + 0.5d);
        double scale = nBuckets / boundsDim;
        LongSparseArray<LongSparseArray<Double>> buckets = new LongSparseArray<>();
        double max = 0.0d;
        for (WeightedLatLng l : points) {
            double maxX2 = maxX;
            double maxX3 = l.getPoint().x;
            double maxY = y;
            double maxY2 = l.getPoint().y;
            double minX2 = minX;
            int xBucket = (int) ((maxX3 - minX) * scale);
            int yBucket = (int) ((maxY2 - minY) * scale);
            LongSparseArray<Double> column = buckets.get(xBucket);
            if (column == null) {
                column = new LongSparseArray<>();
                buckets.put(xBucket, column);
            }
            Double value = column.get(yBucket);
            if (value == null) {
                value = Double.valueOf(0.0d);
            }
            Double value2 = Double.valueOf(value.doubleValue() + l.getIntensity());
            double minY2 = minY;
            column.put(yBucket, value2);
            if (value2.doubleValue() > max) {
                max = value2.doubleValue();
            }
            maxX = maxX2;
            y = maxY;
            minX = minX2;
            minY = minY2;
        }
        return max;
    }
}
