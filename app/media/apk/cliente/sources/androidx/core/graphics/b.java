package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final b f405e = new b(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f406a;

    /* renamed from: b  reason: collision with root package name */
    public final int f407b;

    /* renamed from: c  reason: collision with root package name */
    public final int f408c;

    /* renamed from: d  reason: collision with root package name */
    public final int f409d;

    /* loaded from: classes.dex */
    static class a {
        static Insets a(int i5, int i6, int i7, int i8) {
            return Insets.of(i5, i6, i7, i8);
        }
    }

    private b(int i5, int i6, int i7, int i8) {
        this.f406a = i5;
        this.f407b = i6;
        this.f408c = i7;
        this.f409d = i8;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f406a, bVar2.f406a), Math.max(bVar.f407b, bVar2.f407b), Math.max(bVar.f408c, bVar2.f408c), Math.max(bVar.f409d, bVar2.f409d));
    }

    public static b b(int i5, int i6, int i7, int i8) {
        return (i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) ? f405e : new b(i5, i6, i7, i8);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f406a, this.f407b, this.f408c, this.f409d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f409d == bVar.f409d && this.f406a == bVar.f406a && this.f408c == bVar.f408c && this.f407b == bVar.f407b;
    }

    public int hashCode() {
        return (((((this.f406a * 31) + this.f407b) * 31) + this.f408c) * 31) + this.f409d;
    }

    public String toString() {
        return "Insets{left=" + this.f406a + ", top=" + this.f407b + ", right=" + this.f408c + ", bottom=" + this.f409d + '}';
    }
}
