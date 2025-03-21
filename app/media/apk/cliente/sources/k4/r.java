package k4;

import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends q {
    public static final String h0(String str, int i5) {
        int c5;
        e4.k.e(str, "<this>");
        if (i5 >= 0) {
            c5 = h4.l.c(i5, str.length());
            String substring = str.substring(c5);
            e4.k.d(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i5 + " is less than zero.").toString());
    }

    public static char i0(CharSequence charSequence) {
        e4.k.e(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(p.q(charSequence));
    }
}
