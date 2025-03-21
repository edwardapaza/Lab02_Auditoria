package com.google.android.gms.internal.p000authapiphone;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.g;
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzi  reason: invalid package */
/* loaded from: classes.dex */
public final class zzi extends zzb implements zzj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zzj
    public final void zza(g gVar) {
        Parcel zza = zza();
        zzd.zza(zza, gVar);
        zza(3, zza);
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zzj
    public final void zza(zzf zzfVar) {
        Parcel zza = zza();
        zzd.zza(zza, zzfVar);
        zza(4, zza);
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zzj
    public final void zza(zzl zzlVar) {
        Parcel zza = zza();
        zzd.zza(zza, zzlVar);
        zza(1, zza);
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zzj
    public final void zza(String str, zzh zzhVar) {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzhVar);
        zza(5, zza);
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zzj
    public final void zza(String str, zzl zzlVar) {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzlVar);
        zza(2, zza);
    }
}
