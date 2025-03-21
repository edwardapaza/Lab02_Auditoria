package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1135a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static k1 f1136b = null;

    /* renamed from: c  reason: collision with root package name */
    static HandlerThread f1137c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Executor f1138d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f1139e = false;

    public static int a() {
        return 4225;
    }

    public static h b(Context context) {
        synchronized (f1135a) {
            if (f1136b == null) {
                f1136b = new k1(context.getApplicationContext(), f1139e ? c().getLooper() : context.getMainLooper(), f1138d);
            }
        }
        return f1136b;
    }

    public static HandlerThread c() {
        synchronized (f1135a) {
            HandlerThread handlerThread = f1137c;
            if (handlerThread != null) {
                return handlerThread;
            }
            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
            f1137c = handlerThread2;
            handlerThread2.start();
            return f1137c;
        }
    }

    protected abstract void d(f1 f1Var, ServiceConnection serviceConnection, String str);

    public final void e(String str, String str2, int i5, ServiceConnection serviceConnection, String str3, boolean z4) {
        d(new f1(str, str2, 4225, z4), serviceConnection, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean f(f1 f1Var, ServiceConnection serviceConnection, String str, Executor executor);
}
