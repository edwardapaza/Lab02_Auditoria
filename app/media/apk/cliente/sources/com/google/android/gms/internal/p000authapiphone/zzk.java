package com.google.android.gms.internal.p000authapiphone;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzk  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzk extends zza implements zzl {
    public zzk() {
        super("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverResultCallback");
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zza
    protected final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            zza((Status) zzd.zza(parcel, Status.CREATOR));
            return true;
        }
        return false;
    }
}
