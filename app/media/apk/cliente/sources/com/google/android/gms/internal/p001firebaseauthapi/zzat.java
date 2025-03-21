package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzat  reason: invalid package */
/* loaded from: classes.dex */
public final class zzat<K, V> {
    zzaw zza;
    private Object[] zzb;
    private int zzc;
    private boolean zzd;

    public zzat() {
        this(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzat(int i5) {
        this.zzb = new Object[i5 * 2];
        this.zzc = 0;
        this.zzd = false;
    }

    private final void zza(int i5) {
        int i6 = i5 << 1;
        Object[] objArr = this.zzb;
        if (i6 > objArr.length) {
            this.zzb = Arrays.copyOf(objArr, zzan.zza(objArr.length, i6));
            this.zzd = false;
        }
    }

    public final zzat<K, V> zza(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        if (iterable instanceof Collection) {
            zza(this.zzc + ((Collection) iterable).size());
        }
        for (Map.Entry<? extends K, ? extends V> entry : iterable) {
            K key = entry.getKey();
            V value = entry.getValue();
            zza(this.zzc + 1);
            zzaj.zza(key, value);
            Object[] objArr = this.zzb;
            int i5 = this.zzc;
            objArr[i5 * 2] = key;
            objArr[(i5 * 2) + 1] = value;
            this.zzc = i5 + 1;
        }
        return this;
    }

    public final zzau<K, V> zza() {
        zzaw zzawVar = this.zza;
        if (zzawVar == null) {
            int i5 = this.zzc;
            Object[] objArr = this.zzb;
            this.zzd = true;
            zzax zza = zzax.zza(i5, objArr, this);
            zzaw zzawVar2 = this.zza;
            if (zzawVar2 == null) {
                return zza;
            }
            throw zzawVar2.zza();
        }
        throw zzawVar.zza();
    }
}
