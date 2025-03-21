package o;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q0 implements Parcelable {
    public static final Parcelable.Creator<q0> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final String f6573a;

    /* renamed from: b  reason: collision with root package name */
    final String f6574b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f6575c;

    /* renamed from: d  reason: collision with root package name */
    final int f6576d;

    /* renamed from: e  reason: collision with root package name */
    final int f6577e;

    /* renamed from: f  reason: collision with root package name */
    final String f6578f;

    /* renamed from: k  reason: collision with root package name */
    final boolean f6579k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f6580l;

    /* renamed from: m  reason: collision with root package name */
    final boolean f6581m;

    /* renamed from: n  reason: collision with root package name */
    final boolean f6582n;

    /* renamed from: o  reason: collision with root package name */
    final int f6583o;

    /* renamed from: p  reason: collision with root package name */
    final String f6584p;

    /* renamed from: q  reason: collision with root package name */
    final int f6585q;

    /* renamed from: r  reason: collision with root package name */
    final boolean f6586r;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<q0> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public q0 createFromParcel(Parcel parcel) {
            return new q0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public q0[] newArray(int i5) {
            return new q0[i5];
        }
    }

    q0(Parcel parcel) {
        this.f6573a = parcel.readString();
        this.f6574b = parcel.readString();
        this.f6575c = parcel.readInt() != 0;
        this.f6576d = parcel.readInt();
        this.f6577e = parcel.readInt();
        this.f6578f = parcel.readString();
        this.f6579k = parcel.readInt() != 0;
        this.f6580l = parcel.readInt() != 0;
        this.f6581m = parcel.readInt() != 0;
        this.f6582n = parcel.readInt() != 0;
        this.f6583o = parcel.readInt();
        this.f6584p = parcel.readString();
        this.f6585q = parcel.readInt();
        this.f6586r = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q0(s sVar) {
        this.f6573a = sVar.getClass().getName();
        this.f6574b = sVar.f6607f;
        this.f6575c = sVar.f6619t;
        this.f6576d = sVar.C;
        this.f6577e = sVar.D;
        this.f6578f = sVar.E;
        this.f6579k = sVar.H;
        this.f6580l = sVar.f6616q;
        this.f6581m = sVar.G;
        this.f6582n = sVar.F;
        this.f6583o = sVar.X.ordinal();
        this.f6584p = sVar.f6612m;
        this.f6585q = sVar.f6613n;
        this.f6586r = sVar.P;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s a(c0 c0Var, ClassLoader classLoader) {
        s a5 = c0Var.a(classLoader, this.f6573a);
        a5.f6607f = this.f6574b;
        a5.f6619t = this.f6575c;
        a5.f6621v = true;
        a5.C = this.f6576d;
        a5.D = this.f6577e;
        a5.E = this.f6578f;
        a5.H = this.f6579k;
        a5.f6616q = this.f6580l;
        a5.G = this.f6581m;
        a5.F = this.f6582n;
        a5.X = i.b.values()[this.f6583o];
        a5.f6612m = this.f6584p;
        a5.f6613n = this.f6585q;
        a5.P = this.f6586r;
        return a5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f6573a);
        sb.append(" (");
        sb.append(this.f6574b);
        sb.append(")}:");
        if (this.f6575c) {
            sb.append(" fromLayout");
        }
        if (this.f6577e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f6577e));
        }
        String str = this.f6578f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f6578f);
        }
        if (this.f6579k) {
            sb.append(" retainInstance");
        }
        if (this.f6580l) {
            sb.append(" removing");
        }
        if (this.f6581m) {
            sb.append(" detached");
        }
        if (this.f6582n) {
            sb.append(" hidden");
        }
        if (this.f6584p != null) {
            sb.append(" targetWho=");
            sb.append(this.f6584p);
            sb.append(" targetRequestCode=");
            sb.append(this.f6585q);
        }
        if (this.f6586r) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f6573a);
        parcel.writeString(this.f6574b);
        parcel.writeInt(this.f6575c ? 1 : 0);
        parcel.writeInt(this.f6576d);
        parcel.writeInt(this.f6577e);
        parcel.writeString(this.f6578f);
        parcel.writeInt(this.f6579k ? 1 : 0);
        parcel.writeInt(this.f6580l ? 1 : 0);
        parcel.writeInt(this.f6581m ? 1 : 0);
        parcel.writeInt(this.f6582n ? 1 : 0);
        parcel.writeInt(this.f6583o);
        parcel.writeString(this.f6584p);
        parcel.writeInt(this.f6585q);
        parcel.writeInt(this.f6586r ? 1 : 0);
    }
}
