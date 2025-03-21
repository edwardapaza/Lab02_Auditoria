package j4;

import d4.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import t3.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends i {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class a<T> implements Iterable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f5540a;

        public a(b bVar) {
            this.f5540a = bVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f5540a.iterator();
        }
    }

    public static <T> Iterable<T> e(b<? extends T> bVar) {
        e4.k.e(bVar, "<this>");
        return new a(bVar);
    }

    public static <T, R> b<R> f(b<? extends T> bVar, l<? super T, ? extends R> lVar) {
        e4.k.e(bVar, "<this>");
        e4.k.e(lVar, "transform");
        return new k(bVar, lVar);
    }

    public static final <T, C extends Collection<? super T>> C g(b<? extends T> bVar, C c5) {
        e4.k.e(bVar, "<this>");
        e4.k.e(c5, "destination");
        for (T t5 : bVar) {
            c5.add(t5);
        }
        return c5;
    }

    public static <T> List<T> h(b<? extends T> bVar) {
        List<T> i5;
        e4.k.e(bVar, "<this>");
        i5 = p.i(i(bVar));
        return i5;
    }

    public static final <T> List<T> i(b<? extends T> bVar) {
        e4.k.e(bVar, "<this>");
        return (List) g(bVar, new ArrayList());
    }
}
