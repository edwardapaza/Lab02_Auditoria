package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes.dex */
final class i implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0040b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0040b c0040b = new DynamiteModule.b.C0040b();
        c0040b.f1238a = aVar.a(context, str);
        int i5 = 1;
        int b5 = aVar.b(context, str, true);
        c0040b.f1239b = b5;
        int i6 = c0040b.f1238a;
        if (i6 == 0) {
            if (b5 == 0) {
                i5 = 0;
                c0040b.f1240c = i5;
                return c0040b;
            }
            i6 = 0;
        }
        if (b5 < i6) {
            i5 = -1;
        }
        c0040b.f1240c = i5;
        return c0040b;
    }
}
