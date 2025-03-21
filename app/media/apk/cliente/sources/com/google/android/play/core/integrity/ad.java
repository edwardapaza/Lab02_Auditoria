package com.google.android.play.core.integrity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.integrity.internal.c0;
import com.google.android.play.integrity.internal.j0;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class ad {

    /* renamed from: a  reason: collision with root package name */
    final com.google.android.play.integrity.internal.d f1257a;

    /* renamed from: b  reason: collision with root package name */
    private final c0 f1258b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1259c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(Context context, c0 c0Var) {
        this.f1259c = context.getPackageName();
        this.f1258b = c0Var;
        if (com.google.android.play.integrity.internal.h.a(context)) {
            this.f1257a = new com.google.android.play.integrity.internal.d(context, c0Var, "IntegrityService", ae.f1260a, new j0() { // from class: com.google.android.play.core.integrity.aa
                @Override // com.google.android.play.integrity.internal.j0
                public final Object a(IBinder iBinder) {
                    return com.google.android.play.integrity.internal.y.b(iBinder);
                }
            }, null);
            return;
        }
        c0Var.a("Phonesky is not installed.", new Object[0]);
        this.f1257a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Bundle a(ad adVar, byte[] bArr, Long l5, Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", adVar.f1259c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 2);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l5 != null) {
            bundle.putLong("cloud.prj", l5.longValue());
        }
        ArrayList arrayList = new ArrayList();
        com.google.android.play.integrity.internal.p.b(3, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(com.google.android.play.integrity.internal.p.a(arrayList)));
        return bundle;
    }

    public final Task b(IntegrityTokenRequest integrityTokenRequest) {
        if (this.f1257a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        try {
            byte[] decode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long cloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            if (Build.VERSION.SDK_INT >= 23) {
                integrityTokenRequest.a();
            }
            this.f1258b.c("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.f1257a.t(new ab(this, taskCompletionSource, decode, cloudProjectNumber, null, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e5) {
            return Tasks.forException(new IntegrityServiceException(-13, e5));
        }
    }
}
