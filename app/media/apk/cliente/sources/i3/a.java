package i3;

import java.util.IdentityHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final IdentityHashMap<c<?>, Object> f3306b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f3307c;

    /* renamed from: a  reason: collision with root package name */
    private final IdentityHashMap<c<?>, Object> f3308a;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private a f3309a;

        /* renamed from: b  reason: collision with root package name */
        private IdentityHashMap<c<?>, Object> f3310b;

        private b(a aVar) {
            this.f3309a = aVar;
        }

        private IdentityHashMap<c<?>, Object> b(int i5) {
            if (this.f3310b == null) {
                this.f3310b = new IdentityHashMap<>(i5);
            }
            return this.f3310b;
        }

        public a a() {
            if (this.f3310b != null) {
                for (Map.Entry entry : this.f3309a.f3308a.entrySet()) {
                    if (!this.f3310b.containsKey(entry.getKey())) {
                        this.f3310b.put((c) entry.getKey(), entry.getValue());
                    }
                }
                this.f3309a = new a(this.f3310b);
                this.f3310b = null;
            }
            return this.f3309a;
        }

        public <T> b c(c<T> cVar) {
            if (this.f3309a.f3308a.containsKey(cVar)) {
                IdentityHashMap identityHashMap = new IdentityHashMap(this.f3309a.f3308a);
                identityHashMap.remove(cVar);
                this.f3309a = new a(identityHashMap);
            }
            IdentityHashMap<c<?>, Object> identityHashMap2 = this.f3310b;
            if (identityHashMap2 != null) {
                identityHashMap2.remove(cVar);
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <T> b d(c<T> cVar, T t5) {
            b(1).put(cVar, t5);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f3311a;

        private c(String str) {
            this.f3311a = str;
        }

        public static <T> c<T> a(String str) {
            return new c<>(str);
        }

        public String toString() {
            return this.f3311a;
        }
    }

    static {
        IdentityHashMap<c<?>, Object> identityHashMap = new IdentityHashMap<>();
        f3306b = identityHashMap;
        f3307c = new a(identityHashMap);
    }

    private a(IdentityHashMap<c<?>, Object> identityHashMap) {
        this.f3308a = identityHashMap;
    }

    public static b c() {
        return new b();
    }

    public <T> T b(c<T> cVar) {
        return (T) this.f3308a.get(cVar);
    }

    public b d() {
        return new b();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L4
            return r0
        L4:
            r1 = 0
            if (r7 == 0) goto L5a
            java.lang.Class<i3.a> r2 = i3.a.class
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L10
            goto L5a
        L10:
            i3.a r7 = (i3.a) r7
            java.util.IdentityHashMap<i3.a$c<?>, java.lang.Object> r2 = r6.f3308a
            int r2 = r2.size()
            java.util.IdentityHashMap<i3.a$c<?>, java.lang.Object> r3 = r7.f3308a
            int r3 = r3.size()
            if (r2 == r3) goto L21
            return r1
        L21:
            java.util.IdentityHashMap<i3.a$c<?>, java.lang.Object> r2 = r6.f3308a
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L2b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L59
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.util.IdentityHashMap<i3.a$c<?>, java.lang.Object> r4 = r7.f3308a
            java.lang.Object r5 = r3.getKey()
            boolean r4 = r4.containsKey(r5)
            if (r4 != 0) goto L44
            return r1
        L44:
            java.lang.Object r4 = r3.getValue()
            java.util.IdentityHashMap<i3.a$c<?>, java.lang.Object> r5 = r7.f3308a
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r5.get(r3)
            boolean r3 = z0.g.a(r4, r3)
            if (r3 != 0) goto L2b
            return r1
        L59:
            return r0
        L5a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i5 = 0;
        for (Map.Entry<c<?>, Object> entry : this.f3308a.entrySet()) {
            i5 += z0.g.b(entry.getKey(), entry.getValue());
        }
        return i5;
    }

    public String toString() {
        return this.f3308a.toString();
    }
}
