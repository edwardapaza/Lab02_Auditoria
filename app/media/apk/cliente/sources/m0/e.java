package m0;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
/* loaded from: classes.dex */
public final class e {
    public static <T extends d> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        q.k(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    public static <T extends d> T b(Intent intent, String str, Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return (T) a(byteArrayExtra, creator);
    }

    public static <T extends d> T c(String str, Parcelable.Creator<T> creator) {
        return (T) a(q0.c.a(str), creator);
    }

    public static <T extends d> byte[] d(T t5) {
        Parcel obtain = Parcel.obtain();
        t5.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <T extends d> void e(T t5, Intent intent, String str) {
        intent.putExtra(str, d(t5));
    }

    public static <T extends d> String f(T t5) {
        return q0.c.d(d(t5));
    }
}
