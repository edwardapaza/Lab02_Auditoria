package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j1 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k1 f1152a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j1(k1 k1Var, i1 i1Var) {
        this.f1152a = k1Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        int i5 = message.what;
        if (i5 == 0) {
            hashMap = this.f1152a.f1157f;
            synchronized (hashMap) {
                f1 f1Var = (f1) message.obj;
                hashMap2 = this.f1152a.f1157f;
                h1 h1Var = (h1) hashMap2.get(f1Var);
                if (h1Var != null && h1Var.i()) {
                    if (h1Var.j()) {
                        h1Var.g("GmsClientSupervisor");
                    }
                    hashMap3 = this.f1152a.f1157f;
                    hashMap3.remove(f1Var);
                }
            }
            return true;
        } else if (i5 != 1) {
            return false;
        } else {
            hashMap4 = this.f1152a.f1157f;
            synchronized (hashMap4) {
                f1 f1Var2 = (f1) message.obj;
                hashMap5 = this.f1152a.f1157f;
                h1 h1Var2 = (h1) hashMap5.get(f1Var2);
                if (h1Var2 != null && h1Var2.a() == 3) {
                    String valueOf = String.valueOf(f1Var2);
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + valueOf, new Exception());
                    ComponentName b5 = h1Var2.b();
                    if (b5 == null) {
                        b5 = f1Var2.a();
                    }
                    if (b5 == null) {
                        String c5 = f1Var2.c();
                        q.k(c5);
                        b5 = new ComponentName(c5, "unknown");
                    }
                    h1Var2.onServiceDisconnected(b5);
                }
            }
            return true;
        }
    }
}
