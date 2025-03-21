package com.google.protobuf;

import com.google.protobuf.w0;
/* loaded from: classes.dex */
public abstract class b<MessageType extends w0> implements g1<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    private static final q f1864a = q.b();

    private MessageType d(MessageType messagetype) {
        if (messagetype == null || messagetype.n()) {
            return messagetype;
        }
        throw e(messagetype).a().k(messagetype);
    }

    private v1 e(MessageType messagetype) {
        return messagetype instanceof a ? ((a) messagetype).s() : new v1(messagetype);
    }

    @Override // com.google.protobuf.g1
    /* renamed from: f */
    public MessageType a(i iVar, q qVar) {
        return d(h(iVar, qVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.g1
    /* renamed from: g */
    public MessageType b(j jVar, q qVar) {
        return (MessageType) d((w0) c(jVar, qVar));
    }

    public MessageType h(i iVar, q qVar) {
        try {
            j A = iVar.A();
            MessageType messagetype = (MessageType) c(A, qVar);
            try {
                A.a(0);
                return messagetype;
            } catch (e0 e5) {
                throw e5.k(messagetype);
            }
        } catch (e0 e6) {
            throw e6;
        }
    }
}
