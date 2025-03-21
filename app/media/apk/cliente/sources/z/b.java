package z;

import android.graphics.Rect;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f8816a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8817b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8818c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8819d;

    public b(int i5, int i6, int i7, int i8) {
        this.f8816a = i5;
        this.f8817b = i6;
        this.f8818c = i7;
        this.f8819d = i8;
        if (!(i5 <= i7)) {
            throw new IllegalArgumentException(("Left must be less than or equal to right, left: " + i5 + ", right: " + i7).toString());
        }
        if (i6 <= i8) {
            return;
        }
        throw new IllegalArgumentException(("top must be less than or equal to bottom, top: " + i6 + ", bottom: " + i8).toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        e4.k.e(rect, "rect");
    }

    public final int a() {
        return this.f8819d - this.f8817b;
    }

    public final int b() {
        return this.f8816a;
    }

    public final int c() {
        return this.f8817b;
    }

    public final int d() {
        return this.f8818c - this.f8816a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (e4.k.a(b.class, obj != null ? obj.getClass() : null)) {
            e4.k.c(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
            b bVar = (b) obj;
            return this.f8816a == bVar.f8816a && this.f8817b == bVar.f8817b && this.f8818c == bVar.f8818c && this.f8819d == bVar.f8819d;
        }
        return false;
    }

    public final Rect f() {
        return new Rect(this.f8816a, this.f8817b, this.f8818c, this.f8819d);
    }

    public int hashCode() {
        return (((((this.f8816a * 31) + this.f8817b) * 31) + this.f8818c) * 31) + this.f8819d;
    }

    public String toString() {
        return b.class.getSimpleName() + " { [" + this.f8816a + ',' + this.f8817b + ',' + this.f8818c + ',' + this.f8819d + "] }";
    }
}
