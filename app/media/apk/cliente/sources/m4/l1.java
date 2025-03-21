package m4;

import java.io.Closeable;
import v3.g;
/* loaded from: classes.dex */
public abstract class l1 extends g0 implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    public static final a f6254c = new a(null);

    /* loaded from: classes.dex */
    public static final class a extends v3.b<g0, l1> {

        /* renamed from: m4.l1$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0095a extends e4.l implements d4.l<g.b, l1> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0095a f6255a = new C0095a();

            C0095a() {
                super(1);
            }

            @Override // d4.l
            /* renamed from: a */
            public final l1 invoke(g.b bVar) {
                if (bVar instanceof l1) {
                    return (l1) bVar;
                }
                return null;
            }
        }

        private a() {
            super(g0.f6233b, C0095a.f6255a);
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }
    }
}
