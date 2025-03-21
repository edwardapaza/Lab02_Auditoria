package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import com.google.android.gms.internal.p001firebaseauthapi.zzvh;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzby  reason: invalid package */
/* loaded from: classes.dex */
public final class zzby {
    private final zzvh zza;
    private final List<zzca> zzb;
    private final zzrl zzc = zzrl.zza;

    private zzby(zzvh zzvhVar, List<zzca> list) {
        this.zza = zzvhVar;
        this.zzb = list;
    }

    public static final zzby zza(zzcb zzcbVar, zzbh zzbhVar) {
        byte[] bArr = new byte[0];
        zzty zza = zzcbVar.zza();
        if (zza == null || zza.zzc().zzb() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return zza(zza(zza, zzbhVar, bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzby zza(zzvh zzvhVar) {
        zzc(zzvhVar);
        return new zzby(zzvhVar, zzb(zzvhVar));
    }

    private static zzot zza(zzvh.zza zzaVar) {
        try {
            return zzot.zza(zzaVar.zzb().zzf(), zzaVar.zzb().zze(), zzaVar.zzb().zzb(), zzaVar.zzf(), zzaVar.zzf() == zzvt.RAW ? null : Integer.valueOf(zzaVar.zza()));
        } catch (GeneralSecurityException e5) {
            throw new zzpe("Creating a protokey serialization failed", e5);
        }
    }

    private static zzty zza(zzvh zzvhVar, zzbh zzbhVar, byte[] bArr) {
        byte[] zzb = zzbhVar.zzb(zzvhVar.zzj(), bArr);
        try {
            if (zzvh.zza(zzbhVar.zza(zzb, bArr), zzaip.zza()).equals(zzvhVar)) {
                return (zzty) ((zzaja) zzty.zza().zza(zzahm.zza(zzb)).zza(zzcy.zza(zzvhVar)).zzf());
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (zzajj unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static zzvh zza(zzty zztyVar, zzbh zzbhVar, byte[] bArr) {
        try {
            zzvh zza = zzvh.zza(zzbhVar.zza(zztyVar.zzc().zzg(), bArr), zzaip.zza());
            zzc(zza);
            return zza;
        } catch (zzajj unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static <B> B zza(zzmm zzmmVar, zzbu zzbuVar, Class<B> cls) {
        try {
            return (B) zzmmVar.zza(zzbuVar, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    private static <B> B zza(zzmm zzmmVar, zzvh.zza zzaVar, Class<B> cls) {
        try {
            return (B) zzmmVar.zza(zzaVar.zzb(), cls);
        } catch (UnsupportedOperationException unused) {
            return null;
        } catch (GeneralSecurityException e5) {
            if (e5.getMessage().contains("No key manager found for key type ") || e5.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e5;
        }
    }

    private static List<zzca> zzb(zzvh zzvhVar) {
        zzbw zzbwVar;
        ArrayList arrayList = new ArrayList(zzvhVar.zza());
        for (zzvh.zza zzaVar : zzvhVar.zze()) {
            int zza = zzaVar.zza();
            try {
                zzbu zza2 = zznv.zza().zza(zza(zzaVar), zzct.zza());
                int i5 = zzbx.zza[zzaVar.zzc().ordinal()];
                if (i5 == 1) {
                    zzbwVar = zzbw.zza;
                } else if (i5 == 2) {
                    zzbwVar = zzbw.zzb;
                } else if (i5 != 3) {
                    throw new GeneralSecurityException("Unknown key status");
                    break;
                } else {
                    zzbwVar = zzbw.zzc;
                }
                arrayList.add(new zzca(zza2, zzbwVar, zza, zza == zzvhVar.zzb()));
            } catch (GeneralSecurityException unused) {
                arrayList.add(null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void zzc(zzvh zzvhVar) {
        if (zzvhVar == null || zzvhVar.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public final String toString() {
        return zzcy.zza(this.zza).toString();
    }

    public final zzby zza() {
        if (this.zza != null) {
            zzvh.zzb zzc = zzvh.zzc();
            for (zzvh.zza zzaVar : this.zza.zze()) {
                zzux zzb = zzaVar.zzb();
                if (zzb.zzb() != zzux.zzb.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("The keyset contains a non-private key");
                }
                zzc.zza((zzvh.zza) ((zzaja) zzaVar.zzm().zza(zzcu.zza(zzb.zzf(), zzb.zze())).zzf()));
            }
            zzc.zza(this.zza.zzb());
            return zza((zzvh) ((zzaja) zzc.zzf()));
        }
        throw new GeneralSecurityException("cleartext keyset is not available");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <P> P zza(Class<P> cls) {
        zzox zza = zzox.zza();
        if (zza instanceof zzmm) {
            Class<?> zza2 = zza.zza(cls);
            if (zza2 == null) {
                String name = cls.getName();
                throw new GeneralSecurityException("No wrapper found for " + name);
            }
            zzcy.zzb(this.zza);
            zzck zzckVar = new zzck(zza2);
            zzckVar.zza(this.zzc);
            for (int i5 = 0; i5 < this.zza.zza(); i5++) {
                zzvh.zza zza3 = this.zza.zza(i5);
                if (zza3.zzc().equals(zzvb.ENABLED)) {
                    Object zza4 = zza(zza, zza3, zza2);
                    Object zza5 = this.zzb.get(i5) != null ? zza(zza, this.zzb.get(i5).zza(), zza2) : null;
                    if (zza5 == null && zza4 == null) {
                        String valueOf = String.valueOf(zza2);
                        String zzf = zza3.zzb().zzf();
                        throw new GeneralSecurityException("Unable to get primitive " + valueOf + " for key of type " + zzf);
                    } else if (zza3.zza() == this.zza.zzb()) {
                        zzckVar.zzb(zza5, zza4, zza3);
                    } else {
                        zzckVar.zza(zza5, zza4, zza3);
                    }
                }
            }
            return (P) zza.zza(zzckVar.zza(), cls);
        }
        throw new GeneralSecurityException("Currently only subclasses of InternalConfiguration are accepted");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.p001firebaseauthapi.zzce r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.firebase-auth-api.zzvh r0 = r4.zza
            java.util.List r0 = r0.zze()
            java.util.Iterator r0 = r0.iterator()
        La:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L64
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.firebase-auth-api.zzvh$zza r1 = (com.google.android.gms.internal.p001firebaseauthapi.zzvh.zza) r1
            com.google.android.gms.internal.firebase-auth-api.zzux r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r3 = com.google.android.gms.internal.p001firebaseauthapi.zzux.zzb.UNKNOWN_KEYMATERIAL
            if (r2 == r3) goto L3b
            com.google.android.gms.internal.firebase-auth-api.zzux r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r3 = com.google.android.gms.internal.p001firebaseauthapi.zzux.zzb.SYMMETRIC
            if (r2 == r3) goto L3b
            com.google.android.gms.internal.firebase-auth-api.zzux r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r3 = com.google.android.gms.internal.p001firebaseauthapi.zzux.zzb.ASYMMETRIC_PRIVATE
            if (r2 == r3) goto L3b
            goto La
        L3b:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            com.google.android.gms.internal.firebase-auth-api.zzux r3 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r3 = r3.zzb()
            java.lang.String r3 = r3.name()
            r0[r2] = r3
            r2 = 1
            com.google.android.gms.internal.firebase-auth-api.zzux r1 = r1.zzb()
            java.lang.String r1 = r1.zzf()
            r0[r2] = r1
            java.lang.String r1 = "keyset contains key material of type %s for type url %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r5.<init>(r0)
            throw r5
        L64:
            com.google.android.gms.internal.firebase-auth-api.zzvh r0 = r4.zza
            r5.zza(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzby.zza(com.google.android.gms.internal.firebase-auth-api.zzce):void");
    }

    public final void zza(zzce zzceVar, zzbh zzbhVar) {
        zzceVar.zza(zza(this.zza, zzbhVar, new byte[0]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzvh zzb() {
        return this.zza;
    }

    public final zzvi zzc() {
        return zzcy.zza(this.zza);
    }
}
