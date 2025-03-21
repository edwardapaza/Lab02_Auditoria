package com.google.android.gms.internal.p001firebaseauthapi;

import android.util.Log;
import java.text.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzago  reason: invalid package */
/* loaded from: classes.dex */
public final class zzago extends zzagi {
    private static final String zza = "zzago";
    private String zzb;
    private String zzc;
    private int zzd;
    private String zze;
    private int zzf;
    private long zzg;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzagi
    /* renamed from: zzc */
    public final zzago zzb(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("totpSessionInfo");
            if (optJSONObject != null) {
                this.zzc = zzah.zza(optJSONObject.optString("sharedSecretKey"));
                this.zzd = optJSONObject.optInt("verificationCodeLength");
                this.zze = zzah.zza(optJSONObject.optString("hashingAlgorithm"));
                this.zzf = optJSONObject.optInt("periodSec");
                this.zzb = zzah.zza(optJSONObject.optString("sessionInfo"));
                String optString = optJSONObject.optString("finalizeEnrollmentTime");
                try {
                    this.zzg = zzand.zza(zzand.zza(optString));
                } catch (ParseException unused) {
                    String str2 = zza;
                    Log.e(str2, "Failed to parse timestamp: " + optString);
                }
            }
            return this;
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzagi, com.google.android.gms.internal.p001firebaseauthapi.zzacq
    public final /* synthetic */ zzagi zza(String str) {
        return (zzago) zza(str);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzagi
    public final String zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzf;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzc;
    }
}
