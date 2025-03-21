package y2;

import java.util.Locale;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private b f8616a;

    /* renamed from: b  reason: collision with root package name */
    private b f8617b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8618c;

    /* renamed from: d  reason: collision with root package name */
    private final z2.a<String> f8619d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8620a;

        static {
            int[] iArr = new int[b.values().length];
            f8620a = iArr;
            try {
                iArr[b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8620a[b.INACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8620a[b.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8620a[b.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8620a[b.DETACHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum b {
        DETACHED,
        RESUMED,
        INACTIVE,
        HIDDEN,
        PAUSED
    }

    public g(o2.a aVar) {
        this(new z2.a(aVar, "flutter/lifecycle", z2.r.f9021b));
    }

    public g(z2.a<String> aVar) {
        this.f8616a = null;
        this.f8617b = null;
        this.f8618c = true;
        this.f8619d = aVar;
    }

    private void g(b bVar, boolean z4) {
        b bVar2 = this.f8616a;
        if (bVar2 == bVar && z4 == this.f8618c) {
            return;
        }
        if (bVar == null && bVar2 == null) {
            this.f8618c = z4;
            return;
        }
        b bVar3 = null;
        int i5 = a.f8620a[bVar.ordinal()];
        if (i5 == 1) {
            bVar3 = z4 ? b.RESUMED : b.INACTIVE;
        } else if (i5 == 2 || i5 == 3 || i5 == 4 || i5 == 5) {
            bVar3 = bVar;
        }
        this.f8616a = bVar;
        this.f8618c = z4;
        if (bVar3 == this.f8617b) {
            return;
        }
        String str = "AppLifecycleState." + bVar3.name().toLowerCase(Locale.ROOT);
        n2.b.f("LifecycleChannel", "Sending " + str + " message.");
        this.f8619d.c(str);
        this.f8617b = bVar3;
    }

    public void a() {
        g(this.f8616a, true);
    }

    public void b() {
        g(b.DETACHED, this.f8618c);
    }

    public void c() {
        g(b.INACTIVE, this.f8618c);
    }

    public void d() {
        g(b.PAUSED, this.f8618c);
    }

    public void e() {
        g(b.RESUMED, this.f8618c);
    }

    public void f() {
        g(this.f8616a, false);
    }
}
