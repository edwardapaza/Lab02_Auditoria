package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzfo;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfl  reason: invalid package */
/* loaded from: classes.dex */
public final class zzfl extends zzda {
    private final zzfo zza;
    private final zzxt zzb;
    private final zzxr zzc;
    private final Integer zzd;

    private zzfl(zzfo zzfoVar, zzxt zzxtVar, zzxr zzxrVar, Integer num) {
        this.zza = zzfoVar;
        this.zzb = zzxtVar;
        this.zzc = zzxrVar;
        this.zzd = num;
    }

    public static zzfl zza(zzfo.zza zzaVar, zzxt zzxtVar, Integer num) {
        zzxr zza;
        zzfo.zza zzaVar2 = zzfo.zza.zzc;
        if (zzaVar != zzaVar2 && num == null) {
            String valueOf = String.valueOf(zzaVar);
            throw new GeneralSecurityException("For given Variant " + valueOf + " the value of idRequirement must be non-null");
        } else if (zzaVar != zzaVar2 || num == null) {
            if (zzxtVar.zza() != 32) {
                int zza2 = zzxtVar.zza();
                throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza2);
            }
            zzfo zza3 = zzfo.zza(zzaVar);
            if (zza3.zzb() == zzaVar2) {
                zza = zzxr.zza(new byte[0]);
            } else if (zza3.zzb() == zzfo.zza.zzb) {
                zza = zzxr.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (zza3.zzb() != zzfo.zza.zza) {
                String valueOf2 = String.valueOf(zza3.zzb());
                throw new IllegalStateException("Unknown Variant: " + valueOf2);
            } else {
                zza = zzxr.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            }
            return new zzfl(zza3, zzxtVar, zza, num);
        } else {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbu
    public final Integer zza() {
        return this.zzd;
    }

    public final zzfo zzb() {
        return this.zza;
    }

    public final zzxr zzc() {
        return this.zzc;
    }

    public final zzxt zzd() {
        return this.zzb;
    }
}
