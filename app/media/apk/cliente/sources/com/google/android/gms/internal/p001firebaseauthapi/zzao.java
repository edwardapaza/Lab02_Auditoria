package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzao  reason: invalid package */
/* loaded from: classes.dex */
class zzao<E> extends zzan<E> {
    Object[] zza;
    int zzb;
    boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao(int i5) {
        zzaj.zza(4, "initialCapacity");
        this.zza = new Object[4];
        this.zzb = 0;
    }

    public zzao<E> zza(E e5) {
        zzz.zza(e5);
        int i5 = this.zzb + 1;
        Object[] objArr = this.zza;
        if (objArr.length >= i5) {
            if (this.zzc) {
                this.zza = (Object[]) objArr.clone();
            }
            Object[] objArr2 = this.zza;
            int i6 = this.zzb;
            this.zzb = i6 + 1;
            objArr2[i6] = e5;
            return this;
        }
        this.zza = Arrays.copyOf(objArr, zzan.zza(objArr.length, i5));
        this.zzc = false;
        Object[] objArr22 = this.zza;
        int i62 = this.zzb;
        this.zzb = i62 + 1;
        objArr22[i62] = e5;
        return this;
    }
}
