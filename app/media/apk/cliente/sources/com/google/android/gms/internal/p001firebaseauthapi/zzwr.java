package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzwz;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwr  reason: invalid package */
/* loaded from: classes.dex */
public final class zzwr<T_WRAPPER extends zzwz<JcePrimitiveT>, JcePrimitiveT> {
    private final zzxa<JcePrimitiveT> zzh;
    public static final zzwr<zzxc, Cipher> zza = new zzwr<>(new zzxc());
    public static final zzwr<zzxg, Mac> zzb = new zzwr<>(new zzxg());
    private static final zzwr<zzxi, Signature> zzf = new zzwr<>(new zzxi());
    private static final zzwr<zzxf, MessageDigest> zzg = new zzwr<>(new zzxf());
    public static final zzwr<zzxb, KeyAgreement> zzc = new zzwr<>(new zzxb());
    public static final zzwr<zzxd, KeyPairGenerator> zzd = new zzwr<>(new zzxd());
    public static final zzwr<zzxe, KeyFactory> zze = new zzwr<>(new zzxe());

    private zzwr(T_WRAPPER t_wrapper) {
        this.zzh = zzic.zzb() ? new zzwy<>(t_wrapper) : zzxn.zza() ? new zzwu<>(t_wrapper) : new zzww<>(t_wrapper);
    }

    public static List<Provider> zza(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public final JcePrimitiveT zza(String str) {
        return this.zzh.zza(str);
    }
}
