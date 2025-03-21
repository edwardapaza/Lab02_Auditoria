package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
/* loaded from: classes.dex */
final class y {

    /* renamed from: a  reason: collision with root package name */
    private final b<?> f1065a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource<Boolean> f1066b = new TaskCompletionSource<>();

    public y(b<?> bVar) {
        this.f1065a = bVar;
    }

    public final b<?> a() {
        return this.f1065a;
    }

    public final TaskCompletionSource<Boolean> b() {
        return this.f1066b;
    }
}
