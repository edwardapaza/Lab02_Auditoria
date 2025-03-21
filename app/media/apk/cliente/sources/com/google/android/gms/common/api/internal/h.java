package com.google.android.gms.common.api.internal;

import android.app.Activity;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final Object f969a;

    public h(Activity activity) {
        com.google.android.gms.common.internal.q.l(activity, "Activity must not be null");
        this.f969a = activity;
    }

    public final Activity a() {
        return (Activity) this.f969a;
    }

    public final o.x b() {
        return (o.x) this.f969a;
    }

    public final boolean c() {
        return this.f969a instanceof Activity;
    }

    public final boolean d() {
        return this.f969a instanceof o.x;
    }
}
