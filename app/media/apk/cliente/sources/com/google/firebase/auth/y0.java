package com.google.firebase.auth;

import com.google.android.gms.tasks.Task;
/* loaded from: classes.dex */
public final class y0 {
    public static Task<a1> a(l0 l0Var) {
        com.google.android.gms.common.internal.q.k(l0Var);
        j1.p pVar = (j1.p) l0Var;
        return FirebaseAuth.getInstance(pVar.t().P()).X(pVar);
    }

    public static x0 b(a1 a1Var, String str) {
        return new x0((String) com.google.android.gms.common.internal.q.k(str), (a1) com.google.android.gms.common.internal.q.k(a1Var), null);
    }

    public static x0 c(String str, String str2) {
        return new x0((String) com.google.android.gms.common.internal.q.k(str2), null, (String) com.google.android.gms.common.internal.q.k(str));
    }
}
