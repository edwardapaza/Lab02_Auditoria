package com.google.android.gms.internal.p000authapiphone;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;
import l0.c;
import l0.k;
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzv  reason: invalid package */
/* loaded from: classes.dex */
public final class zzv extends g<zzj> {
    public zzv(Context context, Looper looper, d dVar, e eVar, m mVar) {
        super(context, looper, 126, dVar, eVar, mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
        return queryLocalInterface instanceof zzj ? (zzj) queryLocalInterface : new zzi(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c
    public final c[] getApiFeatures() {
        return zzaa.zzd;
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return k.f5890a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.phone.service.SmsRetrieverApiService.START";
    }
}
