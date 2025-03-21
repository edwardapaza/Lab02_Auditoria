package com.google.protobuf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l1 implements u0 {

    /* renamed from: a  reason: collision with root package name */
    private final w0 f2060a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2061b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f2062c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2063d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l1(w0 w0Var, String str, Object[] objArr) {
        char charAt;
        this.f2060a = w0Var;
        this.f2061b = str;
        this.f2062c = objArr;
        int charAt2 = str.charAt(0);
        if (charAt2 >= 55296) {
            int i5 = charAt2 & 8191;
            int i6 = 13;
            int i7 = 1;
            while (true) {
                int i8 = i7 + 1;
                charAt = str.charAt(i7);
                if (charAt < 55296) {
                    break;
                }
                i5 |= (charAt & 8191) << i6;
                i6 += 13;
                i7 = i8;
            }
            charAt2 = i5 | (charAt << i6);
        }
        this.f2063d = charAt2;
    }

    @Override // com.google.protobuf.u0
    public boolean a() {
        return (this.f2063d & 2) == 2;
    }

    @Override // com.google.protobuf.u0
    public i1 b() {
        return (this.f2063d & 1) == 1 ? i1.PROTO2 : i1.PROTO3;
    }

    @Override // com.google.protobuf.u0
    public w0 c() {
        return this.f2060a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] d() {
        return this.f2062c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return this.f2061b;
    }
}
