package v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class u extends e<u> {

    /* renamed from: b  reason: collision with root package name */
    public static final u f8153b = new u(Collections.emptyList());

    private u(List<String> list) {
        super(list);
    }

    public static u t(List<String> list) {
        return list.isEmpty() ? f8153b : new u(list);
    }

    public static u u(String str) {
        if (str.contains("//")) {
            throw new IllegalArgumentException("Invalid path (" + str + "). Paths must not contain // in them.");
        }
        String[] split = str.split("/");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.isEmpty()) {
                arrayList.add(str2);
            }
        }
        return new u(arrayList);
    }

    @Override // v1.e
    public String d() {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < this.f8114a.size(); i5++) {
            if (i5 > 0) {
                sb.append("/");
            }
            sb.append(this.f8114a.get(i5));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // v1.e
    /* renamed from: s */
    public u h(List<String> list) {
        return new u(list);
    }
}
