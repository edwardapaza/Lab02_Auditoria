package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
final class zzgq extends zzgt {
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgq(byte[] bArr, int i5, int i6) {
        super(bArr);
        zzgw.zzk(0, i6, bArr.length);
        this.zzc = i6;
    }

    @Override // com.google.android.recaptcha.internal.zzgt, com.google.android.recaptcha.internal.zzgw
    public final byte zza(int i5) {
        int i6 = this.zzc;
        if (((i6 - (i5 + 1)) | i5) < 0) {
            if (i5 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i5);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i5 + ", " + i6);
        }
        return this.zza[i5];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzgt, com.google.android.recaptcha.internal.zzgw
    public final byte zzb(int i5) {
        return this.zza[i5];
    }

    @Override // com.google.android.recaptcha.internal.zzgt
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.recaptcha.internal.zzgt, com.google.android.recaptcha.internal.zzgw
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zzgt, com.google.android.recaptcha.internal.zzgw
    protected final void zze(byte[] bArr, int i5, int i6, int i7) {
        System.arraycopy(this.zza, 0, bArr, 0, i7);
    }
}
