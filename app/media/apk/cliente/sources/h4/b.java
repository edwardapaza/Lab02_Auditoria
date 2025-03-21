package h4;

import java.util.NoSuchElementException;
import t3.m;
/* loaded from: classes.dex */
public final class b extends m {

    /* renamed from: a  reason: collision with root package name */
    private final int f3120a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3121b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3122c;

    /* renamed from: d  reason: collision with root package name */
    private int f3123d;

    public b(char c5, char c6, int i5) {
        this.f3120a = i5;
        this.f3121b = c6;
        boolean z4 = true;
        if (i5 <= 0 ? e4.k.f(c5, c6) < 0 : e4.k.f(c5, c6) > 0) {
            z4 = false;
        }
        this.f3122c = z4;
        this.f3123d = z4 ? c5 : c6;
    }

    @Override // t3.m
    public char b() {
        int i5 = this.f3123d;
        if (i5 != this.f3121b) {
            this.f3123d = this.f3120a + i5;
        } else if (!this.f3122c) {
            throw new NoSuchElementException();
        } else {
            this.f3122c = false;
        }
        return (char) i5;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3122c;
    }
}
