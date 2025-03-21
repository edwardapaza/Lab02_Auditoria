package androidx.lifecycle;

import android.app.Application;
import r.a;
/* loaded from: classes.dex */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    private final l0 f553a;

    /* renamed from: b  reason: collision with root package name */
    private final b f554b;

    /* renamed from: c  reason: collision with root package name */
    private final r.a f555c;

    /* loaded from: classes.dex */
    public static class a extends c {

        /* renamed from: c  reason: collision with root package name */
        public static final C0020a f556c = new C0020a(null);

        /* renamed from: d  reason: collision with root package name */
        public static final a.b<Application> f557d = C0020a.C0021a.f558a;

        /* renamed from: androidx.lifecycle.i0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0020a {

            /* renamed from: androidx.lifecycle.i0$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            private static final class C0021a implements a.b<Application> {

                /* renamed from: a  reason: collision with root package name */
                public static final C0021a f558a = new C0021a();

                private C0021a() {
                }
            }

            private C0020a() {
            }

            public /* synthetic */ C0020a(e4.g gVar) {
                this();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        <T extends h0> T a(Class<T> cls);

        <T extends h0> T b(Class<T> cls, r.a aVar);
    }

    /* loaded from: classes.dex */
    public static class c implements b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f559a = new a(null);

        /* renamed from: b  reason: collision with root package name */
        public static final a.b<String> f560b = a.C0022a.f561a;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: androidx.lifecycle.i0$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            private static final class C0022a implements a.b<String> {

                /* renamed from: a  reason: collision with root package name */
                public static final C0022a f561a = new C0022a();

                private C0022a() {
                }
            }

            private a() {
            }

            public /* synthetic */ a(e4.g gVar) {
                this();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public void a(h0 h0Var) {
            e4.k.e(h0Var, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i0(l0 l0Var, b bVar) {
        this(l0Var, bVar, null, 4, null);
        e4.k.e(l0Var, "store");
        e4.k.e(bVar, "factory");
    }

    public i0(l0 l0Var, b bVar, r.a aVar) {
        e4.k.e(l0Var, "store");
        e4.k.e(bVar, "factory");
        e4.k.e(aVar, "defaultCreationExtras");
        this.f553a = l0Var;
        this.f554b = bVar;
        this.f555c = aVar;
    }

    public /* synthetic */ i0(l0 l0Var, b bVar, r.a aVar, int i5, e4.g gVar) {
        this(l0Var, bVar, (i5 & 4) != 0 ? a.C0110a.f7127b : aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i0(m0 m0Var, b bVar) {
        this(m0Var.p(), bVar, k0.a(m0Var));
        e4.k.e(m0Var, "owner");
        e4.k.e(bVar, "factory");
    }

    public <T extends h0> T a(Class<T> cls) {
        e4.k.e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends h0> T b(String str, Class<T> cls) {
        T t5;
        e4.k.e(str, "key");
        e4.k.e(cls, "modelClass");
        T t6 = (T) this.f553a.b(str);
        if (!cls.isInstance(t6)) {
            r.b bVar = new r.b(this.f555c);
            bVar.b(c.f560b, str);
            try {
                t5 = (T) this.f554b.b(cls, bVar);
            } catch (AbstractMethodError unused) {
                t5 = (T) this.f554b.a(cls);
            }
            this.f553a.c(str, t5);
            return t5;
        }
        b bVar2 = this.f554b;
        d dVar = bVar2 instanceof d ? (d) bVar2 : null;
        if (dVar != null) {
            e4.k.b(t6);
            dVar.a(t6);
        }
        e4.k.c(t6, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return t6;
    }
}
