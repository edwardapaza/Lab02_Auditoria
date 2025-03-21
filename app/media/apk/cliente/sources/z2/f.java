package z2;

import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f implements k {

    /* renamed from: a  reason: collision with root package name */
    public static final f f9002a = new f();

    private f() {
    }

    @Override // z2.k
    public ByteBuffer a(Object obj) {
        return e.f9001a.a(new JSONArray().put(g.a(obj)));
    }

    @Override // z2.k
    public ByteBuffer b(String str, String str2, Object obj, String str3) {
        return e.f9001a.a(new JSONArray().put(str).put(g.a(str2)).put(g.a(obj)).put(g.a(str3)));
    }

    @Override // z2.k
    public ByteBuffer c(String str, String str2, Object obj) {
        return e.f9001a.a(new JSONArray().put(str).put(g.a(str2)).put(g.a(obj)));
    }

    @Override // z2.k
    public ByteBuffer d(i iVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", iVar.f9003a);
            jSONObject.put("args", g.a(iVar.f9004b));
            return e.f9001a.a(jSONObject);
        } catch (JSONException e5) {
            throw new IllegalArgumentException("Invalid JSON", e5);
        }
    }

    @Override // z2.k
    public i e(ByteBuffer byteBuffer) {
        try {
            Object b5 = e.f9001a.b(byteBuffer);
            if (b5 instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) b5;
                Object obj = jSONObject.get("method");
                Object g5 = g(jSONObject.opt("args"));
                if (obj instanceof String) {
                    return new i((String) obj, g5);
                }
            }
            throw new IllegalArgumentException("Invalid method call: " + b5);
        } catch (JSONException e5) {
            throw new IllegalArgumentException("Invalid JSON", e5);
        }
    }

    @Override // z2.k
    public Object f(ByteBuffer byteBuffer) {
        try {
            Object b5 = e.f9001a.b(byteBuffer);
            if (b5 instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) b5;
                if (jSONArray.length() == 1) {
                    return g(jSONArray.opt(0));
                }
                if (jSONArray.length() == 3) {
                    Object obj = jSONArray.get(0);
                    Object g5 = g(jSONArray.opt(1));
                    Object g6 = g(jSONArray.opt(2));
                    if ((obj instanceof String) && (g5 == null || (g5 instanceof String))) {
                        throw new d((String) obj, (String) g5, g6);
                    }
                }
            }
            throw new IllegalArgumentException("Invalid envelope: " + b5);
        } catch (JSONException e5) {
            throw new IllegalArgumentException("Invalid JSON", e5);
        }
    }

    Object g(Object obj) {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj;
    }
}
