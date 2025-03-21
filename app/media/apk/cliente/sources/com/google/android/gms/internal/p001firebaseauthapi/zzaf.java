package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaf  reason: invalid package */
/* loaded from: classes.dex */
abstract class zzaf extends zzi<String> {
    final CharSequence zza;
    private final zzj zzb;
    private final boolean zzc;
    private int zzd = 0;
    private int zze;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzaf(zzac zzacVar, CharSequence charSequence) {
        zzj zzjVar;
        int i5;
        zzjVar = zzacVar.zza;
        this.zzb = zzjVar;
        this.zzc = false;
        i5 = zzacVar.zzd;
        this.zze = i5;
        this.zza = charSequence;
    }

    abstract int zza(int i5);

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzi
    protected final /* synthetic */ String zza() {
        int i5 = this.zzd;
        while (true) {
            int i6 = this.zzd;
            if (i6 == -1) {
                zzb();
                return null;
            }
            int zzb = zzb(i6);
            if (zzb == -1) {
                zzb = this.zza.length();
                this.zzd = -1;
            } else {
                this.zzd = zza(zzb);
            }
            int i7 = this.zzd;
            if (i7 != i5) {
                while (i5 < zzb && this.zzb.zza(this.zza.charAt(i5))) {
                    i5++;
                }
                while (zzb > i5 && this.zzb.zza(this.zza.charAt(zzb - 1))) {
                    zzb--;
                }
                int i8 = this.zze;
                if (i8 == 1) {
                    zzb = this.zza.length();
                    this.zzd = -1;
                    while (zzb > i5 && this.zzb.zza(this.zza.charAt(zzb - 1))) {
                        zzb--;
                    }
                } else {
                    this.zze = i8 - 1;
                }
                return this.zza.subSequence(i5, zzb).toString();
            }
            int i9 = i7 + 1;
            this.zzd = i9;
            if (i9 > this.zza.length()) {
                this.zzd = -1;
            }
        }
    }

    abstract int zzb(int i5);
}
