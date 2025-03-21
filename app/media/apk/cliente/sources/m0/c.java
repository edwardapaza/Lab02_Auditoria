package m0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static int a(Parcel parcel) {
        return p(parcel, 20293);
    }

    public static void b(Parcel parcel, int i5) {
        q(parcel, i5);
    }

    public static void c(Parcel parcel, int i5, boolean z4) {
        r(parcel, i5, 4);
        parcel.writeInt(z4 ? 1 : 0);
    }

    public static void d(Parcel parcel, int i5, Boolean bool, boolean z4) {
        if (bool != null) {
            r(parcel, i5, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z4) {
            r(parcel, i5, 0);
        }
    }

    public static void e(Parcel parcel, int i5, Bundle bundle, boolean z4) {
        if (bundle == null) {
            if (z4) {
                r(parcel, i5, 0);
                return;
            }
            return;
        }
        int p5 = p(parcel, i5);
        parcel.writeBundle(bundle);
        q(parcel, p5);
    }

    public static void f(Parcel parcel, int i5, IBinder iBinder, boolean z4) {
        if (iBinder == null) {
            if (z4) {
                r(parcel, i5, 0);
                return;
            }
            return;
        }
        int p5 = p(parcel, i5);
        parcel.writeStrongBinder(iBinder);
        q(parcel, p5);
    }

    public static void g(Parcel parcel, int i5, int i6) {
        r(parcel, i5, 4);
        parcel.writeInt(i6);
    }

    public static void h(Parcel parcel, int i5, int[] iArr, boolean z4) {
        if (iArr == null) {
            if (z4) {
                r(parcel, i5, 0);
                return;
            }
            return;
        }
        int p5 = p(parcel, i5);
        parcel.writeIntArray(iArr);
        q(parcel, p5);
    }

    public static void i(Parcel parcel, int i5, long j5) {
        r(parcel, i5, 8);
        parcel.writeLong(j5);
    }

    public static void j(Parcel parcel, int i5, Long l5, boolean z4) {
        if (l5 != null) {
            r(parcel, i5, 8);
            parcel.writeLong(l5.longValue());
        } else if (z4) {
            r(parcel, i5, 0);
        }
    }

    public static void k(Parcel parcel, int i5, Parcelable parcelable, int i6, boolean z4) {
        if (parcelable == null) {
            if (z4) {
                r(parcel, i5, 0);
                return;
            }
            return;
        }
        int p5 = p(parcel, i5);
        parcelable.writeToParcel(parcel, i6);
        q(parcel, p5);
    }

    public static void l(Parcel parcel, int i5, String str, boolean z4) {
        if (str == null) {
            if (z4) {
                r(parcel, i5, 0);
                return;
            }
            return;
        }
        int p5 = p(parcel, i5);
        parcel.writeString(str);
        q(parcel, p5);
    }

    public static void m(Parcel parcel, int i5, List<String> list, boolean z4) {
        if (list == null) {
            if (z4) {
                r(parcel, i5, 0);
                return;
            }
            return;
        }
        int p5 = p(parcel, i5);
        parcel.writeStringList(list);
        q(parcel, p5);
    }

    public static <T extends Parcelable> void n(Parcel parcel, int i5, T[] tArr, int i6, boolean z4) {
        if (tArr == null) {
            if (z4) {
                r(parcel, i5, 0);
                return;
            }
            return;
        }
        int p5 = p(parcel, i5);
        parcel.writeInt(tArr.length);
        for (T t5 : tArr) {
            if (t5 == null) {
                parcel.writeInt(0);
            } else {
                s(parcel, t5, i6);
            }
        }
        q(parcel, p5);
    }

    public static <T extends Parcelable> void o(Parcel parcel, int i5, List<T> list, boolean z4) {
        if (list == null) {
            if (z4) {
                r(parcel, i5, 0);
                return;
            }
            return;
        }
        int p5 = p(parcel, i5);
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            T t5 = list.get(i6);
            if (t5 == null) {
                parcel.writeInt(0);
            } else {
                s(parcel, t5, 0);
            }
        }
        q(parcel, p5);
    }

    private static int p(Parcel parcel, int i5) {
        parcel.writeInt(i5 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void q(Parcel parcel, int i5) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i5 - 4);
        parcel.writeInt(dataPosition - i5);
        parcel.setDataPosition(dataPosition);
    }

    private static void r(Parcel parcel, int i5, int i6) {
        parcel.writeInt(i5 | (i6 << 16));
    }

    private static void s(Parcel parcel, Parcelable parcelable, int i5) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i5);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
