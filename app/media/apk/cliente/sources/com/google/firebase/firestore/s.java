package com.google.firebase.firestore;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import s1.k;
import s1.p;
/* loaded from: classes.dex */
public class s {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends s {

        /* renamed from: a  reason: collision with root package name */
        private final List<s> f1769a;

        /* renamed from: b  reason: collision with root package name */
        private final k.a f1770b;

        public a(List<s> list, k.a aVar) {
            this.f1769a = list;
            this.f1770b = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1770b == aVar.f1770b && Objects.equals(this.f1769a, aVar.f1769a);
        }

        public int hashCode() {
            List<s> list = this.f1769a;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            k.a aVar = this.f1770b;
            return hashCode + (aVar != null ? aVar.hashCode() : 0);
        }

        public List<s> m() {
            return this.f1769a;
        }

        public k.a n() {
            return this.f1770b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends s {

        /* renamed from: a  reason: collision with root package name */
        private final q f1771a;

        /* renamed from: b  reason: collision with root package name */
        private final p.b f1772b;

        /* renamed from: c  reason: collision with root package name */
        private final Object f1773c;

        public b(q qVar, p.b bVar, Object obj) {
            this.f1771a = qVar;
            this.f1772b = bVar;
            this.f1773c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1772b == bVar.f1772b && Objects.equals(this.f1771a, bVar.f1771a) && Objects.equals(this.f1773c, bVar.f1773c);
        }

        public int hashCode() {
            q qVar = this.f1771a;
            int hashCode = (qVar != null ? qVar.hashCode() : 0) * 31;
            p.b bVar = this.f1772b;
            int hashCode2 = (hashCode + (bVar != null ? bVar.hashCode() : 0)) * 31;
            Object obj = this.f1773c;
            return hashCode2 + (obj != null ? obj.hashCode() : 0);
        }

        public q m() {
            return this.f1771a;
        }

        public p.b n() {
            return this.f1772b;
        }

        public Object o() {
            return this.f1773c;
        }
    }

    public static s a(s... sVarArr) {
        return new a(Arrays.asList(sVarArr), k.a.AND);
    }

    public static s b(q qVar, Object obj) {
        return new b(qVar, p.b.ARRAY_CONTAINS, obj);
    }

    public static s c(q qVar, List<? extends Object> list) {
        return new b(qVar, p.b.ARRAY_CONTAINS_ANY, list);
    }

    public static s d(q qVar, Object obj) {
        return new b(qVar, p.b.EQUAL, obj);
    }

    public static s e(q qVar, Object obj) {
        return new b(qVar, p.b.GREATER_THAN, obj);
    }

    public static s f(q qVar, Object obj) {
        return new b(qVar, p.b.GREATER_THAN_OR_EQUAL, obj);
    }

    public static s g(q qVar, List<? extends Object> list) {
        return new b(qVar, p.b.IN, list);
    }

    public static s h(q qVar, Object obj) {
        return new b(qVar, p.b.LESS_THAN, obj);
    }

    public static s i(q qVar, Object obj) {
        return new b(qVar, p.b.LESS_THAN_OR_EQUAL, obj);
    }

    public static s j(q qVar, Object obj) {
        return new b(qVar, p.b.NOT_EQUAL, obj);
    }

    public static s k(q qVar, List<? extends Object> list) {
        return new b(qVar, p.b.NOT_IN, list);
    }

    public static s l(s... sVarArr) {
        return new a(Arrays.asList(sVarArr), k.a.OR);
    }
}
