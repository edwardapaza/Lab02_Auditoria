package com.google.firebase.concurrent;

import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import k1.f0;
import k1.x;
/* loaded from: classes.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* renamed from: a  reason: collision with root package name */
    static final x<ScheduledExecutorService> f1577a = new x<>(new b2.b() { // from class: l1.c
        @Override // b2.b
        public final Object get() {
            ScheduledExecutorService p5;
            p5 = ExecutorsRegistrar.p();
            return p5;
        }
    });

    /* renamed from: b  reason: collision with root package name */
    static final x<ScheduledExecutorService> f1578b = new x<>(new b2.b() { // from class: l1.d
        @Override // b2.b
        public final Object get() {
            ScheduledExecutorService q5;
            q5 = ExecutorsRegistrar.q();
            return q5;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    static final x<ScheduledExecutorService> f1579c = new x<>(new b2.b() { // from class: l1.e
        @Override // b2.b
        public final Object get() {
            ScheduledExecutorService r5;
            r5 = ExecutorsRegistrar.r();
            return r5;
        }
    });

    /* renamed from: d  reason: collision with root package name */
    static final x<ScheduledExecutorService> f1580d = new x<>(new b2.b() { // from class: l1.f
        @Override // b2.b
        public final Object get() {
            ScheduledExecutorService s5;
            s5 = ExecutorsRegistrar.s();
            return s5;
        }
    });

    private static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 23) {
            detectNetwork.detectResourceMismatches();
            if (i5 >= 26) {
                detectNetwork.detectUnbufferedIo();
            }
        }
        return detectNetwork.penaltyLog().build();
    }

    private static ThreadFactory j(String str, int i5) {
        return new b(str, i5, null);
    }

    private static ThreadFactory k(String str, int i5, StrictMode.ThreadPolicy threadPolicy) {
        return new b(str, i5, threadPolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService l(k1.e eVar) {
        return f1577a.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService m(k1.e eVar) {
        return f1579c.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService n(k1.e eVar) {
        return f1578b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Executor o(k1.e eVar) {
        return l1.k.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService p() {
        return u(Executors.newFixedThreadPool(4, k("Firebase Background", 10, i())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService q() {
        return u(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), k("Firebase Lite", 0, t())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService r() {
        return u(Executors.newCachedThreadPool(j("Firebase Blocking", 11)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService s() {
        return Executors.newSingleThreadScheduledExecutor(j("Firebase Scheduler", 0));
    }

    private static StrictMode.ThreadPolicy t() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    private static ScheduledExecutorService u(ExecutorService executorService) {
        return new o(executorService, f1580d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<k1.c<?>> getComponents() {
        return Arrays.asList(k1.c.f(f0.a(g1.a.class, ScheduledExecutorService.class), f0.a(g1.a.class, ExecutorService.class), f0.a(g1.a.class, Executor.class)).d(new k1.h() { // from class: l1.g
            @Override // k1.h
            public final Object a(k1.e eVar) {
                ScheduledExecutorService l5;
                l5 = ExecutorsRegistrar.l(eVar);
                return l5;
            }
        }).c(), k1.c.f(f0.a(g1.b.class, ScheduledExecutorService.class), f0.a(g1.b.class, ExecutorService.class), f0.a(g1.b.class, Executor.class)).d(new k1.h() { // from class: l1.h
            @Override // k1.h
            public final Object a(k1.e eVar) {
                ScheduledExecutorService m5;
                m5 = ExecutorsRegistrar.m(eVar);
                return m5;
            }
        }).c(), k1.c.f(f0.a(g1.c.class, ScheduledExecutorService.class), f0.a(g1.c.class, ExecutorService.class), f0.a(g1.c.class, Executor.class)).d(new k1.h() { // from class: l1.i
            @Override // k1.h
            public final Object a(k1.e eVar) {
                ScheduledExecutorService n5;
                n5 = ExecutorsRegistrar.n(eVar);
                return n5;
            }
        }).c(), k1.c.e(f0.a(g1.d.class, Executor.class)).d(new k1.h() { // from class: l1.j
            @Override // k1.h
            public final Object a(k1.e eVar) {
                Executor o5;
                o5 = ExecutorsRegistrar.o(eVar);
                return o5;
            }
        }).c());
    }
}
