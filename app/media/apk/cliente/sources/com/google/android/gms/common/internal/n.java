package com.google.android.gms.common.internal;

import java.util.concurrent.ConcurrentHashMap;
@Deprecated
/* loaded from: classes.dex */
public class n {

    /* renamed from: b  reason: collision with root package name */
    private static final i f1173b = new i("LibraryVersion", "");

    /* renamed from: c  reason: collision with root package name */
    private static final n f1174c = new n();

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap f1175a = new ConcurrentHashMap();

    protected n() {
    }

    public static n a() {
        return f1174c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String b(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "Failed to get app version for libraryName: "
            java.lang.String r1 = "LibraryVersion"
            java.lang.String r2 = "Please provide a valid libraryName"
            com.google.android.gms.common.internal.q.f(r9, r2)
            java.util.concurrent.ConcurrentHashMap r2 = r8.f1175a
            boolean r2 = r2.containsKey(r9)
            if (r2 == 0) goto L1a
            java.util.concurrent.ConcurrentHashMap r0 = r8.f1175a
            java.lang.Object r9 = r0.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            return r9
        L1a:
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            r3 = 0
            java.lang.String r4 = "/%s.properties"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            r6 = 0
            r5[r6] = r9     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            java.lang.Class<com.google.android.gms.common.internal.n> r5 = com.google.android.gms.common.internal.n.class
            java.io.InputStream r4 = r5.getResourceAsStream(r4)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            if (r4 == 0) goto L57
            r2.load(r4)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            java.lang.String r5 = "version"
            java.lang.String r3 = r2.getProperty(r5, r3)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            com.google.android.gms.common.internal.i r2 = com.google.android.gms.common.internal.n.f1173b     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r5.<init>()     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r5.append(r9)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            java.lang.String r6 = " version is "
            r5.append(r6)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r5.append(r3)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r2.d(r1, r5)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            goto L8f
        L57:
            com.google.android.gms.common.internal.i r2 = com.google.android.gms.common.internal.n.f1173b     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r5.<init>()     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r5.append(r0)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r5.append(r9)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r2.e(r1, r5)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            goto L8f
        L6c:
            r9 = move-exception
            r3 = r4
            goto La5
        L6f:
            r2 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L78
        L74:
            r9 = move-exception
            goto La5
        L76:
            r2 = move-exception
            r4 = r3
        L78:
            com.google.android.gms.common.internal.i r5 = com.google.android.gms.common.internal.n.f1173b     // Catch: java.lang.Throwable -> L74
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r6.<init>()     // Catch: java.lang.Throwable -> L74
            r6.append(r0)     // Catch: java.lang.Throwable -> L74
            r6.append(r9)     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = r6.toString()     // Catch: java.lang.Throwable -> L74
            r5.c(r1, r0, r2)     // Catch: java.lang.Throwable -> L74
            r7 = r4
            r4 = r3
            r3 = r7
        L8f:
            if (r4 == 0) goto L94
            q0.i.a(r4)
        L94:
            if (r3 != 0) goto L9f
            com.google.android.gms.common.internal.i r0 = com.google.android.gms.common.internal.n.f1173b
            java.lang.String r2 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"
            r0.b(r1, r2)
            java.lang.String r3 = "UNKNOWN"
        L9f:
            java.util.concurrent.ConcurrentHashMap r0 = r8.f1175a
            r0.put(r9, r3)
            return r3
        La5:
            if (r3 == 0) goto Laa
            q0.i.a(r3)
        Laa:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.n.b(java.lang.String):java.lang.String");
    }
}
