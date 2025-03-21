package f3;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.g0;
import z2.c;
/* loaded from: classes.dex */
public class j implements c.d {

    /* renamed from: a  reason: collision with root package name */
    g0 f3029a;

    /* renamed from: b  reason: collision with root package name */
    FirebaseFirestore f3030b;

    public j(FirebaseFirestore firebaseFirestore) {
        this.f3030b = firebaseFirestore;
    }

    @Override // z2.c.d
    public void a(Object obj, final c.b bVar) {
        this.f3029a = this.f3030b.g(new Runnable() { // from class: f3.i
            @Override // java.lang.Runnable
            public final void run() {
                c.b.this.a(null);
            }
        });
    }

    @Override // z2.c.d
    public void b(Object obj) {
        g0 g0Var = this.f3029a;
        if (g0Var != null) {
            g0Var.remove();
            this.f3029a = null;
        }
    }
}
