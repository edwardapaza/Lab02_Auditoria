package com.google.android.play.core.integrity;

import android.content.Context;
/* loaded from: classes.dex */
final class s {

    /* renamed from: a  reason: collision with root package name */
    private final s f1326a = this;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.m f1327b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.m f1328c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.m f1329d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.m f1330e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.m f1331f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(Context context, r rVar) {
        ao aoVar;
        com.google.android.play.integrity.internal.j b5 = com.google.android.play.integrity.internal.k.b(context);
        this.f1327b = b5;
        aoVar = an.f1272a;
        com.google.android.play.integrity.internal.m b6 = com.google.android.play.integrity.internal.i.b(aoVar);
        this.f1328c = b6;
        com.google.android.play.integrity.internal.m b7 = com.google.android.play.integrity.internal.i.b(new az(b5, b6));
        this.f1329d = b7;
        com.google.android.play.integrity.internal.m b8 = com.google.android.play.integrity.internal.i.b(new be(b7));
        this.f1330e = b8;
        this.f1331f = com.google.android.play.integrity.internal.i.b(new am(b7, b8));
    }

    public final StandardIntegrityManager a() {
        return (StandardIntegrityManager) this.f1331f.a();
    }
}
