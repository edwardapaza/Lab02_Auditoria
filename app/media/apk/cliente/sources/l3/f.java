package l3;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
/* loaded from: classes.dex */
public final class f implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final f f5985a = new f();

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f5986b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private f() {
    }

    private static List<String> a(X509Certificate x509Certificate, int i5) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i5 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    static boolean c(String str) {
        return f5986b.matcher(str).matches();
    }

    private boolean d(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (lowerCase.contains("*")) {
                if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                    return false;
                }
                String substring = lowerCase.substring(1);
                if (str.endsWith(substring)) {
                    int length = str.length() - substring.length();
                    return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
                }
                return false;
            }
            return str.equals(lowerCase);
        }
        return false;
    }

    private boolean e(String str, X509Certificate x509Certificate) {
        String b5;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> a5 = a(x509Certificate, 2);
        int size = a5.size();
        int i5 = 0;
        boolean z4 = false;
        while (i5 < size) {
            if (d(lowerCase, a5.get(i5))) {
                return true;
            }
            i5++;
            z4 = true;
        }
        if (z4 || (b5 = new d(x509Certificate.getSubjectX500Principal()).b("cn")) == null) {
            return false;
        }
        return d(lowerCase, b5);
    }

    private boolean f(String str, X509Certificate x509Certificate) {
        List<String> a5 = a(x509Certificate, 7);
        int size = a5.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (str.equalsIgnoreCase(a5.get(i5))) {
                return true;
            }
        }
        return false;
    }

    public boolean b(String str, X509Certificate x509Certificate) {
        return c(str) ? f(str, x509Certificate) : e(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return b(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
