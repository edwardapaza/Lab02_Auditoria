package o;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
/* loaded from: classes.dex */
public class q extends s implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: i0  reason: collision with root package name */
    private Handler f6551i0;

    /* renamed from: r0  reason: collision with root package name */
    private boolean f6560r0;

    /* renamed from: t0  reason: collision with root package name */
    private Dialog f6562t0;

    /* renamed from: u0  reason: collision with root package name */
    private boolean f6563u0;

    /* renamed from: v0  reason: collision with root package name */
    private boolean f6564v0;

    /* renamed from: w0  reason: collision with root package name */
    private boolean f6565w0;

    /* renamed from: j0  reason: collision with root package name */
    private Runnable f6552j0 = new a();

    /* renamed from: k0  reason: collision with root package name */
    private DialogInterface.OnCancelListener f6553k0 = new b();

    /* renamed from: l0  reason: collision with root package name */
    private DialogInterface.OnDismissListener f6554l0 = new c();

    /* renamed from: m0  reason: collision with root package name */
    private int f6555m0 = 0;

    /* renamed from: n0  reason: collision with root package name */
    private int f6556n0 = 0;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f6557o0 = true;

    /* renamed from: p0  reason: collision with root package name */
    private boolean f6558p0 = true;

    /* renamed from: q0  reason: collision with root package name */
    private int f6559q0 = -1;

    /* renamed from: s0  reason: collision with root package name */
    private androidx.lifecycle.t<androidx.lifecycle.m> f6561s0 = new d();

    /* renamed from: x0  reason: collision with root package name */
    private boolean f6566x0 = false;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.f6554l0.onDismiss(q.this.f6562t0);
        }
    }

    /* loaded from: classes.dex */
    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (q.this.f6562t0 != null) {
                q qVar = q.this;
                qVar.onCancel(qVar.f6562t0);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (q.this.f6562t0 != null) {
                q qVar = q.this;
                qVar.onDismiss(qVar.f6562t0);
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements androidx.lifecycle.t<androidx.lifecycle.m> {
        d() {
        }

        @Override // androidx.lifecycle.t
        /* renamed from: b */
        public void a(androidx.lifecycle.m mVar) {
            if (mVar == null || !q.this.f6558p0) {
                return;
            }
            View q12 = q.this.q1();
            if (q12.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (q.this.f6562t0 != null) {
                if (l0.I0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + q.this.f6562t0);
                }
                q.this.f6562t0.setContentView(q12);
            }
        }
    }

    /* loaded from: classes.dex */
    class e extends z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f6571a;

        e(z zVar) {
            this.f6571a = zVar;
        }

        @Override // o.z
        public View g(int i5) {
            return this.f6571a.s() ? this.f6571a.g(i5) : q.this.J1(i5);
        }

        @Override // o.z
        public boolean s() {
            return this.f6571a.s() || q.this.K1();
        }
    }

    private void G1(boolean z4, boolean z5, boolean z6) {
        if (this.f6564v0) {
            return;
        }
        this.f6564v0 = true;
        this.f6565w0 = false;
        Dialog dialog = this.f6562t0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f6562t0.dismiss();
            if (!z5) {
                if (Looper.myLooper() == this.f6551i0.getLooper()) {
                    onDismiss(this.f6562t0);
                } else {
                    this.f6551i0.post(this.f6552j0);
                }
            }
        }
        this.f6563u0 = true;
        if (this.f6559q0 >= 0) {
            if (z6) {
                H().c1(this.f6559q0, 1);
            } else {
                H().a1(this.f6559q0, 1, z4);
            }
            this.f6559q0 = -1;
            return;
        }
        t0 n5 = H().n();
        n5.m(true);
        n5.l(this);
        if (z6) {
            n5.h();
        } else if (z4) {
            n5.g();
        } else {
            n5.f();
        }
    }

    private void L1(Bundle bundle) {
        if (this.f6558p0 && !this.f6566x0) {
            try {
                this.f6560r0 = true;
                Dialog I1 = I1(bundle);
                this.f6562t0 = I1;
                if (this.f6558p0) {
                    N1(I1, this.f6555m0);
                    Context u5 = u();
                    if (u5 instanceof Activity) {
                        this.f6562t0.setOwnerActivity((Activity) u5);
                    }
                    this.f6562t0.setCancelable(this.f6557o0);
                    this.f6562t0.setOnCancelListener(this.f6553k0);
                    this.f6562t0.setOnDismissListener(this.f6554l0);
                    this.f6566x0 = true;
                } else {
                    this.f6562t0 = null;
                }
            } finally {
                this.f6560r0 = false;
            }
        }
    }

    public int H1() {
        return this.f6556n0;
    }

    public Dialog I1(Bundle bundle) {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new androidx.activity.k(p1(), H1());
    }

    View J1(int i5) {
        Dialog dialog = this.f6562t0;
        if (dialog != null) {
            return dialog.findViewById(i5);
        }
        return null;
    }

    @Override // o.s
    public void K0(Bundle bundle) {
        super.K0(bundle);
        Dialog dialog = this.f6562t0;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i5 = this.f6555m0;
        if (i5 != 0) {
            bundle.putInt("android:style", i5);
        }
        int i6 = this.f6556n0;
        if (i6 != 0) {
            bundle.putInt("android:theme", i6);
        }
        boolean z4 = this.f6557o0;
        if (!z4) {
            bundle.putBoolean("android:cancelable", z4);
        }
        boolean z5 = this.f6558p0;
        if (!z5) {
            bundle.putBoolean("android:showsDialog", z5);
        }
        int i7 = this.f6559q0;
        if (i7 != -1) {
            bundle.putInt("android:backStackId", i7);
        }
    }

    boolean K1() {
        return this.f6566x0;
    }

    @Override // o.s
    public void L0() {
        super.L0();
        Dialog dialog = this.f6562t0;
        if (dialog != null) {
            this.f6563u0 = false;
            dialog.show();
            View decorView = this.f6562t0.getWindow().getDecorView();
            androidx.lifecycle.n0.a(decorView, this);
            androidx.lifecycle.o0.a(decorView, this);
            u.g.a(decorView, this);
        }
    }

    @Override // o.s
    public void M0() {
        super.M0();
        Dialog dialog = this.f6562t0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void M1(boolean z4) {
        this.f6558p0 = z4;
    }

    public void N1(Dialog dialog, int i5) {
        if (i5 != 1 && i5 != 2) {
            if (i5 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    @Override // o.s
    public void O0(Bundle bundle) {
        Bundle bundle2;
        super.O0(bundle);
        if (this.f6562t0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f6562t0.onRestoreInstanceState(bundle2);
    }

    public void O1(l0 l0Var, String str) {
        this.f6564v0 = false;
        this.f6565w0 = true;
        t0 n5 = l0Var.n();
        n5.m(true);
        n5.d(this, str);
        n5.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // o.s
    public void V0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.V0(layoutInflater, viewGroup, bundle);
        if (this.N != null || this.f6562t0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f6562t0.onRestoreInstanceState(bundle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // o.s
    public z h() {
        return new e(super.h());
    }

    @Override // o.s
    @Deprecated
    public void i0(Bundle bundle) {
        super.i0(bundle);
    }

    @Override // o.s
    public void l0(Context context) {
        super.l0(context);
        V().e(this.f6561s0);
        if (this.f6565w0) {
            return;
        }
        this.f6564v0 = false;
    }

    @Override // o.s
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.f6551i0 = new Handler();
        this.f6558p0 = this.D == 0;
        if (bundle != null) {
            this.f6555m0 = bundle.getInt("android:style", 0);
            this.f6556n0 = bundle.getInt("android:theme", 0);
            this.f6557o0 = bundle.getBoolean("android:cancelable", true);
            this.f6558p0 = bundle.getBoolean("android:showsDialog", this.f6558p0);
            this.f6559q0 = bundle.getInt("android:backStackId", -1);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f6563u0) {
            return;
        }
        if (l0.I0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        G1(true, true, false);
    }

    @Override // o.s
    public void v0() {
        super.v0();
        Dialog dialog = this.f6562t0;
        if (dialog != null) {
            this.f6563u0 = true;
            dialog.setOnDismissListener(null);
            this.f6562t0.dismiss();
            if (!this.f6564v0) {
                onDismiss(this.f6562t0);
            }
            this.f6562t0 = null;
            this.f6566x0 = false;
        }
    }

    @Override // o.s
    public void w0() {
        super.w0();
        if (!this.f6565w0 && !this.f6564v0) {
            this.f6564v0 = true;
        }
        V().h(this.f6561s0);
    }

    @Override // o.s
    public LayoutInflater x0(Bundle bundle) {
        StringBuilder sb;
        String str;
        LayoutInflater x02 = super.x0(bundle);
        if (this.f6558p0 && !this.f6560r0) {
            L1(bundle);
            if (l0.I0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.f6562t0;
            return dialog != null ? x02.cloneInContext(dialog.getContext()) : x02;
        }
        if (l0.I0(2)) {
            String str2 = "getting layout inflater for DialogFragment " + this;
            if (this.f6558p0) {
                sb = new StringBuilder();
                str = "mCreatingDialog = true: ";
            } else {
                sb = new StringBuilder();
                str = "mShowsDialog = false: ";
            }
            sb.append(str);
            sb.append(str2);
            Log.d("FragmentManager", sb.toString());
        }
        return x02;
    }
}
