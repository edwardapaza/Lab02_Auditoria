package o;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.app.a;
import androidx.lifecycle.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import u.d;
/* loaded from: classes.dex */
public class x extends androidx.activity.h implements a.c, a.e {
    boolean A;
    boolean B;

    /* renamed from: y  reason: collision with root package name */
    final b0 f6716y = b0.b(new a());

    /* renamed from: z  reason: collision with root package name */
    final androidx.lifecycle.n f6717z = new androidx.lifecycle.n(this);
    boolean C = true;

    /* loaded from: classes.dex */
    class a extends d0<x> implements androidx.core.content.m, androidx.core.content.n, androidx.core.app.r0, androidx.core.app.s0, androidx.lifecycle.m0, androidx.activity.s, c.e, u.f, p0, androidx.core.view.d {
        public a() {
            super(x.this);
        }

        @Override // o.d0
        public void B() {
            C();
        }

        public void C() {
            x.this.E();
        }

        @Override // o.d0
        /* renamed from: D */
        public x y() {
            return x.this;
        }

        @Override // androidx.lifecycle.m
        public androidx.lifecycle.i a() {
            return x.this.f6717z;
        }

        @Override // o.p0
        public void b(l0 l0Var, s sVar) {
            x.this.W(sVar);
        }

        @Override // androidx.core.view.d
        public void c(androidx.core.view.f fVar) {
            x.this.c(fVar);
        }

        @Override // androidx.core.app.r0
        public void e(k.a<androidx.core.app.o> aVar) {
            x.this.e(aVar);
        }

        @Override // androidx.core.content.m
        public void f(k.a<Configuration> aVar) {
            x.this.f(aVar);
        }

        @Override // o.d0, o.z
        public View g(int i5) {
            return x.this.findViewById(i5);
        }

        @Override // androidx.core.app.s0
        public void h(k.a<androidx.core.app.u0> aVar) {
            x.this.h(aVar);
        }

        @Override // androidx.core.app.r0
        public void i(k.a<androidx.core.app.o> aVar) {
            x.this.i(aVar);
        }

        @Override // androidx.activity.s
        public androidx.activity.q j() {
            return x.this.j();
        }

        @Override // u.f
        public u.d k() {
            return x.this.k();
        }

        @Override // androidx.core.view.d
        public void l(androidx.core.view.f fVar) {
            x.this.l(fVar);
        }

        @Override // c.e
        public c.d m() {
            return x.this.m();
        }

        @Override // androidx.core.app.s0
        public void n(k.a<androidx.core.app.u0> aVar) {
            x.this.n(aVar);
        }

        @Override // androidx.core.content.n
        public void o(k.a<Integer> aVar) {
            x.this.o(aVar);
        }

        @Override // androidx.lifecycle.m0
        public androidx.lifecycle.l0 p() {
            return x.this.p();
        }

        @Override // androidx.core.content.n
        public void q(k.a<Integer> aVar) {
            x.this.q(aVar);
        }

        @Override // androidx.core.content.m
        public void r(k.a<Configuration> aVar) {
            x.this.r(aVar);
        }

        @Override // o.d0, o.z
        public boolean s() {
            Window window = x.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // o.d0
        public void x(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            x.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // o.d0
        public LayoutInflater z() {
            return x.this.getLayoutInflater().cloneInContext(x.this);
        }
    }

    public x() {
        P();
    }

    private void P() {
        k().h("android:support:lifecycle", new d.c() { // from class: o.t
            @Override // u.d.c
            public final Bundle a() {
                Bundle Q;
                Q = x.this.Q();
                return Q;
            }
        });
        r(new k.a() { // from class: o.u
            @Override // k.a
            public final void accept(Object obj) {
                x.this.R((Configuration) obj);
            }
        });
        A(new k.a() { // from class: o.v
            @Override // k.a
            public final void accept(Object obj) {
                x.this.S((Intent) obj);
            }
        });
        z(new b.b() { // from class: o.w
            @Override // b.b
            public final void a(Context context) {
                x.this.T(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle Q() {
        U();
        this.f6717z.h(i.a.ON_STOP);
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(Configuration configuration) {
        this.f6716y.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(Intent intent) {
        this.f6716y.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(Context context) {
        this.f6716y.a(null);
    }

    private static boolean V(l0 l0Var, i.b bVar) {
        boolean z4 = false;
        for (s sVar : l0Var.u0()) {
            if (sVar != null) {
                if (sVar.C() != null) {
                    z4 |= V(sVar.t(), bVar);
                }
                x0 x0Var = sVar.Z;
                if (x0Var != null && x0Var.a().b().c(i.b.STARTED)) {
                    sVar.Z.h(bVar);
                    z4 = true;
                }
                if (sVar.Y.b().c(i.b.STARTED)) {
                    sVar.Y.m(bVar);
                    z4 = true;
                }
            }
        }
        return z4;
    }

    final View N(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f6716y.n(view, str, context, attributeSet);
    }

    public l0 O() {
        return this.f6716y.l();
    }

    void U() {
        do {
        } while (V(O(), i.b.CREATED));
    }

    @Deprecated
    public void W(s sVar) {
    }

    protected void X() {
        this.f6717z.h(i.a.ON_RESUME);
        this.f6716y.h();
    }

    @Override // androidx.core.app.a.e
    @Deprecated
    public final void b(int i5) {
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (s(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.A);
            printWriter.print(" mResumed=");
            printWriter.print(this.B);
            printWriter.print(" mStopped=");
            printWriter.print(this.C);
            if (getApplication() != null) {
                androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.f6716y.l().W(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.activity.h, android.app.Activity
    protected void onActivityResult(int i5, int i6, Intent intent) {
        this.f6716y.m();
        super.onActivityResult(i5, i6, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.h, androidx.core.app.m, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6717z.h(i.a.ON_CREATE);
        this.f6716y.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View N = N(view, str, context, attributeSet);
        return N == null ? super.onCreateView(view, str, context, attributeSet) : N;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View N = N(null, str, context, attributeSet);
        return N == null ? super.onCreateView(str, context, attributeSet) : N;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f6716y.f();
        this.f6717z.h(i.a.ON_DESTROY);
    }

    @Override // androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        if (i5 == 6) {
            return this.f6716y.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.B = false;
        this.f6716y.g();
        this.f6717z.h(i.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        X();
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        this.f6716y.m();
        super.onRequestPermissionsResult(i5, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        this.f6716y.m();
        super.onResume();
        this.B = true;
        this.f6716y.k();
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.f6716y.m();
        super.onStart();
        this.C = false;
        if (!this.A) {
            this.A = true;
            this.f6716y.c();
        }
        this.f6716y.k();
        this.f6717z.h(i.a.ON_START);
        this.f6716y.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f6716y.m();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.C = true;
        U();
        this.f6716y.j();
        this.f6717z.h(i.a.ON_STOP);
    }
}
