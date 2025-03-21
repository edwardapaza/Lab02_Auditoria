package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: a  reason: collision with root package name */
    private final androidx.collection.a<b<?>, l0.a> f973a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.collection.a<b<?>, String> f974b;

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource<Map<b<?>, String>> f975c;

    /* renamed from: d  reason: collision with root package name */
    private int f976d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f977e;

    public final Set<b<?>> a() {
        return this.f973a.keySet();
    }

    public final void b(b<?> bVar, l0.a aVar, String str) {
        this.f973a.put(bVar, aVar);
        this.f974b.put(bVar, str);
        this.f976d--;
        if (!aVar.x()) {
            this.f977e = true;
        }
        if (this.f976d == 0) {
            if (!this.f977e) {
                this.f975c.setResult(this.f974b);
                return;
            }
            this.f975c.setException(new com.google.android.gms.common.api.c(this.f973a));
        }
    }
}
