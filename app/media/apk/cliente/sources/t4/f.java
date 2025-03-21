package t4;

import m4.l1;
/* loaded from: classes.dex */
public class f extends l1 {

    /* renamed from: d  reason: collision with root package name */
    private final int f7680d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7681e;

    /* renamed from: f  reason: collision with root package name */
    private final long f7682f;

    /* renamed from: k  reason: collision with root package name */
    private final String f7683k;

    /* renamed from: l  reason: collision with root package name */
    private a f7684l = i0();

    public f(int i5, int i6, long j5, String str) {
        this.f7680d = i5;
        this.f7681e = i6;
        this.f7682f = j5;
        this.f7683k = str;
    }

    private final a i0() {
        return new a(this.f7680d, this.f7681e, this.f7682f, this.f7683k);
    }

    @Override // m4.g0
    public void f0(v3.g gVar, Runnable runnable) {
        a.n(this.f7684l, runnable, null, false, 6, null);
    }

    public final void j0(Runnable runnable, i iVar, boolean z4) {
        this.f7684l.l(runnable, iVar, z4);
    }
}
