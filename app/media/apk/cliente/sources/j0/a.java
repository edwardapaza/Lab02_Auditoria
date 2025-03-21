package j0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.q;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
/* loaded from: classes.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f5336c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    private static a f5337d;

    /* renamed from: a  reason: collision with root package name */
    private final Lock f5338a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f5339b;

    a(Context context) {
        this.f5339b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        q.k(context);
        Lock lock = f5336c;
        lock.lock();
        try {
            if (f5337d == null) {
                f5337d = new a(context.getApplicationContext());
            }
            a aVar = f5337d;
            lock.unlock();
            return aVar;
        } catch (Throwable th) {
            f5336c.unlock();
            throw th;
        }
    }

    private static final String d(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    public GoogleSignInAccount b() {
        String c5;
        String c6 = c("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(c6) || (c5 = c(d("googleSignInAccount", c6))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.B(c5);
        } catch (JSONException unused) {
            return null;
        }
    }

    protected final String c(String str) {
        this.f5338a.lock();
        try {
            return this.f5339b.getString(str, null);
        } finally {
            this.f5338a.unlock();
        }
    }
}
