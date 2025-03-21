package e0;

import androidx.window.extensions.layout.WindowLayoutComponent;
import e4.k;
/* loaded from: classes.dex */
public final class a implements d0.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0047a f2635a = new C0047a(null);

    /* renamed from: e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0047a {
        private C0047a() {
        }

        public /* synthetic */ C0047a(e4.g gVar) {
            this();
        }

        public final d0.a a(WindowLayoutComponent windowLayoutComponent, z.d dVar) {
            k.e(windowLayoutComponent, "component");
            k.e(dVar, "adapter");
            int a5 = z.e.f8828a.a();
            return a5 >= 2 ? new e(windowLayoutComponent) : a5 == 1 ? new d(windowLayoutComponent, dVar) : new c();
        }
    }
}
