package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.IntegrityTokenRequest;
/* loaded from: classes.dex */
final class c extends IntegrityTokenRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f1306a;

    /* renamed from: b  reason: collision with root package name */
    private Long f1307b;

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest.Builder
    public final IntegrityTokenRequest build() {
        String str = this.f1306a;
        if (str != null) {
            return new e(str, this.f1307b, null, null);
        }
        throw new IllegalStateException("Missing required properties: nonce");
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest.Builder
    public final IntegrityTokenRequest.Builder setCloudProjectNumber(long j5) {
        this.f1307b = Long.valueOf(j5);
        return this;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest.Builder
    public final IntegrityTokenRequest.Builder setNonce(String str) {
        if (str != null) {
            this.f1306a = str;
            return this;
        }
        throw new NullPointerException("Null nonce");
    }
}
