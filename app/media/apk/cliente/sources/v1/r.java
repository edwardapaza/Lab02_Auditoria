package v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class r extends e<r> {

    /* renamed from: b  reason: collision with root package name */
    public static final r f8134b = v("__name__");

    /* renamed from: c  reason: collision with root package name */
    public static final r f8135c = new r(Collections.emptyList());

    private r(List<String> list) {
        super(list);
    }

    public static r t(List<String> list) {
        return list.isEmpty() ? f8135c : new r(list);
    }

    public static r u(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i5 = 0;
        boolean z4 = false;
        while (i5 < str.length()) {
            char charAt = str.charAt(i5);
            if (charAt == '\\') {
                i5++;
                if (i5 == str.length()) {
                    throw new IllegalArgumentException("Trailing escape character is not allowed");
                }
                charAt = str.charAt(i5);
            } else if (charAt == '.') {
                if (!z4) {
                    String sb2 = sb.toString();
                    if (sb2.isEmpty()) {
                        throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
                    }
                    StringBuilder sb3 = new StringBuilder();
                    arrayList.add(sb2);
                    sb = sb3;
                    i5++;
                }
            } else if (charAt == '`') {
                z4 = !z4;
                i5++;
            }
            sb.append(charAt);
            i5++;
        }
        String sb4 = sb.toString();
        if (!sb4.isEmpty()) {
            arrayList.add(sb4);
            return new r(arrayList);
        }
        throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
    }

    public static r v(String str) {
        return new r(Collections.singletonList(str));
    }

    private static boolean x(String str) {
        if (str.isEmpty()) {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt == '_' || ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))) {
            for (int i5 = 1; i5 < str.length(); i5++) {
                char charAt2 = str.charAt(i5);
                if (charAt2 != '_' && ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < '0' || charAt2 > '9')))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // v1.e
    public String d() {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < this.f8114a.size(); i5++) {
            if (i5 > 0) {
                sb.append(".");
            }
            String replace = this.f8114a.get(i5).replace("\\", "\\\\").replace("`", "\\`");
            if (!x(replace)) {
                replace = '`' + replace + '`';
            }
            sb.append(replace);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // v1.e
    /* renamed from: s */
    public r h(List<String> list) {
        return new r(list);
    }

    public boolean w() {
        return equals(f8134b);
    }
}
