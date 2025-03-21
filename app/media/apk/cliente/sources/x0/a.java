package x0;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.k0;
import com.google.android.gms.common.internal.q;
/* loaded from: classes.dex */
public class a extends com.google.android.gms.common.internal.g<g> implements w0.f {

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ int f8317e = 0;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f8318a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.gms.common.internal.d f8319b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f8320c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f8321d;

    public a(Context context, Looper looper, boolean z4, com.google.android.gms.common.internal.d dVar, Bundle bundle, f.a aVar, f.b bVar) {
        super(context, looper, 44, dVar, aVar, bVar);
        this.f8318a = true;
        this.f8319b = dVar;
        this.f8320c = bundle;
        this.f8321d = dVar.g();
    }

    public static Bundle c(com.google.android.gms.common.internal.d dVar) {
        dVar.f();
        Integer g5 = dVar.g();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.a());
        if (g5 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", g5.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    @Override // w0.f
    public final void a() {
        connect(new c.d());
    }

    @Override // w0.f
    public final void b(f fVar) {
        q.l(fVar, "Expecting a valid ISignInCallbacks");
        try {
            Account b5 = this.f8319b.b();
            ((g) getService()).a(new j(1, new k0(b5, ((Integer) q.k(this.f8321d)).intValue(), com.google.android.gms.common.internal.c.DEFAULT_ACCOUNT.equals(b5.name) ? j0.a.a(getContext()).b() : null)), fVar);
        } catch (RemoteException e5) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                fVar.j(new l(1, new l0.a(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof g ? (g) queryLocalInterface : new g(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c
    protected final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.f8319b.d())) {
            this.f8320c.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f8319b.d());
        }
        return this.f8320c;
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return l0.k.f5890a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final boolean requiresSignIn() {
        return this.f8318a;
    }
}
