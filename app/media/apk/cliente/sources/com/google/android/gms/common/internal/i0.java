package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;
/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f1150a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private l0.g f1151b;

    public i0(l0.g gVar) {
        q.k(gVar);
        this.f1151b = gVar;
    }

    public final int a(Context context, int i5) {
        return this.f1150a.get(i5, -1);
    }

    public final int b(Context context, a.f fVar) {
        q.k(context);
        q.k(fVar);
        int i5 = 0;
        if (fVar.requiresGooglePlayServices()) {
            int minApkVersion = fVar.getMinApkVersion();
            int a5 = a(context, minApkVersion);
            if (a5 == -1) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.f1150a.size()) {
                        i5 = -1;
                        break;
                    }
                    int keyAt = this.f1150a.keyAt(i6);
                    if (keyAt > minApkVersion && this.f1150a.get(keyAt) == 0) {
                        break;
                    }
                    i6++;
                }
                a5 = i5 == -1 ? this.f1151b.g(context, minApkVersion) : i5;
                this.f1150a.put(minApkVersion, a5);
            }
            return a5;
        }
        return 0;
    }

    public final void c() {
        this.f1150a.clear();
    }
}
