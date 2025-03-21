package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzmn;
import java.security.GeneralSecurityException;
import java.util.Set;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmr  reason: invalid package */
/* loaded from: classes.dex */
final class zzmr implements zzmn.zza {
    private final /* synthetic */ zzoq zza;
    private final /* synthetic */ zznb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmr(zzoq zzoqVar, zznb zznbVar) {
        this.zza = zzoqVar;
        this.zzb = zznbVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmn.zza
    public final zzbt<?> zza() {
        zzoq zzoqVar = this.zza;
        return new zzor(zzoqVar, this.zzb, zzoqVar.zze());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmn.zza
    public final <Q> zzbt<Q> zza(Class<Q> cls) {
        try {
            return new zzor(this.zza, this.zzb, cls);
        } catch (IllegalArgumentException e5) {
            throw new GeneralSecurityException("Primitive type not supported", e5);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmn.zza
    public final Class<?> zzb() {
        return this.zza.getClass();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmn.zza
    public final Set<Class<?>> zzc() {
        return this.zza.zzg();
    }
}
