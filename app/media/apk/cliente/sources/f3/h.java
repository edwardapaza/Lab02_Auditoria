package f3;

import com.google.firebase.firestore.b1;
import com.google.firebase.firestore.f0;
import com.google.firebase.firestore.g0;
import com.google.firebase.firestore.n;
import com.google.firebase.firestore.p0;
import com.google.firebase.firestore.w0;
import com.google.firebase.firestore.y0;
import com.google.firebase.firestore.z;
import java.util.ArrayList;
import z2.c;
/* loaded from: classes.dex */
public class h implements c.d {

    /* renamed from: a  reason: collision with root package name */
    g0 f3023a;

    /* renamed from: b  reason: collision with root package name */
    w0 f3024b;

    /* renamed from: c  reason: collision with root package name */
    p0 f3025c;

    /* renamed from: d  reason: collision with root package name */
    n.a f3026d;

    /* renamed from: e  reason: collision with root package name */
    f0 f3027e;

    public h(w0 w0Var, Boolean bool, n.a aVar, f0 f0Var) {
        this.f3024b = w0Var;
        this.f3025c = bool.booleanValue() ? p0.INCLUDE : p0.EXCLUDE;
        this.f3026d = aVar;
        this.f3027e = f0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(c.b bVar, y0 y0Var, z zVar) {
        if (zVar != null) {
            bVar.b("firebase_firestore", zVar.getMessage(), g3.a.a(zVar));
            bVar.c();
            b(null);
            return;
        }
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(y0Var.l().size());
        ArrayList arrayList3 = new ArrayList(y0Var.i().size());
        for (com.google.firebase.firestore.n nVar : y0Var.l()) {
            arrayList2.add(g3.b.k(nVar, this.f3026d).e());
        }
        for (com.google.firebase.firestore.h hVar : y0Var.i()) {
            arrayList3.add(g3.b.h(hVar, this.f3026d).f());
        }
        arrayList.add(arrayList2);
        arrayList.add(arrayList3);
        arrayList.add(g3.b.n(y0Var.m()).d());
        bVar.a(arrayList);
    }

    @Override // z2.c.d
    public void a(Object obj, final c.b bVar) {
        b1.b bVar2 = new b1.b();
        bVar2.f(this.f3025c);
        bVar2.g(this.f3027e);
        this.f3023a = this.f3024b.d(bVar2.e(), new com.google.firebase.firestore.o() { // from class: f3.g
            @Override // com.google.firebase.firestore.o
            public final void a(Object obj2, z zVar) {
                h.this.d(bVar, (y0) obj2, zVar);
            }
        });
    }

    @Override // z2.c.d
    public void b(Object obj) {
        g0 g0Var = this.f3023a;
        if (g0Var != null) {
            g0Var.remove();
            this.f3023a = null;
        }
    }
}
