package a1;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    class a<T> extends z<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f34a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f35b;

        a(Object obj) {
            this.f35b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f34a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f34a) {
                throw new NoSuchElementException();
            }
            this.f34a = true;
            return (T) this.f35b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L0:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L1d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto Le
            return r1
        Le:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = z0.g.a(r0, r2)
            if (r0 != 0) goto L0
            return r1
        L1d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.m.a(java.util.Iterator, java.util.Iterator):boolean");
    }

    public static <T> z<T> b(T t5) {
        return new a(t5);
    }
}
