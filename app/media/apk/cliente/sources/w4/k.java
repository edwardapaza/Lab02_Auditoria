package w4;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    static j f8308a;

    /* renamed from: b  reason: collision with root package name */
    static long f8309b;

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar) {
        if (jVar.f8306f != null || jVar.f8307g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f8304d) {
            return;
        }
        synchronized (k.class) {
            long j5 = f8309b;
            if (j5 + 8192 > 65536) {
                return;
            }
            f8309b = j5 + 8192;
            jVar.f8306f = f8308a;
            jVar.f8303c = 0;
            jVar.f8302b = 0;
            f8308a = jVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j b() {
        synchronized (k.class) {
            j jVar = f8308a;
            if (jVar != null) {
                f8308a = jVar.f8306f;
                jVar.f8306f = null;
                f8309b -= 8192;
                return jVar;
            }
            return new j();
        }
    }
}
