package o4;

import com.google.android.gms.common.api.a;
/* loaded from: classes.dex */
public final class g {
    public static final <E> d<E> a(int i5, a aVar, d4.l<? super E, s3.t> lVar) {
        d<E> bVar;
        if (i5 != -2) {
            if (i5 == -1) {
                if (aVar == a.SUSPEND) {
                    return new o(1, a.DROP_OLDEST, lVar);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            } else if (i5 != 0) {
                return i5 != Integer.MAX_VALUE ? aVar == a.SUSPEND ? new b(i5, lVar) : new o(i5, aVar, lVar) : new b(a.e.API_PRIORITY_OTHER, lVar);
            } else {
                bVar = aVar == a.SUSPEND ? new b<>(0, lVar) : new o<>(1, aVar, lVar);
            }
        } else {
            bVar = aVar == a.SUSPEND ? new b<>(d.f6831i.a(), lVar) : new o<>(1, aVar, lVar);
        }
        return bVar;
    }

    public static /* synthetic */ d b(int i5, a aVar, d4.l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = 0;
        }
        if ((i6 & 2) != 0) {
            aVar = a.SUSPEND;
        }
        if ((i6 & 4) != 0) {
            lVar = null;
        }
        return a(i5, aVar, lVar);
    }
}
