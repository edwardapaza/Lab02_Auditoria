package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajn  reason: invalid package */
/* loaded from: classes.dex */
final class zzajn<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzajk> zza;

    private zzajn(Map.Entry<K, zzajk> entry) {
        this.zza = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        return zzajk.zza();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzakk) {
            return this.zza.getValue().zza((zzakk) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzajk zza() {
        return this.zza.getValue();
    }
}
