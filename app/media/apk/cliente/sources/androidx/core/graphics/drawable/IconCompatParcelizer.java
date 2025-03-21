package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(androidx.versionedparcelable.a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f411a = aVar.p(iconCompat.f411a, 1);
        iconCompat.f413c = aVar.j(iconCompat.f413c, 2);
        iconCompat.f414d = aVar.r(iconCompat.f414d, 3);
        iconCompat.f415e = aVar.p(iconCompat.f415e, 4);
        iconCompat.f416f = aVar.p(iconCompat.f416f, 5);
        iconCompat.f417g = (ColorStateList) aVar.r(iconCompat.f417g, 6);
        iconCompat.f419i = aVar.t(iconCompat.f419i, 7);
        iconCompat.f420j = aVar.t(iconCompat.f420j, 8);
        iconCompat.o();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(true, true);
        iconCompat.p(aVar.f());
        int i5 = iconCompat.f411a;
        if (-1 != i5) {
            aVar.F(i5, 1);
        }
        byte[] bArr = iconCompat.f413c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f414d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i6 = iconCompat.f415e;
        if (i6 != 0) {
            aVar.F(i6, 4);
        }
        int i7 = iconCompat.f416f;
        if (i7 != 0) {
            aVar.F(i7, 5);
        }
        ColorStateList colorStateList = iconCompat.f417g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f419i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f420j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
