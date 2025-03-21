package k3;

import i3.m0;
import i3.y0;
import io.grpc.internal.r2;
import java.util.List;
import java.util.logging.Logger;
/* loaded from: classes.dex */
class r {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f5829a = Logger.getLogger(r.class.getName());

    private r() {
    }

    public static y0 a(List<m3.d> list) {
        return m0.c(b(list));
    }

    private static byte[][] b(List<m3.d> list) {
        byte[][] bArr = new byte[list.size() * 2];
        int i5 = 0;
        for (m3.d dVar : list) {
            int i6 = i5 + 1;
            bArr[i5] = dVar.f6114a.t();
            i5 = i6 + 1;
            bArr[i6] = dVar.f6115b.t();
        }
        return r2.e(bArr);
    }

    public static y0 c(List<m3.d> list) {
        return m0.c(b(list));
    }
}
