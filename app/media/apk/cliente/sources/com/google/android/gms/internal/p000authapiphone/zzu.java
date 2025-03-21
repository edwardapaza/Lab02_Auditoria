package com.google.android.gms.internal.p000authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import i0.b;
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzu  reason: invalid package */
/* loaded from: classes.dex */
public final class zzu extends b {
    public zzu(Activity activity) {
        super(activity);
    }

    public zzu(Context context) {
        super(context);
    }

    @Override // i0.b
    public final Task<Void> startSmsRetriever() {
        return doWrite(r.a().b(new p(this) { // from class: com.google.android.gms.internal.auth-api-phone.zzx
            private final zzu zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.p
            public final void accept(Object obj, Object obj2) {
                ((zzj) ((zzv) obj).getService()).zza(new zzz(this.zza, (TaskCompletionSource) obj2));
            }
        }).d(zzaa.zzb).a());
    }

    @Override // i0.b
    public final Task<Void> startSmsUserConsent(final String str) {
        return doWrite(r.a().b(new p(this, str) { // from class: com.google.android.gms.internal.auth-api-phone.zzw
            private final zzu zza;
            private final String zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = str;
            }

            @Override // com.google.android.gms.common.api.internal.p
            public final void accept(Object obj, Object obj2) {
                zzu zzuVar = this.zza;
                ((zzj) ((zzv) obj).getService()).zza(this.zzb, new zzy(zzuVar, (TaskCompletionSource) obj2));
            }
        }).d(zzaa.zzc).a());
    }
}
