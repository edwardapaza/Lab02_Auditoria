package com.google.android.gms.internal.p000authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzn  reason: invalid package */
/* loaded from: classes.dex */
public final class zzn extends e<a.d.c> {
    private static final a.g<zzv> zza;
    private static final a.AbstractC0036a<zzv, a.d.c> zzb;
    private static final a<a.d.c> zzc;

    static {
        a.g<zzv> gVar = new a.g<>();
        zza = gVar;
        zzr zzrVar = new zzr();
        zzb = zzrVar;
        zzc = new a<>("SmsCodeAutofill.API", zzrVar, gVar);
    }

    public zzn(Activity activity) {
        super(activity, (a<a.d>) zzc, (a.d) null, e.a.f891c);
    }

    public zzn(Context context) {
        super(context, zzc, (a.d) null, e.a.f891c);
    }

    public final Task<Integer> checkPermissionState() {
        return doRead(r.a().d(zzaa.zza).b(new p(this) { // from class: com.google.android.gms.internal.auth-api-phone.zzp
            private final zzn zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.p
            public final void accept(Object obj, Object obj2) {
                ((zzj) ((zzv) obj).getService()).zza(new zzt(this.zza, (TaskCompletionSource) obj2));
            }
        }).a());
    }

    public final Task<Boolean> hasOngoingSmsRequest(final String str) {
        q.k(str);
        q.b(!str.isEmpty(), "The package name cannot be empty.");
        return doRead(r.a().d(zzaa.zza).b(new p(this, str) { // from class: com.google.android.gms.internal.auth-api-phone.zzo
            private final zzn zza;
            private final String zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = str;
            }

            @Override // com.google.android.gms.common.api.internal.p
            public final void accept(Object obj, Object obj2) {
                zzn zznVar = this.zza;
                ((zzj) ((zzv) obj).getService()).zza(this.zzb, new zzs(zznVar, (TaskCompletionSource) obj2));
            }
        }).a());
    }

    public final Task<Void> startSmsCodeRetriever() {
        return doWrite(r.a().d(zzaa.zza).b(new p(this) { // from class: com.google.android.gms.internal.auth-api-phone.zzm
            private final zzn zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.p
            public final void accept(Object obj, Object obj2) {
                ((zzj) ((zzv) obj).getService()).zza(new zzq(this.zza, (TaskCompletionSource) obj2));
            }
        }).a());
    }
}
