package o0;

import android.util.Log;
import com.google.android.gms.common.internal.i;
import java.util.Locale;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f6735a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6736b;

    /* renamed from: c  reason: collision with root package name */
    private final i f6737c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6738d;

    public a(String str, String... strArr) {
        String sb;
        if (strArr.length == 0) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str2 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
            sb2.append("] ");
            sb = sb2.toString();
        }
        this.f6736b = sb;
        this.f6735a = str;
        this.f6737c = new i(str);
        int i5 = 2;
        while (i5 <= 7 && !Log.isLoggable(this.f6735a, i5)) {
            i5++;
        }
        this.f6738d = i5;
    }

    public void a(String str, Object... objArr) {
        if (f(3)) {
            Log.d(this.f6735a, d(str, objArr));
        }
    }

    public void b(String str, Throwable th, Object... objArr) {
        Log.e(this.f6735a, d(str, objArr), th);
    }

    public void c(String str, Object... objArr) {
        Log.e(this.f6735a, d(str, objArr));
    }

    protected String d(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f6736b.concat(str);
    }

    public void e(String str, Object... objArr) {
        Log.i(this.f6735a, d(str, objArr));
    }

    public boolean f(int i5) {
        return this.f6738d <= i5;
    }

    public void g(String str, Object... objArr) {
        if (f(2)) {
            Log.v(this.f6735a, d(str, objArr));
        }
    }

    public void h(String str, Object... objArr) {
        Log.w(this.f6735a, d(str, objArr));
    }

    public void i(String str, Throwable th, Object... objArr) {
        Log.wtf(this.f6735a, d(str, objArr), th);
    }

    public void j(Throwable th) {
        Log.wtf(this.f6735a, th);
    }
}
