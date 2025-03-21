package k1;

import java.lang.annotation.Annotation;
/* loaded from: classes.dex */
public final class f0<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? extends Annotation> f5568a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<T> f5569b;

    /* loaded from: classes.dex */
    private @interface a {
    }

    public f0(Class<? extends Annotation> cls, Class<T> cls2) {
        this.f5568a = cls;
        this.f5569b = cls2;
    }

    public static <T> f0<T> a(Class<? extends Annotation> cls, Class<T> cls2) {
        return new f0<>(cls, cls2);
    }

    public static <T> f0<T> b(Class<T> cls) {
        return new f0<>(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f0.class != obj.getClass()) {
            return false;
        }
        f0 f0Var = (f0) obj;
        if (this.f5569b.equals(f0Var.f5569b)) {
            return this.f5568a.equals(f0Var.f5568a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f5569b.hashCode() * 31) + this.f5568a.hashCode();
    }

    public String toString() {
        if (this.f5568a == a.class) {
            return this.f5569b.getName();
        }
        return "@" + this.f5568a.getName() + " " + this.f5569b.getName();
    }
}
