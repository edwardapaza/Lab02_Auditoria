package o;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import o.l0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n0 implements Parcelable {
    public static final Parcelable.Creator<n0> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    ArrayList<String> f6532a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f6533b;

    /* renamed from: c  reason: collision with root package name */
    b[] f6534c;

    /* renamed from: d  reason: collision with root package name */
    int f6535d;

    /* renamed from: e  reason: collision with root package name */
    String f6536e;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<String> f6537f;

    /* renamed from: k  reason: collision with root package name */
    ArrayList<c> f6538k;

    /* renamed from: l  reason: collision with root package name */
    ArrayList<l0.l> f6539l;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<n0> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public n0 createFromParcel(Parcel parcel) {
            return new n0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public n0[] newArray(int i5) {
            return new n0[i5];
        }
    }

    public n0() {
        this.f6536e = null;
        this.f6537f = new ArrayList<>();
        this.f6538k = new ArrayList<>();
    }

    public n0(Parcel parcel) {
        this.f6536e = null;
        this.f6537f = new ArrayList<>();
        this.f6538k = new ArrayList<>();
        this.f6532a = parcel.createStringArrayList();
        this.f6533b = parcel.createStringArrayList();
        this.f6534c = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f6535d = parcel.readInt();
        this.f6536e = parcel.readString();
        this.f6537f = parcel.createStringArrayList();
        this.f6538k = parcel.createTypedArrayList(c.CREATOR);
        this.f6539l = parcel.createTypedArrayList(l0.l.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeStringList(this.f6532a);
        parcel.writeStringList(this.f6533b);
        parcel.writeTypedArray(this.f6534c, i5);
        parcel.writeInt(this.f6535d);
        parcel.writeString(this.f6536e);
        parcel.writeStringList(this.f6537f);
        parcel.writeTypedList(this.f6538k);
        parcel.writeTypedList(this.f6539l);
    }
}
