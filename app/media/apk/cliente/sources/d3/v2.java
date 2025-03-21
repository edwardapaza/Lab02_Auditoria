package d3;

import d3.a1;
import java.util.ArrayList;
import z2.a;
/* loaded from: classes.dex */
public final /* synthetic */ class v2 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a1.f0<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2558a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f2559b;

        a(ArrayList arrayList, a.e eVar) {
            this.f2558a = arrayList;
            this.f2559b = eVar;
        }

        @Override // d3.a1.f0
        public void b(Throwable th) {
            this.f2559b.a(a1.a(th));
        }

        @Override // d3.a1.f0
        /* renamed from: c */
        public void a(String str) {
            this.f2558a.add(0, str);
            this.f2559b.a(this.f2558a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements a1.g0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2560a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f2561b;

        b(ArrayList arrayList, a.e eVar) {
            this.f2560a = arrayList;
            this.f2561b = eVar;
        }

        @Override // d3.a1.g0
        public void a() {
            this.f2560a.add(0, null);
            this.f2561b.a(this.f2560a);
        }

        @Override // d3.a1.g0
        public void b(Throwable th) {
            this.f2561b.a(a1.a(th));
        }
    }

    public static z2.h<Object> a() {
        return new z2.p();
    }

    public static /* synthetic */ void b(a1.l lVar, Object obj, a.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        lVar.a((String) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new a(new ArrayList(), eVar));
    }

    public static /* synthetic */ void c(a1.l lVar, Object obj, a.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        lVar.b((String) arrayList.get(0), (String) arrayList.get(1), new b(new ArrayList(), eVar));
    }

    public static void d(z2.b bVar, a1.l lVar) {
        e(bVar, "", lVar);
    }

    public static void e(z2.b bVar, String str, final a1.l lVar) {
        String str2;
        if (str.isEmpty()) {
            str2 = "";
        } else {
            str2 = "." + str;
        }
        z2.a aVar = new z2.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpSecretHostApi.generateQrCodeUrl" + str2, a());
        if (lVar != null) {
            aVar.e(new a.d() { // from class: d3.t2
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    v2.b(a1.l.this, obj, eVar);
                }
            });
        } else {
            aVar.e(null);
        }
        z2.a aVar2 = new z2.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpSecretHostApi.openInOtpApp" + str2, a());
        if (lVar != null) {
            aVar2.e(new a.d() { // from class: d3.u2
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    v2.c(a1.l.this, obj, eVar);
                }
            });
        } else {
            aVar2.e(null);
        }
    }
}
