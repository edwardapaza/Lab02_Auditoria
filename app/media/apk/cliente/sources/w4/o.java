package w4;

import java.io.InterruptedIOException;
/* loaded from: classes.dex */
public class o {

    /* renamed from: d  reason: collision with root package name */
    public static final o f8312d = new a();

    /* renamed from: a  reason: collision with root package name */
    private boolean f8313a;

    /* renamed from: b  reason: collision with root package name */
    private long f8314b;

    /* renamed from: c  reason: collision with root package name */
    private long f8315c;

    /* loaded from: classes.dex */
    final class a extends o {
        a() {
        }

        @Override // w4.o
        public void c() {
        }
    }

    public long a() {
        if (this.f8313a) {
            return this.f8314b;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean b() {
        return this.f8313a;
    }

    public void c() {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f8313a && this.f8314b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public long d() {
        return this.f8315c;
    }
}
