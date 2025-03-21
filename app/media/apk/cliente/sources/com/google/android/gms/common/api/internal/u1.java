package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class u1 extends o.s implements i {

    /* renamed from: l0  reason: collision with root package name */
    private static final WeakHashMap f1051l0 = new WeakHashMap();

    /* renamed from: i0  reason: collision with root package name */
    private final Map f1052i0 = Collections.synchronizedMap(new androidx.collection.a());

    /* renamed from: j0  reason: collision with root package name */
    private int f1053j0 = 0;

    /* renamed from: k0  reason: collision with root package name */
    private Bundle f1054k0;

    public static u1 F1(o.x xVar) {
        u1 u1Var;
        WeakHashMap weakHashMap = f1051l0;
        WeakReference weakReference = (WeakReference) weakHashMap.get(xVar);
        if (weakReference == null || (u1Var = (u1) weakReference.get()) == null) {
            try {
                u1 u1Var2 = (u1) xVar.O().i0("SupportLifecycleFragmentImpl");
                if (u1Var2 == null || u1Var2.e0()) {
                    u1Var2 = new u1();
                    xVar.O().n().d(u1Var2, "SupportLifecycleFragmentImpl").g();
                }
                weakHashMap.put(xVar, new WeakReference(u1Var2));
                return u1Var2;
            } catch (ClassCastException e5) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e5);
            }
        }
        return u1Var;
    }

    @Override // o.s
    public final void J0() {
        super.J0();
        this.f1053j0 = 3;
        for (LifecycleCallback lifecycleCallback : this.f1052i0.values()) {
            lifecycleCallback.onResume();
        }
    }

    @Override // o.s
    public final void K0(Bundle bundle) {
        super.K0(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f1052i0.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).onSaveInstanceState(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // o.s
    public final void L0() {
        super.L0();
        this.f1053j0 = 2;
        for (LifecycleCallback lifecycleCallback : this.f1052i0.values()) {
            lifecycleCallback.onStart();
        }
    }

    @Override // o.s
    public final void M0() {
        super.M0();
        this.f1053j0 = 4;
        for (LifecycleCallback lifecycleCallback : this.f1052i0.values()) {
            lifecycleCallback.onStop();
        }
    }

    @Override // com.google.android.gms.common.api.internal.i
    public final void b(String str, LifecycleCallback lifecycleCallback) {
        if (this.f1052i0.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f1052i0.put(str, lifecycleCallback);
        if (this.f1053j0 > 0) {
            new zzi(Looper.getMainLooper()).post(new t1(this, lifecycleCallback, str));
        }
    }

    @Override // com.google.android.gms.common.api.internal.i
    public final <T extends LifecycleCallback> T c(String str, Class<T> cls) {
        return cls.cast(this.f1052i0.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.i
    public final /* synthetic */ Activity d() {
        return n();
    }

    @Override // o.s
    public final void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.i(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f1052i0.values()) {
            lifecycleCallback.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // o.s
    public final void j0(int i5, int i6, Intent intent) {
        super.j0(i5, i6, intent);
        for (LifecycleCallback lifecycleCallback : this.f1052i0.values()) {
            lifecycleCallback.onActivityResult(i5, i6, intent);
        }
    }

    @Override // o.s
    public final void o0(Bundle bundle) {
        super.o0(bundle);
        this.f1053j0 = 1;
        this.f1054k0 = bundle;
        for (Map.Entry entry : this.f1052i0.entrySet()) {
            ((LifecycleCallback) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // o.s
    public final void t0() {
        super.t0();
        this.f1053j0 = 5;
        for (LifecycleCallback lifecycleCallback : this.f1052i0.values()) {
            lifecycleCallback.onDestroy();
        }
    }
}
