package com.google.firebase.firestore;
/* loaded from: classes.dex */
public class g extends w0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(v1.u uVar, FirebaseFirestore firebaseFirestore) {
        super(s1.a1.b(uVar), firebaseFirestore);
        if (uVar.p() % 2 == 1) {
            return;
        }
        throw new IllegalArgumentException("Invalid collection reference. Collection references must have an odd number of segments, but " + uVar.d() + " has " + uVar.p());
    }
}
