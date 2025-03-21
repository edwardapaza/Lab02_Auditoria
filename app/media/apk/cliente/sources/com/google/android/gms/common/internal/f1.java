package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
/* loaded from: classes.dex */
public final class f1 {

    /* renamed from: f  reason: collision with root package name */
    private static final Uri f1128f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a  reason: collision with root package name */
    private final String f1129a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1130b;

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f1131c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1132d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1133e;

    public f1(String str, String str2, int i5, boolean z4) {
        q.e(str);
        this.f1129a = str;
        q.e(str2);
        this.f1130b = str2;
        this.f1131c = null;
        this.f1132d = 4225;
        this.f1133e = z4;
    }

    public final ComponentName a() {
        return this.f1131c;
    }

    public final Intent b(Context context) {
        Bundle bundle;
        if (this.f1129a != null) {
            if (this.f1133e) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("serviceActionBundleKey", this.f1129a);
                try {
                    bundle = context.getContentResolver().call(f1128f, "serviceIntentCall", (String) null, bundle2);
                } catch (IllegalArgumentException e5) {
                    Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e5.toString()));
                    bundle = null;
                }
                r2 = bundle != null ? (Intent) bundle.getParcelable("serviceResponseIntentKey") : null;
                if (r2 == null) {
                    Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f1129a)));
                }
            }
            return r2 == null ? new Intent(this.f1129a).setPackage(this.f1130b) : r2;
        }
        return new Intent().setComponent(this.f1131c);
    }

    public final String c() {
        return this.f1130b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f1) {
            f1 f1Var = (f1) obj;
            return p.a(this.f1129a, f1Var.f1129a) && p.a(this.f1130b, f1Var.f1130b) && p.a(this.f1131c, f1Var.f1131c) && this.f1133e == f1Var.f1133e;
        }
        return false;
    }

    public final int hashCode() {
        return p.b(this.f1129a, this.f1130b, this.f1131c, 4225, Boolean.valueOf(this.f1133e));
    }

    public final String toString() {
        String str = this.f1129a;
        if (str == null) {
            q.k(this.f1131c);
            return this.f1131c.flattenToString();
        }
        return str;
    }
}
