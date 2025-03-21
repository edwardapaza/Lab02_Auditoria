package k4;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements j4.b<h4.f> {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f5837a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5838b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5839c;

    /* renamed from: d  reason: collision with root package name */
    private final d4.p<CharSequence, Integer, s3.l<Integer, Integer>> f5840d;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<h4.f> {

        /* renamed from: a  reason: collision with root package name */
        private int f5841a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f5842b;

        /* renamed from: c  reason: collision with root package name */
        private int f5843c;

        /* renamed from: d  reason: collision with root package name */
        private h4.f f5844d;

        /* renamed from: e  reason: collision with root package name */
        private int f5845e;

        a() {
            int e5;
            e5 = h4.l.e(d.this.f5838b, 0, d.this.f5837a.length());
            this.f5842b = e5;
            this.f5843c = e5;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
            if (r0 < r6.f5846f.f5839c) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void b() {
            /*
                r6 = this;
                int r0 = r6.f5843c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f5841a = r1
                r0 = 0
                r6.f5844d = r0
                goto L99
            Lc:
                k4.d r0 = k4.d.this
                int r0 = k4.d.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f5845e
                int r0 = r0 + r3
                r6.f5845e = r0
                k4.d r4 = k4.d.this
                int r4 = k4.d.c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f5843c
                k4.d r4 = k4.d.this
                java.lang.CharSequence r4 = k4.d.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                h4.f r0 = new h4.f
                int r1 = r6.f5842b
                k4.d r4 = k4.d.this
                java.lang.CharSequence r4 = k4.d.b(r4)
                int r4 = k4.p.q(r4)
                r0.<init>(r1, r4)
            L42:
                r6.f5844d = r0
            L44:
                r6.f5843c = r2
                goto L97
            L47:
                k4.d r0 = k4.d.this
                d4.p r0 = k4.d.a(r0)
                k4.d r4 = k4.d.this
                java.lang.CharSequence r4 = k4.d.b(r4)
                int r5 = r6.f5843c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                s3.l r0 = (s3.l) r0
                if (r0 != 0) goto L73
                h4.f r0 = new h4.f
                int r1 = r6.f5842b
                k4.d r4 = k4.d.this
                java.lang.CharSequence r4 = k4.d.b(r4)
                int r4 = k4.p.q(r4)
                r0.<init>(r1, r4)
                goto L42
            L73:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f5842b
                h4.f r4 = h4.j.h(r4, r2)
                r6.f5844d = r4
                int r2 = r2 + r0
                r6.f5842b = r2
                if (r0 != 0) goto L95
                r1 = 1
            L95:
                int r2 = r2 + r1
                goto L44
            L97:
                r6.f5841a = r3
            L99:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: k4.d.a.b():void");
        }

        @Override // java.util.Iterator
        /* renamed from: c */
        public h4.f next() {
            if (this.f5841a == -1) {
                b();
            }
            if (this.f5841a != 0) {
                h4.f fVar = this.f5844d;
                e4.k.c(fVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f5844d = null;
                this.f5841a = -1;
                return fVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f5841a == -1) {
                b();
            }
            return this.f5841a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i5, int i6, d4.p<? super CharSequence, ? super Integer, s3.l<Integer, Integer>> pVar) {
        e4.k.e(charSequence, "input");
        e4.k.e(pVar, "getNextMatch");
        this.f5837a = charSequence;
        this.f5838b = i5;
        this.f5839c = i6;
        this.f5840d = pVar;
    }

    @Override // j4.b
    public Iterator<h4.f> iterator() {
        return new a();
    }
}
