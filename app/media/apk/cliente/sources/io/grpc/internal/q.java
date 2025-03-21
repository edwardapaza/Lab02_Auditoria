package io.grpc.internal;

import i3.e0;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: f  reason: collision with root package name */
    static final Logger f5098f = Logger.getLogger(i3.f.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final Object f5099a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final i3.j0 f5100b;

    /* renamed from: c  reason: collision with root package name */
    private final Collection<i3.e0> f5101c;

    /* renamed from: d  reason: collision with root package name */
    private final long f5102d;

    /* renamed from: e  reason: collision with root package name */
    private int f5103e;

    /* loaded from: classes.dex */
    class a extends ArrayDeque<i3.e0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f5104a;

        a(int i5) {
            this.f5104a = i5;
        }

        @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
        /* renamed from: k */
        public boolean add(i3.e0 e0Var) {
            if (size() == this.f5104a) {
                removeFirst();
            }
            q.a(q.this);
            return super.add(e0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5106a;

        static {
            int[] iArr = new int[e0.b.values().length];
            f5106a = iArr;
            try {
                iArr[e0.b.CT_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5106a[e0.b.CT_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(i3.j0 j0Var, int i5, long j5, String str) {
        z0.k.o(str, "description");
        this.f5100b = (i3.j0) z0.k.o(j0Var, "logId");
        this.f5101c = i5 > 0 ? new a(i5) : null;
        this.f5102d = j5;
        e0.a aVar = new e0.a();
        e(aVar.b(str + " created").c(e0.b.CT_INFO).e(j5).a());
    }

    static /* synthetic */ int a(q qVar) {
        int i5 = qVar.f5103e;
        qVar.f5103e = i5 + 1;
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(i3.j0 j0Var, Level level, String str) {
        Logger logger = f5098f;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + j0Var + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i3.j0 b() {
        return this.f5100b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        boolean z4;
        synchronized (this.f5099a) {
            z4 = this.f5101c != null;
        }
        return z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(i3.e0 e0Var) {
        int i5 = b.f5106a[e0Var.f3393b.ordinal()];
        Level level = i5 != 1 ? i5 != 2 ? Level.FINEST : Level.FINER : Level.FINE;
        f(e0Var);
        d(this.f5100b, level, e0Var.f3392a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(i3.e0 e0Var) {
        synchronized (this.f5099a) {
            Collection<i3.e0> collection = this.f5101c;
            if (collection != null) {
                collection.add(e0Var);
            }
        }
    }
}
