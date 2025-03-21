package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.q;
/* loaded from: classes.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    protected int f872a = 0;

    public static Intent a(Context context, PendingIntent pendingIntent, int i5, boolean z4) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i5);
        intent.putExtra("notify_manager", z4);
        return intent;
    }

    private final void b() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent == null) {
            l0.f.m().n(this, ((Integer) q.k(num)).intValue(), 2, this);
            this.f872a = 1;
        } else {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                this.f872a = 1;
            } catch (ActivityNotFoundException e5) {
                if (extras.getBoolean("notify_manager", true)) {
                    com.google.android.gms.common.api.internal.f.x(this).I(new l0.a(22, null), getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    String obj = pendingIntent.toString();
                    StringBuilder sb = new StringBuilder(obj.length() + 36);
                    sb.append("Activity not found while launching ");
                    sb.append(obj);
                    sb.append(".");
                    String sb2 = sb.toString();
                    if (Build.FINGERPRINT.contains("generic")) {
                        sb2 = sb2.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                    Log.e("GoogleApiActivity", sb2, e5);
                }
                this.f872a = 1;
                finish();
            } catch (IntentSender.SendIntentException e6) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e6);
                finish();
            }
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        if (i5 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f872a = 0;
            setResult(i6, intent);
            if (booleanExtra) {
                com.google.android.gms.common.api.internal.f x4 = com.google.android.gms.common.api.internal.f.x(this);
                if (i6 == -1) {
                    x4.a();
                } else if (i6 == 0) {
                    x4.I(new l0.a(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i5 == 2) {
            this.f872a = 0;
            setResult(i6, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f872a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f872a = bundle.getInt("resolution");
        }
        if (this.f872a != 1) {
            b();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f872a);
        super.onSaveInstanceState(bundle);
    }
}
