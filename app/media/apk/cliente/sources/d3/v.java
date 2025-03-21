package d3;

import d3.a1;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
/* loaded from: classes.dex */
public class v {
    static a1.g a() {
        return new a1.g("PROVIDER_ALREADY_LINKED", "User has already been linked to the given provider.", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a1.g b() {
        return new a1.g("INVALID_CREDENTIAL", "The supplied auth credential is malformed, has expired or is not currently supported.", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a1.g c() {
        return new a1.g("NO_SUCH_PROVIDER", "User was not linked to an account with the given provider.", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a1.g d() {
        return new a1.g("NO_CURRENT_USER", "No user currently signed in.", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a1.g e(Exception exc) {
        if (exc == null) {
            return new a1.g("UNKNOWN", null, null);
        }
        String message = exc.getMessage();
        HashMap hashMap = new HashMap();
        if (exc instanceof com.google.firebase.auth.u) {
            com.google.firebase.auth.u uVar = (com.google.firebase.auth.u) exc;
            HashMap hashMap2 = new HashMap();
            com.google.firebase.auth.k0 b5 = uVar.b();
            List<com.google.firebase.auth.j0> u5 = b5.u();
            com.google.firebase.auth.l0 v5 = b5.v();
            String uuid = UUID.randomUUID().toString();
            w0.f2565b.put(uuid, v5);
            String uuid2 = UUID.randomUUID().toString();
            w0.f2566c.put(uuid2, b5);
            List<List<Object>> d5 = g3.d(u5);
            hashMap2.put("appName", uVar.b().t().l().q());
            hashMap2.put("multiFactorHints", d5);
            hashMap2.put("multiFactorSessionId", uuid);
            hashMap2.put("multiFactorResolverId", uuid2);
            return new a1.g(uVar.a(), uVar.getLocalizedMessage(), hashMap2);
        } else if ((exc instanceof f1.m) || (exc.getCause() != null && (exc.getCause() instanceof f1.m))) {
            return new a1.g("network-request-failed", "A network error (such as timeout, interrupted connection or unreachable host) has occurred.", null);
        } else {
            if ((exc instanceof f1.c) || (exc.getCause() != null && (exc.getCause() instanceof f1.c))) {
                return new a1.g("api-not-available", "The requested API is not available.", null);
            }
            if ((exc instanceof f1.o) || (exc.getCause() != null && (exc.getCause() instanceof f1.o))) {
                return new a1.g("too-many-requests", "We have blocked all requests from this device due to unusual activity. Try again later.", null);
            }
            if (exc.getMessage() == null || !exc.getMessage().startsWith("Cannot create PhoneAuthCredential without either verificationProof")) {
                if (message == null || !message.contains("User has already been linked to the given provider.")) {
                    String a5 = exc instanceof com.google.firebase.auth.q ? ((com.google.firebase.auth.q) exc).a() : "UNKNOWN";
                    if (exc instanceof com.google.firebase.auth.y) {
                        message = ((com.google.firebase.auth.y) exc).b();
                    }
                    if (exc instanceof com.google.firebase.auth.x) {
                        com.google.firebase.auth.x xVar = (com.google.firebase.auth.x) exc;
                        String b6 = xVar.b();
                        if (b6 != null) {
                            hashMap.put("email", b6);
                        }
                        com.google.firebase.auth.h c5 = xVar.c();
                        if (c5 != null) {
                            hashMap.put("authCredential", g3.h(c5));
                        }
                    }
                    return new a1.g(a5, message, hashMap);
                }
                return a();
            }
            return new a1.g("invalid-verification-code", "The verification ID used to create the phone auth credential is invalid.", null);
        }
    }
}
