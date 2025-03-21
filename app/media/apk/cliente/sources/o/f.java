package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import o.b1;
import o.f;
import o.y;
/* loaded from: classes.dex */
public final class f extends b1 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends b1.b {

        /* renamed from: d  reason: collision with root package name */
        private final b f6424d;

        /* renamed from: o.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class animation.Animation$AnimationListenerC0101a implements Animation.AnimationListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b1.d f6425a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewGroup f6426b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ View f6427c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ a f6428d;

            animation.Animation$AnimationListenerC0101a(b1.d dVar, ViewGroup viewGroup, View view, a aVar) {
                this.f6425a = dVar;
                this.f6426b = viewGroup;
                this.f6427c = view;
                this.f6428d = aVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(ViewGroup viewGroup, View view, a aVar) {
                e4.k.e(viewGroup, "$container");
                e4.k.e(aVar, "this$0");
                viewGroup.endViewTransition(view);
                aVar.h().a().f(aVar);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                e4.k.e(animation, "animation");
                final ViewGroup viewGroup = this.f6426b;
                final View view = this.f6427c;
                final a aVar = this.f6428d;
                viewGroup.post(new Runnable() { // from class: o.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.a.animation.Animation$AnimationListenerC0101a.b(viewGroup, view, aVar);
                    }
                });
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.f6425a + " has ended.");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                e4.k.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                e4.k.e(animation, "animation");
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.f6425a + " has reached onAnimationStart.");
                }
            }
        }

        public a(b bVar) {
            e4.k.e(bVar, "animationInfo");
            this.f6424d = bVar;
        }

        @Override // o.b1.b
        public void c(ViewGroup viewGroup) {
            e4.k.e(viewGroup, "container");
            b1.d a5 = this.f6424d.a();
            View view = a5.i().N;
            view.clearAnimation();
            viewGroup.endViewTransition(view);
            this.f6424d.a().f(this);
            if (l0.I0(2)) {
                Log.v("FragmentManager", "Animation from operation " + a5 + " has been cancelled.");
            }
        }

        @Override // o.b1.b
        public void d(ViewGroup viewGroup) {
            e4.k.e(viewGroup, "container");
            if (this.f6424d.b()) {
                this.f6424d.a().f(this);
                return;
            }
            Context context = viewGroup.getContext();
            b1.d a5 = this.f6424d.a();
            View view = a5.i().N;
            b bVar = this.f6424d;
            e4.k.d(context, "context");
            y.a c5 = bVar.c(context);
            if (c5 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Animation animation = c5.f6724a;
            if (animation == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            if (a5.h() != b1.d.b.REMOVED) {
                view.startAnimation(animation);
                this.f6424d.a().f(this);
                return;
            }
            viewGroup.startViewTransition(view);
            y.b bVar2 = new y.b(animation, viewGroup, view);
            bVar2.setAnimationListener(new animation.Animation$AnimationListenerC0101a(a5, viewGroup, view, this));
            view.startAnimation(bVar2);
            if (l0.I0(2)) {
                Log.v("FragmentManager", "Animation from operation " + a5 + " has started.");
            }
        }

        public final b h() {
            return this.f6424d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends C0102f {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f6429b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6430c;

        /* renamed from: d  reason: collision with root package name */
        private y.a f6431d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b1.d dVar, boolean z4) {
            super(dVar);
            e4.k.e(dVar, "operation");
            this.f6429b = z4;
        }

        public final y.a c(Context context) {
            e4.k.e(context, "context");
            if (this.f6430c) {
                return this.f6431d;
            }
            y.a b5 = y.b(context, a().i(), a().h() == b1.d.b.VISIBLE, this.f6429b);
            this.f6431d = b5;
            this.f6430c = true;
            return b5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends b1.b {

        /* renamed from: d  reason: collision with root package name */
        private final b f6432d;

        /* renamed from: e  reason: collision with root package name */
        private AnimatorSet f6433e;

        /* loaded from: classes.dex */
        public static final class a extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewGroup f6434a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f6435b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f6436c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ b1.d f6437d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ c f6438e;

            a(ViewGroup viewGroup, View view, boolean z4, b1.d dVar, c cVar) {
                this.f6434a = viewGroup;
                this.f6435b = view;
                this.f6436c = z4;
                this.f6437d = dVar;
                this.f6438e = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e4.k.e(animator, "anim");
                this.f6434a.endViewTransition(this.f6435b);
                if (this.f6436c) {
                    b1.d.b h5 = this.f6437d.h();
                    View view = this.f6435b;
                    e4.k.d(view, "viewToAnimate");
                    h5.c(view, this.f6434a);
                }
                this.f6438e.h().a().f(this.f6438e);
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "Animator from operation " + this.f6437d + " has ended.");
                }
            }
        }

        public c(b bVar) {
            e4.k.e(bVar, "animatorInfo");
            this.f6432d = bVar;
        }

        @Override // o.b1.b
        public boolean b() {
            return true;
        }

        @Override // o.b1.b
        public void c(ViewGroup viewGroup) {
            e4.k.e(viewGroup, "container");
            AnimatorSet animatorSet = this.f6433e;
            if (animatorSet == null) {
                this.f6432d.a().f(this);
                return;
            }
            b1.d a5 = this.f6432d.a();
            if (!a5.n()) {
                animatorSet.end();
            } else if (Build.VERSION.SDK_INT >= 26) {
                e.f6440a.a(animatorSet);
            }
            if (l0.I0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Animator from operation ");
                sb.append(a5);
                sb.append(" has been canceled");
                sb.append(a5.n() ? " with seeking." : ".");
                sb.append(' ');
                Log.v("FragmentManager", sb.toString());
            }
        }

        @Override // o.b1.b
        public void d(ViewGroup viewGroup) {
            e4.k.e(viewGroup, "container");
            b1.d a5 = this.f6432d.a();
            AnimatorSet animatorSet = this.f6433e;
            if (animatorSet == null) {
                this.f6432d.a().f(this);
                return;
            }
            animatorSet.start();
            if (l0.I0(2)) {
                Log.v("FragmentManager", "Animator from operation " + a5 + " has started.");
            }
        }

        @Override // o.b1.b
        public void e(androidx.activity.b bVar, ViewGroup viewGroup) {
            e4.k.e(bVar, "backEvent");
            e4.k.e(viewGroup, "container");
            b1.d a5 = this.f6432d.a();
            AnimatorSet animatorSet = this.f6433e;
            if (animatorSet == null) {
                this.f6432d.a().f(this);
            } else if (Build.VERSION.SDK_INT < 34 || !a5.i().f6617r) {
            } else {
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + a5);
                }
                long a6 = d.f6439a.a(animatorSet);
                long a7 = bVar.a() * ((float) a6);
                if (a7 == 0) {
                    a7 = 1;
                }
                if (a7 == a6) {
                    a7 = a6 - 1;
                }
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "Setting currentPlayTime to " + a7 + " for Animator " + animatorSet + " on operation " + a5);
                }
                e.f6440a.b(animatorSet, a7);
            }
        }

        @Override // o.b1.b
        public void f(ViewGroup viewGroup) {
            e4.k.e(viewGroup, "container");
            if (this.f6432d.b()) {
                return;
            }
            Context context = viewGroup.getContext();
            b bVar = this.f6432d;
            e4.k.d(context, "context");
            y.a c5 = bVar.c(context);
            this.f6433e = c5 != null ? c5.f6725b : null;
            b1.d a5 = this.f6432d.a();
            s i5 = a5.i();
            boolean z4 = a5.h() == b1.d.b.GONE;
            View view = i5.N;
            viewGroup.startViewTransition(view);
            AnimatorSet animatorSet = this.f6433e;
            if (animatorSet != null) {
                animatorSet.addListener(new a(viewGroup, view, z4, a5, this));
            }
            AnimatorSet animatorSet2 = this.f6433e;
            if (animatorSet2 != null) {
                animatorSet2.setTarget(view);
            }
        }

        public final b h() {
            return this.f6432d;
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final d f6439a = new d();

        private d() {
        }

        public final long a(AnimatorSet animatorSet) {
            long totalDuration;
            e4.k.e(animatorSet, "animatorSet");
            totalDuration = animatorSet.getTotalDuration();
            return totalDuration;
        }
    }

    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final e f6440a = new e();

        private e() {
        }

        public final void a(AnimatorSet animatorSet) {
            e4.k.e(animatorSet, "animatorSet");
            animatorSet.reverse();
        }

        public final void b(AnimatorSet animatorSet, long j5) {
            e4.k.e(animatorSet, "animatorSet");
            animatorSet.setCurrentPlayTime(j5);
        }
    }

    /* renamed from: o.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0102f {

        /* renamed from: a  reason: collision with root package name */
        private final b1.d f6441a;

        public C0102f(b1.d dVar) {
            e4.k.e(dVar, "operation");
            this.f6441a = dVar;
        }

        public final b1.d a() {
            return this.f6441a;
        }

        public final boolean b() {
            b1.d.b bVar;
            View view = this.f6441a.i().N;
            b1.d.b a5 = view != null ? b1.d.b.f6399a.a(view) : null;
            b1.d.b h5 = this.f6441a.h();
            return a5 == h5 || !(a5 == (bVar = b1.d.b.VISIBLE) || h5 == bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g extends b1.b {

        /* renamed from: d  reason: collision with root package name */
        private final List<h> f6442d;

        /* renamed from: e  reason: collision with root package name */
        private final b1.d f6443e;

        /* renamed from: f  reason: collision with root package name */
        private final b1.d f6444f;

        /* renamed from: g  reason: collision with root package name */
        private final w0 f6445g;

        /* renamed from: h  reason: collision with root package name */
        private final Object f6446h;

        /* renamed from: i  reason: collision with root package name */
        private final ArrayList<View> f6447i;

        /* renamed from: j  reason: collision with root package name */
        private final ArrayList<View> f6448j;

        /* renamed from: k  reason: collision with root package name */
        private final androidx.collection.a<String, String> f6449k;

        /* renamed from: l  reason: collision with root package name */
        private final ArrayList<String> f6450l;

        /* renamed from: m  reason: collision with root package name */
        private final ArrayList<String> f6451m;

        /* renamed from: n  reason: collision with root package name */
        private final androidx.collection.a<String, View> f6452n;

        /* renamed from: o  reason: collision with root package name */
        private final androidx.collection.a<String, View> f6453o;

        /* renamed from: p  reason: collision with root package name */
        private final boolean f6454p;

        /* renamed from: q  reason: collision with root package name */
        private final androidx.core.os.c f6455q;

        /* renamed from: r  reason: collision with root package name */
        private Object f6456r;

        /* loaded from: classes.dex */
        static final class a extends e4.l implements d4.a<s3.t> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewGroup f6458b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Object f6459c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ViewGroup viewGroup, Object obj) {
                super(0);
                this.f6458b = viewGroup;
                this.f6459c = obj;
            }

            public final void a() {
                g.this.v().e(this.f6458b, this.f6459c);
            }

            @Override // d4.a
            public /* bridge */ /* synthetic */ s3.t b() {
                a();
                return s3.t.f7573a;
            }
        }

        /* loaded from: classes.dex */
        static final class b extends e4.l implements d4.a<s3.t> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewGroup f6461b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Object f6462c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ e4.r<d4.a<s3.t>> f6463d;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes.dex */
            public static final class a extends e4.l implements d4.a<s3.t> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ g f6464a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ ViewGroup f6465b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(g gVar, ViewGroup viewGroup) {
                    super(0);
                    this.f6464a = gVar;
                    this.f6465b = viewGroup;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void e(g gVar, ViewGroup viewGroup) {
                    e4.k.e(gVar, "this$0");
                    e4.k.e(viewGroup, "$container");
                    for (h hVar : gVar.w()) {
                        b1.d a5 = hVar.a();
                        View U = a5.i().U();
                        if (U != null) {
                            a5.h().c(U, viewGroup);
                        }
                    }
                }

                @Override // d4.a
                public /* bridge */ /* synthetic */ s3.t b() {
                    c();
                    return s3.t.f7573a;
                }

                public final void c() {
                    if (l0.I0(2)) {
                        Log.v("FragmentManager", "Animating to start");
                    }
                    w0 v5 = this.f6464a.v();
                    Object s5 = this.f6464a.s();
                    e4.k.b(s5);
                    final g gVar = this.f6464a;
                    final ViewGroup viewGroup = this.f6465b;
                    v5.d(s5, new Runnable() { // from class: o.p
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.b.a.e(f.g.this, viewGroup);
                        }
                    });
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(ViewGroup viewGroup, Object obj, e4.r<d4.a<s3.t>> rVar) {
                super(0);
                this.f6461b = viewGroup;
                this.f6462c = obj;
                this.f6463d = rVar;
            }

            /* JADX WARN: Type inference failed for: r1v6, types: [T, o.f$g$b$a] */
            public final void a() {
                g gVar = g.this;
                gVar.C(gVar.v().j(this.f6461b, this.f6462c));
                boolean z4 = g.this.s() != null;
                Object obj = this.f6462c;
                ViewGroup viewGroup = this.f6461b;
                if (!z4) {
                    throw new IllegalStateException(("Unable to start transition " + obj + " for container " + viewGroup + '.').toString());
                }
                this.f6463d.f2939a = new a(g.this, viewGroup);
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "Started executing operations from " + g.this.t() + " to " + g.this.u());
                }
            }

            @Override // d4.a
            public /* bridge */ /* synthetic */ s3.t b() {
                a();
                return s3.t.f7573a;
            }
        }

        public g(List<h> list, b1.d dVar, b1.d dVar2, w0 w0Var, Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2, androidx.collection.a<String, String> aVar, ArrayList<String> arrayList3, ArrayList<String> arrayList4, androidx.collection.a<String, View> aVar2, androidx.collection.a<String, View> aVar3, boolean z4) {
            e4.k.e(list, "transitionInfos");
            e4.k.e(w0Var, "transitionImpl");
            e4.k.e(arrayList, "sharedElementFirstOutViews");
            e4.k.e(arrayList2, "sharedElementLastInViews");
            e4.k.e(aVar, "sharedElementNameMapping");
            e4.k.e(arrayList3, "enteringNames");
            e4.k.e(arrayList4, "exitingNames");
            e4.k.e(aVar2, "firstOutViews");
            e4.k.e(aVar3, "lastInViews");
            this.f6442d = list;
            this.f6443e = dVar;
            this.f6444f = dVar2;
            this.f6445g = w0Var;
            this.f6446h = obj;
            this.f6447i = arrayList;
            this.f6448j = arrayList2;
            this.f6449k = aVar;
            this.f6450l = arrayList3;
            this.f6451m = arrayList4;
            this.f6452n = aVar2;
            this.f6453o = aVar3;
            this.f6454p = z4;
            this.f6455q = new androidx.core.os.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void A(b1.d dVar, g gVar) {
            e4.k.e(dVar, "$operation");
            e4.k.e(gVar, "this$0");
            if (l0.I0(2)) {
                Log.v("FragmentManager", "Transition for operation " + dVar + " has completed");
            }
            dVar.f(gVar);
        }

        private final void B(ArrayList<View> arrayList, ViewGroup viewGroup, d4.a<s3.t> aVar) {
            u0.e(arrayList, 4);
            ArrayList<String> q5 = this.f6445g.q(this.f6448j);
            if (l0.I0(2)) {
                Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
                Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
                Iterator<View> it = this.f6447i.iterator();
                while (it.hasNext()) {
                    View next = it.next();
                    e4.k.d(next, "sharedElementFirstOutViews");
                    View view = next;
                    Log.v("FragmentManager", "View: " + view + " Name: " + androidx.core.view.l.f(view));
                }
                Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
                Iterator<View> it2 = this.f6448j.iterator();
                while (it2.hasNext()) {
                    View next2 = it2.next();
                    e4.k.d(next2, "sharedElementLastInViews");
                    View view2 = next2;
                    Log.v("FragmentManager", "View: " + view2 + " Name: " + androidx.core.view.l.f(view2));
                }
            }
            aVar.b();
            this.f6445g.y(viewGroup, this.f6447i, this.f6448j, q5, this.f6449k);
            u0.e(arrayList, 0);
            this.f6445g.A(this.f6446h, this.f6447i, this.f6448j);
        }

        private final void n(ArrayList<View> arrayList, View view) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (!androidx.core.view.b0.a(viewGroup)) {
                    int childCount = viewGroup.getChildCount();
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = viewGroup.getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            e4.k.d(childAt, "child");
                            n(arrayList, childAt);
                        }
                    }
                    return;
                } else if (arrayList.contains(view)) {
                    return;
                }
            } else if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
        }

        private final s3.l<ArrayList<View>, Object> o(ViewGroup viewGroup, b1.d dVar, final b1.d dVar2) {
            Set L;
            final b1.d dVar3 = dVar;
            View view = new View(viewGroup.getContext());
            final Rect rect = new Rect();
            View view2 = null;
            boolean z4 = false;
            for (h hVar : this.f6442d) {
                if (hVar.g() && dVar2 != null && dVar3 != null && (!this.f6449k.isEmpty()) && this.f6446h != null) {
                    u0.a(dVar.i(), dVar2.i(), this.f6454p, this.f6452n, true);
                    androidx.core.view.i.a(viewGroup, new Runnable() { // from class: o.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.p(b1.d.this, dVar2, this);
                        }
                    });
                    this.f6447i.addAll(this.f6452n.values());
                    if (!this.f6451m.isEmpty()) {
                        String str = this.f6451m.get(0);
                        e4.k.d(str, "exitingNames[0]");
                        view2 = this.f6452n.get(str);
                        this.f6445g.v(this.f6446h, view2);
                    }
                    this.f6448j.addAll(this.f6453o.values());
                    if (!this.f6450l.isEmpty()) {
                        String str2 = this.f6450l.get(0);
                        e4.k.d(str2, "enteringNames[0]");
                        final View view3 = this.f6453o.get(str2);
                        if (view3 != null) {
                            final w0 w0Var = this.f6445g;
                            androidx.core.view.i.a(viewGroup, new Runnable() { // from class: o.n
                                @Override // java.lang.Runnable
                                public final void run() {
                                    f.g.q(w0.this, view3, rect);
                                }
                            });
                            z4 = true;
                        }
                    }
                    this.f6445g.z(this.f6446h, view, this.f6447i);
                    w0 w0Var2 = this.f6445g;
                    Object obj = this.f6446h;
                    w0Var2.s(obj, null, null, null, null, obj, this.f6448j);
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator<h> it = this.f6442d.iterator();
            Object obj2 = null;
            Object obj3 = null;
            while (it.hasNext()) {
                h next = it.next();
                b1.d a5 = next.a();
                Iterator<h> it2 = it;
                Object h5 = this.f6445g.h(next.f());
                if (h5 != null) {
                    final ArrayList<View> arrayList2 = new ArrayList<>();
                    Object obj4 = obj3;
                    View view4 = a5.i().N;
                    Object obj5 = obj2;
                    e4.k.d(view4, "operation.fragment.mView");
                    n(arrayList2, view4);
                    if (this.f6446h != null && (a5 == dVar2 || a5 == dVar3)) {
                        L = t3.x.L(a5 == dVar2 ? this.f6447i : this.f6448j);
                        arrayList2.removeAll(L);
                    }
                    if (arrayList2.isEmpty()) {
                        this.f6445g.a(h5, view);
                    } else {
                        this.f6445g.b(h5, arrayList2);
                        this.f6445g.s(h5, h5, arrayList2, null, null, null, null);
                        if (a5.h() == b1.d.b.GONE) {
                            a5.r(false);
                            ArrayList<View> arrayList3 = new ArrayList<>(arrayList2);
                            arrayList3.remove(a5.i().N);
                            this.f6445g.r(h5, a5.i().N, arrayList3);
                            androidx.core.view.i.a(viewGroup, new Runnable() { // from class: o.o
                                @Override // java.lang.Runnable
                                public final void run() {
                                    f.g.r(arrayList2);
                                }
                            });
                        }
                    }
                    if (a5.h() == b1.d.b.VISIBLE) {
                        arrayList.addAll(arrayList2);
                        if (z4) {
                            this.f6445g.u(h5, rect);
                        }
                        if (l0.I0(2)) {
                            Log.v("FragmentManager", "Entering Transition: " + h5);
                            Log.v("FragmentManager", ">>>>> EnteringViews <<<<<");
                            Iterator<View> it3 = arrayList2.iterator();
                            while (it3.hasNext()) {
                                View next2 = it3.next();
                                e4.k.d(next2, "transitioningViews");
                                Log.v("FragmentManager", "View: " + next2);
                            }
                        }
                    } else {
                        this.f6445g.v(h5, view2);
                        if (l0.I0(2)) {
                            Log.v("FragmentManager", "Exiting Transition: " + h5);
                            Log.v("FragmentManager", ">>>>> ExitingViews <<<<<");
                            Iterator<View> it4 = arrayList2.iterator();
                            while (it4.hasNext()) {
                                View next3 = it4.next();
                                e4.k.d(next3, "transitioningViews");
                                Log.v("FragmentManager", "View: " + next3);
                            }
                        }
                    }
                    if (next.h()) {
                        obj2 = this.f6445g.p(obj5, h5, null);
                        dVar3 = dVar;
                        it = it2;
                        obj3 = obj4;
                    } else {
                        obj3 = this.f6445g.p(obj4, h5, null);
                        dVar3 = dVar;
                        obj2 = obj5;
                        it = it2;
                    }
                } else {
                    dVar3 = dVar;
                    it = it2;
                    obj2 = obj2;
                }
            }
            Object o5 = this.f6445g.o(obj2, obj3, this.f6446h);
            if (l0.I0(2)) {
                Log.v("FragmentManager", "Final merged transition: " + o5);
            }
            return new s3.l<>(arrayList, o5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(b1.d dVar, b1.d dVar2, g gVar) {
            e4.k.e(gVar, "this$0");
            u0.a(dVar.i(), dVar2.i(), gVar.f6454p, gVar.f6453o, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(w0 w0Var, View view, Rect rect) {
            e4.k.e(w0Var, "$impl");
            e4.k.e(rect, "$lastInEpicenterRect");
            w0Var.k(view, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(ArrayList arrayList) {
            e4.k.e(arrayList, "$transitioningViews");
            u0.e(arrayList, 4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(b1.d dVar, g gVar) {
            e4.k.e(dVar, "$operation");
            e4.k.e(gVar, "this$0");
            if (l0.I0(2)) {
                Log.v("FragmentManager", "Transition for operation " + dVar + " has completed");
            }
            dVar.f(gVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(e4.r rVar) {
            e4.k.e(rVar, "$seekCancelLambda");
            d4.a aVar = (d4.a) rVar.f2939a;
            if (aVar != null) {
                aVar.b();
            }
        }

        public final void C(Object obj) {
            this.f6456r = obj;
        }

        @Override // o.b1.b
        public boolean b() {
            boolean z4;
            boolean z5;
            if (this.f6445g.m()) {
                List<h> list = this.f6442d;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    for (h hVar : list) {
                        if (Build.VERSION.SDK_INT < 34 || hVar.f() == null || !this.f6445g.n(hVar.f())) {
                            z4 = false;
                            continue;
                        } else {
                            z4 = true;
                            continue;
                        }
                        if (!z4) {
                            z5 = false;
                            break;
                        }
                    }
                }
                z5 = true;
                if (z5) {
                    Object obj = this.f6446h;
                    return obj == null || this.f6445g.n(obj);
                }
                return false;
            }
            return false;
        }

        @Override // o.b1.b
        public void c(ViewGroup viewGroup) {
            e4.k.e(viewGroup, "container");
            this.f6455q.a();
        }

        @Override // o.b1.b
        public void d(ViewGroup viewGroup) {
            int k5;
            StringBuilder sb;
            String str;
            e4.k.e(viewGroup, "container");
            if (!viewGroup.isLaidOut()) {
                for (h hVar : this.f6442d) {
                    b1.d a5 = hVar.a();
                    if (l0.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + viewGroup + " has not been laid out. Completing operation " + a5);
                    }
                    hVar.a().f(this);
                }
                return;
            }
            Object obj = this.f6456r;
            if (obj != null) {
                w0 w0Var = this.f6445g;
                e4.k.b(obj);
                w0Var.c(obj);
                if (!l0.I0(2)) {
                    return;
                }
                sb = new StringBuilder();
                str = "Ending execution of operations from ";
            } else {
                s3.l<ArrayList<View>, Object> o5 = o(viewGroup, this.f6444f, this.f6443e);
                ArrayList<View> a6 = o5.a();
                Object b5 = o5.b();
                List<h> list = this.f6442d;
                k5 = t3.q.k(list, 10);
                ArrayList<b1.d> arrayList = new ArrayList(k5);
                for (h hVar2 : list) {
                    arrayList.add(hVar2.a());
                }
                for (final b1.d dVar : arrayList) {
                    this.f6445g.w(dVar.i(), b5, this.f6455q, new Runnable() { // from class: o.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.y(b1.d.this, this);
                        }
                    });
                }
                B(a6, viewGroup, new a(viewGroup, b5));
                if (!l0.I0(2)) {
                    return;
                }
                sb = new StringBuilder();
                str = "Completed executing operations from ";
            }
            sb.append(str);
            sb.append(this.f6443e);
            sb.append(" to ");
            sb.append(this.f6444f);
            Log.v("FragmentManager", sb.toString());
        }

        @Override // o.b1.b
        public void e(androidx.activity.b bVar, ViewGroup viewGroup) {
            e4.k.e(bVar, "backEvent");
            e4.k.e(viewGroup, "container");
            Object obj = this.f6456r;
            if (obj != null) {
                this.f6445g.t(obj, bVar.a());
            }
        }

        @Override // o.b1.b
        public void f(ViewGroup viewGroup) {
            int k5;
            e4.k.e(viewGroup, "container");
            if (!viewGroup.isLaidOut()) {
                for (h hVar : this.f6442d) {
                    b1.d a5 = hVar.a();
                    if (l0.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + viewGroup + " has not been laid out. Skipping onStart for operation " + a5);
                    }
                }
                return;
            }
            if (x() && this.f6446h != null && !b()) {
                Log.i("FragmentManager", "Ignoring shared elements transition " + this.f6446h + " between " + this.f6443e + " and " + this.f6444f + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
            }
            if (b() && x()) {
                final e4.r rVar = new e4.r();
                s3.l<ArrayList<View>, Object> o5 = o(viewGroup, this.f6444f, this.f6443e);
                ArrayList<View> a6 = o5.a();
                Object b5 = o5.b();
                List<h> list = this.f6442d;
                k5 = t3.q.k(list, 10);
                ArrayList<b1.d> arrayList = new ArrayList(k5);
                for (h hVar2 : list) {
                    arrayList.add(hVar2.a());
                }
                for (final b1.d dVar : arrayList) {
                    this.f6445g.x(dVar.i(), b5, this.f6455q, new Runnable() { // from class: o.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.z(e4.r.this);
                        }
                    }, new Runnable() { // from class: o.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.A(b1.d.this, this);
                        }
                    });
                }
                B(a6, viewGroup, new b(viewGroup, b5, rVar));
            }
        }

        public final Object s() {
            return this.f6456r;
        }

        public final b1.d t() {
            return this.f6443e;
        }

        public final b1.d u() {
            return this.f6444f;
        }

        public final w0 v() {
            return this.f6445g;
        }

        public final List<h> w() {
            return this.f6442d;
        }

        public final boolean x() {
            List<h> list = this.f6442d;
            if ((list instanceof Collection) && list.isEmpty()) {
                return true;
            }
            for (h hVar : list) {
                if (!hVar.a().i().f6617r) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class h extends C0102f {

        /* renamed from: b  reason: collision with root package name */
        private final Object f6466b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f6467c;

        /* renamed from: d  reason: collision with root package name */
        private final Object f6468d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(b1.d dVar, boolean z4, boolean z5) {
            super(dVar);
            Object O;
            boolean z6;
            Object obj;
            e4.k.e(dVar, "operation");
            b1.d.b h5 = dVar.h();
            b1.d.b bVar = b1.d.b.VISIBLE;
            if (h5 == bVar) {
                s i5 = dVar.i();
                O = z4 ? i5.M() : i5.w();
            } else {
                s i6 = dVar.i();
                O = z4 ? i6.O() : i6.z();
            }
            this.f6466b = O;
            if (dVar.h() == bVar) {
                s i7 = dVar.i();
                z6 = z4 ? i7.q() : i7.o();
            } else {
                z6 = true;
            }
            this.f6467c = z6;
            if (z5) {
                s i8 = dVar.i();
                obj = z4 ? i8.Q() : i8.P();
            } else {
                obj = null;
            }
            this.f6468d = obj;
        }

        private final w0 d(Object obj) {
            if (obj == null) {
                return null;
            }
            w0 w0Var = u0.f6690b;
            if (w0Var == null || !w0Var.g(obj)) {
                w0 w0Var2 = u0.f6691c;
                if (w0Var2 == null || !w0Var2.g(obj)) {
                    throw new IllegalArgumentException("Transition " + obj + " for fragment " + a().i() + " is not a valid framework Transition or AndroidX Transition");
                }
                return w0Var2;
            }
            return w0Var;
        }

        public final w0 c() {
            w0 d5 = d(this.f6466b);
            w0 d6 = d(this.f6468d);
            if (d5 == null || d6 == null || d5 == d6) {
                return d5 == null ? d6 : d5;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + a().i() + " returned Transition " + this.f6466b + " which uses a different Transition  type than its shared element transition " + this.f6468d).toString());
        }

        public final Object e() {
            return this.f6468d;
        }

        public final Object f() {
            return this.f6466b;
        }

        public final boolean g() {
            return this.f6468d != null;
        }

        public final boolean h() {
            return this.f6467c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class i extends e4.l implements d4.l<Map.Entry<String, View>, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Collection<String> f6469a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Collection<String> collection) {
            super(1);
            this.f6469a = collection;
        }

        @Override // d4.l
        /* renamed from: a */
        public final Boolean invoke(Map.Entry<String, View> entry) {
            boolean o5;
            e4.k.e(entry, "entry");
            o5 = t3.x.o(this.f6469a, androidx.core.view.l.f(entry.getValue()));
            return Boolean.valueOf(o5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ViewGroup viewGroup) {
        super(viewGroup);
        e4.k.e(viewGroup, "container");
    }

    private final void D(List<b> list) {
        StringBuilder sb;
        String str;
        ArrayList<b> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (b bVar : list) {
            t3.u.l(arrayList2, bVar.a().g());
        }
        boolean z4 = !arrayList2.isEmpty();
        boolean z5 = false;
        for (b bVar2 : list) {
            Context context = t().getContext();
            b1.d a5 = bVar2.a();
            e4.k.d(context, "context");
            y.a c5 = bVar2.c(context);
            if (c5 != null) {
                if (c5.f6725b == null) {
                    arrayList.add(bVar2);
                } else {
                    s i5 = a5.i();
                    if (!(!a5.g().isEmpty())) {
                        if (a5.h() == b1.d.b.GONE) {
                            a5.r(false);
                        }
                        a5.b(new c(bVar2));
                        z5 = true;
                    } else if (l0.I0(2)) {
                        Log.v("FragmentManager", "Ignoring Animator set on " + i5 + " as this Fragment was involved in a Transition.");
                    }
                }
            }
        }
        for (b bVar3 : arrayList) {
            b1.d a6 = bVar3.a();
            s i6 = a6.i();
            if (z4) {
                if (l0.I0(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(i6);
                    str = " as Animations cannot run alongside Transitions.";
                    sb.append(str);
                    Log.v("FragmentManager", sb.toString());
                }
            } else if (!z5) {
                a6.b(new a(bVar3));
            } else if (l0.I0(2)) {
                sb = new StringBuilder();
                sb.append("Ignoring Animation set on ");
                sb.append(i6);
                str = " as Animations cannot run alongside Animators.";
                sb.append(str);
                Log.v("FragmentManager", sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(f fVar, b1.d dVar) {
        e4.k.e(fVar, "this$0");
        e4.k.e(dVar, "$operation");
        fVar.c(dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F(List<h> list, boolean z4, b1.d dVar, b1.d dVar2) {
        Object obj;
        boolean z5;
        boolean z6;
        w0 w0Var;
        ArrayList arrayList;
        ArrayList arrayList2;
        Iterator it;
        ArrayList arrayList3;
        ArrayList<String> R;
        ArrayList<String> S;
        androidx.core.app.c1 x4;
        androidx.core.app.c1 A;
        Object obj2;
        String b5;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : list) {
            if (!((h) obj3).b()) {
                arrayList4.add(obj3);
            }
        }
        ArrayList<h> arrayList5 = new ArrayList();
        for (Object obj4 : arrayList4) {
            if (((h) obj4).c() != null) {
                arrayList5.add(obj4);
            }
        }
        w0 w0Var2 = null;
        for (h hVar : arrayList5) {
            w0 c5 = hVar.c();
            if (!(w0Var2 == null || c5 == w0Var2)) {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + hVar.a().i() + " returned Transition " + hVar.f() + " which uses a different Transition type than other Fragments.").toString());
            }
            w0Var2 = c5;
        }
        if (w0Var2 == null) {
            return;
        }
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        androidx.collection.a aVar = new androidx.collection.a();
        ArrayList<String> arrayList8 = new ArrayList<>();
        ArrayList<String> arrayList9 = new ArrayList<>();
        androidx.collection.a<String, View> aVar2 = new androidx.collection.a<>();
        androidx.collection.a<String, View> aVar3 = new androidx.collection.a<>();
        Iterator it2 = arrayList5.iterator();
        ArrayList<String> arrayList10 = arrayList8;
        ArrayList<String> arrayList11 = arrayList9;
        loop3: while (true) {
            obj = null;
            while (it2.hasNext()) {
                h hVar2 = (h) it2.next();
                if (!hVar2.g() || dVar == null || dVar2 == null) {
                    w0Var = w0Var2;
                    arrayList = arrayList6;
                    arrayList2 = arrayList7;
                    it = it2;
                    arrayList3 = arrayList5;
                } else {
                    Object B = w0Var2.B(w0Var2.h(hVar2.e()));
                    R = dVar2.i().R();
                    e4.k.d(R, "lastIn.fragment.sharedElementSourceNames");
                    ArrayList<String> R2 = dVar.i().R();
                    e4.k.d(R2, "firstOut.fragment.sharedElementSourceNames");
                    ArrayList<String> S2 = dVar.i().S();
                    e4.k.d(S2, "firstOut.fragment.sharedElementTargetNames");
                    int size = S2.size();
                    w0Var = w0Var2;
                    it = it2;
                    int i5 = 0;
                    while (i5 < size) {
                        int i6 = size;
                        int indexOf = R.indexOf(S2.get(i5));
                        if (indexOf != -1) {
                            R.set(indexOf, R2.get(i5));
                        }
                        i5++;
                        size = i6;
                    }
                    S = dVar2.i().S();
                    e4.k.d(S, "lastIn.fragment.sharedElementTargetNames");
                    s i7 = dVar.i();
                    if (z4) {
                        x4 = i7.x();
                        A = dVar2.i().A();
                    } else {
                        x4 = i7.A();
                        A = dVar2.i().x();
                    }
                    s3.l a5 = s3.p.a(x4, A);
                    androidx.core.app.c1 c1Var = (androidx.core.app.c1) a5.a();
                    androidx.core.app.c1 c1Var2 = (androidx.core.app.c1) a5.b();
                    int size2 = R.size();
                    arrayList3 = arrayList5;
                    int i8 = 0;
                    while (true) {
                        arrayList2 = arrayList7;
                        if (i8 >= size2) {
                            break;
                        }
                        int i9 = size2;
                        String str = R.get(i8);
                        e4.k.d(str, "exitingNames[i]");
                        String str2 = S.get(i8);
                        e4.k.d(str2, "enteringNames[i]");
                        aVar.put(str, str2);
                        i8++;
                        size2 = i9;
                        arrayList7 = arrayList2;
                    }
                    if (l0.I0(2)) {
                        Log.v("FragmentManager", ">>> entering view names <<<");
                        Iterator<String> it3 = S.iterator();
                        while (true) {
                            arrayList = arrayList6;
                            if (!it3.hasNext()) {
                                break;
                            }
                            Iterator<String> it4 = it3;
                            Log.v("FragmentManager", "Name: " + it3.next());
                            B = B;
                            arrayList6 = arrayList;
                            it3 = it4;
                        }
                        obj2 = B;
                        Log.v("FragmentManager", ">>> exiting view names <<<");
                        for (Iterator<String> it5 = R.iterator(); it5.hasNext(); it5 = it5) {
                            Log.v("FragmentManager", "Name: " + it5.next());
                        }
                    } else {
                        arrayList = arrayList6;
                        obj2 = B;
                    }
                    View view = dVar.i().N;
                    e4.k.d(view, "firstOut.fragment.mView");
                    G(aVar2, view);
                    aVar2.n(R);
                    if (c1Var != null) {
                        if (l0.I0(2)) {
                            Log.v("FragmentManager", "Executing exit callback for operation " + dVar);
                        }
                        c1Var.a(R, aVar2);
                        int size3 = R.size() - 1;
                        if (size3 >= 0) {
                            while (true) {
                                int i10 = size3 - 1;
                                String str3 = R.get(size3);
                                e4.k.d(str3, "exitingNames[i]");
                                String str4 = str3;
                                View view2 = aVar2.get(str4);
                                if (view2 == null) {
                                    aVar.remove(str4);
                                } else if (!e4.k.a(str4, androidx.core.view.l.f(view2))) {
                                    aVar.put(androidx.core.view.l.f(view2), (String) aVar.remove(str4));
                                }
                                if (i10 < 0) {
                                    break;
                                }
                                size3 = i10;
                            }
                        }
                    } else {
                        aVar.n(aVar2.keySet());
                    }
                    View view3 = dVar2.i().N;
                    e4.k.d(view3, "lastIn.fragment.mView");
                    G(aVar3, view3);
                    aVar3.n(S);
                    aVar3.n(aVar.values());
                    if (c1Var2 != null) {
                        if (l0.I0(2)) {
                            Log.v("FragmentManager", "Executing enter callback for operation " + dVar2);
                        }
                        c1Var2.a(S, aVar3);
                        int size4 = S.size() - 1;
                        if (size4 >= 0) {
                            while (true) {
                                int i11 = size4 - 1;
                                String str5 = S.get(size4);
                                e4.k.d(str5, "enteringNames[i]");
                                String str6 = str5;
                                View view4 = aVar3.get(str6);
                                if (view4 == null) {
                                    String b6 = u0.b(aVar, str6);
                                    if (b6 != null) {
                                        aVar.remove(b6);
                                    }
                                } else if (!e4.k.a(str6, androidx.core.view.l.f(view4)) && (b5 = u0.b(aVar, str6)) != null) {
                                    aVar.put(b5, androidx.core.view.l.f(view4));
                                }
                                if (i11 < 0) {
                                    break;
                                }
                                size4 = i11;
                            }
                        }
                    } else {
                        u0.d(aVar, aVar3);
                    }
                    Collection<String> keySet = aVar.keySet();
                    e4.k.d(keySet, "sharedElementNameMapping.keys");
                    H(aVar2, keySet);
                    Collection<String> values = aVar.values();
                    e4.k.d(values, "sharedElementNameMapping.values");
                    H(aVar3, values);
                    if (aVar.isEmpty()) {
                        break;
                    }
                    arrayList11 = R;
                    arrayList10 = S;
                    obj = obj2;
                }
                it2 = it;
                w0Var2 = w0Var;
                arrayList5 = arrayList3;
                arrayList7 = arrayList2;
                arrayList6 = arrayList;
            }
            Log.i("FragmentManager", "Ignoring shared elements transition " + obj2 + " between " + dVar + " and " + dVar2 + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
            arrayList.clear();
            arrayList2.clear();
            arrayList11 = R;
            arrayList10 = S;
            it2 = it;
            w0Var2 = w0Var;
            arrayList5 = arrayList3;
            arrayList7 = arrayList2;
            arrayList6 = arrayList;
        }
        w0 w0Var3 = w0Var2;
        ArrayList arrayList12 = arrayList6;
        ArrayList arrayList13 = arrayList7;
        ArrayList<h> arrayList14 = arrayList5;
        if (obj == null) {
            if (!arrayList14.isEmpty()) {
                for (h hVar3 : arrayList14) {
                    if (hVar3.f() == null) {
                        z5 = true;
                        continue;
                    } else {
                        z5 = false;
                        continue;
                    }
                    if (!z5) {
                        z6 = false;
                        break;
                    }
                }
            }
            z6 = true;
            if (z6) {
                return;
            }
        }
        g gVar = new g(arrayList14, dVar, dVar2, w0Var3, obj, arrayList12, arrayList13, aVar, arrayList10, arrayList11, aVar2, aVar3, z4);
        for (h hVar4 : arrayList14) {
            hVar4.a().b(gVar);
        }
    }

    private final void G(Map<String, View> map, View view) {
        String f5 = androidx.core.view.l.f(view);
        if (f5 != null) {
            map.put(f5, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = viewGroup.getChildAt(i5);
                if (childAt.getVisibility() == 0) {
                    e4.k.d(childAt, "child");
                    G(map, childAt);
                }
            }
        }
    }

    private final void H(androidx.collection.a<String, View> aVar, Collection<String> collection) {
        Set<Map.Entry<String, View>> entrySet = aVar.entrySet();
        e4.k.d(entrySet, "entries");
        t3.u.n(entrySet, new i(collection));
    }

    private final void I(List<? extends b1.d> list) {
        Object x4;
        x4 = t3.x.x(list);
        s i5 = ((b1.d) x4).i();
        for (b1.d dVar : list) {
            dVar.i().Q.f6635c = i5.Q.f6635c;
            dVar.i().Q.f6636d = i5.Q.f6636d;
            dVar.i().Q.f6637e = i5.Q.f6637e;
            dVar.i().Q.f6638f = i5.Q.f6638f;
        }
    }

    @Override // o.b1
    public void d(List<? extends b1.d> list, boolean z4) {
        b1.d dVar;
        Object obj;
        boolean z5;
        boolean z6;
        e4.k.e(list, "operations");
        Iterator<T> it = list.iterator();
        while (true) {
            dVar = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            b1.d dVar2 = (b1.d) obj;
            b1.d.b.a aVar = b1.d.b.f6399a;
            View view = dVar2.i().N;
            e4.k.d(view, "operation.fragment.mView");
            b1.d.b a5 = aVar.a(view);
            b1.d.b bVar = b1.d.b.VISIBLE;
            if (a5 != bVar || dVar2.h() == bVar) {
                z6 = false;
                continue;
            } else {
                z6 = true;
                continue;
            }
            if (z6) {
                break;
            }
        }
        b1.d dVar3 = (b1.d) obj;
        ListIterator<? extends b1.d> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            b1.d previous = listIterator.previous();
            b1.d dVar4 = previous;
            b1.d.b.a aVar2 = b1.d.b.f6399a;
            View view2 = dVar4.i().N;
            e4.k.d(view2, "operation.fragment.mView");
            b1.d.b a6 = aVar2.a(view2);
            b1.d.b bVar2 = b1.d.b.VISIBLE;
            if (a6 == bVar2 || dVar4.h() != bVar2) {
                z5 = false;
                continue;
            } else {
                z5 = true;
                continue;
            }
            if (z5) {
                dVar = previous;
                break;
            }
        }
        b1.d dVar5 = dVar;
        if (l0.I0(2)) {
            Log.v("FragmentManager", "Executing operations from " + dVar3 + " to " + dVar5);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        I(list);
        Iterator<? extends b1.d> it2 = list.iterator();
        while (it2.hasNext()) {
            final b1.d next = it2.next();
            arrayList.add(new b(next, z4));
            arrayList2.add(new h(next, z4, !z4 ? next != dVar5 : next != dVar3));
            next.a(new Runnable() { // from class: o.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.E(f.this, next);
                }
            });
        }
        F(arrayList2, z4, dVar3, dVar5);
        D(arrayList);
    }
}
