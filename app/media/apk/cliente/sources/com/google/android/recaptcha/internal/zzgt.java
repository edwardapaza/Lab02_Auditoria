package com.google.android.recaptcha.internal;

import java.nio.charset.Charset;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzgt extends zzgs {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgt(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.recaptcha.internal.zzgw
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzgw) && zzd() == ((zzgw) obj).zzd()) {
            if (zzd() == 0) {
                return true;
            }
            if (obj instanceof zzgt) {
                zzgt zzgtVar = (zzgt) obj;
                int zzl = zzl();
                int zzl2 = zzgtVar.zzl();
                if (zzl == 0 || zzl2 == 0 || zzl == zzl2) {
                    int zzd = zzd();
                    if (zzd > zzgtVar.zzd()) {
                        int zzd2 = zzd();
                        throw new IllegalArgumentException("Length too large: " + zzd + zzd2);
                    } else if (zzd > zzgtVar.zzd()) {
                        int zzd3 = zzgtVar.zzd();
                        throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzd3);
                    } else {
                        byte[] bArr = this.zza;
                        byte[] bArr2 = zzgtVar.zza;
                        zzgtVar.zzc();
                        int i5 = 0;
                        int i6 = 0;
                        while (i5 < zzd) {
                            if (bArr[i5] != bArr2[i6]) {
                                return false;
                            }
                            i5++;
                            i6++;
                        }
                        return true;
                    }
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzgw
    public byte zza(int i5) {
        return this.zza[i5];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzgw
    public byte zzb(int i5) {
        return this.zza[i5];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.recaptcha.internal.zzgw
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.recaptcha.internal.zzgw
    protected void zze(byte[] bArr, int i5, int i6, int i7) {
        System.arraycopy(this.zza, 0, bArr, 0, i7);
    }

    @Override // com.google.android.recaptcha.internal.zzgw
    protected final int zzf(int i5, int i6, int i7) {
        return zzjc.zzb(i5, this.zza, 0, i7);
    }

    @Override // com.google.android.recaptcha.internal.zzgw
    public final zzgw zzg(int i5, int i6) {
        int zzk = zzgw.zzk(0, i6, zzd());
        return zzk == 0 ? zzgw.zzb : new zzgq(this.zza, 0, zzk);
    }

    @Override // com.google.android.recaptcha.internal.zzgw
    protected final String zzh(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzgw
    public final void zzi(zzgm zzgmVar) {
        ((zzhe) zzgmVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.recaptcha.internal.zzgw
    public final boolean zzj() {
        return zzma.zzf(this.zza, 0, zzd());
    }
}
