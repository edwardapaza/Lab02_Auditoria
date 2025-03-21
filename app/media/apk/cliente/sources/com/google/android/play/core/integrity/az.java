package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.c0;
/* loaded from: classes.dex */
public final class az implements com.google.android.play.integrity.internal.j {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.m f1294a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.m f1295b;

    public az(com.google.android.play.integrity.internal.m mVar, com.google.android.play.integrity.internal.m mVar2) {
        this.f1294a = mVar;
        this.f1295b = mVar2;
    }

    @Override // com.google.android.play.integrity.internal.m
    public final /* bridge */ /* synthetic */ Object a() {
        return new ax((Context) this.f1294a.a(), (c0) this.f1295b.a());
    }
}
