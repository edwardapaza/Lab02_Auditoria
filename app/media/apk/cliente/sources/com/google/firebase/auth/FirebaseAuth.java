package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001firebaseauthapi.zzaag;
import com.google.android.gms.internal.p001firebaseauthapi.zzach;
import com.google.android.gms.internal.p001firebaseauthapi.zzack;
import com.google.android.gms.internal.p001firebaseauthapi.zzacu;
import com.google.android.gms.internal.p001firebaseauthapi.zzads;
import com.google.android.gms.internal.p001firebaseauthapi.zzaec;
import com.google.android.gms.internal.p001firebaseauthapi.zzafi;
import com.google.android.gms.internal.p001firebaseauthapi.zzafj;
import com.google.android.gms.internal.p001firebaseauthapi.zzafm;
import com.google.android.gms.internal.p001firebaseauthapi.zzafz;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.q0;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public class FirebaseAuth implements j1.b {
    private final Executor A;
    private String B;

    /* renamed from: a  reason: collision with root package name */
    private final f1.f f1381a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f1382b;

    /* renamed from: c  reason: collision with root package name */
    private final List<j1.a> f1383c;

    /* renamed from: d  reason: collision with root package name */
    private final List<a> f1384d;

    /* renamed from: e  reason: collision with root package name */
    private final zzaag f1385e;

    /* renamed from: f  reason: collision with root package name */
    private a0 f1386f;

    /* renamed from: g  reason: collision with root package name */
    private final j1.f f1387g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f1388h;

    /* renamed from: i  reason: collision with root package name */
    private String f1389i;

    /* renamed from: j  reason: collision with root package name */
    private final Object f1390j;

    /* renamed from: k  reason: collision with root package name */
    private String f1391k;

    /* renamed from: l  reason: collision with root package name */
    private j1.y0 f1392l;

    /* renamed from: m  reason: collision with root package name */
    private final RecaptchaAction f1393m;

    /* renamed from: n  reason: collision with root package name */
    private final RecaptchaAction f1394n;

    /* renamed from: o  reason: collision with root package name */
    private final RecaptchaAction f1395o;

    /* renamed from: p  reason: collision with root package name */
    private final RecaptchaAction f1396p;

    /* renamed from: q  reason: collision with root package name */
    private final RecaptchaAction f1397q;

    /* renamed from: r  reason: collision with root package name */
    private final RecaptchaAction f1398r;

    /* renamed from: s  reason: collision with root package name */
    private final j1.z0 f1399s;

    /* renamed from: t  reason: collision with root package name */
    private final j1.g1 f1400t;

    /* renamed from: u  reason: collision with root package name */
    private final j1.d0 f1401u;

    /* renamed from: v  reason: collision with root package name */
    private final b2.b<i1.b> f1402v;

    /* renamed from: w  reason: collision with root package name */
    private final b2.b<a2.i> f1403w;

    /* renamed from: x  reason: collision with root package name */
    private j1.d1 f1404x;

    /* renamed from: y  reason: collision with root package name */
    private final Executor f1405y;

    /* renamed from: z  reason: collision with root package name */
    private final Executor f1406z;

    /* loaded from: classes.dex */
    public interface a {
        void a(FirebaseAuth firebaseAuth);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(FirebaseAuth firebaseAuth);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements j1.x, j1.q1 {
        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
        }

        @Override // j1.q1
        public final void a(zzafm zzafmVar, a0 a0Var) {
            com.google.android.gms.common.internal.q.k(zzafmVar);
            com.google.android.gms.common.internal.q.k(a0Var);
            a0Var.Q(zzafmVar);
            FirebaseAuth.this.i0(a0Var, zzafmVar, true, true);
        }

        @Override // j1.x
        public final void zza(Status status) {
            if (status.u() == 17011 || status.u() == 17021 || status.u() == 17005 || status.u() == 17091) {
                FirebaseAuth.this.F();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements j1.q1 {
        /* JADX INFO: Access modifiers changed from: package-private */
        public d() {
        }

        @Override // j1.q1
        public final void a(zzafm zzafmVar, a0 a0Var) {
            com.google.android.gms.common.internal.q.k(zzafmVar);
            com.google.android.gms.common.internal.q.k(a0Var);
            a0Var.Q(zzafmVar);
            FirebaseAuth.this.h0(a0Var, zzafmVar, true);
        }
    }

    public FirebaseAuth(f1.f fVar, b2.b<i1.b> bVar, b2.b<a2.i> bVar2, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService, Executor executor4) {
        this(fVar, new zzaag(fVar, executor2, scheduledExecutorService), new j1.z0(fVar.m(), fVar.s()), j1.g1.f(), j1.d0.b(), bVar, bVar2, executor, executor2, executor3, executor4);
    }

    private FirebaseAuth(f1.f fVar, zzaag zzaagVar, j1.z0 z0Var, j1.g1 g1Var, j1.d0 d0Var, b2.b<i1.b> bVar, b2.b<a2.i> bVar2, Executor executor, Executor executor2, Executor executor3, Executor executor4) {
        zzafm a5;
        this.f1382b = new CopyOnWriteArrayList();
        this.f1383c = new CopyOnWriteArrayList();
        this.f1384d = new CopyOnWriteArrayList();
        this.f1388h = new Object();
        this.f1390j = new Object();
        this.f1393m = RecaptchaAction.custom("getOobCode");
        this.f1394n = RecaptchaAction.custom("signInWithPassword");
        this.f1395o = RecaptchaAction.custom("signUpPassword");
        this.f1396p = RecaptchaAction.custom("sendVerificationCode");
        this.f1397q = RecaptchaAction.custom("mfaSmsEnrollment");
        this.f1398r = RecaptchaAction.custom("mfaSmsSignIn");
        this.f1381a = (f1.f) com.google.android.gms.common.internal.q.k(fVar);
        this.f1385e = (zzaag) com.google.android.gms.common.internal.q.k(zzaagVar);
        j1.z0 z0Var2 = (j1.z0) com.google.android.gms.common.internal.q.k(z0Var);
        this.f1399s = z0Var2;
        this.f1387g = new j1.f();
        j1.g1 g1Var2 = (j1.g1) com.google.android.gms.common.internal.q.k(g1Var);
        this.f1400t = g1Var2;
        this.f1401u = (j1.d0) com.google.android.gms.common.internal.q.k(d0Var);
        this.f1402v = bVar;
        this.f1403w = bVar2;
        this.f1405y = executor2;
        this.f1406z = executor3;
        this.A = executor4;
        a0 b5 = z0Var2.b();
        this.f1386f = b5;
        if (b5 != null && (a5 = z0Var2.a(b5)) != null) {
            g0(this, this.f1386f, a5, false, false);
        }
        g1Var2.b(this);
    }

    private final synchronized j1.d1 L0() {
        return M0(this);
    }

    private static j1.d1 M0(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.f1404x == null) {
            firebaseAuth.f1404x = new j1.d1((f1.f) com.google.android.gms.common.internal.q.k(firebaseAuth.f1381a));
        }
        return firebaseAuth.f1404x;
    }

    private final Task<i> N(j jVar, a0 a0Var, boolean z4) {
        return new h1(this, z4, a0Var, jVar).b(this, this.f1391k, this.f1393m, "EMAIL_PASSWORD_PROVIDER");
    }

    private final Task<Void> T(a0 a0Var, j1.e1 e1Var) {
        com.google.android.gms.common.internal.q.k(a0Var);
        return this.f1385e.zza(this.f1381a, a0Var, e1Var);
    }

    private final Task<i> a0(String str, String str2, String str3, a0 a0Var, boolean z4) {
        return new i1(this, str, z4, a0Var, str2, str3).b(this, str3, this.f1394n, "EMAIL_PASSWORD_PROVIDER");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final q0.b d0(String str, q0.b bVar) {
        return (this.f1387g.g() && str != null && str.equals(this.f1387g.d())) ? new l2(this, bVar) : bVar;
    }

    private static void f0(FirebaseAuth firebaseAuth, a0 a0Var) {
        String str;
        if (a0Var != null) {
            str = "Notifying auth state listeners about user ( " + a0Var.a() + " ).";
        } else {
            str = "Notifying auth state listeners about a sign-out event.";
        }
        Log.d("FirebaseAuth", str);
        firebaseAuth.A.execute(new w2(firebaseAuth));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
        if (r0 == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void g0(com.google.firebase.auth.FirebaseAuth r4, com.google.firebase.auth.a0 r5, com.google.android.gms.internal.p001firebaseauthapi.zzafm r6, boolean r7, boolean r8) {
        /*
            com.google.android.gms.common.internal.q.k(r5)
            com.google.android.gms.common.internal.q.k(r6)
            com.google.firebase.auth.a0 r0 = r4.f1386f
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1e
            java.lang.String r0 = r5.a()
            com.google.firebase.auth.a0 r3 = r4.f1386f
            java.lang.String r3 = r3.a()
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            if (r0 != 0) goto L24
            if (r8 == 0) goto L24
            return
        L24:
            com.google.firebase.auth.a0 r8 = r4.f1386f
            if (r8 != 0) goto L2a
        L28:
            r1 = 1
            goto L46
        L2a:
            com.google.android.gms.internal.firebase-auth-api.zzafm r8 = r8.T()
            java.lang.String r8 = r8.zzc()
            java.lang.String r3 = r6.zzc()
            boolean r8 = r8.equals(r3)
            r8 = r8 ^ r2
            if (r0 == 0) goto L41
            if (r8 != 0) goto L41
            r8 = 0
            goto L42
        L41:
            r8 = 1
        L42:
            r2 = r8
            if (r0 != 0) goto L46
            goto L28
        L46:
            com.google.android.gms.common.internal.q.k(r5)
            com.google.firebase.auth.a0 r8 = r4.f1386f
            if (r8 == 0) goto L7e
            java.lang.String r8 = r5.a()
            java.lang.String r0 = r4.a()
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L5c
            goto L7e
        L5c:
            com.google.firebase.auth.a0 r8 = r4.f1386f
            java.util.List r0 = r5.x()
            r8.O(r0)
            boolean r8 = r5.z()
            if (r8 != 0) goto L70
            com.google.firebase.auth.a0 r8 = r4.f1386f
            r8.R()
        L70:
            com.google.firebase.auth.h0 r8 = r5.w()
            java.util.List r8 = r8.b()
            com.google.firebase.auth.a0 r0 = r4.f1386f
            r0.S(r8)
            goto L80
        L7e:
            r4.f1386f = r5
        L80:
            if (r7 == 0) goto L89
            j1.z0 r8 = r4.f1399s
            com.google.firebase.auth.a0 r0 = r4.f1386f
            r8.f(r0)
        L89:
            if (r2 == 0) goto L97
            com.google.firebase.auth.a0 r8 = r4.f1386f
            if (r8 == 0) goto L92
            r8.Q(r6)
        L92:
            com.google.firebase.auth.a0 r8 = r4.f1386f
            s0(r4, r8)
        L97:
            if (r1 == 0) goto L9e
            com.google.firebase.auth.a0 r8 = r4.f1386f
            f0(r4, r8)
        L9e:
            if (r7 == 0) goto La5
            j1.z0 r7 = r4.f1399s
            r7.d(r5, r6)
        La5:
            com.google.firebase.auth.a0 r5 = r4.f1386f
            if (r5 == 0) goto Lb4
            j1.d1 r4 = M0(r4)
            com.google.android.gms.internal.firebase-auth-api.zzafm r5 = r5.T()
            r4.d(r5)
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.g0(com.google.firebase.auth.FirebaseAuth, com.google.firebase.auth.a0, com.google.android.gms.internal.firebase-auth-api.zzafm, boolean, boolean):void");
    }

    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) f1.f.o().k(FirebaseAuth.class);
    }

    public static FirebaseAuth getInstance(f1.f fVar) {
        return (FirebaseAuth) fVar.k(FirebaseAuth.class);
    }

    public static void j0(p0 p0Var) {
        String e5;
        String j5;
        if (!p0Var.m()) {
            FirebaseAuth c5 = p0Var.c();
            String e6 = com.google.android.gms.common.internal.q.e(p0Var.i());
            if ((p0Var.e() != null) || !zzads.zza(e6, p0Var.f(), p0Var.a(), p0Var.j())) {
                c5.f1401u.a(c5, e6, p0Var.a(), c5.K0(), p0Var.k(), false, c5.f1396p).addOnCompleteListener(new j2(c5, p0Var, e6));
                return;
            }
            return;
        }
        FirebaseAuth c6 = p0Var.c();
        j1.p pVar = (j1.p) com.google.android.gms.common.internal.q.k(p0Var.d());
        if (pVar.x()) {
            j5 = com.google.android.gms.common.internal.q.e(p0Var.i());
            e5 = j5;
        } else {
            t0 t0Var = (t0) com.google.android.gms.common.internal.q.k(p0Var.g());
            e5 = com.google.android.gms.common.internal.q.e(t0Var.a());
            j5 = t0Var.j();
        }
        if (p0Var.e() == null || !zzads.zza(e5, p0Var.f(), p0Var.a(), p0Var.j())) {
            c6.f1401u.a(c6, j5, p0Var.a(), c6.K0(), p0Var.k(), false, pVar.x() ? c6.f1397q : c6.f1398r).addOnCompleteListener(new m2(c6, p0Var, e5));
        }
    }

    public static void l0(final f1.l lVar, p0 p0Var, String str) {
        Log.e("FirebaseAuth", "Invoking verification failure callback for phone number/uid - " + str);
        final q0.b zza = zzads.zza(str, p0Var.f(), null);
        p0Var.j().execute(new Runnable() { // from class: com.google.firebase.auth.i2
            @Override // java.lang.Runnable
            public final void run() {
                q0.b.this.onVerificationFailed(lVar);
            }
        });
    }

    private static void s0(FirebaseAuth firebaseAuth, a0 a0Var) {
        String str;
        if (a0Var != null) {
            str = "Notifying id token listeners about user ( " + a0Var.a() + " ).";
        } else {
            str = "Notifying id token listeners about a sign-out event.";
        }
        Log.d("FirebaseAuth", str);
        firebaseAuth.A.execute(new x2(firebaseAuth, new c2.b(a0Var != null ? a0Var.zzd() : null)));
    }

    private final boolean t0(String str) {
        f c5 = f.c(str);
        return (c5 == null || TextUtils.equals(this.f1391k, c5.d())) ? false : true;
    }

    public Task<i> A() {
        a0 a0Var = this.f1386f;
        if (a0Var == null || !a0Var.z()) {
            return this.f1385e.zza(this.f1381a, new d(), this.f1391k);
        }
        j1.i iVar = (j1.i) this.f1386f;
        iVar.Y(false);
        return Tasks.forResult(new j1.e2(iVar));
    }

    public Task<i> B(h hVar) {
        com.google.android.gms.common.internal.q.k(hVar);
        h v5 = hVar.v();
        if (v5 instanceof j) {
            j jVar = (j) v5;
            return !jVar.z() ? a0(jVar.zzc(), (String) com.google.android.gms.common.internal.q.k(jVar.zzd()), this.f1391k, null, false) : t0(com.google.android.gms.common.internal.q.e(jVar.zze())) ? Tasks.forException(zzach.zza(new Status(17072))) : N(jVar, null, false);
        } else if (v5 instanceof o0) {
            return this.f1385e.zza(this.f1381a, (o0) v5, this.f1391k, (j1.q1) new d());
        } else {
            return this.f1385e.zza(this.f1381a, v5, this.f1391k, new d());
        }
    }

    public Task<i> C(String str) {
        com.google.android.gms.common.internal.q.e(str);
        return this.f1385e.zza(this.f1381a, str, this.f1391k, new d());
    }

    public final Executor C0() {
        return this.f1405y;
    }

    public Task<i> D(String str, String str2) {
        com.google.android.gms.common.internal.q.e(str);
        com.google.android.gms.common.internal.q.e(str2);
        return a0(str, str2, this.f1391k, null, false);
    }

    public Task<i> E(String str, String str2) {
        return B(k.b(str, str2));
    }

    public final Executor E0() {
        return this.f1406z;
    }

    public void F() {
        I0();
        j1.d1 d1Var = this.f1404x;
        if (d1Var != null) {
            d1Var.b();
        }
    }

    public Task<i> G(Activity activity, n nVar) {
        com.google.android.gms.common.internal.q.k(nVar);
        com.google.android.gms.common.internal.q.k(activity);
        TaskCompletionSource<i> taskCompletionSource = new TaskCompletionSource<>();
        if (this.f1400t.c(activity, taskCompletionSource, this)) {
            j1.o0.d(activity.getApplicationContext(), this);
            nVar.c(activity);
            return taskCompletionSource.getTask();
        }
        return Tasks.forException(zzach.zza(new Status(17057)));
    }

    public final Executor G0() {
        return this.A;
    }

    public void H() {
        synchronized (this.f1388h) {
            this.f1389i = zzacu.zza();
        }
    }

    public void I(String str, int i5) {
        com.google.android.gms.common.internal.q.e(str);
        com.google.android.gms.common.internal.q.b(i5 >= 0 && i5 <= 65535, "Port number must be in the range 0-65535");
        zzaec.zza(this.f1381a, str, i5);
    }

    public final void I0() {
        com.google.android.gms.common.internal.q.k(this.f1399s);
        a0 a0Var = this.f1386f;
        if (a0Var != null) {
            j1.z0 z0Var = this.f1399s;
            com.google.android.gms.common.internal.q.k(a0Var);
            z0Var.e(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", a0Var.a()));
            this.f1386f = null;
        }
        this.f1399s.e("com.google.firebase.auth.FIREBASE_USER");
        s0(this, null);
        f0(this, null);
    }

    public Task<String> J(String str) {
        com.google.android.gms.common.internal.q.e(str);
        return this.f1385e.zzd(this.f1381a, str, this.f1391k);
    }

    public final Task<zzafi> K() {
        return this.f1385e.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean K0() {
        return zzack.zza(l().m());
    }

    public final Task<i> L(Activity activity, n nVar, a0 a0Var) {
        com.google.android.gms.common.internal.q.k(activity);
        com.google.android.gms.common.internal.q.k(nVar);
        com.google.android.gms.common.internal.q.k(a0Var);
        TaskCompletionSource<i> taskCompletionSource = new TaskCompletionSource<>();
        if (this.f1400t.d(activity, taskCompletionSource, this, a0Var)) {
            j1.o0.e(activity.getApplicationContext(), this, a0Var);
            nVar.a(activity);
            return taskCompletionSource.getTask();
        }
        return Tasks.forException(zzach.zza(new Status(17057)));
    }

    public final Task<Void> M(e eVar, String str) {
        com.google.android.gms.common.internal.q.e(str);
        if (this.f1389i != null) {
            if (eVar == null) {
                eVar = e.D();
            }
            eVar.C(this.f1389i);
        }
        return this.f1385e.zza(this.f1381a, eVar, str);
    }

    public final Task<Void> O(a0 a0Var) {
        com.google.android.gms.common.internal.q.k(a0Var);
        return this.f1385e.zza(a0Var, new u2(this, a0Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$c, j1.e1] */
    public final Task<i> P(a0 a0Var, h hVar) {
        com.google.android.gms.common.internal.q.k(hVar);
        com.google.android.gms.common.internal.q.k(a0Var);
        return hVar instanceof j ? new n2(this, a0Var, (j) hVar.v()).b(this, a0Var.y(), this.f1395o, "EMAIL_PASSWORD_PROVIDER") : this.f1385e.zza(this.f1381a, a0Var, hVar.v(), (String) null, (j1.e1) new c());
    }

    public final Task<Void> Q(a0 a0Var, i0 i0Var, String str) {
        com.google.android.gms.common.internal.q.k(a0Var);
        com.google.android.gms.common.internal.q.k(i0Var);
        return i0Var instanceof r0 ? this.f1385e.zza(this.f1381a, (r0) i0Var, a0Var, str, new d()) : i0Var instanceof x0 ? this.f1385e.zza(this.f1381a, (x0) i0Var, a0Var, str, this.f1391k, new d()) : Tasks.forException(zzach.zza(new Status(17499)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$c, j1.e1] */
    public final Task<Void> R(a0 a0Var, o0 o0Var) {
        com.google.android.gms.common.internal.q.k(a0Var);
        com.google.android.gms.common.internal.q.k(o0Var);
        return this.f1385e.zza(this.f1381a, a0Var, (o0) o0Var.v(), (j1.e1) new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$c, j1.e1] */
    public final Task<Void> S(a0 a0Var, e1 e1Var) {
        com.google.android.gms.common.internal.q.k(a0Var);
        com.google.android.gms.common.internal.q.k(e1Var);
        return this.f1385e.zza(this.f1381a, a0Var, e1Var, (j1.e1) new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$c, j1.e1] */
    public final Task<Void> U(a0 a0Var, String str) {
        com.google.android.gms.common.internal.q.k(a0Var);
        com.google.android.gms.common.internal.q.e(str);
        return this.f1385e.zza(this.f1381a, a0Var, str, this.f1391k, (j1.e1) new c()).continueWithTask(new r2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.g1, j1.e1] */
    public final Task<c0> V(a0 a0Var, boolean z4) {
        if (a0Var == null) {
            return Tasks.forException(zzach.zza(new Status(17495)));
        }
        zzafm T = a0Var.T();
        return (!T.zzg() || z4) ? this.f1385e.zza(this.f1381a, a0Var, T.zzd(), (j1.e1) new g1(this)) : Tasks.forResult(j1.l0.a(T.zzc()));
    }

    public final Task<i> W(i0 i0Var, j1.p pVar, a0 a0Var) {
        com.google.android.gms.common.internal.q.k(i0Var);
        com.google.android.gms.common.internal.q.k(pVar);
        if (i0Var instanceof r0) {
            return this.f1385e.zza(this.f1381a, a0Var, (r0) i0Var, com.google.android.gms.common.internal.q.e(pVar.zzc()), new d());
        }
        if (i0Var instanceof x0) {
            return this.f1385e.zza(this.f1381a, a0Var, (x0) i0Var, com.google.android.gms.common.internal.q.e(pVar.zzc()), this.f1391k, new d());
        }
        throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
    }

    public final Task<a1> X(j1.p pVar) {
        com.google.android.gms.common.internal.q.k(pVar);
        return this.f1385e.zza(pVar, this.f1391k).continueWithTask(new v2(this));
    }

    public final Task<zzafj> Y(String str) {
        return this.f1385e.zza(this.f1391k, str);
    }

    public final Task<Void> Z(String str, String str2, e eVar) {
        com.google.android.gms.common.internal.q.e(str);
        com.google.android.gms.common.internal.q.e(str2);
        if (eVar == null) {
            eVar = e.D();
        }
        String str3 = this.f1389i;
        if (str3 != null) {
            eVar.C(str3);
        }
        return this.f1385e.zza(str, str2, eVar);
    }

    @Override // j1.b
    public String a() {
        a0 a0Var = this.f1386f;
        if (a0Var == null) {
            return null;
        }
        return a0Var.a();
    }

    @Override // j1.b
    public void b(j1.a aVar) {
        com.google.android.gms.common.internal.q.k(aVar);
        this.f1383c.remove(aVar);
        L0().c(this.f1383c.size());
    }

    @Override // j1.b
    public void c(j1.a aVar) {
        com.google.android.gms.common.internal.q.k(aVar);
        this.f1383c.add(aVar);
        L0().c(this.f1383c.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final q0.b c0(p0 p0Var, q0.b bVar) {
        return p0Var.k() ? bVar : new o2(this, p0Var, bVar);
    }

    @Override // j1.b
    public Task<c0> d(boolean z4) {
        return V(this.f1386f, z4);
    }

    public void e(a aVar) {
        this.f1384d.add(aVar);
        this.A.execute(new t2(this, aVar));
    }

    public void f(b bVar) {
        this.f1382b.add(bVar);
        this.A.execute(new k2(this, bVar));
    }

    public Task<Void> g(String str) {
        com.google.android.gms.common.internal.q.e(str);
        return this.f1385e.zza(this.f1381a, str, this.f1391k);
    }

    public Task<com.google.firebase.auth.d> h(String str) {
        com.google.android.gms.common.internal.q.e(str);
        return this.f1385e.zzb(this.f1381a, str, this.f1391k);
    }

    public final void h0(a0 a0Var, zzafm zzafmVar, boolean z4) {
        i0(a0Var, zzafmVar, true, false);
    }

    public Task<Void> i(String str, String str2) {
        com.google.android.gms.common.internal.q.e(str);
        com.google.android.gms.common.internal.q.e(str2);
        return this.f1385e.zza(this.f1381a, str, str2, this.f1391k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i0(a0 a0Var, zzafm zzafmVar, boolean z4, boolean z5) {
        g0(this, a0Var, zzafmVar, true, z5);
    }

    public Task<i> j(String str, String str2) {
        com.google.android.gms.common.internal.q.e(str);
        com.google.android.gms.common.internal.q.e(str2);
        return new q2(this, str, str2).b(this, this.f1391k, this.f1395o, "EMAIL_PASSWORD_PROVIDER");
    }

    @Deprecated
    public Task<w0> k(String str) {
        com.google.android.gms.common.internal.q.e(str);
        return this.f1385e.zzc(this.f1381a, str, this.f1391k);
    }

    public final void k0(p0 p0Var, String str, String str2) {
        long longValue = p0Var.h().longValue();
        if (longValue < 0 || longValue > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        String e5 = com.google.android.gms.common.internal.q.e(p0Var.i());
        zzafz zzafzVar = new zzafz(e5, longValue, p0Var.e() != null, this.f1389i, this.f1391k, str, str2, K0());
        q0.b d02 = d0(e5, p0Var.f());
        this.f1385e.zza(this.f1381a, zzafzVar, TextUtils.isEmpty(str) ? c0(p0Var, d02) : d02, p0Var.a(), p0Var.j());
    }

    public f1.f l() {
        return this.f1381a;
    }

    public a0 m() {
        return this.f1386f;
    }

    public final synchronized void m0(j1.y0 y0Var) {
        this.f1392l = y0Var;
    }

    public String n() {
        return this.B;
    }

    public final Task<i> n0(Activity activity, n nVar, a0 a0Var) {
        com.google.android.gms.common.internal.q.k(activity);
        com.google.android.gms.common.internal.q.k(nVar);
        com.google.android.gms.common.internal.q.k(a0Var);
        TaskCompletionSource<i> taskCompletionSource = new TaskCompletionSource<>();
        if (this.f1400t.d(activity, taskCompletionSource, this, a0Var)) {
            j1.o0.e(activity.getApplicationContext(), this, a0Var);
            nVar.b(activity);
            return taskCompletionSource.getTask();
        }
        return Tasks.forException(zzach.zza(new Status(17057)));
    }

    public w o() {
        return this.f1387g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.firebase.auth.FirebaseAuth$c, j1.e1] */
    public final Task<Void> o0(a0 a0Var) {
        return T(a0Var, new c());
    }

    public String p() {
        String str;
        synchronized (this.f1388h) {
            str = this.f1389i;
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$c, j1.e1] */
    public final Task<i> p0(a0 a0Var, String str) {
        com.google.android.gms.common.internal.q.e(str);
        com.google.android.gms.common.internal.q.k(a0Var);
        return this.f1385e.zzb(this.f1381a, a0Var, str, new c());
    }

    public String q() {
        String str;
        synchronized (this.f1390j) {
            str = this.f1391k;
        }
        return str;
    }

    public Task<Void> r() {
        if (this.f1392l == null) {
            this.f1392l = new j1.y0(this.f1381a, this);
        }
        return this.f1392l.a(this.f1391k, Boolean.FALSE).continueWithTask(new y2(this));
    }

    public final synchronized j1.y0 r0() {
        return this.f1392l;
    }

    public void s(a aVar) {
        this.f1384d.remove(aVar);
    }

    public void t(b bVar) {
        this.f1382b.remove(bVar);
    }

    public Task<Void> u(String str) {
        com.google.android.gms.common.internal.q.e(str);
        return v(str, null);
    }

    public final b2.b<i1.b> u0() {
        return this.f1402v;
    }

    public Task<Void> v(String str, e eVar) {
        com.google.android.gms.common.internal.q.e(str);
        if (eVar == null) {
            eVar = e.D();
        }
        String str2 = this.f1389i;
        if (str2 != null) {
            eVar.C(str2);
        }
        eVar.B(1);
        return new p2(this, str, eVar).b(this, this.f1391k, this.f1393m, "EMAIL_PASSWORD_PROVIDER");
    }

    public Task<Void> w(String str, e eVar) {
        com.google.android.gms.common.internal.q.e(str);
        com.google.android.gms.common.internal.q.k(eVar);
        if (eVar.t()) {
            String str2 = this.f1389i;
            if (str2 != null) {
                eVar.C(str2);
            }
            return new s2(this, str, eVar).b(this, this.f1391k, this.f1393m, "EMAIL_PASSWORD_PROVIDER");
        }
        throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$c, j1.e1] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.firebase.auth.FirebaseAuth$c, j1.e1] */
    public final Task<i> w0(a0 a0Var, h hVar) {
        com.google.android.gms.common.internal.q.k(a0Var);
        com.google.android.gms.common.internal.q.k(hVar);
        h v5 = hVar.v();
        if (!(v5 instanceof j)) {
            return v5 instanceof o0 ? this.f1385e.zzb(this.f1381a, a0Var, (o0) v5, this.f1391k, (j1.e1) new c()) : this.f1385e.zzc(this.f1381a, a0Var, v5, a0Var.y(), new c());
        }
        j jVar = (j) v5;
        return "password".equals(jVar.u()) ? a0(jVar.zzc(), com.google.android.gms.common.internal.q.e(jVar.zzd()), a0Var.y(), a0Var, true) : t0(com.google.android.gms.common.internal.q.e(jVar.zze())) ? Tasks.forException(zzach.zza(new Status(17072))) : N(jVar, a0Var, true);
    }

    public void x(String str) {
        String str2;
        com.google.android.gms.common.internal.q.e(str);
        if (str.startsWith("chrome-extension://")) {
            this.B = str;
            return;
        }
        if (str.contains("://")) {
            str2 = str;
        } else {
            str2 = "http://" + str;
        }
        try {
            this.B = (String) com.google.android.gms.common.internal.q.k(new URI(str2).getHost());
        } catch (URISyntaxException e5) {
            if (Log.isLoggable("FirebaseAuth", 4)) {
                Log.i("FirebaseAuth", "Error parsing URL: '" + str + "', " + e5.getMessage());
            }
            this.B = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$c, j1.e1] */
    public final Task<Void> x0(a0 a0Var, String str) {
        com.google.android.gms.common.internal.q.k(a0Var);
        com.google.android.gms.common.internal.q.e(str);
        return this.f1385e.zzc(this.f1381a, a0Var, str, new c());
    }

    public void y(String str) {
        com.google.android.gms.common.internal.q.e(str);
        synchronized (this.f1388h) {
            this.f1389i = str;
        }
    }

    public final b2.b<a2.i> y0() {
        return this.f1403w;
    }

    public void z(String str) {
        com.google.android.gms.common.internal.q.e(str);
        synchronized (this.f1390j) {
            this.f1391k = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$c, j1.e1] */
    public final Task<Void> z0(a0 a0Var, String str) {
        com.google.android.gms.common.internal.q.k(a0Var);
        com.google.android.gms.common.internal.q.e(str);
        return this.f1385e.zzd(this.f1381a, a0Var, str, new c());
    }
}
