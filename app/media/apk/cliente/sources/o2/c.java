package o2;

import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import z2.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements z2.b, o2.d {

    /* renamed from: a  reason: collision with root package name */
    private final FlutterJNI f6758a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, d> f6759b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<a>> f6760c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f6761d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f6762e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Integer, b.InterfaceC0139b> f6763f;

    /* renamed from: g  reason: collision with root package name */
    private int f6764g;

    /* renamed from: h  reason: collision with root package name */
    private final b f6765h;

    /* renamed from: i  reason: collision with root package name */
    private WeakHashMap<b.c, b> f6766i;

    /* renamed from: j  reason: collision with root package name */
    private f f6767j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f6768a;

        /* renamed from: b  reason: collision with root package name */
        int f6769b;

        /* renamed from: c  reason: collision with root package name */
        long f6770c;

        a(ByteBuffer byteBuffer, int i5, long j5) {
            this.f6768a = byteBuffer;
            this.f6769b = i5;
            this.f6770c = j5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(Runnable runnable);
    }

    /* renamed from: o2.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0104c implements f {

        /* renamed from: a  reason: collision with root package name */
        ExecutorService f6771a = n2.a.e().b();

        C0104c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final b.a f6772a;

        /* renamed from: b  reason: collision with root package name */
        public final b f6773b;

        d(b.a aVar, b bVar) {
            this.f6772a = aVar;
            this.f6773b = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e implements b.InterfaceC0139b {

        /* renamed from: a  reason: collision with root package name */
        private final FlutterJNI f6774a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6775b;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicBoolean f6776c = new AtomicBoolean(false);

        e(FlutterJNI flutterJNI, int i5) {
            this.f6774a = flutterJNI;
            this.f6775b = i5;
        }

        @Override // z2.b.InterfaceC0139b
        public void a(ByteBuffer byteBuffer) {
            if (this.f6776c.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            if (byteBuffer == null) {
                this.f6774a.invokePlatformMessageEmptyResponseCallback(this.f6775b);
            } else {
                this.f6774a.invokePlatformMessageResponseCallback(this.f6775b, byteBuffer, byteBuffer.position());
            }
        }
    }

    /* loaded from: classes.dex */
    interface f {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FlutterJNI flutterJNI) {
        this(flutterJNI, new C0104c());
    }

    c(FlutterJNI flutterJNI, f fVar) {
        this.f6759b = new HashMap();
        this.f6760c = new HashMap();
        this.f6761d = new Object();
        this.f6762e = new AtomicBoolean(false);
        this.f6763f = new HashMap();
        this.f6764g = 1;
        this.f6765h = new o2.e();
        this.f6766i = new WeakHashMap<>();
        this.f6758a = flutterJNI;
        this.f6767j = fVar;
    }

    private void h(final String str, final d dVar, final ByteBuffer byteBuffer, final int i5, final long j5) {
        b bVar = dVar != null ? dVar.f6773b : null;
        h3.e.d("PlatformChannel ScheduleHandler on " + str, i5);
        Runnable runnable = new Runnable() { // from class: o2.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.k(str, i5, dVar, byteBuffer, j5);
            }
        };
        if (bVar == null) {
            bVar = this.f6765h;
        }
        bVar.a(runnable);
    }

    private static void i(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() == null) {
            throw error;
        }
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
    }

    private void j(d dVar, ByteBuffer byteBuffer, int i5) {
        if (dVar != null) {
            try {
                n2.b.f("DartMessenger", "Deferring to registered handler to process message.");
                dVar.f6772a.a(byteBuffer, new e(this.f6758a, i5));
                return;
            } catch (Error e5) {
                i(e5);
                return;
            } catch (Exception e6) {
                n2.b.c("DartMessenger", "Uncaught exception in binary message listener", e6);
            }
        } else {
            n2.b.f("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
        }
        this.f6758a.invokePlatformMessageEmptyResponseCallback(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(String str, int i5, d dVar, ByteBuffer byteBuffer, long j5) {
        h3.e.i("PlatformChannel ScheduleHandler on " + str, i5);
        try {
            h3.e j6 = h3.e.j("DartMessenger#handleMessageFromDart on " + str);
            j(dVar, byteBuffer, i5);
            if (byteBuffer != null && byteBuffer.isDirect()) {
                byteBuffer.limit(0);
            }
            if (j6 != null) {
                j6.close();
            }
        } finally {
            this.f6758a.cleanupMessageData(j5);
        }
    }

    @Override // z2.b
    public void a(String str, ByteBuffer byteBuffer, b.InterfaceC0139b interfaceC0139b) {
        h3.e j5 = h3.e.j("DartMessenger#send on " + str);
        try {
            n2.b.f("DartMessenger", "Sending message with callback over channel '" + str + "'");
            int i5 = this.f6764g;
            this.f6764g = i5 + 1;
            if (interfaceC0139b != null) {
                this.f6763f.put(Integer.valueOf(i5), interfaceC0139b);
            }
            if (byteBuffer == null) {
                this.f6758a.dispatchEmptyPlatformMessage(str, i5);
            } else {
                this.f6758a.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i5);
            }
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // z2.b
    public void b(String str, b.a aVar) {
        e(str, aVar, null);
    }

    @Override // z2.b
    public void c(String str, ByteBuffer byteBuffer) {
        n2.b.f("DartMessenger", "Sending message over channel '" + str + "'");
        a(str, byteBuffer, null);
    }

    @Override // o2.d
    public void d(int i5, ByteBuffer byteBuffer) {
        n2.b.f("DartMessenger", "Received message reply from Dart.");
        b.InterfaceC0139b remove = this.f6763f.remove(Integer.valueOf(i5));
        if (remove != null) {
            try {
                n2.b.f("DartMessenger", "Invoking registered callback for reply from Dart.");
                remove.a(byteBuffer);
                if (byteBuffer == null || !byteBuffer.isDirect()) {
                    return;
                }
                byteBuffer.limit(0);
            } catch (Error e5) {
                i(e5);
            } catch (Exception e6) {
                n2.b.c("DartMessenger", "Uncaught exception in binary message reply handler", e6);
            }
        }
    }

    @Override // z2.b
    public void e(String str, b.a aVar, b.c cVar) {
        if (aVar == null) {
            n2.b.f("DartMessenger", "Removing handler for channel '" + str + "'");
            synchronized (this.f6761d) {
                this.f6759b.remove(str);
            }
            return;
        }
        b bVar = null;
        if (cVar != null && (bVar = this.f6766i.get(cVar)) == null) {
            throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
        }
        n2.b.f("DartMessenger", "Setting handler for channel '" + str + "'");
        synchronized (this.f6761d) {
            this.f6759b.put(str, new d(aVar, bVar));
            List<a> remove = this.f6760c.remove(str);
            if (remove == null) {
                return;
            }
            for (a aVar2 : remove) {
                h(str, this.f6759b.get(str), aVar2.f6768a, aVar2.f6769b, aVar2.f6770c);
            }
        }
    }

    @Override // o2.d
    public void f(String str, ByteBuffer byteBuffer, int i5, long j5) {
        d dVar;
        boolean z4;
        n2.b.f("DartMessenger", "Received message from Dart over channel '" + str + "'");
        synchronized (this.f6761d) {
            dVar = this.f6759b.get(str);
            z4 = this.f6762e.get() && dVar == null;
            if (z4) {
                if (!this.f6760c.containsKey(str)) {
                    this.f6760c.put(str, new LinkedList());
                }
                this.f6760c.get(str).add(new a(byteBuffer, i5, j5));
            }
        }
        if (z4) {
            return;
        }
        h(str, dVar, byteBuffer, i5, j5);
    }
}
