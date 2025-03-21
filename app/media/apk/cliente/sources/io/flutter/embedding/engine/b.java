package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f3807b;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f3808a = new HashMap();

    b() {
    }

    public static b b() {
        if (f3807b == null) {
            f3807b = new b();
        }
        return f3807b;
    }

    public a a(String str) {
        return this.f3808a.get(str);
    }

    public void c(String str, a aVar) {
        if (aVar != null) {
            this.f3808a.put(str, aVar);
        } else {
            this.f3808a.remove(str);
        }
    }

    public void d(String str) {
        c(str, null);
    }
}
