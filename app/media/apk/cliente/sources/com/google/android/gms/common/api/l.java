package com.google.android.gms.common.api;
/* loaded from: classes.dex */
public final class l extends UnsupportedOperationException {

    /* renamed from: a  reason: collision with root package name */
    private final l0.c f1076a;

    public l(l0.c cVar) {
        this.f1076a = cVar;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f1076a));
    }
}
