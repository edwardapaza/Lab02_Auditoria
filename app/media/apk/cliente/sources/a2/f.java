package a2;

import a2.j;
import android.content.Context;
import android.util.Base64OutputStream;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import k1.f0;
import k1.r;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f implements i, j {

    /* renamed from: a  reason: collision with root package name */
    private final b2.b<l> f71a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f72b;

    /* renamed from: c  reason: collision with root package name */
    private final b2.b<e2.i> f73c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<g> f74d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f75e;

    private f(final Context context, final String str, Set<g> set, b2.b<e2.i> bVar, Executor executor) {
        this(new b2.b() { // from class: a2.e
            @Override // b2.b
            public final Object get() {
                l j5;
                j5 = f.j(context, str);
                return j5;
            }
        }, set, executor, bVar, context);
    }

    f(b2.b<l> bVar, Set<g> set, Executor executor, b2.b<e2.i> bVar2, Context context) {
        this.f71a = bVar;
        this.f74d = set;
        this.f75e = executor;
        this.f73c = bVar2;
        this.f72b = context;
    }

    public static k1.c<f> g() {
        final f0 a5 = f0.a(g1.a.class, Executor.class);
        return k1.c.d(f.class, i.class, j.class).b(r.j(Context.class)).b(r.j(f1.f.class)).b(r.m(g.class)).b(r.l(e2.i.class)).b(r.k(a5)).d(new k1.h() { // from class: a2.d
            @Override // k1.h
            public final Object a(k1.e eVar) {
                f h5;
                h5 = f.h(f0.this, eVar);
                return h5;
            }
        }).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f h(f0 f0Var, k1.e eVar) {
        return new f((Context) eVar.a(Context.class), ((f1.f) eVar.a(f1.f.class)).s(), eVar.b(g.class), eVar.f(e2.i.class), (Executor) eVar.e(f0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String i() {
        String byteArrayOutputStream;
        synchronized (this) {
            l lVar = this.f71a.get();
            List<m> c5 = lVar.c();
            lVar.b();
            JSONArray jSONArray = new JSONArray();
            for (int i5 = 0; i5 < c5.size(); i5++) {
                m mVar = c5.get(i5);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("agent", mVar.c());
                jSONObject.put("dates", new JSONArray((Collection) mVar.b()));
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("heartbeats", jSONArray);
            jSONObject2.put("version", "2");
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
            try {
                gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                gZIPOutputStream.close();
                base64OutputStream.close();
                byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
            } catch (Throwable th) {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        return byteArrayOutputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l j(Context context, String str) {
        return new l(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void k() {
        synchronized (this) {
            this.f71a.get().k(System.currentTimeMillis(), this.f73c.get().a());
        }
        return null;
    }

    @Override // a2.i
    public Task<String> a() {
        return androidx.core.os.m.a(this.f72b) ^ true ? Tasks.forResult("") : Tasks.call(this.f75e, new Callable() { // from class: a2.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String i5;
                i5 = f.this.i();
                return i5;
            }
        });
    }

    @Override // a2.j
    public synchronized j.a b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        l lVar = this.f71a.get();
        if (!lVar.i(currentTimeMillis)) {
            return j.a.NONE;
        }
        lVar.g();
        return j.a.GLOBAL;
    }

    public Task<Void> l() {
        if (this.f74d.size() > 0 && !(!androidx.core.os.m.a(this.f72b))) {
            return Tasks.call(this.f75e, new Callable() { // from class: a2.c
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Void k5;
                    k5 = f.this.k();
                    return k5;
                }
            });
        }
        return Tasks.forResult(null);
    }
}
