package y2;

import java.util.HashMap;
import z2.j;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final z2.j f8635a;

    /* renamed from: b  reason: collision with root package name */
    private final j.c f8636b;

    /* loaded from: classes.dex */
    class a implements j.c {
        a() {
        }

        @Override // z2.j.c
        public void a(z2.i iVar, j.d dVar) {
            dVar.a(null);
        }
    }

    public j(o2.a aVar) {
        a aVar2 = new a();
        this.f8636b = aVar2;
        z2.j jVar = new z2.j(aVar, "flutter/navigation", z2.f.f9002a);
        this.f8635a = jVar;
        jVar.e(aVar2);
    }

    public void a() {
        n2.b.f("NavigationChannel", "Sending message to pop route.");
        this.f8635a.c("popRoute", null);
    }

    public void b(String str) {
        n2.b.f("NavigationChannel", "Sending message to push route information '" + str + "'");
        HashMap hashMap = new HashMap();
        hashMap.put("location", str);
        this.f8635a.c("pushRouteInformation", hashMap);
    }

    public void c(String str) {
        n2.b.f("NavigationChannel", "Sending message to set initial route to '" + str + "'");
        this.f8635a.c("setInitialRoute", str);
    }
}
