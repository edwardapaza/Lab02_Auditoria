package k4;

import java.io.Serializable;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class e implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f5847b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Pattern f5848a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            e4.k.e(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(pattern)"
            e4.k.d(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.e.<init>(java.lang.String):void");
    }

    public e(Pattern pattern) {
        e4.k.e(pattern, "nativePattern");
        this.f5848a = pattern;
    }

    public final boolean a(CharSequence charSequence) {
        e4.k.e(charSequence, "input");
        return this.f5848a.matcher(charSequence).matches();
    }

    public String toString() {
        String pattern = this.f5848a.toString();
        e4.k.d(pattern, "nativePattern.toString()");
        return pattern;
    }
}
