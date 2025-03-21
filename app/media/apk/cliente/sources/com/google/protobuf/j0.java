package com.google.protobuf;
/* loaded from: classes.dex */
public class j0 {

    /* renamed from: e  reason: collision with root package name */
    private static final q f2028e = q.b();

    /* renamed from: a  reason: collision with root package name */
    private i f2029a;

    /* renamed from: b  reason: collision with root package name */
    private q f2030b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile w0 f2031c;

    /* renamed from: d  reason: collision with root package name */
    private volatile i f2032d;

    protected void a(w0 w0Var) {
        i iVar;
        if (this.f2031c != null) {
            return;
        }
        synchronized (this) {
            if (this.f2031c != null) {
                return;
            }
            try {
                if (this.f2029a != null) {
                    this.f2031c = w0Var.m().a(this.f2029a, this.f2030b);
                    iVar = this.f2029a;
                } else {
                    this.f2031c = w0Var;
                    iVar = i.f1961b;
                }
                this.f2032d = iVar;
            } catch (e0 unused) {
                this.f2031c = w0Var;
                this.f2032d = i.f1961b;
            }
        }
    }

    public int b() {
        if (this.f2032d != null) {
            return this.f2032d.size();
        }
        i iVar = this.f2029a;
        if (iVar != null) {
            return iVar.size();
        }
        if (this.f2031c != null) {
            return this.f2031c.a();
        }
        return 0;
    }

    public w0 c(w0 w0Var) {
        a(w0Var);
        return this.f2031c;
    }

    public w0 d(w0 w0Var) {
        w0 w0Var2 = this.f2031c;
        this.f2029a = null;
        this.f2032d = null;
        this.f2031c = w0Var;
        return w0Var2;
    }

    public i e() {
        if (this.f2032d != null) {
            return this.f2032d;
        }
        i iVar = this.f2029a;
        if (iVar != null) {
            return iVar;
        }
        synchronized (this) {
            if (this.f2032d != null) {
                return this.f2032d;
            }
            this.f2032d = this.f2031c == null ? i.f1961b : this.f2031c.l();
            return this.f2032d;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j0) {
            j0 j0Var = (j0) obj;
            w0 w0Var = this.f2031c;
            w0 w0Var2 = j0Var.f2031c;
            return (w0Var == null && w0Var2 == null) ? e().equals(j0Var.e()) : (w0Var == null || w0Var2 == null) ? w0Var != null ? w0Var.equals(j0Var.c(w0Var.b())) : c(w0Var2.b()).equals(w0Var2) : w0Var.equals(w0Var2);
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }
}
