package com.google.android.recaptcha.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zziq implements zzii {
    final int zza;
    final zzmb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziq(zziw zziwVar, int i5, zzmb zzmbVar, boolean z4, boolean z5) {
        this.zza = i5;
        this.zzb = zzmbVar;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.zza - ((zziq) obj).zza;
    }

    @Override // com.google.android.recaptcha.internal.zzii
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.recaptcha.internal.zzii
    public final zzkd zzb(zzkd zzkdVar, zzke zzkeVar) {
        ((zzin) zzkdVar).zzg((zzit) zzkeVar);
        return zzkdVar;
    }

    @Override // com.google.android.recaptcha.internal.zzii
    public final zzkj zzc(zzkj zzkjVar, zzkj zzkjVar2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.recaptcha.internal.zzii
    public final zzmb zzd() {
        return this.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzii
    public final zzmc zze() {
        return this.zzb.zza();
    }

    @Override // com.google.android.recaptcha.internal.zzii
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzii
    public final boolean zzg() {
        return false;
    }
}
