package y1;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.z;
import i2.a0;
import i2.d;
import i2.h;
import i2.w;
import i3.j1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;
import y1.a1;
import y1.b1;
import y1.z;
/* loaded from: classes.dex */
public class r {

    /* renamed from: e  reason: collision with root package name */
    static final Set<String> f8478e = new HashSet(Arrays.asList("date", "x-google-backends", "x-google-netmon-label", "x-google-service", "x-google-gfe-request-trace"));

    /* renamed from: a  reason: collision with root package name */
    private final s1.l f8479a;

    /* renamed from: b  reason: collision with root package name */
    private final o0 f8480b;

    /* renamed from: c  reason: collision with root package name */
    private final z1.g f8481c;

    /* renamed from: d  reason: collision with root package name */
    private final z f8482d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends z.e<i2.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f8483a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f8484b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TaskCompletionSource f8485c;

        a(List list, List list2, TaskCompletionSource taskCompletionSource) {
            this.f8483a = list;
            this.f8484b = list2;
            this.f8485c = taskCompletionSource;
        }

        @Override // y1.z.e
        public void a(j1 j1Var) {
            if (j1Var.o()) {
                this.f8485c.trySetResult(Collections.emptyList());
                return;
            }
            com.google.firebase.firestore.z t5 = z1.h0.t(j1Var);
            if (t5.a() == z.a.UNAUTHENTICATED) {
                r.this.f8482d.h();
            }
            this.f8485c.trySetException(t5);
        }

        @Override // y1.z.e
        /* renamed from: c */
        public void b(i2.e eVar) {
            this.f8483a.add(eVar);
            if (this.f8483a.size() == this.f8484b.size()) {
                HashMap hashMap = new HashMap();
                for (i2.e eVar2 : this.f8483a) {
                    v1.s m5 = r.this.f8480b.m(eVar2);
                    hashMap.put(m5.getKey(), m5);
                }
                ArrayList arrayList = new ArrayList();
                for (v1.l lVar : this.f8484b) {
                    arrayList.add((v1.s) hashMap.get(lVar));
                }
                this.f8485c.trySetResult(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8487a;

        static {
            int[] iArr = new int[z.a.values().length];
            f8487a = iArr;
            try {
                iArr[z.a.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8487a[z.a.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8487a[z.a.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8487a[z.a.DEADLINE_EXCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8487a[z.a.RESOURCE_EXHAUSTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8487a[z.a.INTERNAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8487a[z.a.UNAVAILABLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8487a[z.a.UNAUTHENTICATED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8487a[z.a.INVALID_ARGUMENT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8487a[z.a.NOT_FOUND.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8487a[z.a.ALREADY_EXISTS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8487a[z.a.PERMISSION_DENIED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f8487a[z.a.FAILED_PRECONDITION.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f8487a[z.a.ABORTED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f8487a[z.a.OUT_OF_RANGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f8487a[z.a.UNIMPLEMENTED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f8487a[z.a.DATA_LOSS.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public r(s1.l lVar, z1.g gVar, q1.a<q1.j> aVar, q1.a<String> aVar2, Context context, j0 j0Var) {
        this.f8479a = lVar;
        this.f8481c = gVar;
        this.f8480b = new o0(lVar.a());
        this.f8482d = i(lVar, gVar, aVar, aVar2, context, j0Var);
    }

    public static boolean j(j1 j1Var) {
        j1Var.m();
        Throwable l5 = j1Var.l();
        if (l5 instanceof SSLHandshakeException) {
            l5.getMessage().contains("no ciphers available");
            return false;
        }
        return false;
    }

    public static boolean k(z.a aVar) {
        switch (b.f8487a[aVar.ordinal()]) {
            case 1:
                throw new IllegalArgumentException("Treated status OK as error");
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return false;
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
            case 11:
            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            case 13:
            case 14:
            case 15:
            case 16:
            case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return true;
            default:
                throw new IllegalArgumentException("Unknown gRPC status code: " + aVar);
        }
    }

    public static boolean l(j1 j1Var) {
        return k(z.a.c(j1Var.m().d()));
    }

    public static boolean m(j1 j1Var) {
        return l(j1Var) && !j1Var.m().equals(j1.b.ABORTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List n(Task task) {
        if (!task.isSuccessful()) {
            if ((task.getException() instanceof com.google.firebase.firestore.z) && ((com.google.firebase.firestore.z) task.getException()).a() == z.a.UNAUTHENTICATED) {
                this.f8482d.h();
            }
            throw task.getException();
        }
        i2.i iVar = (i2.i) task.getResult();
        v1.w y4 = this.f8480b.y(iVar.e0());
        int h02 = iVar.h0();
        ArrayList arrayList = new ArrayList(h02);
        for (int i5 = 0; i5 < h02; i5++) {
            arrayList.add(this.f8480b.p(iVar.g0(i5), y4));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map o(HashMap hashMap, Task task) {
        if (!task.isSuccessful()) {
            if ((task.getException() instanceof com.google.firebase.firestore.z) && ((com.google.firebase.firestore.z) task.getException()).a() == z.a.UNAUTHENTICATED) {
                this.f8482d.h();
            }
            throw task.getException();
        }
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, i2.d0> entry : ((i2.x) task.getResult()).f0().e0().entrySet()) {
            z1.b.d(hashMap.containsKey(entry.getKey()), "%s not present in aliasMap", entry.getKey());
            hashMap2.put((String) hashMap.get(entry.getKey()), entry.getValue());
        }
        return hashMap2;
    }

    public Task<List<w1.i>> e(List<w1.f> list) {
        h.b j02 = i2.h.j0();
        j02.F(this.f8480b.a());
        for (w1.f fVar : list) {
            j02.E(this.f8480b.O(fVar));
        }
        return this.f8482d.n(i2.r.b(), j02.build()).continueWith(this.f8481c.o(), new Continuation() { // from class: y1.p
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                List n5;
                n5 = r.this.n(task);
                return n5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1 f(a1.a aVar) {
        return new a1(this.f8482d, this.f8481c, this.f8480b, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1 g(b1.a aVar) {
        return new b1(this.f8482d, this.f8481c, this.f8480b, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s1.l h() {
        return this.f8479a;
    }

    z i(s1.l lVar, z1.g gVar, q1.a<q1.j> aVar, q1.a<String> aVar2, Context context, j0 j0Var) {
        return new z(gVar, context, aVar, aVar2, lVar, j0Var);
    }

    public Task<List<v1.s>> p(List<v1.l> list) {
        d.b j02 = i2.d.j0();
        j02.F(this.f8480b.a());
        for (v1.l lVar : list) {
            j02.E(this.f8480b.L(lVar));
        }
        ArrayList arrayList = new ArrayList();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f8482d.o(i2.r.a(), j02.build(), new a(arrayList, list, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public Task<Map<String, i2.d0>> q(s1.a1 a1Var, List<com.google.firebase.firestore.a> list) {
        a0.d S = this.f8480b.S(a1Var.C());
        final HashMap<String, String> hashMap = new HashMap<>();
        i2.y U = this.f8480b.U(S, list, hashMap);
        w.b h02 = i2.w.h0();
        h02.E(S.h0());
        h02.F(U);
        return this.f8482d.n(i2.r.d(), h02.build()).continueWith(this.f8481c.o(), new Continuation() { // from class: y1.q
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Map o5;
                o5 = r.this.o(hashMap, task);
                return o5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.f8482d.q();
    }
}
