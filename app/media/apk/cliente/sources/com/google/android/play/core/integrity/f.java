package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;
/* loaded from: classes.dex */
final class f extends StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private long f1310a;

    /* renamed from: b  reason: collision with root package name */
    private byte f1311b;

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder
    public final StandardIntegrityManager.PrepareIntegrityTokenRequest build() {
        if (this.f1311b == 1) {
            return new h(this.f1310a, null);
        }
        throw new IllegalStateException("Missing required properties: cloudProjectNumber");
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder
    public final StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder setCloudProjectNumber(long j5) {
        this.f1310a = j5;
        this.f1311b = (byte) 1;
        return this;
    }
}
