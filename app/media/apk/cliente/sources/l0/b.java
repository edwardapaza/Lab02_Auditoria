package l0;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f5875a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f5876b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f5877c;

    public static b a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        b bVar = new b();
        Dialog dialog2 = (Dialog) com.google.android.gms.common.internal.q.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        bVar.f5875a = dialog2;
        if (onCancelListener != null) {
            bVar.f5876b = onCancelListener;
        }
        return bVar;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f5876b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f5875a;
        if (dialog == null) {
            setShowsDialog(false);
            if (this.f5877c == null) {
                this.f5877c = new AlertDialog.Builder((Context) com.google.android.gms.common.internal.q.k(getActivity())).create();
            }
            return this.f5877c;
        }
        return dialog;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
