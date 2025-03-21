package z2;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import z2.b;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final z2.b f8990a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8991b;

    /* renamed from: c  reason: collision with root package name */
    private final k f8992c;

    /* renamed from: d  reason: collision with root package name */
    private final b.c f8993d;

    /* loaded from: classes.dex */
    public interface b {
        void a(Object obj);

        void b(String str, String str2, Object obj);

        void c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z2.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0140c implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final d f8994a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicReference<b> f8995b = new AtomicReference<>(null);

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: z2.c$c$a */
        /* loaded from: classes.dex */
        public final class a implements b {

            /* renamed from: a  reason: collision with root package name */
            final AtomicBoolean f8997a;

            private a() {
                this.f8997a = new AtomicBoolean(false);
            }

            @Override // z2.c.b
            public void a(Object obj) {
                if (this.f8997a.get() || C0140c.this.f8995b.get() != this) {
                    return;
                }
                c.this.f8990a.c(c.this.f8991b, c.this.f8992c.a(obj));
            }

            @Override // z2.c.b
            public void b(String str, String str2, Object obj) {
                if (this.f8997a.get() || C0140c.this.f8995b.get() != this) {
                    return;
                }
                c.this.f8990a.c(c.this.f8991b, c.this.f8992c.c(str, str2, obj));
            }

            @Override // z2.c.b
            public void c() {
                if (this.f8997a.getAndSet(true) || C0140c.this.f8995b.get() != this) {
                    return;
                }
                c.this.f8990a.c(c.this.f8991b, null);
            }
        }

        C0140c(d dVar) {
            this.f8994a = dVar;
        }

        private void c(Object obj, b.InterfaceC0139b interfaceC0139b) {
            ByteBuffer c5;
            if (this.f8995b.getAndSet(null) != null) {
                try {
                    this.f8994a.b(obj);
                    interfaceC0139b.a(c.this.f8992c.a(null));
                    return;
                } catch (RuntimeException e5) {
                    n2.b.c("EventChannel#" + c.this.f8991b, "Failed to close event stream", e5);
                    c5 = c.this.f8992c.c("error", e5.getMessage(), null);
                }
            } else {
                c5 = c.this.f8992c.c("error", "No active stream to cancel", null);
            }
            interfaceC0139b.a(c5);
        }

        private void d(Object obj, b.InterfaceC0139b interfaceC0139b) {
            a aVar = new a();
            if (this.f8995b.getAndSet(aVar) != null) {
                try {
                    this.f8994a.b(null);
                } catch (RuntimeException e5) {
                    n2.b.c("EventChannel#" + c.this.f8991b, "Failed to close existing event stream", e5);
                }
            }
            try {
                this.f8994a.a(obj, aVar);
                interfaceC0139b.a(c.this.f8992c.a(null));
            } catch (RuntimeException e6) {
                this.f8995b.set(null);
                n2.b.c("EventChannel#" + c.this.f8991b, "Failed to open event stream", e6);
                interfaceC0139b.a(c.this.f8992c.c("error", e6.getMessage(), null));
            }
        }

        @Override // z2.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0139b interfaceC0139b) {
            i e5 = c.this.f8992c.e(byteBuffer);
            if (e5.f9003a.equals("listen")) {
                d(e5.f9004b, interfaceC0139b);
            } else if (e5.f9003a.equals("cancel")) {
                c(e5.f9004b, interfaceC0139b);
            } else {
                interfaceC0139b.a(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(Object obj, b bVar);

        void b(Object obj);
    }

    public c(z2.b bVar, String str) {
        this(bVar, str, q.f9018b);
    }

    public c(z2.b bVar, String str, k kVar) {
        this(bVar, str, kVar, null);
    }

    public c(z2.b bVar, String str, k kVar, b.c cVar) {
        this.f8990a = bVar;
        this.f8991b = str;
        this.f8992c = kVar;
        this.f8993d = cVar;
    }

    public void d(d dVar) {
        if (this.f8993d != null) {
            this.f8990a.e(this.f8991b, dVar != null ? new C0140c(dVar) : null, this.f8993d);
        } else {
            this.f8990a.b(this.f8991b, dVar != null ? new C0140c(dVar) : null);
        }
    }
}
