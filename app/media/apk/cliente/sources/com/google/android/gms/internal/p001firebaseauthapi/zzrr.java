package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrr  reason: invalid package */
/* loaded from: classes.dex */
public final class zzrr {
    private ArrayList<zzru> zza = new ArrayList<>();
    private zzrl zzb = zzrl.zza;
    private Integer zzc = null;

    public final zzrr zza(int i5) {
        if (this.zza != null) {
            this.zzc = Integer.valueOf(i5);
            return this;
        }
        throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
    }

    public final zzrr zza(zzbw zzbwVar, int i5, String str, String str2) {
        ArrayList<zzru> arrayList = this.zza;
        if (arrayList != null) {
            arrayList.add(new zzru(zzbwVar, i5, str, str2));
            return this;
        }
        throw new IllegalStateException("addEntry cannot be called after build()");
    }

    public final zzrr zza(zzrl zzrlVar) {
        if (this.zza != null) {
            this.zzb = zzrlVar;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build()");
    }

    public final zzrs zza() {
        if (this.zza != null) {
            Integer num = this.zzc;
            if (num != null) {
                int intValue = num.intValue();
                ArrayList<zzru> arrayList = this.zza;
                int size = arrayList.size();
                boolean z4 = false;
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    zzru zzruVar = arrayList.get(i5);
                    i5++;
                    if (zzruVar.zza() == intValue) {
                        z4 = true;
                        break;
                    }
                }
                if (!z4) {
                    throw new GeneralSecurityException("primary key ID is not present in entries");
                }
            }
            zzrs zzrsVar = new zzrs(this.zzb, Collections.unmodifiableList(this.zza), this.zzc);
            this.zza = null;
            return zzrsVar;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
