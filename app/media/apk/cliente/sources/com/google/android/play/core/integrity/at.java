package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
/* loaded from: classes.dex */
class at extends com.google.android.play.integrity.internal.v {

    /* renamed from: a  reason: collision with root package name */
    final TaskCompletionSource f1284a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ax f1285b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ax axVar, TaskCompletionSource taskCompletionSource) {
        this.f1285b = axVar;
        this.f1284a = taskCompletionSource;
    }

    @Override // com.google.android.play.integrity.internal.w
    public final void b(Bundle bundle) {
        this.f1285b.f1289a.v(this.f1284a);
    }

    @Override // com.google.android.play.integrity.internal.w
    public void c(Bundle bundle) {
        this.f1285b.f1289a.v(this.f1284a);
    }

    @Override // com.google.android.play.integrity.internal.w
    public final void d(Bundle bundle) {
        this.f1285b.f1289a.v(this.f1284a);
    }

    @Override // com.google.android.play.integrity.internal.w
    public void e(Bundle bundle) {
        this.f1285b.f1289a.v(this.f1284a);
    }
}
