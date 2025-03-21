package y1;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import y1.z0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: b  reason: collision with root package name */
    private static final x0 f8542b = new x0();

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<AtomicReference<c>> f8543a = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class a {
        static a d(n nVar, boolean z4, int i5, int i6, int i7) {
            return new l(nVar, z4, i5, i6, i7);
        }

        static a e(n nVar, z0.b bVar, s sVar) {
            i2.g b5 = sVar.b();
            if (b5 == null) {
                return null;
            }
            return d(nVar, bVar == z0.b.SUCCESS, b5.g0(), b5.e0().e0().size(), b5.e0().g0());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract boolean a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int b();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract n c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int f();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class b {
        static b b(int i5, int i6, String str, String str2, a aVar) {
            return new m(i5, i6, str, str2, aVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b e(int i5, s sVar, v1.f fVar, n nVar, z0.b bVar) {
            return b(i5, sVar.a(), fVar.h(), fVar.e(), a.e(nVar, bVar, sVar));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract String c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int d();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int f();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract String g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void a(b bVar);
    }

    private x0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x0 a() {
        return f8542b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(b bVar) {
        Iterator<AtomicReference<c>> it = this.f8543a.iterator();
        while (it.hasNext()) {
            c cVar = it.next().get();
            if (cVar != null) {
                cVar.a(bVar);
            }
        }
    }
}
