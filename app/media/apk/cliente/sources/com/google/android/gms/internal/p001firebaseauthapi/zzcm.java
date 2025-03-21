package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcm  reason: invalid package */
/* loaded from: classes.dex */
public final class zzcm<P> {
    private final P zza;
    private final P zzb;
    private final byte[] zzc;
    private final zzvb zzd;
    private final zzvt zze;
    private final int zzf;
    private final String zzg;
    private final zzbu zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcm(P p5, P p6, byte[] bArr, zzvb zzvbVar, zzvt zzvtVar, int i5, String str, zzbu zzbuVar) {
        this.zza = p5;
        this.zzb = p6;
        this.zzc = Arrays.copyOf(bArr, bArr.length);
        this.zzd = zzvbVar;
        this.zze = zzvtVar;
        this.zzf = i5;
        this.zzg = str;
        this.zzh = zzbuVar;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzbu zzb() {
        return this.zzh;
    }

    public final zzvb zzc() {
        return this.zzd;
    }

    public final zzvt zzd() {
        return this.zze;
    }

    public final P zze() {
        return this.zza;
    }

    public final P zzf() {
        return this.zzb;
    }

    public final String zzg() {
        return this.zzg;
    }

    public final byte[] zzh() {
        byte[] bArr = this.zzc;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
