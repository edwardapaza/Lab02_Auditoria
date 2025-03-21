package com.google.android.recaptcha.internal;

import android.app.Application;
import android.os.Build;
import d4.p;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.n;
import s3.t;
import v3.d;
/* loaded from: classes.dex */
final class zzal extends l implements p {
    final /* synthetic */ Application zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbd zzc;
    final /* synthetic */ zzbq zzd;
    final /* synthetic */ zzab zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzal(Application application, String str, zzbd zzbdVar, zzbq zzbqVar, zzab zzabVar, d dVar) {
        super(2, dVar);
        this.zza = application;
        this.zzb = str;
        this.zzc = zzbdVar;
        this.zzd = zzbqVar;
        this.zze = zzabVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzal(this.zza, this.zzb, this.zzc, this.zzd, this.zze, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzal) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        w3.d.c();
        n.b(obj);
        zzaf zzafVar = zzaf.zza;
        zzbd zzbdVar = this.zzc;
        Application application = this.zza;
        String zza = zzaf.zza(application);
        String packageName = application.getPackageName();
        String zzd = zzbdVar.zzd();
        zzq zzqVar = new zzq(application);
        int i5 = Build.VERSION.SDK_INT;
        String zza2 = zzqVar.zza("_GRECAPTCHA_KC");
        if (zza2 == null) {
            zza2 = "";
        }
        String encode = URLEncoder.encode(this.zzb, "UTF-8");
        String encode2 = URLEncoder.encode(packageName, "UTF-8");
        String encode3 = URLEncoder.encode(zza, "UTF-8");
        String encode4 = URLEncoder.encode("18.4.0", "UTF-8");
        String encode5 = URLEncoder.encode(zzd, "UTF-8");
        byte[] bytes = ("k=" + encode + "&pk=" + encode2 + "&mst=" + encode3 + "&msv=" + encode4 + "&msi=" + encode5 + "&mov=" + i5 + "&mkc=" + zza2).getBytes(Charset.forName("UTF-8"));
        zzbq zzbqVar = this.zzd;
        zzab zzabVar = this.zze;
        return zzbqVar.zza(zzabVar.zzb(), bytes, this.zzc);
    }
}
