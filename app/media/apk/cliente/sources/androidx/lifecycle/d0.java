package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.i;
import androidx.lifecycle.i0;
import r.a;
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a.b<u.f> f528a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final a.b<m0> f529b = new c();

    /* renamed from: c  reason: collision with root package name */
    public static final a.b<Bundle> f530c = new a();

    /* loaded from: classes.dex */
    public static final class a implements a.b<Bundle> {
        a() {
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements a.b<u.f> {
        b() {
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements a.b<m0> {
        c() {
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements i0.b {
        d() {
        }

        @Override // androidx.lifecycle.i0.b
        public /* synthetic */ h0 a(Class cls) {
            return j0.a(this, cls);
        }

        @Override // androidx.lifecycle.i0.b
        public <T extends h0> T b(Class<T> cls, r.a aVar) {
            e4.k.e(cls, "modelClass");
            e4.k.e(aVar, "extras");
            return new f0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends u.f & m0> void a(T t5) {
        e4.k.e(t5, "<this>");
        i.b b5 = t5.a().b();
        if (!(b5 == i.b.INITIALIZED || b5 == i.b.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (t5.k().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            e0 e0Var = new e0(t5.k(), t5);
            t5.k().h("androidx.lifecycle.internal.SavedStateHandlesProvider", e0Var);
            t5.a().a(new c0(e0Var));
        }
    }

    public static final f0 b(m0 m0Var) {
        e4.k.e(m0Var, "<this>");
        return (f0) new i0(m0Var, new d()).b("androidx.lifecycle.internal.SavedStateHandlesVM", f0.class);
    }
}
