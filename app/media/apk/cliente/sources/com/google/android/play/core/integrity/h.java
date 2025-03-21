package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;
/* loaded from: classes.dex */
final class h extends StandardIntegrityManager.PrepareIntegrityTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    private final long f1312a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(long j5, g gVar) {
        this.f1312a = j5;
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest
    public final long a() {
        return this.f1312a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof StandardIntegrityManager.PrepareIntegrityTokenRequest) && this.f1312a == ((StandardIntegrityManager.PrepareIntegrityTokenRequest) obj).a();
    }

    public final int hashCode() {
        long j5 = this.f1312a;
        return 1000003 ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        long j5 = this.f1312a;
        return "PrepareIntegrityTokenRequest{cloudProjectNumber=" + j5 + "}";
    }
}
