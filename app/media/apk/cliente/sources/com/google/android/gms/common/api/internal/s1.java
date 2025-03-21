package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
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
public final class s1 extends Fragment implements i {

    /* renamed from: d  reason: collision with root package name */
    private static final WeakHashMap f1037d = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final Map f1038a = Collections.synchronizedMap(new androidx.collection.a());

    /* renamed from: b  reason: collision with root package name */
    private int f1039b = 0;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f1040c;

    public static s1 f(Activity activity) {
        s1 s1Var;
        WeakHashMap weakHashMap = f1037d;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference == null || (s1Var = (s1) weakReference.get()) == null) {
            try {
                s1 s1Var2 = (s1) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (s1Var2 == null || s1Var2.isRemoving()) {
                    s1Var2 = new s1();
                    activity.getFragmentManager().beginTransaction().add(s1Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                weakHashMap.put(activity, new WeakReference(s1Var2));
                return s1Var2;
            } catch (ClassCastException e5) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e5);
            }
        }
        return s1Var;
    }

    @Override // com.google.android.gms.common.api.internal.i
    public final void b(String str, LifecycleCallback lifecycleCallback) {
        if (this.f1038a.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f1038a.put(str, lifecycleCallback);
        if (this.f1039b > 0) {
            new zzi(Looper.getMainLooper()).post(new r1(this, lifecycleCallback, str));
        }
    }

    @Override // com.google.android.gms.common.api.internal.i
    public final <T extends LifecycleCallback> T c(String str, Class<T> cls) {
        return cls.cast(this.f1038a.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.i
    public final Activity d() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f1038a.values()) {
            lifecycleCallback.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        for (LifecycleCallback lifecycleCallback : this.f1038a.values()) {
            lifecycleCallback.onActivityResult(i5, i6, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1039b = 1;
        this.f1040c = bundle;
        for (Map.Entry entry : this.f1038a.entrySet()) {
            ((LifecycleCallback) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f1039b = 5;
        for (LifecycleCallback lifecycleCallback : this.f1038a.values()) {
            lifecycleCallback.onDestroy();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f1039b = 3;
        for (LifecycleCallback lifecycleCallback : this.f1038a.values()) {
            lifecycleCallback.onResume();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f1038a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).onSaveInstanceState(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f1039b = 2;
        for (LifecycleCallback lifecycleCallback : this.f1038a.values()) {
            lifecycleCallback.onStart();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f1039b = 4;
        for (LifecycleCallback lifecycleCallback : this.f1038a.values()) {
            lifecycleCallback.onStop();
        }
    }
}
