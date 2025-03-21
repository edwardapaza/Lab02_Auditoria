package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
final class zzln extends zzll {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzll
    public final /* synthetic */ int zza(Object obj) {
        return ((zzlm) obj).zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzll
    public final /* synthetic */ int zzb(Object obj) {
        return ((zzlm) obj).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzll
    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzit zzitVar = (zzit) obj;
        zzlm zzlmVar = zzitVar.zzc;
        if (zzlmVar == zzlm.zzc()) {
            zzlm zzf = zzlm.zzf();
            zzitVar.zzc = zzf;
            return zzf;
        }
        return zzlmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzll
    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzit) obj).zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzll
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzlm.zzc().equals(obj2)) {
            return obj;
        }
        zzlm zzlmVar = (zzlm) obj2;
        if (zzlm.zzc().equals(obj)) {
            return zzlm.zze((zzlm) obj, zzlmVar);
        }
        ((zzlm) obj).zzd(zzlmVar);
        return obj;
    }

    @Override // com.google.android.recaptcha.internal.zzll
    final /* synthetic */ Object zzf() {
        return zzlm.zzf();
    }

    @Override // com.google.android.recaptcha.internal.zzll
    final /* synthetic */ Object zzg(Object obj) {
        ((zzlm) obj).zzh();
        return obj;
    }

    @Override // com.google.android.recaptcha.internal.zzll
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i5, int i6) {
        ((zzlm) obj).zzj((i5 << 3) | 5, Integer.valueOf(i6));
    }

    @Override // com.google.android.recaptcha.internal.zzll
    final /* bridge */ /* synthetic */ void zzi(Object obj, int i5, long j5) {
        ((zzlm) obj).zzj((i5 << 3) | 1, Long.valueOf(j5));
    }

    @Override // com.google.android.recaptcha.internal.zzll
    final /* bridge */ /* synthetic */ void zzj(Object obj, int i5, Object obj2) {
        ((zzlm) obj).zzj((i5 << 3) | 3, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzll
    public final /* bridge */ /* synthetic */ void zzk(Object obj, int i5, zzgw zzgwVar) {
        ((zzlm) obj).zzj((i5 << 3) | 2, zzgwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzll
    public final /* bridge */ /* synthetic */ void zzl(Object obj, int i5, long j5) {
        ((zzlm) obj).zzj(i5 << 3, Long.valueOf(j5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzll
    public final void zzm(Object obj) {
        ((zzit) obj).zzc.zzh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzll
    public final /* synthetic */ void zzn(Object obj, Object obj2) {
        ((zzit) obj).zzc = (zzlm) obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzll
    public final /* synthetic */ void zzo(Object obj, Object obj2) {
        ((zzit) obj).zzc = (zzlm) obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzll
    public final /* synthetic */ void zzp(Object obj, zzmd zzmdVar) {
        ((zzlm) obj).zzk(zzmdVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzll
    public final /* synthetic */ void zzq(Object obj, zzmd zzmdVar) {
        ((zzlm) obj).zzl(zzmdVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzll
    public final boolean zzs(zzkq zzkqVar) {
        return false;
    }
}
