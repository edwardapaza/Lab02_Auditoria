package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagb  reason: invalid package */
/* loaded from: classes.dex */
public final class zzagb implements zzacr {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzj;
    private boolean zzh = true;
    private zzagn zzg = new zzagn();
    private zzagn zzi = new zzagn();

    public final zzagb zza(String str) {
        q.e(str);
        this.zzi.zzb().add(str);
        return this;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("returnSecureToken", this.zzh);
        if (!this.zzi.zzb().isEmpty()) {
            List<String> zzb = this.zzi.zzb();
            JSONArray jSONArray = new JSONArray();
            for (int i5 = 0; i5 < zzb.size(); i5++) {
                jSONArray.put(zzb.get(i5));
            }
            jSONObject.put("deleteProvider", jSONArray);
        }
        List<String> zzb2 = this.zzg.zzb();
        int size = zzb2.size();
        int[] iArr = new int[size];
        for (int i6 = 0; i6 < zzb2.size(); i6++) {
            String str = zzb2.get(i6);
            str.hashCode();
            char c5 = 65535;
            int i7 = 2;
            switch (str.hashCode()) {
                case -333046776:
                    if (str.equals("DISPLAY_NAME")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 66081660:
                    if (str.equals("EMAIL")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 1939891618:
                    if (str.equals("PHOTO_URL")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 1999612571:
                    if (str.equals("PASSWORD")) {
                        c5 = 3;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    break;
                case 1:
                    i7 = 1;
                    break;
                case 2:
                    i7 = 4;
                    break;
                case 3:
                    i7 = 5;
                    break;
                default:
                    i7 = 0;
                    break;
            }
            iArr[i6] = i7;
        }
        if (size > 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i8 = 0; i8 < size; i8++) {
                jSONArray2.put(iArr[i8]);
            }
            jSONObject.put("deleteAttribute", jSONArray2);
        }
        String str2 = this.zza;
        if (str2 != null) {
            jSONObject.put("idToken", str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("email", str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            jSONObject.put("password", str4);
        }
        String str5 = this.zzb;
        if (str5 != null) {
            jSONObject.put("displayName", str5);
        }
        String str6 = this.zzf;
        if (str6 != null) {
            jSONObject.put("photoUrl", str6);
        }
        String str7 = this.zze;
        if (str7 != null) {
            jSONObject.put("oobCode", str7);
        }
        String str8 = this.zzj;
        if (str8 != null) {
            jSONObject.put("tenantId", str8);
        }
        return jSONObject.toString();
    }

    public final zzagb zzb(String str) {
        if (str == null) {
            this.zzg.zzb().add("DISPLAY_NAME");
        } else {
            this.zzb = str;
        }
        return this;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final zzagb zzc(String str) {
        if (str == null) {
            this.zzg.zzb().add("EMAIL");
        } else {
            this.zzc = str;
        }
        return this;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final zzagb zzd(String str) {
        this.zza = q.e(str);
        return this;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final zzagb zze(String str) {
        this.zze = q.e(str);
        return this;
    }

    public final String zze() {
        return this.zzf;
    }

    public final zzagb zzf(String str) {
        if (str == null) {
            this.zzg.zzb().add("PASSWORD");
        } else {
            this.zzd = str;
        }
        return this;
    }

    public final zzagb zzg(String str) {
        if (str == null) {
            this.zzg.zzb().add("PHOTO_URL");
        } else {
            this.zzf = str;
        }
        return this;
    }

    public final zzagb zzh(String str) {
        this.zzj = str;
        return this;
    }

    public final boolean zzi(String str) {
        q.e(str);
        return this.zzg.zzb().contains(str);
    }
}
