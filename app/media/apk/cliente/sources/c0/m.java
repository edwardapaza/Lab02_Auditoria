package c0;

import android.app.Activity;
/* loaded from: classes.dex */
public interface m {

    /* renamed from: a  reason: collision with root package name */
    public static final a f827a = a.f828a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f828a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static d4.l<? super m, ? extends m> f829b = C0034a.f830a;

        /* renamed from: c0.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0034a extends e4.l implements d4.l<m, m> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0034a f830a = new C0034a();

            C0034a() {
                super(1);
            }

            @Override // d4.l
            /* renamed from: a */
            public final m invoke(m mVar) {
                e4.k.e(mVar, "it");
                return mVar;
            }
        }

        private a() {
        }

        public final m a() {
            return f829b.invoke(n.f831b);
        }
    }

    k a(Activity activity);
}
