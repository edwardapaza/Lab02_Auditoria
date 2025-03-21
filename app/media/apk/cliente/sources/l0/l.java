package l0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.errorprone.annotations.RestrictedInheritance;
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes.dex */
public class l {

    /* renamed from: b  reason: collision with root package name */
    private static l f5893b;

    /* renamed from: a  reason: collision with root package name */
    private final Context f5894a;

    public l(Context context) {
        this.f5894a = context.getApplicationContext();
    }

    public static l a(Context context) {
        com.google.android.gms.common.internal.q.k(context);
        synchronized (l.class) {
            if (f5893b == null) {
                a0.a(context);
                f5893b = new l(context);
            }
        }
        return f5893b;
    }

    static final w b(PackageInfo packageInfo, w... wVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            x xVar = new x(packageInfo.signatures[0].toByteArray());
            for (int i5 = 0; i5 < wVarArr.length; i5++) {
                if (wVarArr[i5].equals(xVar)) {
                    return wVarArr[i5];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean c(android.content.pm.PackageInfo r4, boolean r5) {
        /*
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L2a
            if (r4 == 0) goto L28
            java.lang.String r2 = r4.packageName
            java.lang.String r3 = "com.android.vending"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L1a
            java.lang.String r2 = r4.packageName
            java.lang.String r3 = "com.google.android.gms"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L2a
        L1a:
            android.content.pm.ApplicationInfo r5 = r4.applicationInfo
            if (r5 != 0) goto L20
        L1e:
            r5 = 0
            goto L2a
        L20:
            int r5 = r5.flags
            r5 = r5 & 129(0x81, float:1.81E-43)
            if (r5 == 0) goto L1e
            r5 = 1
            goto L2a
        L28:
            r2 = 0
            goto L2b
        L2a:
            r2 = r4
        L2b:
            if (r4 == 0) goto L49
            android.content.pm.Signature[] r4 = r2.signatures
            if (r4 == 0) goto L49
            if (r5 == 0) goto L3a
            l0.w[] r4 = l0.z.f5904a
            l0.w r4 = b(r2, r4)
            goto L46
        L3a:
            l0.w[] r4 = new l0.w[r0]
            l0.w[] r5 = l0.z.f5904a
            r5 = r5[r1]
            r4[r1] = r5
            l0.w r4 = b(r2, r4)
        L46:
            if (r4 == 0) goto L49
            return r0
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.l.c(android.content.pm.PackageInfo, boolean):boolean");
    }
}
