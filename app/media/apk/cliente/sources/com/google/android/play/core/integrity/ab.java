package com.google.android.play.core.integrity;

import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.c0;
import com.google.android.play.integrity.internal.d0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab extends d0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ byte[] f1249a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Long f1250b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f1251c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ IntegrityTokenRequest f1252d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ ad f1253e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(ad adVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l5, Parcelable parcelable, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.f1253e = adVar;
        this.f1249a = bArr;
        this.f1250b = l5;
        this.f1251c = taskCompletionSource2;
        this.f1252d = integrityTokenRequest;
    }

    @Override // com.google.android.play.integrity.internal.d0
    public final void a(Exception exc) {
        if (exc instanceof com.google.android.play.integrity.internal.e) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    @Override // com.google.android.play.integrity.internal.d0
    protected final void b() {
        c0 c0Var;
        try {
            ((com.google.android.play.integrity.internal.z) this.f1253e.f1257a.e()).e(ad.a(this.f1253e, this.f1249a, this.f1250b, null), new ac(this.f1253e, this.f1251c));
        } catch (RemoteException e5) {
            c0Var = this.f1253e.f1258b;
            c0Var.b(e5, "requestIntegrityToken(%s)", this.f1252d);
            this.f1251c.trySetException(new IntegrityServiceException(-100, e5));
        }
    }
}
