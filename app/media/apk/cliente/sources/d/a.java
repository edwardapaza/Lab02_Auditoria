package d;

import android.content.Context;
import android.content.Intent;
import e4.k;
/* loaded from: classes.dex */
public abstract class a<I, O> {

    /* renamed from: d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0046a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f2246a;

        public C0046a(T t5) {
            this.f2246a = t5;
        }

        public final T a() {
            return this.f2246a;
        }
    }

    public abstract Intent a(Context context, I i5);

    public C0046a<O> b(Context context, I i5) {
        k.e(context, "context");
        return null;
    }

    public abstract O c(int i5, Intent intent);
}
