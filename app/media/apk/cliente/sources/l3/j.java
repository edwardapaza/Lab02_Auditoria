package l3;

import java.net.ProtocolException;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final i f6021a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6022b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6023c;

    public j(i iVar, int i5, String str) {
        this.f6021a = iVar;
        this.f6022b = i5;
        this.f6023c = str;
    }

    public static j a(String str) {
        i iVar;
        String str2;
        int i5 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                iVar = i.HTTP_1_0;
            } else if (charAt != 1) {
                throw new ProtocolException("Unexpected status line: " + str);
            } else {
                iVar = i.HTTP_1_1;
            }
        } else if (!str.startsWith("ICY ")) {
            throw new ProtocolException("Unexpected status line: " + str);
        } else {
            iVar = i.HTTP_1_0;
            i5 = 4;
        }
        int i6 = i5 + 3;
        if (str.length() < i6) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i5, i6));
            if (str.length() <= i6) {
                str2 = "";
            } else if (str.charAt(i6) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            } else {
                str2 = str.substring(i5 + 4);
            }
            return new j(iVar, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6021a == i.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f6022b);
        if (this.f6023c != null) {
            sb.append(' ');
            sb.append(this.f6023c);
        }
        return sb.toString();
    }
}
