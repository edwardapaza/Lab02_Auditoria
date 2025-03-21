package v1;

import com.google.protobuf.u1;
import i2.d0;
import i2.u;
/* loaded from: classes.dex */
public final class v {
    public static u1 a(d0 d0Var) {
        return d0Var.w0().j0("__local_write_time__").z0();
    }

    public static d0 b(d0 d0Var) {
        d0 i02 = d0Var.w0().i0("__previous_value__", null);
        return c(i02) ? b(i02) : i02;
    }

    public static boolean c(d0 d0Var) {
        d0 i02 = d0Var != null ? d0Var.w0().i0("__type__", null) : null;
        return i02 != null && "server_timestamp".equals(i02.y0());
    }

    public static d0 d(f1.q qVar, d0 d0Var) {
        u.b G = i2.u.n0().G("__type__", d0.B0().Q("server_timestamp").build()).G("__local_write_time__", d0.B0().R(u1.j0().F(qVar.n()).E(qVar.h())).build());
        if (c(d0Var)) {
            d0Var = b(d0Var);
        }
        if (d0Var != null) {
            G.G("__previous_value__", d0Var);
        }
        return d0.B0().M(G).build();
    }
}
