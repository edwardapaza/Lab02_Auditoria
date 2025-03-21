package n3;

import l3.e;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final n3.a f6337a;

    /* renamed from: b  reason: collision with root package name */
    private final e f6338b;

    /* renamed from: n3.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0099b {

        /* renamed from: a  reason: collision with root package name */
        private n3.a f6339a;

        /* renamed from: b  reason: collision with root package name */
        private e.b f6340b = new e.b();

        public b c() {
            if (this.f6339a != null) {
                return new b(this);
            }
            throw new IllegalStateException("url == null");
        }

        public C0099b d(String str, String str2) {
            this.f6340b.f(str, str2);
            return this;
        }

        public C0099b e(n3.a aVar) {
            if (aVar != null) {
                this.f6339a = aVar;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }
    }

    private b(C0099b c0099b) {
        this.f6337a = c0099b.f6339a;
        this.f6338b = c0099b.f6340b.c();
    }

    public e a() {
        return this.f6338b;
    }

    public n3.a b() {
        return this.f6337a;
    }

    public String toString() {
        return "Request{url=" + this.f6337a + '}';
    }
}
