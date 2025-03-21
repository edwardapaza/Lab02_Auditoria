package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;
/* loaded from: classes.dex */
final class k extends StandardIntegrityManager.StandardIntegrityTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f1314a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(String str, j jVar) {
        this.f1314a = str;
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenRequest
    public final String a() {
        return this.f1314a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StandardIntegrityManager.StandardIntegrityTokenRequest) {
            String str = this.f1314a;
            String a5 = ((StandardIntegrityManager.StandardIntegrityTokenRequest) obj).a();
            return str == null ? a5 == null : str.equals(a5);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f1314a;
        return (str == null ? 0 : str.hashCode()) ^ 1000003;
    }

    public final String toString() {
        String str = this.f1314a;
        return "StandardIntegrityTokenRequest{requestHash=" + str + "}";
    }
}
