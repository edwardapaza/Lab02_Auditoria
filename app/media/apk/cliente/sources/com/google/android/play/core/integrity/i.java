package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;
/* loaded from: classes.dex */
final class i extends StandardIntegrityManager.StandardIntegrityTokenRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f1313a;

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenRequest.Builder
    public final StandardIntegrityManager.StandardIntegrityTokenRequest build() {
        return new k(this.f1313a, null);
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenRequest.Builder
    public final StandardIntegrityManager.StandardIntegrityTokenRequest.Builder setRequestHash(String str) {
        this.f1313a = str;
        return this;
    }
}
