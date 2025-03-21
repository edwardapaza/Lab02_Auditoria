package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.c0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ar extends aw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f1276a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f1277b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ax f1278c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(ax axVar, TaskCompletionSource taskCompletionSource, long j5, TaskCompletionSource taskCompletionSource2) {
        super(axVar, taskCompletionSource);
        this.f1278c = axVar;
        this.f1276a = j5;
        this.f1277b = taskCompletionSource2;
    }

    @Override // com.google.android.play.integrity.internal.d0
    protected final void b() {
        c0 c0Var;
        if (ax.g(this.f1278c)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        try {
            ax axVar = this.f1278c;
            ((com.google.android.play.integrity.internal.u) axVar.f1289a.e()).c(ax.b(axVar, this.f1276a), new av(this.f1278c, this.f1277b));
        } catch (RemoteException e5) {
            c0Var = this.f1278c.f1290b;
            c0Var.b(e5, "warmUpIntegrityToken(%s)", Long.valueOf(this.f1276a));
            this.f1277b.trySetException(new StandardIntegrityException(-100, e5));
        }
    }
}
