package y2;

import java.util.HashMap;
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public final z2.a<Object> f8763a;

    public r(o2.a aVar) {
        this.f8763a = new z2.a<>(aVar, "flutter/system", z2.e.f9001a);
    }

    public void a() {
        n2.b.f("SystemChannel", "Sending memory pressure warning to Flutter.");
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "memoryPressure");
        this.f8763a.c(hashMap);
    }
}
