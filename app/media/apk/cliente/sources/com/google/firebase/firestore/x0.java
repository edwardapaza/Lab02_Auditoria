package com.google.firebase.firestore;

import com.google.firebase.firestore.n;
import java.util.Map;
/* loaded from: classes.dex */
public class x0 extends n {
    private x0(FirebaseFirestore firebaseFirestore, v1.l lVar, v1.i iVar, boolean z4, boolean z5) {
        super(firebaseFirestore, lVar, iVar, z4, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x0 h(FirebaseFirestore firebaseFirestore, v1.i iVar, boolean z4, boolean z5) {
        return new x0(firebaseFirestore, iVar.getKey(), iVar, z4, z5);
    }

    @Override // com.google.firebase.firestore.n
    public Map<String, Object> d() {
        Map<String, Object> d5 = super.d();
        z1.b.d(d5 != null, "Data in a QueryDocumentSnapshot should be non-null", new Object[0]);
        return d5;
    }

    @Override // com.google.firebase.firestore.n
    public Map<String, Object> e(n.a aVar) {
        z1.y.c(aVar, "Provided serverTimestampBehavior value must not be null.");
        Map<String, Object> e5 = super.e(aVar);
        z1.b.d(e5 != null, "Data in a QueryDocumentSnapshot should be non-null", new Object[0]);
        return e5;
    }
}
