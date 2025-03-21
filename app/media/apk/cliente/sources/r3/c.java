package r3;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final a f7174a;

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r1 = 0
            java.lang.String r2 = "io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> Lb
            r3 = r1
            goto Le
        Lb:
            r2 = move-exception
            r3 = r2
            r2 = r1
        Le:
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L31
            java.lang.Class<r3.a> r6 = r3.a.class
            java.lang.Class r2 = r2.asSubclass(r6)     // Catch: java.lang.Throwable -> L2f
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> L2f
            java.lang.Class<r3.d> r7 = r3.d.class
            r6[r4] = r7     // Catch: java.lang.Throwable -> L2f
            java.lang.reflect.Constructor r2 = r2.getConstructor(r6)     // Catch: java.lang.Throwable -> L2f
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L2f
            r3.d r7 = r3.a.f7171a     // Catch: java.lang.Throwable -> L2f
            r6[r4] = r7     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r2 = r2.newInstance(r6)     // Catch: java.lang.Throwable -> L2f
            r3.a r2 = (r3.a) r2     // Catch: java.lang.Throwable -> L2f
            goto L32
        L2f:
            r2 = move-exception
            r3 = r2
        L31:
            r2 = r1
        L32:
            if (r2 == 0) goto L35
            goto L3c
        L35:
            r3.a r2 = new r3.a
            r3.d r6 = r3.a.f7171a
            r2.<init>(r6)
        L3c:
            r3.c.f7174a = r2
            if (r3 == 0) goto L95
            java.lang.String r2 = "io.perfmark.PerfMark.debug"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch: java.lang.Throwable -> L95
            if (r2 == 0) goto L95
            java.lang.String r2 = "java.util.logging.Logger"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L95
            java.lang.String r6 = "getLogger"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> L95
            r7[r4] = r0     // Catch: java.lang.Throwable -> L95
            java.lang.reflect.Method r6 = r2.getMethod(r6, r7)     // Catch: java.lang.Throwable -> L95
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L95
            java.lang.Class<r3.c> r8 = r3.c.class
            java.lang.String r8 = r8.getName()     // Catch: java.lang.Throwable -> L95
            r7[r4] = r8     // Catch: java.lang.Throwable -> L95
            java.lang.Object r6 = r6.invoke(r1, r7)     // Catch: java.lang.Throwable -> L95
            java.lang.String r7 = "java.util.logging.Level"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch: java.lang.Throwable -> L95
            java.lang.String r8 = "FINE"
            java.lang.reflect.Field r8 = r7.getField(r8)     // Catch: java.lang.Throwable -> L95
            java.lang.Object r1 = r8.get(r1)     // Catch: java.lang.Throwable -> L95
            java.lang.String r8 = "log"
            r9 = 3
            java.lang.Class[] r10 = new java.lang.Class[r9]     // Catch: java.lang.Throwable -> L95
            r10[r4] = r7     // Catch: java.lang.Throwable -> L95
            r10[r5] = r0     // Catch: java.lang.Throwable -> L95
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            r7 = 2
            r10[r7] = r0     // Catch: java.lang.Throwable -> L95
            java.lang.reflect.Method r0 = r2.getMethod(r8, r10)     // Catch: java.lang.Throwable -> L95
            java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch: java.lang.Throwable -> L95
            r2[r4] = r1     // Catch: java.lang.Throwable -> L95
            java.lang.String r1 = "Error during PerfMark.<clinit>"
            r2[r5] = r1     // Catch: java.lang.Throwable -> L95
            r2[r7] = r3     // Catch: java.lang.Throwable -> L95
            r0.invoke(r6, r2)     // Catch: java.lang.Throwable -> L95
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.c.<clinit>():void");
    }

    private c() {
    }

    public static void a(d dVar) {
        f7174a.a(dVar);
    }

    public static d b(String str) {
        return f7174a.b(str, Long.MIN_VALUE);
    }

    public static d c(String str, long j5) {
        return f7174a.b(str, j5);
    }

    public static void d(String str, d dVar) {
        f7174a.c(str, dVar);
    }

    public static void e(b bVar) {
        f7174a.d(bVar);
    }

    public static b f() {
        return f7174a.e();
    }

    public static void g() {
        f7174a.g();
    }

    public static e h(String str) {
        f7174a.f(str);
        return e.f7177a;
    }
}
