package f1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import z1.y;
/* loaded from: classes.dex */
public final class q implements Comparable<q>, Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final long f3003a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3004b;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<q> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public q createFromParcel(Parcel parcel) {
            return new q(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public q[] newArray(int i5) {
            return new q[i5];
        }
    }

    public q(long j5, int i5) {
        t(j5, i5);
        this.f3003a = j5;
        this.f3004b = i5;
    }

    protected q(Parcel parcel) {
        this.f3003a = parcel.readLong();
        this.f3004b = parcel.readInt();
    }

    public q(Date date) {
        long time = date.getTime();
        long j5 = time / 1000;
        int i5 = ((int) (time % 1000)) * 1000000;
        if (i5 < 0) {
            j5--;
            i5 += 1000000000;
        }
        t(j5, i5);
        this.f3003a = j5;
        this.f3004b = i5;
    }

    public static q q() {
        return new q(new Date());
    }

    private static void t(long j5, int i5) {
        y.a(i5 >= 0, "Timestamp nanoseconds out of range: %s", Integer.valueOf(i5));
        y.a(((double) i5) < 1.0E9d, "Timestamp nanoseconds out of range: %s", Integer.valueOf(i5));
        y.a(j5 >= -62135596800L, "Timestamp seconds out of range: %s", Long.valueOf(j5));
        y.a(j5 < 253402300800L, "Timestamp seconds out of range: %s", Long.valueOf(j5));
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(q qVar) {
        long j5 = this.f3003a;
        long j6 = qVar.f3003a;
        return j5 == j6 ? Integer.signum(this.f3004b - qVar.f3004b) : Long.signum(j5 - j6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof q) && compareTo((q) obj) == 0;
    }

    public int h() {
        return this.f3004b;
    }

    public int hashCode() {
        long j5 = this.f3003a;
        return (((((int) j5) * 37 * 37) + ((int) (j5 >> 32))) * 37) + this.f3004b;
    }

    public long n() {
        return this.f3003a;
    }

    public String toString() {
        return "Timestamp(seconds=" + this.f3003a + ", nanoseconds=" + this.f3004b + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeLong(this.f3003a);
        parcel.writeInt(this.f3004b);
    }
}
