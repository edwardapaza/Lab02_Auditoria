package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.g0;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.api.internal.l0;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.x;
import com.google.android.gms.common.api.internal.z0;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
/* loaded from: classes.dex */
public abstract class e<O extends a.d> {
    protected final com.google.android.gms.common.api.internal.f zaa;
    private final Context zab;
    private final String zac;
    private final com.google.android.gms.common.api.a<O> zad;
    private final O zae;
    private final com.google.android.gms.common.api.internal.b<O> zaf;
    private final Looper zag;
    private final int zah;
    private final f zai;
    private final q zaj;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final a f891c = new C0038a().a();

        /* renamed from: a  reason: collision with root package name */
        public final q f892a;

        /* renamed from: b  reason: collision with root package name */
        public final Looper f893b;

        /* renamed from: com.google.android.gms.common.api.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0038a {

            /* renamed from: a  reason: collision with root package name */
            private q f894a;

            /* renamed from: b  reason: collision with root package name */
            private Looper f895b;

            public a a() {
                if (this.f894a == null) {
                    this.f894a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.f895b == null) {
                    this.f895b = Looper.getMainLooper();
                }
                return new a(this.f894a, this.f895b);
            }

            public C0038a b(Looper looper) {
                com.google.android.gms.common.internal.q.l(looper, "Looper must not be null.");
                this.f895b = looper;
                return this;
            }

            public C0038a c(q qVar) {
                com.google.android.gms.common.internal.q.l(qVar, "StatusExceptionMapper must not be null.");
                this.f894a = qVar;
                return this;
            }
        }

        private a(q qVar, Account account, Looper looper) {
            this.f892a = qVar;
            this.f893b = looper;
        }
    }

    public e(Activity activity, com.google.android.gms.common.api.a<O> aVar, O o5, a aVar2) {
        this(activity, activity, aVar, o5, aVar2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(android.app.Activity r2, com.google.android.gms.common.api.a<O> r3, O r4, com.google.android.gms.common.api.internal.q r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.e$a$a r0 = new com.google.android.gms.common.api.e$a$a
            r0.<init>()
            r0.c(r5)
            android.os.Looper r5 = r2.getMainLooper()
            r0.b(r5)
            com.google.android.gms.common.api.e$a r5 = r0.a()
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.e.<init>(android.app.Activity, com.google.android.gms.common.api.a, com.google.android.gms.common.api.a$d, com.google.android.gms.common.api.internal.q):void");
    }

    private e(Context context, Activity activity, com.google.android.gms.common.api.a<O> aVar, O o5, a aVar2) {
        com.google.android.gms.common.internal.q.l(context, "Null context is not permitted.");
        com.google.android.gms.common.internal.q.l(aVar, "Api must not be null.");
        com.google.android.gms.common.internal.q.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.zab = context.getApplicationContext();
        String str = null;
        if (q0.j.i()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.zac = str;
        this.zad = aVar;
        this.zae = o5;
        this.zag = aVar2.f893b;
        com.google.android.gms.common.api.internal.b<O> a5 = com.google.android.gms.common.api.internal.b.a(aVar, o5, str);
        this.zaf = a5;
        this.zai = new l0(this);
        com.google.android.gms.common.api.internal.f x4 = com.google.android.gms.common.api.internal.f.x(this.zab);
        this.zaa = x4;
        this.zah = x4.m();
        this.zaj = aVar2.f892a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            x.j(activity, x4, a5);
        }
        x4.b(this);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(android.content.Context r2, com.google.android.gms.common.api.a<O> r3, O r4, android.os.Looper r5, com.google.android.gms.common.api.internal.q r6) {
        /*
            r1 = this;
            com.google.android.gms.common.api.e$a$a r0 = new com.google.android.gms.common.api.e$a$a
            r0.<init>()
            r0.b(r5)
            r0.c(r6)
            com.google.android.gms.common.api.e$a r5 = r0.a()
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.e.<init>(android.content.Context, com.google.android.gms.common.api.a, com.google.android.gms.common.api.a$d, android.os.Looper, com.google.android.gms.common.api.internal.q):void");
    }

    public e(Context context, com.google.android.gms.common.api.a<O> aVar, O o5, a aVar2) {
        this(context, (Activity) null, aVar, o5, aVar2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(android.content.Context r2, com.google.android.gms.common.api.a<O> r3, O r4, com.google.android.gms.common.api.internal.q r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.e$a$a r0 = new com.google.android.gms.common.api.e$a$a
            r0.<init>()
            r0.c(r5)
            com.google.android.gms.common.api.e$a r5 = r0.a()
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.e.<init>(android.content.Context, com.google.android.gms.common.api.a, com.google.android.gms.common.api.a$d, com.google.android.gms.common.api.internal.q):void");
    }

    private final <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends j, A>> T zad(int i5, T t5) {
        t5.i();
        this.zaa.F(this, i5, t5);
        return t5;
    }

    private final <TResult, A extends a.b> Task<TResult> zae(int i5, r<A, TResult> rVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.G(this, i5, rVar, taskCompletionSource, this.zaj);
        return taskCompletionSource.getTask();
    }

    public f asGoogleApiClient() {
        return this.zai;
    }

    protected d.a createClientSettingsBuilder() {
        Account a5;
        GoogleSignInAccount b5;
        GoogleSignInAccount b6;
        d.a aVar = new d.a();
        O o5 = this.zae;
        if (!(o5 instanceof a.d.b) || (b6 = ((a.d.b) o5).b()) == null) {
            O o6 = this.zae;
            a5 = o6 instanceof a.d.InterfaceC0037a ? ((a.d.InterfaceC0037a) o6).a() : null;
        } else {
            a5 = b6.t();
        }
        aVar.d(a5);
        O o7 = this.zae;
        aVar.c((!(o7 instanceof a.d.b) || (b5 = ((a.d.b) o7).b()) == null) ? Collections.emptySet() : b5.y());
        aVar.e(this.zab.getClass().getName());
        aVar.b(this.zab.getPackageName());
        return aVar;
    }

    protected Task<Boolean> disconnectService() {
        return this.zaa.z(this);
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends j, A>> T doBestEffortWrite(T t5) {
        zad(2, t5);
        return t5;
    }

    public <TResult, A extends a.b> Task<TResult> doBestEffortWrite(r<A, TResult> rVar) {
        return zae(2, rVar);
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends j, A>> T doRead(T t5) {
        zad(0, t5);
        return t5;
    }

    public <TResult, A extends a.b> Task<TResult> doRead(r<A, TResult> rVar) {
        return zae(0, rVar);
    }

    @Deprecated
    public <A extends a.b, T extends com.google.android.gms.common.api.internal.n<A, ?>, U extends t<A, ?>> Task<Void> doRegisterEventListener(T t5, U u5) {
        com.google.android.gms.common.internal.q.k(t5);
        com.google.android.gms.common.internal.q.k(u5);
        throw null;
    }

    public <A extends a.b> Task<Void> doRegisterEventListener(com.google.android.gms.common.api.internal.o<A, ?> oVar) {
        com.google.android.gms.common.internal.q.k(oVar);
        throw null;
    }

    public Task<Boolean> doUnregisterEventListener(j.a<?> aVar) {
        return doUnregisterEventListener(aVar, 0);
    }

    public Task<Boolean> doUnregisterEventListener(j.a<?> aVar, int i5) {
        com.google.android.gms.common.internal.q.l(aVar, "Listener key cannot be null.");
        return this.zaa.A(this, aVar, i5);
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends j, A>> T doWrite(T t5) {
        zad(1, t5);
        return t5;
    }

    public <TResult, A extends a.b> Task<TResult> doWrite(r<A, TResult> rVar) {
        return zae(1, rVar);
    }

    public final com.google.android.gms.common.api.internal.b<O> getApiKey() {
        return this.zaf;
    }

    public O getApiOptions() {
        return this.zae;
    }

    public Context getApplicationContext() {
        return this.zab;
    }

    protected String getContextAttributionTag() {
        return this.zac;
    }

    @Deprecated
    protected String getContextFeatureId() {
        return this.zac;
    }

    public Looper getLooper() {
        return this.zag;
    }

    public <L> com.google.android.gms.common.api.internal.j<L> registerListener(L l5, String str) {
        return com.google.android.gms.common.api.internal.k.a(l5, this.zag, str);
    }

    public final int zaa() {
        return this.zah;
    }

    public final a.f zab(Looper looper, g0<O> g0Var) {
        a.f buildClient = ((a.AbstractC0036a) com.google.android.gms.common.internal.q.k(this.zad.a())).buildClient(this.zab, looper, createClientSettingsBuilder().a(), (com.google.android.gms.common.internal.d) this.zae, (f.a) g0Var, (f.b) g0Var);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (buildClient instanceof com.google.android.gms.common.internal.c)) {
            ((com.google.android.gms.common.internal.c) buildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && (buildClient instanceof com.google.android.gms.common.api.internal.l)) {
            ((com.google.android.gms.common.api.internal.l) buildClient).d(contextAttributionTag);
        }
        return buildClient;
    }

    public final z0 zac(Context context, Handler handler) {
        return new z0(context, handler, createClientSettingsBuilder().a());
    }
}
