package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import com.google.android.play.integrity.internal.c0;
/* loaded from: classes.dex */
final class a extends ag {

    /* renamed from: a  reason: collision with root package name */
    private String f1245a;

    /* renamed from: b  reason: collision with root package name */
    private c0 f1246b;

    /* renamed from: c  reason: collision with root package name */
    private PendingIntent f1247c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.integrity.ag
    public final ag a(PendingIntent pendingIntent) {
        this.f1247c = pendingIntent;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.integrity.ag
    public final ag b(c0 c0Var) {
        if (c0Var != null) {
            this.f1246b = c0Var;
            return this;
        }
        throw new NullPointerException("Null logger");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.integrity.ag
    public final ag c(String str) {
        this.f1245a = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.integrity.ag
    public final ah d() {
        c0 c0Var;
        String str = this.f1245a;
        if (str == null || (c0Var = this.f1246b) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.f1245a == null) {
                sb.append(" token");
            }
            if (this.f1246b == null) {
                sb.append(" logger");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new ah(str, c0Var, this.f1247c);
    }
}
