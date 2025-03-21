package o;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final List<String> f6408a;

    /* renamed from: b  reason: collision with root package name */
    final List<b> f6409b;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<c> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public c[] newArray(int i5) {
            return new c[i5];
        }
    }

    c(Parcel parcel) {
        this.f6408a = parcel.createStringArrayList();
        this.f6409b = parcel.createTypedArrayList(b.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeStringList(this.f6408a);
        parcel.writeTypedList(this.f6409b);
    }
}
