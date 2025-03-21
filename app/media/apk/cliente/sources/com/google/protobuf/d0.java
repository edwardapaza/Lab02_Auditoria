package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f1910a = Charset.forName("US-ASCII");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f1911b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    static final Charset f1912c = Charset.forName("ISO-8859-1");

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f1913d;

    /* renamed from: e  reason: collision with root package name */
    public static final ByteBuffer f1914e;

    /* renamed from: f  reason: collision with root package name */
    public static final j f1915f;

    /* loaded from: classes.dex */
    public interface a extends i<Boolean> {
    }

    /* loaded from: classes.dex */
    public interface b extends i<Double> {
    }

    /* loaded from: classes.dex */
    public interface c {
        int b();
    }

    /* loaded from: classes.dex */
    public interface d<T extends c> {
        T a(int i5);
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean a(int i5);
    }

    /* loaded from: classes.dex */
    public interface f extends i<Float> {
    }

    /* loaded from: classes.dex */
    public interface g extends i<Integer> {
    }

    /* loaded from: classes.dex */
    public interface h extends i<Long> {
    }

    /* loaded from: classes.dex */
    public interface i<E> extends List<E>, RandomAccess {
        void a();

        i<E> b(int i5);

        boolean j();
    }

    static {
        byte[] bArr = new byte[0];
        f1913d = bArr;
        f1914e = ByteBuffer.wrap(bArr);
        f1915f = j.j(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t5) {
        t5.getClass();
        return t5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T b(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z4) {
        return z4 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i5, int i6) {
        int i7 = i(i6, bArr, i5, i6);
        if (i7 == 0) {
            return 1;
        }
        return i7;
    }

    public static int f(long j5) {
        return (int) (j5 ^ (j5 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return b2.s(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object h(Object obj, Object obj2) {
        return ((w0) obj).c().g((w0) obj2).i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i5, byte[] bArr, int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            i5 = (i5 * 31) + bArr[i8];
        }
        return i5;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, f1911b);
    }
}
