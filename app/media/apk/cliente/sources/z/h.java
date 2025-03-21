package z;
/* loaded from: classes.dex */
public abstract class h<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f8837a = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }

        public static /* synthetic */ h b(a aVar, Object obj, String str, j jVar, g gVar, int i5, Object obj2) {
            if ((i5 & 2) != 0) {
                jVar = c.f8820a.a();
            }
            if ((i5 & 4) != 0) {
                gVar = z.a.f8815a;
            }
            return aVar.a(obj, str, jVar, gVar);
        }

        public final <T> h<T> a(T t5, String str, j jVar, g gVar) {
            e4.k.e(t5, "<this>");
            e4.k.e(str, "tag");
            e4.k.e(jVar, "verificationMode");
            e4.k.e(gVar, "logger");
            return new i(t5, str, jVar, gVar);
        }
    }

    public abstract T a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b(Object obj, String str) {
        e4.k.e(obj, "value");
        e4.k.e(str, "message");
        return str + " value: " + obj;
    }

    public abstract h<T> c(String str, d4.l<? super T, Boolean> lVar);
}
