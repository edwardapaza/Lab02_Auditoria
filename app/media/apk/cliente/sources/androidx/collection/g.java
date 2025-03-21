package androidx.collection;
/* loaded from: classes.dex */
public class g<E> implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f223e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private boolean f224a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f225b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f226c;

    /* renamed from: d  reason: collision with root package name */
    private int f227d;

    public g() {
        this(10);
    }

    public g(int i5) {
        this.f224a = false;
        if (i5 == 0) {
            this.f225b = c.f198a;
            this.f226c = c.f200c;
            return;
        }
        int d5 = c.d(i5);
        this.f225b = new int[d5];
        this.f226c = new Object[d5];
    }

    private void c() {
        int i5 = this.f227d;
        int[] iArr = this.f225b;
        Object[] objArr = this.f226c;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            if (obj != f223e) {
                if (i7 != i6) {
                    iArr[i6] = iArr[i7];
                    objArr[i6] = obj;
                    objArr[i7] = null;
                }
                i6++;
            }
        }
        this.f224a = false;
        this.f227d = i6;
    }

    public void a() {
        int i5 = this.f227d;
        Object[] objArr = this.f226c;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        this.f227d = 0;
        this.f224a = false;
    }

    /* renamed from: b */
    public g<E> clone() {
        try {
            g<E> gVar = (g) super.clone();
            gVar.f225b = (int[]) this.f225b.clone();
            gVar.f226c = (Object[]) this.f226c.clone();
            return gVar;
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    public int d(int i5) {
        if (this.f224a) {
            c();
        }
        return this.f225b[i5];
    }

    public int e() {
        if (this.f224a) {
            c();
        }
        return this.f227d;
    }

    public E f(int i5) {
        if (this.f224a) {
            c();
        }
        return (E) this.f226c[i5];
    }

    public String toString() {
        if (e() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f227d * 28);
        sb.append('{');
        for (int i5 = 0; i5 < this.f227d; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            sb.append(d(i5));
            sb.append('=');
            E f5 = f(i5);
            if (f5 != this) {
                sb.append(f5);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
