package m0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public static class a extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(java.lang.String r3, android.os.Parcel r4) {
            /*
                r2 = this;
                int r0 = r4.dataPosition()
                int r4 = r4.dataSize()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                java.lang.String r3 = " Parcel: pos="
                r1.append(r3)
                r1.append(r0)
                java.lang.String r3 = " size="
                r1.append(r3)
                r1.append(r4)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m0.b.a.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    public static Bundle a(Parcel parcel, int i5) {
        int q5 = q(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (q5 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + q5);
        return readBundle;
    }

    public static int[] b(Parcel parcel, int i5) {
        int q5 = q(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (q5 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + q5);
        return createIntArray;
    }

    public static <T extends Parcelable> T c(Parcel parcel, int i5, Parcelable.Creator<T> creator) {
        int q5 = q(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (q5 == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + q5);
        return createFromParcel;
    }

    public static String d(Parcel parcel, int i5) {
        int q5 = q(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (q5 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + q5);
        return readString;
    }

    public static ArrayList<String> e(Parcel parcel, int i5) {
        int q5 = q(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (q5 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + q5);
        return createStringArrayList;
    }

    public static <T> T[] f(Parcel parcel, int i5, Parcelable.Creator<T> creator) {
        int q5 = q(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (q5 == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + q5);
        return tArr;
    }

    public static <T> ArrayList<T> g(Parcel parcel, int i5, Parcelable.Creator<T> creator) {
        int q5 = q(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (q5 == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + q5);
        return createTypedArrayList;
    }

    public static void h(Parcel parcel, int i5) {
        if (parcel.dataPosition() == i5) {
            return;
        }
        throw new a("Overread allowed size end=" + i5, parcel);
    }

    public static int i(int i5) {
        return (char) i5;
    }

    public static boolean j(Parcel parcel, int i5) {
        u(parcel, i5, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean k(Parcel parcel, int i5) {
        int q5 = q(parcel, i5);
        if (q5 == 0) {
            return null;
        }
        t(parcel, i5, q5, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static int l(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder m(Parcel parcel, int i5) {
        int q5 = q(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (q5 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + q5);
        return readStrongBinder;
    }

    public static int n(Parcel parcel, int i5) {
        u(parcel, i5, 4);
        return parcel.readInt();
    }

    public static long o(Parcel parcel, int i5) {
        u(parcel, i5, 8);
        return parcel.readLong();
    }

    public static Long p(Parcel parcel, int i5) {
        int q5 = q(parcel, i5);
        if (q5 == 0) {
            return null;
        }
        t(parcel, i5, q5, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int q(Parcel parcel, int i5) {
        return (i5 & (-65536)) != -65536 ? (char) (i5 >> 16) : parcel.readInt();
    }

    public static void r(Parcel parcel, int i5) {
        parcel.setDataPosition(parcel.dataPosition() + q(parcel, i5));
    }

    public static int s(Parcel parcel) {
        int l5 = l(parcel);
        int q5 = q(parcel, l5);
        int i5 = i(l5);
        int dataPosition = parcel.dataPosition();
        if (i5 == 20293) {
            int i6 = q5 + dataPosition;
            if (i6 < dataPosition || i6 > parcel.dataSize()) {
                throw new a("Size read is invalid start=" + dataPosition + " end=" + i6, parcel);
            }
            return i6;
        }
        throw new a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(l5))), parcel);
    }

    private static void t(Parcel parcel, int i5, int i6, int i7) {
        if (i6 == i7) {
            return;
        }
        String hexString = Integer.toHexString(i6);
        throw new a("Expected size " + i7 + " got " + i6 + " (0x" + hexString + ")", parcel);
    }

    private static void u(Parcel parcel, int i5, int i6) {
        int q5 = q(parcel, i5);
        if (q5 == i6) {
            return;
        }
        String hexString = Integer.toHexString(q5);
        throw new a("Expected size " + i6 + " got " + q5 + " (0x" + hexString + ")", parcel);
    }
}
