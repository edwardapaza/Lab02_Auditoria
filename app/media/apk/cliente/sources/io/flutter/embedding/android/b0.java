package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import com.google.android.gms.common.api.a;
import io.flutter.plugin.editing.d;
import java.util.HashSet;
import java.util.Map;
import y2.f;
/* loaded from: classes.dex */
public class b0 implements d.a, f.b {

    /* renamed from: a  reason: collision with root package name */
    protected final d[] f3631a;

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<KeyEvent> f3632b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private final e f3633c;

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private int f3634a = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Character a(int i5) {
            char c5 = (char) i5;
            if ((Integer.MIN_VALUE & i5) != 0) {
                int i6 = i5 & a.e.API_PRIORITY_OTHER;
                int i7 = this.f3634a;
                if (i7 != 0) {
                    i6 = KeyCharacterMap.getDeadChar(i7, i6);
                }
                this.f3634a = i6;
            } else {
                int i8 = this.f3634a;
                if (i8 != 0) {
                    int deadChar = KeyCharacterMap.getDeadChar(i8, i5);
                    if (deadChar > 0) {
                        c5 = (char) deadChar;
                    }
                    this.f3634a = 0;
                }
            }
            return Character.valueOf(c5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        final KeyEvent f3635a;

        /* renamed from: b  reason: collision with root package name */
        int f3636b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3637c = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class a implements d.a {

            /* renamed from: a  reason: collision with root package name */
            boolean f3639a;

            private a() {
                this.f3639a = false;
            }

            @Override // io.flutter.embedding.android.b0.d.a
            public void a(boolean z4) {
                if (this.f3639a) {
                    throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
                }
                this.f3639a = true;
                c cVar = c.this;
                int i5 = cVar.f3636b - 1;
                cVar.f3636b = i5;
                boolean z5 = z4 | cVar.f3637c;
                cVar.f3637c = z5;
                if (i5 != 0 || z5) {
                    return;
                }
                b0.this.e(cVar.f3635a);
            }
        }

        c(KeyEvent keyEvent) {
            this.f3636b = b0.this.f3631a.length;
            this.f3635a = keyEvent;
        }

        public d.a a() {
            return new a();
        }
    }

    /* loaded from: classes.dex */
    public interface d {

        /* loaded from: classes.dex */
        public interface a {
            void a(boolean z4);
        }

        void a(KeyEvent keyEvent, a aVar);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(KeyEvent keyEvent);

        boolean c(KeyEvent keyEvent);

        z2.b getBinaryMessenger();
    }

    public b0(e eVar) {
        this.f3633c = eVar;
        this.f3631a = new d[]{new a0(eVar.getBinaryMessenger()), new v(new y2.e(eVar.getBinaryMessenger()))};
        new y2.f(eVar.getBinaryMessenger()).b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(KeyEvent keyEvent) {
        e eVar = this.f3633c;
        if (eVar == null || eVar.c(keyEvent)) {
            return;
        }
        this.f3632b.add(keyEvent);
        this.f3633c.a(keyEvent);
        if (this.f3632b.remove(keyEvent)) {
            n2.b.g("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
        }
    }

    @Override // y2.f.b
    public Map<Long, Long> a() {
        return ((a0) this.f3631a[0]).h();
    }

    @Override // io.flutter.plugin.editing.d.a
    public boolean b(KeyEvent keyEvent) {
        if (this.f3632b.remove(keyEvent)) {
            return false;
        }
        if (this.f3631a.length <= 0) {
            e(keyEvent);
            return true;
        }
        c cVar = new c(keyEvent);
        for (d dVar : this.f3631a) {
            dVar.a(keyEvent, cVar.a());
        }
        return true;
    }

    public void d() {
        int size = this.f3632b.size();
        if (size > 0) {
            n2.b.g("KeyboardManager", "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }
}
