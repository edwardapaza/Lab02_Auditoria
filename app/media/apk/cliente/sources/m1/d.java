package m1;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public class d<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<j<K, V>> f6058a = new ArrayDeque<>();

    /* renamed from: b  reason: collision with root package name */
    private final boolean f6059b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(h<K, V> hVar, K k5, Comparator<K> comparator, boolean z4) {
        int i5;
        this.f6059b = z4;
        while (!hVar.isEmpty()) {
            if (k5 != null) {
                K key = hVar.getKey();
                i5 = z4 ? comparator.compare(k5, key) : comparator.compare(key, k5);
            } else {
                i5 = 1;
            }
            if (i5 < 0) {
                hVar = z4 ? hVar.a() : hVar.e();
            } else if (i5 == 0) {
                this.f6058a.push((j) hVar);
                return;
            } else {
                this.f6058a.push((j) hVar);
                if (z4) {
                }
            }
        }
    }

    @Override // java.util.Iterator
    /* renamed from: b */
    public Map.Entry<K, V> next() {
        try {
            j<K, V> pop = this.f6058a.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(pop.getKey(), pop.getValue());
            if (this.f6059b) {
                for (h<K, V> a5 = pop.a(); !a5.isEmpty(); a5 = a5.e()) {
                    this.f6058a.push((j) a5);
                }
            } else {
                for (h<K, V> e5 = pop.e(); !e5.isEmpty(); e5 = e5.a()) {
                    this.f6058a.push((j) e5);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException unused) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f6058a.size() > 0;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
