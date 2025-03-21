package o;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.i;
import androidx.lifecycle.i0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x0 implements androidx.lifecycle.h, u.f, androidx.lifecycle.m0 {

    /* renamed from: a  reason: collision with root package name */
    private final s f6719a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.lifecycle.l0 f6720b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f6721c;

    /* renamed from: d  reason: collision with root package name */
    private androidx.lifecycle.n f6722d = null;

    /* renamed from: e  reason: collision with root package name */
    private u.e f6723e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0(s sVar, androidx.lifecycle.l0 l0Var, Runnable runnable) {
        this.f6719a = sVar;
        this.f6720b = l0Var;
        this.f6721c = runnable;
    }

    @Override // androidx.lifecycle.m
    public androidx.lifecycle.i a() {
        c();
        return this.f6722d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i.a aVar) {
        this.f6722d.h(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f6722d == null) {
            this.f6722d = new androidx.lifecycle.n(this);
            u.e a5 = u.e.a(this);
            this.f6723e = a5;
            a5.c();
            this.f6721c.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f6722d != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Bundle bundle) {
        this.f6723e.d(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Bundle bundle) {
        this.f6723e.e(bundle);
    }

    @Override // androidx.lifecycle.h
    public r.a g() {
        Application application;
        Context applicationContext = this.f6719a.p1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            } else if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            } else {
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
        }
        r.b bVar = new r.b();
        if (application != null) {
            bVar.b(i0.a.f557d, application);
        }
        bVar.b(androidx.lifecycle.d0.f528a, this.f6719a);
        bVar.b(androidx.lifecycle.d0.f529b, this);
        if (this.f6719a.s() != null) {
            bVar.b(androidx.lifecycle.d0.f530c, this.f6719a.s());
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(i.b bVar) {
        this.f6722d.m(bVar);
    }

    @Override // u.f
    public u.d k() {
        c();
        return this.f6723e.b();
    }

    @Override // androidx.lifecycle.m0
    public androidx.lifecycle.l0 p() {
        c();
        return this.f6720b;
    }
}
