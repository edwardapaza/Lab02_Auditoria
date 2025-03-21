package j4;

import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends g {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class a<T> implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterator f5539a;

        public a(Iterator it) {
            this.f5539a = it;
        }

        @Override // j4.b
        public Iterator<T> iterator() {
            return this.f5539a;
        }
    }

    public static <T> b<T> c(Iterator<? extends T> it) {
        e4.k.e(it, "<this>");
        return d(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b<T> d(b<? extends T> bVar) {
        e4.k.e(bVar, "<this>");
        return bVar instanceof j4.a ? bVar : new j4.a(bVar);
    }
}
