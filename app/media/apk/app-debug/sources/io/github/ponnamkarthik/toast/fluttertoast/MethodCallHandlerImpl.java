package io.github.ponnamkarthik.toast.fluttertoast;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MethodCallHandlerImpl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/github/ponnamkarthik/toast/fluttertoast/MethodCallHandlerImpl;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mToast", "Landroid/widget/Toast;", "onMethodCall", "", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "fluttertoast_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private Context context;
    private Toast mToast;

    public MethodCallHandlerImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        int i;
        Toast toast;
        Drawable gradientDrawable;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = call.method;
        if (Intrinsics.areEqual(str, "showToast")) {
            String mMessage = String.valueOf(call.argument(NotificationCompat.CATEGORY_MESSAGE));
            String length = String.valueOf(call.argument("length"));
            String gravity = String.valueOf(call.argument("gravity"));
            Number bgcolor = (Number) call.argument("bgcolor");
            Number textcolor = (Number) call.argument("textcolor");
            Number textSize = (Number) call.argument("fontSize");
            if (Intrinsics.areEqual(gravity, "top")) {
                i = 48;
            } else {
                i = Intrinsics.areEqual(gravity, "center") ? 17 : 80;
            }
            int mGravity = i;
            int mDuration = Intrinsics.areEqual(length, "long") ? 1 : 0;
            if (bgcolor != null) {
                Object systemService = this.context.getSystemService("layout_inflater");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                View layout = ((LayoutInflater) systemService).inflate(R.layout.toast_custom, (ViewGroup) null);
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText(mMessage);
                if (Build.VERSION.SDK_INT >= 21) {
                    gradientDrawable = this.context.getDrawable(R.drawable.corner);
                    Intrinsics.checkNotNull(gradientDrawable);
                } else {
                    gradientDrawable = ContextCompat.getDrawable(this.context, R.drawable.corner);
                }
                Intrinsics.checkNotNull(gradientDrawable);
                gradientDrawable.setColorFilter(bgcolor.intValue(), PorterDuff.Mode.SRC_IN);
                text.setBackground(gradientDrawable);
                if (textSize != null) {
                    text.setTextSize(textSize.floatValue());
                }
                if (textcolor != null) {
                    text.setTextColor(textcolor.intValue());
                }
                Toast toast2 = new Toast(this.context);
                this.mToast = toast2;
                toast2.setDuration(mDuration);
                Toast toast3 = this.mToast;
                if (toast3 != null) {
                    toast3.setView(layout);
                }
            } else {
                try {
                    Toast makeText = Toast.makeText(this.context, mMessage, mDuration);
                    this.mToast = makeText;
                    View view = makeText != null ? makeText.getView() : null;
                    Intrinsics.checkNotNull(view);
                    View findViewById = view.findViewById(16908299);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                    TextView textView = (TextView) findViewById;
                    if (textSize != null) {
                        textView.setTextSize(textSize.floatValue());
                    }
                    if (textcolor != null) {
                        textView.setTextColor(textcolor.intValue());
                    }
                } catch (Exception e) {
                }
            }
            try {
                switch (mGravity) {
                    case 17:
                        Toast toast4 = this.mToast;
                        if (toast4 != null) {
                            toast4.setGravity(mGravity, 0, 0);
                            break;
                        }
                        break;
                    case 48:
                        Toast toast5 = this.mToast;
                        if (toast5 != null) {
                            toast5.setGravity(mGravity, 0, 100);
                            break;
                        }
                        break;
                    default:
                        Toast toast6 = this.mToast;
                        if (toast6 != null) {
                            toast6.setGravity(mGravity, 0, 100);
                            break;
                        }
                        break;
                }
            } catch (Exception e2) {
            }
            Context context = this.context;
            if (context instanceof Activity) {
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                ((Activity) context).runOnUiThread(new Runnable() { // from class: io.github.ponnamkarthik.toast.fluttertoast.MethodCallHandlerImpl$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        MethodCallHandlerImpl.onMethodCall$lambda$0(MethodCallHandlerImpl.this);
                    }
                });
            } else {
                Toast toast7 = this.mToast;
                if (toast7 != null) {
                    toast7.show();
                }
            }
            if (Build.VERSION.SDK_INT >= 30 && (toast = this.mToast) != null) {
                toast.addCallback(new Toast.Callback() { // from class: io.github.ponnamkarthik.toast.fluttertoast.MethodCallHandlerImpl$onMethodCall$2
                    @Override // android.widget.Toast.Callback
                    public void onToastHidden() {
                        super.onToastHidden();
                        MethodCallHandlerImpl.this.mToast = null;
                    }
                });
            }
            result.success(true);
        } else if (Intrinsics.areEqual(str, "cancel")) {
            Toast toast8 = this.mToast;
            if (toast8 != null) {
                if (toast8 != null) {
                    toast8.cancel();
                }
                this.mToast = null;
            }
            result.success(true);
        } else {
            result.notImplemented();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMethodCall$lambda$0(MethodCallHandlerImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast toast = this$0.mToast;
        if (toast != null) {
            toast.show();
        }
    }
}
