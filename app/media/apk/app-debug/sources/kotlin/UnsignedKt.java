package kotlin;

import io.flutter.embedding.android.KeyboardMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
/* compiled from: UnsignedUtils.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0001\u001a\u001f\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0001\u001a\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0001\u001a\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0013H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tH\u0000¨\u0006\u001d"}, d2 = {"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UnsignedKt {
    public static final int uintCompare(int v1, int v2) {
        return Intrinsics.compare(v1 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ v2);
    }

    public static final int ulongCompare(long v1, long v2) {
        return Intrinsics.compare(v1 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ v2);
    }

    /* renamed from: uintDivide-J1ME1BU  reason: not valid java name */
    public static final int m519uintDivideJ1ME1BU(int v1, int v2) {
        return UInt.m263constructorimpl((int) ((v1 & KeyboardMap.kValueMask) / (KeyboardMap.kValueMask & v2)));
    }

    /* renamed from: uintRemainder-J1ME1BU  reason: not valid java name */
    public static final int m520uintRemainderJ1ME1BU(int v1, int v2) {
        return UInt.m263constructorimpl((int) ((v1 & KeyboardMap.kValueMask) % (KeyboardMap.kValueMask & v2)));
    }

    /* renamed from: ulongDivide-eb3DHEI  reason: not valid java name */
    public static final long m521ulongDivideeb3DHEI(long v1, long v2) {
        int compare;
        int compare2;
        if (v2 < 0) {
            compare2 = Long.compare(v1 ^ Long.MIN_VALUE, v2 ^ Long.MIN_VALUE);
            return ULong.m342constructorimpl(compare2 >= 0 ? 1L : 0L);
        } else if (v1 >= 0) {
            return ULong.m342constructorimpl(v1 / v2);
        } else {
            long quotient = ((v1 >>> 1) / v2) << 1;
            long rem = v1 - (quotient * v2);
            compare = Long.compare(ULong.m342constructorimpl(rem) ^ Long.MIN_VALUE, ULong.m342constructorimpl(v2) ^ Long.MIN_VALUE);
            return ULong.m342constructorimpl((compare < 0 ? 0 : 1) + quotient);
        }
    }

    /* renamed from: ulongRemainder-eb3DHEI  reason: not valid java name */
    public static final long m522ulongRemaindereb3DHEI(long v1, long v2) {
        int compare;
        int compare2;
        long j = 0;
        if (v2 < 0) {
            compare2 = Long.compare(v1 ^ Long.MIN_VALUE, v2 ^ Long.MIN_VALUE);
            if (compare2 < 0) {
                return v1;
            }
            return ULong.m342constructorimpl(v1 - v2);
        } else if (v1 >= 0) {
            return ULong.m342constructorimpl(v1 % v2);
        } else {
            long quotient = ((v1 >>> 1) / v2) << 1;
            long rem = v1 - (quotient * v2);
            compare = Long.compare(ULong.m342constructorimpl(rem) ^ Long.MIN_VALUE, ULong.m342constructorimpl(v2) ^ Long.MIN_VALUE);
            if (compare >= 0) {
                j = v2;
            }
            return ULong.m342constructorimpl(rem - j);
        }
    }

    public static final int doubleToUInt(double v) {
        if (!Double.isNaN(v) && v > uintToDouble(0)) {
            if (v >= uintToDouble(-1)) {
                return -1;
            }
            return v <= 2.147483647E9d ? UInt.m263constructorimpl((int) v) : UInt.m263constructorimpl(UInt.m263constructorimpl((int) (v - Integer.MAX_VALUE)) + UInt.m263constructorimpl(Integer.MAX_VALUE));
        }
        return 0;
    }

    public static final long doubleToULong(double v) {
        if (!Double.isNaN(v) && v > ulongToDouble(0L)) {
            if (v >= ulongToDouble(-1L)) {
                return -1L;
            }
            return v < 9.223372036854776E18d ? ULong.m342constructorimpl((long) v) : ULong.m342constructorimpl(ULong.m342constructorimpl((long) (v - 9.223372036854776E18d)) - Long.MIN_VALUE);
        }
        return 0L;
    }

    public static final double uintToDouble(int v) {
        return (Integer.MAX_VALUE & v) + (((v >>> 31) << 30) * 2);
    }

    public static final double ulongToDouble(long v) {
        return ((v >>> 11) * 2048) + (2047 & v);
    }

    public static final String ulongToString(long v) {
        return ulongToString(v, 10);
    }

    public static final String ulongToString(long v, int base) {
        if (v >= 0) {
            String l = Long.toString(v, CharsKt.checkRadix(base));
            Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
            return l;
        }
        long quotient = ((v >>> 1) / base) << 1;
        long rem = v - (base * quotient);
        if (rem >= base) {
            rem -= base;
            quotient++;
        }
        StringBuilder sb = new StringBuilder();
        String l2 = Long.toString(quotient, CharsKt.checkRadix(base));
        Intrinsics.checkNotNullExpressionValue(l2, "toString(...)");
        StringBuilder append = sb.append(l2);
        String l3 = Long.toString(rem, CharsKt.checkRadix(base));
        Intrinsics.checkNotNullExpressionValue(l3, "toString(...)");
        return append.append(l3).toString();
    }
}
