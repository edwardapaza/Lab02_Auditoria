package t1;

import com.google.protobuf.i;
import v1.q;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final g f7595a = new g();

    /* renamed from: b  reason: collision with root package name */
    private final a f7596b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final b f7597c = new b();

    /* loaded from: classes.dex */
    class a extends t1.b {
        a() {
        }

        @Override // t1.b
        public void a(i iVar) {
            d.this.f7595a.h(iVar);
        }

        @Override // t1.b
        public void b(double d5) {
            d.this.f7595a.j(d5);
        }

        @Override // t1.b
        public void c() {
            d.this.f7595a.n();
        }

        @Override // t1.b
        public void d(long j5) {
            d.this.f7595a.r(j5);
        }

        @Override // t1.b
        public void e(String str) {
            d.this.f7595a.v(str);
        }
    }

    /* loaded from: classes.dex */
    class b extends t1.b {
        b() {
        }

        @Override // t1.b
        public void a(i iVar) {
            d.this.f7595a.i(iVar);
        }

        @Override // t1.b
        public void b(double d5) {
            d.this.f7595a.k(d5);
        }

        @Override // t1.b
        public void c() {
            d.this.f7595a.o();
        }

        @Override // t1.b
        public void d(long j5) {
            d.this.f7595a.s(j5);
        }

        @Override // t1.b
        public void e(String str) {
            d.this.f7595a.w(str);
        }
    }

    public t1.b b(q.c.a aVar) {
        return aVar.equals(q.c.a.DESCENDING) ? this.f7597c : this.f7596b;
    }

    public byte[] c() {
        return this.f7595a.a();
    }

    public void d(byte[] bArr) {
        this.f7595a.c(bArr);
    }
}
