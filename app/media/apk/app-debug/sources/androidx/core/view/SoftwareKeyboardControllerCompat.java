package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class SoftwareKeyboardControllerCompat {
    private final Impl mImpl;

    public SoftwareKeyboardControllerCompat(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(view);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.mImpl = new Impl20(view);
        } else {
            this.mImpl = new Impl();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public SoftwareKeyboardControllerCompat(WindowInsetsController windowInsetsController) {
        this.mImpl = new Impl30(windowInsetsController);
    }

    public void show() {
        this.mImpl.show();
    }

    public void hide() {
        this.mImpl.hide();
    }

    /* loaded from: classes.dex */
    private static class Impl {
        Impl() {
        }

        void show() {
        }

        void hide() {
        }
    }

    /* loaded from: classes.dex */
    private static class Impl20 extends Impl {
        private final View mView;

        Impl20(View view) {
            this.mView = view;
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void show() {
            View view = this.mView;
            if (view == null) {
                return;
            }
            if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                view.requestFocus();
            } else {
                view = view.getRootView().findFocus();
            }
            if (view == null) {
                view = this.mView.getRootView().findViewById(16908290);
            }
            if (view != null && view.hasWindowFocus()) {
                final View finalView = view;
                finalView.post(new Runnable() { // from class: androidx.core.view.SoftwareKeyboardControllerCompat$Impl20$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SoftwareKeyboardControllerCompat.Impl20.lambda$show$0(finalView);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$show$0(View finalView) {
            InputMethodManager imm = (InputMethodManager) finalView.getContext().getSystemService("input_method");
            imm.showSoftInput(finalView, 0);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void hide() {
            View view = this.mView;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class Impl30 extends Impl20 {
        private View mView;
        private WindowInsetsController mWindowInsetsController;

        Impl30(View view) {
            super(view);
            this.mView = view;
        }

        Impl30(WindowInsetsController windowInsetsController) {
            super(null);
            this.mWindowInsetsController = windowInsetsController;
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void show() {
            if (this.mView != null && Build.VERSION.SDK_INT < 33) {
                InputMethodManager imm = (InputMethodManager) this.mView.getContext().getSystemService("input_method");
                imm.isActive();
            }
            WindowInsetsController insetsController = null;
            if (this.mWindowInsetsController != null) {
                insetsController = this.mWindowInsetsController;
            } else {
                View view = this.mView;
                if (view != null) {
                    insetsController = view.getWindowInsetsController();
                }
            }
            if (insetsController != null) {
                insetsController.show(WindowInsets.Type.ime());
            } else {
                super.show();
            }
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void hide() {
            View view;
            WindowInsetsController insetsController = null;
            if (this.mWindowInsetsController != null) {
                insetsController = this.mWindowInsetsController;
            } else {
                View view2 = this.mView;
                if (view2 != null) {
                    insetsController = view2.getWindowInsetsController();
                }
            }
            if (insetsController != null) {
                final AtomicBoolean isImeInsetsControllable = new AtomicBoolean(false);
                WindowInsetsController.OnControllableInsetsChangedListener listener = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0
                    @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i) {
                        isImeInsetsControllable.set((typeMask & 8) != 0);
                    }
                };
                insetsController.addOnControllableInsetsChangedListener(listener);
                if (!isImeInsetsControllable.get() && (view = this.mView) != null) {
                    InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService("input_method");
                    imm.hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
                }
                insetsController.removeOnControllableInsetsChangedListener(listener);
                insetsController.hide(WindowInsets.Type.ime());
                return;
            }
            super.hide();
        }
    }
}
