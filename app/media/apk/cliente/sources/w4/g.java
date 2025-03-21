package w4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f8289a = Logger.getLogger(g.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f8290a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OutputStream f8291b;

        a(o oVar, OutputStream outputStream) {
            this.f8290a = oVar;
            this.f8291b = outputStream;
        }

        @Override // w4.m
        public void Z(w4.c cVar, long j5) {
            p.b(cVar.f8282b, 0L, j5);
            while (j5 > 0) {
                this.f8290a.c();
                j jVar = cVar.f8281a;
                int min = (int) Math.min(j5, jVar.f8303c - jVar.f8302b);
                this.f8291b.write(jVar.f8301a, jVar.f8302b, min);
                int i5 = jVar.f8302b + min;
                jVar.f8302b = i5;
                long j6 = min;
                j5 -= j6;
                cVar.f8282b -= j6;
                if (i5 == jVar.f8303c) {
                    cVar.f8281a = jVar.b();
                    k.a(jVar);
                }
            }
        }

        @Override // w4.m, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f8291b.close();
        }

        @Override // w4.m, java.io.Flushable
        public void flush() {
            this.f8291b.flush();
        }

        public String toString() {
            return "sink(" + this.f8291b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class b implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f8292a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InputStream f8293b;

        b(o oVar, InputStream inputStream) {
            this.f8292a = oVar;
            this.f8293b = inputStream;
        }

        @Override // w4.n, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f8293b.close();
        }

        @Override // w4.n
        public long s(w4.c cVar, long j5) {
            int i5 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
            if (i5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            } else if (i5 == 0) {
                return 0L;
            } else {
                try {
                    this.f8292a.c();
                    j N = cVar.N(1);
                    int read = this.f8293b.read(N.f8301a, N.f8303c, (int) Math.min(j5, 8192 - N.f8303c));
                    if (read != -1) {
                        N.f8303c += read;
                        long j6 = read;
                        cVar.f8282b += j6;
                        return j6;
                    } else if (N.f8302b == N.f8303c) {
                        cVar.f8281a = N.b();
                        k.a(N);
                        return -1L;
                    } else {
                        return -1L;
                    }
                } catch (AssertionError e5) {
                    if (g.c(e5)) {
                        throw new IOException(e5);
                    }
                    throw e5;
                }
            }
        }

        public String toString() {
            return "source(" + this.f8293b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class c extends w4.a {

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Socket f8294k;

        c(Socket socket) {
            this.f8294k = socket;
        }

        @Override // w4.a
        protected IOException k(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // w4.a
        protected void p() {
            Level level;
            StringBuilder sb;
            Logger logger;
            Exception exc;
            try {
                this.f8294k.close();
            } catch (AssertionError e5) {
                if (!g.c(e5)) {
                    throw e5;
                }
                Logger logger2 = g.f8289a;
                level = Level.WARNING;
                sb = new StringBuilder();
                exc = e5;
                logger = logger2;
                sb.append("Failed to close timed out socket ");
                sb.append(this.f8294k);
                logger.log(level, sb.toString(), (Throwable) exc);
            } catch (Exception e6) {
                Logger logger3 = g.f8289a;
                level = Level.WARNING;
                sb = new StringBuilder();
                exc = e6;
                logger = logger3;
                sb.append("Failed to close timed out socket ");
                sb.append(this.f8294k);
                logger.log(level, sb.toString(), (Throwable) exc);
            }
        }
    }

    private g() {
    }

    public static d a(m mVar) {
        return new h(mVar);
    }

    public static e b(n nVar) {
        return new i(nVar);
    }

    static boolean c(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    private static m d(OutputStream outputStream, o oVar) {
        if (outputStream != null) {
            if (oVar != null) {
                return new a(oVar, outputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static m e(Socket socket) {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                w4.a h5 = h(socket);
                return h5.n(d(socket.getOutputStream(), h5));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static n f(InputStream inputStream, o oVar) {
        if (inputStream != null) {
            if (oVar != null) {
                return new b(oVar, inputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    public static n g(Socket socket) {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                w4.a h5 = h(socket);
                return h5.o(f(socket.getInputStream(), h5));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static w4.a h(Socket socket) {
        return new c(socket);
    }
}
