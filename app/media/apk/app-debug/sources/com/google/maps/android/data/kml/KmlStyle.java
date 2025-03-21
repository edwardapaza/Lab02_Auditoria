package com.google.maps.android.data.kml;

import android.graphics.Color;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Style;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
/* loaded from: classes.dex */
public class KmlStyle extends Style {
    private static final int HSV_VALUES = 3;
    private static final int HUE_VALUE = 0;
    private static final int INITIAL_SCALE = 1;
    private String mIconUrl;
    private boolean mFill = true;
    private boolean mOutline = true;
    private String mStyleId = null;
    private final HashMap<String, String> mBalloonOptions = new HashMap<>();
    private final HashSet<String> mStylesSet = new HashSet<>();
    private double mScale = 1.0d;
    float mMarkerColor = 0.0f;
    private boolean mIconRandomColorMode = false;
    private boolean mLineRandomColorMode = false;
    private boolean mPolyRandomColorMode = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInfoWindowText(String text) {
        this.mBalloonOptions.put("text", text);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getStyleId() {
        return this.mStyleId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStyleId(String styleId) {
        this.mStyleId = styleId;
    }

    public boolean isStyleSet(String style) {
        return this.mStylesSet.contains(style);
    }

    public boolean hasFill() {
        return this.mFill;
    }

    public void setFill(boolean fill) {
        this.mFill = fill;
    }

    public double getIconScale() {
        return this.mScale;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIconScale(double scale) {
        this.mScale = scale;
        this.mStylesSet.add("iconScale");
    }

    public boolean hasOutline() {
        return this.mOutline;
    }

    public boolean hasBalloonStyle() {
        return this.mBalloonOptions.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOutline(boolean outline) {
        this.mOutline = outline;
        this.mStylesSet.add("outline");
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIconUrl(String iconUrl) {
        this.mIconUrl = iconUrl;
        this.mStylesSet.add("iconUrl");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFillColor(String color) {
        int polygonColorNum = Color.parseColor("#" + convertColor(color));
        setPolygonFillColor(polygonColorNum);
        this.mStylesSet.add("fillColor");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMarkerColor(String color) {
        int integerColor = Color.parseColor("#" + convertColor(color));
        this.mMarkerColor = getHueValue(integerColor);
        this.mMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(this.mMarkerColor));
        this.mStylesSet.add("markerColor");
    }

    private static float getHueValue(int integerColor) {
        float[] hsvValues = new float[3];
        Color.colorToHSV(integerColor, hsvValues);
        return hsvValues[0];
    }

    private static String convertColor(String color) {
        String color2;
        if (color.trim().length() > 6) {
            String newColor = color2.substring(0, 2) + color2.substring(6, 8) + color2.substring(4, 6) + color2.substring(2, 4);
            return newColor;
        }
        String newColor2 = color2.substring(4, 6) + color2.substring(2, 4) + color2.substring(0, 2);
        return newColor2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHeading(float heading) {
        setMarkerRotation(heading);
        this.mStylesSet.add("heading");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHotSpot(float x, float y, String xUnits, String yUnits) {
        setMarkerHotSpot(x, y, xUnits, yUnits);
        this.mStylesSet.add("hotSpot");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIconColorMode(String colorMode) {
        this.mIconRandomColorMode = colorMode.equals("random");
        this.mStylesSet.add("iconColorMode");
    }

    boolean isIconRandomColorMode() {
        return this.mIconRandomColorMode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLineColorMode(String colorMode) {
        this.mLineRandomColorMode = colorMode.equals("random");
        this.mStylesSet.add("lineColorMode");
    }

    public boolean isLineRandomColorMode() {
        return this.mLineRandomColorMode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPolyColorMode(String colorMode) {
        this.mPolyRandomColorMode = colorMode.equals("random");
        this.mStylesSet.add("polyColorMode");
    }

    public boolean isPolyRandomColorMode() {
        return this.mPolyRandomColorMode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOutlineColor(String color) {
        this.mPolylineOptions.color(Color.parseColor("#" + convertColor(color)));
        this.mPolygonOptions.strokeColor(Color.parseColor("#" + convertColor(color)));
        this.mStylesSet.add("outlineColor");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWidth(Float width) {
        setLineStringWidth(width.floatValue());
        setPolygonStrokeWidth(width.floatValue());
        this.mStylesSet.add("width");
    }

    public HashMap<String, String> getBalloonOptions() {
        return this.mBalloonOptions;
    }

    private static MarkerOptions createMarkerOptions(MarkerOptions originalMarkerOption, boolean iconRandomColorMode, float markerColor) {
        MarkerOptions newMarkerOption = new MarkerOptions();
        newMarkerOption.rotation(originalMarkerOption.getRotation());
        newMarkerOption.anchor(originalMarkerOption.getAnchorU(), originalMarkerOption.getAnchorV());
        if (iconRandomColorMode) {
            float hue = getHueValue(computeRandomColor((int) markerColor));
            originalMarkerOption.icon(BitmapDescriptorFactory.defaultMarker(hue));
        }
        newMarkerOption.icon(originalMarkerOption.getIcon());
        return newMarkerOption;
    }

    private static PolylineOptions createPolylineOptions(PolylineOptions originalPolylineOption) {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(originalPolylineOption.getColor());
        polylineOptions.width(originalPolylineOption.getWidth());
        polylineOptions.clickable(originalPolylineOption.isClickable());
        return polylineOptions;
    }

    private static PolygonOptions createPolygonOptions(PolygonOptions originalPolygonOption, boolean isFill, boolean isOutline) {
        float originalWidth = 0.0f;
        PolygonOptions polygonOptions = new PolygonOptions();
        if (isFill) {
            polygonOptions.fillColor(originalPolygonOption.getFillColor());
        }
        if (isOutline) {
            polygonOptions.strokeColor(originalPolygonOption.getStrokeColor());
            originalWidth = originalPolygonOption.getStrokeWidth();
        }
        polygonOptions.strokeWidth(originalWidth);
        polygonOptions.clickable(originalPolygonOption.isClickable());
        return polygonOptions;
    }

    public MarkerOptions getMarkerOptions() {
        return createMarkerOptions(this.mMarkerOptions, isIconRandomColorMode(), this.mMarkerColor);
    }

    public PolylineOptions getPolylineOptions() {
        return createPolylineOptions(this.mPolylineOptions);
    }

    public PolygonOptions getPolygonOptions() {
        return createPolygonOptions(this.mPolygonOptions, this.mFill, this.mOutline);
    }

    public static int computeRandomColor(int color) {
        Random random = new Random();
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        if (red != 0) {
            red = random.nextInt(red);
        }
        if (blue != 0) {
            blue = random.nextInt(blue);
        }
        if (green != 0) {
            green = random.nextInt(green);
        }
        return Color.rgb(red, green, blue);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Style").append("{");
        sb.append("\n balloon options=").append(this.mBalloonOptions);
        sb.append(",\n fill=").append(this.mFill);
        sb.append(",\n outline=").append(this.mOutline);
        sb.append(",\n icon url=").append(this.mIconUrl);
        sb.append(",\n scale=").append(this.mScale);
        sb.append(",\n style id=").append(this.mStyleId);
        sb.append("\n}\n");
        return sb.toString();
    }
}
