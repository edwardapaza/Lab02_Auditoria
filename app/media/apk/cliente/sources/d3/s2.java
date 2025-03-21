package d3;

import d3.a1;
import d3.s2;
import java.util.ArrayList;
import z2.a;
/* loaded from: classes.dex */
public final /* synthetic */ class s2 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a1.f0<a1.z> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2534a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f2535b;

        a(ArrayList arrayList, a.e eVar) {
            this.f2534a = arrayList;
            this.f2535b = eVar;
        }

        @Override // d3.a1.f0
        public void b(Throwable th) {
            this.f2535b.a(a1.a(th));
        }

        @Override // d3.a1.f0
        /* renamed from: c */
        public void a(a1.z zVar) {
            this.f2534a.add(0, zVar);
            this.f2535b.a(this.f2534a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements a1.f0<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2536a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f2537b;

        b(ArrayList arrayList, a.e eVar) {
            this.f2536a = arrayList;
            this.f2537b = eVar;
        }

        @Override // d3.a1.f0
        public void b(Throwable th) {
            this.f2537b.a(a1.a(th));
        }

        @Override // d3.a1.f0
        /* renamed from: c */
        public void a(String str) {
            this.f2536a.add(0, str);
            this.f2537b.a(this.f2536a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements a1.f0<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2538a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f2539b;

        c(ArrayList arrayList, a.e eVar) {
            this.f2538a = arrayList;
            this.f2539b = eVar;
        }

        @Override // d3.a1.f0
        public void b(Throwable th) {
            this.f2539b.a(a1.a(th));
        }

        @Override // d3.a1.f0
        /* renamed from: c */
        public void a(String str) {
            this.f2538a.add(0, str);
            this.f2539b.a(this.f2538a);
        }
    }

    public static z2.h<Object> a() {
        return a1.k.f2314d;
    }

    public static /* synthetic */ void c(a1.j jVar, Object obj, a.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        jVar.c((String) arrayList.get(0), (String) arrayList.get(1), new b(new ArrayList(), eVar));
    }

    public static /* synthetic */ void d(a1.j jVar, Object obj, a.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        jVar.b((String) arrayList.get(0), (String) arrayList.get(1), new c(new ArrayList(), eVar));
    }

    public static void e(z2.b bVar, a1.j jVar) {
        f(bVar, "", jVar);
    }

    public static void f(z2.b bVar, String str, final a1.j jVar) {
        String str2;
        if (str.isEmpty()) {
            str2 = "";
        } else {
            str2 = "." + str;
        }
        z2.a aVar = new z2.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.generateSecret" + str2, a());
        if (jVar != null) {
            aVar.e(new a.d() { // from class: d3.p2
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    a1.j.this.a((String) ((ArrayList) obj).get(0), new s2.a(new ArrayList(), eVar));
                }
            });
        } else {
            aVar.e(null);
        }
        z2.a aVar2 = new z2.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.getAssertionForEnrollment" + str2, a());
        if (jVar != null) {
            aVar2.e(new a.d() { // from class: d3.q2
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    s2.c(a1.j.this, obj, eVar);
                }
            });
        } else {
            aVar2.e(null);
        }
        z2.a aVar3 = new z2.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.getAssertionForSignIn" + str2, a());
        if (jVar != null) {
            aVar3.e(new a.d() { // from class: d3.r2
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    s2.d(a1.j.this, obj, eVar);
                }
            });
        } else {
            aVar3.e(null);
        }
    }
}
