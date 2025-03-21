package com.google.firebase.auth;

import android.net.Uri;
import com.google.android.gms.internal.p001firebaseauthapi.zzau;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes.dex */
public class f {

    /* renamed from: g  reason: collision with root package name */
    private static final zzau<String, Integer> f1448g;

    /* renamed from: a  reason: collision with root package name */
    private final String f1449a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1450b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1451c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1452d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1453e;

    /* renamed from: f  reason: collision with root package name */
    private final String f1454f;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("recoverEmail", 2);
        hashMap.put("resetPassword", 0);
        hashMap.put("signIn", 4);
        hashMap.put("verifyEmail", 1);
        hashMap.put("verifyBeforeChangeEmail", 5);
        hashMap.put("revertSecondFactorAddition", 6);
        f1448g = zzau.zza(hashMap);
    }

    private f(String str) {
        String e5 = e(str, "apiKey");
        String e6 = e(str, "oobCode");
        String e7 = e(str, "mode");
        if (e5 == null || e6 == null || e7 == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", "apiKey", "oobCode", "mode"));
        }
        this.f1449a = com.google.android.gms.common.internal.q.e(e5);
        this.f1450b = com.google.android.gms.common.internal.q.e(e6);
        this.f1451c = com.google.android.gms.common.internal.q.e(e7);
        this.f1452d = e(str, "continueUrl");
        this.f1453e = e(str, "languageCode");
        this.f1454f = e(str, "tenantId");
    }

    public static f c(String str) {
        com.google.android.gms.common.internal.q.e(str);
        try {
            return new f(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static String e(String str, String str2) {
        Uri parse = Uri.parse(str);
        try {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return parse.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(com.google.android.gms.common.internal.q.e(parse.getQueryParameter("link"))).getQueryParameter(str2);
            }
            return null;
        } catch (NullPointerException | UnsupportedOperationException unused) {
            return null;
        }
    }

    public String a() {
        return this.f1450b;
    }

    public int b() {
        zzau<String, Integer> zzauVar = f1448g;
        if (zzauVar.containsKey(this.f1451c)) {
            return zzauVar.get(this.f1451c).intValue();
        }
        return 3;
    }

    public final String d() {
        return this.f1454f;
    }
}
