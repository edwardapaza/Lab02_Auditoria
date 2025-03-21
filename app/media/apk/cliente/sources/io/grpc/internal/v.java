package io.grpc.internal;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public interface v extends Closeable {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f5274a = "unknown-authority";

        /* renamed from: b  reason: collision with root package name */
        private i3.a f5275b = i3.a.f3307c;

        /* renamed from: c  reason: collision with root package name */
        private String f5276c;

        /* renamed from: d  reason: collision with root package name */
        private i3.c0 f5277d;

        public String a() {
            return this.f5274a;
        }

        public i3.a b() {
            return this.f5275b;
        }

        public i3.c0 c() {
            return this.f5277d;
        }

        public String d() {
            return this.f5276c;
        }

        public a e(String str) {
            this.f5274a = (String) z0.k.o(str, "authority");
            return this;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f5274a.equals(aVar.f5274a) && this.f5275b.equals(aVar.f5275b) && z0.g.a(this.f5276c, aVar.f5276c) && z0.g.a(this.f5277d, aVar.f5277d);
            }
            return false;
        }

        public a f(i3.a aVar) {
            z0.k.o(aVar, "eagAttributes");
            this.f5275b = aVar;
            return this;
        }

        public a g(i3.c0 c0Var) {
            this.f5277d = c0Var;
            return this;
        }

        public a h(String str) {
            this.f5276c = str;
            return this;
        }

        public int hashCode() {
            return z0.g.b(this.f5274a, this.f5275b, this.f5276c, this.f5277d);
        }
    }

    ScheduledExecutorService R();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    x y(SocketAddress socketAddress, a aVar, i3.f fVar);
}
