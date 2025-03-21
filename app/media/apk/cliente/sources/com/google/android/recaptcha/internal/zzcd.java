package com.google.android.recaptcha.internal;

import android.webkit.WebView;
import java.util.Arrays;
import m4.h;
import m4.j0;
/* loaded from: classes.dex */
public final class zzcd {
    private final WebView zza;
    private final j0 zzb;

    public zzcd(WebView webView, j0 j0Var) {
        this.zza = webView;
        this.zzb = j0Var;
    }

    public final void zzb(String str, String... strArr) {
        h.d(this.zzb, null, null, new zzcc((String[]) Arrays.copyOf(strArr, strArr.length), this, str, null), 3, null);
    }
}
