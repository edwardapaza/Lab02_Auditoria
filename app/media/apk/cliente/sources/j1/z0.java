package j1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.internal.p001firebaseauthapi.zzafm;
import com.google.android.gms.internal.p001firebaseauthapi.zzxv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: a  reason: collision with root package name */
    private Context f5509a;

    /* renamed from: b  reason: collision with root package name */
    private String f5510b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f5511c;

    /* renamed from: d  reason: collision with root package name */
    private o0.a f5512d;

    public z0(Context context, String str) {
        com.google.android.gms.common.internal.q.k(context);
        this.f5510b = com.google.android.gms.common.internal.q.e(str);
        this.f5509a = context.getApplicationContext();
        this.f5511c = this.f5509a.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", this.f5510b), 0);
        this.f5512d = new o0.a("StorageHelpers", new String[0]);
    }

    private final i c(JSONObject jSONObject) {
        JSONArray jSONArray;
        k a5;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z4 = jSONObject.getBoolean("anonymous");
            String string3 = jSONObject.getString("version");
            String str = string3 != null ? string3 : "2";
            JSONArray jSONArray2 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray2.length();
            if (length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i5 = 0; i5 < length; i5++) {
                arrayList.add(e.t(jSONArray2.getString(i5)));
            }
            i iVar = new i(f1.f.p(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                iVar.Q(zzafm.zzb(string));
            }
            if (!z4) {
                iVar.R();
            }
            iVar.V(str);
            if (jSONObject.has("userMetadata") && (a5 = k.a(jSONObject.getJSONObject("userMetadata"))) != null) {
                iVar.X(a5);
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i6));
                    String optString = jSONObject2.optString("factorIdKey");
                    arrayList2.add("phone".equals(optString) ? com.google.firebase.auth.t0.w(jSONObject2) : Objects.equals(optString, "totp") ? com.google.firebase.auth.z0.w(jSONObject2) : null);
                }
                iVar.S(arrayList2);
            }
            return iVar;
        } catch (zzxv | ArrayIndexOutOfBoundsException | IllegalArgumentException | JSONException e5) {
            this.f5512d.j(e5);
            return null;
        }
    }

    private final String g(com.google.firebase.auth.a0 a0Var) {
        JSONObject jSONObject = new JSONObject();
        if (i.class.isAssignableFrom(a0Var.getClass())) {
            i iVar = (i) a0Var;
            try {
                jSONObject.put("cachedTokenState", iVar.zze());
                jSONObject.put("applicationName", iVar.P().q());
                jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
                if (iVar.c0() != null) {
                    JSONArray jSONArray = new JSONArray();
                    List<e> c02 = iVar.c0();
                    int size = c02.size();
                    if (c02.size() > 30) {
                        this.f5512d.h("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(c02.size()));
                        size = 30;
                    }
                    boolean z4 = false;
                    for (int i5 = 0; i5 < size; i5++) {
                        e eVar = c02.get(i5);
                        if (eVar.c().equals("firebase")) {
                            z4 = true;
                        }
                        if (i5 == size - 1 && !z4) {
                            break;
                        }
                        jSONArray.put(eVar.u());
                    }
                    if (!z4) {
                        int i6 = size - 1;
                        while (true) {
                            if (i6 >= c02.size() || i6 < 0) {
                                break;
                            }
                            e eVar2 = c02.get(i6);
                            if (eVar2.c().equals("firebase")) {
                                jSONArray.put(eVar2.u());
                                z4 = true;
                                break;
                            }
                            if (i6 == c02.size() - 1) {
                                jSONArray.put(eVar2.u());
                            }
                            i6++;
                        }
                        if (!z4) {
                            this.f5512d.h("Malformed user object! No Firebase Auth provider id found. Provider user info list size: %d, trimmed size: %d", Integer.valueOf(c02.size()), Integer.valueOf(size));
                            if (c02.size() < 5) {
                                StringBuilder sb = new StringBuilder("Provider user info list:\n");
                                Iterator<e> it = c02.iterator();
                                while (it.hasNext()) {
                                    sb.append(String.format("Provider - %s\n", it.next().c()));
                                }
                                this.f5512d.h(sb.toString(), new Object[0]);
                            }
                        }
                    }
                    jSONObject.put("userInfos", jSONArray);
                }
                jSONObject.put("anonymous", iVar.z());
                jSONObject.put("version", "2");
                if (iVar.v() != null) {
                    jSONObject.put("userMetadata", ((k) iVar.v()).b());
                }
                List<com.google.firebase.auth.j0> b5 = ((m) iVar.w()).b();
                if (b5 != null && !b5.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i7 = 0; i7 < b5.size(); i7++) {
                        jSONArray2.put(b5.get(i7).v());
                    }
                    jSONObject.put("userMultiFactorInfo", jSONArray2);
                }
                return jSONObject.toString();
            } catch (Exception e5) {
                this.f5512d.i("Failed to turn object into JSON", e5, new Object[0]);
                throw new zzxv(e5);
            }
        }
        return null;
    }

    public final zzafm a(com.google.firebase.auth.a0 a0Var) {
        com.google.android.gms.common.internal.q.k(a0Var);
        String string = this.f5511c.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", a0Var.a()), null);
        if (string != null) {
            return zzafm.zzb(string);
        }
        return null;
    }

    public final com.google.firebase.auth.a0 b() {
        String string = this.f5511c.getString("com.google.firebase.auth.FIREBASE_USER", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return c(jSONObject);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final void d(com.google.firebase.auth.a0 a0Var, zzafm zzafmVar) {
        com.google.android.gms.common.internal.q.k(a0Var);
        com.google.android.gms.common.internal.q.k(zzafmVar);
        this.f5511c.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", a0Var.a()), zzafmVar.zzf()).apply();
    }

    public final void e(String str) {
        this.f5511c.edit().remove(str).apply();
    }

    public final void f(com.google.firebase.auth.a0 a0Var) {
        com.google.android.gms.common.internal.q.k(a0Var);
        String g5 = g(a0Var);
        if (TextUtils.isEmpty(g5)) {
            return;
        }
        this.f5511c.edit().putString("com.google.firebase.auth.FIREBASE_USER", g5).apply();
    }
}
