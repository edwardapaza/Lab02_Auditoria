package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.b0;
import y2.e;
/* loaded from: classes.dex */
public class v implements b0.d {

    /* renamed from: a  reason: collision with root package name */
    private final y2.e f3755a;

    /* renamed from: b  reason: collision with root package name */
    private final b0.b f3756b = new b0.b();

    public v(y2.e eVar) {
        this.f3755a = eVar;
    }

    @Override // io.flutter.embedding.android.b0.d
    public void a(KeyEvent keyEvent, final b0.d.a aVar) {
        int action = keyEvent.getAction();
        if (action == 0 || action == 1) {
            this.f3755a.e(new e.b(keyEvent, this.f3756b.a(keyEvent.getUnicodeChar())), action != 0, new e.a() { // from class: io.flutter.embedding.android.u
                @Override // y2.e.a
                public final void a(boolean z4) {
                    b0.d.a.this.a(z4);
                }
            });
        } else {
            aVar.a(false);
        }
    }
}
