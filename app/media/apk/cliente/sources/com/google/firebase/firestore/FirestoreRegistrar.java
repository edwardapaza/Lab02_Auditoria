package com.google.firebase.firestore;

import android.content.Context;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class FirestoreRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fst";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ b0 lambda$getComponents$0(k1.e eVar) {
        return new b0((Context) eVar.a(Context.class), (f1.f) eVar.a(f1.f.class), eVar.i(j1.b.class), eVar.i(i1.b.class), new y1.t(eVar.f(e2.i.class), eVar.f(a2.j.class), (f1.n) eVar.a(f1.n.class)));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<k1.c<?>> getComponents() {
        return Arrays.asList(k1.c.c(b0.class).f(LIBRARY_NAME).b(k1.r.j(f1.f.class)).b(k1.r.j(Context.class)).b(k1.r.i(a2.j.class)).b(k1.r.i(e2.i.class)).b(k1.r.a(j1.b.class)).b(k1.r.a(i1.b.class)).b(k1.r.h(f1.n.class)).d(new k1.h() { // from class: com.google.firebase.firestore.c0
            @Override // k1.h
            public final Object a(k1.e eVar) {
                b0 lambda$getComponents$0;
                lambda$getComponents$0 = FirestoreRegistrar.lambda$getComponents$0(eVar);
                return lambda$getComponents$0;
            }
        }).c(), e2.h.b(LIBRARY_NAME, "24.11.0"));
    }
}
