package androidx.activity;

import android.window.BackEvent;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f89a = new a();

    private a() {
    }

    public final BackEvent a(float f5, float f6, float f7, int i5) {
        return new BackEvent(f5, f6, f7, i5);
    }

    public final float b(BackEvent backEvent) {
        e4.k.e(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    public final int c(BackEvent backEvent) {
        e4.k.e(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    public final float d(BackEvent backEvent) {
        e4.k.e(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    public final float e(BackEvent backEvent) {
        e4.k.e(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
