package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzvh;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzck  reason: invalid package */
/* loaded from: classes.dex */
public final class zzck<P> {
    private final Class<P> zza;
    private ConcurrentMap<zzcl, List<zzcm<P>>> zzb;
    private final List<zzcm<P>> zzc;
    private zzcm<P> zzd;
    private zzrl zze;

    private zzck(Class<P> cls) {
        this.zzb = new ConcurrentHashMap();
        this.zzc = new ArrayList();
        this.zza = cls;
        this.zze = zzrl.zza;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.internal.p001firebaseauthapi.zzck<P> zza(P r13, P r14, com.google.android.gms.internal.p001firebaseauthapi.zzvh.zza r15, boolean r16) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzck.zza(java.lang.Object, java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzvh$zza, boolean):com.google.android.gms.internal.firebase-auth-api.zzck");
    }

    public final zzch<P> zza() {
        ConcurrentMap<zzcl, List<zzcm<P>>> concurrentMap = this.zzb;
        if (concurrentMap != null) {
            zzch<P> zzchVar = new zzch<>(concurrentMap, this.zzc, this.zzd, this.zze, this.zza);
            this.zzb = null;
            return zzchVar;
        }
        throw new IllegalStateException("build cannot be called twice");
    }

    public final zzck<P> zza(zzrl zzrlVar) {
        if (this.zzb != null) {
            this.zze = zzrlVar;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build");
    }

    public final zzck<P> zza(P p5, P p6, zzvh.zza zzaVar) {
        return zza(p5, p6, zzaVar, false);
    }

    public final zzck<P> zzb(P p5, P p6, zzvh.zza zzaVar) {
        return zza(p5, p6, zzaVar, true);
    }
}
