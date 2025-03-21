package m1;

import m1.h;
/* loaded from: classes.dex */
public class i<K, V> extends j<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(K k5, V v5) {
        super(k5, v5, g.i(), g.i());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(K k5, V v5, h<K, V> hVar, h<K, V> hVar2) {
        super(k5, v5, hVar, hVar2);
    }

    @Override // m1.h
    public boolean c() {
        return true;
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
        return new i(k5, v5, hVar, hVar2);
    }

    @Override // m1.j
    protected h.a m() {
        return h.a.RED;
    }

    @Override // m1.h
    public int size() {
        return a().size() + 1 + e().size();
    }
}
