package q4;
/* loaded from: classes.dex */
public interface i<T> extends p4.c<T> {

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ p4.c a(i iVar, v3.g gVar, int i5, o4.a aVar, int i6, Object obj) {
            if (obj == null) {
                if ((i6 & 1) != 0) {
                    gVar = v3.h.f8175a;
                }
                if ((i6 & 2) != 0) {
                    i5 = -3;
                }
                if ((i6 & 4) != 0) {
                    aVar = o4.a.SUSPEND;
                }
                return iVar.a(gVar, i5, aVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }

    p4.c<T> a(v3.g gVar, int i5, o4.a aVar);
}
