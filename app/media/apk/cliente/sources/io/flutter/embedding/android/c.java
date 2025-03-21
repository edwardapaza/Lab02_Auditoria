package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    private static final Matrix f3641f = new Matrix();

    /* renamed from: a  reason: collision with root package name */
    private final FlutterRenderer f3642a;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3644c;

    /* renamed from: e  reason: collision with root package name */
    private int f3646e;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Integer, float[]> f3645d = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final d0 f3643b = d0.a();

    public c(FlutterRenderer flutterRenderer, boolean z4) {
        this.f3642a = flutterRenderer;
        this.f3644c = z4;
    }

    private void a(MotionEvent motionEvent, int i5, int i6, int i7, Matrix matrix, ByteBuffer byteBuffer) {
        b(motionEvent, i5, i6, i7, matrix, byteBuffer, null);
    }

    private void b(MotionEvent motionEvent, int i5, int i6, int i7, Matrix matrix, ByteBuffer byteBuffer, Context context) {
        long j5;
        long j6;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        InputDevice.MotionRange motionRange;
        int i8 = -1;
        if (i6 == -1) {
            return;
        }
        int pointerId = motionEvent.getPointerId(i5);
        int f5 = f(motionEvent.getToolType(i5));
        float[] fArr = {motionEvent.getX(i5), motionEvent.getY(i5)};
        matrix.mapPoints(fArr);
        if (f5 == 1) {
            j5 = motionEvent.getButtonState() & 31;
            if (j5 == 0 && motionEvent.getSource() == 8194 && i6 == 4) {
                this.f3645d.put(Integer.valueOf(pointerId), fArr);
            }
        } else {
            j5 = f5 == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
        }
        boolean containsKey = this.f3645d.containsKey(Integer.valueOf(pointerId));
        if (containsKey) {
            int e5 = e(i6);
            if (e5 == -1) {
                return;
            }
            i8 = e5;
        }
        long d11 = this.f3644c ? this.f3643b.c(motionEvent).d() : 0L;
        int i9 = motionEvent.getActionMasked() == 8 ? 1 : 0;
        int i10 = i8;
        byteBuffer.putLong(d11);
        byteBuffer.putLong(motionEvent.getEventTime() * 1000);
        if (containsKey) {
            byteBuffer.putLong(i10);
            j6 = 4;
        } else {
            byteBuffer.putLong(i6);
            j6 = f5;
        }
        byteBuffer.putLong(j6);
        byteBuffer.putLong(i9);
        byteBuffer.putLong(pointerId);
        byteBuffer.putLong(0L);
        if (containsKey) {
            float[] fArr2 = this.f3645d.get(Integer.valueOf(pointerId));
            byteBuffer.putDouble(fArr2[0]);
            d5 = fArr2[1];
        } else {
            byteBuffer.putDouble(fArr[0]);
            d5 = fArr[1];
        }
        byteBuffer.putDouble(d5);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putLong(j5);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getPressure(i5));
        if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
            d6 = 1.0d;
            d7 = 0.0d;
        } else {
            d7 = motionRange.getMin();
            d6 = motionRange.getMax();
        }
        byteBuffer.putDouble(d7);
        byteBuffer.putDouble(d6);
        if (f5 == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(24, i5));
            d8 = 0.0d;
        } else {
            d8 = 0.0d;
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d8);
        byteBuffer.putDouble(motionEvent.getSize(i5));
        byteBuffer.putDouble(motionEvent.getToolMajor(i5));
        byteBuffer.putDouble(motionEvent.getToolMinor(i5));
        byteBuffer.putDouble(d8);
        byteBuffer.putDouble(d8);
        byteBuffer.putDouble(motionEvent.getAxisValue(8, i5));
        if (f5 == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(25, i5));
        } else {
            byteBuffer.putDouble(d8);
        }
        byteBuffer.putLong(i7);
        if (i9 == 1) {
            double d12 = 48.0d;
            if (context != null) {
                d12 = c(context);
                d10 = g(context);
            } else {
                d10 = 48.0d;
            }
            byteBuffer.putDouble(d12 * (-motionEvent.getAxisValue(10, i5)));
            byteBuffer.putDouble(d10 * (-motionEvent.getAxisValue(9, i5)));
        } else {
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        if (containsKey) {
            float[] fArr3 = this.f3645d.get(Integer.valueOf(pointerId));
            byteBuffer.putDouble(fArr[0] - fArr3[0]);
            byteBuffer.putDouble(fArr[1] - fArr3[1]);
            d9 = 0.0d;
        } else {
            d9 = 0.0d;
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d9);
        byteBuffer.putDouble(d9);
        byteBuffer.putDouble(1.0d);
        byteBuffer.putDouble(d9);
        byteBuffer.putLong(0L);
        if (containsKey && i10 == 9) {
            this.f3645d.remove(Integer.valueOf(pointerId));
        }
    }

    private float c(Context context) {
        float scaledHorizontalScrollFactor;
        if (Build.VERSION.SDK_INT >= 26) {
            scaledHorizontalScrollFactor = ViewConfiguration.get(context).getScaledHorizontalScrollFactor();
            return scaledHorizontalScrollFactor;
        }
        return i(context);
    }

    private int d(int i5) {
        if (i5 == 0) {
            return 4;
        }
        if (i5 == 1) {
            return 6;
        }
        if (i5 == 5) {
            return 4;
        }
        if (i5 == 6) {
            return 6;
        }
        if (i5 == 2) {
            return 5;
        }
        if (i5 == 7) {
            return 3;
        }
        if (i5 == 3) {
            return 0;
        }
        return i5 == 8 ? 3 : -1;
    }

    private int e(int i5) {
        if (i5 == 4) {
            return 7;
        }
        if (i5 == 5) {
            return 8;
        }
        return (i5 == 6 || i5 == 0) ? 9 : -1;
    }

    private int f(int i5) {
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    return i5 != 4 ? 5 : 3;
                }
                return 1;
            }
            return 2;
        }
        return 0;
    }

    private float g(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? h(context) : i(context);
    }

    private float h(Context context) {
        float scaledVerticalScrollFactor;
        scaledVerticalScrollFactor = ViewConfiguration.get(context).getScaledVerticalScrollFactor();
        return scaledVerticalScrollFactor;
    }

    private int i(Context context) {
        if (this.f3646e == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 48;
            }
            this.f3646e = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f3646e;
    }

    public boolean j(MotionEvent motionEvent, Context context) {
        boolean isFromSource = motionEvent.isFromSource(2);
        boolean z4 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (isFromSource && z4) {
            int d5 = d(motionEvent.getActionMasked());
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 36 * 8);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            b(motionEvent, motionEvent.getActionIndex(), d5, 0, f3641f, allocateDirect, context);
            if (allocateDirect.position() % 288 == 0) {
                this.f3642a.m(allocateDirect, allocateDirect.position());
                return true;
            }
            throw new AssertionError("Packet position is not on field boundary.");
        }
        return false;
    }

    public boolean k(MotionEvent motionEvent) {
        return l(motionEvent, f3641f);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean l(android.view.MotionEvent r13, android.graphics.Matrix r14) {
        /*
            r12 = this;
            int r0 = r13.getPointerCount()
            int r1 = r0 * 36
            int r1 = r1 * 8
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocateDirect(r1)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            r1.order(r2)
            int r2 = r13.getActionMasked()
            int r3 = r13.getActionMasked()
            int r9 = r12.d(r3)
            r3 = 0
            r10 = 1
            if (r2 == 0) goto L27
            r4 = 5
            if (r2 != r4) goto L25
            goto L27
        L25:
            r4 = 0
            goto L28
        L27:
            r4 = 1
        L28:
            if (r4 != 0) goto L31
            if (r2 == r10) goto L2f
            r5 = 6
            if (r2 != r5) goto L31
        L2f:
            r2 = 1
            goto L32
        L31:
            r2 = 0
        L32:
            if (r4 == 0) goto L42
        L34:
            int r4 = r13.getActionIndex()
            r6 = 0
            r2 = r12
            r3 = r13
            r5 = r9
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
            goto L6f
        L42:
            r11 = 0
            if (r2 == 0) goto L60
        L45:
            if (r11 >= r0) goto L34
            int r2 = r13.getActionIndex()
            if (r11 == r2) goto L5d
            int r2 = r13.getToolType(r11)
            if (r2 != r10) goto L5d
            r5 = 5
            r6 = 1
            r2 = r12
            r3 = r13
            r4 = r11
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
        L5d:
            int r11 = r11 + 1
            goto L45
        L60:
            if (r11 >= r0) goto L6f
            r6 = 0
            r2 = r12
            r3 = r13
            r4 = r11
            r5 = r9
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
            int r11 = r11 + 1
            goto L60
        L6f:
            int r13 = r1.position()
            int r13 = r13 % 288
            if (r13 != 0) goto L81
            io.flutter.embedding.engine.renderer.FlutterRenderer r13 = r12.f3642a
            int r14 = r1.position()
            r13.m(r1, r14)
            return r10
        L81:
            java.lang.AssertionError r13 = new java.lang.AssertionError
            java.lang.String r14 = "Packet position is not on field boundary"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.c.l(android.view.MotionEvent, android.graphics.Matrix):boolean");
    }
}
