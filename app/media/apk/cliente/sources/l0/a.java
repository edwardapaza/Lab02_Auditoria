package l0;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import i2.d0;
/* loaded from: classes.dex */
public final class a extends m0.a {

    /* renamed from: a  reason: collision with root package name */
    final int f5865a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5866b;

    /* renamed from: c  reason: collision with root package name */
    private final PendingIntent f5867c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5868d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f5864e = new a(0);
    public static final Parcelable.Creator<a> CREATOR = new q();

    public a(int i5) {
        this(i5, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i5, int i6, PendingIntent pendingIntent, String str) {
        this.f5865a = i5;
        this.f5866b = i6;
        this.f5867c = pendingIntent;
        this.f5868d = str;
    }

    public a(int i5, PendingIntent pendingIntent) {
        this(i5, pendingIntent, null);
    }

    public a(int i5, PendingIntent pendingIntent, String str) {
        this(1, i5, pendingIntent, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String y(int i5) {
        if (i5 != 99) {
            if (i5 != 1500) {
                switch (i5) {
                    case -1:
                        return "UNKNOWN";
                    case 0:
                        return "SUCCESS";
                    case 1:
                        return "SERVICE_MISSING";
                    case 2:
                        return "SERVICE_VERSION_UPDATE_REQUIRED";
                    case 3:
                        return "SERVICE_DISABLED";
                    case 4:
                        return "SIGN_IN_REQUIRED";
                    case 5:
                        return "INVALID_ACCOUNT";
                    case 6:
                        return "RESOLUTION_REQUIRED";
                    case 7:
                        return "NETWORK_ERROR";
                    case 8:
                        return "INTERNAL_ERROR";
                    case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                        return "SERVICE_INVALID";
                    case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                        return "DEVELOPER_ERROR";
                    case 11:
                        return "LICENSE_CHECK_FAILED";
                    default:
                        switch (i5) {
                            case 13:
                                return "CANCELED";
                            case 14:
                                return "TIMEOUT";
                            case 15:
                                return "INTERRUPTED";
                            case 16:
                                return "API_UNAVAILABLE";
                            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                                return "SIGN_IN_FAILED";
                            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                                return "SERVICE_UPDATING";
                            case 19:
                                return "SERVICE_MISSING_PERMISSION";
                            case 20:
                                return "RESTRICTED_PROFILE";
                            case 21:
                                return "API_VERSION_UPDATE_REQUIRED";
                            case 22:
                                return "RESOLUTION_ACTIVITY_NOT_FOUND";
                            case 23:
                                return "API_DISABLED";
                            case 24:
                                return "API_DISABLED_FOR_CONNECTION";
                            default:
                                return "UNKNOWN_ERROR_CODE(" + i5 + ")";
                        }
                }
            }
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        return "UNFINISHED";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f5866b == aVar.f5866b && com.google.android.gms.common.internal.p.a(this.f5867c, aVar.f5867c) && com.google.android.gms.common.internal.p.a(this.f5868d, aVar.f5868d);
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.b(Integer.valueOf(this.f5866b), this.f5867c, this.f5868d);
    }

    public int t() {
        return this.f5866b;
    }

    public String toString() {
        p.a c5 = com.google.android.gms.common.internal.p.c(this);
        c5.a("statusCode", y(this.f5866b));
        c5.a("resolution", this.f5867c);
        c5.a("message", this.f5868d);
        return c5.toString();
    }

    public String u() {
        return this.f5868d;
    }

    public PendingIntent v() {
        return this.f5867c;
    }

    public boolean w() {
        return (this.f5866b == 0 || this.f5867c == null) ? false : true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.f5865a;
        int a5 = m0.c.a(parcel);
        m0.c.g(parcel, 1, i6);
        m0.c.g(parcel, 2, t());
        m0.c.k(parcel, 3, v(), i5, false);
        m0.c.l(parcel, 4, u(), false);
        m0.c.b(parcel, a5);
    }

    public boolean x() {
        return this.f5866b == 0;
    }
}
