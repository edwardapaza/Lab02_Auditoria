package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadFactory f1583e = Executors.defaultThreadFactory();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f1584a = new AtomicLong();

    /* renamed from: b  reason: collision with root package name */
    private final String f1585b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1586c;

    /* renamed from: d  reason: collision with root package name */
    private final StrictMode.ThreadPolicy f1587d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, int i5, StrictMode.ThreadPolicy threadPolicy) {
        this.f1585b = str;
        this.f1586c = i5;
        this.f1587d = threadPolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        Process.setThreadPriority(this.f1586c);
        StrictMode.ThreadPolicy threadPolicy = this.f1587d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread newThread = f1583e.newThread(new Runnable() { // from class: com.google.firebase.concurrent.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.b(runnable);
            }
        });
        newThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f1585b, Long.valueOf(this.f1584a.getAndIncrement())));
        return newThread;
    }
}
