package io.flutter.plugin.editing;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets$Builder;
import android.view.WindowInsets$Type;
import android.view.WindowInsetsAnimation;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ImeSyncDeferringInsetsCallback {
    private WindowInsets lastWindowInsets;
    private View view;
    private final int deferredInsetTypes = WindowInsets$Type.ime();
    private boolean animating = false;
    private boolean needsSave = false;
    private AnimationCallback animationCallback = new AnimationCallback();
    private b insetsListener = new b();

    /* loaded from: classes.dex */
    private class AnimationCallback extends WindowInsetsAnimation.Callback {
        AnimationCallback() {
            new Object(1) { // from class: android.view.WindowInsetsAnimation.Callback
                static {
                    throw new NoClassDefFoundError();
                }
            };
        }

        public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
            if (!ImeSyncDeferringInsetsCallback.this.animating || (windowInsetsAnimation.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) == 0) {
                return;
            }
            ImeSyncDeferringInsetsCallback.this.animating = false;
            if (ImeSyncDeferringInsetsCallback.this.lastWindowInsets == null || ImeSyncDeferringInsetsCallback.this.view == null) {
                return;
            }
            ImeSyncDeferringInsetsCallback.this.view.dispatchApplyWindowInsets(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
        }

        public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
            ImeSyncDeferringInsetsCallback.this.needsSave = true;
            if ((windowInsetsAnimation.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                ImeSyncDeferringInsetsCallback.this.animating = true;
            }
        }

        public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
            int i5;
            Insets insets;
            Insets insets2;
            if (ImeSyncDeferringInsetsCallback.this.animating && !ImeSyncDeferringInsetsCallback.this.needsSave) {
                boolean z4 = false;
                for (WindowInsetsAnimation windowInsetsAnimation : list) {
                    if ((windowInsetsAnimation.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                        z4 = true;
                    }
                }
                if (!z4) {
                    return windowInsets;
                }
                int windowSystemUiVisibility = ImeSyncDeferringInsetsCallback.this.view.getWindowSystemUiVisibility();
                if ((windowSystemUiVisibility & 512) == 0 && (windowSystemUiVisibility & 2) == 0) {
                    insets2 = windowInsets.getInsets(WindowInsets$Type.navigationBars());
                    i5 = insets2.bottom;
                } else {
                    i5 = 0;
                }
                WindowInsets$Builder windowInsets$Builder = new WindowInsets$Builder(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
                insets = windowInsets.getInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes);
                windowInsets$Builder.setInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes, Insets.of(0, 0, 0, Math.max(insets.bottom - i5, 0)));
                ImeSyncDeferringInsetsCallback.this.view.onApplyWindowInsets(windowInsets$Builder.build());
            }
            return windowInsets;
        }
    }

    /* loaded from: classes.dex */
    private class b implements View.OnApplyWindowInsetsListener {
        private b() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ImeSyncDeferringInsetsCallback.this.view = view;
            if (ImeSyncDeferringInsetsCallback.this.needsSave) {
                ImeSyncDeferringInsetsCallback.this.lastWindowInsets = windowInsets;
                ImeSyncDeferringInsetsCallback.this.needsSave = false;
            }
            return ImeSyncDeferringInsetsCallback.this.animating ? WindowInsets.CONSUMED : view.onApplyWindowInsets(windowInsets);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImeSyncDeferringInsetsCallback(View view) {
        this.view = view;
    }

    WindowInsetsAnimation.Callback getAnimationCallback() {
        return this.animationCallback;
    }

    View.OnApplyWindowInsetsListener getInsetsListener() {
        return this.insetsListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void install() {
        this.view.setWindowInsetsAnimationCallback(this.animationCallback);
        this.view.setOnApplyWindowInsetsListener(this.insetsListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove() {
        this.view.setWindowInsetsAnimationCallback(null);
        this.view.setOnApplyWindowInsetsListener(null);
    }
}
