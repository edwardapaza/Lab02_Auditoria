package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f1055a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ w f1056b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(w wVar, TaskCompletionSource taskCompletionSource) {
        this.f1056b = wVar;
        this.f1055a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        Map map;
        map = this.f1056b.f1059b;
        map.remove(this.f1055a);
    }
}
