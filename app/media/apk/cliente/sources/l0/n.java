package l0;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import o.l0;
/* loaded from: classes.dex */
public class n extends o.q {
    private Dialog A0;

    /* renamed from: y0  reason: collision with root package name */
    private Dialog f5895y0;

    /* renamed from: z0  reason: collision with root package name */
    private DialogInterface.OnCancelListener f5896z0;

    public static n P1(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        n nVar = new n();
        Dialog dialog2 = (Dialog) com.google.android.gms.common.internal.q.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        nVar.f5895y0 = dialog2;
        if (onCancelListener != null) {
            nVar.f5896z0 = onCancelListener;
        }
        return nVar;
    }

    @Override // o.q
    public Dialog I1(Bundle bundle) {
        Dialog dialog = this.f5895y0;
        if (dialog == null) {
            M1(false);
            if (this.A0 == null) {
                this.A0 = new AlertDialog.Builder((Context) com.google.android.gms.common.internal.q.k(u())).create();
            }
            return this.A0;
        }
        return dialog;
    }

    @Override // o.q
    public void O1(l0 l0Var, String str) {
        super.O1(l0Var, str);
    }

    @Override // o.q, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f5896z0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
