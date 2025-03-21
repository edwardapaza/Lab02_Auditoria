package c0;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.extensions.layout.WindowLayoutComponent;
import e0.a;
import e4.s;
/* loaded from: classes.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f808a = a.f809a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: b  reason: collision with root package name */
        private static final boolean f810b = false;

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f809a = new a();

        /* renamed from: c  reason: collision with root package name */
        private static final String f811c = s.b(f.class).c();

        /* renamed from: d  reason: collision with root package name */
        private static final s3.g<d0.a> f812d = s3.h.a(C0032a.f814a);

        /* renamed from: e  reason: collision with root package name */
        private static g f813e = b.f784a;

        /* renamed from: c0.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0032a extends e4.l implements d4.a<d0.a> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0032a f814a = new C0032a();

            C0032a() {
                super(0);
            }

            @Override // d4.a
            /* renamed from: a */
            public final d0.a b() {
                WindowLayoutComponent g5;
                try {
                    ClassLoader classLoader = f.class.getClassLoader();
                    e eVar = classLoader != null ? new e(classLoader, new z.d(classLoader)) : null;
                    if (eVar == null || (g5 = eVar.g()) == null) {
                        return null;
                    }
                    a.C0047a c0047a = e0.a.f2635a;
                    e4.k.d(classLoader, "loader");
                    return c0047a.a(g5, new z.d(classLoader));
                } catch (Throwable unused) {
                    if (a.f810b) {
                        Log.d(a.f811c, "Failed to load WindowExtensions");
                        return null;
                    }
                    return null;
                }
            }
        }

        private a() {
        }

        public final d0.a c() {
            return f812d.getValue();
        }

        public final f d(Context context) {
            e4.k.e(context, "context");
            d0.a c5 = c();
            if (c5 == null) {
                c5 = androidx.window.layout.adapter.sidecar.b.f722c.a(context);
            }
            return f813e.a(new i(n.f831b, c5));
        }
    }

    p4.c<j> a(Activity activity);
}
