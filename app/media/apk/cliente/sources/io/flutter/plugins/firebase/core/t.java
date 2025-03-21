package io.flutter.plugins.firebase.core;

import io.flutter.plugins.firebase.core.p;
import io.flutter.plugins.firebase.core.t;
import java.util.ArrayList;
import java.util.List;
import z2.a;
/* loaded from: classes.dex */
public final /* synthetic */ class t {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements p.g<p.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f4180a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f4181b;

        a(ArrayList arrayList, a.e eVar) {
            this.f4180a = arrayList;
            this.f4181b = eVar;
        }

        @Override // io.flutter.plugins.firebase.core.p.g
        public void b(Throwable th) {
            this.f4181b.a(p.a(th));
        }

        @Override // io.flutter.plugins.firebase.core.p.g
        /* renamed from: c */
        public void a(p.f fVar) {
            this.f4180a.add(0, fVar);
            this.f4181b.a(this.f4180a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements p.g<List<p.f>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f4182a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f4183b;

        b(ArrayList arrayList, a.e eVar) {
            this.f4182a = arrayList;
            this.f4183b = eVar;
        }

        @Override // io.flutter.plugins.firebase.core.p.g
        public void b(Throwable th) {
            this.f4183b.a(p.a(th));
        }

        @Override // io.flutter.plugins.firebase.core.p.g
        /* renamed from: c */
        public void a(List<p.f> list) {
            this.f4182a.add(0, list);
            this.f4183b.a(this.f4182a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements p.g<p.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f4184a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.e f4185b;

        c(ArrayList arrayList, a.e eVar) {
            this.f4184a = arrayList;
            this.f4185b = eVar;
        }

        @Override // io.flutter.plugins.firebase.core.p.g
        public void b(Throwable th) {
            this.f4185b.a(p.a(th));
        }

        @Override // io.flutter.plugins.firebase.core.p.g
        /* renamed from: c */
        public void a(p.e eVar) {
            this.f4184a.add(0, eVar);
            this.f4185b.a(this.f4184a);
        }
    }

    public static z2.h<Object> a() {
        return p.c.f4138d;
    }

    public static /* synthetic */ void b(p.b bVar, Object obj, a.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        bVar.a((String) arrayList.get(0), (p.e) arrayList.get(1), new a(new ArrayList(), eVar));
    }

    public static void e(z2.b bVar, final p.b bVar2) {
        z2.a aVar = new z2.a(bVar, "dev.flutter.pigeon.FirebaseCoreHostApi.initializeApp", a());
        if (bVar2 != null) {
            aVar.e(new a.d() { // from class: io.flutter.plugins.firebase.core.q
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    t.b(p.b.this, obj, eVar);
                }
            });
        } else {
            aVar.e(null);
        }
        z2.a aVar2 = new z2.a(bVar, "dev.flutter.pigeon.FirebaseCoreHostApi.initializeCore", a());
        if (bVar2 != null) {
            aVar2.e(new a.d() { // from class: io.flutter.plugins.firebase.core.r
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    p.b.this.c(new t.b(new ArrayList(), eVar));
                }
            });
        } else {
            aVar2.e(null);
        }
        z2.a aVar3 = new z2.a(bVar, "dev.flutter.pigeon.FirebaseCoreHostApi.optionsFromResource", a());
        if (bVar2 != null) {
            aVar3.e(new a.d() { // from class: io.flutter.plugins.firebase.core.s
                @Override // z2.a.d
                public final void a(Object obj, a.e eVar) {
                    p.b.this.d(new t.c(new ArrayList(), eVar));
                }
            });
        } else {
            aVar3.e(null);
        }
    }
}
