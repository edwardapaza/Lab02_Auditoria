package z0;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f8868a;

    private e(String str) {
        this.f8868a = (String) k.n(str);
    }

    public static e e(char c5) {
        return new e(String.valueOf(c5));
    }

    public <A extends Appendable> A a(A a5, Iterator<? extends Object> it) {
        k.n(a5);
        if (it.hasNext()) {
            while (true) {
                a5.append(f(it.next()));
                if (!it.hasNext()) {
                    break;
                }
                a5.append(this.f8868a);
            }
        }
        return a5;
    }

    public final StringBuilder b(StringBuilder sb, Iterator<? extends Object> it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e5) {
            throw new AssertionError(e5);
        }
    }

    public final String c(Iterable<? extends Object> iterable) {
        return d(iterable.iterator());
    }

    public final String d(Iterator<? extends Object> it) {
        return b(new StringBuilder(), it).toString();
    }

    CharSequence f(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
