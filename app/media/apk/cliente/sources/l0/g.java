package l0;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.common.zzd;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5885a = k.f5890a;

    /* renamed from: b  reason: collision with root package name */
    private static final g f5886b = new g();

    public static g e() {
        return f5886b;
    }

    public Intent a(Context context, int i5, String str) {
        if (i5 != 1 && i5 != 2) {
            if (i5 != 3) {
                return null;
            }
            Uri fromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(fromParts);
            return intent;
        } else if (context != null && q0.g.c(context)) {
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("gcore_");
            sb.append(f5885a);
            sb.append("-");
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            sb.append("-");
            if (context != null) {
                sb.append(context.getPackageName());
            }
            sb.append("-");
            if (context != null) {
                try {
                    sb.append(s0.d.a(context).c(context.getPackageName(), 0).versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            String sb2 = sb.toString();
            Intent intent3 = new Intent("android.intent.action.VIEW");
            Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
            if (!TextUtils.isEmpty(sb2)) {
                appendQueryParameter.appendQueryParameter("pcampaignid", sb2);
            }
            intent3.setData(appendQueryParameter.build());
            intent3.setPackage("com.android.vending");
            intent3.addFlags(524288);
            return intent3;
        }
    }

    public PendingIntent b(Context context, int i5, int i6) {
        return c(context, i5, i6, null);
    }

    public PendingIntent c(Context context, int i5, int i6, String str) {
        Intent a5 = a(context, i5, str);
        if (a5 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i6, a5, zzd.zza | 134217728);
    }

    public String d(int i5) {
        return k.b(i5);
    }

    @ResultIgnorabilityUnspecified
    public int f(Context context) {
        return g(context, f5885a);
    }

    public int g(Context context, int i5) {
        int e5 = k.e(context, i5);
        if (k.f(context, e5)) {
            return 18;
        }
        return e5;
    }

    public boolean h(Context context, String str) {
        return k.i(context, str);
    }

    public boolean i(int i5) {
        return k.h(i5);
    }

    public void j(Context context, int i5) {
        k.a(context, i5);
    }
}
