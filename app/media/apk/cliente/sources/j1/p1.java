package j1;

import com.google.android.gms.internal.p001firebaseauthapi.zzags;
/* loaded from: classes.dex */
public final class p1 {
    public static zzags a(com.google.firebase.auth.h hVar, String str) {
        com.google.android.gms.common.internal.q.k(hVar);
        if (com.google.firebase.auth.f0.class.isAssignableFrom(hVar.getClass())) {
            return com.google.firebase.auth.f0.w((com.google.firebase.auth.f0) hVar, str);
        }
        if (com.google.firebase.auth.l.class.isAssignableFrom(hVar.getClass())) {
            return com.google.firebase.auth.l.w((com.google.firebase.auth.l) hVar, str);
        }
        if (com.google.firebase.auth.b1.class.isAssignableFrom(hVar.getClass())) {
            return com.google.firebase.auth.b1.w((com.google.firebase.auth.b1) hVar, str);
        }
        if (com.google.firebase.auth.d0.class.isAssignableFrom(hVar.getClass())) {
            return com.google.firebase.auth.d0.w((com.google.firebase.auth.d0) hVar, str);
        }
        if (com.google.firebase.auth.u0.class.isAssignableFrom(hVar.getClass())) {
            return com.google.firebase.auth.u0.w((com.google.firebase.auth.u0) hVar, str);
        }
        if (com.google.firebase.auth.d2.class.isAssignableFrom(hVar.getClass())) {
            return com.google.firebase.auth.d2.z((com.google.firebase.auth.d2) hVar, str);
        }
        throw new IllegalArgumentException("Unsupported credential type.");
    }
}
