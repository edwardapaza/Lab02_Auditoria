package z2;

import i2.a0;
import i2.d0;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class p implements h<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final p f9015a = new p();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f9016b;

    /* renamed from: c  reason: collision with root package name */
    private static final Charset f9017c;

    /* loaded from: classes.dex */
    static final class a extends ByteArrayOutputStream {
        /* JADX INFO: Access modifiers changed from: package-private */
        public byte[] c() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    static {
        f9016b = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
        f9017c = Charset.forName("UTF8");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void c(ByteBuffer byteBuffer, int i5) {
        int position = byteBuffer.position() % i5;
        if (position != 0) {
            byteBuffer.position((byteBuffer.position() + i5) - position);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final byte[] d(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[e(byteBuffer)];
        byteBuffer.get(bArr);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final int e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            int i5 = byteBuffer.get() & 255;
            return i5 < 254 ? i5 : i5 == 254 ? byteBuffer.getChar() : byteBuffer.getInt();
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void h(ByteArrayOutputStream byteArrayOutputStream, int i5) {
        int size = byteArrayOutputStream.size() % i5;
        if (size != 0) {
            for (int i6 = 0; i6 < i5 - size; i6++) {
                byteArrayOutputStream.write(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void i(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        o(byteArrayOutputStream, bArr.length);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    protected static final void j(ByteArrayOutputStream byteArrayOutputStream, int i5) {
        if (f9016b) {
            byteArrayOutputStream.write(i5);
            i5 >>>= 8;
        } else {
            byteArrayOutputStream.write(i5 >>> 8);
        }
        byteArrayOutputStream.write(i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void k(ByteArrayOutputStream byteArrayOutputStream, double d5) {
        n(byteArrayOutputStream, Double.doubleToLongBits(d5));
    }

    protected static final void l(ByteArrayOutputStream byteArrayOutputStream, float f5) {
        m(byteArrayOutputStream, Float.floatToIntBits(f5));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void m(ByteArrayOutputStream byteArrayOutputStream, int i5) {
        if (f9016b) {
            byteArrayOutputStream.write(i5);
            byteArrayOutputStream.write(i5 >>> 8);
            byteArrayOutputStream.write(i5 >>> 16);
            i5 >>>= 24;
        } else {
            byteArrayOutputStream.write(i5 >>> 24);
            byteArrayOutputStream.write(i5 >>> 16);
            byteArrayOutputStream.write(i5 >>> 8);
        }
        byteArrayOutputStream.write(i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void n(ByteArrayOutputStream byteArrayOutputStream, long j5) {
        if (f9016b) {
            byteArrayOutputStream.write((byte) j5);
            byteArrayOutputStream.write((byte) (j5 >>> 8));
            byteArrayOutputStream.write((byte) (j5 >>> 16));
            byteArrayOutputStream.write((byte) (j5 >>> 24));
            byteArrayOutputStream.write((byte) (j5 >>> 32));
            byteArrayOutputStream.write((byte) (j5 >>> 40));
            byteArrayOutputStream.write((byte) (j5 >>> 48));
            j5 >>>= 56;
        } else {
            byteArrayOutputStream.write((byte) (j5 >>> 56));
            byteArrayOutputStream.write((byte) (j5 >>> 48));
            byteArrayOutputStream.write((byte) (j5 >>> 40));
            byteArrayOutputStream.write((byte) (j5 >>> 32));
            byteArrayOutputStream.write((byte) (j5 >>> 24));
            byteArrayOutputStream.write((byte) (j5 >>> 16));
            byteArrayOutputStream.write((byte) (j5 >>> 8));
        }
        byteArrayOutputStream.write((byte) j5);
    }

    protected static final void o(ByteArrayOutputStream byteArrayOutputStream, int i5) {
        if (i5 < 254) {
            byteArrayOutputStream.write(i5);
        } else if (i5 <= 65535) {
            byteArrayOutputStream.write(254);
            j(byteArrayOutputStream, i5);
        } else {
            byteArrayOutputStream.write(255);
            m(byteArrayOutputStream, i5);
        }
    }

    @Override // z2.h
    public ByteBuffer a(Object obj) {
        if (obj == null) {
            return null;
        }
        a aVar = new a();
        p(aVar, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.c(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // z2.h
    public Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        Object f5 = f(byteBuffer);
        if (byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        return f5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object f(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            return g(byteBuffer.get(), byteBuffer);
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.Map, java.util.HashMap] */
    public Object g(byte b5, ByteBuffer byteBuffer) {
        int e5;
        int e6;
        long[] jArr;
        ?? arrayList;
        int[] iArr;
        int i5 = 0;
        switch (b5) {
            case 0:
                return null;
            case 1:
                return Boolean.TRUE;
            case 2:
                return Boolean.FALSE;
            case 3:
                return Integer.valueOf(byteBuffer.getInt());
            case 4:
                return Long.valueOf(byteBuffer.getLong());
            case 5:
                return new BigInteger(new String(d(byteBuffer), f9017c), 16);
            case 6:
                c(byteBuffer, 8);
                return Double.valueOf(byteBuffer.getDouble());
            case 7:
                return new String(d(byteBuffer), f9017c);
            case 8:
                return d(byteBuffer);
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                e5 = e(byteBuffer);
                int[] iArr2 = new int[e5];
                c(byteBuffer, 4);
                byteBuffer.asIntBuffer().get(iArr2);
                iArr = iArr2;
                byteBuffer.position(byteBuffer.position() + (e5 * 4));
                return iArr;
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                e6 = e(byteBuffer);
                long[] jArr2 = new long[e6];
                c(byteBuffer, 8);
                byteBuffer.asLongBuffer().get(jArr2);
                jArr = jArr2;
                byteBuffer.position(byteBuffer.position() + (e6 * 8));
                return jArr;
            case 11:
                e6 = e(byteBuffer);
                double[] dArr = new double[e6];
                c(byteBuffer, 8);
                byteBuffer.asDoubleBuffer().get(dArr);
                jArr = dArr;
                byteBuffer.position(byteBuffer.position() + (e6 * 8));
                return jArr;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                int e7 = e(byteBuffer);
                arrayList = new ArrayList(e7);
                while (i5 < e7) {
                    arrayList.add(f(byteBuffer));
                    i5++;
                }
                return arrayList;
            case 13:
                int e8 = e(byteBuffer);
                arrayList = new HashMap();
                while (i5 < e8) {
                    arrayList.put(f(byteBuffer), f(byteBuffer));
                    i5++;
                }
                return arrayList;
            case 14:
                e5 = e(byteBuffer);
                float[] fArr = new float[e5];
                c(byteBuffer, 4);
                byteBuffer.asFloatBuffer().get(fArr);
                iArr = fArr;
                byteBuffer.position(byteBuffer.position() + (e5 * 4));
                return iArr;
            default:
                throw new IllegalArgumentException("Message corrupted");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        int i5 = 0;
        if (obj == null || obj.equals(null)) {
            byteArrayOutputStream.write(0);
        } else if (obj instanceof Boolean) {
            byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 2);
        } else if (obj instanceof Number) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                byteArrayOutputStream.write(3);
                m(byteArrayOutputStream, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                byteArrayOutputStream.write(4);
                n(byteArrayOutputStream, ((Long) obj).longValue());
            } else if ((obj instanceof Float) || (obj instanceof Double)) {
                byteArrayOutputStream.write(6);
                h(byteArrayOutputStream, 8);
                k(byteArrayOutputStream, ((Number) obj).doubleValue());
            } else if (!(obj instanceof BigInteger)) {
                throw new IllegalArgumentException("Unsupported Number type: " + obj.getClass());
            } else {
                byteArrayOutputStream.write(5);
                i(byteArrayOutputStream, ((BigInteger) obj).toString(16).getBytes(f9017c));
            }
        } else if (obj instanceof CharSequence) {
            byteArrayOutputStream.write(7);
            i(byteArrayOutputStream, obj.toString().getBytes(f9017c));
        } else if (obj instanceof byte[]) {
            byteArrayOutputStream.write(8);
            i(byteArrayOutputStream, (byte[]) obj);
        } else if (obj instanceof int[]) {
            byteArrayOutputStream.write(9);
            int[] iArr = (int[]) obj;
            o(byteArrayOutputStream, iArr.length);
            h(byteArrayOutputStream, 4);
            int length = iArr.length;
            while (i5 < length) {
                m(byteArrayOutputStream, iArr[i5]);
                i5++;
            }
        } else if (obj instanceof long[]) {
            byteArrayOutputStream.write(10);
            long[] jArr = (long[]) obj;
            o(byteArrayOutputStream, jArr.length);
            h(byteArrayOutputStream, 8);
            int length2 = jArr.length;
            while (i5 < length2) {
                n(byteArrayOutputStream, jArr[i5]);
                i5++;
            }
        } else if (obj instanceof double[]) {
            byteArrayOutputStream.write(11);
            double[] dArr = (double[]) obj;
            o(byteArrayOutputStream, dArr.length);
            h(byteArrayOutputStream, 8);
            int length3 = dArr.length;
            while (i5 < length3) {
                k(byteArrayOutputStream, dArr[i5]);
                i5++;
            }
        } else if (obj instanceof List) {
            byteArrayOutputStream.write(12);
            List<Object> list = (List) obj;
            o(byteArrayOutputStream, list.size());
            for (Object obj2 : list) {
                p(byteArrayOutputStream, obj2);
            }
        } else if (obj instanceof Map) {
            byteArrayOutputStream.write(13);
            Map map = (Map) obj;
            o(byteArrayOutputStream, map.size());
            for (Map.Entry entry : map.entrySet()) {
                p(byteArrayOutputStream, entry.getKey());
                p(byteArrayOutputStream, entry.getValue());
            }
        } else if (!(obj instanceof float[])) {
            throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass() + "'");
        } else {
            byteArrayOutputStream.write(14);
            float[] fArr = (float[]) obj;
            o(byteArrayOutputStream, fArr.length);
            h(byteArrayOutputStream, 4);
            int length4 = fArr.length;
            while (i5 < length4) {
                l(byteArrayOutputStream, fArr[i5]);
                i5++;
            }
        }
    }
}
