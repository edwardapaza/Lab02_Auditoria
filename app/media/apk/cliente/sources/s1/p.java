package s1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class p extends q {

    /* renamed from: a  reason: collision with root package name */
    private final b f7444a;

    /* renamed from: b  reason: collision with root package name */
    private final i2.d0 f7445b;

    /* renamed from: c  reason: collision with root package name */
    private final v1.r f7446c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7447a;

        static {
            int[] iArr = new int[b.values().length];
            f7447a = iArr;
            try {
                iArr[b.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7447a[b.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7447a[b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7447a[b.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7447a[b.GREATER_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7447a[b.GREATER_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        LESS_THAN("<"),
        LESS_THAN_OR_EQUAL("<="),
        EQUAL("=="),
        NOT_EQUAL("!="),
        GREATER_THAN(">"),
        GREATER_THAN_OR_EQUAL(">="),
        ARRAY_CONTAINS("array_contains"),
        ARRAY_CONTAINS_ANY("array_contains_any"),
        IN("in"),
        NOT_IN("not_in");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f7459a;

        b(String str) {
            this.f7459a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f7459a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public p(v1.r rVar, b bVar, i2.d0 d0Var) {
        this.f7446c = rVar;
        this.f7444a = bVar;
        this.f7445b = d0Var;
    }

    public static p e(v1.r rVar, b bVar, i2.d0 d0Var) {
        if (!rVar.w()) {
            return bVar == b.ARRAY_CONTAINS ? new f(rVar, d0Var) : bVar == b.IN ? new p0(rVar, d0Var) : bVar == b.ARRAY_CONTAINS_ANY ? new e(rVar, d0Var) : bVar == b.NOT_IN ? new x0(rVar, d0Var) : new p(rVar, bVar, d0Var);
        } else if (bVar == b.IN) {
            return new r0(rVar, d0Var);
        } else {
            if (bVar == b.NOT_IN) {
                return new s0(rVar, d0Var);
            }
            boolean z4 = (bVar == b.ARRAY_CONTAINS || bVar == b.ARRAY_CONTAINS_ANY) ? false : true;
            z1.b.d(z4, bVar.toString() + "queries don't make sense on document keys", new Object[0]);
            return new q0(rVar, bVar, d0Var);
        }
    }

    @Override // s1.q
    public String a() {
        return f().d() + g().toString() + v1.z.b(h());
    }

    @Override // s1.q
    public List<q> b() {
        return Collections.singletonList(this);
    }

    @Override // s1.q
    public List<p> c() {
        return Collections.singletonList(this);
    }

    @Override // s1.q
    public boolean d(v1.i iVar) {
        i2.d0 e5 = iVar.e(this.f7446c);
        return this.f7444a == b.NOT_EQUAL ? e5 != null && j(v1.z.i(e5, this.f7445b)) : e5 != null && v1.z.G(e5) == v1.z.G(this.f7445b) && j(v1.z.i(e5, this.f7445b));
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f7444a == pVar.f7444a && this.f7446c.equals(pVar.f7446c) && this.f7445b.equals(pVar.f7445b);
    }

    public v1.r f() {
        return this.f7446c;
    }

    public b g() {
        return this.f7444a;
    }

    public i2.d0 h() {
        return this.f7445b;
    }

    public int hashCode() {
        return ((((1147 + this.f7444a.hashCode()) * 31) + this.f7446c.hashCode()) * 31) + this.f7445b.hashCode();
    }

    public boolean i() {
        return Arrays.asList(b.LESS_THAN, b.LESS_THAN_OR_EQUAL, b.GREATER_THAN, b.GREATER_THAN_OR_EQUAL, b.NOT_EQUAL, b.NOT_IN).contains(this.f7444a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(int i5) {
        switch (a.f7447a[this.f7444a.ordinal()]) {
            case 1:
                return i5 < 0;
            case 2:
                return i5 <= 0;
            case 3:
                return i5 == 0;
            case 4:
                return i5 != 0;
            case 5:
                return i5 > 0;
            case 6:
                return i5 >= 0;
            default:
                throw z1.b.a("Unknown FieldFilter operator: %s", this.f7444a);
        }
    }

    public String toString() {
        return a();
    }
}
