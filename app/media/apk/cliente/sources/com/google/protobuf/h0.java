package com.google.protobuf;
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
public final class h0 {

    /* renamed from: d  reason: collision with root package name */
    public static final h0 f1947d;

    /* renamed from: e  reason: collision with root package name */
    public static final h0 f1948e;

    /* renamed from: f  reason: collision with root package name */
    public static final h0 f1949f;

    /* renamed from: k  reason: collision with root package name */
    public static final h0 f1950k;

    /* renamed from: l  reason: collision with root package name */
    public static final h0 f1951l;

    /* renamed from: m  reason: collision with root package name */
    public static final h0 f1952m;

    /* renamed from: n  reason: collision with root package name */
    public static final h0 f1953n;

    /* renamed from: o  reason: collision with root package name */
    public static final h0 f1954o;

    /* renamed from: p  reason: collision with root package name */
    public static final h0 f1955p;

    /* renamed from: q  reason: collision with root package name */
    public static final h0 f1956q;

    /* renamed from: r  reason: collision with root package name */
    private static final /* synthetic */ h0[] f1957r;

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f1958a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f1959b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f1960c;

    static {
        h0 h0Var = new h0("VOID", 0, Void.class, Void.class, null);
        f1947d = h0Var;
        Class cls = Integer.TYPE;
        h0 h0Var2 = new h0("INT", 1, cls, Integer.class, 0);
        f1948e = h0Var2;
        h0 h0Var3 = new h0("LONG", 2, Long.TYPE, Long.class, 0L);
        f1949f = h0Var3;
        h0 h0Var4 = new h0("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f1950k = h0Var4;
        h0 h0Var5 = new h0("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f1951l = h0Var5;
        h0 h0Var6 = new h0("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f1952m = h0Var6;
        h0 h0Var7 = new h0("STRING", 6, String.class, String.class, "");
        f1953n = h0Var7;
        h0 h0Var8 = new h0("BYTE_STRING", 7, i.class, i.class, i.f1961b);
        f1954o = h0Var8;
        h0 h0Var9 = new h0("ENUM", 8, cls, Integer.class, null);
        f1955p = h0Var9;
        h0 h0Var10 = new h0("MESSAGE", 9, Object.class, Object.class, null);
        f1956q = h0Var10;
        f1957r = new h0[]{h0Var, h0Var2, h0Var3, h0Var4, h0Var5, h0Var6, h0Var7, h0Var8, h0Var9, h0Var10};
    }

    private h0(String str, int i5, Class cls, Class cls2, Object obj) {
        this.f1958a = cls;
        this.f1959b = cls2;
        this.f1960c = obj;
    }

    public static h0 valueOf(String str) {
        return (h0) Enum.valueOf(h0.class, str);
    }

    public static h0[] values() {
        return (h0[]) f1957r.clone();
    }

    public Class<?> a() {
        return this.f1959b;
    }
}
