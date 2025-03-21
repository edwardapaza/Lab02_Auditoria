package com.google.protobuf;

import com.google.protobuf.d2;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class x1 {

    /* renamed from: f  reason: collision with root package name */
    private static final x1 f2194f = new x1(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    private int f2195a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f2196b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f2197c;

    /* renamed from: d  reason: collision with root package name */
    private int f2198d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2199e;

    private x1() {
        this(0, new int[8], new Object[8], true);
    }

    private x1(int i5, int[] iArr, Object[] objArr, boolean z4) {
        this.f2198d = -1;
        this.f2195a = i5;
        this.f2196b = iArr;
        this.f2197c = objArr;
        this.f2199e = z4;
    }

    private void b(int i5) {
        int[] iArr = this.f2196b;
        if (i5 > iArr.length) {
            int i6 = this.f2195a;
            int i7 = i6 + (i6 / 2);
            if (i7 >= i5) {
                i5 = i7;
            }
            if (i5 < 8) {
                i5 = 8;
            }
            this.f2196b = Arrays.copyOf(iArr, i5);
            this.f2197c = Arrays.copyOf(this.f2197c, i5);
        }
    }

    public static x1 c() {
        return f2194f;
    }

    private static int f(int[] iArr, int i5) {
        int i6 = 17;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 = (i6 * 31) + iArr[i7];
        }
        return i6;
    }

    private static int g(Object[] objArr, int i5) {
        int i6 = 17;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 = (i6 * 31) + objArr[i7].hashCode();
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x1 j(x1 x1Var, x1 x1Var2) {
        int i5 = x1Var.f2195a + x1Var2.f2195a;
        int[] copyOf = Arrays.copyOf(x1Var.f2196b, i5);
        System.arraycopy(x1Var2.f2196b, 0, copyOf, x1Var.f2195a, x1Var2.f2195a);
        Object[] copyOf2 = Arrays.copyOf(x1Var.f2197c, i5);
        System.arraycopy(x1Var2.f2197c, 0, copyOf2, x1Var.f2195a, x1Var2.f2195a);
        return new x1(i5, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x1 k() {
        return new x1();
    }

    private static boolean l(Object[] objArr, Object[] objArr2, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (!objArr[i6].equals(objArr2[i6])) {
                return false;
            }
        }
        return true;
    }

    private static boolean o(int[] iArr, int[] iArr2, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (iArr[i6] != iArr2[i6]) {
                return false;
            }
        }
        return true;
    }

    private static void q(int i5, Object obj, d2 d2Var) {
        int a5 = c2.a(i5);
        int b5 = c2.b(i5);
        if (b5 == 0) {
            d2Var.e(a5, ((Long) obj).longValue());
        } else if (b5 == 1) {
            d2Var.A(a5, ((Long) obj).longValue());
        } else if (b5 == 2) {
            d2Var.l(a5, (i) obj);
        } else if (b5 != 3) {
            if (b5 != 5) {
                throw new RuntimeException(e0.e());
            }
            d2Var.p(a5, ((Integer) obj).intValue());
        } else if (d2Var.B() == d2.a.ASCENDING) {
            d2Var.k(a5);
            ((x1) obj).r(d2Var);
            d2Var.F(a5);
        } else {
            d2Var.F(a5);
            ((x1) obj).r(d2Var);
            d2Var.k(a5);
        }
    }

    void a() {
        if (!this.f2199e) {
            throw new UnsupportedOperationException();
        }
    }

    public int d() {
        int Y;
        int i5 = this.f2198d;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.f2195a; i7++) {
            int i8 = this.f2196b[i7];
            int a5 = c2.a(i8);
            int b5 = c2.b(i8);
            if (b5 == 0) {
                Y = l.Y(a5, ((Long) this.f2197c[i7]).longValue());
            } else if (b5 == 1) {
                Y = l.p(a5, ((Long) this.f2197c[i7]).longValue());
            } else if (b5 == 2) {
                Y = l.h(a5, (i) this.f2197c[i7]);
            } else if (b5 == 3) {
                Y = (l.V(a5) * 2) + ((x1) this.f2197c[i7]).d();
            } else if (b5 != 5) {
                throw new IllegalStateException(e0.e());
            } else {
                Y = l.n(a5, ((Integer) this.f2197c[i7]).intValue());
            }
            i6 += Y;
        }
        this.f2198d = i6;
        return i6;
    }

    public int e() {
        int i5 = this.f2198d;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.f2195a; i7++) {
            i6 += l.K(c2.a(this.f2196b[i7]), (i) this.f2197c[i7]);
        }
        this.f2198d = i6;
        return i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof x1)) {
            x1 x1Var = (x1) obj;
            int i5 = this.f2195a;
            return i5 == x1Var.f2195a && o(this.f2196b, x1Var.f2196b, i5) && l(this.f2197c, x1Var.f2197c, this.f2195a);
        }
        return false;
    }

    public void h() {
        this.f2199e = false;
    }

    public int hashCode() {
        int i5 = this.f2195a;
        return ((((527 + i5) * 31) + f(this.f2196b, i5)) * 31) + g(this.f2197c, this.f2195a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1 i(x1 x1Var) {
        if (x1Var.equals(c())) {
            return this;
        }
        a();
        int i5 = this.f2195a + x1Var.f2195a;
        b(i5);
        System.arraycopy(x1Var.f2196b, 0, this.f2196b, this.f2195a, x1Var.f2195a);
        System.arraycopy(x1Var.f2197c, 0, this.f2197c, this.f2195a, x1Var.f2195a);
        this.f2195a = i5;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(StringBuilder sb, int i5) {
        for (int i6 = 0; i6 < this.f2195a; i6++) {
            y0.d(sb, i5, String.valueOf(c2.a(this.f2196b[i6])), this.f2197c[i6]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i5, Object obj) {
        a();
        b(this.f2195a + 1);
        int[] iArr = this.f2196b;
        int i6 = this.f2195a;
        iArr[i6] = i5;
        this.f2197c[i6] = obj;
        this.f2195a = i6 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(d2 d2Var) {
        if (d2Var.B() == d2.a.DESCENDING) {
            for (int i5 = this.f2195a - 1; i5 >= 0; i5--) {
                d2Var.h(c2.a(this.f2196b[i5]), this.f2197c[i5]);
            }
            return;
        }
        for (int i6 = 0; i6 < this.f2195a; i6++) {
            d2Var.h(c2.a(this.f2196b[i6]), this.f2197c[i6]);
        }
    }

    public void r(d2 d2Var) {
        if (this.f2195a == 0) {
            return;
        }
        if (d2Var.B() == d2.a.ASCENDING) {
            for (int i5 = 0; i5 < this.f2195a; i5++) {
                q(this.f2196b[i5], this.f2197c[i5], d2Var);
            }
            return;
        }
        for (int i6 = this.f2195a - 1; i6 >= 0; i6--) {
            q(this.f2196b[i6], this.f2197c[i6], d2Var);
        }
    }
}
