package com.google.android.gms.internal.p000authapiphone;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
/* renamed from: com.google.android.gms.internal.auth-api-phone.zze  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zze extends zza implements zzf {
    public zze() {
        super("com.google.android.gms.auth.api.phone.internal.IAutofillPermissionStateCallback");
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zza
    protected final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            zza((Status) zzd.zza(parcel, Status.CREATOR), parcel.readInt());
            return true;
        }
        return false;
    }
}
