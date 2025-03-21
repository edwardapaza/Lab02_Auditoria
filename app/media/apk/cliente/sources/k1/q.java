package k1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
class q {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final k1.c<?> f5603a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<b> f5604b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set<b> f5605c = new HashSet();

        b(k1.c<?> cVar) {
            this.f5603a = cVar;
        }

        void a(b bVar) {
            this.f5604b.add(bVar);
        }

        void b(b bVar) {
            this.f5605c.add(bVar);
        }

        k1.c<?> c() {
            return this.f5603a;
        }

        Set<b> d() {
            return this.f5604b;
        }

        boolean e() {
            return this.f5604b.isEmpty();
        }

        boolean f() {
            return this.f5605c.isEmpty();
        }

        void g(b bVar) {
            this.f5605c.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private final f0<?> f5606a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f5607b;

        private c(f0<?> f0Var, boolean z4) {
            this.f5606a = f0Var;
            this.f5607b = z4;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return cVar.f5606a.equals(this.f5606a) && cVar.f5607b == this.f5607b;
            }
            return false;
        }

        public int hashCode() {
            return ((this.f5606a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f5607b).hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(List<k1.c<?>> list) {
        Set<b> c5 = c(list);
        Set<b> b5 = b(c5);
        int i5 = 0;
        while (!b5.isEmpty()) {
            b next = b5.iterator().next();
            b5.remove(next);
            i5++;
            for (b bVar : next.d()) {
                bVar.g(next);
                if (bVar.f()) {
                    b5.add(bVar);
                }
            }
        }
        if (i5 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : c5) {
            if (!bVar2.f() && !bVar2.e()) {
                arrayList.add(bVar2.c());
            }
        }
        throw new s(arrayList);
    }

    private static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    private static Set<b> c(List<k1.c<?>> list) {
        Set<b> set;
        HashMap hashMap = new HashMap(list.size());
        for (k1.c<?> cVar : list) {
            b bVar = new b(cVar);
            for (f0<? super Object> f0Var : cVar.j()) {
                c cVar2 = new c(f0Var, !cVar.p());
                if (!hashMap.containsKey(cVar2)) {
                    hashMap.put(cVar2, new HashSet());
                }
                Set set2 = (Set) hashMap.get(cVar2);
                if (!set2.isEmpty() && !cVar2.f5607b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", f0Var));
                }
                set2.add(bVar);
            }
        }
        for (Set<b> set3 : hashMap.values()) {
            for (b bVar2 : set3) {
                for (r rVar : bVar2.c().g()) {
                    if (rVar.e() && (set = (Set) hashMap.get(new c(rVar.c(), rVar.g()))) != null) {
                        for (b bVar3 : set) {
                            bVar2.a(bVar3);
                            bVar3.b(bVar2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set set4 : hashMap.values()) {
            hashSet.addAll(set4);
        }
        return hashSet;
    }
}
