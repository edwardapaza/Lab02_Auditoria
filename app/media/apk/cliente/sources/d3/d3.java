package d3;

import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import z2.c;
/* loaded from: classes.dex */
public class d3 implements c.d {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseAuth f2425a;

    /* renamed from: b  reason: collision with root package name */
    private FirebaseAuth.b f2426b;

    public d3(FirebaseAuth firebaseAuth) {
        this.f2425a = firebaseAuth;
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
        hashMap.put("appName", this.f2425a.l().q());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        FirebaseAuth.b bVar2 = new FirebaseAuth.b() { // from class: d3.c3
            @Override // com.google.firebase.auth.FirebaseAuth.b
            public final void a(FirebaseAuth firebaseAuth) {
                d3.d(atomicBoolean, hashMap, bVar, firebaseAuth);
            }
        };
        this.f2426b = bVar2;
        this.f2425a.f(bVar2);
    }

    @Override // z2.c.d
    public void b(Object obj) {
        FirebaseAuth.b bVar = this.f2426b;
        if (bVar != null) {
            this.f2425a.t(bVar);
            this.f2426b = null;
        }
    }
}
