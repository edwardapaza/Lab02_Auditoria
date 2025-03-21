package com.google.android.recaptcha.internal;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
final class zzgn extends zzgp {
    final /* synthetic */ zzgw zza;
    private int zzb = 0;
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgn(zzgw zzgwVar) {
        this.zza = zzgwVar;
        this.zzc = zzgwVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zzgr
    public final byte zza() {
        int i5 = this.zzb;
        if (i5 < this.zzc) {
            this.zzb = i5 + 1;
            return this.zza.zzb(i5);
        }
        throw new NoSuchElementException();
    }
}
