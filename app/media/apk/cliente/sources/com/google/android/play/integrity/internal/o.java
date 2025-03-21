package com.google.android.play.integrity.internal;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final ClassLoader f1374a = o.class.getClassLoader();

    private o() {
    }

    public static Parcelable a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void b(Parcel parcel) {
        int dataAvail = parcel.dataAvail();
        if (dataAvail <= 0) {
            return;
        }
        throw new BadParcelableException("Parcel data not fully consumed, unread size: " + dataAvail);
    }

    public static void c(Parcel parcel, Parcelable parcelable) {
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
