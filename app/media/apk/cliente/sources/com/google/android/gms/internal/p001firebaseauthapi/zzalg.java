package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalg  reason: invalid package */
/* loaded from: classes.dex */
public final class zzalg extends zzalh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalg(int i5) {
        super(i5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzalh
    public final void zza() {
        if (!zze()) {
            for (int i5 = 0; i5 < zzb(); i5++) {
                Map.Entry zzb = zzb(i5);
                if (((zzaiu) zzb.getKey()).zze()) {
                    zzb.setValue(Collections.unmodifiableList((List) zzb.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzaiu) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
