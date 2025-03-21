package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
final class zzv extends LifecycleCallback {
    private final List zza;

    private zzv(i iVar) {
        super(iVar);
        this.zza = new ArrayList();
        this.mLifecycleFragment.b("TaskOnStopCallback", this);
    }

    public static zzv zza(Activity activity) {
        zzv zzvVar;
        i fragment = LifecycleCallback.getFragment(activity);
        synchronized (fragment) {
            zzvVar = (zzv) fragment.c("TaskOnStopCallback", zzv.class);
            if (zzvVar == null) {
                zzvVar = new zzv(fragment);
            }
        }
        return zzvVar;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        synchronized (this.zza) {
            for (WeakReference weakReference : this.zza) {
                zzq zzqVar = (zzq) weakReference.get();
                if (zzqVar != null) {
                    zzqVar.zzc();
                }
            }
            this.zza.clear();
        }
    }

    public final void zzb(zzq zzqVar) {
        synchronized (this.zza) {
            this.zza.add(new WeakReference(zzqVar));
        }
    }
}
