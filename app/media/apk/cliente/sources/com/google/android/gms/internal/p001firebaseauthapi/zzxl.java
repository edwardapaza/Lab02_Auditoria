package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxl  reason: invalid package */
/* loaded from: classes.dex */
public final class zzxl extends ThreadLocal<Mac> {
    private final /* synthetic */ zzxm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxl(zzxm zzxmVar) {
        this.zza = zzxmVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.ThreadLocal
    /* renamed from: zza */
    public final Mac initialValue() {
        String str;
        Key key;
        try {
            zzwr<zzxg, Mac> zzwrVar = zzwr.zzb;
            str = this.zza.zzc;
            Mac zza = zzwrVar.zza(str);
            key = this.zza.zzd;
            zza.init(key);
            return zza;
        } catch (GeneralSecurityException e5) {
            throw new IllegalStateException(e5);
        }
    }
}
