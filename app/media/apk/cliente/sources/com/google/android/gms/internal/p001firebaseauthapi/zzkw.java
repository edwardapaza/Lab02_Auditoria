package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzsh;
import com.google.android.gms.internal.p001firebaseauthapi.zzst;
import com.google.android.gms.internal.p001firebaseauthapi.zztb;
import com.google.android.gms.internal.p001firebaseauthapi.zzue;
import java.security.GeneralSecurityException;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkw  reason: invalid package */
/* loaded from: classes.dex */
final class zzkw implements zzwk {
    private final String zza;
    private final int zzb;
    private zzst zzc;
    private zzsd zzd;
    private int zze;
    private zztb zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkw(zzvd zzvdVar) {
        String zzf = zzvdVar.zzf();
        this.zza = zzf;
        if (zzf.equals(zzcx.zzb)) {
            try {
                zzsw zza = zzsw.zza(zzvdVar.zze(), zzaip.zza());
                this.zzc = zzst.zza(zzcu.zza(zzvdVar).zze(), zzaip.zza());
                this.zzb = zza.zza();
            } catch (zzajj e5) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e5);
            }
        } else if (zzf.equals(zzcx.zza)) {
            try {
                zzsg zza2 = zzsg.zza(zzvdVar.zze(), zzaip.zza());
                this.zzd = zzsd.zza(zzcu.zza(zzvdVar).zze(), zzaip.zza());
                this.zze = zza2.zzc().zza();
                this.zzb = this.zze + zza2.zzd().zza();
            } catch (zzajj e6) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e6);
            }
        } else if (!zzf.equals(zzis.zza)) {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: " + zzf);
        } else {
            try {
                zzte zza3 = zzte.zza(zzvdVar.zze(), zzaip.zza());
                this.zzf = zztb.zza(zzcu.zza(zzvdVar).zze(), zzaip.zza());
                this.zzb = zza3.zza();
            } catch (zzajj e7) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e7);
            }
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzwk
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzwk
    public final zzlv zza(byte[] bArr) {
        if (bArr.length == this.zzb) {
            if (this.zza.equals(zzcx.zzb)) {
                return new zzlv((zzbh) zzcu.zza(this.zza, ((zzst) ((zzaja) zzst.zzb().zza((zzst.zza) this.zzc).zza(zzahm.zza(bArr, 0, this.zzb)).zzf())).zzi(), zzbh.class));
            }
            if (!this.zza.equals(zzcx.zza)) {
                if (this.zza.equals(zzis.zza)) {
                    return new zzlv((zzbq) zzcu.zza(this.zza, ((zztb) ((zzaja) zztb.zzb().zza((zztb.zza) this.zzf).zza(zzahm.zza(bArr, 0, this.zzb)).zzf())).zzi(), zzbq.class));
                }
                throw new GeneralSecurityException("unknown DEM key type");
            }
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
            return new zzlv((zzbh) zzcu.zza(this.zza, ((zzsd) ((zzaja) zzsd.zzb().zza(this.zzd.zza()).zza((zzsh) ((zzaja) zzsh.zzb().zza((zzsh.zza) this.zzd.zzd()).zza(zzahm.zza(copyOfRange)).zzf())).zza((zzue) ((zzaja) zzue.zzb().zza((zzue.zza) this.zzd.zze()).zza(zzahm.zza(copyOfRange2)).zzf())).zzf())).zzi(), zzbh.class));
        }
        throw new GeneralSecurityException("Symmetric key has incorrect length");
    }
}
