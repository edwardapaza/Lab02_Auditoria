package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class LifecycleCallback {
    protected final i mLifecycleFragment;

    /* JADX INFO: Access modifiers changed from: protected */
    public LifecycleCallback(i iVar) {
        this.mLifecycleFragment = iVar;
    }

    private static i getChimeraLifecycleFragmentImpl(h hVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public static i getFragment(Activity activity) {
        return getFragment(new h(activity));
    }

    public static i getFragment(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    protected static i getFragment(h hVar) {
        if (hVar.d()) {
            return u1.F1(hVar.b());
        }
        if (hVar.c()) {
            return s1.f(hVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity getActivity() {
        Activity d5 = this.mLifecycleFragment.d();
        com.google.android.gms.common.internal.q.k(d5);
        return d5;
    }

    public void onActivityResult(int i5, int i6, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
