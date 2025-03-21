package z2;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes.dex */
public final class e implements h<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final e f9001a = new e();

    private e() {
    }

    @Override // z2.h
    public ByteBuffer a(Object obj) {
        r rVar;
        String obj2;
        if (obj == null) {
            return null;
        }
        Object a5 = g.a(obj);
        if (a5 instanceof String) {
            rVar = r.f9021b;
            obj2 = JSONObject.quote((String) a5);
        } else {
            rVar = r.f9021b;
            obj2 = a5.toString();
        }
        return rVar.a(obj2);
    }

    @Override // z2.h
    public Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            JSONTokener jSONTokener = new JSONTokener(r.f9021b.b(byteBuffer));
            Object nextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                throw new IllegalArgumentException("Invalid JSON");
            }
            return nextValue;
        } catch (JSONException e5) {
            throw new IllegalArgumentException("Invalid JSON", e5);
        }
    }
}
