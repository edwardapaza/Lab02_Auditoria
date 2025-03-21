package w4;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class a extends o {

    /* renamed from: h  reason: collision with root package name */
    private static final long f8268h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f8269i;

    /* renamed from: j  reason: collision with root package name */
    static a f8270j;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8271e;

    /* renamed from: f  reason: collision with root package name */
    private a f8272f;

    /* renamed from: g  reason: collision with root package name */
    private long f8273g;

    /* renamed from: w4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0125a implements m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f8274a;

        C0125a(m mVar) {
            this.f8274a = mVar;
        }

        @Override // w4.m
        public void Z(w4.c cVar, long j5) {
            p.b(cVar.f8282b, 0L, j5);
            while (true) {
                long j6 = 0;
                if (j5 <= 0) {
                    return;
                }
                j jVar = cVar.f8281a;
                while (true) {
                    if (j6 >= 65536) {
                        break;
                    }
                    j6 += jVar.f8303c - jVar.f8302b;
                    if (j6 >= j5) {
                        j6 = j5;
                        break;
                    }
                    jVar = jVar.f8306f;
                }
                a.this.g();
                try {
                    try {
                        this.f8274a.Z(cVar, j6);
                        j5 -= j6;
                        a.this.i(true);
                    } catch (IOException e5) {
                        throw a.this.h(e5);
                    }
                } catch (Throwable th) {
                    a.this.i(false);
                    throw th;
                }
            }
        }

        @Override // w4.m, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a.this.g();
            try {
                try {
                    this.f8274a.close();
                    a.this.i(true);
                } catch (IOException e5) {
                    throw a.this.h(e5);
                }
            } catch (Throwable th) {
                a.this.i(false);
                throw th;
            }
        }

        @Override // w4.m, java.io.Flushable
        public void flush() {
            a.this.g();
            try {
                try {
                    this.f8274a.flush();
                    a.this.i(true);
                } catch (IOException e5) {
                    throw a.this.h(e5);
                }
            } catch (Throwable th) {
                a.this.i(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f8274a + ")";
        }
    }

    /* loaded from: classes.dex */
    class b implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f8276a;

        b(n nVar) {
            this.f8276a = nVar;
        }

        @Override // w4.n, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a.this.g();
            try {
                try {
                    this.f8276a.close();
                    a.this.i(true);
                } catch (IOException e5) {
                    throw a.this.h(e5);
                }
            } catch (Throwable th) {
                a.this.i(false);
                throw th;
            }
        }

        @Override // w4.n
        public long s(w4.c cVar, long j5) {
            a.this.g();
            try {
                try {
                    long s5 = this.f8276a.s(cVar, j5);
                    a.this.i(true);
                    return s5;
                } catch (IOException e5) {
                    throw a.this.h(e5);
                }
            } catch (Throwable th) {
                a.this.i(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f8276a + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
            r1.p();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<w4.a> r0 = w4.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                w4.a r1 = w4.a.e()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                w4.a r2 = w4.a.f8270j     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                w4.a.f8270j = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.p()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: w4.a.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f8268h = millis;
        f8269i = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    static a e() {
        a aVar = f8270j.f8272f;
        long nanoTime = System.nanoTime();
        if (aVar == null) {
            a.class.wait(f8268h);
            if (f8270j.f8272f != null || System.nanoTime() - nanoTime < f8269i) {
                return null;
            }
            return f8270j;
        }
        long l5 = aVar.l(nanoTime);
        if (l5 > 0) {
            long j5 = l5 / 1000000;
            a.class.wait(j5, (int) (l5 - (1000000 * j5)));
            return null;
        }
        f8270j.f8272f = aVar.f8272f;
        aVar.f8272f = null;
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
        r1.f8272f = r3.f8272f;
        r3.f8272f = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized boolean f(w4.a r3) {
        /*
            java.lang.Class<w4.a> r0 = w4.a.class
            monitor-enter(r0)
            w4.a r1 = w4.a.f8270j     // Catch: java.lang.Throwable -> L19
        L5:
            if (r1 == 0) goto L17
            w4.a r2 = r1.f8272f     // Catch: java.lang.Throwable -> L19
            if (r2 != r3) goto L15
            w4.a r2 = r3.f8272f     // Catch: java.lang.Throwable -> L19
            r1.f8272f = r2     // Catch: java.lang.Throwable -> L19
            r1 = 0
            r3.f8272f = r1     // Catch: java.lang.Throwable -> L19
            r3 = 0
        L13:
            monitor-exit(r0)
            return r3
        L15:
            r1 = r2
            goto L5
        L17:
            r3 = 1
            goto L13
        L19:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.a.f(w4.a):boolean");
    }

    private long l(long j5) {
        return this.f8273g - j5;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005a A[Catch: all -> 0x0065, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x0016, B:10:0x0022, B:11:0x002b, B:16:0x003a, B:17:0x0040, B:19:0x0044, B:22:0x004d, B:23:0x0050, B:25:0x005a, B:15:0x0034, B:28:0x005f, B:29:0x0064), top: B:33:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized void m(w4.a r6, long r7, boolean r9) {
        /*
            java.lang.Class<w4.a> r0 = w4.a.class
            monitor-enter(r0)
            w4.a r1 = w4.a.f8270j     // Catch: java.lang.Throwable -> L65
            if (r1 != 0) goto L16
            w4.a r1 = new w4.a     // Catch: java.lang.Throwable -> L65
            r1.<init>()     // Catch: java.lang.Throwable -> L65
            w4.a.f8270j = r1     // Catch: java.lang.Throwable -> L65
            w4.a$c r1 = new w4.a$c     // Catch: java.lang.Throwable -> L65
            r1.<init>()     // Catch: java.lang.Throwable -> L65
            r1.start()     // Catch: java.lang.Throwable -> L65
        L16:
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L65
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L2f
            if (r9 == 0) goto L2f
            long r3 = r6.a()     // Catch: java.lang.Throwable -> L65
            long r3 = r3 - r1
            long r7 = java.lang.Math.min(r7, r3)     // Catch: java.lang.Throwable -> L65
        L2b:
            long r7 = r7 + r1
            r6.f8273g = r7     // Catch: java.lang.Throwable -> L65
            goto L3a
        L2f:
            if (r5 == 0) goto L32
            goto L2b
        L32:
            if (r9 == 0) goto L5f
            long r7 = r6.a()     // Catch: java.lang.Throwable -> L65
            r6.f8273g = r7     // Catch: java.lang.Throwable -> L65
        L3a:
            long r7 = r6.l(r1)     // Catch: java.lang.Throwable -> L65
            w4.a r9 = w4.a.f8270j     // Catch: java.lang.Throwable -> L65
        L40:
            w4.a r3 = r9.f8272f     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L50
            long r3 = r3.l(r1)     // Catch: java.lang.Throwable -> L65
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L4d
            goto L50
        L4d:
            w4.a r9 = r9.f8272f     // Catch: java.lang.Throwable -> L65
            goto L40
        L50:
            w4.a r7 = r9.f8272f     // Catch: java.lang.Throwable -> L65
            r6.f8272f = r7     // Catch: java.lang.Throwable -> L65
            r9.f8272f = r6     // Catch: java.lang.Throwable -> L65
            w4.a r6 = w4.a.f8270j     // Catch: java.lang.Throwable -> L65
            if (r9 != r6) goto L5d
            r0.notify()     // Catch: java.lang.Throwable -> L65
        L5d:
            monitor-exit(r0)
            return
        L5f:
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L65
            r6.<init>()     // Catch: java.lang.Throwable -> L65
            throw r6     // Catch: java.lang.Throwable -> L65
        L65:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.a.m(w4.a, long, boolean):void");
    }

    public final void g() {
        if (this.f8271e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long d5 = d();
        boolean b5 = b();
        if (d5 != 0 || b5) {
            this.f8271e = true;
            m(this, d5, b5);
        }
    }

    final IOException h(IOException iOException) {
        return !j() ? iOException : k(iOException);
    }

    final void i(boolean z4) {
        if (j() && z4) {
            throw k(null);
        }
    }

    public final boolean j() {
        if (this.f8271e) {
            this.f8271e = false;
            return f(this);
        }
        return false;
    }

    protected IOException k(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final m n(m mVar) {
        return new C0125a(mVar);
    }

    public final n o(n nVar) {
        return new b(nVar);
    }

    protected void p() {
    }
}
