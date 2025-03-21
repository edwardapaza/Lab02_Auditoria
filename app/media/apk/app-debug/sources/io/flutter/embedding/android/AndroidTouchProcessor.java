package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import io.flutter.embedding.android.MotionEventTracker;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class AndroidTouchProcessor {
    static final int BYTES_PER_FIELD = 8;
    static final int DEFAULT_HORIZONTAL_SCROLL_FACTOR = 48;
    static final int DEFAULT_VERTICAL_SCROLL_FACTOR = 48;
    private static final Matrix IDENTITY_TRANSFORM = new Matrix();
    private static final int IMPLICIT_VIEW_ID = 0;
    private static final int POINTER_DATA_FIELD_COUNT = 36;
    private static final int POINTER_DATA_FLAG_BATCHED = 1;
    private static final String TAG = "AndroidTouchProcessor";
    private int cachedVerticalScrollFactor;
    private final FlutterRenderer renderer;
    private final boolean trackMotionEvents;
    private final Map<Integer, float[]> ongoingPans = new HashMap();
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();

    /* loaded from: classes.dex */
    public @interface PointerChange {
        public static final int ADD = 1;
        public static final int CANCEL = 0;
        public static final int DOWN = 4;
        public static final int HOVER = 3;
        public static final int MOVE = 5;
        public static final int PAN_ZOOM_END = 9;
        public static final int PAN_ZOOM_START = 7;
        public static final int PAN_ZOOM_UPDATE = 8;
        public static final int REMOVE = 2;
        public static final int UP = 6;
    }

    /* loaded from: classes.dex */
    public @interface PointerDeviceKind {
        public static final int INVERTED_STYLUS = 3;
        public static final int MOUSE = 1;
        public static final int STYLUS = 2;
        public static final int TOUCH = 0;
        public static final int TRACKPAD = 4;
        public static final int UNKNOWN = 5;
    }

    /* loaded from: classes.dex */
    public @interface PointerSignalKind {
        public static final int NONE = 0;
        public static final int SCALE = 3;
        public static final int SCROLL = 1;
        public static final int SCROLL_INERTIA_CANCEL = 2;
        public static final int UNKNOWN = 4;
    }

    public AndroidTouchProcessor(FlutterRenderer renderer, boolean trackMotionEvents) {
        this.renderer = renderer;
        this.trackMotionEvents = trackMotionEvents;
    }

    public boolean onTouchEvent(MotionEvent event) {
        return onTouchEvent(event, IDENTITY_TRANSFORM);
    }

    public boolean onTouchEvent(MotionEvent event, Matrix transformMatrix) {
        int pointerCount = event.getPointerCount();
        ByteBuffer packet = ByteBuffer.allocateDirect(pointerCount * 36 * 8);
        packet.order(ByteOrder.LITTLE_ENDIAN);
        int maskedAction = event.getActionMasked();
        int pointerChange = getPointerChangeForAction(event.getActionMasked());
        boolean z = false;
        boolean updateForSinglePointer = maskedAction == 0 || maskedAction == 5;
        if (!updateForSinglePointer && (maskedAction == 1 || maskedAction == 6)) {
            z = true;
        }
        boolean updateForMultiplePointers = z;
        if (updateForSinglePointer) {
            addPointerForIndex(event, event.getActionIndex(), pointerChange, 0, transformMatrix, packet);
        } else if (updateForMultiplePointers) {
            for (int p = 0; p < pointerCount; p++) {
                if (p != event.getActionIndex() && event.getToolType(p) == 1) {
                    addPointerForIndex(event, p, 5, 1, transformMatrix, packet);
                }
            }
            addPointerForIndex(event, event.getActionIndex(), pointerChange, 0, transformMatrix, packet);
        } else {
            for (int p2 = 0; p2 < pointerCount; p2++) {
                addPointerForIndex(event, p2, pointerChange, 0, transformMatrix, packet);
            }
        }
        if (packet.position() % 288 != 0) {
            throw new AssertionError("Packet position is not on field boundary");
        }
        this.renderer.dispatchPointerDataPacket(packet, packet.position());
        return true;
    }

    public boolean onGenericMotionEvent(MotionEvent event, Context context) {
        boolean z;
        boolean isPointerEvent;
        if (Build.VERSION.SDK_INT >= 18 && event.isFromSource(2)) {
            z = true;
            isPointerEvent = z;
            boolean isMovementEvent = event.getActionMasked() != 7 || event.getActionMasked() == 8;
            if (isPointerEvent || !isMovementEvent) {
                return false;
            }
            int pointerChange = getPointerChangeForAction(event.getActionMasked());
            ByteBuffer packet = ByteBuffer.allocateDirect(event.getPointerCount() * 36 * 8);
            packet.order(ByteOrder.LITTLE_ENDIAN);
            addPointerForIndex(event, event.getActionIndex(), pointerChange, 0, IDENTITY_TRANSFORM, packet, context);
            if (packet.position() % 288 != 0) {
                throw new AssertionError("Packet position is not on field boundary.");
            }
            this.renderer.dispatchPointerDataPacket(packet, packet.position());
            return true;
        }
        z = false;
        isPointerEvent = z;
        boolean isMovementEvent2 = event.getActionMasked() != 7 || event.getActionMasked() == 8;
        if (isPointerEvent) {
        }
        return false;
    }

    private void addPointerForIndex(MotionEvent event, int pointerIndex, int pointerChange, int pointerData, Matrix transformMatrix, ByteBuffer packet) {
        addPointerForIndex(event, pointerIndex, pointerChange, pointerData, transformMatrix, packet, null);
    }

    private void addPointerForIndex(MotionEvent event, int pointerIndex, int pointerChange, int pointerData, Matrix transformMatrix, ByteBuffer packet, Context context) {
        long buttons;
        long motionEventId;
        int signalKind;
        double pressureMax;
        MotionEvent motionEvent;
        int i;
        double d;
        InputDevice.MotionRange pressureRange;
        if (pointerChange == -1) {
            return;
        }
        int pointerId = event.getPointerId(pointerIndex);
        int pointerKind = getPointerDeviceTypeForToolType(event.getToolType(pointerIndex));
        float[] viewToScreenCoords = {event.getX(pointerIndex), event.getY(pointerIndex)};
        transformMatrix.mapPoints(viewToScreenCoords);
        if (pointerKind == 1) {
            buttons = event.getButtonState() & 31;
            if (buttons == 0 && event.getSource() == 8194 && pointerChange == 4) {
                this.ongoingPans.put(Integer.valueOf(pointerId), viewToScreenCoords);
            }
        } else {
            buttons = pointerKind == 2 ? (event.getButtonState() >> 4) & 15 : 0L;
        }
        int panZoomType = -1;
        boolean isTrackpadPan = this.ongoingPans.containsKey(Integer.valueOf(pointerId));
        if (isTrackpadPan && (panZoomType = getPointerChangeForPanZoom(pointerChange)) == -1) {
            return;
        }
        if (!this.trackMotionEvents) {
            motionEventId = 0;
        } else {
            MotionEventTracker.MotionEventId trackedEvent = this.motionEventTracker.track(event);
            long motionEventId2 = trackedEvent.getId();
            motionEventId = motionEventId2;
        }
        if (event.getActionMasked() == 8) {
            signalKind = 1;
        } else {
            signalKind = 0;
        }
        long buttons2 = buttons;
        long timeStamp = event.getEventTime() * 1000;
        packet.putLong(motionEventId);
        packet.putLong(timeStamp);
        if (isTrackpadPan) {
            long motionEventId3 = panZoomType;
            packet.putLong(motionEventId3);
            packet.putLong(4L);
        } else {
            long motionEventId4 = pointerChange;
            packet.putLong(motionEventId4);
            packet.putLong(pointerKind);
        }
        packet.putLong(signalKind);
        packet.putLong(pointerId);
        packet.putLong(0L);
        if (isTrackpadPan) {
            float[] panStart = this.ongoingPans.get(Integer.valueOf(pointerId));
            packet.putDouble(panStart[0]);
            packet.putDouble(panStart[1]);
        } else {
            packet.putDouble(viewToScreenCoords[0]);
            packet.putDouble(viewToScreenCoords[1]);
        }
        packet.putDouble(0.0d);
        packet.putDouble(0.0d);
        packet.putLong(buttons2);
        packet.putLong(0L);
        packet.putLong(0L);
        packet.putDouble(event.getPressure(pointerIndex));
        double pressureMin = 0.0d;
        if (event.getDevice() == null || (pressureRange = event.getDevice().getMotionRange(2)) == null) {
            pressureMax = 1.0d;
        } else {
            double pressureMin2 = pressureRange.getMin();
            double pressureMin3 = pressureRange.getMax();
            pressureMax = pressureMin3;
            pressureMin = pressureMin2;
        }
        packet.putDouble(pressureMin);
        packet.putDouble(pressureMax);
        if (pointerKind == 2) {
            motionEvent = event;
            i = pointerIndex;
            double pressureMin4 = motionEvent.getAxisValue(24, i);
            packet.putDouble(pressureMin4);
            packet.putDouble(0.0d);
        } else {
            motionEvent = event;
            i = pointerIndex;
            packet.putDouble(0.0d);
            packet.putDouble(0.0d);
        }
        packet.putDouble(event.getSize(pointerIndex));
        packet.putDouble(event.getToolMajor(pointerIndex));
        packet.putDouble(event.getToolMinor(pointerIndex));
        packet.putDouble(0.0d);
        packet.putDouble(0.0d);
        packet.putDouble(motionEvent.getAxisValue(8, i));
        if (pointerKind == 2) {
            packet.putDouble(motionEvent.getAxisValue(25, i));
        } else {
            packet.putDouble(0.0d);
        }
        packet.putLong(pointerData);
        if (signalKind == 1) {
            double horizontalScaleFactor = 48.0d;
            double verticalScaleFactor = 48.0d;
            if (context != null) {
                double horizontalScaleFactor2 = getHorizontalScrollFactor(context);
                horizontalScaleFactor = horizontalScaleFactor2;
                verticalScaleFactor = getVerticalScrollFactor(context);
            }
            double horizontalScrollPixels = (-motionEvent.getAxisValue(10, i)) * horizontalScaleFactor;
            double verticalScrollPixels = (-motionEvent.getAxisValue(9, i)) * verticalScaleFactor;
            packet.putDouble(horizontalScrollPixels);
            packet.putDouble(verticalScrollPixels);
        } else {
            packet.putDouble(0.0d);
            packet.putDouble(0.0d);
        }
        if (isTrackpadPan) {
            float[] panStart2 = this.ongoingPans.get(Integer.valueOf(pointerId));
            packet.putDouble(viewToScreenCoords[0] - panStart2[0]);
            packet.putDouble(viewToScreenCoords[1] - panStart2[1]);
            d = 0.0d;
        } else {
            d = 0.0d;
            packet.putDouble(0.0d);
            packet.putDouble(0.0d);
        }
        packet.putDouble(d);
        packet.putDouble(d);
        packet.putDouble(1.0d);
        packet.putDouble(d);
        packet.putLong(0L);
        if (isTrackpadPan && panZoomType == 9) {
            this.ongoingPans.remove(Integer.valueOf(pointerId));
        }
    }

    private float getHorizontalScrollFactor(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ViewConfiguration.get(context).getScaledHorizontalScrollFactor();
        }
        return getVerticalScrollFactorPre26(context);
    }

    private float getVerticalScrollFactor(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return getVerticalScrollFactorAbove26(context);
        }
        return getVerticalScrollFactorPre26(context);
    }

    private float getVerticalScrollFactorAbove26(Context context) {
        return ViewConfiguration.get(context).getScaledVerticalScrollFactor();
    }

    private int getVerticalScrollFactorPre26(Context context) {
        if (this.cachedVerticalScrollFactor == 0) {
            TypedValue outValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(16842829, outValue, true)) {
                return 48;
            }
            this.cachedVerticalScrollFactor = (int) outValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.cachedVerticalScrollFactor;
    }

    private int getPointerChangeForAction(int maskedAction) {
        if (maskedAction == 0) {
            return 4;
        }
        if (maskedAction == 1) {
            return 6;
        }
        if (maskedAction == 5) {
            return 4;
        }
        if (maskedAction == 6) {
            return 6;
        }
        if (maskedAction == 2) {
            return 5;
        }
        if (maskedAction == 7) {
            return 3;
        }
        if (maskedAction == 3) {
            return 0;
        }
        return maskedAction == 8 ? 3 : -1;
    }

    private int getPointerChangeForPanZoom(int pointerChange) {
        if (pointerChange == 4) {
            return 7;
        }
        if (pointerChange == 5) {
            return 8;
        }
        if (pointerChange == 6 || pointerChange == 0) {
            return 9;
        }
        return -1;
    }

    private int getPointerDeviceTypeForToolType(int toolType) {
        switch (toolType) {
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 1;
            case 4:
                return 3;
            default:
                return 5;
        }
    }
}
