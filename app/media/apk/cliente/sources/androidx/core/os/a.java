package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
/* loaded from: classes.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f421a = new a();

    private a() {
    }

    public static final void a(Bundle bundle, String str, Size size) {
        bundle.putSize(str, size);
    }

    public static final void b(Bundle bundle, String str, SizeF sizeF) {
        bundle.putSizeF(str, sizeF);
    }
}
