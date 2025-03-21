package p3;

import i3.c;
import java.util.logging.Logger;
import z0.n;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f6884a = Logger.getLogger(c.class.getName());

    /* renamed from: b  reason: collision with root package name */
    static boolean f6885b;

    /* renamed from: c  reason: collision with root package name */
    static final c.C0069c<a> f6886c;

    /* loaded from: classes.dex */
    enum a {
        BLOCKING,
        FUTURE,
        ASYNC
    }

    static {
        f6885b = !n.a(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE")) && Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        f6886c = c.C0069c.b("internal-stub-type");
    }

    private c() {
    }
}
