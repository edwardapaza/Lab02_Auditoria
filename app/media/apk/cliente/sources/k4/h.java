package k4;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends g {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends e4.l implements d4.l<String, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f5849a = new a();

        a() {
            super(1);
        }

        @Override // d4.l
        /* renamed from: a */
        public final String invoke(String str) {
            e4.k.e(str, "line");
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends e4.l implements d4.l<String, String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f5850a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f5850a = str;
        }

        @Override // d4.l
        /* renamed from: a */
        public final String invoke(String str) {
            e4.k.e(str, "line");
            return this.f5850a + str;
        }
    }

    private static final d4.l<String, String> b(String str) {
        return str.length() == 0 ? a.f5849a : new b(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                i5 = -1;
                break;
            } else if (!k4.a.c(str.charAt(i5))) {
                break;
            } else {
                i5++;
            }
        }
        return i5 == -1 ? str.length() : i5;
    }

    public static final String d(String str, String str2) {
        String invoke;
        e4.k.e(str, "<this>");
        e4.k.e(str2, "newIndent");
        List<String> E = p.E(str);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : E) {
            if (!f.h((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(t3.n.k(arrayList, 10));
        for (String str3 : arrayList) {
            arrayList2.add(Integer.valueOf(c(str3)));
        }
        Integer num = (Integer) t3.n.y(arrayList2);
        int i5 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * E.size());
        d4.l<String, String> b5 = b(str2);
        int g5 = t3.n.g(E);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : E) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                t3.n.j();
            }
            String str4 = (String) obj2;
            if ((i5 == 0 || i5 == g5) && f.h(str4)) {
                str4 = null;
            } else {
                String h02 = r.h0(str4, intValue);
                if (h02 != null && (invoke = b5.invoke(h02)) != null) {
                    str4 = invoke;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i5 = i6;
        }
        String sb = ((StringBuilder) t3.n.u(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        e4.k.d(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static String e(String str) {
        e4.k.e(str, "<this>");
        return d(str, "");
    }
}
