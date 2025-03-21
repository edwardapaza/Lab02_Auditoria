package com.google.firebase.firestore;
/* loaded from: classes.dex */
public class d0 implements Comparable<d0> {

    /* renamed from: a  reason: collision with root package name */
    private final double f1682a;

    /* renamed from: b  reason: collision with root package name */
    private final double f1683b;

    public d0(double d5, double d6) {
        if (Double.isNaN(d5) || d5 < -90.0d || d5 > 90.0d) {
            throw new IllegalArgumentException("Latitude must be in the range of [-90, 90]");
        }
        if (Double.isNaN(d6) || d6 < -180.0d || d6 > 180.0d) {
            throw new IllegalArgumentException("Longitude must be in the range of [-180, 180]");
        }
        this.f1682a = d5;
        this.f1683b = d6;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(d0 d0Var) {
        int k5 = z1.h0.k(this.f1682a, d0Var.f1682a);
        return k5 == 0 ? z1.h0.k(this.f1683b, d0Var.f1683b) : k5;
    }

    public double c() {
        return this.f1682a;
    }

    public double d() {
        return this.f1683b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            return this.f1682a == d0Var.f1682a && this.f1683b == d0Var.f1683b;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f1682a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f1683b);
        return (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "GeoPoint { latitude=" + this.f1682a + ", longitude=" + this.f1683b + " }";
    }
}
