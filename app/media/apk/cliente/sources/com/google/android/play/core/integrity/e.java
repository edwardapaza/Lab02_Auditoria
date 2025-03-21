package com.google.android.play.core.integrity;

import android.net.Network;
/* loaded from: classes.dex */
final class e extends IntegrityTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f1308a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f1309b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(String str, Long l5, Network network, d dVar) {
        this.f1308a = str;
        this.f1309b = l5;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final Network a() {
        return null;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final Long cloudProjectNumber() {
        return this.f1309b;
    }

    public final boolean equals(Object obj) {
        Long l5;
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenRequest) {
            IntegrityTokenRequest integrityTokenRequest = (IntegrityTokenRequest) obj;
            if (this.f1308a.equals(integrityTokenRequest.nonce()) && ((l5 = this.f1309b) != null ? l5.equals(integrityTokenRequest.cloudProjectNumber()) : integrityTokenRequest.cloudProjectNumber() == null)) {
                integrityTokenRequest.a();
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f1308a.hashCode() ^ 1000003;
        Long l5 = this.f1309b;
        return ((hashCode * 1000003) ^ (l5 == null ? 0 : l5.hashCode())) * 1000003;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final String nonce() {
        return this.f1308a;
    }

    public final String toString() {
        String str = this.f1308a;
        Long l5 = this.f1309b;
        return "IntegrityTokenRequest{nonce=" + str + ", cloudProjectNumber=" + l5 + ", network=null}";
    }
}
