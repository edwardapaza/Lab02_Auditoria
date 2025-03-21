package com.google.firebase.firestore;
/* loaded from: classes.dex */
public final class o0 implements n0 {

    /* renamed from: a  reason: collision with root package name */
    private long f1755a;

    public long a() {
        return this.f1755a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && o0.class == obj.getClass() && this.f1755a == ((o0) obj).f1755a;
    }

    public int hashCode() {
        long j5 = this.f1755a;
        return (int) (j5 ^ (j5 >>> 32));
    }

    public String toString() {
        return "MemoryLruGcSettings{cacheSize=" + a() + "}";
    }
}
