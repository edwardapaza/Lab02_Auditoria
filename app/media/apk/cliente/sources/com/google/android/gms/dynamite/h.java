package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes.dex */
final class h implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0040b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0040b c0040b = new DynamiteModule.b.C0040b();
        int a5 = aVar.a(context, str);
        c0040b.f1238a = a5;
        int i5 = 1;
        int i6 = 0;
        int b5 = a5 != 0 ? aVar.b(context, str, false) : aVar.b(context, str, true);
        c0040b.f1239b = b5;
        int i7 = c0040b.f1238a;
        if (i7 != 0) {
            i6 = i7;
        } else if (b5 == 0) {
            i5 = 0;
            c0040b.f1240c = i5;
            return c0040b;
        }
        if (i6 >= b5) {
            i5 = -1;
        }
        c0040b.f1240c = i5;
        return c0040b;
    }
}
