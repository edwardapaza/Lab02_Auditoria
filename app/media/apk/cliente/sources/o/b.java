package o;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.i;
import java.util.ArrayList;
import o.t0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int[] f6359a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<String> f6360b;

    /* renamed from: c  reason: collision with root package name */
    final int[] f6361c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f6362d;

    /* renamed from: e  reason: collision with root package name */
    final int f6363e;

    /* renamed from: f  reason: collision with root package name */
    final String f6364f;

    /* renamed from: k  reason: collision with root package name */
    final int f6365k;

    /* renamed from: l  reason: collision with root package name */
    final int f6366l;

    /* renamed from: m  reason: collision with root package name */
    final CharSequence f6367m;

    /* renamed from: n  reason: collision with root package name */
    final int f6368n;

    /* renamed from: o  reason: collision with root package name */
    final CharSequence f6369o;

    /* renamed from: p  reason: collision with root package name */
    final ArrayList<String> f6370p;

    /* renamed from: q  reason: collision with root package name */
    final ArrayList<String> f6371q;

    /* renamed from: r  reason: collision with root package name */
    final boolean f6372r;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public b[] newArray(int i5) {
            return new b[i5];
        }
    }

    b(Parcel parcel) {
        this.f6359a = parcel.createIntArray();
        this.f6360b = parcel.createStringArrayList();
        this.f6361c = parcel.createIntArray();
        this.f6362d = parcel.createIntArray();
        this.f6363e = parcel.readInt();
        this.f6364f = parcel.readString();
        this.f6365k = parcel.readInt();
        this.f6366l = parcel.readInt();
        this.f6367m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f6368n = parcel.readInt();
        this.f6369o = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f6370p = parcel.createStringArrayList();
        this.f6371q = parcel.createStringArrayList();
        this.f6372r = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(o.a aVar) {
        int size = aVar.f6662c.size();
        this.f6359a = new int[size * 6];
        if (!aVar.f6668i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f6360b = new ArrayList<>(size);
        this.f6361c = new int[size];
        this.f6362d = new int[size];
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            t0.a aVar2 = aVar.f6662c.get(i5);
            int i7 = i6 + 1;
            this.f6359a[i6] = aVar2.f6679a;
            ArrayList<String> arrayList = this.f6360b;
            s sVar = aVar2.f6680b;
            arrayList.add(sVar != null ? sVar.f6607f : null);
            int[] iArr = this.f6359a;
            int i8 = i7 + 1;
            iArr[i7] = aVar2.f6681c ? 1 : 0;
            int i9 = i8 + 1;
            iArr[i8] = aVar2.f6682d;
            int i10 = i9 + 1;
            iArr[i9] = aVar2.f6683e;
            int i11 = i10 + 1;
            iArr[i10] = aVar2.f6684f;
            iArr[i11] = aVar2.f6685g;
            this.f6361c[i5] = aVar2.f6686h.ordinal();
            this.f6362d[i5] = aVar2.f6687i.ordinal();
            i5++;
            i6 = i11 + 1;
        }
        this.f6363e = aVar.f6667h;
        this.f6364f = aVar.f6670k;
        this.f6365k = aVar.f6350v;
        this.f6366l = aVar.f6671l;
        this.f6367m = aVar.f6672m;
        this.f6368n = aVar.f6673n;
        this.f6369o = aVar.f6674o;
        this.f6370p = aVar.f6675p;
        this.f6371q = aVar.f6676q;
        this.f6372r = aVar.f6677r;
    }

    private void a(o.a aVar) {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z4 = true;
            if (i5 >= this.f6359a.length) {
                aVar.f6667h = this.f6363e;
                aVar.f6670k = this.f6364f;
                aVar.f6668i = true;
                aVar.f6671l = this.f6366l;
                aVar.f6672m = this.f6367m;
                aVar.f6673n = this.f6368n;
                aVar.f6674o = this.f6369o;
                aVar.f6675p = this.f6370p;
                aVar.f6676q = this.f6371q;
                aVar.f6677r = this.f6372r;
                return;
            }
            t0.a aVar2 = new t0.a();
            int i7 = i5 + 1;
            aVar2.f6679a = this.f6359a[i5];
            if (l0.I0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i6 + " base fragment #" + this.f6359a[i7]);
            }
            aVar2.f6686h = i.b.values()[this.f6361c[i6]];
            aVar2.f6687i = i.b.values()[this.f6362d[i6]];
            int[] iArr = this.f6359a;
            int i8 = i7 + 1;
            if (iArr[i7] == 0) {
                z4 = false;
            }
            aVar2.f6681c = z4;
            int i9 = i8 + 1;
            int i10 = iArr[i8];
            aVar2.f6682d = i10;
            int i11 = i9 + 1;
            int i12 = iArr[i9];
            aVar2.f6683e = i12;
            int i13 = i11 + 1;
            int i14 = iArr[i11];
            aVar2.f6684f = i14;
            int i15 = iArr[i13];
            aVar2.f6685g = i15;
            aVar.f6663d = i10;
            aVar.f6664e = i12;
            aVar.f6665f = i14;
            aVar.f6666g = i15;
            aVar.e(aVar2);
            i6++;
            i5 = i13 + 1;
        }
    }

    public o.a b(l0 l0Var) {
        o.a aVar = new o.a(l0Var);
        a(aVar);
        aVar.f6350v = this.f6365k;
        for (int i5 = 0; i5 < this.f6360b.size(); i5++) {
            String str = this.f6360b.get(i5);
            if (str != null) {
                aVar.f6662c.get(i5).f6680b = l0Var.f0(str);
            }
        }
        aVar.n(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeIntArray(this.f6359a);
        parcel.writeStringList(this.f6360b);
        parcel.writeIntArray(this.f6361c);
        parcel.writeIntArray(this.f6362d);
        parcel.writeInt(this.f6363e);
        parcel.writeString(this.f6364f);
        parcel.writeInt(this.f6365k);
        parcel.writeInt(this.f6366l);
        TextUtils.writeToParcel(this.f6367m, parcel, 0);
        parcel.writeInt(this.f6368n);
        TextUtils.writeToParcel(this.f6369o, parcel, 0);
        parcel.writeStringList(this.f6370p);
        parcel.writeStringList(this.f6371q);
        parcel.writeInt(this.f6372r ? 1 : 0);
    }
}
