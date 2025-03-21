package com.google.protobuf;

import com.google.protobuf.d0;
/* loaded from: classes.dex */
public enum f1 implements d0.c {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);
    

    /* renamed from: d  reason: collision with root package name */
    private static final d0.d<f1> f1941d = new d0.d<f1>() { // from class: com.google.protobuf.f1.a
        @Override // com.google.protobuf.d0.d
        /* renamed from: b */
        public f1 a(int i5) {
            return f1.a(i5);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f1943a;

    f1(int i5) {
        this.f1943a = i5;
    }

    public static f1 a(int i5) {
        if (i5 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    @Override // com.google.protobuf.d0.c
    public final int b() {
        if (this != UNRECOGNIZED) {
            return this.f1943a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
