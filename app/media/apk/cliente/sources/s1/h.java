package s1;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class h<T> implements com.google.firebase.firestore.o<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f7335a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.firestore.o<T> f7336b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f7337c = false;

    public h(Executor executor, com.google.firebase.firestore.o<T> oVar) {
        this.f7335a = executor;
        this.f7336b = oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Object obj, com.google.firebase.firestore.z zVar) {
        if (this.f7337c) {
            return;
        }
        this.f7336b.a(obj, zVar);
    }

    @Override // com.google.firebase.firestore.o
    public void a(final T t5, final com.google.firebase.firestore.z zVar) {
        this.f7335a.execute(new Runnable() { // from class: s1.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.c(t5, zVar);
            }
        });
    }

    public void d() {
        this.f7337c = true;
    }
}
