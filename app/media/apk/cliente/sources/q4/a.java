package q4;

import java.util.Arrays;
import q4.c;
import s3.m;
import s3.t;
/* loaded from: classes.dex */
public abstract class a<S extends c<?>> {

    /* renamed from: a  reason: collision with root package name */
    private S[] f7083a;

    /* renamed from: b  reason: collision with root package name */
    private int f7084b;

    /* renamed from: c  reason: collision with root package name */
    private int f7085c;

    /* JADX INFO: Access modifiers changed from: protected */
    public final S d() {
        S s5;
        synchronized (this) {
            S[] sArr = this.f7083a;
            if (sArr == null) {
                sArr = f(2);
                this.f7083a = sArr;
            } else if (this.f7084b >= sArr.length) {
                Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                e4.k.d(copyOf, "copyOf(this, newSize)");
                this.f7083a = (S[]) ((c[]) copyOf);
                sArr = (S[]) ((c[]) copyOf);
            }
            int i5 = this.f7085c;
            do {
                s5 = sArr[i5];
                if (s5 == null) {
                    s5 = e();
                    sArr[i5] = s5;
                }
                i5++;
                if (i5 >= sArr.length) {
                    i5 = 0;
                }
                e4.k.c(s5, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            } while (!s5.a(this));
            this.f7085c = i5;
            this.f7084b++;
        }
        return s5;
    }

    protected abstract S e();

    protected abstract S[] f(int i5);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(S s5) {
        int i5;
        v3.d<t>[] b5;
        synchronized (this) {
            int i6 = this.f7084b - 1;
            this.f7084b = i6;
            if (i6 == 0) {
                this.f7085c = 0;
            }
            e4.k.c(s5, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            b5 = s5.b(this);
        }
        for (v3.d<t> dVar : b5) {
            if (dVar != null) {
                m.a aVar = s3.m.f7565b;
                dVar.resumeWith(s3.m.b(t.f7573a));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final S[] h() {
        return this.f7083a;
    }
}
