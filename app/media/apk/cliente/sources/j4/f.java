package j4;

import d4.p;
import java.util.Iterator;
import s3.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class a<T> implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f5538a;

        public a(p pVar) {
            this.f5538a = pVar;
        }

        @Override // j4.b
        public Iterator<T> iterator() {
            Iterator<T> a5;
            a5 = f.a(this.f5538a);
            return a5;
        }
    }

    public static <T> Iterator<T> a(p<? super d<? super T>, ? super v3.d<? super t>, ? extends Object> pVar) {
        v3.d<? super t> a5;
        e4.k.e(pVar, "block");
        c cVar = new c();
        a5 = w3.c.a(pVar, cVar, cVar);
        cVar.f(a5);
        return cVar;
    }

    public static <T> b<T> b(p<? super d<? super T>, ? super v3.d<? super t>, ? extends Object> pVar) {
        e4.k.e(pVar, "block");
        return new a(pVar);
    }
}
