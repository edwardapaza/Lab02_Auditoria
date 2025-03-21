package com.google.android.recaptcha.internal;

import android.content.Context;
import b4.f;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzad {
    private final Context zza;

    public zzad(Context context) {
        this.zza = context;
    }

    public static final byte[] zza(File file) {
        byte[] a5;
        a5 = f.a(file);
        return a5;
    }

    public static final void zzb(File file, byte[] bArr) {
        if (file.exists() && !file.delete()) {
            throw new IOException("Unable to delete existing encrypted file");
        }
        f.b(file, bArr);
    }
}
