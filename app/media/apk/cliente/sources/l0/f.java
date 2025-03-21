package l0;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.app.q;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.m0;
import com.google.android.gms.common.api.internal.n0;
import com.google.android.gms.common.internal.c0;
import com.google.android.gms.common.internal.f0;
import com.google.android.gms.internal.base.zal;
/* loaded from: classes.dex */
public class f extends g {

    /* renamed from: c  reason: collision with root package name */
    private String f5884c;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f5882e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static final f f5883f = new f();

    /* renamed from: d  reason: collision with root package name */
    public static final int f5881d = g.f5885a;

    public static f m() {
        return f5883f;
    }

    @Override // l0.g
    public Intent a(Context context, int i5, String str) {
        return super.a(context, i5, str);
    }

    @Override // l0.g
    public PendingIntent b(Context context, int i5, int i6) {
        return super.b(context, i5, i6);
    }

    @Override // l0.g
    public final String d(int i5) {
        return super.d(i5);
    }

    @Override // l0.g
    public int f(Context context) {
        return super.f(context);
    }

    @Override // l0.g
    public int g(Context context, int i5) {
        return super.g(context, i5);
    }

    @Override // l0.g
    public final boolean i(int i5) {
        return super.i(i5);
    }

    public Dialog k(Activity activity, int i5, int i6, DialogInterface.OnCancelListener onCancelListener) {
        return p(activity, i5, f0.b(activity, a(activity, i5, "d"), i6), onCancelListener);
    }

    public PendingIntent l(Context context, a aVar) {
        return aVar.w() ? aVar.v() : b(context, aVar.t(), 0);
    }

    public boolean n(Activity activity, int i5, int i6, DialogInterface.OnCancelListener onCancelListener) {
        Dialog k5 = k(activity, i5, i6, onCancelListener);
        if (k5 == null) {
            return false;
        }
        s(activity, k5, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void o(Context context, int i5) {
        t(context, i5, null, c(context, i5, 0, "n"));
    }

    final Dialog p(Context context, int i5, f0 f0Var, DialogInterface.OnCancelListener onCancelListener) {
        if (i5 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(c0.d(context, i5));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c5 = c0.c(context, i5);
        if (c5 != null) {
            builder.setPositiveButton(c5, f0Var);
        }
        String g5 = c0.g(context, i5);
        if (g5 != null) {
            builder.setTitle(g5);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i5)), new IllegalArgumentException());
        return builder.create();
    }

    public final Dialog q(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(c0.d(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        s(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public final n0 r(Context context, m0 m0Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        n0 n0Var = new n0(m0Var);
        context.registerReceiver(n0Var, intentFilter);
        n0Var.a(context);
        if (h(context, "com.google.android.gms")) {
            return n0Var;
        }
        m0Var.a();
        n0Var.b();
        return null;
    }

    final void s(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof o.x) {
                n.P1(dialog, onCancelListener).O1(((o.x) activity).O(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* JADX WARN: Type inference failed for: r12v6, types: [android.app.NotificationChannel] */
    final void t(Context context, int i5, String str, PendingIntent pendingIntent) {
        int i6;
        String str2;
        NotificationChannel notificationChannel;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i5), null), new IllegalArgumentException());
        if (i5 == 18) {
            u(context);
        } else if (pendingIntent == null) {
            if (i5 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        } else {
            String f5 = c0.f(context, i5);
            String e5 = c0.e(context, i5);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) com.google.android.gms.common.internal.q.k(context.getSystemService("notification"));
            q.d n5 = new q.d(context).k(true).e(true).i(f5).n(new q.b().h(e5));
            if (q0.g.b(context)) {
                com.google.android.gms.common.internal.q.m(q0.j.d());
                n5.m(context.getApplicationInfo().icon).l(2);
                if (q0.g.c(context)) {
                    n5.a(k0.a.common_full_open_on_phone, resources.getString(k0.b.common_open_on_phone), pendingIntent);
                } else {
                    n5.g(pendingIntent);
                }
            } else {
                n5.m(17301642).o(resources.getString(k0.b.common_google_play_services_notification_ticker)).p(System.currentTimeMillis()).g(pendingIntent).h(e5);
            }
            if (q0.j.g()) {
                com.google.android.gms.common.internal.q.m(q0.j.g());
                synchronized (f5882e) {
                    str2 = this.f5884c;
                }
                if (str2 == null) {
                    str2 = "com.google.android.gms.availability";
                    notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                    String b5 = c0.b(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new Parcelable("com.google.android.gms.availability", b5, 4) { // from class: android.app.NotificationChannel
                            static {
                                throw new NoClassDefFoundError();
                            }

                            public native /* synthetic */ CharSequence getName();

                            public native /* synthetic */ void setName(CharSequence charSequence);
                        });
                    } else if (!b5.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(b5);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                n5.f(str2);
            }
            Notification b6 = n5.b();
            if (i5 == 1 || i5 == 2 || i5 == 3) {
                k.f5891b.set(false);
                i6 = 10436;
            } else {
                i6 = 39789;
            }
            notificationManager.notify(i6, b6);
        }
    }

    final void u(Context context) {
        new p(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean v(Activity activity, com.google.android.gms.common.api.internal.i iVar, int i5, int i6, DialogInterface.OnCancelListener onCancelListener) {
        Dialog p5 = p(activity, i5, f0.c(iVar, a(activity, i5, "d"), 2), onCancelListener);
        if (p5 == null) {
            return false;
        }
        s(activity, p5, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean w(Context context, a aVar, int i5) {
        PendingIntent l5;
        if (s0.b.a(context) || (l5 = l(context, aVar)) == null) {
            return false;
        }
        t(context, aVar.t(), null, zal.zaa(context, 0, GoogleApiActivity.a(context, l5, i5, true), zal.zaa | 134217728));
        return true;
    }
}
