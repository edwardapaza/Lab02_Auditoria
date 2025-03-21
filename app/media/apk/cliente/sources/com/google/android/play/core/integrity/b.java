package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import com.google.android.play.integrity.internal.c0;
/* loaded from: classes.dex */
final class b extends ba {

    /* renamed from: a  reason: collision with root package name */
    private String f1296a;

    /* renamed from: b  reason: collision with root package name */
    private c0 f1297b;

    /* renamed from: c  reason: collision with root package name */
    private PendingIntent f1298c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.integrity.ba
    public final ba a(PendingIntent pendingIntent) {
        this.f1298c = pendingIntent;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.integrity.ba
    public final ba b(c0 c0Var) {
        if (c0Var != null) {
            this.f1297b = c0Var;
            return this;
        }
        throw new NullPointerException("Null logger");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.integrity.ba
    public final ba c(String str) {
        if (str != null) {
            this.f1296a = str;
            return this;
        }
        throw new NullPointerException("Null token");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.integrity.ba
    public final bb d() {
        c0 c0Var;
        String str = this.f1296a;
        if (str == null || (c0Var = this.f1297b) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.f1296a == null) {
                sb.append(" token");
            }
            if (this.f1297b == null) {
                sb.append(" logger");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new bb(str, c0Var, this.f1298c);
    }
}
