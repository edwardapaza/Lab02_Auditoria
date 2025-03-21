package y2;

import android.view.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import y2.e;
import z2.a;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final z2.a<Object> f8608a;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z4);
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final KeyEvent f8609a;

        /* renamed from: b  reason: collision with root package name */
        public final Character f8610b;

        public b(KeyEvent keyEvent, Character ch) {
            this.f8609a = keyEvent;
            this.f8610b = ch;
        }
    }

    public e(z2.b bVar) {
        this.f8608a = new z2.a<>(bVar, "flutter/keyevent", z2.e.f9001a);
    }

    private static a.e<Object> b(final a aVar) {
        return new a.e() { // from class: y2.d
            @Override // z2.a.e
            public final void a(Object obj) {
                e.d(e.a.this, obj);
            }
        };
    }

    private Map<String, Object> c(b bVar, boolean z4) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", z4 ? "keyup" : "keydown");
        hashMap.put("keymap", "android");
        hashMap.put("flags", Integer.valueOf(bVar.f8609a.getFlags()));
        hashMap.put("plainCodePoint", Integer.valueOf(bVar.f8609a.getUnicodeChar(0)));
        hashMap.put("codePoint", Integer.valueOf(bVar.f8609a.getUnicodeChar()));
        hashMap.put("keyCode", Integer.valueOf(bVar.f8609a.getKeyCode()));
        hashMap.put("scanCode", Integer.valueOf(bVar.f8609a.getScanCode()));
        hashMap.put("metaState", Integer.valueOf(bVar.f8609a.getMetaState()));
        Character ch = bVar.f8610b;
        if (ch != null) {
            hashMap.put("character", ch.toString());
        }
        hashMap.put("source", Integer.valueOf(bVar.f8609a.getSource()));
        hashMap.put("deviceId", Integer.valueOf(bVar.f8609a.getDeviceId()));
        hashMap.put("repeatCount", Integer.valueOf(bVar.f8609a.getRepeatCount()));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(a aVar, Object obj) {
        boolean z4 = false;
        if (obj != null) {
            try {
                z4 = ((JSONObject) obj).getBoolean("handled");
            } catch (JSONException e5) {
                n2.b.b("KeyEventChannel", "Unable to unpack JSON message: " + e5);
            }
        }
        aVar.a(z4);
    }

    public void e(b bVar, boolean z4, a aVar) {
        this.f8608a.d(c(bVar, z4), b(aVar));
    }
}
