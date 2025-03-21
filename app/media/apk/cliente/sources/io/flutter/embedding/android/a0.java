package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.b0;
import io.flutter.embedding.android.c0;
import io.flutter.embedding.android.w;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import z2.b;
/* loaded from: classes.dex */
public class a0 implements b0.d {

    /* renamed from: a  reason: collision with root package name */
    private final z2.b f3626a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<Long, Long> f3627b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<Long, c0.e> f3628c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final b0.b f3629d = new b0.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3630a;

        static {
            int[] iArr = new int[w.b.values().length];
            f3630a = iArr;
            try {
                iArr[w.b.kDown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3630a[w.b.kUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3630a[w.b.kRepeat.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a0(z2.b bVar) {
        c0.e[] a5;
        this.f3626a = bVar;
        for (c0.e eVar : c0.a()) {
            this.f3628c.put(Long.valueOf(eVar.f3656c), eVar);
        }
    }

    private static w.b e(KeyEvent keyEvent) {
        boolean z4 = keyEvent.getRepeatCount() > 0;
        int action = keyEvent.getAction();
        if (action == 0) {
            return z4 ? w.b.kRepeat : w.b.kDown;
        } else if (action == 1) {
            return w.b.kUp;
        } else {
            throw new AssertionError("Unexpected event type");
        }
    }

    private Long f(KeyEvent keyEvent) {
        Long l5 = c0.f3648b.get(Long.valueOf(keyEvent.getKeyCode()));
        return l5 != null ? l5 : Long.valueOf(j(keyEvent.getKeyCode(), 73014444032L));
    }

    private Long g(KeyEvent keyEvent) {
        int scanCode;
        long scanCode2 = keyEvent.getScanCode();
        if (scanCode2 == 0) {
            scanCode = keyEvent.getKeyCode();
        } else {
            Long l5 = c0.f3647a.get(Long.valueOf(scanCode2));
            if (l5 != null) {
                return l5;
            }
            scanCode = keyEvent.getScanCode();
        }
        return Long.valueOf(j(scanCode, 73014444032L));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0144 A[LOOP:2: B:69:0x013e->B:71:0x0144, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean i(android.view.KeyEvent r18, io.flutter.embedding.android.b0.d.a r19) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.a0.i(android.view.KeyEvent, io.flutter.embedding.android.b0$d$a):boolean");
    }

    private static long j(long j5, long j6) {
        return (j5 & 4294967295L) | j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(b0.d.a aVar, ByteBuffer byteBuffer) {
        Boolean bool = Boolean.FALSE;
        if (byteBuffer != null) {
            byteBuffer.rewind();
            if (byteBuffer.capacity() != 0) {
                bool = Boolean.valueOf(byteBuffer.get() != 0);
            }
        } else {
            n2.b.g("KeyEmbedderResponder", "A null reply was received when sending a key event to the framework.");
        }
        aVar.a(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(c0.c cVar, long j5, KeyEvent keyEvent) {
        q(false, Long.valueOf(cVar.f3651b), Long.valueOf(j5), keyEvent.getEventTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(c0.c cVar, KeyEvent keyEvent) {
        q(false, Long.valueOf(cVar.f3651b), Long.valueOf(cVar.f3650a), keyEvent.getEventTime());
    }

    private void n(w wVar, final b0.d.a aVar) {
        this.f3626a.a("flutter/keydata", wVar.a(), aVar == null ? null : new b.InterfaceC0139b() { // from class: io.flutter.embedding.android.x
            @Override // z2.b.InterfaceC0139b
            public final void a(ByteBuffer byteBuffer) {
                a0.k(b0.d.a.this, byteBuffer);
            }
        });
    }

    private void q(boolean z4, Long l5, Long l6, long j5) {
        w wVar = new w();
        wVar.f3757a = j5;
        wVar.f3758b = z4 ? w.b.kDown : w.b.kUp;
        wVar.f3760d = l5.longValue();
        wVar.f3759c = l6.longValue();
        wVar.f3763g = null;
        wVar.f3761e = true;
        wVar.f3762f = w.a.kKeyboard;
        if (l6.longValue() != 0 && l5.longValue() != 0) {
            if (!z4) {
                l5 = null;
            }
            r(l6, l5);
        }
        n(wVar, null);
    }

    @Override // io.flutter.embedding.android.b0.d
    public void a(KeyEvent keyEvent, b0.d.a aVar) {
        if (i(keyEvent, aVar)) {
            return;
        }
        q(true, 0L, 0L, 0L);
        aVar.a(true);
    }

    public Map<Long, Long> h() {
        return Collections.unmodifiableMap(this.f3627b);
    }

    void o(c0.d dVar, boolean z4, long j5, final long j6, final KeyEvent keyEvent, ArrayList<Runnable> arrayList) {
        c0.c[] cVarArr = dVar.f3653b;
        boolean[] zArr = new boolean[cVarArr.length];
        Boolean[] boolArr = new Boolean[cVarArr.length];
        boolean z5 = false;
        int i5 = 0;
        while (true) {
            c0.c[] cVarArr2 = dVar.f3653b;
            boolean z6 = true;
            if (i5 >= cVarArr2.length) {
                break;
            }
            final c0.c cVar = cVarArr2[i5];
            boolean containsKey = this.f3627b.containsKey(Long.valueOf(cVar.f3650a));
            zArr[i5] = containsKey;
            if (cVar.f3651b == j5) {
                int i6 = a.f3630a[e(keyEvent).ordinal()];
                if (i6 == 1) {
                    boolArr[i5] = Boolean.FALSE;
                    if (!z4) {
                        arrayList.add(new Runnable() { // from class: io.flutter.embedding.android.y
                            @Override // java.lang.Runnable
                            public final void run() {
                                a0.this.l(cVar, j6, keyEvent);
                            }
                        });
                    }
                } else if (i6 == 2) {
                    boolArr[i5] = Boolean.valueOf(zArr[i5]);
                } else if (i6 == 3) {
                    if (!z4) {
                        arrayList.add(new Runnable() { // from class: io.flutter.embedding.android.z
                            @Override // java.lang.Runnable
                            public final void run() {
                                a0.this.m(cVar, keyEvent);
                            }
                        });
                    }
                    boolArr[i5] = Boolean.valueOf(zArr[i5]);
                }
                z5 = true;
            } else {
                if (!z5 && !containsKey) {
                    z6 = false;
                }
                z5 = z6;
            }
            i5++;
        }
        if (z4) {
            for (int i7 = 0; i7 < dVar.f3653b.length; i7++) {
                if (boolArr[i7] == null) {
                    if (z5) {
                        boolArr[i7] = Boolean.valueOf(zArr[i7]);
                    } else {
                        boolArr[i7] = Boolean.TRUE;
                        z5 = true;
                    }
                }
            }
            if (!z5) {
                boolArr[0] = Boolean.TRUE;
            }
        } else {
            for (int i8 = 0; i8 < dVar.f3653b.length; i8++) {
                if (boolArr[i8] == null) {
                    boolArr[i8] = Boolean.FALSE;
                }
            }
        }
        for (int i9 = 0; i9 < dVar.f3653b.length; i9++) {
            if (zArr[i9] != boolArr[i9].booleanValue()) {
                c0.c cVar2 = dVar.f3653b[i9];
                q(boolArr[i9].booleanValue(), Long.valueOf(cVar2.f3651b), Long.valueOf(cVar2.f3650a), keyEvent.getEventTime());
            }
        }
    }

    void p(c0.e eVar, boolean z4, long j5, KeyEvent keyEvent) {
        if (eVar.f3656c == j5 || eVar.f3657d == z4) {
            return;
        }
        boolean z5 = !this.f3627b.containsKey(Long.valueOf(eVar.f3655b));
        if (z5) {
            eVar.f3657d = !eVar.f3657d;
        }
        q(z5, Long.valueOf(eVar.f3656c), Long.valueOf(eVar.f3655b), keyEvent.getEventTime());
        if (!z5) {
            eVar.f3657d = !eVar.f3657d;
        }
        q(!z5, Long.valueOf(eVar.f3656c), Long.valueOf(eVar.f3655b), keyEvent.getEventTime());
    }

    void r(Long l5, Long l6) {
        if (l6 != null) {
            if (this.f3627b.put(l5, l6) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (this.f3627b.remove(l5) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}
