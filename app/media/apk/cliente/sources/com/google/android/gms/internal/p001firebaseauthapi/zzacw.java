package com.google.android.gms.internal.p001firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.internal.q;
import com.google.firebase.auth.a0;
import com.google.firebase.auth.h;
import com.google.firebase.auth.q0;
import f1.f;
import j1.x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacw  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzacw<ResultT, CallbackT> implements zzadh<ResultT> {
    protected final int zza;
    private ResultT zzaa;
    private Status zzab;
    protected f zzc;
    protected a0 zzd;
    protected CallbackT zze;
    protected x zzf;
    protected zzacx<ResultT> zzg;
    protected Executor zzi;
    protected zzafm zzj;
    protected zzafb zzk;
    protected zzaem zzl;
    protected zzafv zzm;
    protected String zzn;
    protected String zzo;
    protected h zzp;
    protected String zzq;
    protected String zzr;
    protected zzyi zzs;
    protected zzafj zzt;
    protected zzafi zzu;
    protected zzagi zzv;
    protected zzaga zzw;
    boolean zzx;
    private boolean zzz;
    protected final zzacy zzb = new zzacy(this);
    protected final List<q0.b> zzh = new ArrayList();
    private boolean zzy = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacw$zza */
    /* loaded from: classes.dex */
    public static class zza extends LifecycleCallback {
        private final List<q0.b> zza;

        private zza(i iVar, List<q0.b> list) {
            super(iVar);
            this.mLifecycleFragment.b("PhoneAuthActivityStopCallback", this);
            this.zza = list;
        }

        public static void zza(Activity activity, List<q0.b> list) {
            i fragment = LifecycleCallback.getFragment(activity);
            if (((zza) fragment.c("PhoneAuthActivityStopCallback", zza.class)) == null) {
                new zza(fragment, list);
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void onStop() {
            synchronized (this.zza) {
                this.zza.clear();
            }
        }
    }

    public zzacw(int i5) {
        this.zza = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzacw zzacwVar) {
        zzacwVar.zzb();
        q.n(zzacwVar.zzz, "no success or failure set on method implementation");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzacw zzacwVar, Status status) {
        x xVar = zzacwVar.zzf;
        if (xVar != null) {
            xVar.zza(status);
        }
    }

    public final zzacw<ResultT, CallbackT> zza(a0 a0Var) {
        this.zzd = (a0) q.l(a0Var, "firebaseUser cannot be null");
        return this;
    }

    public final zzacw<ResultT, CallbackT> zza(q0.b bVar, Activity activity, Executor executor, String str) {
        q0.b zza2 = zzads.zza(str, bVar, this);
        synchronized (this.zzh) {
            this.zzh.add((q0.b) q.k(zza2));
        }
        if (activity != null) {
            zza.zza(activity, this.zzh);
        }
        this.zzi = (Executor) q.k(executor);
        return this;
    }

    public final zzacw<ResultT, CallbackT> zza(f fVar) {
        this.zzc = (f) q.l(fVar, "firebaseApp cannot be null");
        return this;
    }

    public final zzacw<ResultT, CallbackT> zza(x xVar) {
        this.zzf = (x) q.l(xVar, "external failure callback cannot be null");
        return this;
    }

    public final zzacw<ResultT, CallbackT> zza(CallbackT callbackt) {
        this.zze = (CallbackT) q.l(callbackt, "external callback cannot be null");
        return this;
    }

    public final void zza(Status status) {
        this.zzz = true;
        this.zzx = false;
        this.zzab = status;
        this.zzg.zza(null, status);
    }

    public abstract void zzb();

    public final void zzb(ResultT resultt) {
        this.zzz = true;
        this.zzx = true;
        this.zzaa = resultt;
        this.zzg.zza(resultt, null);
    }
}
