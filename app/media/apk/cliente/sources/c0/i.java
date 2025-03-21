package c0;

import android.app.Activity;
import c0.i;
import d4.p;
import m4.z0;
import o4.r;
import s3.t;
/* loaded from: classes.dex */
public final class i implements f {

    /* renamed from: b  reason: collision with root package name */
    private final m f816b;

    /* renamed from: c  reason: collision with root package name */
    private final d0.a f817c;

    @kotlin.coroutines.jvm.internal.f(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$2", f = "WindowInfoTrackerImpl.kt", l = {63}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    static final class a extends kotlin.coroutines.jvm.internal.l implements p<r<? super j>, v3.d<? super t>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f818a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f819b;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Activity f821d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c0.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0033a extends e4.l implements d4.a<t> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i f822a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ k.a<j> f823b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0033a(i iVar, k.a<j> aVar) {
                super(0);
                this.f822a = iVar;
                this.f823b = aVar;
            }

            public final void a() {
                this.f822a.f817c.b(this.f823b);
            }

            @Override // d4.a
            public /* bridge */ /* synthetic */ t b() {
                a();
                return t.f7573a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Activity activity, v3.d<? super a> dVar) {
            super(2, dVar);
            this.f821d = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(r rVar, j jVar) {
            rVar.l(jVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v3.d<t> create(Object obj, v3.d<?> dVar) {
            a aVar = new a(this.f821d, dVar);
            aVar.f819b = obj;
            return aVar;
        }

        @Override // d4.p
        /* renamed from: f */
        public final Object invoke(r<? super j> rVar, v3.d<? super t> dVar) {
            return ((a) create(rVar, dVar)).invokeSuspend(t.f7573a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object c5;
            c5 = w3.d.c();
            int i5 = this.f818a;
            if (i5 == 0) {
                s3.n.b(obj);
                final r rVar = (r) this.f819b;
                k.a<j> aVar = new k.a() { // from class: c0.h
                    @Override // k.a
                    public final void accept(Object obj2) {
                        i.a.g(r.this, (j) obj2);
                    }
                };
                i.this.f817c.a(this.f821d, new androidx.profileinstaller.g(), aVar);
                C0033a c0033a = new C0033a(i.this, aVar);
                this.f818a = 1;
                if (o4.p.a(rVar, c0033a, this) == c5) {
                    return c5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                s3.n.b(obj);
            }
            return t.f7573a;
        }
    }

    public i(m mVar, d0.a aVar) {
        e4.k.e(mVar, "windowMetricsCalculator");
        e4.k.e(aVar, "windowBackend");
        this.f816b = mVar;
        this.f817c = aVar;
    }

    @Override // c0.f
    public p4.c<j> a(Activity activity) {
        e4.k.e(activity, "activity");
        return p4.e.d(p4.e.a(new a(activity, null)), z0.c());
    }
}
