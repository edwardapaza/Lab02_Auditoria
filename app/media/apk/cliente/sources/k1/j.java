package k1;

import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
/* loaded from: classes.dex */
public interface j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f5582a = new j() { // from class: k1.i
        @Override // k1.j
        public final List a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar.getComponents();
        }
    };

    List<c<?>> a(ComponentRegistrar componentRegistrar);
}
