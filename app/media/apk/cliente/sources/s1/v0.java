package s1;
/* loaded from: classes.dex */
public class v0 implements com.google.firebase.firestore.g0 {

    /* renamed from: a  reason: collision with root package name */
    private final o0 f7501a;

    /* renamed from: b  reason: collision with root package name */
    private final b1 f7502b;

    /* renamed from: c  reason: collision with root package name */
    private final h<x1> f7503c;

    public v0(o0 o0Var, b1 b1Var, h<x1> hVar) {
        this.f7501a = o0Var;
        this.f7502b = b1Var;
        this.f7503c = hVar;
    }

    @Override // com.google.firebase.firestore.g0
    public void remove() {
        this.f7503c.d();
        this.f7501a.h0(this.f7502b);
    }
}
