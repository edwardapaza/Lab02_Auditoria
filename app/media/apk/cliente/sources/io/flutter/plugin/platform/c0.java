package io.flutter.plugin.platform;

import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
/* loaded from: classes.dex */
abstract class c0 implements WindowManager {

    /* renamed from: a  reason: collision with root package name */
    final WindowManager f4012a;

    /* renamed from: b  reason: collision with root package name */
    x f4013b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(WindowManager windowManager, x xVar) {
        this.f4012a = windowManager;
        this.f4013b = xVar;
    }

    @Override // android.view.WindowManager
    public void addCrossWindowBlurEnabledListener(Executor executor, Consumer<Boolean> consumer) {
        this.f4012a.addCrossWindowBlurEnabledListener(executor, consumer);
    }

    @Override // android.view.WindowManager
    public void addCrossWindowBlurEnabledListener(Consumer<Boolean> consumer) {
        this.f4012a.addCrossWindowBlurEnabledListener(consumer);
    }

    @Override // android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        x xVar = this.f4013b;
        if (xVar == null) {
            n2.b.g("PlatformViewsController", "Embedded view called addView while detached from presentation");
        } else {
            xVar.addView(view, layoutParams);
        }
    }

    @Override // android.view.WindowManager
    public WindowMetrics getCurrentWindowMetrics() {
        WindowMetrics currentWindowMetrics;
        currentWindowMetrics = this.f4012a.getCurrentWindowMetrics();
        return currentWindowMetrics;
    }

    @Override // android.view.WindowManager
    @Deprecated
    public Display getDefaultDisplay() {
        return this.f4012a.getDefaultDisplay();
    }

    @Override // android.view.WindowManager
    public WindowMetrics getMaximumWindowMetrics() {
        WindowMetrics maximumWindowMetrics;
        maximumWindowMetrics = this.f4012a.getMaximumWindowMetrics();
        return maximumWindowMetrics;
    }

    @Override // android.view.WindowManager
    public boolean isCrossWindowBlurEnabled() {
        boolean isCrossWindowBlurEnabled;
        isCrossWindowBlurEnabled = this.f4012a.isCrossWindowBlurEnabled();
        return isCrossWindowBlurEnabled;
    }

    @Override // android.view.WindowManager
    public void removeCrossWindowBlurEnabledListener(Consumer<Boolean> consumer) {
        this.f4012a.removeCrossWindowBlurEnabledListener(consumer);
    }

    @Override // android.view.ViewManager
    public void removeView(View view) {
        x xVar = this.f4013b;
        if (xVar == null) {
            n2.b.g("PlatformViewsController", "Embedded view called removeView while detached from presentation");
        } else {
            xVar.removeView(view);
        }
    }

    @Override // android.view.WindowManager
    public void removeViewImmediate(View view) {
        if (this.f4013b == null) {
            n2.b.g("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
            return;
        }
        view.clearAnimation();
        this.f4013b.removeView(view);
    }

    @Override // android.view.ViewManager
    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        x xVar = this.f4013b;
        if (xVar == null) {
            n2.b.g("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
        } else {
            xVar.updateViewLayout(view, layoutParams);
        }
    }
}
