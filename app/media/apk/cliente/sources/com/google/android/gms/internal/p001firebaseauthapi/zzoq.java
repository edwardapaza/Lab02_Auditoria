package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzakk;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoq  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzoq<KeyProtoT extends zzakk, PublicKeyProtoT extends zzakk> extends zznb<KeyProtoT> {
    private final Class<PublicKeyProtoT> zza;

    /* JADX INFO: Access modifiers changed from: protected */
    @SafeVarargs
    public zzoq(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, zzoi<?, KeyProtoT>... zzoiVarArr) {
        super(cls, zzoiVarArr);
        this.zza = cls2;
    }

    public abstract PublicKeyProtoT zza(KeyProtoT keyprotot);
}
