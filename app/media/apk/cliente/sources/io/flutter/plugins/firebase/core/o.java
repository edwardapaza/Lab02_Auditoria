package io.flutter.plugins.firebase.core;

import io.flutter.plugins.firebase.core.o;
import io.flutter.plugins.firebase.core.p;
import java.util.ArrayList;
import z2.a;
/* loaded from: classes.dex */
public final /* synthetic */ class o {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements p.g<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f4132a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f4133b;

        a(ArrayList arrayList, a.e eVar) {
            this.f4132a = arrayList;
            this.f4133b = eVar;
        }

        @Override // io.flutter.plugins.firebase.core.p.g
        public void b(Throwable th) {
            this.f4133b.a(p.a(th));
        }

        @Override // io.flutter.plugins.firebase.core.p.g
        /* renamed from: c */
        public void a(Void r32) {
            this.f4132a.add(0, null);
            this.f4133b.a(this.f4132a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements p.g<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f4134a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f4135b;

        b(ArrayList arrayList, a.e eVar) {
            this.f4134a = arrayList;
            this.f4135b = eVar;
        }

        @Override // io.flutter.plugins.firebase.core.p.g
        public void b(Throwable th) {
            this.f4135b.a(p.a(th));
        }

        @Override // io.flutter.plugins.firebase.core.p.g
        /* renamed from: c */
        public void a(Void r32) {
            this.f4134a.add(0, null);
            this.f4135b.a(this.f4134a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements p.g<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f4136a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f4137b;

        c(ArrayList arrayList, a.e eVar) {
            this.f4136a = arrayList;
            this.f4137b = eVar;
        }

        @Override // io.flutter.plugins.firebase.core.p.g
        public void b(Throwable th) {
            this.f4137b.a(p.a(th));
        }

        @Override // io.flutter.plugins.firebase.core.p.g
        /* renamed from: c */
        public void a(Void r32) {
            this.f4136a.add(0, null);
            this.f4137b.a(this.f4136a);
        }
    }

    public static z2.h<Object> a() {
        return new z2.p();
    }

    public static /* synthetic */ void b(p.a aVar, Object obj, a.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        aVar.e((String) arrayList.get(0), (Boolean) arrayList.get(1), new a(new ArrayList(), eVar));
    }

    public static /* synthetic */ void c(p.a aVar, Object obj, a.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        aVar.f((String) arrayList.get(0), (Boolean) arrayList.get(1), new b(new ArrayList(), eVar));
    }

    public static void e(z2.b bVar, final p.a aVar) {
        z2.a aVar2 = new z2.a(bVar, "dev.flutter.pigeon.FirebaseAppHostApi.setAutomaticDataCollectionEnabled", a());
        if (aVar != null) {
            aVar2.e(new a.d() { // from class: io.flutter.plugins.firebase.core.l
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    o.b(p.a.this, obj, eVar);
                }
            });
        } else {
            aVar2.e(null);
        }
        z2.a aVar3 = new z2.a(bVar, "dev.flutter.pigeon.FirebaseAppHostApi.setAutomaticResourceManagementEnabled", a());
        if (aVar != null) {
            aVar3.e(new a.d() { // from class: io.flutter.plugins.firebase.core.m
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    o.c(p.a.this, obj, eVar);
                }
            });
        } else {
            aVar3.e(null);
        }
        z2.a aVar4 = new z2.a(bVar, "dev.flutter.pigeon.FirebaseAppHostApi.delete", a());
        if (aVar != null) {
            aVar4.e(new a.d() { // from class: io.flutter.plugins.firebase.core.n
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    p.a.this.g((String) ((ArrayList) obj).get(0), new o.c(new ArrayList(), eVar));
                }
            });
        } else {
            aVar4.e(null);
        }
    }
}
