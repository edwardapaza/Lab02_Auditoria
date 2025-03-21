package d3;

import android.app.Activity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.p0;
import com.google.firebase.auth.q0;
import d3.a1;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import z2.c;
/* loaded from: classes.dex */
public class f3 implements c.d {

    /* renamed from: k  reason: collision with root package name */
    private static final HashMap<Integer, q0.a> f2437k = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<Activity> f2438a;

    /* renamed from: b  reason: collision with root package name */
    final FirebaseAuth f2439b;

    /* renamed from: c  reason: collision with root package name */
    final String f2440c;

    /* renamed from: d  reason: collision with root package name */
    final com.google.firebase.auth.t0 f2441d;

    /* renamed from: e  reason: collision with root package name */
    final int f2442e;

    /* renamed from: f  reason: collision with root package name */
    final b f2443f;

    /* renamed from: g  reason: collision with root package name */
    final com.google.firebase.auth.l0 f2444g;

    /* renamed from: h  reason: collision with root package name */
    String f2445h;

    /* renamed from: i  reason: collision with root package name */
    Integer f2446i;

    /* renamed from: j  reason: collision with root package name */
    private c.b f2447j;

    /* loaded from: classes.dex */
    class a extends q0.b {
        a() {
        }

        @Override // com.google.firebase.auth.q0.b
        public void onCodeAutoRetrievalTimeOut(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("verificationId", str);
            hashMap.put("name", "Auth#phoneCodeAutoRetrievalTimeout");
            if (f3.this.f2447j != null) {
                f3.this.f2447j.a(hashMap);
            }
        }

        @Override // com.google.firebase.auth.q0.b
        public void onCodeSent(String str, q0.a aVar) {
            int hashCode = aVar.hashCode();
            f3.f2437k.put(Integer.valueOf(hashCode), aVar);
            HashMap hashMap = new HashMap();
            hashMap.put("verificationId", str);
            hashMap.put("forceResendingToken", Integer.valueOf(hashCode));
            hashMap.put("name", "Auth#phoneCodeSent");
            if (f3.this.f2447j != null) {
                f3.this.f2447j.a(hashMap);
            }
        }

        @Override // com.google.firebase.auth.q0.b
        public void onVerificationCompleted(com.google.firebase.auth.o0 o0Var) {
            int hashCode = o0Var.hashCode();
            f3.this.f2443f.a(o0Var);
            HashMap hashMap = new HashMap();
            hashMap.put("token", Integer.valueOf(hashCode));
            if (o0Var.w() != null) {
                hashMap.put("smsCode", o0Var.w());
            }
            hashMap.put("name", "Auth#phoneVerificationCompleted");
            if (f3.this.f2447j != null) {
                f3.this.f2447j.a(hashMap);
            }
        }

        @Override // com.google.firebase.auth.q0.b
        public void onVerificationFailed(f1.l lVar) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            a1.g e5 = v.e(lVar);
            hashMap2.put("code", e5.f2311a.replaceAll("ERROR_", "").toLowerCase(Locale.ROOT).replaceAll("_", "-"));
            hashMap2.put("message", e5.getMessage());
            hashMap2.put("details", e5.f2312b);
            hashMap.put("error", hashMap2);
            hashMap.put("name", "Auth#phoneVerificationFailed");
            if (f3.this.f2447j != null) {
                f3.this.f2447j.a(hashMap);
            }
        }
    }

    /* loaded from: classes.dex */
    interface b {
        void a(com.google.firebase.auth.o0 o0Var);
    }

    public f3(Activity activity, a1.b bVar, a1.e0 e0Var, com.google.firebase.auth.l0 l0Var, com.google.firebase.auth.t0 t0Var, b bVar2) {
        AtomicReference<Activity> atomicReference = new AtomicReference<>(null);
        this.f2438a = atomicReference;
        atomicReference.set(activity);
        this.f2444g = l0Var;
        this.f2441d = t0Var;
        this.f2439b = u.V(bVar);
        this.f2440c = e0Var.f();
        this.f2442e = e3.a(e0Var.g().longValue());
        if (e0Var.b() != null) {
            this.f2445h = e0Var.b();
        }
        if (e0Var.c() != null) {
            this.f2446i = Integer.valueOf(e3.a(e0Var.c().longValue()));
        }
        this.f2443f = bVar2;
    }

    @Override // z2.c.d
    public void a(Object obj, c.b bVar) {
        q0.a aVar;
        this.f2447j = bVar;
        a aVar2 = new a();
        if (this.f2445h != null) {
            this.f2439b.o().c(this.f2440c, this.f2445h);
        }
        p0.a aVar3 = new p0.a(this.f2439b);
        aVar3.b(this.f2438a.get());
        aVar3.c(aVar2);
        String str = this.f2440c;
        if (str != null) {
            aVar3.g(str);
        }
        com.google.firebase.auth.l0 l0Var = this.f2444g;
        if (l0Var != null) {
            aVar3.f(l0Var);
        }
        com.google.firebase.auth.t0 t0Var = this.f2441d;
        if (t0Var != null) {
            aVar3.e(t0Var);
        }
        aVar3.h(Long.valueOf(this.f2442e), TimeUnit.MILLISECONDS);
        Integer num = this.f2446i;
        if (num != null && (aVar = f2437k.get(num)) != null) {
            aVar3.d(aVar);
        }
        com.google.firebase.auth.q0.b(aVar3.a());
    }

    @Override // z2.c.d
    public void b(Object obj) {
        this.f2447j = null;
        this.f2438a.set(null);
    }
}
