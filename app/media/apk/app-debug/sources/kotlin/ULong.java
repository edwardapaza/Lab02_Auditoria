package kotlin;

import com.google.firebase.messaging.Constants;
import io.flutter.embedding.android.KeyboardMap;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;
/* compiled from: ULong.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 ~2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001~B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b \u0010\u000bJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b)\u0010\u001dJ\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b*\u0010\u001fJ\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b+\u0010\u000bJ\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\b¢\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b.\u0010/J\u0013\u00100\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u0013\u00102\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b3\u0010\u0005J\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b5\u0010\u001dJ\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b6\u0010\u001fJ\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b7\u0010\u000bJ\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b8\u0010\"J\u0018\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b:\u0010;J\u0018\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b<\u0010\u0013J\u0018\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b=\u0010\u000bJ\u0018\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\b¢\u0006\u0004\b>\u0010?J\u0018\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bA\u0010\u000bJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bC\u0010\u001dJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bD\u0010\u001fJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bE\u0010\u000bJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\bF\u0010\"J\u0018\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bI\u0010JJ\u0018\u0010K\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bL\u0010JJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bN\u0010\u001dJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bO\u0010\u001fJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bP\u0010\u000bJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\bQ\u0010\"J\u001b\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\u0087\fø\u0001\u0000¢\u0006\u0004\bT\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\u0087\fø\u0001\u0000¢\u0006\u0004\bV\u0010\u001fJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bX\u0010\u001dJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bY\u0010\u001fJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bZ\u0010\u000bJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b[\u0010\"J\u0010\u0010\\\u001a\u00020]H\u0087\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020aH\u0087\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020eH\u0087\b¢\u0006\u0004\bf\u0010gJ\u0010\u0010h\u001a\u00020\rH\u0087\b¢\u0006\u0004\bi\u0010/J\u0010\u0010j\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bk\u0010\u0005J\u0010\u0010l\u001a\u00020mH\u0087\b¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020qH\u0016¢\u0006\u0004\br\u0010sJ\u0013\u0010t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\bu\u0010_J\u0013\u0010v\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\bw\u0010/J\u0013\u0010x\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\by\u0010\u0005J\u0013\u0010z\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b{\u0010oJ\u0018\u0010|\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b}\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\b!¨\u0006\u007f"}, d2 = {"Lkotlin/ULong;", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = new Companion(null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULong m336boximpl(long j) {
        return new ULong(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m342constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m348equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m394unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m349equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m354hashCodeimpl(long j) {
        return ULong$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m348equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m354hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m394unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedKt.ulongCompare(m394unboximpl(), uLong.m394unboximpl());
    }

    private /* synthetic */ ULong(long data) {
        this.data = data;
    }

    /* compiled from: ULong.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m337compareTo7apg3OU(long arg0, byte other) {
        int compare;
        compare = Long.compare(arg0 ^ Long.MIN_VALUE, m342constructorimpl(other & 255) ^ Long.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m341compareToxj2QHRw(long arg0, short other) {
        int compare;
        compare = Long.compare(arg0 ^ Long.MIN_VALUE, m342constructorimpl(other & 65535) ^ Long.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m340compareToWZ4Q5Ns(long arg0, int other) {
        int compare;
        compare = Long.compare(arg0 ^ Long.MIN_VALUE, m342constructorimpl(other & KeyboardMap.kValueMask) ^ Long.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private int m338compareToVKZWuLQ(long other) {
        return UnsignedKt.ulongCompare(m394unboximpl(), other);
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static int m339compareToVKZWuLQ(long arg0, long other) {
        return UnsignedKt.ulongCompare(arg0, other);
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final long m366plus7apg3OU(long arg0, byte other) {
        return m342constructorimpl(m342constructorimpl(other & 255) + arg0);
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final long m369plusxj2QHRw(long arg0, short other) {
        return m342constructorimpl(m342constructorimpl(other & 65535) + arg0);
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final long m368plusWZ4Q5Ns(long arg0, int other) {
        return m342constructorimpl(m342constructorimpl(other & KeyboardMap.kValueMask) + arg0);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m367plusVKZWuLQ(long arg0, long other) {
        return m342constructorimpl(arg0 + other);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final long m357minus7apg3OU(long arg0, byte other) {
        return m342constructorimpl(arg0 - m342constructorimpl(other & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final long m360minusxj2QHRw(long arg0, short other) {
        return m342constructorimpl(arg0 - m342constructorimpl(other & 65535));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final long m359minusWZ4Q5Ns(long arg0, int other) {
        return m342constructorimpl(arg0 - m342constructorimpl(other & KeyboardMap.kValueMask));
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m358minusVKZWuLQ(long arg0, long other) {
        return m342constructorimpl(arg0 - other);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final long m378times7apg3OU(long arg0, byte other) {
        return m342constructorimpl(m342constructorimpl(other & 255) * arg0);
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final long m381timesxj2QHRw(long arg0, short other) {
        return m342constructorimpl(m342constructorimpl(other & 65535) * arg0);
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final long m380timesWZ4Q5Ns(long arg0, int other) {
        return m342constructorimpl(m342constructorimpl(other & KeyboardMap.kValueMask) * arg0);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m379timesVKZWuLQ(long arg0, long other) {
        return m342constructorimpl(arg0 * other);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final long m344div7apg3OU(long arg0, byte other) {
        return UByte$$ExternalSyntheticBackport5.m(arg0, m342constructorimpl(other & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final long m347divxj2QHRw(long arg0, short other) {
        return UByte$$ExternalSyntheticBackport5.m(arg0, m342constructorimpl(other & 65535));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final long m346divWZ4Q5Ns(long arg0, int other) {
        return UByte$$ExternalSyntheticBackport5.m(arg0, m342constructorimpl(other & KeyboardMap.kValueMask));
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m345divVKZWuLQ(long arg0, long other) {
        return UnsignedKt.m521ulongDivideeb3DHEI(arg0, other);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final long m372rem7apg3OU(long arg0, byte other) {
        return UByte$$ExternalSyntheticBackport3.m(arg0, m342constructorimpl(other & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final long m375remxj2QHRw(long arg0, short other) {
        return UByte$$ExternalSyntheticBackport3.m(arg0, m342constructorimpl(other & 65535));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final long m374remWZ4Q5Ns(long arg0, int other) {
        return UByte$$ExternalSyntheticBackport3.m(arg0, m342constructorimpl(other & KeyboardMap.kValueMask));
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m373remVKZWuLQ(long arg0, long other) {
        return UnsignedKt.m522ulongRemaindereb3DHEI(arg0, other);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final long m350floorDiv7apg3OU(long arg0, byte other) {
        return UByte$$ExternalSyntheticBackport5.m(arg0, m342constructorimpl(other & 255));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final long m353floorDivxj2QHRw(long arg0, short other) {
        return UByte$$ExternalSyntheticBackport5.m(arg0, m342constructorimpl(other & 65535));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final long m352floorDivWZ4Q5Ns(long arg0, int other) {
        return UByte$$ExternalSyntheticBackport5.m(arg0, m342constructorimpl(other & KeyboardMap.kValueMask));
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m351floorDivVKZWuLQ(long arg0, long other) {
        return UByte$$ExternalSyntheticBackport5.m(arg0, other);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m361mod7apg3OU(long arg0, byte other) {
        return UByte.m186constructorimpl((byte) UByte$$ExternalSyntheticBackport3.m(arg0, m342constructorimpl(other & 255)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m364modxj2QHRw(long arg0, short other) {
        return UShort.m449constructorimpl((short) UByte$$ExternalSyntheticBackport3.m(arg0, m342constructorimpl(other & 65535)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m363modWZ4Q5Ns(long arg0, int other) {
        return UInt.m263constructorimpl((int) UByte$$ExternalSyntheticBackport3.m(arg0, m342constructorimpl(other & KeyboardMap.kValueMask)));
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m362modVKZWuLQ(long arg0, long other) {
        return UByte$$ExternalSyntheticBackport3.m(arg0, other);
    }

    /* renamed from: inc-s-VKNKU  reason: not valid java name */
    private static final long m355incsVKNKU(long arg0) {
        return m342constructorimpl(1 + arg0);
    }

    /* renamed from: dec-s-VKNKU  reason: not valid java name */
    private static final long m343decsVKNKU(long arg0) {
        return m342constructorimpl((-1) + arg0);
    }

    /* renamed from: rangeTo-VKZWuLQ  reason: not valid java name */
    private static final ULongRange m370rangeToVKZWuLQ(long arg0, long other) {
        return new ULongRange(arg0, other, null);
    }

    /* renamed from: rangeUntil-VKZWuLQ  reason: not valid java name */
    private static final ULongRange m371rangeUntilVKZWuLQ(long arg0, long other) {
        return URangesKt.m1439untileb3DHEI(arg0, other);
    }

    /* renamed from: shl-s-VKNKU  reason: not valid java name */
    private static final long m376shlsVKNKU(long arg0, int bitCount) {
        return m342constructorimpl(arg0 << bitCount);
    }

    /* renamed from: shr-s-VKNKU  reason: not valid java name */
    private static final long m377shrsVKNKU(long arg0, int bitCount) {
        return m342constructorimpl(arg0 >>> bitCount);
    }

    /* renamed from: and-VKZWuLQ  reason: not valid java name */
    private static final long m335andVKZWuLQ(long arg0, long other) {
        return m342constructorimpl(arg0 & other);
    }

    /* renamed from: or-VKZWuLQ  reason: not valid java name */
    private static final long m365orVKZWuLQ(long arg0, long other) {
        return m342constructorimpl(arg0 | other);
    }

    /* renamed from: xor-VKZWuLQ  reason: not valid java name */
    private static final long m393xorVKZWuLQ(long arg0, long other) {
        return m342constructorimpl(arg0 ^ other);
    }

    /* renamed from: inv-s-VKNKU  reason: not valid java name */
    private static final long m356invsVKNKU(long arg0) {
        return m342constructorimpl(~arg0);
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m382toByteimpl(long arg0) {
        return (byte) arg0;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m387toShortimpl(long arg0) {
        return (short) arg0;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m385toIntimpl(long arg0) {
        return (int) arg0;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m386toLongimpl(long arg0) {
        return arg0;
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m389toUBytew2LRezQ(long arg0) {
        return UByte.m186constructorimpl((byte) arg0);
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m392toUShortMh2AYeg(long arg0) {
        return UShort.m449constructorimpl((short) arg0);
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m390toUIntpVg5ArA(long arg0) {
        return UInt.m263constructorimpl((int) arg0);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m391toULongsVKNKU(long arg0) {
        return arg0;
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m384toFloatimpl(long arg0) {
        return (float) UnsignedKt.ulongToDouble(arg0);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m383toDoubleimpl(long arg0) {
        return UnsignedKt.ulongToDouble(arg0);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m388toStringimpl(long arg0) {
        return UnsignedKt.ulongToString(arg0);
    }

    public String toString() {
        return m388toStringimpl(this.data);
    }
}
