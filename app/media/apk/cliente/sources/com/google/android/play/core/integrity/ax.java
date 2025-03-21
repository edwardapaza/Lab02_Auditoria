package com.google.android.play.core.integrity;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.c0;
import com.google.android.play.integrity.internal.j0;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class ax {

    /* renamed from: a  reason: collision with root package name */
    final com.google.android.play.integrity.internal.d f1289a;

    /* renamed from: b  reason: collision with root package name */
    private final c0 f1290b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1291c;

    /* renamed from: d  reason: collision with root package name */
    private final TaskCompletionSource f1292d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(Context context, c0 c0Var) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f1292d = taskCompletionSource;
        this.f1291c = context.getPackageName();
        this.f1290b = c0Var;
        com.google.android.play.integrity.internal.d dVar = new com.google.android.play.integrity.internal.d(context, c0Var, "ExpressIntegrityService", ay.f1293a, new j0() { // from class: com.google.android.play.core.integrity.ap
            @Override // com.google.android.play.integrity.internal.j0
            public final Object a(IBinder iBinder) {
                return com.google.android.play.integrity.internal.t.b(iBinder);
            }
        }, null);
        this.f1289a = dVar;
        dVar.c().post(new aq(this, taskCompletionSource, context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Bundle a(ax axVar, String str, long j5, long j6) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", axVar.f1291c);
        bundle.putLong("cloud.prj", j5);
        bundle.putString("nonce", str);
        bundle.putLong("warm.up.sid", j6);
        ArrayList arrayList = new ArrayList();
        com.google.android.play.integrity.internal.p.b(5, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(com.google.android.play.integrity.internal.p.a(arrayList)));
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Bundle b(ax axVar, long j5) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", axVar.f1291c);
        bundle.putLong("cloud.prj", j5);
        ArrayList arrayList = new ArrayList();
        com.google.android.play.integrity.internal.p.b(4, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(com.google.android.play.integrity.internal.p.a(arrayList)));
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean g(ax axVar) {
        return axVar.f1292d.getTask().isSuccessful() && !((Boolean) axVar.f1292d.getTask().getResult()).booleanValue();
    }

    public final Task c(String str, long j5, long j6) {
        this.f1290b.c("requestExpressIntegrityToken(%s)", Long.valueOf(j6));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f1289a.t(new as(this, taskCompletionSource, str, j5, j6, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task d(long j5) {
        this.f1290b.c("warmUpIntegrityToken(%s)", Long.valueOf(j5));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f1289a.t(new ar(this, taskCompletionSource, j5, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
