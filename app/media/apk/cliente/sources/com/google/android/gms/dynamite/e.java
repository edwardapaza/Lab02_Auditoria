package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes.dex */
final class e implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0040b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0040b c0040b = new DynamiteModule.b.C0040b();
        int a5 = aVar.a(context, str);
        c0040b.f1238a = a5;
        if (a5 != 0) {
            c0040b.f1240c = -1;
        } else {
            int b5 = aVar.b(context, str, true);
            c0040b.f1239b = b5;
            if (b5 != 0) {
                c0040b.f1240c = 1;
            }
        }
        return c0040b;
    }
}
