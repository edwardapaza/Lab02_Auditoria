package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.c0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class as extends aw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1279a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f1280b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f1281c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f1282d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ ax f1283e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(ax axVar, TaskCompletionSource taskCompletionSource, String str, long j5, long j6, TaskCompletionSource taskCompletionSource2) {
        super(axVar, taskCompletionSource);
        this.f1283e = axVar;
        this.f1279a = str;
        this.f1280b = j5;
        this.f1281c = j6;
        this.f1282d = taskCompletionSource2;
    }

    @Override // com.google.android.play.integrity.internal.d0
    protected final void b() {
        c0 c0Var;
        if (ax.g(this.f1283e)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        try {
            ax axVar = this.f1283e;
            ((com.google.android.play.integrity.internal.u) axVar.f1289a.e()).g(ax.a(axVar, this.f1279a, this.f1280b, this.f1281c), new au(this.f1283e, this.f1282d));
        } catch (RemoteException e5) {
            c0Var = this.f1283e.f1290b;
            c0Var.b(e5, "requestExpressIntegrityToken(%s, %s)", this.f1279a, Long.valueOf(this.f1280b));
            this.f1282d.trySetException(new StandardIntegrityException(-100, e5));
        }
    }
}
