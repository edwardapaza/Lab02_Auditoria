package d3;

import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import z2.c;
/* loaded from: classes.dex */
public class b implements c.d {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseAuth f2397a;

    /* renamed from: b  reason: collision with root package name */
    private FirebaseAuth.a f2398b;

    public b(FirebaseAuth firebaseAuth) {
        this.f2397a = firebaseAuth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AtomicBoolean atomicBoolean, Map map, c.b bVar, FirebaseAuth firebaseAuth) {
        if (atomicBoolean.get()) {
            atomicBoolean.set(false);
            return;
        }
        com.google.firebase.auth.a0 m5 = firebaseAuth.m();
        map.put("user", m5 == null ? null : g3.c(g3.j(m5)));
        bVar.a(map);
    }

    @Override // z2.c.d
    public void a(Object obj, final c.b bVar) {
        final HashMap hashMap = new HashMap();
        hashMap.put("appName", this.f2397a.l().q());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        FirebaseAuth.a aVar = new FirebaseAuth.a() { // from class: d3.a
            @Override // com.google.firebase.auth.FirebaseAuth.a
            public final void a(FirebaseAuth firebaseAuth) {
                b.d(atomicBoolean, hashMap, bVar, firebaseAuth);
            }
        };
        this.f2398b = aVar;
        this.f2397a.e(aVar);
    }

    @Override // z2.c.d
    public void b(Object obj) {
        FirebaseAuth.a aVar = this.f2398b;
        if (aVar != null) {
            this.f2397a.s(aVar);
            this.f2398b = null;
        }
    }
}
