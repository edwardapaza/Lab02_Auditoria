package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class c<T extends IInterface> {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private volatile String zzA;
    private l0.a zzB;
    private boolean zzC;
    private volatile b1 zzD;
    m1 zza;
    final Handler zzb;
    protected InterfaceC0039c zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final h zzn;
    private final l0.g zzo;
    private final Object zzp;
    private final Object zzq;
    private m zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private y0 zzu;
    private int zzv;
    private final a zzw;
    private final b zzx;
    private final int zzy;
    private final String zzz;
    private static final l0.c[] zze = new l0.c[0];
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    /* loaded from: classes.dex */
    public interface a {
        void a(int i5);

        void f(Bundle bundle);
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(l0.a aVar);
    }

    /* renamed from: com.google.android.gms.common.internal.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0039c {
        void a(l0.a aVar);
    }

    /* loaded from: classes.dex */
    protected class d implements InterfaceC0039c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.c.InterfaceC0039c
        public final void a(l0.a aVar) {
            if (aVar.x()) {
                c cVar = c.this;
                cVar.getRemoteService(null, cVar.getScopes());
            } else if (c.this.zzx != null) {
                c.this.zzx.b(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, Handler handler, h hVar, l0.g gVar, int i5, a aVar, b bVar) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        q.l(context, "Context must not be null");
        this.zzl = context;
        q.l(handler, "Handler must not be null");
        this.zzb = handler;
        this.zzm = handler.getLooper();
        q.l(hVar, "Supervisor must not be null");
        this.zzn = hVar;
        q.l(gVar, "API availability must not be null");
        this.zzo = gVar;
        this.zzy = i5;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected c(android.content.Context r10, android.os.Looper r11, int r12, com.google.android.gms.common.internal.c.a r13, com.google.android.gms.common.internal.c.b r14, java.lang.String r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.h r3 = com.google.android.gms.common.internal.h.b(r10)
            l0.g r4 = l0.g.e()
            com.google.android.gms.common.internal.q.k(r13)
            com.google.android.gms.common.internal.q.k(r14)
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.c.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.c$a, com.google.android.gms.common.internal.c$b, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, Looper looper, h hVar, l0.g gVar, int i5, a aVar, b bVar, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        q.l(context, "Context must not be null");
        this.zzl = context;
        q.l(looper, "Looper must not be null");
        this.zzm = looper;
        q.l(hVar, "Supervisor must not be null");
        this.zzn = hVar;
        q.l(gVar, "API availability must not be null");
        this.zzo = gVar;
        this.zzb = new v0(this, looper);
        this.zzy = i5;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzj(c cVar, b1 b1Var) {
        cVar.zzD = b1Var;
        if (cVar.usesClientTelemetry()) {
            com.google.android.gms.common.internal.e eVar = b1Var.f1082d;
            r.b().c(eVar == null ? null : eVar.y());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzk(c cVar, int i5) {
        int i6;
        int i7;
        synchronized (cVar.zzp) {
            i6 = cVar.zzv;
        }
        if (i6 == 3) {
            cVar.zzC = true;
            i7 = 5;
        } else {
            i7 = 4;
        }
        Handler handler = cVar.zzb;
        handler.sendMessage(handler.obtainMessage(i7, cVar.zzd.get(), 16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zzn(c cVar, int i5, int i6, IInterface iInterface) {
        synchronized (cVar.zzp) {
            if (cVar.zzv != i5) {
                return false;
            }
            cVar.zzp(i6, iInterface);
            return true;
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException
        	at java.base/java.util.BitSet.or(BitSet.java:941)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    static /* bridge */ /* synthetic */ boolean zzo(com.google.android.gms.common.internal.c r2) {
        /*
            boolean r0 = r2.zzC
            r1 = 0
            if (r0 == 0) goto L6
            goto L24
        L6:
            java.lang.String r0 = r2.getServiceDescriptor()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L11
            goto L24
        L11:
            java.lang.String r0 = r2.getLocalStartServiceAction()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L1c
            goto L24
        L1c:
            java.lang.String r2 = r2.getServiceDescriptor()     // Catch: java.lang.ClassNotFoundException -> L24
            java.lang.Class.forName(r2)     // Catch: java.lang.ClassNotFoundException -> L24
            r1 = 1
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.c.zzo(com.google.android.gms.common.internal.c):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzp(int i5, IInterface iInterface) {
        m1 m1Var;
        q.a((i5 == 4) == (iInterface != 0));
        synchronized (this.zzp) {
            this.zzv = i5;
            this.zzs = iInterface;
            if (i5 == 1) {
                y0 y0Var = this.zzu;
                if (y0Var != null) {
                    h hVar = this.zzn;
                    String b5 = this.zza.b();
                    q.k(b5);
                    hVar.e(b5, this.zza.a(), 4225, y0Var, zze(), this.zza.c());
                    this.zzu = null;
                }
            } else if (i5 == 2 || i5 == 3) {
                y0 y0Var2 = this.zzu;
                if (y0Var2 != null && (m1Var = this.zza) != null) {
                    String b6 = m1Var.b();
                    String a5 = m1Var.a();
                    Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + b6 + " on " + a5);
                    h hVar2 = this.zzn;
                    String b7 = this.zza.b();
                    q.k(b7);
                    hVar2.e(b7, this.zza.a(), 4225, y0Var2, zze(), this.zza.c());
                    this.zzd.incrementAndGet();
                }
                y0 y0Var3 = new y0(this, this.zzd.get());
                this.zzu = y0Var3;
                m1 m1Var2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new m1(getStartServicePackage(), getStartServiceAction(), false, 4225, getUseDynamicLookup()) : new m1(getContext().getPackageName(), getLocalStartServiceAction(), true, 4225, false);
                this.zza = m1Var2;
                if (m1Var2.c() && getMinApkVersion() < 17895000) {
                    throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.b())));
                }
                h hVar3 = this.zzn;
                String b8 = this.zza.b();
                q.k(b8);
                if (!hVar3.f(new f1(b8, this.zza.a(), 4225, this.zza.c()), y0Var3, zze(), getBindServiceExecutor())) {
                    String b9 = this.zza.b();
                    String a6 = this.zza.a();
                    Log.w("GmsClient", "unable to connect to service: " + b9 + " on " + a6);
                    zzl(16, null, this.zzd.get());
                }
            } else if (i5 == 4) {
                q.k(iInterface);
                onConnectedLocked(iInterface);
            }
        }
    }

    public void checkAvailabilityAndConnect() {
        int g5 = this.zzo.g(this.zzl, getMinApkVersion());
        if (g5 == 0) {
            connect(new d());
            return;
        }
        zzp(1, null);
        triggerNotAvailable(new d(), g5, null);
    }

    protected final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(InterfaceC0039c interfaceC0039c) {
        q.l(interfaceC0039c, "Connection progress callbacks cannot be null.");
        this.zzc = interfaceC0039c;
        zzp(2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            int size = this.zzt.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((w0) this.zzt.get(i5)).d();
            }
            this.zzt.clear();
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zzp(1, null);
    }

    public void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i5;
        IInterface iInterface;
        m mVar;
        synchronized (this.zzp) {
            i5 = this.zzv;
            iInterface = this.zzs;
        }
        synchronized (this.zzq) {
            mVar = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        printWriter.print(i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? i5 != 5 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "LOCAL_CONNECTING" : "REMOTE_CONNECTING" : "DISCONNECTED");
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (mVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(mVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j5 = this.zzh;
            String format = simpleDateFormat.format(new Date(j5));
            append.println(j5 + " " + format);
        }
        if (this.zzg > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i6 = this.zzf;
            printWriter.append((CharSequence) (i6 != 1 ? i6 != 2 ? i6 != 3 ? String.valueOf(i6) : "CAUSE_DEAD_OBJECT_EXCEPTION" : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED"));
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j6 = this.zzg;
            String format2 = simpleDateFormat.format(new Date(j6));
            append2.println(j6 + " " + format2);
        }
        if (this.zzj > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) com.google.android.gms.common.api.d.a(this.zzi));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j7 = this.zzj;
            String format3 = simpleDateFormat.format(new Date(j7));
            append3.println(j7 + " " + format3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public l0.c[] getApiFeatures() {
        return zze;
    }

    public final l0.c[] getAvailableFeatures() {
        b1 b1Var = this.zzD;
        if (b1Var == null) {
            return null;
        }
        return b1Var.f1080b;
    }

    protected Executor getBindServiceExecutor() {
        return null;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public String getEndpointPackageName() {
        m1 m1Var;
        if (!isConnected() || (m1Var = this.zza) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return m1Var.a();
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    protected Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    protected String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzm;
    }

    public int getMinApkVersion() {
        return l0.g.f5885a;
    }

    public void getRemoteService(j jVar, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        String str = this.zzA;
        int i5 = l0.g.f5885a;
        Scope[] scopeArr = f.f1112s;
        Bundle bundle = new Bundle();
        int i6 = this.zzy;
        l0.c[] cVarArr = f.f1113t;
        f fVar = new f(6, i6, i5, null, null, scopeArr, bundle, null, cVarArr, cVarArr, true, 0, false, str);
        fVar.f1117d = this.zzl.getPackageName();
        fVar.f1120k = getServiceRequestExtraArgs;
        if (set != null) {
            fVar.f1119f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account(DEFAULT_ACCOUNT, "com.google");
            }
            fVar.f1121l = account;
            if (jVar != null) {
                fVar.f1118e = jVar.asBinder();
            }
        } else if (requiresAccount()) {
            fVar.f1121l = getAccount();
        }
        fVar.f1122m = zze;
        fVar.f1123n = getApiFeatures();
        if (usesClientTelemetry()) {
            fVar.f1126q = true;
        }
        try {
            synchronized (this.zzq) {
                m mVar = this.zzr;
                if (mVar != null) {
                    mVar.d(new x0(this, this.zzd.get()), fVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e5) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e5);
            triggerConnectionSuspended(3);
        } catch (RemoteException e6) {
            e = e6;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        } catch (SecurityException e7) {
            throw e7;
        } catch (RuntimeException e8) {
            e = e8;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        }
    }

    protected Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    public final T getService() {
        T t5;
        synchronized (this.zzp) {
            if (this.zzv == 5) {
                throw new DeadObjectException();
            }
            checkConnected();
            t5 = (T) this.zzs;
            q.l(t5, "Client is connected but service is null");
        }
        return t5;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            m mVar = this.zzr;
            if (mVar == null) {
                return null;
            }
            return mVar.asBinder();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    protected abstract String getStartServiceAction();

    protected String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public com.google.android.gms.common.internal.e getTelemetryConfiguration() {
        b1 b1Var = this.zzD;
        if (b1Var == null) {
            return null;
        }
        return b1Var.f1082d;
    }

    protected boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    public boolean hasConnectionInfo() {
        return this.zzD != null;
    }

    public boolean isConnected() {
        boolean z4;
        synchronized (this.zzp) {
            z4 = this.zzv == 4;
        }
        return z4;
    }

    public boolean isConnecting() {
        boolean z4;
        synchronized (this.zzp) {
            int i5 = this.zzv;
            z4 = true;
            if (i5 != 2 && i5 != 3) {
                z4 = false;
            }
        }
        return z4;
    }

    protected void onConnectedLocked(T t5) {
        this.zzh = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onConnectionFailed(l0.a aVar) {
        this.zzi = aVar.t();
        this.zzj = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onConnectionSuspended(int i5) {
        this.zzf = i5;
        this.zzg = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPostInitHandler(int i5, IBinder iBinder, Bundle bundle, int i6) {
        this.zzb.sendMessage(this.zzb.obtainMessage(1, i6, -1, new z0(this, i5, iBinder, bundle)));
    }

    public void onUserSignOut(e eVar) {
        eVar.a();
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void setAttributionTag(String str) {
        this.zzA = str;
    }

    public void triggerConnectionSuspended(int i5) {
        this.zzb.sendMessage(this.zzb.obtainMessage(6, this.zzd.get(), i5));
    }

    protected void triggerNotAvailable(InterfaceC0039c interfaceC0039c, int i5, PendingIntent pendingIntent) {
        q.l(interfaceC0039c, "Connection progress callbacks cannot be null.");
        this.zzc = interfaceC0039c;
        this.zzb.sendMessage(this.zzb.obtainMessage(3, this.zzd.get(), i5, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    protected final String zze() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzl(int i5, Bundle bundle, int i6) {
        this.zzb.sendMessage(this.zzb.obtainMessage(7, i6, -1, new a1(this, i5, null)));
    }
}
