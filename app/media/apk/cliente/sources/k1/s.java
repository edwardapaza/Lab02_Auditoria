package k1;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class s extends t {

    /* renamed from: a  reason: collision with root package name */
    private final List<c<?>> f5611a;

    public s(List<c<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f5611a = list;
    }
}
