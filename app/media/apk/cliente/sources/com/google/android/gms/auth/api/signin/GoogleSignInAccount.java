package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import m0.c;
import org.json.JSONArray;
import org.json.JSONObject;
import q0.d;
import q0.f;
/* loaded from: classes.dex */
public class GoogleSignInAccount extends m0.a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a();

    /* renamed from: r  reason: collision with root package name */
    public static d f857r = f.b();

    /* renamed from: a  reason: collision with root package name */
    final int f858a;

    /* renamed from: b  reason: collision with root package name */
    private String f859b;

    /* renamed from: c  reason: collision with root package name */
    private String f860c;

    /* renamed from: d  reason: collision with root package name */
    private String f861d;

    /* renamed from: e  reason: collision with root package name */
    private String f862e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f863f;

    /* renamed from: k  reason: collision with root package name */
    private String f864k;

    /* renamed from: l  reason: collision with root package name */
    private long f865l;

    /* renamed from: m  reason: collision with root package name */
    private String f866m;

    /* renamed from: n  reason: collision with root package name */
    List<Scope> f867n;

    /* renamed from: o  reason: collision with root package name */
    private String f868o;

    /* renamed from: p  reason: collision with root package name */
    private String f869p;

    /* renamed from: q  reason: collision with root package name */
    private Set<Scope> f870q = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInAccount(int i5, String str, String str2, String str3, String str4, Uri uri, String str5, long j5, String str6, List<Scope> list, String str7, String str8) {
        this.f858a = i5;
        this.f859b = str;
        this.f860c = str2;
        this.f861d = str3;
        this.f862e = str4;
        this.f863f = uri;
        this.f864k = str5;
        this.f865l = j5;
        this.f866m = str6;
        this.f867n = list;
        this.f868o = str7;
        this.f869p = str8;
    }

    public static GoogleSignInAccount A(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l5, String str7, Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l5.longValue(), q.e(str7), new ArrayList((Collection) q.k(set)), str5, str6);
    }

    public static GoogleSignInAccount B(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i5 = 0; i5 < length; i5++) {
            hashSet.add(new Scope(jSONArray.getString(i5)));
        }
        GoogleSignInAccount A = A(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        A.f864k = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return A;
    }

    public Uri b() {
        return this.f863f;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoogleSignInAccount) {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
            return googleSignInAccount.f866m.equals(this.f866m) && googleSignInAccount.y().equals(y());
        }
        return false;
    }

    public int hashCode() {
        return ((this.f866m.hashCode() + 527) * 31) + y().hashCode();
    }

    public String n() {
        return this.f861d;
    }

    public String q() {
        return this.f862e;
    }

    public Account t() {
        String str = this.f861d;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    public String u() {
        return this.f869p;
    }

    public String v() {
        return this.f868o;
    }

    public String w() {
        return this.f859b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f858a);
        c.l(parcel, 2, w(), false);
        c.l(parcel, 3, x(), false);
        c.l(parcel, 4, n(), false);
        c.l(parcel, 5, q(), false);
        c.k(parcel, 6, b(), i5, false);
        c.l(parcel, 7, z(), false);
        c.i(parcel, 8, this.f865l);
        c.l(parcel, 9, this.f866m, false);
        c.o(parcel, 10, this.f867n, false);
        c.l(parcel, 11, v(), false);
        c.l(parcel, 12, u(), false);
        c.b(parcel, a5);
    }

    public String x() {
        return this.f860c;
    }

    public Set<Scope> y() {
        HashSet hashSet = new HashSet(this.f867n);
        hashSet.addAll(this.f870q);
        return hashSet;
    }

    public String z() {
        return this.f864k;
    }
}
