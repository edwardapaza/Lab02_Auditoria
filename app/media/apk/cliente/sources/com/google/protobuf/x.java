package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.d0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends c<Float> implements d0.f, RandomAccess, h1 {

    /* renamed from: d  reason: collision with root package name */
    private static final x f2191d;

    /* renamed from: b  reason: collision with root package name */
    private float[] f2192b;

    /* renamed from: c  reason: collision with root package name */
    private int f2193c;

    static {
        x xVar = new x(new float[0], 0);
        f2191d = xVar;
        xVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x() {
        this(new float[10], 0);
    }

    private x(float[] fArr, int i5) {
        this.f2192b = fArr;
        this.f2193c = i5;
    }

    private void l(int i5, float f5) {
        int i6;
        g();
        if (i5 < 0 || i5 > (i6 = this.f2193c)) {
            throw new IndexOutOfBoundsException(p(i5));
        }
        float[] fArr = this.f2192b;
        if (i6 < fArr.length) {
            System.arraycopy(fArr, i5, fArr, i5 + 1, i6 - i5);
        } else {
            float[] fArr2 = new float[((i6 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i5);
            System.arraycopy(this.f2192b, i5, fArr2, i5 + 1, this.f2193c - i5);
            this.f2192b = fArr2;
        }
        this.f2192b[i5] = f5;
        this.f2193c++;
        ((AbstractList) this).modCount++;
    }

    private void m(int i5) {
        if (i5 < 0 || i5 >= this.f2193c) {
            throw new IndexOutOfBoundsException(p(i5));
        }
    }

    private String p(int i5) {
        return "Index:" + i5 + ", Size:" + this.f2193c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        g();
        d0.a(collection);
        if (collection instanceof x) {
            x xVar = (x) collection;
            int i5 = xVar.f2193c;
            if (i5 == 0) {
                return false;
            }
            int i6 = this.f2193c;
            if (a.e.API_PRIORITY_OTHER - i6 >= i5) {
                int i7 = i6 + i5;
                float[] fArr = this.f2192b;
                if (i7 > fArr.length) {
                    this.f2192b = Arrays.copyOf(fArr, i7);
                }
                System.arraycopy(xVar.f2192b, 0, this.f2192b, this.f2193c, xVar.f2193c);
                this.f2193c = i7;
                ((AbstractList) this).modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.f2193c != xVar.f2193c) {
                return false;
            }
            float[] fArr = xVar.f2192b;
            for (int i5 = 0; i5 < this.f2193c; i5++) {
                if (Float.floatToIntBits(this.f2192b[i5]) != Float.floatToIntBits(fArr[i5])) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h */
    public void add(int i5, Float f5) {
        l(i5, f5.floatValue());
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f2193c; i6++) {
            i5 = (i5 * 31) + Float.floatToIntBits(this.f2192b[i6]);
        }
        return i5;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: i */
    public boolean add(Float f5) {
        k(f5.floatValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            int size = size();
            for (int i5 = 0; i5 < size; i5++) {
                if (this.f2192b[i5] == floatValue) {
                    return i5;
                }
            }
            return -1;
        }
        return -1;
    }

    public void k(float f5) {
        g();
        int i5 = this.f2193c;
        float[] fArr = this.f2192b;
        if (i5 == fArr.length) {
            float[] fArr2 = new float[((i5 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i5);
            this.f2192b = fArr2;
        }
        float[] fArr3 = this.f2192b;
        int i6 = this.f2193c;
        this.f2193c = i6 + 1;
        fArr3[i6] = f5;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n */
    public Float get(int i5) {
        return Float.valueOf(o(i5));
    }

    public float o(int i5) {
        m(i5);
        return this.f2192b[i5];
    }

    @Override // com.google.protobuf.d0.i
    /* renamed from: q */
    public d0.f b(int i5) {
        if (i5 >= this.f2193c) {
            return new x(Arrays.copyOf(this.f2192b, i5), this.f2193c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* renamed from: r */
    public Float remove(int i5) {
        int i6;
        g();
        m(i5);
        float[] fArr = this.f2192b;
        float f5 = fArr[i5];
        if (i5 < this.f2193c - 1) {
            System.arraycopy(fArr, i5 + 1, fArr, i5, (i6 - i5) - 1);
        }
        this.f2193c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f5);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i5, int i6) {
        g();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f2192b;
        System.arraycopy(fArr, i6, fArr, i5, this.f2193c - i6);
        this.f2193c -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: s */
    public Float set(int i5, Float f5) {
        return Float.valueOf(t(i5, f5.floatValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2193c;
    }

    public float t(int i5, float f5) {
        g();
        m(i5);
        float[] fArr = this.f2192b;
        float f6 = fArr[i5];
        fArr[i5] = f5;
        return f6;
    }
}
