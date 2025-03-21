package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
/* compiled from: UShort.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u001c\u0010\u0010J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u001d\u0010\u0013J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b'\u0010\u0010J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b(\u0010\u0013J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b¢\u0006\u0004\b)\u0010\u001fJ\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0013\u00100\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b3\u0010\u0010J\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b4\u0010\u0013J\u0018\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b5\u0010\u001fJ\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b6\u0010\u0018J\u0018\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b8\u00109J\u0018\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b:\u0010\u0013J\u0018\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b¢\u0006\u0004\b;\u0010\u001fJ\u0018\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b<\u0010\u000bJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b>\u0010\u000bJ\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b@\u0010\u0010J\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bA\u0010\u0013J\u0018\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bB\u0010\u001fJ\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bC\u0010\u0018J\u0018\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bF\u0010GJ\u0018\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bI\u0010GJ\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bK\u0010\u0010J\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bL\u0010\u0013J\u0018\u0010J\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bM\u0010\u001fJ\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bN\u0010\u0018J\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bP\u0010\u0010J\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bQ\u0010\u0013J\u0018\u0010O\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bR\u0010\u001fJ\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\b¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020]H\u0087\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\rH\u0087\b¢\u0006\u0004\ba\u0010-J\u0010\u0010b\u001a\u00020cH\u0087\b¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bg\u0010\u0005J\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\bm\u0010WJ\u0013\u0010n\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\bo\u0010-J\u0013\u0010p\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\bq\u0010eJ\u0013\u0010r\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bs\u0010\u0005J\u0018\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\b!¨\u0006w"}, d2 = {"Lkotlin/UShort;", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = new Companion(null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UShort m443boximpl(short s) {
        return new UShort(s);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m449constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m455equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m499unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m456equalsimpl0(short s, short s2) {
        return s == s2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m461hashCodeimpl(short s) {
        return s;
    }

    public boolean equals(Object obj) {
        return m455equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m461hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short m499unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(m499unboximpl() & MAX_VALUE, uShort.m499unboximpl() & MAX_VALUE);
    }

    private /* synthetic */ UShort(short data) {
        this.data = data;
    }

    /* compiled from: UShort.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", ExifInterface.LATITUDE_SOUTH, "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m444compareTo7apg3OU(short arg0, byte other) {
        return Intrinsics.compare(65535 & arg0, other & UByte.MAX_VALUE);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private int m447compareToxj2QHRw(short other) {
        return Intrinsics.compare(m499unboximpl() & MAX_VALUE, 65535 & other);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static int m448compareToxj2QHRw(short arg0, short other) {
        return Intrinsics.compare(arg0 & MAX_VALUE, 65535 & other);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m446compareToWZ4Q5Ns(short arg0, int other) {
        int compare;
        compare = Integer.compare(UInt.m263constructorimpl(65535 & arg0) ^ Integer.MIN_VALUE, other ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m445compareToVKZWuLQ(short arg0, long other) {
        int compare;
        compare = Long.compare(ULong.m342constructorimpl(arg0 & 65535) ^ Long.MIN_VALUE, other ^ Long.MIN_VALUE);
        return compare;
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m473plus7apg3OU(short arg0, byte other) {
        return UInt.m263constructorimpl(UInt.m263constructorimpl(65535 & arg0) + UInt.m263constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m476plusxj2QHRw(short arg0, short other) {
        return UInt.m263constructorimpl(UInt.m263constructorimpl(arg0 & MAX_VALUE) + UInt.m263constructorimpl(65535 & other));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m475plusWZ4Q5Ns(short arg0, int other) {
        return UInt.m263constructorimpl(UInt.m263constructorimpl(65535 & arg0) + other);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m474plusVKZWuLQ(short arg0, long other) {
        return ULong.m342constructorimpl(ULong.m342constructorimpl(arg0 & 65535) + other);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m464minus7apg3OU(short arg0, byte other) {
        return UInt.m263constructorimpl(UInt.m263constructorimpl(65535 & arg0) - UInt.m263constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m467minusxj2QHRw(short arg0, short other) {
        return UInt.m263constructorimpl(UInt.m263constructorimpl(arg0 & MAX_VALUE) - UInt.m263constructorimpl(65535 & other));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m466minusWZ4Q5Ns(short arg0, int other) {
        return UInt.m263constructorimpl(UInt.m263constructorimpl(65535 & arg0) - other);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m465minusVKZWuLQ(short arg0, long other) {
        return ULong.m342constructorimpl(ULong.m342constructorimpl(arg0 & 65535) - other);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m483times7apg3OU(short arg0, byte other) {
        return UInt.m263constructorimpl(UInt.m263constructorimpl(65535 & arg0) * UInt.m263constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m486timesxj2QHRw(short arg0, short other) {
        return UInt.m263constructorimpl(UInt.m263constructorimpl(arg0 & MAX_VALUE) * UInt.m263constructorimpl(65535 & other));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m485timesWZ4Q5Ns(short arg0, int other) {
        return UInt.m263constructorimpl(UInt.m263constructorimpl(65535 & arg0) * other);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m484timesVKZWuLQ(short arg0, long other) {
        return ULong.m342constructorimpl(ULong.m342constructorimpl(arg0 & 65535) * other);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m451div7apg3OU(short arg0, byte other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m263constructorimpl(65535 & arg0), UInt.m263constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m454divxj2QHRw(short arg0, short other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m263constructorimpl(arg0 & MAX_VALUE), UInt.m263constructorimpl(65535 & other));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m453divWZ4Q5Ns(short arg0, int other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m263constructorimpl(65535 & arg0), other);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m452divVKZWuLQ(short arg0, long other) {
        return UByte$$ExternalSyntheticBackport5.m(ULong.m342constructorimpl(arg0 & 65535), other);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m479rem7apg3OU(short arg0, byte other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m263constructorimpl(65535 & arg0), UInt.m263constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m482remxj2QHRw(short arg0, short other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m263constructorimpl(arg0 & MAX_VALUE), UInt.m263constructorimpl(65535 & other));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m481remWZ4Q5Ns(short arg0, int other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m263constructorimpl(65535 & arg0), other);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m480remVKZWuLQ(short arg0, long other) {
        return UByte$$ExternalSyntheticBackport3.m(ULong.m342constructorimpl(arg0 & 65535), other);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m457floorDiv7apg3OU(short arg0, byte other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m263constructorimpl(65535 & arg0), UInt.m263constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m460floorDivxj2QHRw(short arg0, short other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m263constructorimpl(arg0 & MAX_VALUE), UInt.m263constructorimpl(65535 & other));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m459floorDivWZ4Q5Ns(short arg0, int other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m263constructorimpl(65535 & arg0), other);
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m458floorDivVKZWuLQ(short arg0, long other) {
        return UByte$$ExternalSyntheticBackport5.m(ULong.m342constructorimpl(arg0 & 65535), other);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m468mod7apg3OU(short arg0, byte other) {
        return UByte.m186constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m(UInt.m263constructorimpl(65535 & arg0), UInt.m263constructorimpl(other & UByte.MAX_VALUE)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m471modxj2QHRw(short arg0, short other) {
        return m449constructorimpl((short) UByte$$ExternalSyntheticBackport0.m(UInt.m263constructorimpl(arg0 & MAX_VALUE), UInt.m263constructorimpl(65535 & other)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m470modWZ4Q5Ns(short arg0, int other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m263constructorimpl(65535 & arg0), other);
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m469modVKZWuLQ(short arg0, long other) {
        return UByte$$ExternalSyntheticBackport3.m(ULong.m342constructorimpl(arg0 & 65535), other);
    }

    /* renamed from: inc-Mh2AYeg  reason: not valid java name */
    private static final short m462incMh2AYeg(short arg0) {
        return m449constructorimpl((short) (arg0 + 1));
    }

    /* renamed from: dec-Mh2AYeg  reason: not valid java name */
    private static final short m450decMh2AYeg(short arg0) {
        return m449constructorimpl((short) (arg0 - 1));
    }

    /* renamed from: rangeTo-xj2QHRw  reason: not valid java name */
    private static final UIntRange m477rangeToxj2QHRw(short arg0, short other) {
        return new UIntRange(UInt.m263constructorimpl(arg0 & MAX_VALUE), UInt.m263constructorimpl(65535 & other), null);
    }

    /* renamed from: rangeUntil-xj2QHRw  reason: not valid java name */
    private static final UIntRange m478rangeUntilxj2QHRw(short arg0, short other) {
        return URangesKt.m1437untilJ1ME1BU(UInt.m263constructorimpl(arg0 & MAX_VALUE), UInt.m263constructorimpl(65535 & other));
    }

    /* renamed from: and-xj2QHRw  reason: not valid java name */
    private static final short m442andxj2QHRw(short arg0, short other) {
        return m449constructorimpl((short) (arg0 & other));
    }

    /* renamed from: or-xj2QHRw  reason: not valid java name */
    private static final short m472orxj2QHRw(short arg0, short other) {
        return m449constructorimpl((short) (arg0 | other));
    }

    /* renamed from: xor-xj2QHRw  reason: not valid java name */
    private static final short m498xorxj2QHRw(short arg0, short other) {
        return m449constructorimpl((short) (arg0 ^ other));
    }

    /* renamed from: inv-Mh2AYeg  reason: not valid java name */
    private static final short m463invMh2AYeg(short arg0) {
        return m449constructorimpl((short) (~arg0));
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m487toByteimpl(short arg0) {
        return (byte) arg0;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m492toShortimpl(short arg0) {
        return arg0;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m490toIntimpl(short arg0) {
        return 65535 & arg0;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m491toLongimpl(short arg0) {
        return arg0 & 65535;
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m494toUBytew2LRezQ(short arg0) {
        return UByte.m186constructorimpl((byte) arg0);
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m497toUShortMh2AYeg(short arg0) {
        return arg0;
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m495toUIntpVg5ArA(short arg0) {
        return UInt.m263constructorimpl(65535 & arg0);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m496toULongsVKNKU(short arg0) {
        return ULong.m342constructorimpl(arg0 & 65535);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m489toFloatimpl(short arg0) {
        return 65535 & arg0;
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m488toDoubleimpl(short arg0) {
        return 65535 & arg0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m493toStringimpl(short arg0) {
        return String.valueOf(65535 & arg0);
    }

    public String toString() {
        return m493toStringimpl(this.data);
    }
}
