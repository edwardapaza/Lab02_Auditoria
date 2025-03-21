package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkq  reason: invalid package */
/* loaded from: classes.dex */
public final class zzkq {
    public static final zzvd zza;
    private static final byte[] zzb;
    private static final zzvd zzc;
    private static final zzvd zzd;

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zztx zztxVar = zztx.NIST_P256;
        zzuc zzucVar = zzuc.SHA256;
        zztj zztjVar = zztj.UNCOMPRESSED;
        zzvd zzvdVar = zzcz.zza;
        zzvt zzvtVar = zzvt.TINK;
        zza = zza(zztxVar, zzucVar, zztjVar, zzvdVar, zzvtVar, bArr);
        zzc = zza(zztxVar, zzucVar, zztj.COMPRESSED, zzvdVar, zzvt.RAW, bArr);
        zzd = zza(zztxVar, zzucVar, zztjVar, zzcz.zzb, zzvtVar, bArr);
    }

    @Deprecated
    private static zzvd zza(zztx zztxVar, zzuc zzucVar, zztj zztjVar, zzvd zzvdVar, zzvt zzvtVar, byte[] bArr) {
        return (zzvd) ((zzaja) zzvd.zza().zza(new zzje().zzd()).zza(zzvtVar).zza(((zzto) ((zzaja) zzto.zza().zza((zztp) ((zzaja) zztp.zzc().zza((zztw) ((zzaja) zztw.zza().zza(zztxVar).zza(zzucVar).zza(zzahm.zza(bArr)).zzf())).zza((zztk) ((zzaja) zztk.zza().zza(zzvdVar).zzf())).zza(zztjVar).zzf())).zzf())).zzi()).zzf());
    }
}
