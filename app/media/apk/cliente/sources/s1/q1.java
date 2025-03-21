package s1;
/* loaded from: classes.dex */
public class q1 {

    /* renamed from: a  reason: collision with root package name */
    private final p1 f7464a;

    /* renamed from: b  reason: collision with root package name */
    private final v1.r f7465b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7466c;

    private q1(p1 p1Var, v1.r rVar, boolean z4) {
        this.f7464a = p1Var;
        this.f7465b = rVar;
        this.f7466c = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q1(p1 p1Var, v1.r rVar, boolean z4, o1 o1Var) {
        this(p1Var, rVar, z4);
    }

    private void k() {
        if (this.f7465b == null) {
            return;
        }
        for (int i5 = 0; i5 < this.f7465b.p(); i5++) {
            l(this.f7465b.m(i5));
        }
    }

    private void l(String str) {
        if (str.isEmpty()) {
            throw f("Document fields must not be empty");
        }
        if (j() && str.startsWith("__") && str.endsWith("__")) {
            throw f("Document fields cannot begin and end with \"__\"");
        }
    }

    public void a(v1.r rVar) {
        this.f7464a.b(rVar);
    }

    public void b(v1.r rVar, w1.p pVar) {
        this.f7464a.c(rVar, pVar);
    }

    public q1 c(int i5) {
        return new q1(this.f7464a, null, true);
    }

    public q1 d(String str) {
        v1.r rVar = this.f7465b;
        q1 q1Var = new q1(this.f7464a, rVar == null ? null : rVar.a(str), false);
        q1Var.l(str);
        return q1Var;
    }

    public q1 e(v1.r rVar) {
        v1.r rVar2 = this.f7465b;
        q1 q1Var = new q1(this.f7464a, rVar2 == null ? null : rVar2.c(rVar), false);
        q1Var.k();
        return q1Var;
    }

    public RuntimeException f(String str) {
        String str2;
        v1.r rVar = this.f7465b;
        if (rVar == null || rVar.n()) {
            str2 = "";
        } else {
            str2 = " (found in field " + this.f7465b.toString() + ")";
        }
        return new IllegalArgumentException("Invalid data. " + str + str2);
    }

    public t1 g() {
        return p1.a(this.f7464a);
    }

    public v1.r h() {
        return this.f7465b;
    }

    public boolean i() {
        return this.f7466c;
    }

    public boolean j() {
        int i5 = o1.f7443a[p1.a(this.f7464a).ordinal()];
        if (i5 == 1 || i5 == 2 || i5 == 3) {
            return true;
        }
        if (i5 == 4 || i5 == 5) {
            return false;
        }
        throw z1.b.a("Unexpected case for UserDataSource: %s", p1.a(this.f7464a).name());
    }
}
