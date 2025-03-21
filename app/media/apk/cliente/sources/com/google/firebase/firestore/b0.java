package com.google.firebase.firestore;

import android.content.Context;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b0 implements f1.g, FirebaseFirestore.a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, FirebaseFirestore> f1662a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final f1.f f1663b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1664c;

    /* renamed from: d  reason: collision with root package name */
    private final b2.a<j1.b> f1665d;

    /* renamed from: e  reason: collision with root package name */
    private final b2.a<i1.b> f1666e;

    /* renamed from: f  reason: collision with root package name */
    private final y1.j0 f1667f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(Context context, f1.f fVar, b2.a<j1.b> aVar, b2.a<i1.b> aVar2, y1.j0 j0Var) {
        this.f1664c = context;
        this.f1663b = fVar;
        this.f1665d = aVar;
        this.f1666e = aVar2;
        this.f1667f = j0Var;
        fVar.h(this);
    }

    @Override // f1.g
    public synchronized void a(String str, f1.n nVar) {
        Iterator it = new ArrayList(this.f1662a.entrySet()).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ((FirebaseFirestore) entry.getValue()).M();
            z1.b.d(!this.f1662a.containsKey(entry.getKey()), "terminate() should have removed its entry from `instances` for key: %s", entry.getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized FirebaseFirestore b(String str) {
        FirebaseFirestore firebaseFirestore;
        firebaseFirestore = this.f1662a.get(str);
        if (firebaseFirestore == null) {
            firebaseFirestore = FirebaseFirestore.G(this.f1664c, this.f1663b, this.f1665d, this.f1666e, str, this, this.f1667f);
            this.f1662a.put(str, firebaseFirestore);
        }
        return firebaseFirestore;
    }

    @Override // com.google.firebase.firestore.FirebaseFirestore.a
    public synchronized void remove(String str) {
        this.f1662a.remove(str);
    }
}
