package i0;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.internal.p000authapiphone.zzv;
import com.google.android.gms.tasks.Task;
/* loaded from: classes.dex */
public abstract class b extends e<a.d.c> {
    private static final a.g<zzv> zza;
    private static final a.AbstractC0036a<zzv, a.d.c> zzb;
    private static final com.google.android.gms.common.api.a<a.d.c> zzc;

    static {
        a.g<zzv> gVar = new a.g<>();
        zza = gVar;
        c cVar = new c();
        zzb = cVar;
        zzc = new com.google.android.gms.common.api.a<>("SmsRetriever.API", cVar, gVar);
    }

    public b(Activity activity) {
        super(activity, (com.google.android.gms.common.api.a<a.d>) zzc, (a.d) null, e.a.f891c);
    }

    public b(Context context) {
        super(context, zzc, (a.d) null, e.a.f891c);
    }

    public abstract Task<Void> startSmsRetriever();

    public abstract Task<Void> startSmsUserConsent(String str);
}
