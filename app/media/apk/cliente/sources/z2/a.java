package z2;

import java.nio.ByteBuffer;
import z2.b;
/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final z2.b f8980a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8981b;

    /* renamed from: c  reason: collision with root package name */
    private final h<T> f8982c;

    /* renamed from: d  reason: collision with root package name */
    private final b.c f8983d;

    /* loaded from: classes.dex */
    private final class b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final d<T> f8984a;

        /* renamed from: z2.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0138a implements e<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b.InterfaceC0139b f8986a;

            C0138a(b.InterfaceC0139b interfaceC0139b) {
                this.f8986a = interfaceC0139b;
            }

            @Override // z2.a.e
            public void a(T t5) {
                this.f8986a.a(a.this.f8982c.a(t5));
            }
        }

        private b(d<T> dVar) {
            this.f8984a = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // z2.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0139b interfaceC0139b) {
            try {
                this.f8984a.a(a.this.f8982c.b(byteBuffer), new C0138a(interfaceC0139b));
            } catch (RuntimeException e5) {
                n2.b.c("BasicMessageChannel#" + a.this.f8981b, "Failed to handle message", e5);
                interfaceC0139b.a(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c implements b.InterfaceC0139b {

        /* renamed from: a  reason: collision with root package name */
        private final e<T> f8988a;

        private c(e<T> eVar) {
            this.f8988a = eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // z2.b.InterfaceC0139b
        public void a(ByteBuffer byteBuffer) {
            try {
                this.f8988a.a(a.this.f8982c.b(byteBuffer));
            } catch (RuntimeException e5) {
                n2.b.c("BasicMessageChannel#" + a.this.f8981b, "Failed to handle message reply", e5);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d<T> {
        void a(T t5, e<T> eVar);
    }

    /* loaded from: classes.dex */
    public interface e<T> {
        void a(T t5);
    }

    public a(z2.b bVar, String str, h<T> hVar) {
        this(bVar, str, hVar, null);
    }

    public a(z2.b bVar, String str, h<T> hVar, b.c cVar) {
        this.f8980a = bVar;
        this.f8981b = str;
        this.f8982c = hVar;
        this.f8983d = cVar;
    }

    public void c(T t5) {
        d(t5, null);
    }

    public void d(T t5, e<T> eVar) {
        this.f8980a.a(this.f8981b, this.f8982c.a(t5), eVar != null ? new c(eVar) : null);
    }

    public void e(d<T> dVar) {
        if (this.f8983d != null) {
            this.f8980a.e(this.f8981b, dVar != null ? new b(dVar) : null, this.f8983d);
        } else {
            this.f8980a.b(this.f8981b, dVar != null ? new b(dVar) : null);
        }
    }
}
