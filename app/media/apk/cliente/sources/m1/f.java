package m1;

import m1.h;
/* loaded from: classes.dex */
public class f<K, V> extends j<K, V> {

    /* renamed from: e  reason: collision with root package name */
    private int f6062e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(K k5, V v5, h<K, V> hVar, h<K, V> hVar2) {
        super(k5, v5, hVar, hVar2);
        this.f6062e = -1;
    }

    @Override // m1.h
    public boolean c() {
        return false;
    }

    @Override // m1.j
    protected j<K, V> k(K k5, V v5, h<K, V> hVar, h<K, V> hVar2) {
        if (k5 == null) {
            k5 = getKey();
        }
        if (v5 == null) {
            v5 = getValue();
        }
        if (hVar == null) {
            hVar = a();
        }
        if (hVar2 == null) {
            hVar2 = e();
        }
        return new f(k5, v5, hVar, hVar2);
    }

    @Override // m1.j
    protected h.a m() {
        return h.a.BLACK;
    }

    @Override // m1.h
    public int size() {
        if (this.f6062e == -1) {
            this.f6062e = a().size() + 1 + e().size();
        }
        return this.f6062e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // m1.j
    public void t(h<K, V> hVar) {
        if (this.f6062e != -1) {
            throw new IllegalStateException("Can't set left after using size");
        }
        super.t(hVar);
    }
}
