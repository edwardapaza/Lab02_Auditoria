package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.a;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzc  reason: invalid package */
/* loaded from: classes.dex */
public final class zzc extends a {
    @Deprecated
    public static Intent zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        Intent registerReceiver;
        if (zza.zza()) {
            registerReceiver = context.registerReceiver(broadcastReceiver, intentFilter, zza.zza() ? 2 : 0);
            return registerReceiver;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }
}
