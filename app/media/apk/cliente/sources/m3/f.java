package m3;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import w4.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final w4.f f6122a = w4.f.e(":");

    /* renamed from: b  reason: collision with root package name */
    private static final d[] f6123b;

    /* renamed from: c  reason: collision with root package name */
    private static final Map<w4.f, Integer> f6124c;

    /* loaded from: classes.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<d> f6125a;

        /* renamed from: b  reason: collision with root package name */
        private final w4.e f6126b;

        /* renamed from: c  reason: collision with root package name */
        private int f6127c;

        /* renamed from: d  reason: collision with root package name */
        private int f6128d;

        /* renamed from: e  reason: collision with root package name */
        d[] f6129e;

        /* renamed from: f  reason: collision with root package name */
        int f6130f;

        /* renamed from: g  reason: collision with root package name */
        int f6131g;

        /* renamed from: h  reason: collision with root package name */
        int f6132h;

        a(int i5, int i6, n nVar) {
            this.f6125a = new ArrayList();
            d[] dVarArr = new d[8];
            this.f6129e = dVarArr;
            this.f6130f = dVarArr.length - 1;
            this.f6131g = 0;
            this.f6132h = 0;
            this.f6127c = i5;
            this.f6128d = i6;
            this.f6126b = w4.g.b(nVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i5, n nVar) {
            this(i5, i5, nVar);
        }

        private void a() {
            int i5 = this.f6128d;
            int i6 = this.f6132h;
            if (i5 < i6) {
                if (i5 == 0) {
                    b();
                } else {
                    d(i6 - i5);
                }
            }
        }

        private void b() {
            Arrays.fill(this.f6129e, (Object) null);
            this.f6130f = this.f6129e.length - 1;
            this.f6131g = 0;
            this.f6132h = 0;
        }

        private int c(int i5) {
            return this.f6130f + 1 + i5;
        }

        private int d(int i5) {
            int i6;
            int i7 = 0;
            if (i5 > 0) {
                int length = this.f6129e.length;
                while (true) {
                    length--;
                    i6 = this.f6130f;
                    if (length < i6 || i5 <= 0) {
                        break;
                    }
                    int i8 = this.f6129e[length].f6116c;
                    i5 -= i8;
                    this.f6132h -= i8;
                    this.f6131g--;
                    i7++;
                }
                d[] dVarArr = this.f6129e;
                System.arraycopy(dVarArr, i6 + 1, dVarArr, i6 + 1 + i7, this.f6131g);
                this.f6130f += i7;
            }
            return i7;
        }

        private w4.f f(int i5) {
            d dVar;
            if (!i(i5)) {
                int c5 = c(i5 - f.f6123b.length);
                if (c5 >= 0) {
                    d[] dVarArr = this.f6129e;
                    if (c5 < dVarArr.length) {
                        dVar = dVarArr[c5];
                    }
                }
                throw new IOException("Header index too large " + (i5 + 1));
            }
            dVar = f.f6123b[i5];
            return dVar.f6114a;
        }

        private void h(int i5, d dVar) {
            this.f6125a.add(dVar);
            int i6 = dVar.f6116c;
            if (i5 != -1) {
                i6 -= this.f6129e[c(i5)].f6116c;
            }
            int i7 = this.f6128d;
            if (i6 > i7) {
                b();
                return;
            }
            int d5 = d((this.f6132h + i6) - i7);
            if (i5 == -1) {
                int i8 = this.f6131g + 1;
                d[] dVarArr = this.f6129e;
                if (i8 > dVarArr.length) {
                    d[] dVarArr2 = new d[dVarArr.length * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                    this.f6130f = this.f6129e.length - 1;
                    this.f6129e = dVarArr2;
                }
                int i9 = this.f6130f;
                this.f6130f = i9 - 1;
                this.f6129e[i9] = dVar;
                this.f6131g++;
            } else {
                this.f6129e[i5 + c(i5) + d5] = dVar;
            }
            this.f6132h += i6;
        }

        private boolean i(int i5) {
            return i5 >= 0 && i5 <= f.f6123b.length - 1;
        }

        private int j() {
            return this.f6126b.readByte() & 255;
        }

        private void m(int i5) {
            if (i(i5)) {
                this.f6125a.add(f.f6123b[i5]);
                return;
            }
            int c5 = c(i5 - f.f6123b.length);
            if (c5 >= 0) {
                d[] dVarArr = this.f6129e;
                if (c5 <= dVarArr.length - 1) {
                    this.f6125a.add(dVarArr[c5]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i5 + 1));
        }

        private void o(int i5) {
            h(-1, new d(f(i5), k()));
        }

        private void p() {
            h(-1, new d(f.e(k()), k()));
        }

        private void q(int i5) {
            this.f6125a.add(new d(f(i5), k()));
        }

        private void r() {
            this.f6125a.add(new d(f.e(k()), k()));
        }

        public List<d> e() {
            ArrayList arrayList = new ArrayList(this.f6125a);
            this.f6125a.clear();
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void g(int i5) {
            this.f6127c = i5;
            this.f6128d = i5;
            a();
        }

        w4.f k() {
            int j5 = j();
            boolean z4 = (j5 & 128) == 128;
            int n5 = n(j5, 127);
            return z4 ? w4.f.m(h.f().c(this.f6126b.G(n5))) : this.f6126b.k(n5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void l() {
            while (!this.f6126b.C()) {
                int readByte = this.f6126b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    m(n(readByte, 127) - 1);
                } else if (readByte == 64) {
                    p();
                } else if ((readByte & 64) == 64) {
                    o(n(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int n5 = n(readByte, 31);
                    this.f6128d = n5;
                    if (n5 < 0 || n5 > this.f6127c) {
                        throw new IOException("Invalid dynamic table size update " + this.f6128d);
                    }
                    a();
                } else if (readByte == 16 || readByte == 0) {
                    r();
                } else {
                    q(n(readByte, 15) - 1);
                }
            }
        }

        int n(int i5, int i6) {
            int i7 = i5 & i6;
            if (i7 < i6) {
                return i7;
            }
            int i8 = 0;
            while (true) {
                int j5 = j();
                if ((j5 & 128) == 0) {
                    return i6 + (j5 << i8);
                }
                i6 += (j5 & 127) << i8;
                i8 += 7;
            }
        }
    }

    /* loaded from: classes.dex */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final w4.c f6133a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f6134b;

        /* renamed from: c  reason: collision with root package name */
        int f6135c;

        /* renamed from: d  reason: collision with root package name */
        private int f6136d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6137e;

        /* renamed from: f  reason: collision with root package name */
        private int f6138f;

        /* renamed from: g  reason: collision with root package name */
        d[] f6139g;

        /* renamed from: h  reason: collision with root package name */
        int f6140h;

        /* renamed from: i  reason: collision with root package name */
        private int f6141i;

        /* renamed from: j  reason: collision with root package name */
        private int f6142j;

        b(int i5, boolean z4, w4.c cVar) {
            this.f6136d = a.e.API_PRIORITY_OTHER;
            d[] dVarArr = new d[8];
            this.f6139g = dVarArr;
            this.f6141i = dVarArr.length - 1;
            this.f6135c = i5;
            this.f6138f = i5;
            this.f6134b = z4;
            this.f6133a = cVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(w4.c cVar) {
            this(4096, false, cVar);
        }

        private void a() {
            Arrays.fill(this.f6139g, (Object) null);
            this.f6141i = this.f6139g.length - 1;
            this.f6140h = 0;
            this.f6142j = 0;
        }

        private int b(int i5) {
            int i6;
            int i7 = 0;
            if (i5 > 0) {
                int length = this.f6139g.length;
                while (true) {
                    length--;
                    i6 = this.f6141i;
                    if (length < i6 || i5 <= 0) {
                        break;
                    }
                    int i8 = this.f6139g[length].f6116c;
                    i5 -= i8;
                    this.f6142j -= i8;
                    this.f6140h--;
                    i7++;
                }
                d[] dVarArr = this.f6139g;
                System.arraycopy(dVarArr, i6 + 1, dVarArr, i6 + 1 + i7, this.f6140h);
                this.f6141i += i7;
            }
            return i7;
        }

        private void c(d dVar) {
            int i5 = dVar.f6116c;
            int i6 = this.f6138f;
            if (i5 > i6) {
                a();
                return;
            }
            b((this.f6142j + i5) - i6);
            int i7 = this.f6140h + 1;
            d[] dVarArr = this.f6139g;
            if (i7 > dVarArr.length) {
                d[] dVarArr2 = new d[dVarArr.length * 2];
                System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                this.f6141i = this.f6139g.length - 1;
                this.f6139g = dVarArr2;
            }
            int i8 = this.f6141i;
            this.f6141i = i8 - 1;
            this.f6139g[i8] = dVar;
            this.f6140h++;
            this.f6142j += i5;
        }

        void d(w4.f fVar) {
            int p5;
            int i5;
            if (!this.f6134b || h.f().e(fVar.t()) >= fVar.p()) {
                p5 = fVar.p();
                i5 = 0;
            } else {
                w4.c cVar = new w4.c();
                h.f().d(fVar.t(), cVar.u());
                fVar = cVar.w();
                p5 = fVar.p();
                i5 = 128;
            }
            f(p5, 127, i5);
            this.f6133a.O(fVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void e(List<d> list) {
            int i5;
            int i6;
            if (this.f6137e) {
                int i7 = this.f6136d;
                if (i7 < this.f6138f) {
                    f(i7, 31, 32);
                }
                this.f6137e = false;
                this.f6136d = a.e.API_PRIORITY_OTHER;
                f(this.f6138f, 31, 32);
            }
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                d dVar = list.get(i8);
                w4.f s5 = dVar.f6114a.s();
                w4.f fVar = dVar.f6115b;
                Integer num = (Integer) f.f6124c.get(s5);
                if (num != null) {
                    i5 = num.intValue() + 1;
                    if (i5 >= 2 && i5 <= 7) {
                        if (f.f6123b[i5 - 1].f6115b.equals(fVar)) {
                            i6 = i5;
                        } else if (f.f6123b[i5].f6115b.equals(fVar)) {
                            i6 = i5;
                            i5++;
                        }
                    }
                    i6 = i5;
                    i5 = -1;
                } else {
                    i5 = -1;
                    i6 = -1;
                }
                if (i5 == -1) {
                    int i9 = this.f6141i;
                    while (true) {
                        i9++;
                        d[] dVarArr = this.f6139g;
                        if (i9 >= dVarArr.length) {
                            break;
                        } else if (dVarArr[i9].f6114a.equals(s5)) {
                            if (this.f6139g[i9].f6115b.equals(fVar)) {
                                i5 = f.f6123b.length + (i9 - this.f6141i);
                                break;
                            } else if (i6 == -1) {
                                i6 = (i9 - this.f6141i) + f.f6123b.length;
                            }
                        }
                    }
                }
                if (i5 != -1) {
                    f(i5, 127, 128);
                } else {
                    if (i6 == -1) {
                        this.f6133a.writeByte(64);
                        d(s5);
                    } else if (!s5.q(f.f6122a) || d.f6111h.equals(s5)) {
                        f(i6, 63, 64);
                    } else {
                        f(i6, 15, 0);
                        d(fVar);
                    }
                    d(fVar);
                    c(dVar);
                }
            }
        }

        void f(int i5, int i6, int i7) {
            int i8;
            w4.c cVar;
            if (i5 < i6) {
                cVar = this.f6133a;
                i8 = i5 | i7;
            } else {
                this.f6133a.writeByte(i7 | i6);
                i8 = i5 - i6;
                while (i8 >= 128) {
                    this.f6133a.writeByte(128 | (i8 & 127));
                    i8 >>>= 7;
                }
                cVar = this.f6133a;
            }
            cVar.writeByte(i8);
        }
    }

    static {
        w4.f fVar = d.f6108e;
        w4.f fVar2 = d.f6109f;
        w4.f fVar3 = d.f6110g;
        w4.f fVar4 = d.f6107d;
        f6123b = new d[]{new d(d.f6111h, ""), new d(fVar, "GET"), new d(fVar, "POST"), new d(fVar2, "/"), new d(fVar2, "/index.html"), new d(fVar3, "http"), new d(fVar3, "https"), new d(fVar4, "200"), new d(fVar4, "204"), new d(fVar4, "206"), new d(fVar4, "304"), new d(fVar4, "400"), new d(fVar4, "404"), new d(fVar4, "500"), new d("accept-charset", ""), new d("accept-encoding", "gzip, deflate"), new d("accept-language", ""), new d("accept-ranges", ""), new d("accept", ""), new d("access-control-allow-origin", ""), new d("age", ""), new d("allow", ""), new d("authorization", ""), new d("cache-control", ""), new d("content-disposition", ""), new d("content-encoding", ""), new d("content-language", ""), new d("content-length", ""), new d("content-location", ""), new d("content-range", ""), new d("content-type", ""), new d("cookie", ""), new d("date", ""), new d("etag", ""), new d("expect", ""), new d("expires", ""), new d("from", ""), new d("host", ""), new d("if-match", ""), new d("if-modified-since", ""), new d("if-none-match", ""), new d("if-range", ""), new d("if-unmodified-since", ""), new d("last-modified", ""), new d("link", ""), new d("location", ""), new d("max-forwards", ""), new d("proxy-authenticate", ""), new d("proxy-authorization", ""), new d("range", ""), new d("referer", ""), new d("refresh", ""), new d("retry-after", ""), new d("server", ""), new d("set-cookie", ""), new d("strict-transport-security", ""), new d("transfer-encoding", ""), new d("user-agent", ""), new d("vary", ""), new d("via", ""), new d("www-authenticate", "")};
        f6124c = f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static w4.f e(w4.f fVar) {
        int p5 = fVar.p();
        for (int i5 = 0; i5 < p5; i5++) {
            byte h5 = fVar.h(i5);
            if (h5 >= 65 && h5 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.u());
            }
        }
        return fVar;
    }

    private static Map<w4.f, Integer> f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f6123b.length);
        int i5 = 0;
        while (true) {
            d[] dVarArr = f6123b;
            if (i5 >= dVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(dVarArr[i5].f6114a)) {
                linkedHashMap.put(dVarArr[i5].f6114a, Integer.valueOf(i5));
            }
            i5++;
        }
    }
}
