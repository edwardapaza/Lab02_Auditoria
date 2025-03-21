package i3;

import i3.a;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class x {

    /* renamed from: d  reason: collision with root package name */
    public static final a.c<String> f3577d = a.c.a("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* renamed from: a  reason: collision with root package name */
    private final List<SocketAddress> f3578a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3579b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3580c;

    public x(SocketAddress socketAddress) {
        this(socketAddress, a.f3307c);
    }

    public x(SocketAddress socketAddress, a aVar) {
        this(Collections.singletonList(socketAddress), aVar);
    }

    public x(List<SocketAddress> list) {
        this(list, a.f3307c);
    }

    public x(List<SocketAddress> list, a aVar) {
        z0.k.e(!list.isEmpty(), "addrs is empty");
        List<SocketAddress> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f3578a = unmodifiableList;
        this.f3579b = (a) z0.k.o(aVar, "attrs");
        this.f3580c = unmodifiableList.hashCode();
    }

    public List<SocketAddress> a() {
        return this.f3578a;
    }

    public a b() {
        return this.f3579b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.f3578a.size() != xVar.f3578a.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.f3578a.size(); i5++) {
                if (!this.f3578a.get(i5).equals(xVar.f3578a.get(i5))) {
                    return false;
                }
            }
            return this.f3579b.equals(xVar.f3579b);
        }
        return false;
    }

    public int hashCode() {
        return this.f3580c;
    }

    public String toString() {
        return "[" + this.f3578a + "/" + this.f3579b + "]";
    }
}
