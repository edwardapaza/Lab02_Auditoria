package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.firebase.auth.e;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafd  reason: invalid package */
/* loaded from: classes.dex */
public final class zzafd implements zzacr {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private e zze;
    private String zzf;
    private String zzg;

    public zzafd(int i5) {
        this.zza = zza(i5);
    }

    private zzafd(int i5, e eVar, String str, String str2, String str3, String str4, String str5) {
        this.zza = zza(7);
        this.zze = (e) q.k(eVar);
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
        this.zzg = null;
    }

    public static zzafd zza(e eVar, String str, String str2) {
        q.e(str);
        q.e(str2);
        q.k(eVar);
        return new zzafd(7, eVar, null, str2, str, null, null);
    }

    private static String zza(int i5) {
        return i5 != 1 ? i5 != 4 ? i5 != 6 ? i5 != 7 ? "REQUEST_TYPE_UNSET_ENUM_VALUE" : "VERIFY_AND_CHANGE_EMAIL" : "EMAIL_SIGNIN" : "VERIFY_EMAIL" : "PASSWORD_RESET";
    }

    public final zzafd zza(e eVar) {
        this.zze = (e) q.k(eVar);
        return this;
    }

    public final zzafd zza(String str) {
        this.zzg = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        str.hashCode();
        int i5 = 1;
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1452371317:
                if (str.equals("PASSWORD_RESET")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1341836234:
                if (str.equals("VERIFY_EMAIL")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1099157829:
                if (str.equals("VERIFY_AND_CHANGE_EMAIL")) {
                    c5 = 2;
                    break;
                }
                break;
            case 870738373:
                if (str.equals("EMAIL_SIGNIN")) {
                    c5 = 3;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                break;
            case 1:
                i5 = 4;
                break;
            case 2:
                i5 = 7;
                break;
            case 3:
                i5 = 6;
                break;
            default:
                i5 = 0;
                break;
        }
        jSONObject.put("requestType", i5);
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put("email", str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("newEmail", str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            jSONObject.put("idToken", str4);
        }
        e eVar = this.zze;
        if (eVar != null) {
            jSONObject.put("androidInstallApp", eVar.u());
            jSONObject.put("canHandleCodeInApp", this.zze.t());
            if (this.zze.y() != null) {
                jSONObject.put("continueUrl", this.zze.y());
            }
            if (this.zze.x() != null) {
                jSONObject.put("iosBundleId", this.zze.x());
            }
            if (this.zze.zzd() != null) {
                jSONObject.put("iosAppStoreId", this.zze.zzd());
            }
            if (this.zze.w() != null) {
                jSONObject.put("androidPackageName", this.zze.w());
            }
            if (this.zze.v() != null) {
                jSONObject.put("androidMinimumVersion", this.zze.v());
            }
            if (this.zze.zzc() != null) {
                jSONObject.put("dynamicLinkDomain", this.zze.zzc());
            }
        }
        String str5 = this.zzf;
        if (str5 != null) {
            jSONObject.put("tenantId", str5);
        }
        String str6 = this.zzg;
        if (str6 != null) {
            zzahb.zza(jSONObject, "captchaResp", str6);
        } else {
            zzahb.zza(jSONObject);
        }
        return jSONObject.toString();
    }

    public final zzafd zzb(String str) {
        this.zzb = q.e(str);
        return this;
    }

    public final e zzb() {
        return this.zze;
    }

    public final zzafd zzc(String str) {
        this.zzf = str;
        return this;
    }

    public final zzafd zzd(String str) {
        this.zzd = q.e(str);
        return this;
    }
}
