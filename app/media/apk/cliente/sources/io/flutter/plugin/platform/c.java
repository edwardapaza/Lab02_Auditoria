package io.flutter.plugin.platform;

import android.content.Context;
import android.view.MotionEvent;
import io.flutter.embedding.android.l;
/* loaded from: classes.dex */
public class c extends io.flutter.embedding.android.l {

    /* renamed from: k  reason: collision with root package name */
    private a f4011k;

    public c(Context context, int i5, int i6, a aVar) {
        super(context, i5, i6, l.b.overlay);
        this.f4011k = aVar;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        a aVar = this.f4011k;
        if (aVar == null || !aVar.a(motionEvent, true)) {
            return super.onHoverEvent(motionEvent);
        }
        return true;
    }
}
