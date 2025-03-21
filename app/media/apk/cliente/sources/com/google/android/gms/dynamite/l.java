package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes.dex */
final class l implements DynamiteModule.b.a {

    /* renamed from: a  reason: collision with root package name */
    private final int f1242a;

    public l(int i5, int i6) {
        this.f1242a = i5;
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.b.a
    public final int a(Context context, String str) {
        return this.f1242a;
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.b.a
    public final int b(Context context, String str, boolean z4) {
        return 0;
    }
}
