package y2;

import android.window.BackEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import z2.j;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final z2.j f8599a;

    /* renamed from: b  reason: collision with root package name */
    private final j.c f8600b;

    /* loaded from: classes.dex */
    class a implements j.c {
        a() {
        }

        @Override // z2.j.c
        public void a(z2.i iVar, j.d dVar) {
            dVar.a(null);
        }
    }

    public b(o2.a aVar) {
        a aVar2 = new a();
        this.f8600b = aVar2;
        z2.j jVar = new z2.j(aVar, "flutter/backgesture", z2.q.f9018b);
        this.f8599a = jVar;
        jVar.e(aVar2);
    }

    private Map<String, Object> a(BackEvent backEvent) {
        HashMap hashMap = new HashMap(3);
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        hashMap.put("touchOffset", (Float.isNaN(touchX) || Float.isNaN(touchY)) ? null : Arrays.asList(Float.valueOf(touchX), Float.valueOf(touchY)));
        hashMap.put("progress", Float.valueOf(backEvent.getProgress()));
        hashMap.put("swipeEdge", Integer.valueOf(backEvent.getSwipeEdge()));
        return hashMap;
    }

    public void b() {
        n2.b.f("BackGestureChannel", "Sending message to cancel back gesture");
        this.f8599a.c("cancelBackGesture", null);
    }

    public void c() {
        n2.b.f("BackGestureChannel", "Sending message to commit back gesture");
        this.f8599a.c("commitBackGesture", null);
    }

    public void d(BackEvent backEvent) {
        n2.b.f("BackGestureChannel", "Sending message to start back gesture");
        this.f8599a.c("startBackGesture", a(backEvent));
    }

    public void e(BackEvent backEvent) {
        n2.b.f("BackGestureChannel", "Sending message to update back gesture progress");
        this.f8599a.c("updateBackGestureProgress", a(backEvent));
    }
}
