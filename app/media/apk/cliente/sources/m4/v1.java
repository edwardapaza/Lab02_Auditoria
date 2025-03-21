package m4;

import java.util.concurrent.CancellationException;
/* loaded from: classes.dex */
public final class v1 extends CancellationException {

    /* renamed from: a  reason: collision with root package name */
    public final transient u1 f6285a;

    public v1(String str, Throwable th, u1 u1Var) {
        super(str);
        this.f6285a = u1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof v1) {
                v1 v1Var = (v1) obj;
                if (!e4.k.a(v1Var.getMessage(), getMessage()) || !e4.k.a(v1Var.f6285a, this.f6285a) || !e4.k.a(v1Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        e4.k.b(message);
        int hashCode = ((message.hashCode() * 31) + this.f6285a.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f6285a;
    }
}
