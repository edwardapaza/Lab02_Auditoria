package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import j1.w1;
import m0.a;
import m0.c;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzags  reason: invalid package */
/* loaded from: classes.dex */
public final class zzags extends a implements zzacr {
    public static final Parcelable.Creator<zzags> CREATOR = new zzagr();
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private boolean zzi;
    private boolean zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private String zzn;
    private boolean zzo;
    private String zzp;

    public zzags() {
        this.zzi = true;
        this.zzj = true;
    }

    public zzags(w1 w1Var, String str) {
        q.k(w1Var);
        this.zzl = q.e(w1Var.d());
        this.zzm = q.e(str);
        this.zze = q.e(w1Var.c());
        this.zzi = true;
        this.zzg = "providerId=" + this.zze;
    }

    public zzags(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.zza = "http://localhost";
        this.zzc = str;
        this.zzd = str2;
        this.zzh = str5;
        this.zzk = str6;
        this.zzn = str7;
        this.zzp = str8;
        this.zzi = true;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(this.zzd) && TextUtils.isEmpty(this.zzk)) {
            throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
        }
        this.zze = q.e(str3);
        this.zzf = null;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.zzc)) {
            sb.append("id_token=");
            sb.append(this.zzc);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            sb.append("access_token=");
            sb.append(this.zzd);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzf)) {
            sb.append("identifier=");
            sb.append(this.zzf);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            sb.append("oauth_token_secret=");
            sb.append(this.zzh);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzk)) {
            sb.append("code=");
            sb.append(this.zzk);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(str9)) {
            sb.append("nonce=");
            sb.append(str9);
            sb.append("&");
        }
        sb.append("providerId=");
        sb.append(this.zze);
        this.zzg = sb.toString();
        this.zzj = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzags(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z4, boolean z5, String str9, String str10, String str11, String str12, boolean z6, String str13) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = z4;
        this.zzj = z5;
        this.zzk = str9;
        this.zzl = str10;
        this.zzm = str11;
        this.zzn = str12;
        this.zzo = z6;
        this.zzp = str13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.l(parcel, 2, this.zza, false);
        c.l(parcel, 3, this.zzb, false);
        c.l(parcel, 4, this.zzc, false);
        c.l(parcel, 5, this.zzd, false);
        c.l(parcel, 6, this.zze, false);
        c.l(parcel, 7, this.zzf, false);
        c.l(parcel, 8, this.zzg, false);
        c.l(parcel, 9, this.zzh, false);
        c.c(parcel, 10, this.zzi);
        c.c(parcel, 11, this.zzj);
        c.l(parcel, 12, this.zzk, false);
        c.l(parcel, 13, this.zzl, false);
        c.l(parcel, 14, this.zzm, false);
        c.l(parcel, 15, this.zzn, false);
        c.c(parcel, 16, this.zzo);
        c.l(parcel, 17, this.zzp, false);
        c.b(parcel, a5);
    }

    public final zzags zza(String str) {
        this.zzb = q.e(str);
        return this;
    }

    public final zzags zza(boolean z4) {
        this.zzj = false;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
        if (r1 != null) goto L19;
     */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zza() {
        /*
            r3 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            boolean r1 = r3.zzj
            java.lang.String r2 = "autoCreate"
            r0.put(r2, r1)
            boolean r1 = r3.zzi
            java.lang.String r2 = "returnSecureToken"
            r0.put(r2, r1)
            java.lang.String r1 = r3.zzb
            if (r1 == 0) goto L1c
            java.lang.String r2 = "idToken"
            r0.put(r2, r1)
        L1c:
            java.lang.String r1 = r3.zzg
            if (r1 == 0) goto L25
            java.lang.String r2 = "postBody"
            r0.put(r2, r1)
        L25:
            java.lang.String r1 = r3.zzn
            if (r1 == 0) goto L2e
            java.lang.String r2 = "tenantId"
            r0.put(r2, r1)
        L2e:
            java.lang.String r1 = r3.zzp
            if (r1 == 0) goto L37
            java.lang.String r2 = "pendingToken"
            r0.put(r2, r1)
        L37:
            java.lang.String r1 = r3.zzl
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L46
            java.lang.String r1 = r3.zzl
            java.lang.String r2 = "sessionId"
            r0.put(r2, r1)
        L46:
            java.lang.String r1 = r3.zzm
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r2 = "requestUri"
            if (r1 != 0) goto L56
            java.lang.String r1 = r3.zzm
        L52:
            r0.put(r2, r1)
            goto L5b
        L56:
            java.lang.String r1 = r3.zza
            if (r1 == 0) goto L5b
            goto L52
        L5b:
            boolean r1 = r3.zzo
            java.lang.String r2 = "returnIdpCredential"
            r0.put(r2, r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzags.zza():java.lang.String");
    }

    public final zzags zzb(String str) {
        this.zzn = str;
        return this;
    }

    public final zzags zzb(boolean z4) {
        this.zzo = true;
        return this;
    }

    public final zzags zzc(boolean z4) {
        this.zzi = true;
        return this;
    }
}
