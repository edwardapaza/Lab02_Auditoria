package o;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
/* loaded from: classes.dex */
class y {

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f6724a;

        /* renamed from: b  reason: collision with root package name */
        public final AnimatorSet f6725b;

        a(Animator animator) {
            this.f6724a = null;
            AnimatorSet animatorSet = new AnimatorSet();
            this.f6725b = animatorSet;
            animatorSet.play(animator);
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        a(Animation animation) {
            this.f6724a = animation;
            this.f6725b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* loaded from: classes.dex */
    static class b extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f6726a;

        /* renamed from: b  reason: collision with root package name */
        private final View f6727b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6728c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6729d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6730e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f6730e = true;
            this.f6726a = viewGroup;
            this.f6727b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j5, Transformation transformation) {
            this.f6730e = true;
            if (this.f6728c) {
                return !this.f6729d;
            }
            if (!super.getTransformation(j5, transformation)) {
                this.f6728c = true;
                androidx.core.view.i.a(this.f6726a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j5, Transformation transformation, float f5) {
            this.f6730e = true;
            if (this.f6728c) {
                return !this.f6729d;
            }
            if (!super.getTransformation(j5, transformation, f5)) {
                this.f6728c = true;
                androidx.core.view.i.a(this.f6726a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6728c || !this.f6730e) {
                this.f6726a.endViewTransition(this.f6727b);
                this.f6729d = true;
                return;
            }
            this.f6730e = false;
            this.f6726a.post(this);
        }
    }

    private static int a(s sVar, boolean z4, boolean z5) {
        return z5 ? z4 ? sVar.J() : sVar.K() : z4 ? sVar.v() : sVar.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b(Context context, s sVar, boolean z4, boolean z5) {
        int F = sVar.F();
        int a5 = a(sVar, z4, z5);
        boolean z6 = false;
        sVar.u1(0, 0, 0, 0);
        ViewGroup viewGroup = sVar.M;
        if (viewGroup != null) {
            int i5 = n.b.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i5) != null) {
                sVar.M.setTag(i5, null);
            }
        }
        ViewGroup viewGroup2 = sVar.M;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation p02 = sVar.p0(F, z4, a5);
            if (p02 != null) {
                return new a(p02);
            }
            Animator q02 = sVar.q0(F, z4, a5);
            if (q02 != null) {
                return new a(q02);
            }
            if (a5 == 0 && F != 0) {
                a5 = d(context, F, z4);
            }
            if (a5 != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(a5));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, a5);
                        if (loadAnimation != null) {
                            return new a(loadAnimation);
                        }
                        z6 = true;
                    } catch (Resources.NotFoundException e5) {
                        throw e5;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z6) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, a5);
                        if (loadAnimator != null) {
                            return new a(loadAnimator);
                        }
                    } catch (RuntimeException e6) {
                        if (equals) {
                            throw e6;
                        }
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, a5);
                        if (loadAnimation2 != null) {
                            return new a(loadAnimation2);
                        }
                    }
                }
            }
            return null;
        }
        return null;
    }

    private static int c(Context context, int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{i5});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int d(Context context, int i5, boolean z4) {
        int i6;
        if (i5 == 4097) {
            return z4 ? n.a.fragment_open_enter : n.a.fragment_open_exit;
        } else if (i5 == 8194) {
            return z4 ? n.a.fragment_close_enter : n.a.fragment_close_exit;
        } else {
            if (i5 == 8197) {
                i6 = z4 ? 16842938 : 16842939;
            } else if (i5 == 4099) {
                return z4 ? n.a.fragment_fade_enter : n.a.fragment_fade_exit;
            } else if (i5 != 4100) {
                return -1;
            } else {
                i6 = z4 ? 16842936 : 16842937;
            }
            return c(context, i6);
        }
    }
}
