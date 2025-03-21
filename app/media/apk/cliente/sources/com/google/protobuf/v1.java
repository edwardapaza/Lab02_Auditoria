package com.google.protobuf;

import java.util.List;
/* loaded from: classes.dex */
public class v1 extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f2149a;

    public v1(w0 w0Var) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f2149a = null;
    }

    public e0 a() {
        return new e0(getMessage());
    }
}
