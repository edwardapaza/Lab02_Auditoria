package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.d0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aq extends d0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1274a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ax f1275b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(ax axVar, TaskCompletionSource taskCompletionSource, Context context) {
        super(taskCompletionSource);
        this.f1275b = axVar;
        this.f1274a = context;
    }

    @Override // com.google.android.play.integrity.internal.d0
    protected final void b() {
        TaskCompletionSource taskCompletionSource;
        taskCompletionSource = this.f1275b.f1292d;
        taskCompletionSource.trySetResult(Boolean.valueOf(com.google.android.play.integrity.internal.h.a(this.f1274a)));
    }
}
