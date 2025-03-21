package y2;

import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Map;
import z2.j;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public final z2.j f8727a;

    /* renamed from: b  reason: collision with root package name */
    public final PackageManager f8728b;

    /* renamed from: c  reason: collision with root package name */
    private b f8729c;

    /* renamed from: d  reason: collision with root package name */
    public final j.c f8730d;

    /* loaded from: classes.dex */
    class a implements j.c {
        a() {
        }

        @Override // z2.j.c
        public void a(z2.i iVar, j.d dVar) {
            if (n.this.f8729c == null) {
                return;
            }
            String str = iVar.f9003a;
            Object obj = iVar.f9004b;
            str.hashCode();
            try {
                if (str.equals("ProcessText.processTextAction")) {
                    ArrayList arrayList = (ArrayList) obj;
                    boolean booleanValue = ((Boolean) arrayList.get(2)).booleanValue();
                    n.this.f8729c.d((String) arrayList.get(0), (String) arrayList.get(1), booleanValue, dVar);
                } else if (!str.equals("ProcessText.queryTextActions")) {
                    dVar.c();
                } else {
                    dVar.a(n.this.f8729c.c());
                }
            } catch (IllegalStateException e5) {
                dVar.b("error", e5.getMessage(), null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        Map<String, String> c();

        void d(String str, String str2, boolean z4, j.d dVar);
    }

    public n(o2.a aVar, PackageManager packageManager) {
        a aVar2 = new a();
        this.f8730d = aVar2;
        this.f8728b = packageManager;
        z2.j jVar = new z2.j(aVar, "flutter/processtext", z2.q.f9018b);
        this.f8727a = jVar;
        jVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f8729c = bVar;
    }
}
