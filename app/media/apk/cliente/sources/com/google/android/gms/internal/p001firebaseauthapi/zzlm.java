package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlm  reason: invalid package */
/* loaded from: classes.dex */
final class zzlm extends zzna<zzuo, zzut> {
    private final /* synthetic */ zzlk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzlm(zzlk zzlkVar, Class cls) {
        super(cls);
        this.zza = zzlkVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzna
    public final /* synthetic */ zzuo zza(zzahm zzahmVar) {
        return zzuo.zza(zzahmVar, zzaip.zza());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzna
    public final /* synthetic */ zzut zza(zzuo zzuoVar) {
        byte[] zza;
        byte[] zza2;
        zzuo zzuoVar2 = zzuoVar;
        zzum zzc = zzuoVar2.zzc().zzc();
        int i5 = zzll.zza[zzc.ordinal()];
        if (i5 != 1) {
            if (i5 != 2 && i5 != 3 && i5 != 4) {
                throw new GeneralSecurityException("Invalid KEM");
            }
            zzwq zzc2 = zzlq.zzc(zzuoVar2.zzc().zzc());
            ECParameterSpec zza3 = zzwn.zza(zzc2);
            KeyPairGenerator zza4 = zzwr.zzd.zza("EC");
            zza4.initialize(zza3);
            KeyPair generateKeyPair = zza4.generateKeyPair();
            zzwp zzwpVar = zzwp.UNCOMPRESSED;
            ECPoint w5 = ((ECPublicKey) generateKeyPair.getPublic()).getW();
            EllipticCurve curve = zzwn.zza(zzc2).getCurve();
            zzmd.zza(w5, curve);
            int zza5 = zzwn.zza(curve);
            int ordinal = zzwpVar.ordinal();
            if (ordinal == 0) {
                int i6 = (zza5 * 2) + 1;
                byte[] bArr = new byte[i6];
                byte[] zza6 = zzmb.zza(w5.getAffineX());
                byte[] zza7 = zzmb.zza(w5.getAffineY());
                System.arraycopy(zza7, 0, bArr, i6 - zza7.length, zza7.length);
                System.arraycopy(zza6, 0, bArr, (zza5 + 1) - zza6.length, zza6.length);
                bArr[0] = 4;
                zza2 = bArr;
            } else if (ordinal == 1) {
                int i7 = zza5 + 1;
                zza2 = new byte[i7];
                byte[] zza8 = zzmb.zza(w5.getAffineX());
                System.arraycopy(zza8, 0, zza2, i7 - zza8.length, zza8.length);
                zza2[0] = (byte) (w5.getAffineY().testBit(0) ? 3 : 2);
            } else if (ordinal != 2) {
                String valueOf = String.valueOf(zzwpVar);
                throw new GeneralSecurityException("invalid format:" + valueOf);
            } else {
                int i8 = zza5 * 2;
                zza2 = new byte[i8];
                byte[] zza9 = zzmb.zza(w5.getAffineX());
                if (zza9.length > zza5) {
                    zza9 = Arrays.copyOfRange(zza9, zza9.length - zza5, zza9.length);
                }
                byte[] zza10 = zzmb.zza(w5.getAffineY());
                if (zza10.length > zza5) {
                    zza10 = Arrays.copyOfRange(zza10, zza10.length - zza5, zza10.length);
                }
                System.arraycopy(zza10, 0, zza2, i8 - zza10.length, zza10.length);
                System.arraycopy(zza9, 0, zza2, zza5 - zza9.length, zza9.length);
            }
            zza = zzmb.zza(((ECPrivateKey) generateKeyPair.getPrivate()).getS(), zzlq.zza(zzc));
        } else {
            zza = zzov.zza(32);
            zza[0] = (byte) (zza[0] | 7);
            byte b5 = (byte) (zza[31] & 63);
            zza[31] = b5;
            zza[31] = (byte) (b5 | 128);
            zza2 = zzxp.zza(zza);
        }
        return (zzut) ((zzaja) zzut.zzb().zza(0).zza((zzuw) ((zzaja) zzuw.zzc().zza(0).zza(zzuoVar2.zzc()).zza(zzahm.zza(zza2)).zzf())).zza(zzahm.zza(zza)).zzf());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzna
    public final /* synthetic */ void zzb(zzuo zzuoVar) {
        zzlq.zza(zzuoVar.zzc());
    }
}
