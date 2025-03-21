package y1;

import i3.j1;
import java.util.List;
/* loaded from: classes.dex */
public abstract class y0 {

    /* loaded from: classes.dex */
    public static final class b extends y0 {

        /* renamed from: a  reason: collision with root package name */
        private final List<Integer> f8547a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Integer> f8548b;

        /* renamed from: c  reason: collision with root package name */
        private final v1.l f8549c;

        /* renamed from: d  reason: collision with root package name */
        private final v1.s f8550d;

        public b(List<Integer> list, List<Integer> list2, v1.l lVar, v1.s sVar) {
            super();
            this.f8547a = list;
            this.f8548b = list2;
            this.f8549c = lVar;
            this.f8550d = sVar;
        }

        public v1.l a() {
            return this.f8549c;
        }

        public v1.s b() {
            return this.f8550d;
        }

        public List<Integer> c() {
            return this.f8548b;
        }

        public List<Integer> d() {
            return this.f8547a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f8547a.equals(bVar.f8547a) && this.f8548b.equals(bVar.f8548b) && this.f8549c.equals(bVar.f8549c)) {
                v1.s sVar = this.f8550d;
                v1.s sVar2 = bVar.f8550d;
                return sVar != null ? sVar.equals(sVar2) : sVar2 == null;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.f8547a.hashCode() * 31) + this.f8548b.hashCode()) * 31) + this.f8549c.hashCode()) * 31;
            v1.s sVar = this.f8550d;
            return hashCode + (sVar != null ? sVar.hashCode() : 0);
        }

        public String toString() {
            return "DocumentChange{updatedTargetIds=" + this.f8547a + ", removedTargetIds=" + this.f8548b + ", key=" + this.f8549c + ", newDocument=" + this.f8550d + '}';
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends y0 {

        /* renamed from: a  reason: collision with root package name */
        private final int f8551a;

        /* renamed from: b  reason: collision with root package name */
        private final s f8552b;

        public c(int i5, s sVar) {
            super();
            this.f8551a = i5;
            this.f8552b = sVar;
        }

        public s a() {
            return this.f8552b;
        }

        public int b() {
            return this.f8551a;
        }

        public String toString() {
            return "ExistenceFilterWatchChange{targetId=" + this.f8551a + ", existenceFilter=" + this.f8552b + '}';
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends y0 {

        /* renamed from: a  reason: collision with root package name */
        private final e f8553a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Integer> f8554b;

        /* renamed from: c  reason: collision with root package name */
        private final com.google.protobuf.i f8555c;

        /* renamed from: d  reason: collision with root package name */
        private final j1 f8556d;

        public d(e eVar, List<Integer> list, com.google.protobuf.i iVar, j1 j1Var) {
            super();
            z1.b.d(j1Var == null || eVar == e.Removed, "Got cause for a target change that was not a removal", new Object[0]);
            this.f8553a = eVar;
            this.f8554b = list;
            this.f8555c = iVar;
            if (j1Var == null || j1Var.o()) {
                this.f8556d = null;
            } else {
                this.f8556d = j1Var;
            }
        }

        public j1 a() {
            return this.f8556d;
        }

        public e b() {
            return this.f8553a;
        }

        public com.google.protobuf.i c() {
            return this.f8555c;
        }

        public List<Integer> d() {
            return this.f8554b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f8553a == dVar.f8553a && this.f8554b.equals(dVar.f8554b) && this.f8555c.equals(dVar.f8555c)) {
                j1 j1Var = this.f8556d;
                return j1Var != null ? dVar.f8556d != null && j1Var.m().equals(dVar.f8556d.m()) : dVar.f8556d == null;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.f8553a.hashCode() * 31) + this.f8554b.hashCode()) * 31) + this.f8555c.hashCode()) * 31;
            j1 j1Var = this.f8556d;
            return hashCode + (j1Var != null ? j1Var.m().hashCode() : 0);
        }

        public String toString() {
            return "WatchTargetChange{changeType=" + this.f8553a + ", targetIds=" + this.f8554b + '}';
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        NoChange,
        Added,
        Removed,
        Current,
        Reset
    }

    private y0() {
    }
}
