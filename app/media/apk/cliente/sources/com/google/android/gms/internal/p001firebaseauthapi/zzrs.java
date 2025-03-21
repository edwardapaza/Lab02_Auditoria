package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;
import java.util.Objects;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrs  reason: invalid package */
/* loaded from: classes.dex */
public final class zzrs {
    private final zzrl zza;
    private final List<zzru> zzb;
    private final Integer zzc;

    private zzrs(zzrl zzrlVar, List<zzru> list, Integer num) {
        this.zza = zzrlVar;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzrs) {
            zzrs zzrsVar = (zzrs) obj;
            return this.zza.equals(zzrsVar.zza) && this.zzb.equals(zzrsVar.zzb) && Objects.equals(this.zzc, zzrsVar.zzc);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", this.zza, this.zzb, this.zzc);
    }
}
