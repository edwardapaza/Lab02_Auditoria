package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Base64;
import com.google.firebase.auth.o0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o0.a;
import s0.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadt  reason: invalid package */
/* loaded from: classes.dex */
public final class zzadt {
    private static final a zza = new a("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private final HashMap<String, zzaea> zzd = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadt(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzb = context;
        this.zzc = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(String str) {
        Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    private static String zza(String str, String str2) {
        String str3 = str + " " + str2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str3.getBytes(zzq.zza));
            String substring = Base64.encodeToString(Arrays.copyOf(messageDigest.digest(), 9), 3).substring(0, 11);
            zza.a("Package: " + str + " -- Hash: " + substring, new Object[0]);
            return substring;
        } catch (NoSuchAlgorithmException e5) {
            zza.c("NoSuchAlgorithm: " + e5.getMessage(), new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzadt zzadtVar, String str) {
        zzaea zzaeaVar = zzadtVar.zzd.get(str);
        if (zzaeaVar == null || zzah.zzc(zzaeaVar.zzd) || zzah.zzc(zzaeaVar.zze) || zzaeaVar.zzb.isEmpty()) {
            return;
        }
        for (zzacf zzacfVar : zzaeaVar.zzb) {
            zzacfVar.zza(o0.x(zzaeaVar.zzd, zzaeaVar.zze));
        }
        zzaeaVar.zzh = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(String str) {
        zzaea zzaeaVar = this.zzd.get(str);
        if (zzaeaVar == null || zzaeaVar.zzh || zzah.zzc(zzaeaVar.zzd)) {
            return;
        }
        zza.h("Timed out waiting for SMS.", new Object[0]);
        for (zzacf zzacfVar : zzaeaVar.zzb) {
            zzacfVar.zza(zzaeaVar.zzd);
        }
        zzaeaVar.zzi = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzf */
    public final void zzb(String str) {
        zzaea zzaeaVar = this.zzd.get(str);
        if (zzaeaVar == null) {
            return;
        }
        if (!zzaeaVar.zzi) {
            zze(str);
        }
        zzc(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzacf zza(zzacf zzacfVar, String str) {
        return new zzady(this, zzacfVar, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(final String str, zzacf zzacfVar, long j5, boolean z4) {
        this.zzd.put(str, new zzaea(j5, z4));
        zzb(zzacfVar, str);
        zzaea zzaeaVar = this.zzd.get(str);
        if (zzaeaVar.zza <= 0) {
            zza.h("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzaeaVar.zzf = this.zzc.schedule(new Runnable() { // from class: com.google.android.gms.internal.firebase-auth-api.zzadw
            @Override // java.lang.Runnable
            public final void run() {
                zzadt.this.zzb(str);
            }
        }, zzaeaVar.zza, TimeUnit.SECONDS);
        if (!zzaeaVar.zzc) {
            zza.h("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzadx zzadxVar = new zzadx(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.gms.auth.api.phone.SMS_RETRIEVED");
        zzc.zza(this.zzb.getApplicationContext(), zzadxVar, intentFilter);
        i0.a.a(this.zzb).startSmsRetriever().addOnFailureListener(new zzadv(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        try {
            String packageName = this.zzb.getPackageName();
            String zza2 = zza(packageName, (Build.VERSION.SDK_INT < 28 ? d.a(this.zzb).c(packageName, 64).signatures : d.a(this.zzb).c(packageName, 134217728).signingInfo.getApkContentsSigners())[0].toCharsString());
            if (zza2 != null) {
                return zza2;
            }
            zza.c("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zza.c("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzacf zzacfVar, String str) {
        zzaea zzaeaVar = this.zzd.get(str);
        if (zzaeaVar == null) {
            return;
        }
        zzaeaVar.zzb.add(zzacfVar);
        if (zzaeaVar.zzg) {
            zzacfVar.zzb(zzaeaVar.zzd);
        }
        if (zzaeaVar.zzh) {
            zzacfVar.zza(o0.x(zzaeaVar.zzd, zzaeaVar.zze));
        }
        if (zzaeaVar.zzi) {
            zzacfVar.zza(zzaeaVar.zzd);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(String str) {
        zzaea zzaeaVar = this.zzd.get(str);
        if (zzaeaVar == null) {
            return;
        }
        ScheduledFuture<?> scheduledFuture = zzaeaVar.zzf;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            zzaeaVar.zzf.cancel(false);
        }
        zzaeaVar.zzb.clear();
        this.zzd.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd(String str) {
        return this.zzd.get(str) != null;
    }
}
