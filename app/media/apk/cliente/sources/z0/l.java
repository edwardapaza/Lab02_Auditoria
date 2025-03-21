package z0;

import com.google.android.gms.common.api.a;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final z0.a f8879a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8880b;

    /* renamed from: c  reason: collision with root package name */
    private final b f8881c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8882d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z0.a f8883a;

        a(z0.a aVar) {
            this.f8883a = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
    }

    private l(b bVar) {
        this(bVar, false, z0.a.c(), a.e.API_PRIORITY_OTHER);
    }

    private l(b bVar, boolean z4, z0.a aVar, int i5) {
        this.f8881c = bVar;
        this.f8880b = z4;
        this.f8879a = aVar;
        this.f8882d = i5;
    }

    public static l a(char c5) {
        return b(z0.a.b(c5));
    }

    public static l b(z0.a aVar) {
        k.n(aVar);
        return new l(new a(aVar));
    }

    public l c() {
        return d(z0.a.e());
    }

    public l d(z0.a aVar) {
        k.n(aVar);
        return new l(this.f8881c, this.f8880b, aVar, this.f8882d);
    }
}
