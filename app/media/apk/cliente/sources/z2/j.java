package z2;

import java.nio.ByteBuffer;
import z2.b;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final z2.b f9005a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9006b;

    /* renamed from: c  reason: collision with root package name */
    private final k f9007c;

    /* renamed from: d  reason: collision with root package name */
    private final b.c f9008d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final c f9009a;

        /* renamed from: z2.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0141a implements d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b.InterfaceC0139b f9011a;

            C0141a(b.InterfaceC0139b interfaceC0139b) {
                this.f9011a = interfaceC0139b;
            }

            @Override // z2.j.d
            public void a(Object obj) {
                this.f9011a.a(j.this.f9007c.a(obj));
            }

            @Override // z2.j.d
            public void b(String str, String str2, Object obj) {
                this.f9011a.a(j.this.f9007c.c(str, str2, obj));
            }

            @Override // z2.j.d
            public void c() {
                this.f9011a.a(null);
            }
        }

        a(c cVar) {
            this.f9009a = cVar;
        }

        @Override // z2.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0139b interfaceC0139b) {
            try {
                this.f9009a.a(j.this.f9007c.e(byteBuffer), new C0141a(interfaceC0139b));
            } catch (RuntimeException e5) {
                n2.b.c("MethodChannel#" + j.this.f9006b, "Failed to handle method call", e5);
                interfaceC0139b.a(j.this.f9007c.b("error", e5.getMessage(), null, n2.b.d(e5)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements b.InterfaceC0139b {

        /* renamed from: a  reason: collision with root package name */
        private final d f9013a;

        b(d dVar) {
            this.f9013a = dVar;
        }

        @Override // z2.b.InterfaceC0139b
        public void a(ByteBuffer byteBuffer) {
            try {
                if (byteBuffer == null) {
                    this.f9013a.c();
                } else {
                    try {
                        this.f9013a.a(j.this.f9007c.f(byteBuffer));
                    } catch (z2.d e5) {
                        this.f9013a.b(e5.f8999a, e5.getMessage(), e5.f9000b);
                    }
                }
            } catch (RuntimeException e6) {
                n2.b.c("MethodChannel#" + j.this.f9006b, "Failed to handle method call result", e6);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(i iVar, d dVar);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(Object obj);

        void b(String str, String str2, Object obj);

        void c();
    }

    public j(z2.b bVar, String str) {
        this(bVar, str, q.f9018b);
    }

    public j(z2.b bVar, String str, k kVar) {
        this(bVar, str, kVar, null);
    }

    public j(z2.b bVar, String str, k kVar, b.c cVar) {
        this.f9005a = bVar;
        this.f9006b = str;
        this.f9007c = kVar;
        this.f9008d = cVar;
    }

    public void c(String str, Object obj) {
        d(str, obj, null);
    }

    public void d(String str, Object obj, d dVar) {
        this.f9005a.a(this.f9006b, this.f9007c.d(new i(str, obj)), dVar == null ? null : new b(dVar));
    }

    public void e(c cVar) {
        if (this.f9008d != null) {
            this.f9005a.e(this.f9006b, cVar != null ? new a(cVar) : null, this.f9008d);
        } else {
            this.f9005a.b(this.f9006b, cVar != null ? new a(cVar) : null);
        }
    }
}
