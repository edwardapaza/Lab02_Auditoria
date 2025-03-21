package u1;

import java.util.ArrayList;
import s1.m;
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f7886a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f7887b;

    /* renamed from: c  reason: collision with root package name */
    private final m1.e<v1.l> f7888c;

    /* renamed from: d  reason: collision with root package name */
    private final m1.e<v1.l> f7889d;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7890a;

        static {
            int[] iArr = new int[m.a.values().length];
            f7890a = iArr;
            try {
                iArr[m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7890a[m.a.REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public j0(int i5, boolean z4, m1.e<v1.l> eVar, m1.e<v1.l> eVar2) {
        this.f7886a = i5;
        this.f7887b = z4;
        this.f7888c = eVar;
        this.f7889d = eVar2;
    }

    public static j0 a(int i5, s1.x1 x1Var) {
        m1.e eVar = new m1.e(new ArrayList(), v1.l.a());
        m1.e eVar2 = new m1.e(new ArrayList(), v1.l.a());
        for (s1.m mVar : x1Var.d()) {
            int i6 = a.f7890a[mVar.c().ordinal()];
            if (i6 == 1) {
                eVar = eVar.i(mVar.b().getKey());
            } else if (i6 == 2) {
                eVar2 = eVar2.i(mVar.b().getKey());
            }
        }
        return new j0(i5, x1Var.k(), eVar, eVar2);
    }

    public m1.e<v1.l> b() {
        return this.f7888c;
    }

    public m1.e<v1.l> c() {
        return this.f7889d;
    }

    public int d() {
        return this.f7886a;
    }

    public boolean e() {
        return this.f7887b;
    }
}
