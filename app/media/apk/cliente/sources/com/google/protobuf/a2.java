package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a2 {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f1840a = H();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f1841b = com.google.protobuf.d.b();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f1842c = q(Long.TYPE);

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f1843d = q(Integer.TYPE);

    /* renamed from: e  reason: collision with root package name */
    private static final e f1844e = F();

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f1845f = X();

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f1846g = W();

    /* renamed from: h  reason: collision with root package name */
    static final long f1847h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f1848i;

    /* renamed from: j  reason: collision with root package name */
    private static final long f1849j;

    /* renamed from: k  reason: collision with root package name */
    private static final long f1850k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f1851l;

    /* renamed from: m  reason: collision with root package name */
    private static final long f1852m;

    /* renamed from: n  reason: collision with root package name */
    private static final long f1853n;

    /* renamed from: o  reason: collision with root package name */
    private static final long f1854o;

    /* renamed from: p  reason: collision with root package name */
    private static final long f1855p;

    /* renamed from: q  reason: collision with root package name */
    private static final long f1856q;

    /* renamed from: r  reason: collision with root package name */
    private static final long f1857r;

    /* renamed from: s  reason: collision with root package name */
    private static final long f1858s;

    /* renamed from: t  reason: collision with root package name */
    private static final long f1859t;

    /* renamed from: u  reason: collision with root package name */
    private static final long f1860u;

    /* renamed from: v  reason: collision with root package name */
    private static final int f1861v;

    /* renamed from: w  reason: collision with root package name */
    static final boolean f1862w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a */
        public Unsafe run() {
            Field[] declaredFields;
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends e {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.a2.e
        public void c(long j5, byte[] bArr, long j6, long j7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.a2.e
        public boolean d(Object obj, long j5) {
            return a2.f1862w ? a2.u(obj, j5) : a2.v(obj, j5);
        }

        @Override // com.google.protobuf.a2.e
        public byte e(long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.a2.e
        public byte f(Object obj, long j5) {
            return a2.f1862w ? a2.y(obj, j5) : a2.z(obj, j5);
        }

        @Override // com.google.protobuf.a2.e
        public double g(Object obj, long j5) {
            return Double.longBitsToDouble(k(obj, j5));
        }

        @Override // com.google.protobuf.a2.e
        public float h(Object obj, long j5) {
            return Float.intBitsToFloat(i(obj, j5));
        }

        @Override // com.google.protobuf.a2.e
        public long j(long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.a2.e
        public void n(Object obj, long j5, boolean z4) {
            if (a2.f1862w) {
                a2.M(obj, j5, z4);
            } else {
                a2.N(obj, j5, z4);
            }
        }

        @Override // com.google.protobuf.a2.e
        public void o(Object obj, long j5, byte b5) {
            if (a2.f1862w) {
                a2.P(obj, j5, b5);
            } else {
                a2.Q(obj, j5, b5);
            }
        }

        @Override // com.google.protobuf.a2.e
        public void p(Object obj, long j5, double d5) {
            s(obj, j5, Double.doubleToLongBits(d5));
        }

        @Override // com.google.protobuf.a2.e
        public void q(Object obj, long j5, float f5) {
            r(obj, j5, Float.floatToIntBits(f5));
        }

        @Override // com.google.protobuf.a2.e
        public boolean v() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.a2.e
        public void c(long j5, byte[] bArr, long j6, long j7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.a2.e
        public boolean d(Object obj, long j5) {
            return a2.f1862w ? a2.u(obj, j5) : a2.v(obj, j5);
        }

        @Override // com.google.protobuf.a2.e
        public byte e(long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.a2.e
        public byte f(Object obj, long j5) {
            return a2.f1862w ? a2.y(obj, j5) : a2.z(obj, j5);
        }

        @Override // com.google.protobuf.a2.e
        public double g(Object obj, long j5) {
            return Double.longBitsToDouble(k(obj, j5));
        }

        @Override // com.google.protobuf.a2.e
        public float h(Object obj, long j5) {
            return Float.intBitsToFloat(i(obj, j5));
        }

        @Override // com.google.protobuf.a2.e
        public long j(long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.a2.e
        public void n(Object obj, long j5, boolean z4) {
            if (a2.f1862w) {
                a2.M(obj, j5, z4);
            } else {
                a2.N(obj, j5, z4);
            }
        }

        @Override // com.google.protobuf.a2.e
        public void o(Object obj, long j5, byte b5) {
            if (a2.f1862w) {
                a2.P(obj, j5, b5);
            } else {
                a2.Q(obj, j5, b5);
            }
        }

        @Override // com.google.protobuf.a2.e
        public void p(Object obj, long j5, double d5) {
            s(obj, j5, Double.doubleToLongBits(d5));
        }

        @Override // com.google.protobuf.a2.e
        public void q(Object obj, long j5, float f5) {
            r(obj, j5, Float.floatToIntBits(f5));
        }

        @Override // com.google.protobuf.a2.e
        public boolean v() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d extends e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.a2.e
        public void c(long j5, byte[] bArr, long j6, long j7) {
            this.f1863a.copyMemory((Object) null, j5, bArr, a2.f1847h + j6, j7);
        }

        @Override // com.google.protobuf.a2.e
        public boolean d(Object obj, long j5) {
            return this.f1863a.getBoolean(obj, j5);
        }

        @Override // com.google.protobuf.a2.e
        public byte e(long j5) {
            return this.f1863a.getByte(j5);
        }

        @Override // com.google.protobuf.a2.e
        public byte f(Object obj, long j5) {
            return this.f1863a.getByte(obj, j5);
        }

        @Override // com.google.protobuf.a2.e
        public double g(Object obj, long j5) {
            return this.f1863a.getDouble(obj, j5);
        }

        @Override // com.google.protobuf.a2.e
        public float h(Object obj, long j5) {
            return this.f1863a.getFloat(obj, j5);
        }

        @Override // com.google.protobuf.a2.e
        public long j(long j5) {
            return this.f1863a.getLong(j5);
        }

        @Override // com.google.protobuf.a2.e
        public void n(Object obj, long j5, boolean z4) {
            this.f1863a.putBoolean(obj, j5, z4);
        }

        @Override // com.google.protobuf.a2.e
        public void o(Object obj, long j5, byte b5) {
            this.f1863a.putByte(obj, j5, b5);
        }

        @Override // com.google.protobuf.a2.e
        public void p(Object obj, long j5, double d5) {
            this.f1863a.putDouble(obj, j5, d5);
        }

        @Override // com.google.protobuf.a2.e
        public void q(Object obj, long j5, float f5) {
            this.f1863a.putFloat(obj, j5, f5);
        }

        @Override // com.google.protobuf.a2.e
        public boolean u() {
            if (super.u()) {
                try {
                    Class<?> cls = this.f1863a.getClass();
                    Class<?> cls2 = Long.TYPE;
                    cls.getMethod("getByte", Object.class, cls2);
                    cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                    cls.getMethod("getBoolean", Object.class, cls2);
                    cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                    cls.getMethod("getFloat", Object.class, cls2);
                    cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                    cls.getMethod("getDouble", Object.class, cls2);
                    cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                    return true;
                } catch (Throwable th) {
                    a2.K(th);
                    return false;
                }
            }
            return false;
        }

        @Override // com.google.protobuf.a2.e
        public boolean v() {
            if (super.v()) {
                try {
                    Class<?> cls = this.f1863a.getClass();
                    Class<?> cls2 = Long.TYPE;
                    cls.getMethod("getByte", cls2);
                    cls.getMethod("putByte", cls2, Byte.TYPE);
                    cls.getMethod("getInt", cls2);
                    cls.getMethod("putInt", cls2, Integer.TYPE);
                    cls.getMethod("getLong", cls2);
                    cls.getMethod("putLong", cls2, cls2);
                    cls.getMethod("copyMemory", cls2, cls2, cls2);
                    cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                    return true;
                } catch (Throwable th) {
                    a2.K(th);
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        Unsafe f1863a;

        e(Unsafe unsafe) {
            this.f1863a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f1863a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f1863a.arrayIndexScale(cls);
        }

        public abstract void c(long j5, byte[] bArr, long j6, long j7);

        public abstract boolean d(Object obj, long j5);

        public abstract byte e(long j5);

        public abstract byte f(Object obj, long j5);

        public abstract double g(Object obj, long j5);

        public abstract float h(Object obj, long j5);

        public final int i(Object obj, long j5) {
            return this.f1863a.getInt(obj, j5);
        }

        public abstract long j(long j5);

        public final long k(Object obj, long j5) {
            return this.f1863a.getLong(obj, j5);
        }

        public final Object l(Object obj, long j5) {
            return this.f1863a.getObject(obj, j5);
        }

        public final long m(Field field) {
            return this.f1863a.objectFieldOffset(field);
        }

        public abstract void n(Object obj, long j5, boolean z4);

        public abstract void o(Object obj, long j5, byte b5);

        public abstract void p(Object obj, long j5, double d5);

        public abstract void q(Object obj, long j5, float f5);

        public final void r(Object obj, long j5, int i5) {
            this.f1863a.putInt(obj, j5, i5);
        }

        public final void s(Object obj, long j5, long j6) {
            this.f1863a.putLong(obj, j5, j6);
        }

        public final void t(Object obj, long j5, Object obj2) {
            this.f1863a.putObject(obj, j5, obj2);
        }

        public boolean u() {
            Unsafe unsafe = this.f1863a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                a2.K(th);
                return false;
            }
        }

        public boolean v() {
            Unsafe unsafe = this.f1863a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return a2.b() != null;
            } catch (Throwable th) {
                a2.K(th);
                return false;
            }
        }
    }

    static {
        long m5 = m(byte[].class);
        f1847h = m5;
        f1848i = m(boolean[].class);
        f1849j = n(boolean[].class);
        f1850k = m(int[].class);
        f1851l = n(int[].class);
        f1852m = m(long[].class);
        f1853n = n(long[].class);
        f1854o = m(float[].class);
        f1855p = n(float[].class);
        f1856q = m(double[].class);
        f1857r = n(double[].class);
        f1858s = m(Object[].class);
        f1859t = n(Object[].class);
        f1860u = s(o());
        f1861v = (int) (7 & m5);
        f1862w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private a2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double A(Object obj, long j5) {
        return f1844e.g(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float B(Object obj, long j5) {
        return f1844e.h(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C(Object obj, long j5) {
        return f1844e.i(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long D(long j5) {
        return f1844e.j(j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long E(Object obj, long j5) {
        return f1844e.k(obj, j5);
    }

    private static e F() {
        Unsafe unsafe = f1840a;
        if (unsafe == null) {
            return null;
        }
        if (com.google.protobuf.d.c()) {
            if (f1842c) {
                return new c(unsafe);
            }
            if (f1843d) {
                return new b(unsafe);
            }
            return null;
        }
        return new d(unsafe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object G(Object obj, long j5) {
        return f1844e.l(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe H() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean I() {
        return f1846g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean J() {
        return f1845f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(Throwable th) {
        Logger logger = Logger.getLogger(a2.class.getName());
        Level level = Level.WARNING;
        logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void L(Object obj, long j5, boolean z4) {
        f1844e.n(obj, j5, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void M(Object obj, long j5, boolean z4) {
        P(obj, j5, z4 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(Object obj, long j5, boolean z4) {
        Q(obj, j5, z4 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void O(byte[] bArr, long j5, byte b5) {
        f1844e.o(bArr, f1847h + j5, b5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(Object obj, long j5, byte b5) {
        long j6 = (-4) & j5;
        int C = C(obj, j6);
        int i5 = ((~((int) j5)) & 3) << 3;
        T(obj, j6, ((255 & b5) << i5) | (C & (~(255 << i5))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(Object obj, long j5, byte b5) {
        long j6 = (-4) & j5;
        int i5 = (((int) j5) & 3) << 3;
        T(obj, j6, ((255 & b5) << i5) | (C(obj, j6) & (~(255 << i5))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void R(Object obj, long j5, double d5) {
        f1844e.p(obj, j5, d5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void S(Object obj, long j5, float f5) {
        f1844e.q(obj, j5, f5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void T(Object obj, long j5, int i5) {
        f1844e.r(obj, j5, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void U(Object obj, long j5, long j6) {
        f1844e.s(obj, j5, j6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void V(Object obj, long j5, Object obj2) {
        f1844e.t(obj, j5, obj2);
    }

    private static boolean W() {
        e eVar = f1844e;
        if (eVar == null) {
            return false;
        }
        return eVar.u();
    }

    private static boolean X() {
        e eVar = f1844e;
        if (eVar == null) {
            return false;
        }
        return eVar.v();
    }

    static /* synthetic */ Field b() {
        return o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long k(ByteBuffer byteBuffer) {
        return f1844e.k(byteBuffer, f1860u);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T l(Class<T> cls) {
        try {
            return (T) f1840a.allocateInstance(cls);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    private static int m(Class<?> cls) {
        if (f1846g) {
            return f1844e.a(cls);
        }
        return -1;
    }

    private static int n(Class<?> cls) {
        if (f1846g) {
            return f1844e.b(cls);
        }
        return -1;
    }

    private static Field o() {
        Field r5;
        if (!com.google.protobuf.d.c() || (r5 = r(Buffer.class, "effectiveDirectAddress")) == null) {
            Field r6 = r(Buffer.class, "address");
            if (r6 == null || r6.getType() != Long.TYPE) {
                return null;
            }
            return r6;
        }
        return r5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void p(long j5, byte[] bArr, long j6, long j7) {
        f1844e.c(j5, bArr, j6, j7);
    }

    static boolean q(Class<?> cls) {
        if (com.google.protobuf.d.c()) {
            try {
                Class<?> cls2 = f1841b;
                Class<?> cls3 = Boolean.TYPE;
                cls2.getMethod("peekLong", cls, cls3);
                cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
                Class<?> cls4 = Integer.TYPE;
                cls2.getMethod("pokeInt", cls, cls4, cls3);
                cls2.getMethod("peekInt", cls, cls3);
                cls2.getMethod("pokeByte", cls, Byte.TYPE);
                cls2.getMethod("peekByte", cls);
                cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
                cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    private static Field r(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long s(Field field) {
        e eVar;
        if (field == null || (eVar = f1844e) == null) {
            return -1L;
        }
        return eVar.m(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t(Object obj, long j5) {
        return f1844e.d(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean u(Object obj, long j5) {
        return y(obj, j5) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean v(Object obj, long j5) {
        return z(obj, j5) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte w(long j5) {
        return f1844e.e(j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte x(byte[] bArr, long j5) {
        return f1844e.f(bArr, f1847h + j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte y(Object obj, long j5) {
        return (byte) ((C(obj, (-4) & j5) >>> ((int) (((~j5) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte z(Object obj, long j5) {
        return (byte) ((C(obj, (-4) & j5) >>> ((int) ((j5 & 3) << 3))) & 255);
    }
}
