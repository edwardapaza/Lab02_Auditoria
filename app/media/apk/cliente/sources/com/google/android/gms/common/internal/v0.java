package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.internal.common.zzi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v0 extends zzi {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1207a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(c cVar, Looper looper) {
        super(looper);
        this.f1207a = cVar;
    }

    private static final void a(Message message) {
        w0 w0Var = (w0) message.obj;
        w0Var.b();
        w0Var.e();
    }

    private static final boolean b(Message message) {
        int i5 = message.what;
        return i5 == 2 || i5 == 1 || i5 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        c.a aVar;
        c.a aVar2;
        l0.a aVar3;
        l0.a aVar4;
        boolean z4;
        if (this.f1207a.zzd.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i5 = message.what;
        if ((i5 == 1 || i5 == 7 || ((i5 == 4 && !this.f1207a.enableLocalFallback()) || message.what == 5)) && !this.f1207a.isConnecting()) {
            a(message);
            return;
        }
        int i6 = message.what;
        if (i6 == 4) {
            this.f1207a.zzB = new l0.a(message.arg2);
            if (c.zzo(this.f1207a)) {
                c cVar = this.f1207a;
                z4 = cVar.zzC;
                if (!z4) {
                    cVar.zzp(3, null);
                    return;
                }
            }
            c cVar2 = this.f1207a;
            aVar4 = cVar2.zzB;
            l0.a aVar5 = aVar4 != null ? cVar2.zzB : new l0.a(8);
            this.f1207a.zzc.a(aVar5);
            this.f1207a.onConnectionFailed(aVar5);
        } else if (i6 == 5) {
            c cVar3 = this.f1207a;
            aVar3 = cVar3.zzB;
            l0.a aVar6 = aVar3 != null ? cVar3.zzB : new l0.a(8);
            this.f1207a.zzc.a(aVar6);
            this.f1207a.onConnectionFailed(aVar6);
        } else if (i6 == 3) {
            Object obj = message.obj;
            l0.a aVar7 = new l0.a(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f1207a.zzc.a(aVar7);
            this.f1207a.onConnectionFailed(aVar7);
        } else if (i6 == 6) {
            this.f1207a.zzp(5, null);
            c cVar4 = this.f1207a;
            aVar = cVar4.zzw;
            if (aVar != null) {
                aVar2 = cVar4.zzw;
                aVar2.a(message.arg2);
            }
            this.f1207a.onConnectionSuspended(message.arg2);
            c.zzn(this.f1207a, 5, 1, null);
        } else if (i6 == 2 && !this.f1207a.isConnected()) {
            a(message);
        } else if (b(message)) {
            ((w0) message.obj).c();
        } else {
            int i7 = message.what;
            Log.wtf("GmsClient", "Don't know how to handle message: " + i7, new Exception());
        }
    }
}
