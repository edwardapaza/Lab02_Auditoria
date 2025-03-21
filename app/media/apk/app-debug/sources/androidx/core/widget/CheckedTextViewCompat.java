package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CheckedTextView;
/* loaded from: classes.dex */
public final class CheckedTextViewCompat {
    private CheckedTextViewCompat() {
    }

    public static void setCheckMarkTintList(CheckedTextView textView, ColorStateList tint) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.setCheckMarkTintList(textView, tint);
        } else if (textView instanceof TintableCheckedTextView) {
            ((TintableCheckedTextView) textView).setSupportCheckMarkTintList(tint);
        }
    }

    public static ColorStateList getCheckMarkTintList(CheckedTextView textView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getCheckMarkTintList(textView);
        }
        if (textView instanceof TintableCheckedTextView) {
            return ((TintableCheckedTextView) textView).getSupportCheckMarkTintList();
        }
        return null;
    }

    public static void setCheckMarkTintMode(CheckedTextView textView, PorterDuff.Mode tintMode) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.setCheckMarkTintMode(textView, tintMode);
        } else if (textView instanceof TintableCheckedTextView) {
            ((TintableCheckedTextView) textView).setSupportCheckMarkTintMode(tintMode);
        }
    }

    public static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView textView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getCheckMarkTintMode(textView);
        }
        if (textView instanceof TintableCheckedTextView) {
            return ((TintableCheckedTextView) textView).getSupportCheckMarkTintMode();
        }
        return null;
    }

    public static Drawable getCheckMarkDrawable(CheckedTextView textView) {
        return textView.getCheckMarkDrawable();
    }

    /* loaded from: classes.dex */
    private static class Api21Impl {
        private Api21Impl() {
        }

        static void setCheckMarkTintList(CheckedTextView textView, ColorStateList tint) {
            textView.setCheckMarkTintList(tint);
        }

        static ColorStateList getCheckMarkTintList(CheckedTextView textView) {
            return textView.getCheckMarkTintList();
        }

        static void setCheckMarkTintMode(CheckedTextView textView, PorterDuff.Mode tintMode) {
            textView.setCheckMarkTintMode(tintMode);
        }

        static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView textView) {
            return textView.getCheckMarkTintMode();
        }
    }
}
