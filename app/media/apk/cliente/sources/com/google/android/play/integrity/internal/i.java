package com.google.android.play.integrity.internal;
/* loaded from: classes.dex */
public final class i implements m {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1366c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile m f1367a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f1368b = f1366c;

    private i(m mVar) {
        this.f1367a = mVar;
    }

    public static m b(m mVar) {
        return mVar instanceof i ? mVar : new i(mVar);
    }

    @Override // com.google.android.play.integrity.internal.m
    public final Object a() {
        Object obj = this.f1368b;
        Object obj2 = f1366c;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.f1368b;
                if (obj == obj2) {
                    obj = this.f1367a.a();
                    Object obj3 = this.f1368b;
                    if (obj3 != obj2 && obj3 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f1368b = obj;
                    this.f1367a = null;
                }
            }
        }
        return obj;
    }
}
