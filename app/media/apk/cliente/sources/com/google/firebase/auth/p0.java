package com.google.firebase.auth;

import android.app.Activity;
import com.google.firebase.auth.q0;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseAuth f1520a;

    /* renamed from: b  reason: collision with root package name */
    private Long f1521b;

    /* renamed from: c  reason: collision with root package name */
    private q0.b f1522c;

    /* renamed from: d  reason: collision with root package name */
    private Executor f1523d;

    /* renamed from: e  reason: collision with root package name */
    private String f1524e;

    /* renamed from: f  reason: collision with root package name */
    private Activity f1525f;

    /* renamed from: g  reason: collision with root package name */
    private q0.a f1526g;

    /* renamed from: h  reason: collision with root package name */
    private l0 f1527h;

    /* renamed from: i  reason: collision with root package name */
    private t0 f1528i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1529j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1530k;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final FirebaseAuth f1531a;

        /* renamed from: b  reason: collision with root package name */
        private String f1532b;

        /* renamed from: c  reason: collision with root package name */
        private Long f1533c;

        /* renamed from: d  reason: collision with root package name */
        private q0.b f1534d;

        /* renamed from: e  reason: collision with root package name */
        private Executor f1535e;

        /* renamed from: f  reason: collision with root package name */
        private Activity f1536f;

        /* renamed from: g  reason: collision with root package name */
        private q0.a f1537g;

        /* renamed from: h  reason: collision with root package name */
        private l0 f1538h;

        /* renamed from: i  reason: collision with root package name */
        private t0 f1539i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f1540j;

        public a(FirebaseAuth firebaseAuth) {
            this.f1531a = (FirebaseAuth) com.google.android.gms.common.internal.q.k(firebaseAuth);
        }

        public final p0 a() {
            boolean z4;
            String str;
            com.google.android.gms.common.internal.q.l(this.f1531a, "FirebaseAuth instance cannot be null");
            com.google.android.gms.common.internal.q.l(this.f1533c, "You must specify an auto-retrieval timeout; please call #setTimeout()");
            com.google.android.gms.common.internal.q.l(this.f1534d, "You must specify callbacks on your PhoneAuthOptions. Please call #setCallbacks()");
            this.f1535e = this.f1531a.G0();
            if (this.f1533c.longValue() < 0 || this.f1533c.longValue() > 120) {
                throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
            }
            l0 l0Var = this.f1538h;
            if (l0Var == null) {
                com.google.android.gms.common.internal.q.f(this.f1532b, "The given phoneNumber is empty. Please set a non-empty phone number with #setPhoneNumber()");
                com.google.android.gms.common.internal.q.b(!this.f1540j, "You cannot require sms validation without setting a multi-factor session.");
                com.google.android.gms.common.internal.q.b(this.f1539i == null, "A phoneMultiFactorInfo must be set for second factor sign-in.");
            } else {
                if (l0Var != null && ((j1.p) l0Var).x()) {
                    com.google.android.gms.common.internal.q.e(this.f1532b);
                    z4 = this.f1539i == null;
                    str = "Invalid MultiFactorSession - use the getSession method in MultiFactorResolver to get a valid sign-in session.";
                } else {
                    com.google.android.gms.common.internal.q.b(this.f1539i != null, "A phoneMultiFactorInfo must be set for second factor sign-in.");
                    z4 = this.f1532b == null;
                    str = "A phone number must not be set for MFA sign-in. A PhoneMultiFactorInfo should be set instead.";
                }
                com.google.android.gms.common.internal.q.b(z4, str);
            }
            return new p0(this.f1531a, this.f1533c, this.f1534d, this.f1535e, this.f1532b, this.f1536f, this.f1537g, this.f1538h, this.f1539i, this.f1540j);
        }

        public final a b(Activity activity) {
            this.f1536f = activity;
            return this;
        }

        public final a c(q0.b bVar) {
            this.f1534d = bVar;
            return this;
        }

        public final a d(q0.a aVar) {
            this.f1537g = aVar;
            return this;
        }

        public final a e(t0 t0Var) {
            this.f1539i = t0Var;
            return this;
        }

        public final a f(l0 l0Var) {
            this.f1538h = l0Var;
            return this;
        }

        public final a g(String str) {
            this.f1532b = str;
            return this;
        }

        public final a h(Long l5, TimeUnit timeUnit) {
            this.f1533c = Long.valueOf(TimeUnit.SECONDS.convert(l5.longValue(), timeUnit));
            return this;
        }
    }

    private p0(FirebaseAuth firebaseAuth, Long l5, q0.b bVar, Executor executor, String str, Activity activity, q0.a aVar, l0 l0Var, t0 t0Var, boolean z4) {
        this.f1520a = firebaseAuth;
        this.f1524e = str;
        this.f1521b = l5;
        this.f1522c = bVar;
        this.f1525f = activity;
        this.f1523d = executor;
        this.f1526g = aVar;
        this.f1527h = l0Var;
        this.f1528i = t0Var;
        this.f1529j = z4;
    }

    public final Activity a() {
        return this.f1525f;
    }

    public final void b(boolean z4) {
        this.f1530k = true;
    }

    public final FirebaseAuth c() {
        return this.f1520a;
    }

    public final l0 d() {
        return this.f1527h;
    }

    public final q0.a e() {
        return this.f1526g;
    }

    public final q0.b f() {
        return this.f1522c;
    }

    public final t0 g() {
        return this.f1528i;
    }

    public final Long h() {
        return this.f1521b;
    }

    public final String i() {
        return this.f1524e;
    }

    public final Executor j() {
        return this.f1523d;
    }

    public final boolean k() {
        return this.f1530k;
    }

    public final boolean l() {
        return this.f1529j;
    }

    public final boolean m() {
        return this.f1527h != null;
    }
}
