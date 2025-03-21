package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
/* loaded from: classes.dex */
public abstract class f0 implements DialogInterface.OnClickListener {
    public static f0 b(Activity activity, Intent intent, int i5) {
        return new d0(intent, activity, i5);
    }

    public static f0 c(com.google.android.gms.common.api.internal.i iVar, Intent intent, int i5) {
        return new e0(intent, iVar, 2);
    }

    protected abstract void a();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        try {
            a();
        } catch (ActivityNotFoundException e5) {
            Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e5);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
