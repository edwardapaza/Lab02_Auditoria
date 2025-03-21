package io.grpc.internal;

import i3.m0;
import i3.y0;
import io.grpc.internal.a;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public abstract class w0 extends a.c {

    /* renamed from: w  reason: collision with root package name */
    private static final m0.a<Integer> f5293w;

    /* renamed from: x  reason: collision with root package name */
    private static final y0.g<Integer> f5294x;

    /* renamed from: s  reason: collision with root package name */
    private i3.j1 f5295s;

    /* renamed from: t  reason: collision with root package name */
    private i3.y0 f5296t;

    /* renamed from: u  reason: collision with root package name */
    private Charset f5297u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f5298v;

    /* loaded from: classes.dex */
    class a implements m0.a<Integer> {
        a() {
        }

        @Override // i3.y0.j
        /* renamed from: c */
        public Integer b(byte[] bArr) {
            if (bArr.length >= 3) {
                return Integer.valueOf(((bArr[0] - 48) * 100) + ((bArr[1] - 48) * 10) + (bArr[2] - 48));
            }
            throw new NumberFormatException("Malformed status code " + new String(bArr, i3.m0.f3499a));
        }

        @Override // i3.y0.j
        /* renamed from: d */
        public byte[] a(Integer num) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        a aVar = new a();
        f5293w = aVar;
        f5294x = i3.m0.b(":status", aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w0(int i5, n2 n2Var, t2 t2Var) {
        super(i5, n2Var, t2Var);
        this.f5297u = z0.b.f8864c;
    }

    private static Charset O(i3.y0 y0Var) {
        String str = (String) y0Var.g(t0.f5184j);
        if (str != null) {
            String[] split = str.split("charset=", 2);
            try {
                return Charset.forName(split[split.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return z0.b.f8864c;
    }

    private i3.j1 Q(i3.y0 y0Var) {
        i3.j1 j1Var = (i3.j1) y0Var.g(i3.o0.f3519b);
        if (j1Var != null) {
            return j1Var.q((String) y0Var.g(i3.o0.f3518a));
        }
        if (this.f5298v) {
            return i3.j1.f3434h.q("missing GRPC status in response");
        }
        Integer num = (Integer) y0Var.g(f5294x);
        return (num != null ? t0.l(num.intValue()) : i3.j1.f3446t.q("missing HTTP status code")).e("missing GRPC status, inferred error from HTTP status code");
    }

    private static void R(i3.y0 y0Var) {
        y0Var.e(f5294x);
        y0Var.e(i3.o0.f3519b);
        y0Var.e(i3.o0.f3518a);
    }

    private i3.j1 V(i3.y0 y0Var) {
        Integer num = (Integer) y0Var.g(f5294x);
        if (num == null) {
            return i3.j1.f3446t.q("Missing HTTP status code");
        }
        String str = (String) y0Var.g(t0.f5184j);
        if (t0.m(str)) {
            return null;
        }
        i3.j1 l5 = t0.l(num.intValue());
        return l5.e("invalid content-type: " + str);
    }

    protected abstract void P(i3.j1 j1Var, boolean z4, i3.y0 y0Var);

    /* JADX INFO: Access modifiers changed from: protected */
    public void S(x1 x1Var, boolean z4) {
        i3.j1 j1Var = this.f5295s;
        if (j1Var != null) {
            this.f5295s = j1Var.e("DATA-----------------------------\n" + y1.e(x1Var, this.f5297u));
            x1Var.close();
            if (this.f5295s.n().length() > 1000 || z4) {
                P(this.f5295s, false, this.f5296t);
            }
        } else if (!this.f5298v) {
            P(i3.j1.f3446t.q("headers not received before payload"), false, new i3.y0());
        } else {
            int b5 = x1Var.b();
            D(x1Var);
            if (z4) {
                this.f5295s = i3.j1.f3446t.q(b5 > 0 ? "Received unexpected EOS on non-empty DATA frame from server" : "Received unexpected EOS on empty DATA frame from server");
                i3.y0 y0Var = new i3.y0();
                this.f5296t = y0Var;
                N(this.f5295s, false, y0Var);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Finally extract failed */
    public void T(i3.y0 y0Var) {
        z0.k.o(y0Var, "headers");
        i3.j1 j1Var = this.f5295s;
        if (j1Var != null) {
            this.f5295s = j1Var.e("headers: " + y0Var);
            return;
        }
        try {
            if (this.f5298v) {
                i3.j1 q5 = i3.j1.f3446t.q("Received headers twice");
                this.f5295s = q5;
                if (q5 != null) {
                    this.f5295s = q5.e("headers: " + y0Var);
                    this.f5296t = y0Var;
                    this.f5297u = O(y0Var);
                    return;
                }
                return;
            }
            Integer num = (Integer) y0Var.g(f5294x);
            if (num != null && num.intValue() >= 100 && num.intValue() < 200) {
                i3.j1 j1Var2 = this.f5295s;
                if (j1Var2 != null) {
                    this.f5295s = j1Var2.e("headers: " + y0Var);
                    this.f5296t = y0Var;
                    this.f5297u = O(y0Var);
                    return;
                }
                return;
            }
            this.f5298v = true;
            i3.j1 V = V(y0Var);
            this.f5295s = V;
            if (V != null) {
                if (V != null) {
                    this.f5295s = V.e("headers: " + y0Var);
                    this.f5296t = y0Var;
                    this.f5297u = O(y0Var);
                    return;
                }
                return;
            }
            R(y0Var);
            E(y0Var);
            i3.j1 j1Var3 = this.f5295s;
            if (j1Var3 != null) {
                this.f5295s = j1Var3.e("headers: " + y0Var);
                this.f5296t = y0Var;
                this.f5297u = O(y0Var);
            }
        } catch (Throwable th) {
            i3.j1 j1Var4 = this.f5295s;
            if (j1Var4 != null) {
                this.f5295s = j1Var4.e("headers: " + y0Var);
                this.f5296t = y0Var;
                this.f5297u = O(y0Var);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(i3.y0 y0Var) {
        z0.k.o(y0Var, "trailers");
        if (this.f5295s == null && !this.f5298v) {
            i3.j1 V = V(y0Var);
            this.f5295s = V;
            if (V != null) {
                this.f5296t = y0Var;
            }
        }
        i3.j1 j1Var = this.f5295s;
        if (j1Var == null) {
            i3.j1 Q = Q(y0Var);
            R(y0Var);
            F(y0Var, Q);
            return;
        }
        i3.j1 e5 = j1Var.e("trailers: " + y0Var);
        this.f5295s = e5;
        P(e5, false, this.f5296t);
    }

    @Override // io.grpc.internal.a.c, io.grpc.internal.n1.b
    public /* bridge */ /* synthetic */ void e(boolean z4) {
        super.e(z4);
    }
}
