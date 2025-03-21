package i3;

import i3.l;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: c  reason: collision with root package name */
    static final z0.e f3571c = z0.e.e(',');

    /* renamed from: d  reason: collision with root package name */
    private static final v f3572d = a().f(new l.a(), true).f(l.b.f3486a, false);

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f3573a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f3574b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final u f3575a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f3576b;

        a(u uVar, boolean z4) {
            this.f3575a = (u) z0.k.o(uVar, "decompressor");
            this.f3576b = z4;
        }
    }

    private v() {
        this.f3573a = new LinkedHashMap(0);
        this.f3574b = new byte[0];
    }

    private v(u uVar, boolean z4, v vVar) {
        String a5 = uVar.a();
        z0.k.e(!a5.contains(","), "Comma is currently not allowed in message encoding");
        int size = vVar.f3573a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(vVar.f3573a.containsKey(uVar.a()) ? size : size + 1);
        for (a aVar : vVar.f3573a.values()) {
            String a6 = aVar.f3575a.a();
            if (!a6.equals(a5)) {
                linkedHashMap.put(a6, new a(aVar.f3575a, aVar.f3576b));
            }
        }
        linkedHashMap.put(a5, new a(uVar, z4));
        this.f3573a = Collections.unmodifiableMap(linkedHashMap);
        this.f3574b = f3571c.c(b()).getBytes(Charset.forName("US-ASCII"));
    }

    public static v a() {
        return new v();
    }

    public static v c() {
        return f3572d;
    }

    public Set<String> b() {
        HashSet hashSet = new HashSet(this.f3573a.size());
        for (Map.Entry<String, a> entry : this.f3573a.entrySet()) {
            if (entry.getValue().f3576b) {
                hashSet.add(entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] d() {
        return this.f3574b;
    }

    public u e(String str) {
        a aVar = this.f3573a.get(str);
        if (aVar != null) {
            return aVar.f3575a;
        }
        return null;
    }

    public v f(u uVar, boolean z4) {
        return new v(uVar, z4, this);
    }
}
