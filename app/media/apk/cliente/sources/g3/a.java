package g3;

import android.util.Log;
import com.google.firebase.firestore.z;
import e3.y;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes.dex */
public class a {
    public static Map<String, String> a(Exception exc) {
        HashMap hashMap = new HashMap();
        if (exc == null) {
            return hashMap;
        }
        e3.a aVar = null;
        if (exc instanceof z) {
            aVar = new e3.a((z) exc, exc.getCause());
        } else if (exc.getCause() != null && (exc.getCause() instanceof z)) {
            aVar = new e3.a((z) exc.getCause(), exc.getCause().getCause() != null ? exc.getCause().getCause() : exc.getCause());
        }
        if (aVar != null) {
            hashMap.put("code", aVar.a());
            hashMap.put("message", aVar.getMessage());
        }
        if (hashMap.containsKey("code")) {
            String str = (String) hashMap.get("code");
            Objects.requireNonNull(str);
            if (str.equals("unknown")) {
                Log.e("FLTFirebaseFirestore", "An unknown error occurred", exc);
            }
        }
        return hashMap;
    }

    public static void b(y.w wVar, Exception exc) {
        wVar.b(new y.j("firebase_firestore", exc != null ? exc.getMessage() : null, a(exc)));
    }
}
