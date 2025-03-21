package z0;

import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class n {
    public static boolean a(String str) {
        return j.c(str);
    }

    public static String b(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i5 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i6 = 0; i6 < objArr.length; i6++) {
                objArr[i6] = c(objArr[i6]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i7 = 0;
        while (i5 < objArr.length && (indexOf = valueOf.indexOf("%s", i7)) != -1) {
            sb.append((CharSequence) valueOf, i7, indexOf);
            sb.append(objArr[i5]);
            i7 = indexOf + 2;
            i5++;
        }
        sb.append((CharSequence) valueOf, i7, valueOf.length());
        if (i5 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i5]);
            for (int i8 = i5 + 1; i8 < objArr.length; i8++) {
                sb.append(", ");
                sb.append(objArr[i8]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String c(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e5) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e5);
            return "<" + str + " threw " + e5.getClass().getName() + ">";
        }
    }
}
