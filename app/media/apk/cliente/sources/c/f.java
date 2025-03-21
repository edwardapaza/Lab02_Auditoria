package c;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import e4.g;
import e4.k;
/* loaded from: classes.dex */
public final class f implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private final IntentSender f776a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f777b;

    /* renamed from: c  reason: collision with root package name */
    private final int f778c;

    /* renamed from: d  reason: collision with root package name */
    private final int f779d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f775e = new c(null);
    public static final Parcelable.Creator<f> CREATOR = new b();

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final IntentSender f780a;

        /* renamed from: b  reason: collision with root package name */
        private Intent f781b;

        /* renamed from: c  reason: collision with root package name */
        private int f782c;

        /* renamed from: d  reason: collision with root package name */
        private int f783d;

        public a(IntentSender intentSender) {
            k.e(intentSender, "intentSender");
            this.f780a = intentSender;
        }

        public final f a() {
            return new f(this.f780a, this.f781b, this.f782c, this.f783d);
        }

        public final a b(Intent intent) {
            this.f781b = intent;
            return this;
        }

        public final a c(int i5, int i6) {
            this.f783d = i5;
            this.f782c = i6;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Parcelable.Creator<f> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            k.e(parcel, "inParcel");
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public f[] newArray(int i5) {
            return new f[i5];
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(g gVar) {
            this();
        }
    }

    public f(IntentSender intentSender, Intent intent, int i5, int i6) {
        k.e(intentSender, "intentSender");
        this.f776a = intentSender;
        this.f777b = intent;
        this.f778c = i5;
        this.f779d = i6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public f(android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            e4.k.e(r4, r0)
            java.lang.Class<android.content.IntentSender> r0 = android.content.IntentSender.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r4.readParcelable(r0)
            e4.k.b(r0)
            android.content.IntentSender r0 = (android.content.IntentSender) r0
            java.lang.Class<android.content.Intent> r1 = android.content.Intent.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r4.readParcelable(r1)
            android.content.Intent r1 = (android.content.Intent) r1
            int r2 = r4.readInt()
            int r4 = r4.readInt()
            r3.<init>(r0, r1, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.f.<init>(android.os.Parcel):void");
    }

    public final Intent a() {
        return this.f777b;
    }

    public final int b() {
        return this.f778c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int f() {
        return this.f779d;
    }

    public final IntentSender g() {
        return this.f776a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        k.e(parcel, "dest");
        parcel.writeParcelable(this.f776a, i5);
        parcel.writeParcelable(this.f777b, i5);
        parcel.writeInt(this.f778c);
        parcel.writeInt(this.f779d);
    }
}
