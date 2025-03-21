package com.google.android.gms.internal.p001firebaseauthapi;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahb  reason: invalid package */
/* loaded from: classes.dex */
public final class zzahb {
    public static zzaah zza(Exception exc, String str, String str2) {
        String message = exc.getMessage();
        Log.e(str, "Failed to parse " + str + " for string [" + str2 + "] with exception: " + message);
        return new zzaah("Failed to parse " + str + " for string [" + str2 + "]", exc);
    }

    public static List<String> zza(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                arrayList.add(jSONArray.getString(i5));
            }
        }
        return arrayList;
    }

    public static void zza(JSONObject jSONObject) {
        jSONObject.put("clientType", "CLIENT_TYPE_ANDROID");
    }

    public static void zza(JSONObject jSONObject, String str, String str2) {
        jSONObject.put(str, str2);
        jSONObject.put("recaptchaVersion", "RECAPTCHA_ENTERPRISE");
        jSONObject.put("clientType", "CLIENT_TYPE_ANDROID");
    }
}
