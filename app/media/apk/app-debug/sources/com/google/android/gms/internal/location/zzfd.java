package com.google.android.gms.internal.location;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
public final class zzfd {
    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zza(java.util.concurrent.CountDownLatch r4, long r5, java.util.concurrent.TimeUnit r7) {
        /*
            r5 = 30
            r0 = 1
            r1 = 0
            long r5 = r7.toNanos(r5)     // Catch: java.lang.Throwable -> L2b
            long r2 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L2b
            long r2 = r2 + r5
        Ld:
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L1d java.lang.InterruptedException -> L20
            boolean r4 = r4.await(r5, r7)     // Catch: java.lang.Throwable -> L1d java.lang.InterruptedException -> L20
            if (r1 == 0) goto L1c
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            r5.interrupt()
        L1c:
            return r4
        L1d:
            r4 = move-exception
            r0 = r1
            goto L2d
        L20:
            r5 = move-exception
            long r5 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L29
            long r5 = r2 - r5
            r1 = 1
            goto Ld
        L29:
            r4 = move-exception
            goto L2d
        L2b:
            r4 = move-exception
            r0 = 0
        L2d:
            if (r0 == 0) goto L36
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            r5.interrupt()
        L36:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzfd.zza(java.util.concurrent.CountDownLatch, long, java.util.concurrent.TimeUnit):boolean");
    }
}
