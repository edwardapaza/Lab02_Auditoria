package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.a;
/* loaded from: classes.dex */
public class x implements a.d {

    /* renamed from: b  reason: collision with root package name */
    public static final x f1211b = c().a();

    /* renamed from: a  reason: collision with root package name */
    private final String f1212a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f1213a;

        /* synthetic */ a(z zVar) {
        }

        public x a() {
            return new x(this.f1213a, null);
        }
    }

    /* synthetic */ x(String str, a0 a0Var) {
        this.f1212a = str;
    }

    public static a c() {
        return new a(null);
    }

    public final Bundle d() {
        Bundle bundle = new Bundle();
        String str = this.f1212a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x) {
            return p.a(this.f1212a, ((x) obj).f1212a);
        }
        return false;
    }

    public final int hashCode() {
        return p.b(this.f1212a);
    }
}
