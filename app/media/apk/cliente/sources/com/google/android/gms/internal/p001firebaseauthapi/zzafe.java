package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafe  reason: invalid package */
/* loaded from: classes.dex */
public final class zzafe {
    private List<zzafb> zza;

    public zzafe() {
        this.zza = new ArrayList();
    }

    public zzafe(List<zzafb> list) {
        this.zza = Collections.unmodifiableList(list);
    }

    public final List<zzafb> zza() {
        return this.zza;
    }
}
