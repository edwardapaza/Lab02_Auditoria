package com.google.firebase.auth;

import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public class FirebaseAuthRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ FirebaseAuth lambda$getComponents$0(k1.f0 f0Var, k1.f0 f0Var2, k1.f0 f0Var3, k1.f0 f0Var4, k1.f0 f0Var5, k1.e eVar) {
        return new j1.g((f1.f) eVar.a(f1.f.class), eVar.f(i1.b.class), eVar.f(a2.i.class), (Executor) eVar.e(f0Var), (Executor) eVar.e(f0Var2), (Executor) eVar.e(f0Var3), (ScheduledExecutorService) eVar.e(f0Var4), (Executor) eVar.e(f0Var5));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<k1.c<?>> getComponents() {
        final k1.f0 a5 = k1.f0.a(g1.a.class, Executor.class);
        final k1.f0 a6 = k1.f0.a(g1.b.class, Executor.class);
        final k1.f0 a7 = k1.f0.a(g1.c.class, Executor.class);
        final k1.f0 a8 = k1.f0.a(g1.c.class, ScheduledExecutorService.class);
        final k1.f0 a9 = k1.f0.a(g1.d.class, Executor.class);
        return Arrays.asList(k1.c.d(FirebaseAuth.class, j1.b.class).b(k1.r.j(f1.f.class)).b(k1.r.l(a2.i.class)).b(k1.r.k(a5)).b(k1.r.k(a6)).b(k1.r.k(a7)).b(k1.r.k(a8)).b(k1.r.k(a9)).b(k1.r.i(i1.b.class)).d(new k1.h() { // from class: com.google.firebase.auth.l1
            @Override // k1.h
            public final Object a(k1.e eVar) {
                return FirebaseAuthRegistrar.lambda$getComponents$0(k1.f0.this, a6, a7, a8, a9, eVar);
            }
        }).c(), a2.h.a(), e2.h.b("fire-auth", "22.3.1"));
    }
}
