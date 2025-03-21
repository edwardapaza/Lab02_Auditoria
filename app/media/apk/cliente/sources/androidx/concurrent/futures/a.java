package androidx.concurrent.futures;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public abstract class a<V> implements e1.b<V> {

    /* renamed from: d  reason: collision with root package name */
    static final boolean f228d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f229e = Logger.getLogger(a.class.getName());

    /* renamed from: f  reason: collision with root package name */
    static final b f230f;

    /* renamed from: k  reason: collision with root package name */
    private static final Object f231k;

    /* renamed from: a  reason: collision with root package name */
    volatile Object f232a;

    /* renamed from: b  reason: collision with root package name */
    volatile e f233b;

    /* renamed from: c  reason: collision with root package name */
    volatile i f234c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b {
        private b() {
        }

        abstract boolean a(a<?> aVar, e eVar, e eVar2);

        abstract boolean b(a<?> aVar, Object obj, Object obj2);

        abstract boolean c(a<?> aVar, i iVar, i iVar2);

        abstract void d(i iVar, i iVar2);

        abstract void e(i iVar, Thread thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        static final c f235c;

        /* renamed from: d  reason: collision with root package name */
        static final c f236d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f237a;

        /* renamed from: b  reason: collision with root package name */
        final Throwable f238b;

        static {
            if (a.f228d) {
                f236d = null;
                f235c = null;
                return;
            }
            f236d = new c(false, null);
            f235c = new c(true, null);
        }

        c(boolean z4, Throwable th) {
            this.f237a = z4;
            this.f238b = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: b  reason: collision with root package name */
        static final d f239b = new d(new C0011a("Failure occurred while trying to finish a future."));

        /* renamed from: a  reason: collision with root package name */
        final Throwable f240a;

        /* renamed from: androidx.concurrent.futures.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0011a extends Throwable {
            C0011a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th) {
            this.f240a = (Throwable) a.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        static final e f241d = new e(null, null);

        /* renamed from: a  reason: collision with root package name */
        final Runnable f242a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f243b;

        /* renamed from: c  reason: collision with root package name */
        e f244c;

        e(Runnable runnable, Executor executor) {
            this.f242a = runnable;
            this.f243b = executor;
        }
    }

    /* loaded from: classes.dex */
    private static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, Thread> f245a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, i> f246b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, i> f247c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, e> f248d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f249e;

        f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f245a = atomicReferenceFieldUpdater;
            this.f246b = atomicReferenceFieldUpdater2;
            this.f247c = atomicReferenceFieldUpdater3;
            this.f248d = atomicReferenceFieldUpdater4;
            this.f249e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            return androidx.concurrent.futures.b.a(this.f248d, aVar, eVar, eVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            return androidx.concurrent.futures.b.a(this.f249e, aVar, obj, obj2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            return androidx.concurrent.futures.b.a(this.f247c, aVar, iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void d(i iVar, i iVar2) {
            this.f246b.lazySet(iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void e(i iVar, Thread thread) {
            this.f245a.lazySet(iVar, thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final a<V> f250a;

        /* renamed from: b  reason: collision with root package name */
        final e1.b<? extends V> f251b;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f250a.f232a != this) {
                return;
            }
            if (a.f230f.b(this.f250a, this, a.o(this.f251b))) {
                a.k(this.f250a);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class h extends b {
        h() {
            super();
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f233b == eVar) {
                    aVar.f233b = eVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f232a == obj) {
                    aVar.f232a = obj2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f234c == iVar) {
                    aVar.f234c = iVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.concurrent.futures.a.b
        void d(i iVar, i iVar2) {
            iVar.f254b = iVar2;
        }

        @Override // androidx.concurrent.futures.a.b
        void e(i iVar, Thread thread) {
            iVar.f253a = thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class i {

        /* renamed from: c  reason: collision with root package name */
        static final i f252c = new i(false);

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f253a;

        /* renamed from: b  reason: collision with root package name */
        volatile i f254b;

        i() {
            a.f230f.e(this, Thread.currentThread());
        }

        i(boolean z4) {
        }

        void a(i iVar) {
            a.f230f.d(this, iVar);
        }

        void b() {
            Thread thread = this.f253a;
            if (thread != null) {
                this.f253a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        f230f = hVar;
        if (th != null) {
            f229e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f231k = new Object();
    }

    private void a(StringBuilder sb) {
        String str = "]";
        try {
            Object p5 = p(this);
            sb.append("SUCCESS, result=[");
            sb.append(w(p5));
            sb.append("]");
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (RuntimeException e5) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e5.getClass());
            str = " thrown from get()]";
            sb.append(str);
        } catch (ExecutionException e6) {
            sb.append("FAILURE, cause=[");
            sb.append(e6.getCause());
            sb.append(str);
        }
    }

    private static CancellationException d(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T e(T t5) {
        t5.getClass();
        return t5;
    }

    private e h(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f233b;
        } while (!f230f.a(this, eVar2, e.f241d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f244c;
            eVar4.f244c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.concurrent.futures.a$b] */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.concurrent.futures.a<?>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.concurrent.futures.a] */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.concurrent.futures.a<V>, androidx.concurrent.futures.a] */
    static void k(a<?> aVar) {
        e eVar = null;
        while (true) {
            aVar.s();
            aVar.c();
            e h5 = aVar.h(eVar);
            while (h5 != null) {
                eVar = h5.f244c;
                Runnable runnable = h5.f242a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f250a;
                    if (aVar.f232a == gVar) {
                        if (f230f.b(aVar, gVar, o(gVar.f251b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    m(runnable, h5.f243b);
                }
                h5 = eVar;
            }
            return;
        }
    }

    private static void m(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e5) {
            Logger logger = f229e;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V n(Object obj) {
        if (obj instanceof c) {
            throw d("Task was cancelled.", ((c) obj).f238b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f240a);
        }
        if (obj == f231k) {
            return null;
        }
        return obj;
    }

    static Object o(e1.b<?> bVar) {
        if (bVar instanceof a) {
            Object obj = ((a) bVar).f232a;
            if (obj instanceof c) {
                c cVar = (c) obj;
                return cVar.f237a ? cVar.f238b != null ? new c(false, cVar.f238b) : c.f236d : obj;
            }
            return obj;
        }
        boolean isCancelled = bVar.isCancelled();
        if ((!f228d) && isCancelled) {
            return c.f236d;
        }
        try {
            Object p5 = p(bVar);
            return p5 == null ? f231k : p5;
        } catch (CancellationException e5) {
            if (isCancelled) {
                return new c(false, e5);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + bVar, e5));
        } catch (ExecutionException e6) {
            return new d(e6.getCause());
        } catch (Throwable th) {
            return new d(th);
        }
    }

    static <V> V p(Future<V> future) {
        V v5;
        boolean z4 = false;
        while (true) {
            try {
                v5 = future.get();
                break;
            } catch (InterruptedException unused) {
                z4 = true;
            } catch (Throwable th) {
                if (z4) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
        return v5;
    }

    private void s() {
        i iVar;
        do {
            iVar = this.f234c;
        } while (!f230f.c(this, iVar, i.f252c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f254b;
        }
    }

    private void t(i iVar) {
        iVar.f253a = null;
        while (true) {
            i iVar2 = this.f234c;
            if (iVar2 == i.f252c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f254b;
                if (iVar2.f253a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f254b = iVar4;
                    if (iVar3.f253a == null) {
                        break;
                    }
                } else if (!f230f.c(this, iVar2, iVar4)) {
                    break;
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    private String w(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    protected void c() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z4) {
        Object obj = this.f232a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f228d ? new c(z4, new CancellationException("Future.cancel() was called.")) : z4 ? c.f235c : c.f236d;
        boolean z5 = false;
        a<V> aVar = this;
        while (true) {
            if (f230f.b(aVar, obj, cVar)) {
                if (z4) {
                    aVar.q();
                }
                k(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                e1.b<? extends V> bVar = ((g) obj).f251b;
                if (!(bVar instanceof a)) {
                    bVar.cancel(z4);
                    return true;
                }
                aVar = (a) bVar;
                obj = aVar.f232a;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z5 = true;
            } else {
                obj = aVar.f232a;
                if (!(obj instanceof g)) {
                    return z5;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f232a;
        if ((obj2 != null) && (!(obj2 instanceof g))) {
            return n(obj2);
        }
        i iVar = this.f234c;
        if (iVar != i.f252c) {
            i iVar2 = new i();
            do {
                iVar2.a(iVar);
                if (f230f.c(this, iVar, iVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            t(iVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f232a;
                    } while (!((obj != null) & (!(obj instanceof g))));
                    return n(obj);
                }
                iVar = this.f234c;
            } while (iVar != i.f252c);
            return n(this.f232a);
        }
        return n(this.f232a);
    }

    @Override // java.util.concurrent.Future
    public final V get(long j5, TimeUnit timeUnit) {
        Locale locale;
        long nanos = timeUnit.toNanos(j5);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f232a;
        if ((obj != null) && (!(obj instanceof g))) {
            return n(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.f234c;
            if (iVar != i.f252c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f230f.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                t(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f232a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return n(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        t(iVar2);
                    } else {
                        iVar = this.f234c;
                    }
                } while (iVar != i.f252c);
                return n(this.f232a);
            }
            return n(this.f232a);
        }
        while (nanos > 0) {
            Object obj3 = this.f232a;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
                return n(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String aVar = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String str = "Waited " + j5 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j6 = -nanos;
            long convert = timeUnit.convert(j6, TimeUnit.NANOSECONDS);
            long nanos2 = j6 - timeUnit.toNanos(convert);
            int i5 = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
            boolean z4 = i5 == 0 || nanos2 > 1000;
            if (i5 > 0) {
                String str3 = str2 + convert + " " + lowerCase;
                if (z4) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z4) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + aVar);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f232a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f232a;
        return (!(obj instanceof g)) & (obj != null);
    }

    protected void q() {
    }

    protected String r() {
        Object obj = this.f232a;
        if (obj instanceof g) {
            return "setFuture=[" + w(((g) obj).f251b) + "]";
        } else if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        } else {
            return null;
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (!isCancelled()) {
            if (!isDone()) {
                try {
                    str = r();
                } catch (RuntimeException e5) {
                    str = "Exception thrown from implementation: " + e5.getClass();
                }
                if (str != null && !str.isEmpty()) {
                    sb.append("PENDING, info=[");
                    sb.append(str);
                    sb.append("]");
                    sb.append("]");
                    return sb.toString();
                }
                str2 = isDone() ? "PENDING" : "PENDING";
            }
            a(sb);
            sb.append("]");
            return sb.toString();
        }
        str2 = "CANCELLED";
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u(V v5) {
        if (v5 == null) {
            v5 = (V) f231k;
        }
        if (f230f.b(this, null, v5)) {
            k(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean v(Throwable th) {
        if (f230f.b(this, null, new d((Throwable) e(th)))) {
            k(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean x() {
        Object obj = this.f232a;
        return (obj instanceof c) && ((c) obj).f237a;
    }
}
