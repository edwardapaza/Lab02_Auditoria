package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public class zzio extends zzin implements zzkf {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzio(zzip zzipVar) {
        super(zzipVar);
    }

    @Override // com.google.android.recaptcha.internal.zzin, com.google.android.recaptcha.internal.zzkd
    /* renamed from: zzd */
    public final zzip zzk() {
        zzit zzk;
        if (((zzip) this.zza).zzG()) {
            ((zzip) this.zza).zzb.zzg();
            zzk = super.zzk();
        } else {
            zzk = this.zza;
        }
        return (zzip) zzk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.recaptcha.internal.zzin
    public final void zzn() {
        super.zzn();
        if (((zzip) this.zza).zzb != zzij.zzd()) {
            zzip zzipVar = (zzip) this.zza;
            zzipVar.zzb = zzipVar.zzb.clone();
        }
    }
}
