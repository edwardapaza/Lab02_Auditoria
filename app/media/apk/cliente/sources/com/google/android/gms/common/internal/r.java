package com.google.android.gms.common.internal;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: b  reason: collision with root package name */
    private static r f1190b;

    /* renamed from: c  reason: collision with root package name */
    private static final s f1191c = new s(0, false, false, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private s f1192a;

    private r() {
    }

    public static synchronized r b() {
        r rVar;
        synchronized (r.class) {
            if (f1190b == null) {
                f1190b = new r();
            }
            rVar = f1190b;
        }
        return rVar;
    }

    public s a() {
        return this.f1192a;
    }

    public final synchronized void c(s sVar) {
        if (sVar == null) {
            this.f1192a = f1191c;
            return;
        }
        s sVar2 = this.f1192a;
        if (sVar2 == null || sVar2.x() < sVar.x()) {
            this.f1192a = sVar;
        }
    }
}
