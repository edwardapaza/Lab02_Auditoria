package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import q0.m;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagn  reason: invalid package */
/* loaded from: classes.dex */
public final class zzagn {
    private final int zza;
    private List<String> zzb;

    public zzagn() {
        this(null);
    }

    public zzagn(int i5, List<String> list) {
        List<String> emptyList;
        this.zza = 1;
        if (list == null || list.isEmpty()) {
            emptyList = Collections.emptyList();
        } else {
            for (int i6 = 0; i6 < list.size(); i6++) {
                list.set(i6, m.a(list.get(i6)));
            }
            emptyList = Collections.unmodifiableList(list);
        }
        this.zzb = emptyList;
    }

    private zzagn(List<String> list) {
        this.zza = 1;
        this.zzb = new ArrayList();
    }

    public static zzagn zza() {
        return new zzagn(null);
    }

    public final List<String> zzb() {
        return this.zzb;
    }
}
