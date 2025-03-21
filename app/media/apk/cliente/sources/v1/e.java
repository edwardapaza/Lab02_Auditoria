package v1;

import java.util.ArrayList;
import java.util.List;
import v1.e;
import z1.h0;
/* loaded from: classes.dex */
public abstract class e<B extends e<B>> implements Comparable<B> {

    /* renamed from: a  reason: collision with root package name */
    final List<String> f8114a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(List<String> list) {
        this.f8114a = list;
    }

    public B a(String str) {
        ArrayList arrayList = new ArrayList(this.f8114a);
        arrayList.add(str);
        return h(arrayList);
    }

    public B c(B b5) {
        ArrayList arrayList = new ArrayList(this.f8114a);
        arrayList.addAll(b5.f8114a);
        return h(arrayList);
    }

    public abstract String d();

    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(B b5) {
        int p5 = p();
        int p6 = b5.p();
        for (int i5 = 0; i5 < p5 && i5 < p6; i5++) {
            int compareTo = m(i5).compareTo(b5.m(i5));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return h0.l(p5, p6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && compareTo((e) obj) == 0;
    }

    abstract B h(List<String> list);

    public int hashCode() {
        return ((getClass().hashCode() + 37) * 37) + this.f8114a.hashCode();
    }

    public String k() {
        return this.f8114a.get(p() - 1);
    }

    public String m(int i5) {
        return this.f8114a.get(i5);
    }

    public boolean n() {
        return p() == 0;
    }

    public boolean o(B b5) {
        if (p() > b5.p()) {
            return false;
        }
        for (int i5 = 0; i5 < p(); i5++) {
            if (!m(i5).equals(b5.m(i5))) {
                return false;
            }
        }
        return true;
    }

    public int p() {
        return this.f8114a.size();
    }

    public B q(int i5) {
        int p5 = p();
        z1.b.d(p5 >= i5, "Can't call popFirst with count > length() (%d > %d)", Integer.valueOf(i5), Integer.valueOf(p5));
        return h(this.f8114a.subList(i5, p5));
    }

    public B r() {
        return h(this.f8114a.subList(0, p() - 1));
    }

    public String toString() {
        return d();
    }
}
