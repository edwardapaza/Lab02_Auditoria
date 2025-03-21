package d3;

import d3.a1;
import java.util.ArrayList;
import z2.a;
/* loaded from: classes.dex */
public final /* synthetic */ class o2 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a1.f0<a1.a0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2516a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f2517b;

        a(ArrayList arrayList, a.e eVar) {
            this.f2516a = arrayList;
            this.f2517b = eVar;
        }

        @Override // d3.a1.f0
        public void b(Throwable th) {
            this.f2517b.a(a1.a(th));
        }

        @Override // d3.a1.f0
        /* renamed from: c */
        public void a(a1.a0 a0Var) {
            this.f2516a.add(0, a0Var);
            this.f2517b.a(this.f2516a);
        }
    }

    public static z2.h<Object> a() {
        return a1.i.f2313d;
    }

    public static /* synthetic */ void b(a1.h hVar, Object obj, a.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        hVar.b((String) arrayList.get(0), (a1.x) arrayList.get(1), (String) arrayList.get(2), new a(new ArrayList(), eVar));
    }

    public static void c(z2.b bVar, a1.h hVar) {
        d(bVar, "", hVar);
    }

    public static void d(z2.b bVar, String str, final a1.h hVar) {
        String str2;
        if (str.isEmpty()) {
            str2 = "";
        } else {
            str2 = "." + str;
        }
        new z2.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactoResolverHostApi.resolveSignIn" + str2, a()).e(hVar != null ? new a.d() { // from class: d3.n2
            @Override // z2.a.d
            public final void a(Object obj, a.e eVar) {
                o2.b(a1.h.this, obj, eVar);
            }
        } : null);
    }
}
