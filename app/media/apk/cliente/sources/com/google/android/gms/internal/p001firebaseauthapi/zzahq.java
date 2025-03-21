package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahq  reason: invalid package */
/* loaded from: classes.dex */
final class zzahq extends zzahw {
    private final int zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahq(byte[] bArr, int i5, int i6) {
        super(bArr);
        zzahm.zza(i5, i5 + i6, bArr.length);
        this.zzc = i5;
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahw, com.google.android.gms.internal.p001firebaseauthapi.zzahm
    public final byte zza(int i5) {
        int zzb = zzb();
        if (((zzb - (i5 + 1)) | i5) < 0) {
            if (i5 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i5);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i5 + ", " + zzb);
        }
        return this.zzb[this.zzc + i5];
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahw, com.google.android.gms.internal.p001firebaseauthapi.zzahm
    protected final void zza(byte[] bArr, int i5, int i6, int i7) {
        System.arraycopy(this.zzb, zzh(), bArr, 0, i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahw, com.google.android.gms.internal.p001firebaseauthapi.zzahm
    public final byte zzb(int i5) {
        return this.zzb[this.zzc + i5];
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahw, com.google.android.gms.internal.p001firebaseauthapi.zzahm
    public final int zzb() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahw
    public final int zzh() {
        return this.zzc;
    }
}
