package s0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f7253a;

    public c(Context context) {
        this.f7253a = context;
    }

    @ResultIgnorabilityUnspecified
    public ApplicationInfo a(String str, int i5) {
        return this.f7253a.getPackageManager().getApplicationInfo(str, i5);
    }

    public CharSequence b(String str) {
        Context context = this.f7253a;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    @ResultIgnorabilityUnspecified
    public PackageInfo c(String str, int i5) {
        return this.f7253a.getPackageManager().getPackageInfo(str, i5);
    }
}
