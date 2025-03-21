package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzmn;
import java.util.Collections;
import java.util.Set;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmq  reason: invalid package */
/* loaded from: classes.dex */
final class zzmq implements zzmn.zza {
    private final /* synthetic */ zzbt zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmq(zzbt zzbtVar) {
        this.zza = zzbtVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmn.zza
    public final zzbt<?> zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmn.zza
    public final <Q> zzbt<Q> zza(Class<Q> cls) {
        if (this.zza.zza().equals(cls)) {
            return this.zza;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmn.zza
    public final Class<?> zzb() {
        return this.zza.getClass();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmn.zza
    public final Set<Class<?>> zzc() {
        return Collections.singleton(this.zza.zza());
    }
}
