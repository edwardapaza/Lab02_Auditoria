package z2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import z2.p;
/* loaded from: classes.dex */
public final class q implements k {

    /* renamed from: b  reason: collision with root package name */
    public static final q f9018b = new q(p.f9015a);

    /* renamed from: a  reason: collision with root package name */
    private final p f9019a;

    public q(p pVar) {
        this.f9019a = pVar;
    }

    @Override // z2.k
    public ByteBuffer a(Object obj) {
        p.a aVar = new p.a();
        aVar.write(0);
        this.f9019a.p(aVar, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.c(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // z2.k
    public ByteBuffer b(String str, String str2, Object obj, String str3) {
        p.a aVar = new p.a();
        aVar.write(1);
        this.f9019a.p(aVar, str);
        this.f9019a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f9019a.p(aVar, n2.b.d((Throwable) obj));
        } else {
            this.f9019a.p(aVar, obj);
        }
        this.f9019a.p(aVar, str3);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.c(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // z2.k
    public ByteBuffer c(String str, String str2, Object obj) {
        p.a aVar = new p.a();
        aVar.write(1);
        this.f9019a.p(aVar, str);
        this.f9019a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f9019a.p(aVar, n2.b.d((Throwable) obj));
        } else {
            this.f9019a.p(aVar, obj);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.c(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // z2.k
    public ByteBuffer d(i iVar) {
        p.a aVar = new p.a();
        this.f9019a.p(aVar, iVar.f9003a);
        this.f9019a.p(aVar, iVar.f9004b);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.c(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // z2.k
    public i e(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        Object f5 = this.f9019a.f(byteBuffer);
        Object f6 = this.f9019a.f(byteBuffer);
        if (!(f5 instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new i((String) f5, f6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r0 == 1) goto L8;
     */
    @Override // z2.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.nio.ByteBuffer r5) {
        /*
            r4 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            r5.order(r0)
            byte r0 = r5.get()
            if (r0 == 0) goto L11
            r1 = 1
            if (r0 != r1) goto L4a
            goto L1e
        L11:
            z2.p r0 = r4.f9019a
            java.lang.Object r0 = r0.f(r5)
            boolean r1 = r5.hasRemaining()
            if (r1 != 0) goto L1e
            return r0
        L1e:
            z2.p r0 = r4.f9019a
            java.lang.Object r0 = r0.f(r5)
            z2.p r1 = r4.f9019a
            java.lang.Object r1 = r1.f(r5)
            z2.p r2 = r4.f9019a
            java.lang.Object r2 = r2.f(r5)
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L4a
            if (r1 == 0) goto L3a
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L4a
        L3a:
            boolean r5 = r5.hasRemaining()
            if (r5 != 0) goto L4a
            z2.d r5 = new z2.d
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = (java.lang.String) r1
            r5.<init>(r0, r1, r2)
            throw r5
        L4a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Envelope corrupted"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.q.f(java.nio.ByteBuffer):java.lang.Object");
    }
}
