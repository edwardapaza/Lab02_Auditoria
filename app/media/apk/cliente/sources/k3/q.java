package k3;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private final d f5816a;

    /* renamed from: b  reason: collision with root package name */
    private final m3.c f5817b;

    /* renamed from: c  reason: collision with root package name */
    private int f5818c = 65535;

    /* renamed from: d  reason: collision with root package name */
    private final c f5819d = new c(0, 65535, null);

    /* loaded from: classes.dex */
    public interface b {
        void d(int i5);
    }

    /* loaded from: classes.dex */
    public final class c {

        /* renamed from: b  reason: collision with root package name */
        private Runnable f5821b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5822c;

        /* renamed from: d  reason: collision with root package name */
        private int f5823d;

        /* renamed from: e  reason: collision with root package name */
        private int f5824e;

        /* renamed from: f  reason: collision with root package name */
        private final b f5825f;

        /* renamed from: a  reason: collision with root package name */
        private final w4.c f5820a = new w4.c();

        /* renamed from: g  reason: collision with root package name */
        private boolean f5826g = false;

        c(int i5, int i6, b bVar) {
            this.f5822c = i5;
            this.f5823d = i6;
            this.f5825f = bVar;
        }

        void a(int i5) {
            this.f5824e += i5;
        }

        int b() {
            return this.f5824e;
        }

        void c() {
            this.f5824e = 0;
        }

        void d(w4.c cVar, int i5, boolean z4) {
            this.f5820a.Z(cVar, i5);
            this.f5826g |= z4;
        }

        boolean e() {
            return this.f5820a.size() > 0;
        }

        int f(int i5) {
            if (i5 <= 0 || a.e.API_PRIORITY_OTHER - i5 >= this.f5823d) {
                int i6 = this.f5823d + i5;
                this.f5823d = i6;
                return i6;
            }
            throw new IllegalArgumentException("Window size overflow for stream: " + this.f5822c);
        }

        int g() {
            return Math.max(0, Math.min(this.f5823d, (int) this.f5820a.size()));
        }

        int h() {
            return g() - this.f5824e;
        }

        int i() {
            return this.f5823d;
        }

        int j() {
            return Math.min(this.f5823d, q.this.f5819d.i());
        }

        void k(w4.c cVar, int i5, boolean z4) {
            do {
                int min = Math.min(i5, q.this.f5817b.V());
                int i6 = -min;
                q.this.f5819d.f(i6);
                f(i6);
                try {
                    q.this.f5817b.q(cVar.size() == ((long) min) && z4, this.f5822c, cVar, min);
                    this.f5825f.d(min);
                    i5 -= min;
                } catch (IOException e5) {
                    throw new RuntimeException(e5);
                }
            } while (i5 > 0);
        }

        int l(int i5, e eVar) {
            Runnable runnable;
            int min = Math.min(i5, j());
            int i6 = 0;
            while (e() && min > 0) {
                if (min >= this.f5820a.size()) {
                    i6 += (int) this.f5820a.size();
                    w4.c cVar = this.f5820a;
                    k(cVar, (int) cVar.size(), this.f5826g);
                } else {
                    i6 += min;
                    k(this.f5820a, min, false);
                }
                eVar.b();
                min = Math.min(i5 - i6, j());
            }
            if (!e() && (runnable = this.f5821b) != null) {
                runnable.run();
                this.f5821b = null;
            }
            return i6;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        c[] a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        int f5828a;

        private e() {
        }

        boolean a() {
            return this.f5828a > 0;
        }

        void b() {
            this.f5828a++;
        }
    }

    public q(d dVar, m3.c cVar) {
        this.f5816a = (d) z0.k.o(dVar, "transport");
        this.f5817b = (m3.c) z0.k.o(cVar, "frameWriter");
    }

    public c c(b bVar, int i5) {
        return new c(i5, this.f5818c, (b) z0.k.o(bVar, "stream"));
    }

    public void d(boolean z4, c cVar, w4.c cVar2, boolean z5) {
        z0.k.o(cVar2, "source");
        int j5 = cVar.j();
        boolean e5 = cVar.e();
        int size = (int) cVar2.size();
        if (e5 || j5 < size) {
            if (!e5 && j5 > 0) {
                cVar.k(cVar2, j5, false);
            }
            cVar.d(cVar2, (int) cVar2.size(), z4);
        } else {
            cVar.k(cVar2, size, z4);
        }
        if (z5) {
            e();
        }
    }

    public void e() {
        try {
            this.f5817b.flush();
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }

    public boolean f(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("Invalid initial window size: " + i5);
        }
        int i6 = i5 - this.f5818c;
        this.f5818c = i5;
        for (c cVar : this.f5816a.a()) {
            cVar.f(i6);
        }
        return i6 > 0;
    }

    public int g(c cVar, int i5) {
        if (cVar == null) {
            int f5 = this.f5819d.f(i5);
            h();
            return f5;
        }
        int f6 = cVar.f(i5);
        e eVar = new e();
        cVar.l(cVar.j(), eVar);
        if (eVar.a()) {
            e();
        }
        return f6;
    }

    public void h() {
        int i5;
        c[] a5 = this.f5816a.a();
        Collections.shuffle(Arrays.asList(a5));
        int i6 = this.f5819d.i();
        int length = a5.length;
        while (true) {
            i5 = 0;
            if (length <= 0 || i6 <= 0) {
                break;
            }
            int ceil = (int) Math.ceil(i6 / length);
            for (int i7 = 0; i7 < length && i6 > 0; i7++) {
                c cVar = a5[i7];
                int min = Math.min(i6, Math.min(cVar.h(), ceil));
                if (min > 0) {
                    cVar.a(min);
                    i6 -= min;
                }
                if (cVar.h() > 0) {
                    a5[i5] = cVar;
                    i5++;
                }
            }
            length = i5;
        }
        e eVar = new e();
        c[] a6 = this.f5816a.a();
        int length2 = a6.length;
        while (i5 < length2) {
            c cVar2 = a6[i5];
            cVar2.l(cVar2.b(), eVar);
            cVar2.c();
            i5++;
        }
        if (eVar.a()) {
            e();
        }
    }
}
