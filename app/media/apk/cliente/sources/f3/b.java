package f3;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.b1;
import com.google.firebase.firestore.f0;
import com.google.firebase.firestore.g0;
import com.google.firebase.firestore.n;
import com.google.firebase.firestore.p0;
import com.google.firebase.firestore.z;
import z2.c;
/* loaded from: classes.dex */
public class b implements c.d {

    /* renamed from: a  reason: collision with root package name */
    g0 f3009a;

    /* renamed from: b  reason: collision with root package name */
    FirebaseFirestore f3010b;

    /* renamed from: c  reason: collision with root package name */
    com.google.firebase.firestore.m f3011c;

    /* renamed from: d  reason: collision with root package name */
    p0 f3012d;

    /* renamed from: e  reason: collision with root package name */
    n.a f3013e;

    /* renamed from: f  reason: collision with root package name */
    f0 f3014f;

    public b(FirebaseFirestore firebaseFirestore, com.google.firebase.firestore.m mVar, Boolean bool, n.a aVar, f0 f0Var) {
        this.f3010b = firebaseFirestore;
        this.f3011c = mVar;
        this.f3012d = bool.booleanValue() ? p0.INCLUDE : p0.EXCLUDE;
        this.f3013e = aVar;
        this.f3014f = f0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(c.b bVar, com.google.firebase.firestore.n nVar, z zVar) {
        if (zVar == null) {
            bVar.a(g3.b.k(nVar, this.f3013e).e());
            return;
        }
        bVar.b("firebase_firestore", zVar.getMessage(), g3.a.a(zVar));
        bVar.c();
        b(null);
    }

    @Override // z2.c.d
    public void a(Object obj, final c.b bVar) {
        b1.b bVar2 = new b1.b();
        bVar2.f(this.f3012d);
        bVar2.g(this.f3014f);
        this.f3009a = this.f3011c.d(bVar2.e(), new com.google.firebase.firestore.o() { // from class: f3.a
            @Override // com.google.firebase.firestore.o
            public final void a(Object obj2, z zVar) {
                b.this.d(bVar, (com.google.firebase.firestore.n) obj2, zVar);
            }
        });
    }

    @Override // z2.c.d
    public void b(Object obj) {
        g0 g0Var = this.f3009a;
        if (g0Var != null) {
            g0Var.remove();
            this.f3009a = null;
        }
    }
}
