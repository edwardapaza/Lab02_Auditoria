package l3;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f6031a = new String[0];

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f6032b = Charset.forName("UTF-8");

    public static <T> List<T> a(T[] tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    private static <T> List<T> b(T[] tArr, T[] tArr2) {
        ArrayList arrayList = new ArrayList();
        for (T t5 : tArr) {
            int length = tArr2.length;
            int i5 = 0;
            while (true) {
                if (i5 < length) {
                    T t6 = tArr2[i5];
                    if (t5.equals(t6)) {
                        arrayList.add(t6);
                        break;
                    }
                    i5++;
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] c(Class<T> cls, T[] tArr, T[] tArr2) {
        List b5 = b(tArr, tArr2);
        return (T[]) b5.toArray((Object[]) Array.newInstance((Class<?>) cls, b5.size()));
    }
}
