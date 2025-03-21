package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes.dex */
final class f implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0040b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0040b c0040b = new DynamiteModule.b.C0040b();
        int b5 = aVar.b(context, str, false);
        c0040b.f1239b = b5;
        c0040b.f1240c = b5 != 0 ? 1 : 0;
        return c0040b;
    }
}
