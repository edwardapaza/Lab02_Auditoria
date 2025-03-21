package io.flutter.plugin.platform;

import android.view.Surface;
/* loaded from: classes.dex */
public interface n {
    void a(int i5, int i6);

    int getHeight();

    long getId();

    Surface getSurface();

    int getWidth();

    void release();

    void scheduleFrame();
}
