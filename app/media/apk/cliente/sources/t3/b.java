package t3;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public abstract class b<T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    private q0 f7606a = q0.NotReady;

    /* renamed from: b  reason: collision with root package name */
    private T f7607b;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7608a;

        static {
            int[] iArr = new int[q0.values().length];
            try {
                iArr[q0.Done.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[q0.Ready.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f7608a = iArr;
        }
    }

    private final boolean e() {
        this.f7606a = q0.Failed;
        b();
        return this.f7606a == q0.Ready;
    }

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        this.f7606a = q0.Done;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(T t5) {
        this.f7607b = t5;
        this.f7606a = q0.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        q0 q0Var = this.f7606a;
        if (q0Var != q0.Failed) {
            int i5 = a.f7608a[q0Var.ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    return e();
                }
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.f7606a = q0.NotReady;
            return this.f7607b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
