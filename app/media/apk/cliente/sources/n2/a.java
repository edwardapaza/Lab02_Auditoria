package n2;

import io.flutter.embedding.engine.FlutterJNI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import q2.d;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    private static a f6317e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f6318f;

    /* renamed from: a  reason: collision with root package name */
    private d f6319a;

    /* renamed from: b  reason: collision with root package name */
    private p2.a f6320b;

    /* renamed from: c  reason: collision with root package name */
    private FlutterJNI.c f6321c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f6322d;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private d f6323a;

        /* renamed from: b  reason: collision with root package name */
        private p2.a f6324b;

        /* renamed from: c  reason: collision with root package name */
        private FlutterJNI.c f6325c;

        /* renamed from: d  reason: collision with root package name */
        private ExecutorService f6326d;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n2.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class ThreadFactoryC0097a implements ThreadFactory {

            /* renamed from: a  reason: collision with root package name */
            private int f6327a;

            private ThreadFactoryC0097a() {
                this.f6327a = 0;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                StringBuilder sb = new StringBuilder();
                sb.append("flutter-worker-");
                int i5 = this.f6327a;
                this.f6327a = i5 + 1;
                sb.append(i5);
                thread.setName(sb.toString());
                return thread;
            }
        }

        private void b() {
            if (this.f6325c == null) {
                this.f6325c = new FlutterJNI.c();
            }
            if (this.f6326d == null) {
                this.f6326d = Executors.newCachedThreadPool(new ThreadFactoryC0097a());
            }
            if (this.f6323a == null) {
                this.f6323a = new d(this.f6325c.a(), this.f6326d);
            }
        }

        public a a() {
            b();
            return new a(this.f6323a, this.f6324b, this.f6325c, this.f6326d);
        }
    }

    private a(d dVar, p2.a aVar, FlutterJNI.c cVar, ExecutorService executorService) {
        this.f6319a = dVar;
        this.f6320b = aVar;
        this.f6321c = cVar;
        this.f6322d = executorService;
    }

    public static a e() {
        f6318f = true;
        if (f6317e == null) {
            f6317e = new b().a();
        }
        return f6317e;
    }

    public p2.a a() {
        return this.f6320b;
    }

    public ExecutorService b() {
        return this.f6322d;
    }

    public d c() {
        return this.f6319a;
    }

    public FlutterJNI.c d() {
        return this.f6321c;
    }
}
