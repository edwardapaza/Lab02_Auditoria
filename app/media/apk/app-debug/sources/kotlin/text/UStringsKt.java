package kotlin.text;

import io.flutter.embedding.android.KeyboardMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByte$$ExternalSyntheticBackport1;
import kotlin.UByte$$ExternalSyntheticBackport5;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UStrings.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0012\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u0014\u001a\u00020\u0007*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0014\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u0018\u001a\u00020\n*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u0018\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001a\u001a\u000e\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\r*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001d\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001e\u001a\u000e\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006 "}, d2 = {"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UStringsKt {
    /* renamed from: toString-LxnNnR4  reason: not valid java name */
    public static final String m1481toStringLxnNnR4(byte $this$toString_u2dLxnNnR4, int radix) {
        String num = Integer.toString($this$toString_u2dLxnNnR4 & UByte.MAX_VALUE, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    /* renamed from: toString-olVBNx4  reason: not valid java name */
    public static final String m1483toStringolVBNx4(short $this$toString_u2dolVBNx4, int radix) {
        String num = Integer.toString(65535 & $this$toString_u2dolVBNx4, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    /* renamed from: toString-V7xB4Y4  reason: not valid java name */
    public static final String m1482toStringV7xB4Y4(int $this$toString_u2dV7xB4Y4, int radix) {
        String l = Long.toString($this$toString_u2dV7xB4Y4 & KeyboardMap.kValueMask, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
        return l;
    }

    /* renamed from: toString-JSWoG40  reason: not valid java name */
    public static final String m1480toStringJSWoG40(long $this$toString_u2dJSWoG40, int radix) {
        return UnsignedKt.ulongToString($this$toString_u2dJSWoG40, CharsKt.checkRadix(radix));
    }

    public static final byte toUByte(String $this$toUByte) {
        Intrinsics.checkNotNullParameter($this$toUByte, "<this>");
        UByte uByteOrNull = toUByteOrNull($this$toUByte);
        if (uByteOrNull != null) {
            return uByteOrNull.m236unboximpl();
        }
        StringsKt.numberFormatError($this$toUByte);
        throw new KotlinNothingValueException();
    }

    public static final byte toUByte(String $this$toUByte, int radix) {
        Intrinsics.checkNotNullParameter($this$toUByte, "<this>");
        UByte uByteOrNull = toUByteOrNull($this$toUByte, radix);
        if (uByteOrNull != null) {
            return uByteOrNull.m236unboximpl();
        }
        StringsKt.numberFormatError($this$toUByte);
        throw new KotlinNothingValueException();
    }

    public static final short toUShort(String $this$toUShort) {
        Intrinsics.checkNotNullParameter($this$toUShort, "<this>");
        UShort uShortOrNull = toUShortOrNull($this$toUShort);
        if (uShortOrNull != null) {
            return uShortOrNull.m499unboximpl();
        }
        StringsKt.numberFormatError($this$toUShort);
        throw new KotlinNothingValueException();
    }

    public static final short toUShort(String $this$toUShort, int radix) {
        Intrinsics.checkNotNullParameter($this$toUShort, "<this>");
        UShort uShortOrNull = toUShortOrNull($this$toUShort, radix);
        if (uShortOrNull != null) {
            return uShortOrNull.m499unboximpl();
        }
        StringsKt.numberFormatError($this$toUShort);
        throw new KotlinNothingValueException();
    }

    public static final int toUInt(String $this$toUInt) {
        Intrinsics.checkNotNullParameter($this$toUInt, "<this>");
        UInt uIntOrNull = toUIntOrNull($this$toUInt);
        if (uIntOrNull != null) {
            return uIntOrNull.m315unboximpl();
        }
        StringsKt.numberFormatError($this$toUInt);
        throw new KotlinNothingValueException();
    }

    public static final int toUInt(String $this$toUInt, int radix) {
        Intrinsics.checkNotNullParameter($this$toUInt, "<this>");
        UInt uIntOrNull = toUIntOrNull($this$toUInt, radix);
        if (uIntOrNull != null) {
            return uIntOrNull.m315unboximpl();
        }
        StringsKt.numberFormatError($this$toUInt);
        throw new KotlinNothingValueException();
    }

    public static final long toULong(String $this$toULong) {
        Intrinsics.checkNotNullParameter($this$toULong, "<this>");
        ULong uLongOrNull = toULongOrNull($this$toULong);
        if (uLongOrNull != null) {
            return uLongOrNull.m394unboximpl();
        }
        StringsKt.numberFormatError($this$toULong);
        throw new KotlinNothingValueException();
    }

    public static final long toULong(String $this$toULong, int radix) {
        Intrinsics.checkNotNullParameter($this$toULong, "<this>");
        ULong uLongOrNull = toULongOrNull($this$toULong, radix);
        if (uLongOrNull != null) {
            return uLongOrNull.m394unboximpl();
        }
        StringsKt.numberFormatError($this$toULong);
        throw new KotlinNothingValueException();
    }

    public static final UByte toUByteOrNull(String $this$toUByteOrNull) {
        Intrinsics.checkNotNullParameter($this$toUByteOrNull, "<this>");
        return toUByteOrNull($this$toUByteOrNull, 10);
    }

    public static final UByte toUByteOrNull(String $this$toUByteOrNull, int radix) {
        int compare;
        Intrinsics.checkNotNullParameter($this$toUByteOrNull, "<this>");
        UInt uIntOrNull = toUIntOrNull($this$toUByteOrNull, radix);
        if (uIntOrNull != null) {
            int m315unboximpl = uIntOrNull.m315unboximpl();
            compare = Integer.compare(m315unboximpl ^ Integer.MIN_VALUE, UInt.m263constructorimpl(255) ^ Integer.MIN_VALUE);
            if (compare > 0) {
                return null;
            }
            return UByte.m180boximpl(UByte.m186constructorimpl((byte) m315unboximpl));
        }
        return null;
    }

    public static final UShort toUShortOrNull(String $this$toUShortOrNull) {
        Intrinsics.checkNotNullParameter($this$toUShortOrNull, "<this>");
        return toUShortOrNull($this$toUShortOrNull, 10);
    }

    public static final UShort toUShortOrNull(String $this$toUShortOrNull, int radix) {
        int compare;
        Intrinsics.checkNotNullParameter($this$toUShortOrNull, "<this>");
        UInt uIntOrNull = toUIntOrNull($this$toUShortOrNull, radix);
        if (uIntOrNull != null) {
            int m315unboximpl = uIntOrNull.m315unboximpl();
            compare = Integer.compare(m315unboximpl ^ Integer.MIN_VALUE, UInt.m263constructorimpl(65535) ^ Integer.MIN_VALUE);
            if (compare > 0) {
                return null;
            }
            return UShort.m443boximpl(UShort.m449constructorimpl((short) m315unboximpl));
        }
        return null;
    }

    public static final UInt toUIntOrNull(String $this$toUIntOrNull) {
        Intrinsics.checkNotNullParameter($this$toUIntOrNull, "<this>");
        return toUIntOrNull($this$toUIntOrNull, 10);
    }

    public static final UInt toUIntOrNull(String $this$toUIntOrNull, int radix) {
        int start;
        int compare;
        int compare2;
        int compare3;
        Intrinsics.checkNotNullParameter($this$toUIntOrNull, "<this>");
        CharsKt.checkRadix(radix);
        int length = $this$toUIntOrNull.length();
        if (length == 0) {
            return null;
        }
        char firstChar = $this$toUIntOrNull.charAt(0);
        if (Intrinsics.compare((int) firstChar, 48) < 0) {
            if (length == 1 || firstChar != '+') {
                return null;
            }
            start = 1;
        } else {
            start = 0;
        }
        int limitBeforeMul = 119304647;
        int uradix = UInt.m263constructorimpl(radix);
        int result = 0;
        for (int i = start; i < length; i++) {
            int digit = CharsKt.digitOf($this$toUIntOrNull.charAt(i), radix);
            if (digit < 0) {
                return null;
            }
            compare = Integer.compare(result ^ Integer.MIN_VALUE, limitBeforeMul ^ Integer.MIN_VALUE);
            if (compare > 0) {
                if (limitBeforeMul != 119304647) {
                    return null;
                }
                limitBeforeMul = UByte$$ExternalSyntheticBackport1.m(-1, uradix);
                compare3 = Integer.compare(result ^ Integer.MIN_VALUE, limitBeforeMul ^ Integer.MIN_VALUE);
                if (compare3 > 0) {
                    return null;
                }
            }
            int result2 = UInt.m263constructorimpl(result * uradix);
            result = UInt.m263constructorimpl(UInt.m263constructorimpl(digit) + result2);
            compare2 = Integer.compare(result ^ Integer.MIN_VALUE, result2 ^ Integer.MIN_VALUE);
            if (compare2 < 0) {
                return null;
            }
        }
        return UInt.m257boximpl(result);
    }

    public static final ULong toULongOrNull(String $this$toULongOrNull) {
        Intrinsics.checkNotNullParameter($this$toULongOrNull, "<this>");
        return toULongOrNull($this$toULongOrNull, 10);
    }

    public static final ULong toULongOrNull(String $this$toULongOrNull, int radix) {
        int start;
        int compare;
        int compare2;
        int compare3;
        String str = $this$toULongOrNull;
        int i = radix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(radix);
        int length = $this$toULongOrNull.length();
        if (length == 0) {
            return null;
        }
        char firstChar = str.charAt(0);
        if (Intrinsics.compare((int) firstChar, 48) < 0) {
            if (length == 1 || firstChar != '+') {
                return null;
            }
            start = 1;
        } else {
            start = 0;
        }
        long limitBeforeMul = 512409557603043100L;
        long uradix = ULong.m342constructorimpl(i);
        long result = 0;
        int i2 = start;
        while (i2 < length) {
            int length2 = length;
            int digit = CharsKt.digitOf(str.charAt(i2), i);
            if (digit < 0) {
                return null;
            }
            compare = Long.compare(result ^ Long.MIN_VALUE, limitBeforeMul ^ Long.MIN_VALUE);
            if (compare > 0) {
                if (limitBeforeMul == 512409557603043100L) {
                    limitBeforeMul = UByte$$ExternalSyntheticBackport5.m(-1L, uradix);
                    compare3 = Long.compare(result ^ Long.MIN_VALUE, limitBeforeMul ^ Long.MIN_VALUE);
                    if (compare3 > 0) {
                        return null;
                    }
                } else {
                    return null;
                }
            }
            long result2 = ULong.m342constructorimpl(result * uradix);
            result = ULong.m342constructorimpl(ULong.m342constructorimpl(UInt.m263constructorimpl(digit) & KeyboardMap.kValueMask) + result2);
            compare2 = Long.compare(result ^ Long.MIN_VALUE, result2 ^ Long.MIN_VALUE);
            if (compare2 < 0) {
                return null;
            }
            i2++;
            str = $this$toULongOrNull;
            i = radix;
            length = length2;
        }
        return ULong.m336boximpl(result);
    }
}
