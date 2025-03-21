package j1;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzac;
import com.google.android.gms.internal.p001firebaseauthapi.zzxv;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class k0 {

    /* renamed from: a  reason: collision with root package name */
    private static final o0.a f5436a = new o0.a("JSONParser", new String[0]);

    private static List<Object> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            Object obj = jSONArray.get(i5);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = c((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static Map<String, Object> b(String str) {
        com.google.android.gms.common.internal.q.e(str);
        List<String> zza = zzac.zza('.').zza((CharSequence) str);
        if (zza.size() < 2) {
            o0.a aVar = f5436a;
            aVar.c("Invalid idToken " + str, new Object[0]);
            return new HashMap();
        }
        try {
            Map<String, Object> d5 = d(new String(q0.c.b(zza.get(1)), "UTF-8"));
            return d5 == null ? new HashMap() : d5;
        } catch (UnsupportedEncodingException e5) {
            f5436a.b("Unable to decode token", e5, new Object[0]);
            return new HashMap();
        }
    }

    private static Map<String, Object> c(JSONObject jSONObject) {
        androidx.collection.a aVar = new androidx.collection.a();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = c((JSONObject) obj);
            }
            aVar.put(next, obj);
        }
        return aVar;
    }

    public static Map<String, Object> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return c(jSONObject);
            }
            return null;
        } catch (Exception e5) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new zzxv(e5);
        }
    }
}
