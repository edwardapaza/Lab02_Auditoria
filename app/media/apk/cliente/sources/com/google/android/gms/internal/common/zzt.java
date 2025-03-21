package com.google.android.gms.internal.common;
/* loaded from: classes.dex */
final class zzt extends zzw {
    final /* synthetic */ zzu zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzt(zzu zzuVar, zzx zzxVar, CharSequence charSequence) {
        super(zzxVar, charSequence);
        this.zza = zzuVar;
    }

    @Override // com.google.android.gms.internal.common.zzw
    final int zzc(int i5) {
        return i5 + 1;
    }

    @Override // com.google.android.gms.internal.common.zzw
    final int zzd(int i5) {
        CharSequence charSequence = ((zzw) this).zzb;
        int length = charSequence.length();
        zzs.zzb(i5, length, "index");
        while (i5 < length) {
            zzu zzuVar = this.zza;
            if (zzuVar.zza.zza(charSequence.charAt(i5))) {
                return i5;
            }
            i5++;
        }
        return -1;
    }
}
