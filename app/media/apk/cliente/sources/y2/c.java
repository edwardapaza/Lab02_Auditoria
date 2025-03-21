package y2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import z2.j;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final z2.j f8602a;

    /* renamed from: b  reason: collision with root package name */
    private p2.a f8603b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<j.d>> f8604c;

    /* renamed from: d  reason: collision with root package name */
    final j.c f8605d;

    /* loaded from: classes.dex */
    class a implements j.c {
        a() {
        }

        @Override // z2.j.c
        public void a(z2.i iVar, j.d dVar) {
            String str;
            if (c.this.f8603b == null) {
                return;
            }
            String str2 = iVar.f9003a;
            Map map = (Map) iVar.a();
            n2.b.f("DeferredComponentChannel", "Received '" + str2 + "' message.");
            int intValue = ((Integer) map.get("loadingUnitId")).intValue();
            String str3 = (String) map.get("componentName");
            str2.hashCode();
            char c5 = 65535;
            switch (str2.hashCode()) {
                case -1004447972:
                    if (str2.equals("uninstallDeferredComponent")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 399701758:
                    if (str2.equals("getDeferredComponentInstallState")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 520962947:
                    if (str2.equals("installDeferredComponent")) {
                        c5 = 2;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    c.this.f8603b.b(intValue, str3);
                    str = null;
                    break;
                case 1:
                    str = c.this.f8603b.a(intValue, str3);
                    break;
                case 2:
                    c.this.f8603b.d(intValue, str3);
                    if (!c.this.f8604c.containsKey(str3)) {
                        c.this.f8604c.put(str3, new ArrayList());
                    }
                    ((List) c.this.f8604c.get(str3)).add(dVar);
                    return;
                default:
                    dVar.c();
                    return;
            }
            dVar.a(str);
        }
    }

    public c(o2.a aVar) {
        a aVar2 = new a();
        this.f8605d = aVar2;
        z2.j jVar = new z2.j(aVar, "flutter/deferredcomponent", z2.q.f9018b);
        this.f8602a = jVar;
        jVar.e(aVar2);
        this.f8603b = n2.a.e().a();
        this.f8604c = new HashMap();
    }

    public void c(p2.a aVar) {
        this.f8603b = aVar;
    }
}
