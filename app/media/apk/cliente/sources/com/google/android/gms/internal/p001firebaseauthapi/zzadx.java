package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import o0.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadx  reason: invalid package */
/* loaded from: classes.dex */
public final class zzadx extends BroadcastReceiver {
    private final String zza;
    private final /* synthetic */ zzadt zzb;

    public zzadx(zzadt zzadtVar, String str) {
        this.zzb = zzadtVar;
        this.zza = str;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        HashMap hashMap;
        a aVar;
        a aVar2;
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).u() == 0) {
                String str = (String) extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
                hashMap = this.zzb.zzd;
                zzaea zzaeaVar = (zzaea) hashMap.get(this.zza);
                if (zzaeaVar == null) {
                    aVar2 = zzadt.zza;
                    aVar2.c("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    String zza = zzadt.zza(str);
                    zzaeaVar.zze = zza;
                    if (zza == null) {
                        aVar = zzadt.zza;
                        aVar.c("Unable to extract verification code.", new Object[0]);
                    } else if (!zzah.zzc(zzaeaVar.zzd)) {
                        zzadt.zza(this.zzb, this.zza);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
