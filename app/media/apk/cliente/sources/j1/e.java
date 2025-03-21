package j1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzafb;
import com.google.android.gms.internal.p001firebaseauthapi.zzafr;
import com.google.android.gms.internal.p001firebaseauthapi.zzxv;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e extends m0.a implements com.google.firebase.auth.d1 {
    public static final Parcelable.Creator<e> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private String f5370a;

    /* renamed from: b  reason: collision with root package name */
    private String f5371b;

    /* renamed from: c  reason: collision with root package name */
    private String f5372c;

    /* renamed from: d  reason: collision with root package name */
    private String f5373d;

    /* renamed from: e  reason: collision with root package name */
    private Uri f5374e;

    /* renamed from: f  reason: collision with root package name */
    private String f5375f;

    /* renamed from: k  reason: collision with root package name */
    private String f5376k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5377l;

    /* renamed from: m  reason: collision with root package name */
    private String f5378m;

    public e(zzafb zzafbVar, String str) {
        com.google.android.gms.common.internal.q.k(zzafbVar);
        com.google.android.gms.common.internal.q.e(str);
        this.f5370a = com.google.android.gms.common.internal.q.e(zzafbVar.zzi());
        this.f5371b = str;
        this.f5375f = zzafbVar.zzh();
        this.f5372c = zzafbVar.zzg();
        Uri zzc = zzafbVar.zzc();
        if (zzc != null) {
            this.f5373d = zzc.toString();
            this.f5374e = zzc;
        }
        this.f5377l = zzafbVar.zzm();
        this.f5378m = null;
        this.f5376k = zzafbVar.zzj();
    }

    public e(zzafr zzafrVar) {
        com.google.android.gms.common.internal.q.k(zzafrVar);
        this.f5370a = zzafrVar.zzd();
        this.f5371b = com.google.android.gms.common.internal.q.e(zzafrVar.zzf());
        this.f5372c = zzafrVar.zzb();
        Uri zza = zzafrVar.zza();
        if (zza != null) {
            this.f5373d = zza.toString();
            this.f5374e = zza;
        }
        this.f5375f = zzafrVar.zzc();
        this.f5376k = zzafrVar.zze();
        this.f5377l = false;
        this.f5378m = zzafrVar.zzg();
    }

    public e(String str, String str2, String str3, String str4, String str5, String str6, boolean z4, String str7) {
        this.f5370a = str;
        this.f5371b = str2;
        this.f5375f = str3;
        this.f5376k = str4;
        this.f5372c = str5;
        this.f5373d = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.f5374e = Uri.parse(this.f5373d);
        }
        this.f5377l = z4;
        this.f5378m = str7;
    }

    public static e t(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new e(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e5) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzxv(e5);
        }
    }

    @Override // com.google.firebase.auth.d1
    public final String a() {
        return this.f5370a;
    }

    @Override // com.google.firebase.auth.d1
    public final Uri b() {
        if (!TextUtils.isEmpty(this.f5373d) && this.f5374e == null) {
            this.f5374e = Uri.parse(this.f5373d);
        }
        return this.f5374e;
    }

    @Override // com.google.firebase.auth.d1
    public final String c() {
        return this.f5371b;
    }

    @Override // com.google.firebase.auth.d1
    public final boolean f() {
        return this.f5377l;
    }

    @Override // com.google.firebase.auth.d1
    public final String j() {
        return this.f5376k;
    }

    @Override // com.google.firebase.auth.d1
    public final String n() {
        return this.f5375f;
    }

    @Override // com.google.firebase.auth.d1
    public final String q() {
        return this.f5372c;
    }

    public final String u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.f5370a);
            jSONObject.putOpt("providerId", this.f5371b);
            jSONObject.putOpt("displayName", this.f5372c);
            jSONObject.putOpt("photoUrl", this.f5373d);
            jSONObject.putOpt("email", this.f5375f);
            jSONObject.putOpt("phoneNumber", this.f5376k);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.f5377l));
            jSONObject.putOpt("rawUserInfo", this.f5378m);
            return jSONObject.toString();
        } catch (JSONException e5) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzxv(e5);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, a(), false);
        m0.c.l(parcel, 2, c(), false);
        m0.c.l(parcel, 3, q(), false);
        m0.c.l(parcel, 4, this.f5373d, false);
        m0.c.l(parcel, 5, n(), false);
        m0.c.l(parcel, 6, j(), false);
        m0.c.c(parcel, 7, f());
        m0.c.l(parcel, 8, this.f5378m, false);
        m0.c.b(parcel, a5);
    }

    public final String zza() {
        return this.f5378m;
    }
}
