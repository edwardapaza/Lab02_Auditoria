package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a1 extends r {

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ r.a f913d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(r.a aVar, l0.c[] cVarArr, boolean z4, int i5) {
        super(cVarArr, z4, i5);
        this.f913d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.r
    public final void b(a.b bVar, TaskCompletionSource taskCompletionSource) {
        p pVar;
        pVar = this.f913d.f1025a;
        pVar.accept(bVar, taskCompletionSource);
    }
}
