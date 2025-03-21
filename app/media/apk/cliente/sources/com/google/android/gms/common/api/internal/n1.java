package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.base.zaq;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public abstract class n1 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    protected volatile boolean f1012a;

    /* renamed from: b  reason: collision with root package name */
    protected final AtomicReference<j1> f1013b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f1014c;

    /* renamed from: d  reason: collision with root package name */
    protected final l0.f f1015d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n1(i iVar, l0.f fVar) {
        super(iVar);
        this.f1013b = new AtomicReference<>(null);
        this.f1014c = new zaq(Looper.getMainLooper());
        this.f1015d = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(l0.a aVar, int i5) {
        this.f1013b.set(null);
        b(aVar, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        this.f1013b.set(null);
        c();
    }

    private static final int e(j1 j1Var) {
        if (j1Var == null) {
            return -1;
        }
        return j1Var.a();
    }

    protected abstract void b(l0.a aVar, int i5);

    protected abstract void c();

    public final void h(l0.a aVar, int i5) {
        j1 j1Var = new j1(aVar, i5);
        if (m1.a(this.f1013b, null, j1Var)) {
            this.f1014c.post(new l1(this, j1Var));
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onActivityResult(int i5, int i6, Intent intent) {
        j1 j1Var = this.f1013b.get();
        if (i5 != 1) {
            if (i5 == 2) {
                int f5 = this.f1015d.f(getActivity());
                if (f5 == 0) {
                    d();
                    return;
                } else if (j1Var == null) {
                    return;
                } else {
                    if (j1Var.b().t() == 18 && f5 == 18) {
                        return;
                    }
                }
            }
        } else if (i6 == -1) {
            d();
            return;
        } else if (i6 == 0) {
            if (j1Var == null) {
                return;
            }
            a(new l0.a(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, j1Var.b().toString()), e(j1Var));
            return;
        }
        if (j1Var != null) {
            a(j1Var.b(), j1Var.a());
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        a(new l0.a(13, null), e(this.f1013b.get()));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f1013b.set(bundle.getBoolean("resolving_error", false) ? new j1(new l0.a(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        j1 j1Var = this.f1013b.get();
        if (j1Var == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", j1Var.a());
        bundle.putInt("failed_status", j1Var.b().t());
        bundle.putParcelable("failed_resolution", j1Var.b().v());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.f1012a = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.f1012a = false;
    }
}
