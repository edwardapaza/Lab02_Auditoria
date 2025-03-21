package j1;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001firebaseauthapi.zzags;
import com.google.android.gms.internal.p001firebaseauthapi.zzaq;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: d  reason: collision with root package name */
    private static long f5452d = 3600000;

    /* renamed from: e  reason: collision with root package name */
    private static final zzaq<String> f5453e = zzaq.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");

    /* renamed from: f  reason: collision with root package name */
    private static final o0 f5454f = new o0();

    /* renamed from: a  reason: collision with root package name */
    private Task<com.google.firebase.auth.i> f5455a;

    /* renamed from: b  reason: collision with root package name */
    private Task<String> f5456b;

    /* renamed from: c  reason: collision with root package name */
    private long f5457c = 0;

    private o0() {
    }

    public static void b(Context context, Status status) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.u());
        edit.putString("statusMessage", status.v());
        edit.putLong("timestamp", q0.f.b().a());
        edit.commit();
    }

    public static void c(Context context, zzags zzagsVar, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("verifyAssertionRequest", m0.e.f(zzagsVar));
        edit.putString("operation", str);
        edit.putString("tenantId", str2);
        edit.putLong("timestamp", q0.f.b().a());
        edit.commit();
    }

    public static void d(Context context, FirebaseAuth firebaseAuth) {
        com.google.android.gms.common.internal.q.k(context);
        com.google.android.gms.common.internal.q.k(firebaseAuth);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.l().q());
        edit.commit();
    }

    public static void e(Context context, FirebaseAuth firebaseAuth, com.google.firebase.auth.a0 a0Var) {
        com.google.android.gms.common.internal.q.k(context);
        com.google.android.gms.common.internal.q.k(firebaseAuth);
        com.google.android.gms.common.internal.q.k(a0Var);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.l().q());
        edit.putString("firebaseUserUid", a0Var.a());
        edit.commit();
    }

    public static void f(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("recaptchaToken", str);
        edit.putString("operation", str2);
        edit.putLong("timestamp", q0.f.b().a());
        edit.commit();
    }

    private static void g(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        zzaq<String> zzaqVar = f5453e;
        int size = zzaqVar.size();
        int i5 = 0;
        while (i5 < size) {
            String str = zzaqVar.get(i5);
            i5++;
            edit.remove(str);
        }
        edit.commit();
    }

    public static o0 j() {
        return f5454f;
    }

    public final void a(Context context) {
        com.google.android.gms.common.internal.q.k(context);
        g(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.f5455a = null;
        this.f5457c = 0L;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008b, code lost:
        if (r4.equals("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE") == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(com.google.firebase.auth.FirebaseAuth r12) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.o0.h(com.google.firebase.auth.FirebaseAuth):void");
    }

    public final Task<String> i() {
        if (q0.f.b().a() - this.f5457c < f5452d) {
            return this.f5456b;
        }
        return null;
    }
}
