package j1;

import com.google.android.gms.internal.p001firebaseauthapi.zzxv;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    private static final o0.a f5439a = new o0.a("GetTokenResultFactory", new String[0]);

    public static com.google.firebase.auth.c0 a(String str) {
        Map hashMap;
        try {
            hashMap = k0.b(str);
        } catch (zzxv e5) {
            f5439a.b("Error parsing token claims", e5, new Object[0]);
            hashMap = new HashMap();
        }
        return new com.google.firebase.auth.c0(str, hashMap);
    }
}
