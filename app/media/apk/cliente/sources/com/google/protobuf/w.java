package com.google.protobuf;

import java.lang.reflect.Type;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum f uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class w {
    public static final w A;
    public static final w B;
    public static final w C;
    public static final w D;
    public static final w E;
    public static final w F;
    public static final w G;
    public static final w H;
    public static final w I;
    public static final w J;
    public static final w K;
    public static final w L;
    public static final w M;
    public static final w N;
    public static final w O;
    public static final w P;
    public static final w Q;
    public static final w R;
    public static final w S;
    public static final w T;
    public static final w U;
    public static final w V;
    public static final w W;
    public static final w X;
    public static final w Y;
    public static final w Z;

    /* renamed from: a0  reason: collision with root package name */
    public static final w f2150a0;

    /* renamed from: b0  reason: collision with root package name */
    public static final w f2151b0;

    /* renamed from: c0  reason: collision with root package name */
    public static final w f2152c0;

    /* renamed from: d0  reason: collision with root package name */
    public static final w f2153d0;

    /* renamed from: e0  reason: collision with root package name */
    public static final w f2154e0;

    /* renamed from: f  reason: collision with root package name */
    public static final w f2155f;

    /* renamed from: f0  reason: collision with root package name */
    public static final w f2156f0;

    /* renamed from: g0  reason: collision with root package name */
    public static final w f2157g0;

    /* renamed from: h0  reason: collision with root package name */
    public static final w f2158h0;

    /* renamed from: i0  reason: collision with root package name */
    private static final w[] f2159i0;

    /* renamed from: j0  reason: collision with root package name */
    private static final Type[] f2160j0;

    /* renamed from: k  reason: collision with root package name */
    public static final w f2161k;

    /* renamed from: k0  reason: collision with root package name */
    private static final /* synthetic */ w[] f2162k0;

    /* renamed from: l  reason: collision with root package name */
    public static final w f2163l;

    /* renamed from: m  reason: collision with root package name */
    public static final w f2164m;

    /* renamed from: n  reason: collision with root package name */
    public static final w f2165n;

    /* renamed from: o  reason: collision with root package name */
    public static final w f2166o;

    /* renamed from: p  reason: collision with root package name */
    public static final w f2167p;

    /* renamed from: q  reason: collision with root package name */
    public static final w f2168q;

    /* renamed from: r  reason: collision with root package name */
    public static final w f2169r;

    /* renamed from: s  reason: collision with root package name */
    public static final w f2170s;

    /* renamed from: t  reason: collision with root package name */
    public static final w f2171t;

    /* renamed from: u  reason: collision with root package name */
    public static final w f2172u;

    /* renamed from: v  reason: collision with root package name */
    public static final w f2173v;

    /* renamed from: w  reason: collision with root package name */
    public static final w f2174w;

    /* renamed from: x  reason: collision with root package name */
    public static final w f2175x;

    /* renamed from: y  reason: collision with root package name */
    public static final w f2176y;

    /* renamed from: z  reason: collision with root package name */
    public static final w f2177z;

    /* renamed from: a  reason: collision with root package name */
    private final h0 f2178a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2179b;

    /* renamed from: c  reason: collision with root package name */
    private final b f2180c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<?> f2181d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2182e;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2183a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2184b;

        static {
            int[] iArr = new int[h0.values().length];
            f2184b = iArr;
            try {
                iArr[h0.f1954o.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2184b[h0.f1956q.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2184b[h0.f1953n.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[b.values().length];
            f2183a = iArr2;
            try {
                iArr2[b.MAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2183a[b.VECTOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2183a[b.SCALAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    enum b {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);
        

        /* renamed from: a  reason: collision with root package name */
        private final boolean f2190a;

        b(boolean z4) {
            this.f2190a = z4;
        }
    }

    static {
        b bVar = b.SCALAR;
        h0 h0Var = h0.f1951l;
        w wVar = new w("DOUBLE", 0, 0, bVar, h0Var);
        f2155f = wVar;
        h0 h0Var2 = h0.f1950k;
        w wVar2 = new w("FLOAT", 1, 1, bVar, h0Var2);
        f2161k = wVar2;
        h0 h0Var3 = h0.f1949f;
        w wVar3 = new w("INT64", 2, 2, bVar, h0Var3);
        f2163l = wVar3;
        w wVar4 = new w("UINT64", 3, 3, bVar, h0Var3);
        f2164m = wVar4;
        h0 h0Var4 = h0.f1948e;
        w wVar5 = new w("INT32", 4, 4, bVar, h0Var4);
        f2165n = wVar5;
        w wVar6 = new w("FIXED64", 5, 5, bVar, h0Var3);
        f2166o = wVar6;
        w wVar7 = new w("FIXED32", 6, 6, bVar, h0Var4);
        f2167p = wVar7;
        h0 h0Var5 = h0.f1952m;
        w wVar8 = new w("BOOL", 7, 7, bVar, h0Var5);
        f2168q = wVar8;
        h0 h0Var6 = h0.f1953n;
        w wVar9 = new w("STRING", 8, 8, bVar, h0Var6);
        f2169r = wVar9;
        h0 h0Var7 = h0.f1956q;
        w wVar10 = new w("MESSAGE", 9, 9, bVar, h0Var7);
        f2170s = wVar10;
        h0 h0Var8 = h0.f1954o;
        w wVar11 = new w("BYTES", 10, 10, bVar, h0Var8);
        f2171t = wVar11;
        w wVar12 = new w("UINT32", 11, 11, bVar, h0Var4);
        f2172u = wVar12;
        h0 h0Var9 = h0.f1955p;
        w wVar13 = new w("ENUM", 12, 12, bVar, h0Var9);
        f2173v = wVar13;
        w wVar14 = new w("SFIXED32", 13, 13, bVar, h0Var4);
        f2174w = wVar14;
        w wVar15 = new w("SFIXED64", 14, 14, bVar, h0Var3);
        f2175x = wVar15;
        w wVar16 = new w("SINT32", 15, 15, bVar, h0Var4);
        f2176y = wVar16;
        w wVar17 = new w("SINT64", 16, 16, bVar, h0Var3);
        f2177z = wVar17;
        w wVar18 = new w("GROUP", 17, 17, bVar, h0Var7);
        A = wVar18;
        b bVar2 = b.VECTOR;
        w wVar19 = new w("DOUBLE_LIST", 18, 18, bVar2, h0Var);
        B = wVar19;
        w wVar20 = new w("FLOAT_LIST", 19, 19, bVar2, h0Var2);
        C = wVar20;
        w wVar21 = new w("INT64_LIST", 20, 20, bVar2, h0Var3);
        D = wVar21;
        w wVar22 = new w("UINT64_LIST", 21, 21, bVar2, h0Var3);
        E = wVar22;
        w wVar23 = new w("INT32_LIST", 22, 22, bVar2, h0Var4);
        F = wVar23;
        w wVar24 = new w("FIXED64_LIST", 23, 23, bVar2, h0Var3);
        G = wVar24;
        w wVar25 = new w("FIXED32_LIST", 24, 24, bVar2, h0Var4);
        H = wVar25;
        w wVar26 = new w("BOOL_LIST", 25, 25, bVar2, h0Var5);
        I = wVar26;
        w wVar27 = new w("STRING_LIST", 26, 26, bVar2, h0Var6);
        J = wVar27;
        w wVar28 = new w("MESSAGE_LIST", 27, 27, bVar2, h0Var7);
        K = wVar28;
        w wVar29 = new w("BYTES_LIST", 28, 28, bVar2, h0Var8);
        L = wVar29;
        w wVar30 = new w("UINT32_LIST", 29, 29, bVar2, h0Var4);
        M = wVar30;
        w wVar31 = new w("ENUM_LIST", 30, 30, bVar2, h0Var9);
        N = wVar31;
        w wVar32 = new w("SFIXED32_LIST", 31, 31, bVar2, h0Var4);
        O = wVar32;
        w wVar33 = new w("SFIXED64_LIST", 32, 32, bVar2, h0Var3);
        P = wVar33;
        w wVar34 = new w("SINT32_LIST", 33, 33, bVar2, h0Var4);
        Q = wVar34;
        w wVar35 = new w("SINT64_LIST", 34, 34, bVar2, h0Var3);
        R = wVar35;
        b bVar3 = b.PACKED_VECTOR;
        w wVar36 = new w("DOUBLE_LIST_PACKED", 35, 35, bVar3, h0Var);
        S = wVar36;
        w wVar37 = new w("FLOAT_LIST_PACKED", 36, 36, bVar3, h0Var2);
        T = wVar37;
        w wVar38 = new w("INT64_LIST_PACKED", 37, 37, bVar3, h0Var3);
        U = wVar38;
        w wVar39 = new w("UINT64_LIST_PACKED", 38, 38, bVar3, h0Var3);
        V = wVar39;
        w wVar40 = new w("INT32_LIST_PACKED", 39, 39, bVar3, h0Var4);
        W = wVar40;
        w wVar41 = new w("FIXED64_LIST_PACKED", 40, 40, bVar3, h0Var3);
        X = wVar41;
        w wVar42 = new w("FIXED32_LIST_PACKED", 41, 41, bVar3, h0Var4);
        Y = wVar42;
        w wVar43 = new w("BOOL_LIST_PACKED", 42, 42, bVar3, h0Var5);
        Z = wVar43;
        w wVar44 = new w("UINT32_LIST_PACKED", 43, 43, bVar3, h0Var4);
        f2150a0 = wVar44;
        w wVar45 = new w("ENUM_LIST_PACKED", 44, 44, bVar3, h0Var9);
        f2151b0 = wVar45;
        w wVar46 = new w("SFIXED32_LIST_PACKED", 45, 45, bVar3, h0Var4);
        f2152c0 = wVar46;
        w wVar47 = new w("SFIXED64_LIST_PACKED", 46, 46, bVar3, h0Var3);
        f2153d0 = wVar47;
        w wVar48 = new w("SINT32_LIST_PACKED", 47, 47, bVar3, h0Var4);
        f2154e0 = wVar48;
        w wVar49 = new w("SINT64_LIST_PACKED", 48, 48, bVar3, h0Var3);
        f2156f0 = wVar49;
        w wVar50 = new w("GROUP_LIST", 49, 49, bVar2, h0Var7);
        f2157g0 = wVar50;
        w wVar51 = new w("MAP", 50, 50, b.MAP, h0.f1947d);
        f2158h0 = wVar51;
        f2162k0 = new w[]{wVar, wVar2, wVar3, wVar4, wVar5, wVar6, wVar7, wVar8, wVar9, wVar10, wVar11, wVar12, wVar13, wVar14, wVar15, wVar16, wVar17, wVar18, wVar19, wVar20, wVar21, wVar22, wVar23, wVar24, wVar25, wVar26, wVar27, wVar28, wVar29, wVar30, wVar31, wVar32, wVar33, wVar34, wVar35, wVar36, wVar37, wVar38, wVar39, wVar40, wVar41, wVar42, wVar43, wVar44, wVar45, wVar46, wVar47, wVar48, wVar49, wVar50, wVar51};
        f2160j0 = new Type[0];
        w[] values = values();
        f2159i0 = new w[values.length];
        for (w wVar52 : values) {
            f2159i0[wVar52.f2179b] = wVar52;
        }
    }

    private w(String str, int i5, int i6, b bVar, h0 h0Var) {
        int i7;
        this.f2179b = i6;
        this.f2180c = bVar;
        this.f2178a = h0Var;
        int i8 = a.f2183a[bVar.ordinal()];
        boolean z4 = true;
        this.f2181d = (i8 == 1 || i8 == 2) ? h0Var.a() : null;
        this.f2182e = (bVar != b.SCALAR || (i7 = a.f2184b[h0Var.ordinal()]) == 1 || i7 == 2 || i7 == 3) ? false : false;
    }

    public static w valueOf(String str) {
        return (w) Enum.valueOf(w.class, str);
    }

    public static w[] values() {
        return (w[]) f2162k0.clone();
    }

    public int a() {
        return this.f2179b;
    }
}
