package com.google.android.play.core.integrity;

import android.content.Context;
/* loaded from: classes.dex */
final class m implements t {

    /* renamed from: a  reason: collision with root package name */
    private Context f1315a;

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(l lVar) {
    }

    public final m a(Context context) {
        context.getClass();
        this.f1315a = context;
        return this;
    }

    @Override // com.google.android.play.core.integrity.t
    public final o b() {
        com.google.android.play.integrity.internal.l.a(this.f1315a, Context.class);
        return new o(this.f1315a, null);
    }
}
