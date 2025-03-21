package c;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0030a();

    /* renamed from: a  reason: collision with root package name */
    private final int f759a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f760b;

    /* renamed from: c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0030a implements Parcelable.Creator<a> {
        C0030a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public a[] newArray(int i5) {
            return new a[i5];
        }
    }

    public a(int i5, Intent intent) {
        this.f759a = i5;
        this.f760b = intent;
    }

    a(Parcel parcel) {
        this.f759a = parcel.readInt();
        this.f760b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    public static String f(int i5) {
        return i5 != -1 ? i5 != 0 ? String.valueOf(i5) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.f760b;
    }

    public int b() {
        return this.f759a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + f(this.f759a) + ", data=" + this.f760b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f759a);
        parcel.writeInt(this.f760b == null ? 0 : 1);
        Intent intent = this.f760b;
        if (intent != null) {
            intent.writeToParcel(parcel, i5);
        }
    }
}
