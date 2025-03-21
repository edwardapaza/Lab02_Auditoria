package q0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class a {
    @Deprecated
    public static byte[] a(Context context, String str) {
        MessageDigest b5;
        PackageInfo c5 = s0.d.a(context).c(str, 64);
        Signature[] signatureArr = c5.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (b5 = b("SHA1")) == null) {
            return null;
        }
        return b5.digest(c5.signatures[0].toByteArray());
    }

    public static MessageDigest b(String str) {
        MessageDigest messageDigest;
        for (int i5 = 0; i5 < 2; i5++) {
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }
}
