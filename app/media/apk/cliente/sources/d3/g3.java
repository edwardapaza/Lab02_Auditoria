package d3;

import android.net.Uri;
import com.google.firebase.auth.e;
import com.google.firebase.auth.n0;
import d3.a1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes.dex */
public class g3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.firebase.auth.e a(a1.q qVar) {
        e.a z4 = com.google.firebase.auth.e.z();
        z4.f(qVar.h());
        if (qVar.e() != null) {
            z4.c(qVar.e());
        }
        z4.d(qVar.f().booleanValue());
        if (qVar.d() != null) {
            z4.b(qVar.d(), qVar.b().booleanValue(), qVar.c());
        }
        if (qVar.g() != null) {
            z4.e(qVar.g());
        }
        return z4.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.firebase.auth.h b(Map<String, Object> map) {
        if (map.get("token") != null) {
            com.google.firebase.auth.h hVar = u.f2544i.get(Integer.valueOf(((Integer) map.get("token")).intValue()));
            if (hVar != null) {
                return hVar;
            }
            throw v.b();
        }
        Object obj = map.get("signInMethod");
        Objects.requireNonNull(obj);
        String str = (String) obj;
        String str2 = (String) map.get("secret");
        String str3 = (String) map.get("idToken");
        String str4 = (String) map.get("accessToken");
        String str5 = (String) map.get("rawNonce");
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1830313082:
                if (str.equals("twitter.com")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1551433523:
                if (str.equals("playgames.google.com")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1536293812:
                if (str.equals("google.com")) {
                    c5 = 2;
                    break;
                }
                break;
            case -364826023:
                if (str.equals("facebook.com")) {
                    c5 = 3;
                    break;
                }
                break;
            case 105516695:
                if (str.equals("oauth")) {
                    c5 = 4;
                    break;
                }
                break;
            case 106642798:
                if (str.equals("phone")) {
                    c5 = 5;
                    break;
                }
                break;
            case 1216985755:
                if (str.equals("password")) {
                    c5 = 6;
                    break;
                }
                break;
            case 1985010934:
                if (str.equals("github.com")) {
                    c5 = 7;
                    break;
                }
                break;
            case 2120171958:
                if (str.equals("emailLink")) {
                    c5 = '\b';
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                Objects.requireNonNull(str4);
                Objects.requireNonNull(str2);
                return com.google.firebase.auth.c1.a(str4, str2);
            case 1:
                Object obj2 = map.get("serverAuthCode");
                Objects.requireNonNull(obj2);
                return com.google.firebase.auth.v0.a((String) obj2);
            case 2:
                return com.google.firebase.auth.g0.a(str3, str4);
            case 3:
                Objects.requireNonNull(str4);
                return com.google.firebase.auth.m.a(str4);
            case 4:
                Object obj3 = map.get("providerId");
                Objects.requireNonNull(obj3);
                n0.b f5 = com.google.firebase.auth.n0.f((String) obj3);
                if (str4 != null) {
                    f5.b(str4);
                }
                Objects.requireNonNull(str3);
                if (str5 == null) {
                    f5.c(str3);
                } else {
                    f5.d(str3, str5);
                }
                return f5.a();
            case 5:
                Object obj4 = map.get("verificationId");
                Objects.requireNonNull(obj4);
                Object obj5 = map.get("smsCode");
                Objects.requireNonNull(obj5);
                return com.google.firebase.auth.q0.a((String) obj4, (String) obj5);
            case 6:
                Object obj6 = map.get("email");
                Objects.requireNonNull(obj6);
                Objects.requireNonNull(str2);
                return com.google.firebase.auth.k.a((String) obj6, str2);
            case 7:
                Objects.requireNonNull(str4);
                return com.google.firebase.auth.e0.a(str4);
            case '\b':
                Object obj7 = map.get("email");
                Objects.requireNonNull(obj7);
                Object obj8 = map.get("emailLink");
                Objects.requireNonNull(obj8);
                return com.google.firebase.auth.k.b((String) obj7, (String) obj8);
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Object> c(a1.b0 b0Var) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(b0Var.c().n());
        arrayList.add(b0Var.b());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<List<Object>> d(List<com.google.firebase.auth.j0> list) {
        ArrayList arrayList = new ArrayList();
        for (a1.v vVar : e(list)) {
            arrayList.add(vVar.g());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<a1.v> e(List<com.google.firebase.auth.j0> list) {
        ArrayList arrayList = new ArrayList();
        for (com.google.firebase.auth.j0 j0Var : list) {
            arrayList.add((j0Var instanceof com.google.firebase.auth.t0 ? new a1.v.a().e(((com.google.firebase.auth.t0) j0Var).j()) : new a1.v.a()).b(j0Var.q()).c(Double.valueOf(j0Var.t())).f(j0Var.a()).d(j0Var.u()).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a1.o f(com.google.firebase.auth.d dVar) {
        a1.a aVar;
        com.google.firebase.auth.b b5;
        a1.o.a aVar2 = new a1.o.a();
        a1.p.a aVar3 = new a1.p.a();
        int a5 = dVar.a();
        if (a5 == 0) {
            aVar = a1.a.PASSWORD_RESET;
        } else if (a5 == 1) {
            aVar = a1.a.VERIFY_EMAIL;
        } else if (a5 == 2) {
            aVar = a1.a.RECOVER_EMAIL;
        } else if (a5 == 4) {
            aVar = a1.a.EMAIL_SIGN_IN;
        } else if (a5 != 5) {
            if (a5 == 6) {
                aVar = a1.a.REVERT_SECOND_FACTOR_ADDITION;
            }
            b5 = dVar.b();
            if ((b5 == null && a5 == 1) || a5 == 0) {
                aVar3.b(b5.a());
            } else if (a5 != 2 || a5 == 5) {
                Objects.requireNonNull(b5);
                com.google.firebase.auth.a aVar4 = (com.google.firebase.auth.a) b5;
                aVar3.b(aVar4.a());
                aVar3.c(aVar4.b());
            }
            aVar2.b(aVar3.a());
            return aVar2.a();
        } else {
            aVar = a1.a.VERIFY_AND_CHANGE_EMAIL;
        }
        aVar2.c(aVar);
        b5 = dVar.b();
        if (b5 == null) {
        }
        if (a5 != 2) {
        }
        Objects.requireNonNull(b5);
        com.google.firebase.auth.a aVar42 = (com.google.firebase.auth.a) b5;
        aVar3.b(aVar42.a());
        aVar3.c(aVar42.b());
        aVar2.b(aVar3.a());
        return aVar2.a();
    }

    private static a1.r g(com.google.firebase.auth.g gVar) {
        if (gVar == null) {
            return null;
        }
        a1.r.a aVar = new a1.r.a();
        aVar.b(Boolean.valueOf(gVar.p()));
        aVar.c(gVar.e());
        aVar.d(gVar.c());
        aVar.e(gVar.o());
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a1.s h(com.google.firebase.auth.h hVar) {
        if (hVar == null) {
            return null;
        }
        int hashCode = hVar.hashCode();
        u.f2544i.put(Integer.valueOf(hashCode), hVar);
        a1.s.a aVar = new a1.s.a();
        aVar.d(hVar.t());
        aVar.e(hVar.u());
        aVar.c(Long.valueOf(hashCode));
        if (hVar instanceof com.google.firebase.auth.m0) {
            aVar.b(((com.google.firebase.auth.m0) hVar).w());
        }
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a1.a0 i(com.google.firebase.auth.i iVar) {
        a1.a0.a aVar = new a1.a0.a();
        aVar.b(g(iVar.s()));
        aVar.c(h(iVar.d()));
        aVar.d(j(iVar.m()));
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a1.b0 j(com.google.firebase.auth.a0 a0Var) {
        if (a0Var == null) {
            return null;
        }
        a1.b0.a aVar = new a1.b0.a();
        a1.c0.a aVar2 = new a1.c0.a();
        aVar2.c(a0Var.q());
        aVar2.d(a0Var.n());
        aVar2.f(Boolean.valueOf(a0Var.f()));
        aVar2.e(Boolean.valueOf(a0Var.z()));
        if (a0Var.v() != null) {
            aVar2.b(Long.valueOf(a0Var.v().k()));
            aVar2.g(Long.valueOf(a0Var.v().r()));
        }
        aVar2.h(a0Var.j());
        aVar2.i(k(a0Var.b()));
        aVar2.k(a0Var.a());
        aVar2.j(a0Var.y());
        aVar.c(aVar2.a());
        aVar.b(m(a0Var.x()));
        return aVar.a();
    }

    private static String k(Uri uri) {
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        if ("".equals(uri2)) {
            return null;
        }
        return uri2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a1.u l(com.google.firebase.auth.c0 c0Var) {
        a1.u.a aVar = new a1.u.a();
        aVar.h(c0Var.g());
        aVar.f(c0Var.e());
        aVar.b(Long.valueOf(c0Var.a() * 1000));
        aVar.d(Long.valueOf(c0Var.c() * 1000));
        aVar.e(Long.valueOf(c0Var.d() * 1000));
        aVar.c(c0Var.b());
        aVar.g(c0Var.f());
        return aVar.a();
    }

    private static List<Map<Object, Object>> m(List<? extends com.google.firebase.auth.d1> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return null;
        }
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            com.google.firebase.auth.d1 d1Var = (com.google.firebase.auth.d1) it.next();
            if (d1Var != null && !"firebase".equals(d1Var.c())) {
                arrayList.add(n(d1Var));
            }
        }
        return arrayList;
    }

    private static Map<Object, Object> n(com.google.firebase.auth.d1 d1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("displayName", d1Var.q());
        hashMap.put("email", d1Var.n());
        hashMap.put("isEmailVerified", Boolean.valueOf(d1Var.f()));
        hashMap.put("phoneNumber", d1Var.j());
        hashMap.put("photoUrl", k(d1Var.b()));
        hashMap.put("uid", d1Var.a() == null ? "" : d1Var.a());
        hashMap.put("providerId", d1Var.c());
        hashMap.put("isAnonymous", Boolean.FALSE);
        return hashMap;
    }
}
