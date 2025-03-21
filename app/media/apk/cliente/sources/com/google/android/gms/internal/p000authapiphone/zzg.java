package com.google.android.gms.internal.p000authapiphone;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzg  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzg extends zza implements zzh {
    public zzg() {
        super("com.google.android.gms.auth.api.phone.internal.IOngoingSmsRequestCallback");
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zza
    protected final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            zza((Status) zzd.zza(parcel, Status.CREATOR), zzd.zza(parcel));
            return true;
        }
        return false;
    }
}
