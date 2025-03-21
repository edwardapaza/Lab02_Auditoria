package e3;

import com.google.firebase.firestore.FirebaseFirestore;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseFirestore f2677a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2678b;

    public b(FirebaseFirestore firebaseFirestore, String str) {
        this.f2677a = firebaseFirestore;
        this.f2678b = str;
    }

    public String a() {
        return this.f2678b;
    }

    public FirebaseFirestore b() {
        return this.f2677a;
    }
}
