package androidx.loader.app;

import androidx.lifecycle.m;
import androidx.lifecycle.m0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class a {
    public static <T extends m & m0> a b(T t5) {
        return new b(t5, t5.p());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
