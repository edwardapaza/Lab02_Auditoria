package com.google.android.recaptcha.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzku extends zzle {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzku(int i5) {
        super(i5, null);
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public final void zza() {
        if (!zzj()) {
            for (int i5 = 0; i5 < zzb(); i5++) {
                ((zzii) zzg(i5).getKey()).zzg();
            }
            for (Map.Entry entry : zzc()) {
                ((zzii) entry.getKey()).zzg();
            }
        }
        super.zza();
    }
}
