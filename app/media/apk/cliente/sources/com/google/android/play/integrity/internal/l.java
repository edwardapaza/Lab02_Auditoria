package com.google.android.play.integrity.internal;
/* loaded from: classes.dex */
public final class l {
    public static void a(Object obj, Class cls) {
        if (obj == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
        }
    }
}
