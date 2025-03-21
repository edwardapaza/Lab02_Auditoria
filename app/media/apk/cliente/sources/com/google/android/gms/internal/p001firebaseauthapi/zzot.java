package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzot  reason: invalid package */
/* loaded from: classes.dex */
public final class zzot implements zzow {
    private final String zza;
    private final zzxr zzb;
    private final zzahm zzc;
    private final zzux.zzb zzd;
    private final zzvt zze;
    private final Integer zzf;

    private zzot(String str, zzahm zzahmVar, zzux.zzb zzbVar, zzvt zzvtVar, Integer num) {
        this.zza = str;
        this.zzb = zzpg.zzb(str);
        this.zzc = zzahmVar;
        this.zzd = zzbVar;
        this.zze = zzvtVar;
        this.zzf = num;
    }

    public static zzot zza(String str, zzahm zzahmVar, zzux.zzb zzbVar, zzvt zzvtVar, Integer num) {
        if (zzvtVar == zzvt.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzot(str, zzahmVar, zzbVar, zzvtVar, num);
    }

    public final zzux.zzb zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzow
    public final zzxr zzb() {
        return this.zzb;
    }

    public final zzvt zzc() {
        return this.zze;
    }

    public final zzahm zzd() {
        return this.zzc;
    }

    public final Integer zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zza;
    }
}
