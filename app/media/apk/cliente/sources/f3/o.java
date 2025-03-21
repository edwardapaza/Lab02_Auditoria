package f3;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.a1;
import com.google.firebase.firestore.g1;
import com.google.firebase.firestore.h1;
import com.google.firebase.firestore.z;
import e3.x;
import e3.y;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import z2.c;
/* loaded from: classes.dex */
public class o implements f, c.d {

    /* renamed from: a  reason: collision with root package name */
    final b f3039a;

    /* renamed from: b  reason: collision with root package name */
    final FirebaseFirestore f3040b;

    /* renamed from: c  reason: collision with root package name */
    final String f3041c;

    /* renamed from: d  reason: collision with root package name */
    final Long f3042d;

    /* renamed from: e  reason: collision with root package name */
    final Long f3043e;

    /* renamed from: g  reason: collision with root package name */
    private y.u f3045g;

    /* renamed from: h  reason: collision with root package name */
    private List<y.t> f3046h;

    /* renamed from: f  reason: collision with root package name */
    final Semaphore f3044f = new Semaphore(0);

    /* renamed from: i  reason: collision with root package name */
    final Handler f3047i = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3048a;

        static {
            int[] iArr = new int[y.v.values().length];
            f3048a = iArr;
            try {
                iArr[y.v.DELETE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3048a[y.v.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3048a[y.v.SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(g1 g1Var);
    }

    public o(b bVar, FirebaseFirestore firebaseFirestore, String str, Long l5, Long l6) {
        this.f3039a = bVar;
        this.f3040b = firebaseFirestore;
        this.f3041c = str;
        this.f3042d = l5;
        this.f3043e = l6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ x i(final c.b bVar, g1 g1Var) {
        this.f3039a.a(g1Var);
        final HashMap hashMap = new HashMap();
        hashMap.put("appName", this.f3040b.r().q());
        this.f3047i.post(new Runnable() { // from class: f3.n
            @Override // java.lang.Runnable
            public final void run() {
                c.b.this.a(hashMap);
            }
        });
        try {
            if (this.f3044f.tryAcquire(this.f3042d.longValue(), TimeUnit.MILLISECONDS)) {
                if (!this.f3046h.isEmpty() && this.f3045g != y.u.FAILURE) {
                    for (y.t tVar : this.f3046h) {
                        com.google.firebase.firestore.m o5 = this.f3040b.o(tVar.d());
                        int i5 = a.f3048a[tVar.e().ordinal()];
                        if (i5 == 1) {
                            g1Var.b(o5);
                        } else if (i5 == 2) {
                            Map<String, Object> b5 = tVar.b();
                            Objects.requireNonNull(b5);
                            g1Var.h(o5, b5);
                        } else if (i5 == 3) {
                            y.m c5 = tVar.c();
                            Objects.requireNonNull(c5);
                            a1 a1Var = null;
                            if (c5.b() != null && c5.b().booleanValue()) {
                                a1Var = a1.c();
                            } else if (c5.c() != null) {
                                List<List<String>> c6 = c5.c();
                                Objects.requireNonNull(c6);
                                a1Var = a1.d(g3.b.c(c6));
                            }
                            Map<String, Object> b6 = tVar.b();
                            Objects.requireNonNull(b6);
                            Map<String, Object> map = b6;
                            if (a1Var == null) {
                                g1Var.f(o5, map);
                            } else {
                                g1Var.g(o5, map, a1Var);
                            }
                        }
                    }
                    return x.a();
                }
                return x.a();
            }
            return x.b(new z("timed out", z.a.DEADLINE_EXCEEDED));
        } catch (InterruptedException unused) {
            return x.b(new z("interrupted", z.a.DEADLINE_EXCEEDED));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(c.b bVar, HashMap hashMap) {
        bVar.a(hashMap);
        bVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(final c.b bVar, Task task) {
        Object a5;
        String str;
        final HashMap hashMap = new HashMap();
        if (task.getException() == null && ((x) task.getResult()).f2811a == null) {
            if (task.getResult() != null) {
                a5 = Boolean.TRUE;
                str = "complete";
            }
            this.f3047i.post(new Runnable() { // from class: f3.m
                @Override // java.lang.Runnable
                public final void run() {
                    o.j(c.b.this, hashMap);
                }
            });
        }
        Exception exception = task.getException() != null ? task.getException() : ((x) task.getResult()).f2811a;
        hashMap.put("appName", this.f3040b.r().q());
        a5 = g3.a.a(exception);
        str = "error";
        hashMap.put(str, a5);
        this.f3047i.post(new Runnable() { // from class: f3.m
            @Override // java.lang.Runnable
            public final void run() {
                o.j(c.b.this, hashMap);
            }
        });
    }

    @Override // z2.c.d
    public void a(Object obj, final c.b bVar) {
        this.f3040b.H(new h1.b().b(this.f3043e.intValue()).a(), new g1.a() { // from class: f3.k
            @Override // com.google.firebase.firestore.g1.a
            public final Object a(g1 g1Var) {
                x i5;
                i5 = o.this.i(bVar, g1Var);
                return i5;
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: f3.l
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                o.this.k(bVar, task);
            }
        });
    }

    @Override // z2.c.d
    public void b(Object obj) {
        this.f3044f.release();
    }

    @Override // f3.f
    public void c(y.u uVar, List<y.t> list) {
        this.f3045g = uVar;
        this.f3046h = list;
        this.f3044f.release();
    }
}
