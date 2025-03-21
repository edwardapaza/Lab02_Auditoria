package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.charset.Charset;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahw  reason: invalid package */
/* loaded from: classes.dex */
public class zzahw extends zzahx {
    protected final byte[] zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahw(byte[] bArr) {
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahm
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzahm) && zzb() == ((zzahm) obj).zzb()) {
            if (zzb() == 0) {
                return true;
            }
            if (obj instanceof zzahw) {
                zzahw zzahwVar = (zzahw) obj;
                int zza = zza();
                int zza2 = zzahwVar.zza();
                if (zza == 0 || zza2 == 0 || zza == zza2) {
                    return zza(zzahwVar, 0, zzb());
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahm
    public byte zza(int i5) {
        return this.zzb[i5];
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahm
    public final zzahm zza(int i5, int i6) {
        int zza = zzahm.zza(0, i6, zzb());
        return zza == 0 ? zzahm.zza : new zzahq(this.zzb, zzh(), zza);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahm
    protected final String zza(Charset charset) {
        return new String(this.zzb, zzh(), zzb(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahm
    public final void zza(zzahn zzahnVar) {
        zzahnVar.zza(this.zzb, zzh(), zzb());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahm
    protected void zza(byte[] bArr, int i5, int i6, int i7) {
        System.arraycopy(this.zzb, 0, bArr, 0, i7);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahx
    final boolean zza(zzahm zzahmVar, int i5, int i6) {
        if (i6 > zzahmVar.zzb()) {
            int zzb = zzb();
            throw new IllegalArgumentException("Length too large: " + i6 + zzb);
        } else if (i6 > zzahmVar.zzb()) {
            int zzb2 = zzahmVar.zzb();
            throw new IllegalArgumentException("Ran off end of other: 0, " + i6 + ", " + zzb2);
        } else if (zzahmVar instanceof zzahw) {
            zzahw zzahwVar = (zzahw) zzahmVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzahwVar.zzb;
            int zzh = zzh() + i6;
            int zzh2 = zzh();
            int zzh3 = zzahwVar.zzh();
            while (zzh2 < zzh) {
                if (bArr[zzh2] != bArr2[zzh3]) {
                    return false;
                }
                zzh2++;
                zzh3++;
            }
            return true;
        } else {
            return zzahmVar.zza(0, i6).equals(zza(0, i6));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahm
    public byte zzb(int i5) {
        return this.zzb[i5];
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahm
    public int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahm
    protected final int zzb(int i5, int i6, int i7) {
        return zzajc.zza(i5, this.zzb, zzh(), i7);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahm
    public final zzaib zzc() {
        return zzaib.zza(this.zzb, zzh(), zzb(), true);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahm
    public final boolean zzf() {
        int zzh = zzh();
        return zzaml.zzc(this.zzb, zzh, zzb() + zzh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int zzh() {
        return 0;
    }
}
