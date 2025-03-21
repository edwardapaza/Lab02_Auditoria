package o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.i;
import c.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import o.t0;
import p.d;
/* loaded from: classes.dex */
public abstract class l0 {
    private static boolean U = false;
    static boolean V = true;
    s A;
    private c.c<Intent> F;
    private c.c<c.f> G;
    private c.c<String[]> H;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private ArrayList<o.a> O;
    private ArrayList<Boolean> P;
    private ArrayList<s> Q;
    private o0 R;
    private d.c S;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6484b;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<s> f6487e;

    /* renamed from: g  reason: collision with root package name */
    private androidx.activity.q f6489g;

    /* renamed from: x  reason: collision with root package name */
    private d0<?> f6506x;

    /* renamed from: y  reason: collision with root package name */
    private z f6507y;

    /* renamed from: z  reason: collision with root package name */
    private s f6508z;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<n> f6483a = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final s0 f6485c = new s0();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<o.a> f6486d = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private final e0 f6488f = new e0(this);

    /* renamed from: h  reason: collision with root package name */
    o.a f6490h = null;

    /* renamed from: i  reason: collision with root package name */
    boolean f6491i = false;

    /* renamed from: j  reason: collision with root package name */
    private final androidx.activity.p f6492j = new b(false);

    /* renamed from: k  reason: collision with root package name */
    private final AtomicInteger f6493k = new AtomicInteger();

    /* renamed from: l  reason: collision with root package name */
    private final Map<String, o.c> f6494l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m  reason: collision with root package name */
    private final Map<String, Bundle> f6495m = Collections.synchronizedMap(new HashMap());

    /* renamed from: n  reason: collision with root package name */
    private final Map<String, Object> f6496n = Collections.synchronizedMap(new HashMap());

    /* renamed from: o  reason: collision with root package name */
    ArrayList<m> f6497o = new ArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    private final f0 f6498p = new f0(this);

    /* renamed from: q  reason: collision with root package name */
    private final CopyOnWriteArrayList<p0> f6499q = new CopyOnWriteArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    private final k.a<Configuration> f6500r = new k.a() { // from class: o.g0
        @Override // k.a
        public final void accept(Object obj) {
            l0.this.R0((Configuration) obj);
        }
    };

    /* renamed from: s  reason: collision with root package name */
    private final k.a<Integer> f6501s = new k.a() { // from class: o.h0
        @Override // k.a
        public final void accept(Object obj) {
            l0.this.S0((Integer) obj);
        }
    };

    /* renamed from: t  reason: collision with root package name */
    private final k.a<androidx.core.app.o> f6502t = new k.a() { // from class: o.i0
        @Override // k.a
        public final void accept(Object obj) {
            l0.this.T0((androidx.core.app.o) obj);
        }
    };

    /* renamed from: u  reason: collision with root package name */
    private final k.a<androidx.core.app.u0> f6503u = new k.a() { // from class: o.j0
        @Override // k.a
        public final void accept(Object obj) {
            l0.this.U0((androidx.core.app.u0) obj);
        }
    };

    /* renamed from: v  reason: collision with root package name */
    private final androidx.core.view.f f6504v = new c();

    /* renamed from: w  reason: collision with root package name */
    int f6505w = -1;
    private c0 B = null;
    private c0 C = new d();
    private c1 D = null;
    private c1 E = new e();
    ArrayDeque<l> I = new ArrayDeque<>();
    private Runnable T = new f();

    /* loaded from: classes.dex */
    class a implements c.b<Map<String, Boolean>> {
        a() {
        }

        @Override // c.b
        /* renamed from: b */
        public void a(Map<String, Boolean> map) {
            StringBuilder sb;
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                iArr[i5] = ((Boolean) arrayList.get(i5)).booleanValue() ? 0 : -1;
            }
            l pollFirst = l0.this.I.pollFirst();
            if (pollFirst == null) {
                sb = new StringBuilder();
                sb.append("No permissions were requested for ");
                sb.append(this);
            } else {
                String str = pollFirst.f6519a;
                int i6 = pollFirst.f6520b;
                s i7 = l0.this.f6485c.i(str);
                if (i7 != null) {
                    i7.I0(i6, strArr, iArr);
                    return;
                }
                sb = new StringBuilder();
                sb.append("Permission request result delivered for unknown Fragment ");
                sb.append(str);
            }
            Log.w("FragmentManager", sb.toString());
        }
    }

    /* loaded from: classes.dex */
    class b extends androidx.activity.p {
        b(boolean z4) {
            super(z4);
        }

        @Override // androidx.activity.p
        public void c() {
            if (l0.I0(3)) {
                Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = " + l0.V + " fragment manager " + l0.this);
            }
            if (l0.V) {
                l0.this.o();
                l0.this.f6490h = null;
            }
        }

        @Override // androidx.activity.p
        public void d() {
            if (l0.I0(3)) {
                Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = " + l0.V + " fragment manager " + l0.this);
            }
            l0.this.E0();
        }

        @Override // androidx.activity.p
        public void e(androidx.activity.b bVar) {
            if (l0.I0(2)) {
                Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = " + l0.V + " fragment manager " + l0.this);
            }
            l0 l0Var = l0.this;
            if (l0Var.f6490h != null) {
                for (b1 b1Var : l0Var.u(new ArrayList<>(Collections.singletonList(l0.this.f6490h)), 0, 1)) {
                    b1Var.y(bVar);
                }
                Iterator<m> it = l0.this.f6497o.iterator();
                while (it.hasNext()) {
                    it.next().a(bVar);
                }
            }
        }

        @Override // androidx.activity.p
        public void f(androidx.activity.b bVar) {
            if (l0.I0(3)) {
                Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = " + l0.V + " fragment manager " + l0.this);
            }
            if (l0.V) {
                l0.this.X();
                l0.this.g1();
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements androidx.core.view.f {
        c() {
        }

        @Override // androidx.core.view.f
        public boolean a(MenuItem menuItem) {
            return l0.this.J(menuItem);
        }

        @Override // androidx.core.view.f
        public void b(Menu menu) {
            l0.this.K(menu);
        }

        @Override // androidx.core.view.f
        public void c(Menu menu, MenuInflater menuInflater) {
            l0.this.C(menu, menuInflater);
        }

        @Override // androidx.core.view.f
        public void d(Menu menu) {
            l0.this.O(menu);
        }
    }

    /* loaded from: classes.dex */
    class d extends c0 {
        d() {
        }

        @Override // o.c0
        public s a(ClassLoader classLoader, String str) {
            return l0.this.v0().d(l0.this.v0().u(), str, null);
        }
    }

    /* loaded from: classes.dex */
    class e implements c1 {
        e() {
        }

        @Override // o.c1
        public b1 a(ViewGroup viewGroup) {
            return new o.f(viewGroup);
        }
    }

    /* loaded from: classes.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l0.this.a0(true);
        }
    }

    /* loaded from: classes.dex */
    class g implements p0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f6515a;

        g(s sVar) {
            this.f6515a = sVar;
        }

        @Override // o.p0
        public void b(l0 l0Var, s sVar) {
            this.f6515a.m0(sVar);
        }
    }

    /* loaded from: classes.dex */
    class h implements c.b<c.a> {
        h() {
        }

        @Override // c.b
        /* renamed from: b */
        public void a(c.a aVar) {
            l pollLast = l0.this.I.pollLast();
            if (pollLast == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = pollLast.f6519a;
            int i5 = pollLast.f6520b;
            s i6 = l0.this.f6485c.i(str);
            if (i6 != null) {
                i6.j0(i5, aVar.b(), aVar.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    /* loaded from: classes.dex */
    class i implements c.b<c.a> {
        i() {
        }

        @Override // c.b
        /* renamed from: b */
        public void a(c.a aVar) {
            l pollFirst = l0.this.I.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = pollFirst.f6519a;
            int i5 = pollFirst.f6520b;
            s i6 = l0.this.f6485c.i(str);
            if (i6 != null) {
                i6.j0(i5, aVar.b(), aVar.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    /* loaded from: classes.dex */
    static class j extends d.a<c.f, c.a> {
        j() {
        }

        @Override // d.a
        /* renamed from: d */
        public Intent a(Context context, c.f fVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent a5 = fVar.a();
            if (a5 != null && (bundleExtra = a5.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                a5.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (a5.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    fVar = new f.a(fVar.g()).b(null).c(fVar.f(), fVar.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", fVar);
            if (l0.I0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // d.a
        /* renamed from: e */
        public c.a c(int i5, Intent intent) {
            return new c.a(i5, intent);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class k {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class l implements Parcelable {
        public static final Parcelable.Creator<l> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f6519a;

        /* renamed from: b  reason: collision with root package name */
        int f6520b;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<l> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public l createFromParcel(Parcel parcel) {
                return new l(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public l[] newArray(int i5) {
                return new l[i5];
            }
        }

        l(Parcel parcel) {
            this.f6519a = parcel.readString();
            this.f6520b = parcel.readInt();
        }

        l(String str, int i5) {
            this.f6519a = str;
            this.f6520b = i5;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeString(this.f6519a);
            parcel.writeInt(this.f6520b);
        }
    }

    /* loaded from: classes.dex */
    public interface m {
        void a(androidx.activity.b bVar);

        void b(s sVar, boolean z4);

        void c();

        void d(s sVar, boolean z4);

        void onBackStackChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface n {
        boolean a(ArrayList<o.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    private class o implements n {

        /* renamed from: a  reason: collision with root package name */
        final String f6521a;

        /* renamed from: b  reason: collision with root package name */
        final int f6522b;

        /* renamed from: c  reason: collision with root package name */
        final int f6523c;

        o(String str, int i5, int i6) {
            this.f6521a = str;
            this.f6522b = i5;
            this.f6523c = i6;
        }

        @Override // o.l0.n
        public boolean a(ArrayList<o.a> arrayList, ArrayList<Boolean> arrayList2) {
            s sVar = l0.this.A;
            if (sVar == null || this.f6522b >= 0 || this.f6521a != null || !sVar.t().b1()) {
                return l0.this.e1(arrayList, arrayList2, this.f6521a, this.f6522b, this.f6523c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p implements n {
        p() {
        }

        @Override // o.l0.n
        public boolean a(ArrayList<o.a> arrayList, ArrayList<Boolean> arrayList2) {
            boolean f12 = l0.this.f1(arrayList, arrayList2);
            l0 l0Var = l0.this;
            l0Var.f6491i = true;
            if (!l0Var.f6497o.isEmpty() && arrayList.size() > 0) {
                boolean booleanValue = arrayList2.get(arrayList.size() - 1).booleanValue();
                LinkedHashSet<s> linkedHashSet = new LinkedHashSet();
                Iterator<o.a> it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedHashSet.addAll(l0.this.n0(it.next()));
                }
                Iterator<m> it2 = l0.this.f6497o.iterator();
                while (it2.hasNext()) {
                    m next = it2.next();
                    for (s sVar : linkedHashSet) {
                        next.b(sVar, booleanValue);
                    }
                }
            }
            return f12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s C0(View view) {
        Object tag = view.getTag(n.b.fragment_container_view_tag);
        if (tag instanceof s) {
            return (s) tag;
        }
        return null;
    }

    public static boolean I0(int i5) {
        return U || Log.isLoggable("FragmentManager", i5);
    }

    private boolean J0(s sVar) {
        return (sVar.J && sVar.K) || sVar.A.p();
    }

    private boolean K0() {
        s sVar = this.f6508z;
        if (sVar == null) {
            return true;
        }
        return sVar.Z() && this.f6508z.H().K0();
    }

    private void L(s sVar) {
        if (sVar == null || !sVar.equals(f0(sVar.f6607f))) {
            return;
        }
        sVar.h1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(Configuration configuration) {
        if (K0()) {
            z(configuration, false);
        }
    }

    private void S(int i5) {
        try {
            this.f6484b = true;
            this.f6485c.d(i5);
            W0(i5, false);
            for (b1 b1Var : t()) {
                b1Var.q();
            }
            this.f6484b = false;
            a0(true);
        } catch (Throwable th) {
            this.f6484b = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(Integer num) {
        if (K0() && num.intValue() == 80) {
            F(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(androidx.core.app.o oVar) {
        if (K0()) {
            G(oVar.a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(androidx.core.app.u0 u0Var) {
        if (K0()) {
            N(u0Var.a(), false);
        }
    }

    private void V() {
        if (this.N) {
            this.N = false;
            t1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        for (b1 b1Var : t()) {
            b1Var.q();
        }
    }

    private void Z(boolean z4) {
        if (this.f6484b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f6506x == null) {
            if (!this.M) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        } else if (Looper.myLooper() != this.f6506x.w().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z4) {
                q();
            }
            if (this.O == null) {
                this.O = new ArrayList<>();
                this.P = new ArrayList<>();
            }
        }
    }

    private static void c0(ArrayList<o.a> arrayList, ArrayList<Boolean> arrayList2, int i5, int i6) {
        while (i5 < i6) {
            o.a aVar = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue()) {
                aVar.n(-1);
                aVar.s();
            } else {
                aVar.n(1);
                aVar.r();
            }
            i5++;
        }
    }

    private void d0(ArrayList<o.a> arrayList, ArrayList<Boolean> arrayList2, int i5, int i6) {
        boolean z4 = arrayList.get(i5).f6677r;
        ArrayList<s> arrayList3 = this.Q;
        if (arrayList3 == null) {
            this.Q = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.Q.addAll(this.f6485c.o());
        s z02 = z0();
        boolean z5 = false;
        for (int i7 = i5; i7 < i6; i7++) {
            o.a aVar = arrayList.get(i7);
            z02 = !arrayList2.get(i7).booleanValue() ? aVar.t(this.Q, z02) : aVar.w(this.Q, z02);
            z5 = z5 || aVar.f6668i;
        }
        this.Q.clear();
        if (!z4 && this.f6505w >= 1) {
            for (int i8 = i5; i8 < i6; i8++) {
                Iterator<t0.a> it = arrayList.get(i8).f6662c.iterator();
                while (it.hasNext()) {
                    s sVar = it.next().f6680b;
                    if (sVar != null && sVar.f6624y != null) {
                        this.f6485c.r(v(sVar));
                    }
                }
            }
        }
        c0(arrayList, arrayList2, i5, i6);
        boolean booleanValue = arrayList2.get(i6 - 1).booleanValue();
        if (z5 && !this.f6497o.isEmpty()) {
            LinkedHashSet<s> linkedHashSet = new LinkedHashSet();
            Iterator<o.a> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(n0(it2.next()));
            }
            if (this.f6490h == null) {
                Iterator<m> it3 = this.f6497o.iterator();
                while (it3.hasNext()) {
                    m next = it3.next();
                    for (s sVar2 : linkedHashSet) {
                        next.b(sVar2, booleanValue);
                    }
                }
                Iterator<m> it4 = this.f6497o.iterator();
                while (it4.hasNext()) {
                    m next2 = it4.next();
                    for (s sVar3 : linkedHashSet) {
                        next2.d(sVar3, booleanValue);
                    }
                }
            }
        }
        for (int i9 = i5; i9 < i6; i9++) {
            o.a aVar2 = arrayList.get(i9);
            if (booleanValue) {
                for (int size = aVar2.f6662c.size() - 1; size >= 0; size--) {
                    s sVar4 = aVar2.f6662c.get(size).f6680b;
                    if (sVar4 != null) {
                        v(sVar4).m();
                    }
                }
            } else {
                Iterator<t0.a> it5 = aVar2.f6662c.iterator();
                while (it5.hasNext()) {
                    s sVar5 = it5.next().f6680b;
                    if (sVar5 != null) {
                        v(sVar5).m();
                    }
                }
            }
        }
        W0(this.f6505w, true);
        for (b1 b1Var : u(arrayList, i5, i6)) {
            b1Var.B(booleanValue);
            b1Var.x();
            b1Var.n();
        }
        while (i5 < i6) {
            o.a aVar3 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && aVar3.f6350v >= 0) {
                aVar3.f6350v = -1;
            }
            aVar3.v();
            i5++;
        }
        if (z5) {
            j1();
        }
    }

    private boolean d1(String str, int i5, int i6) {
        a0(false);
        Z(true);
        s sVar = this.A;
        if (sVar == null || i5 >= 0 || str != null || !sVar.t().b1()) {
            boolean e12 = e1(this.O, this.P, str, i5, i6);
            if (e12) {
                this.f6484b = true;
                try {
                    i1(this.O, this.P);
                } finally {
                    r();
                }
            }
            v1();
            V();
            this.f6485c.b();
            return e12;
        }
        return true;
    }

    private int g0(String str, int i5, boolean z4) {
        if (this.f6486d.isEmpty()) {
            return -1;
        }
        if (str == null && i5 < 0) {
            if (z4) {
                return 0;
            }
            return this.f6486d.size() - 1;
        }
        int size = this.f6486d.size() - 1;
        while (size >= 0) {
            o.a aVar = this.f6486d.get(size);
            if ((str != null && str.equals(aVar.u())) || (i5 >= 0 && i5 == aVar.f6350v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z4) {
            if (size == this.f6486d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            o.a aVar2 = this.f6486d.get(size - 1);
            if ((str == null || !str.equals(aVar2.u())) && (i5 < 0 || i5 != aVar2.f6350v)) {
                return size;
            }
            size--;
        }
        return size;
    }

    private void i1(ArrayList<o.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            if (!arrayList.get(i5).f6677r) {
                if (i6 != i5) {
                    d0(arrayList, arrayList2, i6, i5);
                }
                i6 = i5 + 1;
                if (arrayList2.get(i5).booleanValue()) {
                    while (i6 < size && arrayList2.get(i6).booleanValue() && !arrayList.get(i6).f6677r) {
                        i6++;
                    }
                }
                d0(arrayList, arrayList2, i5, i6);
                i5 = i6 - 1;
            }
            i5++;
        }
        if (i6 != size) {
            d0(arrayList, arrayList2, i6, size);
        }
    }

    private void j1() {
        for (int i5 = 0; i5 < this.f6497o.size(); i5++) {
            this.f6497o.get(i5).onBackStackChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l0 k0(View view) {
        s l02 = l0(view);
        if (l02 != null) {
            if (l02.Z()) {
                return l02.t();
            }
            throw new IllegalStateException("The Fragment " + l02 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        x xVar = null;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof x) {
                xVar = (x) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (xVar != null) {
            return xVar.O();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s l0(View view) {
        while (view != null) {
            s C0 = C0(view);
            if (C0 != null) {
                return C0;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l1(int i5) {
        if (i5 != 4097) {
            if (i5 != 8194) {
                if (i5 != 8197) {
                    if (i5 != 4099) {
                        return i5 != 4100 ? 0 : 8197;
                    }
                    return 4099;
                }
                return 4100;
            }
            return 4097;
        }
        return 8194;
    }

    private void m0() {
        for (b1 b1Var : t()) {
            b1Var.r();
        }
    }

    private boolean o0(ArrayList<o.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f6483a) {
            if (this.f6483a.isEmpty()) {
                return false;
            }
            int size = this.f6483a.size();
            boolean z4 = false;
            for (int i5 = 0; i5 < size; i5++) {
                z4 |= this.f6483a.get(i5).a(arrayList, arrayList2);
            }
            this.f6483a.clear();
            this.f6506x.w().removeCallbacks(this.T);
            return z4;
        }
    }

    private void q() {
        if (P0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private o0 q0(s sVar) {
        return this.R.i(sVar);
    }

    private void r() {
        this.f6484b = false;
        this.P.clear();
        this.O.clear();
    }

    private void r1(s sVar) {
        ViewGroup s02 = s0(sVar);
        if (s02 == null || sVar.v() + sVar.y() + sVar.J() + sVar.K() <= 0) {
            return;
        }
        int i5 = n.b.visible_removing_fragment_view_tag;
        if (s02.getTag(i5) == null) {
            s02.setTag(i5, sVar);
        }
        ((s) s02.getTag(i5)).y1(sVar.I());
    }

    private void s() {
        d0<?> d0Var = this.f6506x;
        boolean z4 = true;
        if (d0Var instanceof androidx.lifecycle.m0) {
            z4 = this.f6485c.p().m();
        } else if (d0Var.u() instanceof Activity) {
            z4 = true ^ ((Activity) this.f6506x.u()).isChangingConfigurations();
        }
        if (z4) {
            for (o.c cVar : this.f6494l.values()) {
                for (String str : cVar.f6408a) {
                    this.f6485c.p().e(str, false);
                }
            }
        }
    }

    private ViewGroup s0(s sVar) {
        ViewGroup viewGroup = sVar.M;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (sVar.D > 0 && this.f6507y.s()) {
            View g5 = this.f6507y.g(sVar.D);
            if (g5 instanceof ViewGroup) {
                return (ViewGroup) g5;
            }
        }
        return null;
    }

    private Set<b1> t() {
        HashSet hashSet = new HashSet();
        for (r0 r0Var : this.f6485c.k()) {
            ViewGroup viewGroup = r0Var.k().M;
            if (viewGroup != null) {
                hashSet.add(b1.v(viewGroup, A0()));
            }
        }
        return hashSet;
    }

    private void t1() {
        for (r0 r0Var : this.f6485c.k()) {
            Z0(r0Var);
        }
    }

    private void u1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new y0("FragmentManager"));
        d0<?> d0Var = this.f6506x;
        try {
            if (d0Var != null) {
                d0Var.x("  ", null, printWriter, new String[0]);
            } else {
                W("  ", null, printWriter, new String[0]);
            }
        } catch (Exception e5) {
            Log.e("FragmentManager", "Failed dumping state", e5);
        }
        throw runtimeException;
    }

    private void v1() {
        synchronized (this.f6483a) {
            boolean z4 = true;
            if (!this.f6483a.isEmpty()) {
                this.f6492j.j(true);
                if (I0(3)) {
                    Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                }
                return;
            }
            z4 = (p0() <= 0 || !N0(this.f6508z)) ? false : false;
            if (I0(3)) {
                Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z4);
            }
            this.f6492j.j(z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A(MenuItem menuItem) {
        if (this.f6505w < 1) {
            return false;
        }
        for (s sVar : this.f6485c.o()) {
            if (sVar != null && sVar.S0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c1 A0() {
        c1 c1Var = this.D;
        if (c1Var != null) {
            return c1Var;
        }
        s sVar = this.f6508z;
        return sVar != null ? sVar.f6624y.A0() : this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        this.K = false;
        this.L = false;
        this.R.o(false);
        S(1);
    }

    public d.c B0() {
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C(Menu menu, MenuInflater menuInflater) {
        if (this.f6505w < 1) {
            return false;
        }
        ArrayList<s> arrayList = null;
        boolean z4 = false;
        for (s sVar : this.f6485c.o()) {
            if (sVar != null && M0(sVar) && sVar.U0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(sVar);
                z4 = true;
            }
        }
        if (this.f6487e != null) {
            for (int i5 = 0; i5 < this.f6487e.size(); i5++) {
                s sVar2 = this.f6487e.get(i5);
                if (arrayList == null || !arrayList.contains(sVar2)) {
                    sVar2.u0();
                }
            }
        }
        this.f6487e = arrayList;
        return z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D() {
        this.M = true;
        a0(true);
        X();
        s();
        S(-1);
        d0<?> d0Var = this.f6506x;
        if (d0Var instanceof androidx.core.content.n) {
            ((androidx.core.content.n) d0Var).o(this.f6501s);
        }
        d0<?> d0Var2 = this.f6506x;
        if (d0Var2 instanceof androidx.core.content.m) {
            ((androidx.core.content.m) d0Var2).f(this.f6500r);
        }
        d0<?> d0Var3 = this.f6506x;
        if (d0Var3 instanceof androidx.core.app.r0) {
            ((androidx.core.app.r0) d0Var3).e(this.f6502t);
        }
        d0<?> d0Var4 = this.f6506x;
        if (d0Var4 instanceof androidx.core.app.s0) {
            ((androidx.core.app.s0) d0Var4).h(this.f6503u);
        }
        d0<?> d0Var5 = this.f6506x;
        if ((d0Var5 instanceof androidx.core.view.d) && this.f6508z == null) {
            ((androidx.core.view.d) d0Var5).c(this.f6504v);
        }
        this.f6506x = null;
        this.f6507y = null;
        this.f6508z = null;
        if (this.f6489g != null) {
            this.f6492j.h();
            this.f6489g = null;
        }
        c.c<Intent> cVar = this.F;
        if (cVar != null) {
            cVar.c();
            this.G.c();
            this.H.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.l0 D0(s sVar) {
        return this.R.l(sVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        S(1);
    }

    void E0() {
        a0(true);
        if (!V || this.f6490h == null) {
            if (this.f6492j.g()) {
                if (I0(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                b1();
                return;
            }
            if (I0(3)) {
                Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
            }
            this.f6489g.k();
            return;
        }
        if (!this.f6497o.isEmpty()) {
            LinkedHashSet<s> linkedHashSet = new LinkedHashSet(n0(this.f6490h));
            Iterator<m> it = this.f6497o.iterator();
            while (it.hasNext()) {
                m next = it.next();
                for (s sVar : linkedHashSet) {
                    next.d(sVar, true);
                }
            }
        }
        Iterator<t0.a> it2 = this.f6490h.f6662c.iterator();
        while (it2.hasNext()) {
            s sVar2 = it2.next().f6680b;
            if (sVar2 != null) {
                sVar2.f6617r = false;
            }
        }
        for (b1 b1Var : u(new ArrayList<>(Collections.singletonList(this.f6490h)), 0, 1)) {
            b1Var.f();
        }
        this.f6490h = null;
        v1();
        if (I0(3)) {
            Log.d("FragmentManager", "Op is being set to null");
            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + this.f6492j.g() + " for  FragmentManager " + this);
        }
    }

    void F(boolean z4) {
        if (z4 && (this.f6506x instanceof androidx.core.content.n)) {
            u1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (s sVar : this.f6485c.o()) {
            if (sVar != null) {
                sVar.a1();
                if (z4) {
                    sVar.A.F(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F0(s sVar) {
        if (I0(2)) {
            Log.v("FragmentManager", "hide: " + sVar);
        }
        if (sVar.F) {
            return;
        }
        sVar.F = true;
        sVar.T = true ^ sVar.T;
        r1(sVar);
    }

    void G(boolean z4, boolean z5) {
        if (z5 && (this.f6506x instanceof androidx.core.app.r0)) {
            u1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (s sVar : this.f6485c.o()) {
            if (sVar != null) {
                sVar.b1(z4);
                if (z5) {
                    sVar.A.G(z4, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G0(s sVar) {
        if (sVar.f6615p && J0(sVar)) {
            this.J = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(s sVar) {
        Iterator<p0> it = this.f6499q.iterator();
        while (it.hasNext()) {
            it.next().b(this, sVar);
        }
    }

    public boolean H0() {
        return this.M;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        for (s sVar : this.f6485c.l()) {
            if (sVar != null) {
                sVar.y0(sVar.a0());
                sVar.A.I();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J(MenuItem menuItem) {
        if (this.f6505w < 1) {
            return false;
        }
        for (s sVar : this.f6485c.o()) {
            if (sVar != null && sVar.c1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(Menu menu) {
        if (this.f6505w < 1) {
            return;
        }
        for (s sVar : this.f6485c.o()) {
            if (sVar != null) {
                sVar.d1(menu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean L0(s sVar) {
        if (sVar == null) {
            return false;
        }
        return sVar.a0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M() {
        S(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean M0(s sVar) {
        if (sVar == null) {
            return true;
        }
        return sVar.c0();
    }

    void N(boolean z4, boolean z5) {
        if (z5 && (this.f6506x instanceof androidx.core.app.s0)) {
            u1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (s sVar : this.f6485c.o()) {
            if (sVar != null) {
                sVar.f1(z4);
                if (z5) {
                    sVar.A.N(z4, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean N0(s sVar) {
        if (sVar == null) {
            return true;
        }
        l0 l0Var = sVar.f6624y;
        return sVar.equals(l0Var.z0()) && N0(l0Var.f6508z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(Menu menu) {
        boolean z4 = false;
        if (this.f6505w < 1) {
            return false;
        }
        for (s sVar : this.f6485c.o()) {
            if (sVar != null && M0(sVar) && sVar.g1(menu)) {
                z4 = true;
            }
        }
        return z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O0(int i5) {
        return this.f6505w >= i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P() {
        v1();
        L(this.A);
    }

    public boolean P0() {
        return this.K || this.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q() {
        this.K = false;
        this.L = false;
        this.R.o(false);
        S(7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R() {
        this.K = false;
        this.L = false;
        this.R.o(false);
        S(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T() {
        this.L = true;
        this.R.o(true);
        S(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U() {
        S(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V0(s sVar, Intent intent, int i5, Bundle bundle) {
        if (this.F == null) {
            this.f6506x.A(sVar, intent, i5, bundle);
            return;
        }
        this.I.addLast(new l(sVar.f6607f, i5));
        if (bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.F.a(intent);
    }

    public void W(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String str2 = str + "    ";
        this.f6485c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<s> arrayList = this.f6487e;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i5 = 0; i5 < size; i5++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(this.f6487e.get(i5).toString());
            }
        }
        int size2 = this.f6486d.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i6 = 0; i6 < size2; i6++) {
                o.a aVar = this.f6486d.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.p(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f6493k.get());
        synchronized (this.f6483a) {
            int size3 = this.f6483a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i7 = 0; i7 < size3; i7++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i7);
                    printWriter.print(": ");
                    printWriter.println(this.f6483a.get(i7));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f6506x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f6507y);
        if (this.f6508z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f6508z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f6505w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.K);
        printWriter.print(" mStopped=");
        printWriter.print(this.L);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.M);
        if (this.J) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.J);
        }
    }

    void W0(int i5, boolean z4) {
        d0<?> d0Var;
        if (this.f6506x == null && i5 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z4 || i5 != this.f6505w) {
            this.f6505w = i5;
            this.f6485c.t();
            t1();
            if (this.J && (d0Var = this.f6506x) != null && this.f6505w == 7) {
                d0Var.B();
                this.J = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X0() {
        if (this.f6506x == null) {
            return;
        }
        this.K = false;
        this.L = false;
        this.R.o(false);
        for (s sVar : this.f6485c.o()) {
            if (sVar != null) {
                sVar.h0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(n nVar, boolean z4) {
        if (!z4) {
            if (this.f6506x == null) {
                if (!this.M) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            q();
        }
        synchronized (this.f6483a) {
            if (this.f6506x == null) {
                if (!z4) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
                return;
            }
            this.f6483a.add(nVar);
            n1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y0(a0 a0Var) {
        View view;
        for (r0 r0Var : this.f6485c.k()) {
            s k5 = r0Var.k();
            if (k5.D == a0Var.getId() && (view = k5.N) != null && view.getParent() == null) {
                k5.M = a0Var;
                r0Var.b();
            }
        }
    }

    void Z0(r0 r0Var) {
        s k5 = r0Var.k();
        if (k5.O) {
            if (this.f6484b) {
                this.N = true;
                return;
            }
            k5.O = false;
            r0Var.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a0(boolean z4) {
        Z(z4);
        boolean z5 = false;
        while (o0(this.O, this.P)) {
            this.f6484b = true;
            try {
                i1(this.O, this.P);
                r();
                z5 = true;
            } catch (Throwable th) {
                r();
                throw th;
            }
        }
        v1();
        V();
        this.f6485c.b();
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a1(int i5, int i6, boolean z4) {
        if (i5 >= 0) {
            Y(new o(null, i5, i6), z4);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0(n nVar, boolean z4) {
        if (z4 && (this.f6506x == null || this.M)) {
            return;
        }
        Z(z4);
        if (nVar.a(this.O, this.P)) {
            this.f6484b = true;
            try {
                i1(this.O, this.P);
            } finally {
                r();
            }
        }
        v1();
        V();
        this.f6485c.b();
    }

    public boolean b1() {
        return d1(null, -1, 0);
    }

    public boolean c1(int i5, int i6) {
        if (i5 >= 0) {
            return d1(null, i5, i6);
        }
        throw new IllegalArgumentException("Bad id: " + i5);
    }

    public boolean e0() {
        boolean a02 = a0(true);
        m0();
        return a02;
    }

    boolean e1(ArrayList<o.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i5, int i6) {
        int g02 = g0(str, i5, (i6 & 1) != 0);
        if (g02 < 0) {
            return false;
        }
        for (int size = this.f6486d.size() - 1; size >= g02; size--) {
            arrayList.add(this.f6486d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s f0(String str) {
        return this.f6485c.f(str);
    }

    boolean f1(ArrayList<o.a> arrayList, ArrayList<Boolean> arrayList2) {
        ArrayList<o.a> arrayList3 = this.f6486d;
        o.a aVar = arrayList3.get(arrayList3.size() - 1);
        this.f6490h = aVar;
        Iterator<t0.a> it = aVar.f6662c.iterator();
        while (it.hasNext()) {
            s sVar = it.next().f6680b;
            if (sVar != null) {
                sVar.f6617r = true;
            }
        }
        return e1(arrayList, arrayList2, null, -1, 0);
    }

    void g1() {
        Y(new p(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(o.a aVar) {
        this.f6486d.add(aVar);
    }

    public s h0(int i5) {
        return this.f6485c.g(i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h1(s sVar) {
        if (I0(2)) {
            Log.v("FragmentManager", "remove: " + sVar + " nesting=" + sVar.f6623x);
        }
        boolean z4 = !sVar.b0();
        if (!sVar.G || z4) {
            this.f6485c.u(sVar);
            if (J0(sVar)) {
                this.J = true;
            }
            sVar.f6616q = true;
            r1(sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0 i(s sVar) {
        String str = sVar.W;
        if (str != null) {
            p.d.h(sVar, str);
        }
        if (I0(2)) {
            Log.v("FragmentManager", "add: " + sVar);
        }
        r0 v5 = v(sVar);
        sVar.f6624y = this;
        this.f6485c.r(v5);
        if (!sVar.G) {
            this.f6485c.a(sVar);
            sVar.f6616q = false;
            if (sVar.N == null) {
                sVar.T = false;
            }
            if (J0(sVar)) {
                this.J = true;
            }
        }
        return v5;
    }

    public s i0(String str) {
        return this.f6485c.h(str);
    }

    public void j(p0 p0Var) {
        this.f6499q.add(p0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s j0(String str) {
        return this.f6485c.i(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f6493k.getAndIncrement();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k1(Parcelable parcelable) {
        r0 r0Var;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f6506x.u().getClassLoader());
                this.f6495m.put(str.substring(7), bundle2);
            }
        }
        HashMap<String, Bundle> hashMap = new HashMap<>();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f6506x.u().getClassLoader());
                hashMap.put(str2.substring(9), bundle);
            }
        }
        this.f6485c.x(hashMap);
        n0 n0Var = (n0) bundle3.getParcelable("state");
        if (n0Var == null) {
            return;
        }
        this.f6485c.v();
        Iterator<String> it = n0Var.f6532a.iterator();
        while (it.hasNext()) {
            Bundle B = this.f6485c.B(it.next(), null);
            if (B != null) {
                s h5 = this.R.h(((q0) B.getParcelable("state")).f6574b);
                if (h5 != null) {
                    if (I0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + h5);
                    }
                    r0Var = new r0(this.f6498p, this.f6485c, h5, B);
                } else {
                    r0Var = new r0(this.f6498p, this.f6485c, this.f6506x.u().getClassLoader(), t0(), B);
                }
                s k5 = r0Var.k();
                k5.f6599b = B;
                k5.f6624y = this;
                if (I0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + k5.f6607f + "): " + k5);
                }
                r0Var.o(this.f6506x.u().getClassLoader());
                this.f6485c.r(r0Var);
                r0Var.s(this.f6505w);
            }
        }
        for (s sVar : this.R.k()) {
            if (!this.f6485c.c(sVar.f6607f)) {
                if (I0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + sVar + " that was not found in the set of active Fragments " + n0Var.f6532a);
                }
                this.R.n(sVar);
                sVar.f6624y = this;
                r0 r0Var2 = new r0(this.f6498p, this.f6485c, sVar);
                r0Var2.s(1);
                r0Var2.m();
                sVar.f6616q = true;
                r0Var2.m();
            }
        }
        this.f6485c.w(n0Var.f6533b);
        if (n0Var.f6534c != null) {
            this.f6486d = new ArrayList<>(n0Var.f6534c.length);
            int i5 = 0;
            while (true) {
                o.b[] bVarArr = n0Var.f6534c;
                if (i5 >= bVarArr.length) {
                    break;
                }
                o.a b5 = bVarArr[i5].b(this);
                if (I0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i5 + " (index " + b5.f6350v + "): " + b5);
                    PrintWriter printWriter = new PrintWriter(new y0("FragmentManager"));
                    b5.q("  ", printWriter, false);
                    printWriter.close();
                }
                this.f6486d.add(b5);
                i5++;
            }
        } else {
            this.f6486d = new ArrayList<>();
        }
        this.f6493k.set(n0Var.f6535d);
        String str3 = n0Var.f6536e;
        if (str3 != null) {
            s f02 = f0(str3);
            this.A = f02;
            L(f02);
        }
        ArrayList<String> arrayList = n0Var.f6537f;
        if (arrayList != null) {
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                this.f6494l.put(arrayList.get(i6), n0Var.f6538k.get(i6));
            }
        }
        this.I = new ArrayDeque<>(n0Var.f6539l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(o.d0<?> r4, o.z r5, o.s r6) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.l0.l(o.d0, o.z, o.s):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(s sVar) {
        if (I0(2)) {
            Log.v("FragmentManager", "attach: " + sVar);
        }
        if (sVar.G) {
            sVar.G = false;
            if (sVar.f6615p) {
                return;
            }
            this.f6485c.a(sVar);
            if (I0(2)) {
                Log.v("FragmentManager", "add from attach: " + sVar);
            }
            if (J0(sVar)) {
                this.J = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m1 */
    public Bundle Q0() {
        Bundle bundle = new Bundle();
        m0();
        X();
        a0(true);
        this.K = true;
        this.R.o(true);
        ArrayList<String> y4 = this.f6485c.y();
        HashMap<String, Bundle> m5 = this.f6485c.m();
        if (!m5.isEmpty()) {
            ArrayList<String> z4 = this.f6485c.z();
            o.b[] bVarArr = null;
            int size = this.f6486d.size();
            if (size > 0) {
                bVarArr = new o.b[size];
                for (int i5 = 0; i5 < size; i5++) {
                    bVarArr[i5] = new o.b(this.f6486d.get(i5));
                    if (I0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i5 + ": " + this.f6486d.get(i5));
                    }
                }
            }
            n0 n0Var = new n0();
            n0Var.f6532a = y4;
            n0Var.f6533b = z4;
            n0Var.f6534c = bVarArr;
            n0Var.f6535d = this.f6493k.get();
            s sVar = this.A;
            if (sVar != null) {
                n0Var.f6536e = sVar.f6607f;
            }
            n0Var.f6537f.addAll(this.f6494l.keySet());
            n0Var.f6538k.addAll(this.f6494l.values());
            n0Var.f6539l = new ArrayList<>(this.I);
            bundle.putParcelable("state", n0Var);
            for (String str : this.f6495m.keySet()) {
                bundle.putBundle("result_" + str, this.f6495m.get(str));
            }
            for (String str2 : m5.keySet()) {
                bundle.putBundle("fragment_" + str2, m5.get(str2));
            }
        } else if (I0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    public t0 n() {
        return new o.a(this);
    }

    Set<s> n0(o.a aVar) {
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < aVar.f6662c.size(); i5++) {
            s sVar = aVar.f6662c.get(i5).f6680b;
            if (sVar != null && aVar.f6668i) {
                hashSet.add(sVar);
            }
        }
        return hashSet;
    }

    void n1() {
        synchronized (this.f6483a) {
            boolean z4 = true;
            if (this.f6483a.size() != 1) {
                z4 = false;
            }
            if (z4) {
                this.f6506x.w().removeCallbacks(this.T);
                this.f6506x.w().post(this.T);
                v1();
            }
        }
    }

    void o() {
        o.a aVar = this.f6490h;
        if (aVar != null) {
            aVar.f6349u = false;
            aVar.f();
            e0();
            Iterator<m> it = this.f6497o.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o1(s sVar, boolean z4) {
        ViewGroup s02 = s0(sVar);
        if (s02 == null || !(s02 instanceof a0)) {
            return;
        }
        ((a0) s02).setDrawDisappearingViewsLast(!z4);
    }

    boolean p() {
        boolean z4 = false;
        for (s sVar : this.f6485c.l()) {
            if (sVar != null) {
                z4 = J0(sVar);
                continue;
            }
            if (z4) {
                return true;
            }
        }
        return false;
    }

    public int p0() {
        return this.f6486d.size() + (this.f6490h != null ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p1(s sVar, i.b bVar) {
        if (sVar.equals(f0(sVar.f6607f)) && (sVar.f6625z == null || sVar.f6624y == this)) {
            sVar.X = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + sVar + " is not an active fragment of FragmentManager " + this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q1(s sVar) {
        if (sVar == null || (sVar.equals(f0(sVar.f6607f)) && (sVar.f6625z == null || sVar.f6624y == this))) {
            s sVar2 = this.A;
            this.A = sVar;
            L(sVar2);
            L(this.A);
            return;
        }
        throw new IllegalArgumentException("Fragment " + sVar + " is not an active fragment of FragmentManager " + this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z r0() {
        return this.f6507y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s1(s sVar) {
        if (I0(2)) {
            Log.v("FragmentManager", "show: " + sVar);
        }
        if (sVar.F) {
            sVar.F = false;
            sVar.T = !sVar.T;
        }
    }

    public c0 t0() {
        c0 c0Var = this.B;
        if (c0Var != null) {
            return c0Var;
        }
        s sVar = this.f6508z;
        return sVar != null ? sVar.f6624y.t0() : this.C;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        s sVar = this.f6508z;
        if (sVar != null) {
            sb.append(sVar.getClass().getSimpleName());
            sb.append("{");
            obj = this.f6508z;
        } else {
            d0<?> d0Var = this.f6506x;
            if (d0Var == null) {
                sb.append("null");
                sb.append("}}");
                return sb.toString();
            }
            sb.append(d0Var.getClass().getSimpleName());
            sb.append("{");
            obj = this.f6506x;
        }
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    Set<b1> u(ArrayList<o.a> arrayList, int i5, int i6) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i5 < i6) {
            Iterator<t0.a> it = arrayList.get(i5).f6662c.iterator();
            while (it.hasNext()) {
                s sVar = it.next().f6680b;
                if (sVar != null && (viewGroup = sVar.M) != null) {
                    hashSet.add(b1.u(viewGroup, this));
                }
            }
            i5++;
        }
        return hashSet;
    }

    public List<s> u0() {
        return this.f6485c.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0 v(s sVar) {
        r0 n5 = this.f6485c.n(sVar.f6607f);
        if (n5 != null) {
            return n5;
        }
        r0 r0Var = new r0(this.f6498p, this.f6485c, sVar);
        r0Var.o(this.f6506x.u().getClassLoader());
        r0Var.s(this.f6505w);
        return r0Var;
    }

    public d0<?> v0() {
        return this.f6506x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(s sVar) {
        if (I0(2)) {
            Log.v("FragmentManager", "detach: " + sVar);
        }
        if (sVar.G) {
            return;
        }
        sVar.G = true;
        if (sVar.f6615p) {
            if (I0(2)) {
                Log.v("FragmentManager", "remove from detach: " + sVar);
            }
            this.f6485c.u(sVar);
            if (J0(sVar)) {
                this.J = true;
            }
            r1(sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 w0() {
        return this.f6488f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        this.K = false;
        this.L = false;
        this.R.o(false);
        S(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0 x0() {
        return this.f6498p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        this.K = false;
        this.L = false;
        this.R.o(false);
        S(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s y0() {
        return this.f6508z;
    }

    void z(Configuration configuration, boolean z4) {
        if (z4 && (this.f6506x instanceof androidx.core.content.m)) {
            u1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (s sVar : this.f6485c.o()) {
            if (sVar != null) {
                sVar.R0(configuration);
                if (z4) {
                    sVar.A.z(configuration, true);
                }
            }
        }
    }

    public s z0() {
        return this.A;
    }
}
