package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.tasks.TaskCompletionSource;
/* loaded from: classes.dex */
public abstract class r<A extends a.b, ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final l0.c[] f1022a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1023b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1024c;

    /* loaded from: classes.dex */
    public static class a<A extends a.b, ResultT> {

        /* renamed from: a  reason: collision with root package name */
        private p<A, TaskCompletionSource<ResultT>> f1025a;

        /* renamed from: c  reason: collision with root package name */
        private l0.c[] f1027c;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1026b = true;

        /* renamed from: d  reason: collision with root package name */
        private int f1028d = 0;

        /* synthetic */ a(b1 b1Var) {
        }

        public r<A, ResultT> a() {
            com.google.android.gms.common.internal.q.b(this.f1025a != null, "execute parameter required");
            return new a1(this, this.f1027c, this.f1026b, this.f1028d);
        }

        public a<A, ResultT> b(p<A, TaskCompletionSource<ResultT>> pVar) {
            this.f1025a = pVar;
            return this;
        }

        public a<A, ResultT> c(boolean z4) {
            this.f1026b = z4;
            return this;
        }

        public a<A, ResultT> d(l0.c... cVarArr) {
            this.f1027c = cVarArr;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public r(l0.c[] cVarArr, boolean z4, int i5) {
        this.f1022a = cVarArr;
        boolean z5 = false;
        if (cVarArr != null && z4) {
            z5 = true;
        }
        this.f1023b = z5;
        this.f1024c = i5;
    }

    public static <A extends a.b, ResultT> a<A, ResultT> a() {
        return new a<>(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(A a5, TaskCompletionSource<ResultT> taskCompletionSource);

    public boolean c() {
        return this.f1023b;
    }

    public final int d() {
        return this.f1024c;
    }

    public final l0.c[] e() {
        return this.f1022a;
    }
}
