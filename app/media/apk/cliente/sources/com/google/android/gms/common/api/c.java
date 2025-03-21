package com.google.android.gms.common.api;

import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final androidx.collection.a<com.google.android.gms.common.api.internal.b<?>, l0.a> f890a;

    public c(androidx.collection.a<com.google.android.gms.common.api.internal.b<?>, l0.a> aVar) {
        this.f890a = aVar;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z4 = true;
        for (com.google.android.gms.common.api.internal.b<?> bVar : this.f890a.keySet()) {
            l0.a aVar = (l0.a) q.k(this.f890a.get(bVar));
            z4 &= !aVar.x();
            String b5 = bVar.b();
            String valueOf = String.valueOf(aVar);
            StringBuilder sb = new StringBuilder(String.valueOf(b5).length() + 2 + valueOf.length());
            sb.append(b5);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z4 ? "None of the queried APIs are available. " : "Some of the queried APIs are unavailable. ");
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
