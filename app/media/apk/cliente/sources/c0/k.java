package c0;

import android.graphics.Rect;
import androidx.core.view.c0;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final z.b f825a;

    /* renamed from: b  reason: collision with root package name */
    private final c0 f826b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(Rect rect, c0 c0Var) {
        this(new z.b(rect), c0Var);
        e4.k.e(rect, "bounds");
        e4.k.e(c0Var, "insets");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ k(android.graphics.Rect r1, androidx.core.view.c0 r2, int r3, e4.g r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L12
            androidx.core.view.c0$b r2 = new androidx.core.view.c0$b
            r2.<init>()
            androidx.core.view.c0 r2 = r2.a()
            java.lang.String r3 = "Builder().build()"
            e4.k.d(r2, r3)
        L12:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.k.<init>(android.graphics.Rect, androidx.core.view.c0, int, e4.g):void");
    }

    public k(z.b bVar, c0 c0Var) {
        e4.k.e(bVar, "_bounds");
        e4.k.e(c0Var, "_windowInsetsCompat");
        this.f825a = bVar;
        this.f826b = c0Var;
    }

    public final Rect a() {
        return this.f825a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (e4.k.a(k.class, obj != null ? obj.getClass() : null)) {
            e4.k.c(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
            k kVar = (k) obj;
            return e4.k.a(this.f825a, kVar.f825a) && e4.k.a(this.f826b, kVar.f826b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f825a.hashCode() * 31) + this.f826b.hashCode();
    }

    public String toString() {
        return "WindowMetrics( bounds=" + this.f825a + ", windowInsetsCompat=" + this.f826b + ')';
    }
}
