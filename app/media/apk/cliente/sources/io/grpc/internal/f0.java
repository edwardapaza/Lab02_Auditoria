package io.grpc.internal;

import i3.a1;
import java.net.URI;
/* loaded from: classes.dex */
public final class f0 extends i3.b1 {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f4752a = i3.n0.a(f0.class.getClassLoader());

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f4753b = 0;

    @Override // i3.a1.d
    public String a() {
        return "dns";
    }

    @Override // i3.a1.d
    public i3.a1 b(URI uri, a1.b bVar) {
        if ("dns".equals(uri.getScheme())) {
            String str = (String) z0.k.o(uri.getPath(), "targetPath");
            z0.k.k(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, uri);
            return new e0(uri.getAuthority(), str.substring(1), bVar, t0.f5195u, z0.m.c(), f4752a);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i3.b1
    public boolean d() {
        return true;
    }

    @Override // i3.b1
    public int e() {
        return 5;
    }
}
