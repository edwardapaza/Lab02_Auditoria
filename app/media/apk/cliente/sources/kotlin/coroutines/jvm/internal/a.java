package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import s3.m;
import s3.n;
import s3.t;
/* loaded from: classes.dex */
public abstract class a implements v3.d<Object>, e, Serializable {
    private final v3.d<Object> completion;

    public a(v3.d<Object> dVar) {
        this.completion = dVar;
    }

    public v3.d<t> create(Object obj, v3.d<?> dVar) {
        e4.k.e(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public v3.d<t> create(v3.d<?> dVar) {
        e4.k.e(dVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public e getCallerFrame() {
        v3.d<Object> dVar = this.completion;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    public final v3.d<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // v3.d
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        Object c5;
        v3.d dVar = this;
        while (true) {
            h.b(dVar);
            a aVar = (a) dVar;
            v3.d dVar2 = aVar.completion;
            e4.k.b(dVar2);
            try {
                invokeSuspend = aVar.invokeSuspend(obj);
                c5 = w3.d.c();
            } catch (Throwable th) {
                m.a aVar2 = m.f7565b;
                obj = m.b(n.a(th));
            }
            if (invokeSuspend == c5) {
                return;
            }
            obj = m.b(invokeSuspend);
            aVar.releaseIntercepted();
            if (!(dVar2 instanceof a)) {
                dVar2.resumeWith(obj);
                return;
            }
            dVar = dVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }
}
