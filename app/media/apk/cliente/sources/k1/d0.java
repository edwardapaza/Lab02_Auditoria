package k1;

import b2.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d0<T> implements b2.b<T>, b2.a<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final a.InterfaceC0028a<Object> f5563c = new a.InterfaceC0028a() { // from class: k1.a0
        @Override // b2.a.InterfaceC0028a
        public final void a(b2.b bVar) {
            d0.f(bVar);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final b2.b<Object> f5564d = new b2.b() { // from class: k1.b0
        @Override // b2.b
        public final Object get() {
            Object g5;
            g5 = d0.g();
            return g5;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private a.InterfaceC0028a<T> f5565a;

    /* renamed from: b  reason: collision with root package name */
    private volatile b2.b<T> f5566b;

    private d0(a.InterfaceC0028a<T> interfaceC0028a, b2.b<T> bVar) {
        this.f5565a = interfaceC0028a;
        this.f5566b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> d0<T> e() {
        return new d0<>(f5563c, f5564d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(b2.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object g() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(a.InterfaceC0028a interfaceC0028a, a.InterfaceC0028a interfaceC0028a2, b2.b bVar) {
        interfaceC0028a.a(bVar);
        interfaceC0028a2.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> d0<T> i(b2.b<T> bVar) {
        return new d0<>(null, bVar);
    }

    @Override // b2.a
    public void a(final a.InterfaceC0028a<T> interfaceC0028a) {
        b2.b<T> bVar;
        b2.b<T> bVar2 = this.f5566b;
        b2.b<Object> bVar3 = f5564d;
        if (bVar2 != bVar3) {
            interfaceC0028a.a(bVar2);
            return;
        }
        b2.b<T> bVar4 = null;
        synchronized (this) {
            bVar = this.f5566b;
            if (bVar != bVar3) {
                bVar4 = bVar;
            } else {
                final a.InterfaceC0028a<T> interfaceC0028a2 = this.f5565a;
                this.f5565a = new a.InterfaceC0028a() { // from class: k1.c0
                    @Override // b2.a.InterfaceC0028a
                    public final void a(b2.b bVar5) {
                        d0.h(a.InterfaceC0028a.this, interfaceC0028a, bVar5);
                    }
                };
            }
        }
        if (bVar4 != null) {
            interfaceC0028a.a(bVar);
        }
    }

    @Override // b2.b
    public T get() {
        return this.f5566b.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(b2.b<T> bVar) {
        a.InterfaceC0028a<T> interfaceC0028a;
        if (this.f5566b != f5564d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC0028a = this.f5565a;
            this.f5565a = null;
            this.f5566b = bVar;
        }
        interfaceC0028a.a(bVar);
    }
}
