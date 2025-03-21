package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzakk;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmo  reason: invalid package */
/* loaded from: classes.dex */
final class zzmo<KeyFormatProtoT extends zzakk, KeyProtoT extends zzakk> {
    private final zzna<KeyFormatProtoT, KeyProtoT> zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmo(zzna<KeyFormatProtoT, KeyProtoT> zznaVar) {
        this.zza = zznaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final KeyProtoT zza(zzahm zzahmVar) {
        KeyFormatProtoT zza = this.zza.zza(zzahmVar);
        this.zza.zzb(zza);
        return this.zza.zza((zzna<KeyFormatProtoT, KeyProtoT>) zza);
    }
}
