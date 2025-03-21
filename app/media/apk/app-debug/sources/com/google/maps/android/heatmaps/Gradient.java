package com.google.maps.android.heatmaps;

import android.graphics.Color;
import java.util.HashMap;
/* loaded from: classes.dex */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    public final int mColorMapSize;
    public int[] mColors;
    public float[] mStartPoints;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ColorInterval {
        private final int color1;
        private final int color2;
        private final float duration;

        private ColorInterval(int color1, int color2, float duration) {
            this.color1 = color1;
            this.color2 = color2;
            this.duration = duration;
        }
    }

    public Gradient(int[] colors, float[] startPoints) {
        this(colors, startPoints, 1000);
    }

    public Gradient(int[] colors, float[] startPoints, int colorMapSize) {
        if (colors.length != startPoints.length) {
            throw new IllegalArgumentException("colors and startPoints should be same length");
        }
        if (colors.length == 0) {
            throw new IllegalArgumentException("No colors have been defined");
        }
        for (int i = 1; i < startPoints.length; i++) {
            if (startPoints[i] <= startPoints[i - 1]) {
                throw new IllegalArgumentException("startPoints should be in increasing order");
            }
        }
        this.mColorMapSize = colorMapSize;
        int[] iArr = new int[colors.length];
        this.mColors = iArr;
        this.mStartPoints = new float[startPoints.length];
        System.arraycopy(colors, 0, iArr, 0, colors.length);
        System.arraycopy(startPoints, 0, this.mStartPoints, 0, startPoints.length);
    }

    private HashMap<Integer, ColorInterval> generateColorIntervals() {
        HashMap<Integer, ColorInterval> colorIntervals = new HashMap<>();
        if (this.mStartPoints[0] != 0.0f) {
            int initialColor = Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0]));
            colorIntervals.put(0, new ColorInterval(initialColor, this.mColors[0], this.mColorMapSize * this.mStartPoints[0]));
        }
        for (int i = 1; i < this.mColors.length; i++) {
            Integer valueOf = Integer.valueOf((int) (this.mColorMapSize * this.mStartPoints[i - 1]));
            int[] iArr = this.mColors;
            int i2 = iArr[i - 1];
            int i3 = iArr[i];
            float[] fArr = this.mStartPoints;
            colorIntervals.put(valueOf, new ColorInterval(i2, i3, (fArr[i] - fArr[i - 1]) * this.mColorMapSize));
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int i4 = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (this.mColorMapSize * fArr2[i4]));
            int i5 = this.mColors[i4];
            colorIntervals.put(valueOf2, new ColorInterval(i5, i5, this.mColorMapSize * (1.0f - this.mStartPoints[i4])));
        }
        return colorIntervals;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] generateColorMap(double opacity) {
        HashMap<Integer, ColorInterval> colorIntervals = generateColorIntervals();
        int[] colorMap = new int[this.mColorMapSize];
        ColorInterval interval = colorIntervals.get(0);
        int start = 0;
        for (int i = 0; i < this.mColorMapSize; i++) {
            if (colorIntervals.containsKey(Integer.valueOf(i))) {
                ColorInterval interval2 = colorIntervals.get(Integer.valueOf(i));
                interval = interval2;
                start = i;
            }
            float ratio = (i - start) / interval.duration;
            colorMap[i] = interpolateColor(interval.color1, interval.color2, ratio);
        }
        if (opacity != 1.0d) {
            for (int i2 = 0; i2 < this.mColorMapSize; i2++) {
                int c = colorMap[i2];
                colorMap[i2] = Color.argb((int) (Color.alpha(c) * opacity), Color.red(c), Color.green(c), Color.blue(c));
            }
        }
        return colorMap;
    }

    static int interpolateColor(int color1, int color2, float ratio) {
        int alpha = (int) (((Color.alpha(color2) - Color.alpha(color1)) * ratio) + Color.alpha(color1));
        float[] hsv1 = new float[3];
        Color.RGBToHSV(Color.red(color1), Color.green(color1), Color.blue(color1), hsv1);
        float[] hsv2 = new float[3];
        Color.RGBToHSV(Color.red(color2), Color.green(color2), Color.blue(color2), hsv2);
        if (hsv1[0] - hsv2[0] > 180.0f) {
            hsv2[0] = hsv2[0] + 360.0f;
        } else if (hsv2[0] - hsv1[0] > 180.0f) {
            hsv1[0] = hsv1[0] + 360.0f;
        }
        float[] result = new float[3];
        for (int i = 0; i < 3; i++) {
            result[i] = ((hsv2[i] - hsv1[i]) * ratio) + hsv1[i];
        }
        return Color.HSVToColor(alpha, result);
    }
}
