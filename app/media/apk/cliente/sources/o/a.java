package o;

import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;
import o.l0;
import o.t0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends t0 implements l0.n {

    /* renamed from: t  reason: collision with root package name */
    final l0 f6348t;

    /* renamed from: u  reason: collision with root package name */
    boolean f6349u;

    /* renamed from: v  reason: collision with root package name */
    int f6350v;

    /* renamed from: w  reason: collision with root package name */
    boolean f6351w;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(l0 l0Var) {
        super(l0Var.t0(), l0Var.v0() != null ? l0Var.v0().u().getClassLoader() : null);
        this.f6350v = -1;
        this.f6351w = false;
        this.f6348t = l0Var;
    }

    @Override // o.l0.n
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (l0.I0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f6668i) {
            this.f6348t.h(this);
            return true;
        }
        return true;
    }

    @Override // o.t0
    public int f() {
        return o(false);
    }

    @Override // o.t0
    public int g() {
        return o(true);
    }

    @Override // o.t0
    public void h() {
        j();
        this.f6348t.b0(this, false);
    }

    @Override // o.t0
    public void i() {
        j();
        this.f6348t.b0(this, true);
    }

    @Override // o.t0
    void k(int i5, s sVar, String str, int i6) {
        super.k(i5, sVar, str, i6);
        sVar.f6624y = this.f6348t;
    }

    @Override // o.t0
    public t0 l(s sVar) {
        l0 l0Var = sVar.f6624y;
        if (l0Var == null || l0Var == this.f6348t) {
            return super.l(sVar);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + sVar.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i5) {
        t0.a aVar;
        if (this.f6668i) {
            if (l0.I0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i5);
            }
            int size = this.f6662c.size();
            for (int i6 = 0; i6 < size; i6++) {
                s sVar = this.f6662c.get(i6).f6680b;
                if (sVar != null) {
                    sVar.f6623x += i5;
                    if (l0.I0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f6680b + " to " + aVar.f6680b.f6623x);
                    }
                }
            }
        }
    }

    int o(boolean z4) {
        if (this.f6349u) {
            throw new IllegalStateException("commit already called");
        }
        if (l0.I0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new y0("FragmentManager"));
            p("  ", printWriter);
            printWriter.close();
        }
        this.f6349u = true;
        this.f6350v = this.f6668i ? this.f6348t.k() : -1;
        this.f6348t.Y(this, z4);
        return this.f6350v;
    }

    public void p(String str, PrintWriter printWriter) {
        q(str, printWriter, true);
    }

    public void q(String str, PrintWriter printWriter, boolean z4) {
        String str2;
        if (z4) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f6670k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f6350v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f6349u);
            if (this.f6667h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f6667h));
            }
            if (this.f6663d != 0 || this.f6664e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f6663d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f6664e));
            }
            if (this.f6665f != 0 || this.f6666g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f6665f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f6666g));
            }
            if (this.f6671l != 0 || this.f6672m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f6671l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f6672m);
            }
            if (this.f6673n != 0 || this.f6674o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f6673n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f6674o);
            }
        }
        if (this.f6662c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f6662c.size();
        for (int i5 = 0; i5 < size; i5++) {
            t0.a aVar = this.f6662c.get(i5);
            switch (aVar.f6679a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f6679a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i5);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f6680b);
            if (z4) {
                if (aVar.f6682d != 0 || aVar.f6683e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f6682d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f6683e));
                }
                if (aVar.f6684f != 0 || aVar.f6685g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f6684f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f6685g));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        l0 l0Var;
        int size = this.f6662c.size();
        for (int i5 = 0; i5 < size; i5++) {
            t0.a aVar = this.f6662c.get(i5);
            s sVar = aVar.f6680b;
            if (sVar != null) {
                sVar.f6618s = this.f6351w;
                sVar.y1(false);
                sVar.x1(this.f6667h);
                sVar.A1(this.f6675p, this.f6676q);
            }
            switch (aVar.f6679a) {
                case 1:
                    sVar.u1(aVar.f6682d, aVar.f6683e, aVar.f6684f, aVar.f6685g);
                    this.f6348t.o1(sVar, false);
                    this.f6348t.i(sVar);
                    continue;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f6679a);
                case 3:
                    sVar.u1(aVar.f6682d, aVar.f6683e, aVar.f6684f, aVar.f6685g);
                    this.f6348t.h1(sVar);
                    continue;
                case 4:
                    sVar.u1(aVar.f6682d, aVar.f6683e, aVar.f6684f, aVar.f6685g);
                    this.f6348t.F0(sVar);
                    continue;
                case 5:
                    sVar.u1(aVar.f6682d, aVar.f6683e, aVar.f6684f, aVar.f6685g);
                    this.f6348t.o1(sVar, false);
                    this.f6348t.s1(sVar);
                    continue;
                case 6:
                    sVar.u1(aVar.f6682d, aVar.f6683e, aVar.f6684f, aVar.f6685g);
                    this.f6348t.w(sVar);
                    continue;
                case 7:
                    sVar.u1(aVar.f6682d, aVar.f6683e, aVar.f6684f, aVar.f6685g);
                    this.f6348t.o1(sVar, false);
                    this.f6348t.m(sVar);
                    continue;
                case 8:
                    l0Var = this.f6348t;
                    break;
                case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    l0Var = this.f6348t;
                    sVar = null;
                    break;
                case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    this.f6348t.p1(sVar, aVar.f6687i);
                    continue;
            }
            l0Var.q1(sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        l0 l0Var;
        for (int size = this.f6662c.size() - 1; size >= 0; size--) {
            t0.a aVar = this.f6662c.get(size);
            s sVar = aVar.f6680b;
            if (sVar != null) {
                sVar.f6618s = this.f6351w;
                sVar.y1(true);
                sVar.x1(l0.l1(this.f6667h));
                sVar.A1(this.f6676q, this.f6675p);
            }
            switch (aVar.f6679a) {
                case 1:
                    sVar.u1(aVar.f6682d, aVar.f6683e, aVar.f6684f, aVar.f6685g);
                    this.f6348t.o1(sVar, true);
                    this.f6348t.h1(sVar);
                    continue;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f6679a);
                case 3:
                    sVar.u1(aVar.f6682d, aVar.f6683e, aVar.f6684f, aVar.f6685g);
                    this.f6348t.i(sVar);
                    continue;
                case 4:
                    sVar.u1(aVar.f6682d, aVar.f6683e, aVar.f6684f, aVar.f6685g);
                    this.f6348t.s1(sVar);
                    continue;
                case 5:
                    sVar.u1(aVar.f6682d, aVar.f6683e, aVar.f6684f, aVar.f6685g);
                    this.f6348t.o1(sVar, true);
                    this.f6348t.F0(sVar);
                    continue;
                case 6:
                    sVar.u1(aVar.f6682d, aVar.f6683e, aVar.f6684f, aVar.f6685g);
                    this.f6348t.m(sVar);
                    continue;
                case 7:
                    sVar.u1(aVar.f6682d, aVar.f6683e, aVar.f6684f, aVar.f6685g);
                    this.f6348t.o1(sVar, true);
                    this.f6348t.w(sVar);
                    continue;
                case 8:
                    l0Var = this.f6348t;
                    sVar = null;
                    break;
                case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    l0Var = this.f6348t;
                    break;
                case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    this.f6348t.p1(sVar, aVar.f6686h);
                    continue;
            }
            l0Var.q1(sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s t(ArrayList<s> arrayList, s sVar) {
        s sVar2 = sVar;
        int i5 = 0;
        while (i5 < this.f6662c.size()) {
            t0.a aVar = this.f6662c.get(i5);
            int i6 = aVar.f6679a;
            if (i6 != 1) {
                if (i6 == 2) {
                    s sVar3 = aVar.f6680b;
                    int i7 = sVar3.D;
                    boolean z4 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        s sVar4 = arrayList.get(size);
                        if (sVar4.D == i7) {
                            if (sVar4 == sVar3) {
                                z4 = true;
                            } else {
                                if (sVar4 == sVar2) {
                                    this.f6662c.add(i5, new t0.a(9, sVar4, true));
                                    i5++;
                                    sVar2 = null;
                                }
                                t0.a aVar2 = new t0.a(3, sVar4, true);
                                aVar2.f6682d = aVar.f6682d;
                                aVar2.f6684f = aVar.f6684f;
                                aVar2.f6683e = aVar.f6683e;
                                aVar2.f6685g = aVar.f6685g;
                                this.f6662c.add(i5, aVar2);
                                arrayList.remove(sVar4);
                                i5++;
                            }
                        }
                    }
                    if (z4) {
                        this.f6662c.remove(i5);
                        i5--;
                    } else {
                        aVar.f6679a = 1;
                        aVar.f6681c = true;
                        arrayList.add(sVar3);
                    }
                } else if (i6 == 3 || i6 == 6) {
                    arrayList.remove(aVar.f6680b);
                    s sVar5 = aVar.f6680b;
                    if (sVar5 == sVar2) {
                        this.f6662c.add(i5, new t0.a(9, sVar5));
                        i5++;
                        sVar2 = null;
                    }
                } else if (i6 != 7) {
                    if (i6 == 8) {
                        this.f6662c.add(i5, new t0.a(9, sVar2, true));
                        aVar.f6681c = true;
                        i5++;
                        sVar2 = aVar.f6680b;
                    }
                }
                i5++;
            }
            arrayList.add(aVar.f6680b);
            i5++;
        }
        return sVar2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f6350v >= 0) {
            sb.append(" #");
            sb.append(this.f6350v);
        }
        if (this.f6670k != null) {
            sb.append(" ");
            sb.append(this.f6670k);
        }
        sb.append("}");
        return sb.toString();
    }

    public String u() {
        return this.f6670k;
    }

    public void v() {
        if (this.f6678s != null) {
            for (int i5 = 0; i5 < this.f6678s.size(); i5++) {
                this.f6678s.get(i5).run();
            }
            this.f6678s = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s w(ArrayList<s> arrayList, s sVar) {
        for (int size = this.f6662c.size() - 1; size >= 0; size--) {
            t0.a aVar = this.f6662c.get(size);
            int i5 = aVar.f6679a;
            if (i5 != 1) {
                if (i5 != 3) {
                    switch (i5) {
                        case 8:
                            sVar = null;
                            break;
                        case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            sVar = aVar.f6680b;
                            break;
                        case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            aVar.f6687i = aVar.f6686h;
                            break;
                    }
                }
                arrayList.add(aVar.f6680b);
            }
            arrayList.remove(aVar.f6680b);
        }
        return sVar;
    }
}
