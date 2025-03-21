package f3;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.i0;
import com.google.firebase.firestore.j0;
import com.google.firebase.firestore.q0;
import java.util.Objects;
import z2.c;
/* loaded from: classes.dex */
public class e implements c.d {

    /* renamed from: a  reason: collision with root package name */
    private c.b f3018a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseFirestore f3019b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f3020c;

    public e(FirebaseFirestore firebaseFirestore, byte[] bArr) {
        this.f3019b = firebaseFirestore;
        this.f3020c = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(c.b bVar, Exception exc) {
        bVar.b("firebase_firestore", exc.getMessage(), g3.a.a(exc));
        b(null);
    }

    @Override // z2.c.d
    public void a(Object obj, final c.b bVar) {
        this.f3018a = bVar;
        i0 E = this.f3019b.E(this.f3020c);
        Objects.requireNonNull(bVar);
        E.a(new q0() { // from class: f3.c
            @Override // com.google.firebase.firestore.q0
            public final void a(Object obj2) {
                c.b.this.a((j0) obj2);
            }
        });
        E.addOnFailureListener(new OnFailureListener() { // from class: f3.d
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                e.this.d(bVar, exc);
            }
        });
    }

    @Override // z2.c.d
    public void b(Object obj) {
        this.f3018a.c();
    }
}
