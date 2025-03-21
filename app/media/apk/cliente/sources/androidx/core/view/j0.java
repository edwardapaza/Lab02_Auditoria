package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    private final e f488a;

    /* loaded from: classes.dex */
    private static class a extends e {

        /* renamed from: a  reason: collision with root package name */
        protected final Window f489a;

        /* renamed from: b  reason: collision with root package name */
        private final j f490b;

        a(Window window, j jVar) {
            this.f489a = window;
            this.f490b = jVar;
        }

        protected void c(int i5) {
            View decorView = this.f489a.getDecorView();
            decorView.setSystemUiVisibility(i5 | decorView.getSystemUiVisibility());
        }

        protected void d(int i5) {
            this.f489a.addFlags(i5);
        }

        protected void e(int i5) {
            View decorView = this.f489a.getDecorView();
            decorView.setSystemUiVisibility((~i5) & decorView.getSystemUiVisibility());
        }

        protected void f(int i5) {
            this.f489a.clearFlags(i5);
        }
    }

    /* loaded from: classes.dex */
    private static class b extends a {
        b(Window window, j jVar) {
            super(window, jVar);
        }

        @Override // androidx.core.view.j0.e
        public void b(boolean z4) {
            if (!z4) {
                e(8192);
                return;
            }
            f(67108864);
            d(Integer.MIN_VALUE);
            c(8192);
        }
    }

    /* loaded from: classes.dex */
    private static class c extends b {
        c(Window window, j jVar) {
            super(window, jVar);
        }

        @Override // androidx.core.view.j0.e
        public void a(boolean z4) {
            if (!z4) {
                e(16);
                return;
            }
            f(134217728);
            d(Integer.MIN_VALUE);
            c(16);
        }
    }

    /* loaded from: classes.dex */
    private static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final j0 f491a;

        /* renamed from: b  reason: collision with root package name */
        final WindowInsetsController f492b;

        /* renamed from: c  reason: collision with root package name */
        final j f493c;

        /* renamed from: d  reason: collision with root package name */
        private final androidx.collection.f<Object, WindowInsetsController.OnControllableInsetsChangedListener> f494d;

        /* renamed from: e  reason: collision with root package name */
        protected Window f495e;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        d(android.view.Window r2, androidx.core.view.j0 r3, androidx.core.view.j r4) {
            /*
                r1 = this;
                android.view.WindowInsetsController r0 = androidx.core.view.k0.a(r2)
                r1.<init>(r0, r3, r4)
                r1.f495e = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.j0.d.<init>(android.view.Window, androidx.core.view.j0, androidx.core.view.j):void");
        }

        d(WindowInsetsController windowInsetsController, j0 j0Var, j jVar) {
            this.f494d = new androidx.collection.f<>();
            this.f492b = windowInsetsController;
            this.f491a = j0Var;
            this.f493c = jVar;
        }

        @Override // androidx.core.view.j0.e
        public void a(boolean z4) {
            if (z4) {
                if (this.f495e != null) {
                    c(16);
                }
                this.f492b.setSystemBarsAppearance(16, 16);
                return;
            }
            if (this.f495e != null) {
                d(16);
            }
            this.f492b.setSystemBarsAppearance(0, 16);
        }

        @Override // androidx.core.view.j0.e
        public void b(boolean z4) {
            if (z4) {
                if (this.f495e != null) {
                    c(8192);
                }
                this.f492b.setSystemBarsAppearance(8, 8);
                return;
            }
            if (this.f495e != null) {
                d(8192);
            }
            this.f492b.setSystemBarsAppearance(0, 8);
        }

        protected void c(int i5) {
            View decorView = this.f495e.getDecorView();
            decorView.setSystemUiVisibility(i5 | decorView.getSystemUiVisibility());
        }

        protected void d(int i5) {
            View decorView = this.f495e.getDecorView();
            decorView.setSystemUiVisibility((~i5) & decorView.getSystemUiVisibility());
        }
    }

    /* loaded from: classes.dex */
    private static class e {
        e() {
        }

        public void a(boolean z4) {
        }

        public void b(boolean z4) {
        }
    }

    public j0(Window window, View view) {
        j jVar = new j(view);
        int i5 = Build.VERSION.SDK_INT;
        this.f488a = i5 >= 30 ? new d(window, this, jVar) : i5 >= 26 ? new c(window, jVar) : i5 >= 23 ? new b(window, jVar) : new a(window, jVar);
    }

    public void a(boolean z4) {
        this.f488a.a(z4);
    }

    public void b(boolean z4) {
        this.f488a.b(z4);
    }
}
