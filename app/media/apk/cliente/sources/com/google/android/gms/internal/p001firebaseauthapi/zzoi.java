package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzakk;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoi  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzoi<PrimitiveT, KeyProtoT extends zzakk> {
    private final Class<PrimitiveT> zza;

    public zzoi(Class<PrimitiveT> cls) {
        this.zza = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Class<PrimitiveT> zza() {
        return this.zza;
    }

    public abstract PrimitiveT zza(KeyProtoT keyprotot);
}
