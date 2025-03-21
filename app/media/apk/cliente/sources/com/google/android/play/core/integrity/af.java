package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.c0;
/* loaded from: classes.dex */
public final class af implements com.google.android.play.integrity.internal.j {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.m f1261a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.m f1262b;

    public af(com.google.android.play.integrity.internal.m mVar, com.google.android.play.integrity.internal.m mVar2) {
        this.f1261a = mVar;
        this.f1262b = mVar2;
    }

    @Override // com.google.android.play.integrity.internal.m
    public final /* bridge */ /* synthetic */ Object a() {
        return new ad((Context) this.f1261a.a(), (c0) this.f1262b.a());
    }
}
