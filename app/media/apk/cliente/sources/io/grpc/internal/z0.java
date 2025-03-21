package io.grpc.internal;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<String> f5328a = new ArrayList<>();

    public z0 a(Object obj) {
        this.f5328a.add(String.valueOf(obj));
        return this;
    }

    public z0 b(String str, Object obj) {
        ArrayList<String> arrayList = this.f5328a;
        arrayList.add(str + "=" + obj);
        return this;
    }

    public String toString() {
        return this.f5328a.toString();
    }
}
