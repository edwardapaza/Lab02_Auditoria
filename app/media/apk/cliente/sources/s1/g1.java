package s1;
/* loaded from: classes.dex */
public class g1 {

    /* renamed from: a  reason: collision with root package name */
    private int f7333a;

    /* renamed from: b  reason: collision with root package name */
    private int f7334b;

    g1(int i5, int i6) {
        z1.b.d((i5 & 1) == i5, "Generator ID %d contains more than %d reserved bits", Integer.valueOf(i5), 1);
        this.f7334b = i5;
        d(i6);
    }

    public static g1 a() {
        return new g1(1, 1);
    }

    public static g1 b(int i5) {
        g1 g1Var = new g1(0, i5);
        g1Var.c();
        return g1Var;
    }

    private void d(int i5) {
        z1.b.d((i5 & 1) == this.f7334b, "Cannot supply target ID from different generator ID", new Object[0]);
        this.f7333a = i5;
    }

    public int c() {
        int i5 = this.f7333a;
        this.f7333a = i5 + 2;
        return i5;
    }
}
