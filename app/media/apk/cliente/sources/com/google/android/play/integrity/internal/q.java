package com.google.android.play.integrity.internal;
/* loaded from: classes.dex */
final class q extends r {

    /* renamed from: a  reason: collision with root package name */
    private final int f1375a;

    /* renamed from: b  reason: collision with root package name */
    private final long f1376b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(int i5, long j5) {
        this.f1375a = i5;
        this.f1376b = j5;
    }

    @Override // com.google.android.play.integrity.internal.r
    public final int a() {
        return this.f1375a;
    }

    @Override // com.google.android.play.integrity.internal.r
    public final long b() {
        return this.f1376b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f1375a == rVar.a() && this.f1376b == rVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f1376b;
        return ((this.f1375a ^ 1000003) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        int i5 = this.f1375a;
        long j5 = this.f1376b;
        return "EventRecord{eventType=" + i5 + ", eventTimestamp=" + j5 + "}";
    }
}
