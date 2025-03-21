package com.google.android.recaptcha.internal;

import java.util.TimerTask;
import m4.i;
import m4.j0;
/* loaded from: classes.dex */
public final class zzbj extends TimerTask {
    final /* synthetic */ zzbm zza;

    public zzbj(zzbm zzbmVar) {
        this.zza = zzbmVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        j0 j0Var;
        zzbm zzbmVar = this.zza;
        j0Var = zzbmVar.zzd;
        i.d(j0Var, null, null, new zzbk(zzbmVar, null), 3, null);
    }
}
