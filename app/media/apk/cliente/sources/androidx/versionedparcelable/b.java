package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f697d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f698e;

    /* renamed from: f  reason: collision with root package name */
    private final int f699f;

    /* renamed from: g  reason: collision with root package name */
    private final int f700g;

    /* renamed from: h  reason: collision with root package name */
    private final String f701h;

    /* renamed from: i  reason: collision with root package name */
    private int f702i;

    /* renamed from: j  reason: collision with root package name */
    private int f703j;

    /* renamed from: k  reason: collision with root package name */
    private int f704k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    private b(Parcel parcel, int i5, int i6, String str, androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f697d = new SparseIntArray();
        this.f702i = -1;
        this.f704k = -1;
        this.f698e = parcel;
        this.f699f = i5;
        this.f700g = i6;
        this.f703j = i5;
        this.f701h = str;
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f698e.writeInt(-1);
            return;
        }
        this.f698e.writeInt(bArr.length);
        this.f698e.writeByteArray(bArr);
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f698e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i5) {
        this.f698e.writeInt(i5);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f698e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f698e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i5 = this.f702i;
        if (i5 >= 0) {
            int i6 = this.f697d.get(i5);
            int dataPosition = this.f698e.dataPosition();
            this.f698e.setDataPosition(i6);
            this.f698e.writeInt(dataPosition - i6);
            this.f698e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f698e;
        int dataPosition = parcel.dataPosition();
        int i5 = this.f703j;
        if (i5 == this.f699f) {
            i5 = this.f700g;
        }
        int i6 = i5;
        return new b(parcel, dataPosition, i6, this.f701h + "  ", this.f694a, this.f695b, this.f696c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f698e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int readInt = this.f698e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f698e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f698e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i5) {
        while (this.f703j < this.f700g) {
            int i6 = this.f704k;
            if (i6 == i5) {
                return true;
            }
            if (String.valueOf(i6).compareTo(String.valueOf(i5)) > 0) {
                return false;
            }
            this.f698e.setDataPosition(this.f703j);
            int readInt = this.f698e.readInt();
            this.f704k = this.f698e.readInt();
            this.f703j += readInt;
        }
        return this.f704k == i5;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f698e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T q() {
        return (T) this.f698e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f698e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i5) {
        a();
        this.f702i = i5;
        this.f697d.put(i5, this.f698e.dataPosition());
        E(0);
        E(i5);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z4) {
        this.f698e.writeInt(z4 ? 1 : 0);
    }
}
