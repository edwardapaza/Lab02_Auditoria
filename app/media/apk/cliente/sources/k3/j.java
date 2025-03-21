package k3;

import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
class j {

    /* renamed from: a  reason: collision with root package name */
    private final Logger f5781a;

    /* renamed from: b  reason: collision with root package name */
    private final Level f5782b;

    /* loaded from: classes.dex */
    enum a {
        INBOUND,
        OUTBOUND
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum b {
        HEADER_TABLE_SIZE(1),
        ENABLE_PUSH(2),
        MAX_CONCURRENT_STREAMS(4),
        MAX_FRAME_SIZE(5),
        MAX_HEADER_LIST_SIZE(6),
        INITIAL_WINDOW_SIZE(7);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f5793a;

        b(int i5) {
            this.f5793a = i5;
        }

        public int a() {
            return this.f5793a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Level level, Class<?> cls) {
        this(level, Logger.getLogger(cls.getName()));
    }

    j(Level level, Logger logger) {
        this.f5782b = (Level) z0.k.o(level, "level");
        this.f5781a = (Logger) z0.k.o(logger, "logger");
    }

    private boolean a() {
        return this.f5781a.isLoggable(this.f5782b);
    }

    private static String l(m3.i iVar) {
        b[] values;
        EnumMap enumMap = new EnumMap(b.class);
        for (b bVar : b.values()) {
            if (iVar.d(bVar.a())) {
                enumMap.put((EnumMap) bVar, (b) Integer.valueOf(iVar.a(bVar.a())));
            }
        }
        return enumMap.toString();
    }

    private static String m(w4.c cVar) {
        if (cVar.size() <= 64) {
            return cVar.L().k();
        }
        int min = (int) Math.min(cVar.size(), 64L);
        return cVar.M(min).k() + "...";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a aVar, int i5, w4.c cVar, int i6, boolean z4) {
        if (a()) {
            Logger logger = this.f5781a;
            Level level = this.f5782b;
            logger.log(level, aVar + " DATA: streamId=" + i5 + " endStream=" + z4 + " length=" + i6 + " bytes=" + m(cVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(a aVar, int i5, m3.a aVar2, w4.f fVar) {
        if (a()) {
            Logger logger = this.f5781a;
            Level level = this.f5782b;
            logger.log(level, aVar + " GO_AWAY: lastStreamId=" + i5 + " errorCode=" + aVar2 + " length=" + fVar.p() + " bytes=" + m(new w4.c().O(fVar)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(a aVar, int i5, List<m3.d> list, boolean z4) {
        if (a()) {
            Logger logger = this.f5781a;
            Level level = this.f5782b;
            logger.log(level, aVar + " HEADERS: streamId=" + i5 + " headers=" + list + " endStream=" + z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(a aVar, long j5) {
        if (a()) {
            Logger logger = this.f5781a;
            Level level = this.f5782b;
            logger.log(level, aVar + " PING: ack=false bytes=" + j5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(a aVar, long j5) {
        if (a()) {
            Logger logger = this.f5781a;
            Level level = this.f5782b;
            logger.log(level, aVar + " PING: ack=true bytes=" + j5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(a aVar, int i5, int i6, List<m3.d> list) {
        if (a()) {
            Logger logger = this.f5781a;
            Level level = this.f5782b;
            logger.log(level, aVar + " PUSH_PROMISE: streamId=" + i5 + " promisedStreamId=" + i6 + " headers=" + list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(a aVar, int i5, m3.a aVar2) {
        if (a()) {
            Logger logger = this.f5781a;
            Level level = this.f5782b;
            logger.log(level, aVar + " RST_STREAM: streamId=" + i5 + " errorCode=" + aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar, m3.i iVar) {
        if (a()) {
            Logger logger = this.f5781a;
            Level level = this.f5782b;
            logger.log(level, aVar + " SETTINGS: ack=false settings=" + l(iVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        if (a()) {
            Logger logger = this.f5781a;
            Level level = this.f5782b;
            logger.log(level, aVar + " SETTINGS: ack=true");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar, int i5, long j5) {
        if (a()) {
            Logger logger = this.f5781a;
            Level level = this.f5782b;
            logger.log(level, aVar + " WINDOW_UPDATE: streamId=" + i5 + " windowSizeIncrement=" + j5);
        }
    }
}
