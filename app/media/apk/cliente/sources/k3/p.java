package k3;

import io.grpc.internal.u2;
import io.grpc.internal.v2;
/* loaded from: classes.dex */
class p implements v2 {
    @Override // io.grpc.internal.v2
    public u2 a(int i5) {
        return new o(new w4.c(), Math.min(1048576, Math.max(4096, i5)));
    }
}
