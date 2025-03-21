package i3;

import i3.b;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class m extends i3.b {

    /* renamed from: a  reason: collision with root package name */
    private final i3.b f3490a;

    /* renamed from: b  reason: collision with root package name */
    private final i3.b f3491b;

    /* loaded from: classes.dex */
    private static final class a extends b.a {

        /* renamed from: a  reason: collision with root package name */
        private final b.a f3492a;

        /* renamed from: b  reason: collision with root package name */
        private final y0 f3493b;

        public a(b.a aVar, y0 y0Var) {
            this.f3492a = aVar;
            this.f3493b = y0Var;
        }

        @Override // i3.b.a
        public void a(y0 y0Var) {
            z0.k.o(y0Var, "headers");
            y0 y0Var2 = new y0();
            y0Var2.m(this.f3493b);
            y0Var2.m(y0Var);
            this.f3492a.a(y0Var2);
        }

        @Override // i3.b.a
        public void b(j1 j1Var) {
            this.f3492a.b(j1Var);
        }
    }

    /* loaded from: classes.dex */
    private final class b extends b.a {

        /* renamed from: a  reason: collision with root package name */
        private final b.AbstractC0068b f3494a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f3495b;

        /* renamed from: c  reason: collision with root package name */
        private final b.a f3496c;

        /* renamed from: d  reason: collision with root package name */
        private final r f3497d;

        public b(b.AbstractC0068b abstractC0068b, Executor executor, b.a aVar, r rVar) {
            this.f3494a = abstractC0068b;
            this.f3495b = executor;
            this.f3496c = (b.a) z0.k.o(aVar, "delegate");
            this.f3497d = (r) z0.k.o(rVar, "context");
        }

        @Override // i3.b.a
        public void a(y0 y0Var) {
            z0.k.o(y0Var, "headers");
            r b5 = this.f3497d.b();
            try {
                m.this.f3491b.a(this.f3494a, this.f3495b, new a(this.f3496c, y0Var));
            } finally {
                this.f3497d.f(b5);
            }
        }

        @Override // i3.b.a
        public void b(j1 j1Var) {
            this.f3496c.b(j1Var);
        }
    }

    public m(i3.b bVar, i3.b bVar2) {
        this.f3490a = (i3.b) z0.k.o(bVar, "creds1");
        this.f3491b = (i3.b) z0.k.o(bVar2, "creds2");
    }

    @Override // i3.b
    public void a(b.AbstractC0068b abstractC0068b, Executor executor, b.a aVar) {
        this.f3490a.a(abstractC0068b, executor, new b(abstractC0068b, executor, aVar, r.e()));
    }
}
