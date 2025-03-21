package com.google.protobuf;
/* loaded from: classes.dex */
public final class c2 {

    /* renamed from: a  reason: collision with root package name */
    static final int f1871a = c(1, 3);

    /* renamed from: b  reason: collision with root package name */
    static final int f1872b = c(1, 4);

    /* renamed from: c  reason: collision with root package name */
    static final int f1873c = c(2, 0);

    /* renamed from: d  reason: collision with root package name */
    static final int f1874d = c(3, 2);

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum e uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: c  reason: collision with root package name */
        public static final b f1875c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f1876d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f1877e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f1878f;

        /* renamed from: k  reason: collision with root package name */
        public static final b f1879k;

        /* renamed from: l  reason: collision with root package name */
        public static final b f1880l;

        /* renamed from: m  reason: collision with root package name */
        public static final b f1881m;

        /* renamed from: n  reason: collision with root package name */
        public static final b f1882n;

        /* renamed from: o  reason: collision with root package name */
        public static final b f1883o;

        /* renamed from: p  reason: collision with root package name */
        public static final b f1884p;

        /* renamed from: q  reason: collision with root package name */
        public static final b f1885q;

        /* renamed from: r  reason: collision with root package name */
        public static final b f1886r;

        /* renamed from: s  reason: collision with root package name */
        public static final b f1887s;

        /* renamed from: t  reason: collision with root package name */
        public static final b f1888t;

        /* renamed from: u  reason: collision with root package name */
        public static final b f1889u;

        /* renamed from: v  reason: collision with root package name */
        public static final b f1890v;

        /* renamed from: w  reason: collision with root package name */
        public static final b f1891w;

        /* renamed from: x  reason: collision with root package name */
        public static final b f1892x;

        /* renamed from: y  reason: collision with root package name */
        private static final /* synthetic */ b[] f1893y;

        /* renamed from: a  reason: collision with root package name */
        private final c f1894a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1895b;

        /* loaded from: classes.dex */
        enum a extends b {
            a(String str, int i5, c cVar, int i6) {
                super(str, i5, cVar, i6);
            }
        }

        /* renamed from: com.google.protobuf.c2$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        enum C0044b extends b {
            C0044b(String str, int i5, c cVar, int i6) {
                super(str, i5, cVar, i6);
            }
        }

        /* loaded from: classes.dex */
        enum c extends b {
            c(String str, int i5, c cVar, int i6) {
                super(str, i5, cVar, i6);
            }
        }

        /* loaded from: classes.dex */
        enum d extends b {
            d(String str, int i5, c cVar, int i6) {
                super(str, i5, cVar, i6);
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            f1875c = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            f1876d = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            f1877e = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f1878f = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            f1879k = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            f1880l = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            f1881m = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            f1882n = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            f1883o = aVar;
            c cVar3 = c.MESSAGE;
            C0044b c0044b = new C0044b("GROUP", 9, cVar3, 3);
            f1884p = c0044b;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            f1885q = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            f1886r = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            f1887s = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            f1888t = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            f1889u = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            f1890v = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            f1891w = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            f1892x = bVar14;
            f1893y = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c0044b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        private b(String str, int i5, c cVar, int i6) {
            this.f1894a = cVar;
            this.f1895b = i6;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f1893y.clone();
        }

        public c a() {
            return this.f1894a;
        }

        public int c() {
            return this.f1895b;
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(i.f1961b),
        ENUM(null),
        MESSAGE(null);
        

        /* renamed from: a  reason: collision with root package name */
        private final Object f1906a;

        c(Object obj) {
            this.f1906a = obj;
        }
    }

    public static int a(int i5) {
        return i5 >>> 3;
    }

    public static int b(int i5) {
        return i5 & 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i5, int i6) {
        return (i5 << 3) | i6;
    }
}
