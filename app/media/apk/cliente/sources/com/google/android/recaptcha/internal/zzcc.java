package com.google.android.recaptcha.internal;

import android.webkit.WebView;
import d4.p;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.n;
import s3.t;
import t3.x;
import v3.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcc extends l implements p {
    final /* synthetic */ String[] zza;
    final /* synthetic */ zzcd zzb;
    final /* synthetic */ String zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcc(String[] strArr, zzcd zzcdVar, String str, d dVar) {
        super(2, dVar);
        this.zza = strArr;
        this.zzb = zzcdVar;
        this.zzc = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzcc(this.zza, this.zzb, this.zzc, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzcc) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        WebView webView;
        String w5;
        w3.d.c();
        n.b(obj);
        String[] strArr = this.zza;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("\"" + str + "\"");
        }
        zzcd zzcdVar = this.zzb;
        String str2 = this.zzc;
        webView = zzcdVar.zza;
        w5 = x.w(arrayList, ",", null, null, 0, null, null, 62, null);
        webView.evaluateJavascript(str2 + "(" + w5 + ")", null);
        return t.f7573a;
    }
}
