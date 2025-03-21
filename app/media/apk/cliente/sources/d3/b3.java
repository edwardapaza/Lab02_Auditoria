package d3;

import d3.a1;
import d3.b3;
import java.util.ArrayList;
import java.util.List;
import z2.a;
/* loaded from: classes.dex */
public final /* synthetic */ class b3 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a1.g0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2402a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f2403b;

        a(ArrayList arrayList, a.e eVar) {
            this.f2402a = arrayList;
            this.f2403b = eVar;
        }

        @Override // d3.a1.g0
        public void a() {
            this.f2402a.add(0, null);
            this.f2403b.a(this.f2402a);
        }

        @Override // d3.a1.g0
        public void b(Throwable th) {
            this.f2403b.a(a1.a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements a1.g0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2404a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f2405b;

        b(ArrayList arrayList, a.e eVar) {
            this.f2404a = arrayList;
            this.f2405b = eVar;
        }

        @Override // d3.a1.g0
        public void a() {
            this.f2404a.add(0, null);
            this.f2405b.a(this.f2404a);
        }

        @Override // d3.a1.g0
        public void b(Throwable th) {
            this.f2405b.a(a1.a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements a1.f0<a1.w> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2406a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f2407b;

        c(ArrayList arrayList, a.e eVar) {
            this.f2406a = arrayList;
            this.f2407b = eVar;
        }

        @Override // d3.a1.f0
        public void b(Throwable th) {
            this.f2407b.a(a1.a(th));
        }

        @Override // d3.a1.f0
        /* renamed from: c */
        public void a(a1.w wVar) {
            this.f2406a.add(0, wVar);
            this.f2407b.a(this.f2406a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements a1.g0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2408a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f2409b;

        d(ArrayList arrayList, a.e eVar) {
            this.f2408a = arrayList;
            this.f2409b = eVar;
        }

        @Override // d3.a1.g0
        public void a() {
            this.f2408a.add(0, null);
            this.f2409b.a(this.f2408a);
        }

        @Override // d3.a1.g0
        public void b(Throwable th) {
            this.f2409b.a(a1.a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements a1.f0<List<a1.v>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2410a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f2411b;

        e(ArrayList arrayList, a.e eVar) {
            this.f2410a = arrayList;
            this.f2411b = eVar;
        }

        @Override // d3.a1.f0
        public void b(Throwable th) {
            this.f2411b.a(a1.a(th));
        }

        @Override // d3.a1.f0
        /* renamed from: c */
        public void a(List<a1.v> list) {
            this.f2410a.add(0, list);
            this.f2411b.a(this.f2410a);
        }
    }

    public static z2.h<Object> a() {
        return a1.n.f2315d;
    }

    public static /* synthetic */ void b(a1.m mVar, Object obj, a.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        mVar.e((a1.b) arrayList.get(0), (a1.x) arrayList.get(1), (String) arrayList.get(2), new a(new ArrayList(), eVar));
    }

    public static /* synthetic */ void c(a1.m mVar, Object obj, a.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        mVar.c((a1.b) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new b(new ArrayList(), eVar));
    }

    public static /* synthetic */ void e(a1.m mVar, Object obj, a.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        mVar.f((a1.b) arrayList.get(0), (String) arrayList.get(1), new d(new ArrayList(), eVar));
    }

    public static void g(z2.b bVar, a1.m mVar) {
        h(bVar, "", mVar);
    }

    public static void h(z2.b bVar, String str, final a1.m mVar) {
        String str2;
        if (str.isEmpty()) {
            str2 = "";
        } else {
            str2 = "." + str;
        }
        z2.a aVar = new z2.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.enrollPhone" + str2, a());
        if (mVar != null) {
            aVar.e(new a.d() { // from class: d3.w2
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    b3.b(a1.m.this, obj, eVar);
                }
            });
        } else {
            aVar.e(null);
        }
        z2.a aVar2 = new z2.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.enrollTotp" + str2, a());
        if (mVar != null) {
            aVar2.e(new a.d() { // from class: d3.x2
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    b3.c(a1.m.this, obj, eVar);
                }
            });
        } else {
            aVar2.e(null);
        }
        z2.a aVar3 = new z2.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.getSession" + str2, a());
        if (mVar != null) {
            aVar3.e(new a.d() { // from class: d3.y2
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    a1.m.this.d((a1.b) ((ArrayList) obj).get(0), new b3.c(new ArrayList(), eVar));
                }
            });
        } else {
            aVar3.e(null);
        }
        z2.a aVar4 = new z2.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.unenroll" + str2, a());
        if (mVar != null) {
            aVar4.e(new a.d() { // from class: d3.z2
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    b3.e(a1.m.this, obj, eVar);
                }
            });
        } else {
            aVar4.e(null);
        }
        z2.a aVar5 = new z2.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.getEnrolledFactors" + str2, a());
        if (mVar != null) {
            aVar5.e(new a.d() { // from class: d3.a3
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    a1.m.this.a((a1.b) ((ArrayList) obj).get(0), new b3.e(new ArrayList(), eVar));
                }
            });
        } else {
            aVar5.e(null);
        }
    }
}
