package com.google.android.gms.internal.p001firebaseauthapi;

import java.net.URL;
import java.net.URLConnection;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zze  reason: invalid package */
/* loaded from: classes.dex */
final class zze extends zzb {
    private zze() {
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzb
    public final URLConnection zza(URL url, String str) {
        return url.openConnection();
    }
}
