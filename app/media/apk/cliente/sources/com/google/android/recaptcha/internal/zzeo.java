package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.Map;
import s3.p;
import t3.h0;
/* loaded from: classes.dex */
public final class zzeo implements zzen {
    private final Context zzb;
    private final Map zzc;

    public zzeo(Context context) {
        Map e5;
        this.zzb = context;
        e5 = h0.e(p.a(2, "activity"), p.a(3, "phone"), p.a(4, "input_method"), p.a(5, "audio"));
        this.zzc = e5;
    }

    @Override // com.google.android.recaptcha.internal.zzen
    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzel.zza(this, objArr);
    }

    @Override // com.google.android.recaptcha.internal.zzen
    public final Object zza(Object... objArr) {
        Object obj = objArr[0];
        if (true != (obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            Object obj2 = this.zzc.get(Integer.valueOf(num.intValue()));
            if (obj2 != null) {
                return this.zzb.getSystemService((String) obj2);
            }
            throw new zzae(4, 4, null);
        }
        throw new zzae(4, 5, null);
    }
}
