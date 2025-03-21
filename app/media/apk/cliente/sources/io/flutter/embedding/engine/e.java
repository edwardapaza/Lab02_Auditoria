package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    private static volatile e f3841b;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, d> f3842a = new HashMap();

    e() {
    }

    public static e b() {
        if (f3841b == null) {
            synchronized (e.class) {
                if (f3841b == null) {
                    f3841b = new e();
                }
            }
        }
        return f3841b;
    }

    public d a(String str) {
        return this.f3842a.get(str);
    }
}
