package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.Serializable;
import java.util.regex.Pattern;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzu  reason: invalid package */
/* loaded from: classes.dex */
final class zzu extends zzs implements Serializable {
    private final Pattern zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(Pattern pattern) {
        this.zza = (Pattern) zzz.zza(pattern);
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzs
    public final zzp zza(CharSequence charSequence) {
        return new zzt(this.zza.matcher(charSequence));
    }
}
