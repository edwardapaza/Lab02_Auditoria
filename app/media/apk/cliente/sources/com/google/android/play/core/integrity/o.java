package com.google.android.play.core.integrity;

import android.content.Context;
/* loaded from: classes.dex */
final class o {

    /* renamed from: a  reason: collision with root package name */
    private final o f1320a = this;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.m f1321b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.m f1322c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.m f1323d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.m f1324e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(Context context, n nVar) {
        z zVar;
        com.google.android.play.integrity.internal.j b5 = com.google.android.play.integrity.internal.k.b(context);
        this.f1321b = b5;
        zVar = y.f1337a;
        com.google.android.play.integrity.internal.m b6 = com.google.android.play.integrity.internal.i.b(zVar);
        this.f1322c = b6;
        com.google.android.play.integrity.internal.m b7 = com.google.android.play.integrity.internal.i.b(new af(b5, b6));
        this.f1323d = b7;
        this.f1324e = com.google.android.play.integrity.internal.i.b(new x(b7));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f1324e.a();
    }
}
