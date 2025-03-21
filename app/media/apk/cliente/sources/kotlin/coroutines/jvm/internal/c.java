package kotlin.coroutines.jvm.internal;
/* loaded from: classes.dex */
public final class c implements v3.d<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final c f5856a = new c();

    private c() {
    }

    @Override // v3.d
    public v3.g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // v3.d
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
