package androidx.profileinstaller;
/* loaded from: classes.dex */
enum f {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);
    

    /* renamed from: a  reason: collision with root package name */
    private final long f654a;

    f(long j5) {
        this.f654a = j5;
    }

    public long c() {
        return this.f654a;
    }
}
