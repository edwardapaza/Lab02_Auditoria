package com.google.android.gms.internal.common;

import com.google.android.gms.common.api.a;
import java.util.Arrays;
/* loaded from: classes.dex */
class zzaa extends zzab {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(int i5) {
    }

    public final zzaa zza(Object obj) {
        obj.getClass();
        int i5 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length >= i5) {
            if (this.zzc) {
                this.zza = (Object[]) objArr.clone();
            }
            Object[] objArr2 = this.zza;
            int i6 = this.zzb;
            this.zzb = i6 + 1;
            objArr2[i6] = obj;
            return this;
        }
        int i7 = length + (length >> 1) + 1;
        if (i7 < i5) {
            int highestOneBit = Integer.highestOneBit(i5 - 1);
            i7 = highestOneBit + highestOneBit;
        }
        if (i7 < 0) {
            i7 = a.e.API_PRIORITY_OTHER;
        }
        this.zza = Arrays.copyOf(objArr, i7);
        this.zzc = false;
        Object[] objArr22 = this.zza;
        int i62 = this.zzb;
        this.zzb = i62 + 1;
        objArr22[i62] = obj;
        return this;
    }
}
