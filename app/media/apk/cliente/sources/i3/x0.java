package i3;

import i3.i1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f3581c = Logger.getLogger(x0.class.getName());

    /* renamed from: d  reason: collision with root package name */
    private static x0 f3582d;

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashSet<w0> f3583a = new LinkedHashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private List<w0> f3584b = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Comparator<w0> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(w0 w0Var, w0 w0Var2) {
            return w0Var.c() - w0Var2.c();
        }
    }

    /* loaded from: classes.dex */
    private static final class b implements i1.b<w0> {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // i3.i1.b
        /* renamed from: c */
        public int b(w0 w0Var) {
            return w0Var.c();
        }

        @Override // i3.i1.b
        /* renamed from: d */
        public boolean a(w0 w0Var) {
            return w0Var.b();
        }
    }

    private synchronized void a(w0 w0Var) {
        z0.k.e(w0Var.b(), "isAvailable() returned false");
        this.f3583a.add(w0Var);
    }

    public static synchronized x0 b() {
        x0 x0Var;
        synchronized (x0.class) {
            if (f3582d == null) {
                List<w0> e5 = i1.e(w0.class, c(), w0.class.getClassLoader(), new b(null));
                f3582d = new x0();
                for (w0 w0Var : e5) {
                    Logger logger = f3581c;
                    logger.fine("Service loader found " + w0Var);
                    f3582d.a(w0Var);
                }
                f3582d.f();
            }
            x0Var = f3582d;
        }
        return x0Var;
    }

    static List<Class<?>> c() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(k3.g.class);
        } catch (ClassNotFoundException e5) {
            f3581c.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e5);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e6) {
            f3581c.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e6);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.UdsNettyChannelProvider"));
        } catch (ClassNotFoundException e7) {
            f3581c.log(Level.FINE, "Unable to find UdsNettyChannelProvider", (Throwable) e7);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized void f() {
        ArrayList arrayList = new ArrayList(this.f3583a);
        Collections.sort(arrayList, Collections.reverseOrder(new a()));
        this.f3584b = Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0 d() {
        List<w0> e5 = e();
        if (e5.isEmpty()) {
            return null;
        }
        return e5.get(0);
    }

    synchronized List<w0> e() {
        return this.f3584b;
    }
}
