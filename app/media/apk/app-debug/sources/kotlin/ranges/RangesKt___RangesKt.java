package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Ranges.kt */
@Metadata(d1 = {"\u0000t\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\u001a'\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007\u001a\u0012\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b\u001a\u0012\u0010\u0000\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t\u001a\u0012\u0010\u0000\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n\u001a'\u0010\u000b\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\f\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u0012\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0012\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a3\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\f\u001a\u0004\u0018\u0001H\u0001¢\u0006\u0002\u0010\u000e\u001a/\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a-\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0012¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u001a\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u001a\u0010\r\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0018\u0010\r\u001a\u00020\b*\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0012\u001a\u001a\u0010\r\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0018\u0010\r\u001a\u00020\t*\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u001a\u001a\u0010\r\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0087\n¢\u0006\u0002\u0010\u0019\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b \u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0087\n¢\u0006\u0002\u0010\"\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\tH\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\nH\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\bH\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020#2\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0087\n¢\u0006\u0002\u0010$\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\nH\u0087\n\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b \u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020**\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\f\u0010+\u001a\u00020\u0018*\u00020*H\u0007\u001a\f\u0010+\u001a\u00020\b*\u00020'H\u0007\u001a\f\u0010+\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\b*\u00020'H\u0007¢\u0006\u0002\u0010.\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\t*\u00020)H\u0007¢\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0018*\u00020*H\u0007\u001a\f\u00100\u001a\u00020\b*\u00020'H\u0007\u001a\f\u00100\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u00101\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0013\u00101\u001a\u0004\u0018\u00010\b*\u00020'H\u0007¢\u0006\u0002\u0010.\u001a\u0013\u00101\u001a\u0004\u0018\u00010\t*\u00020)H\u0007¢\u0006\u0002\u0010/\u001a\r\u00102\u001a\u00020\u0018*\u00020\u0016H\u0087\b\u001a\u0014\u00102\u001a\u00020\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\b*\u00020!H\u0087\b\u001a\u0014\u00102\u001a\u00020\b*\u00020!2\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\t*\u00020#H\u0087\b\u001a\u0014\u00102\u001a\u00020\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007\u001a\u0014\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u0016H\u0087\b¢\u0006\u0002\u00105\u001a\u001b\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00106\u001a\u0014\u00104\u001a\u0004\u0018\u00010\b*\u00020!H\u0087\b¢\u0006\u0002\u00107\u001a\u001b\u00104\u001a\u0004\u0018\u00010\b*\u00020!2\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00108\u001a\u0014\u00104\u001a\u0004\u0018\u00010\t*\u00020#H\u0087\b¢\u0006\u0002\u00109\u001a\u001b\u00104\u001a\u0004\u0018\u00010\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u0010:\u001a\n\u0010;\u001a\u00020**\u00020*\u001a\n\u0010;\u001a\u00020'*\u00020'\u001a\n\u0010;\u001a\u00020)*\u00020)\u001a\u0015\u0010<\u001a\u00020**\u00020*2\u0006\u0010<\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010<\u001a\u00020'*\u00020'2\u0006\u0010<\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010<\u001a\u00020)*\u00020)2\u0006\u0010<\u001a\u00020\tH\u0086\u0004\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0000¢\u0006\u0002\u0010>\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\u0007H\u0000¢\u0006\u0002\u0010?\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\bH\u0000¢\u0006\u0002\u0010@\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\tH\u0000¢\u0006\u0002\u0010A\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\nH\u0000¢\u0006\u0002\u0010B\u001a\u0013\u0010C\u001a\u0004\u0018\u00010\b*\u00020\u0006H\u0000¢\u0006\u0002\u0010D\u001a\u0013\u0010C\u001a\u0004\u0018\u00010\b*\u00020\u0007H\u0000¢\u0006\u0002\u0010E\u001a\u0013\u0010C\u001a\u0004\u0018\u00010\b*\u00020\tH\u0000¢\u0006\u0002\u0010F\u001a\u0013\u0010G\u001a\u0004\u0018\u00010\t*\u00020\u0006H\u0000¢\u0006\u0002\u0010H\u001a\u0013\u0010G\u001a\u0004\u0018\u00010\t*\u00020\u0007H\u0000¢\u0006\u0002\u0010I\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\u0006H\u0000¢\u0006\u0002\u0010K\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\u0007H\u0000¢\u0006\u0002\u0010L\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\bH\u0000¢\u0006\u0002\u0010M\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\tH\u0000¢\u0006\u0002\u0010N\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020\u0016*\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0086\u0004¨\u0006P"}, d2 = {"coerceAtLeast", ExifInterface.GPS_DIRECTION_TRUE, "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "Lkotlin/ranges/OpenEndRange;", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "first", "firstOrNull", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "last", "lastOrNull", "random", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes.dex */
public class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static final int first(IntProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.getFirst();
    }

    public static final long first(LongProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.getFirst();
    }

    public static final char first(CharProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.getFirst();
    }

    public static final Integer firstOrNull(IntProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            return null;
        }
        return Integer.valueOf($this$firstOrNull.getFirst());
    }

    public static final Long firstOrNull(LongProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            return null;
        }
        return Long.valueOf($this$firstOrNull.getFirst());
    }

    public static final Character firstOrNull(CharProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            return null;
        }
        return Character.valueOf($this$firstOrNull.getFirst());
    }

    public static final int last(IntProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.getLast();
    }

    public static final long last(LongProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.getLast();
    }

    public static final char last(CharProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.getLast();
    }

    public static final Integer lastOrNull(IntProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        if ($this$lastOrNull.isEmpty()) {
            return null;
        }
        return Integer.valueOf($this$lastOrNull.getLast());
    }

    public static final Long lastOrNull(LongProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        if ($this$lastOrNull.isEmpty()) {
            return null;
        }
        return Long.valueOf($this$lastOrNull.getLast());
    }

    public static final Character lastOrNull(CharProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        if ($this$lastOrNull.isEmpty()) {
            return null;
        }
        return Character.valueOf($this$lastOrNull.getLast());
    }

    private static final int random(IntRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return RangesKt.random($this$random, Random.Default);
    }

    private static final long random(LongRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return RangesKt.random($this$random, Random.Default);
    }

    private static final char random(CharRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return RangesKt.random($this$random, Random.Default);
    }

    public static final int random(IntRange $this$random, Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextInt(random, $this$random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final long random(LongRange $this$random, Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextLong(random, $this$random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final char random(CharRange $this$random, Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return (char) random.nextInt($this$random.getFirst(), $this$random.getLast() + 1);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final Integer randomOrNull(IntRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return RangesKt.randomOrNull($this$randomOrNull, Random.Default);
    }

    private static final Long randomOrNull(LongRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return RangesKt.randomOrNull($this$randomOrNull, Random.Default);
    }

    private static final Character randomOrNull(CharRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return RangesKt.randomOrNull($this$randomOrNull, Random.Default);
    }

    public static final Integer randomOrNull(IntRange $this$randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return Integer.valueOf(RandomKt.nextInt(random, $this$randomOrNull));
    }

    public static final Long randomOrNull(LongRange $this$randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return Long.valueOf(RandomKt.nextLong(random, $this$randomOrNull));
    }

    public static final Character randomOrNull(CharRange $this$randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.nextInt($this$randomOrNull.getFirst(), $this$randomOrNull.getLast() + 1));
    }

    private static final boolean contains(IntRange $this$contains, Integer element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains(element.intValue());
    }

    private static final boolean contains(LongRange $this$contains, Long element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains(element.longValue());
    }

    private static final boolean contains(CharRange $this$contains, Character element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains(element.charValue());
    }

    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, byte value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Integer.valueOf(value));
    }

    public static final boolean longRangeContains(ClosedRange<Long> closedRange, byte value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf(value));
    }

    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, byte value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Short.valueOf(value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Double.valueOf(value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Float.valueOf(value));
    }

    public static final boolean intRangeContains(OpenEndRange<Integer> openEndRange, byte value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Integer.valueOf(value));
    }

    public static final boolean longRangeContains(OpenEndRange<Long> openEndRange, byte value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf(value));
    }

    public static final boolean shortRangeContains(OpenEndRange<Short> openEndRange, byte value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Short.valueOf(value));
    }

    private static final boolean contains(IntRange $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.intRangeContains((ClosedRange<Integer>) $this$contains, value);
    }

    private static final boolean contains(LongRange $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.longRangeContains((ClosedRange<Long>) $this$contains, value);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange $this$contains, double value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Integer it = RangesKt.toIntExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange $this$contains, double value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Long it = RangesKt.toLongExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange $this$contains, double value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange $this$contains, double value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Short it = RangesKt.toShortExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    public static final boolean floatRangeContains(ClosedRange<Float> closedRange, double value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Float.valueOf((float) value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange $this$contains, float value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Integer it = RangesKt.toIntExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange $this$contains, float value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Long it = RangesKt.toLongExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange $this$contains, float value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange $this$contains, float value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Short it = RangesKt.toShortExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    public static final boolean doubleRangeContains(ClosedRange<Double> closedRange, float value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Double.valueOf(value));
    }

    public static final boolean doubleRangeContains(OpenEndRange<Double> openEndRange, float value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Double.valueOf(value));
    }

    public static final boolean longRangeContains(ClosedRange<Long> closedRange, int value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf(value));
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, int value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return closedRange.contains(it);
        }
        return false;
    }

    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, int value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short it = RangesKt.toShortExactOrNull(value);
        if (it != null) {
            return closedRange.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange $this$contains, int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Double.valueOf(value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange $this$contains, int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Float.valueOf(value));
    }

    public static final boolean longRangeContains(OpenEndRange<Long> openEndRange, int value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf(value));
    }

    public static final boolean byteRangeContains(OpenEndRange<Byte> openEndRange, int value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return openEndRange.contains(it);
        }
        return false;
    }

    public static final boolean shortRangeContains(OpenEndRange<Short> openEndRange, int value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Short it = RangesKt.toShortExactOrNull(value);
        if (it != null) {
            return openEndRange.contains(it);
        }
        return false;
    }

    private static final boolean contains(LongRange $this$contains, int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.longRangeContains((ClosedRange<Long>) $this$contains, value);
    }

    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, long value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Integer it = RangesKt.toIntExactOrNull(value);
        if (it != null) {
            return closedRange.contains(it);
        }
        return false;
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, long value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return closedRange.contains(it);
        }
        return false;
    }

    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, long value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short it = RangesKt.toShortExactOrNull(value);
        if (it != null) {
            return closedRange.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange $this$contains, long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Double.valueOf(value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange $this$contains, long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Float.valueOf((float) value));
    }

    public static final boolean intRangeContains(OpenEndRange<Integer> openEndRange, long value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Integer it = RangesKt.toIntExactOrNull(value);
        if (it != null) {
            return openEndRange.contains(it);
        }
        return false;
    }

    public static final boolean byteRangeContains(OpenEndRange<Byte> openEndRange, long value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return openEndRange.contains(it);
        }
        return false;
    }

    public static final boolean shortRangeContains(OpenEndRange<Short> openEndRange, long value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Short it = RangesKt.toShortExactOrNull(value);
        if (it != null) {
            return openEndRange.contains(it);
        }
        return false;
    }

    private static final boolean contains(IntRange $this$contains, long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.intRangeContains((ClosedRange<Integer>) $this$contains, value);
    }

    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, short value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Integer.valueOf(value));
    }

    public static final boolean longRangeContains(ClosedRange<Long> closedRange, short value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf(value));
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, short value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return closedRange.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Double.valueOf(value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Float.valueOf(value));
    }

    public static final boolean intRangeContains(OpenEndRange<Integer> openEndRange, short value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Integer.valueOf(value));
    }

    public static final boolean longRangeContains(OpenEndRange<Long> openEndRange, short value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf(value));
    }

    public static final boolean byteRangeContains(OpenEndRange<Byte> openEndRange, short value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return openEndRange.contains(it);
        }
        return false;
    }

    private static final boolean contains(IntRange $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.intRangeContains((ClosedRange<Integer>) $this$contains, value);
    }

    private static final boolean contains(LongRange $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.longRangeContains((ClosedRange<Long>) $this$contains, value);
    }

    public static final IntProgression downTo(int $this$downTo, byte to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final LongProgression downTo(long $this$downTo, byte to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final IntProgression downTo(byte $this$downTo, byte to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final IntProgression downTo(short $this$downTo, byte to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final CharProgression downTo(char $this$downTo, char to) {
        return CharProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final IntProgression downTo(int $this$downTo, int to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final LongProgression downTo(long $this$downTo, int to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final IntProgression downTo(byte $this$downTo, int to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final IntProgression downTo(short $this$downTo, int to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final LongProgression downTo(int $this$downTo, long to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final LongProgression downTo(long $this$downTo, long to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final LongProgression downTo(byte $this$downTo, long to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final LongProgression downTo(short $this$downTo, long to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final IntProgression downTo(int $this$downTo, short to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final LongProgression downTo(long $this$downTo, short to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final IntProgression downTo(byte $this$downTo, short to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final IntProgression downTo(short $this$downTo, short to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final IntProgression reversed(IntProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return IntProgression.Companion.fromClosedRange($this$reversed.getLast(), $this$reversed.getFirst(), -$this$reversed.getStep());
    }

    public static final LongProgression reversed(LongProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return LongProgression.Companion.fromClosedRange($this$reversed.getLast(), $this$reversed.getFirst(), -$this$reversed.getStep());
    }

    public static final CharProgression reversed(CharProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return CharProgression.Companion.fromClosedRange($this$reversed.getLast(), $this$reversed.getFirst(), -$this$reversed.getStep());
    }

    public static final IntProgression step(IntProgression $this$step, int step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt.checkStepIsPositive(step > 0, Integer.valueOf(step));
        return IntProgression.Companion.fromClosedRange($this$step.getFirst(), $this$step.getLast(), $this$step.getStep() > 0 ? step : -step);
    }

    public static final LongProgression step(LongProgression $this$step, long step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt.checkStepIsPositive(step > 0, Long.valueOf(step));
        return LongProgression.Companion.fromClosedRange($this$step.getFirst(), $this$step.getLast(), $this$step.getStep() > 0 ? step : -step);
    }

    public static final CharProgression step(CharProgression $this$step, int step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt.checkStepIsPositive(step > 0, Integer.valueOf(step));
        return CharProgression.Companion.fromClosedRange($this$step.getFirst(), $this$step.getLast(), $this$step.getStep() > 0 ? step : -step);
    }

    public static final Byte toByteExactOrNull(int $this$toByteExactOrNull) {
        if (new IntRange(-128, WorkQueueKt.MASK).contains($this$toByteExactOrNull)) {
            return Byte.valueOf((byte) $this$toByteExactOrNull);
        }
        return null;
    }

    public static final Byte toByteExactOrNull(long $this$toByteExactOrNull) {
        if (new LongRange(-128L, 127L).contains($this$toByteExactOrNull)) {
            return Byte.valueOf((byte) $this$toByteExactOrNull);
        }
        return null;
    }

    public static final Byte toByteExactOrNull(short $this$toByteExactOrNull) {
        if (RangesKt.intRangeContains((ClosedRange<Integer>) new IntRange(-128, WorkQueueKt.MASK), $this$toByteExactOrNull)) {
            return Byte.valueOf((byte) $this$toByteExactOrNull);
        }
        return null;
    }

    public static final Byte toByteExactOrNull(double $this$toByteExactOrNull) {
        boolean z = false;
        if (-128.0d <= $this$toByteExactOrNull && $this$toByteExactOrNull <= 127.0d) {
            z = true;
        }
        if (z) {
            return Byte.valueOf((byte) $this$toByteExactOrNull);
        }
        return null;
    }

    public static final Byte toByteExactOrNull(float $this$toByteExactOrNull) {
        boolean z = false;
        if (-128.0f <= $this$toByteExactOrNull && $this$toByteExactOrNull <= 127.0f) {
            z = true;
        }
        if (z) {
            return Byte.valueOf((byte) $this$toByteExactOrNull);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(long $this$toIntExactOrNull) {
        if (new LongRange(-2147483648L, 2147483647L).contains($this$toIntExactOrNull)) {
            return Integer.valueOf((int) $this$toIntExactOrNull);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(double $this$toIntExactOrNull) {
        boolean z = false;
        if (-2.147483648E9d <= $this$toIntExactOrNull && $this$toIntExactOrNull <= 2.147483647E9d) {
            z = true;
        }
        if (z) {
            return Integer.valueOf((int) $this$toIntExactOrNull);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(float $this$toIntExactOrNull) {
        boolean z = false;
        if (-2.14748365E9f <= $this$toIntExactOrNull && $this$toIntExactOrNull <= 2.14748365E9f) {
            z = true;
        }
        if (z) {
            return Integer.valueOf((int) $this$toIntExactOrNull);
        }
        return null;
    }

    public static final Long toLongExactOrNull(double $this$toLongExactOrNull) {
        boolean z = false;
        if (-9.223372036854776E18d <= $this$toLongExactOrNull && $this$toLongExactOrNull <= 9.223372036854776E18d) {
            z = true;
        }
        if (z) {
            return Long.valueOf((long) $this$toLongExactOrNull);
        }
        return null;
    }

    public static final Long toLongExactOrNull(float $this$toLongExactOrNull) {
        boolean z = false;
        if (-9.223372E18f <= $this$toLongExactOrNull && $this$toLongExactOrNull <= 9.223372E18f) {
            z = true;
        }
        if (z) {
            return Long.valueOf($this$toLongExactOrNull);
        }
        return null;
    }

    public static final Short toShortExactOrNull(int $this$toShortExactOrNull) {
        if (new IntRange(-32768, 32767).contains($this$toShortExactOrNull)) {
            return Short.valueOf((short) $this$toShortExactOrNull);
        }
        return null;
    }

    public static final Short toShortExactOrNull(long $this$toShortExactOrNull) {
        if (new LongRange(-32768L, 32767L).contains($this$toShortExactOrNull)) {
            return Short.valueOf((short) $this$toShortExactOrNull);
        }
        return null;
    }

    public static final Short toShortExactOrNull(double $this$toShortExactOrNull) {
        boolean z = false;
        if (-32768.0d <= $this$toShortExactOrNull && $this$toShortExactOrNull <= 32767.0d) {
            z = true;
        }
        if (z) {
            return Short.valueOf((short) $this$toShortExactOrNull);
        }
        return null;
    }

    public static final Short toShortExactOrNull(float $this$toShortExactOrNull) {
        boolean z = false;
        if (-32768.0f <= $this$toShortExactOrNull && $this$toShortExactOrNull <= 32767.0f) {
            z = true;
        }
        if (z) {
            return Short.valueOf((short) $this$toShortExactOrNull);
        }
        return null;
    }

    public static final IntRange until(int $this$until, byte to) {
        return new IntRange($this$until, to - 1);
    }

    public static final LongRange until(long $this$until, byte to) {
        return new LongRange($this$until, to - 1);
    }

    public static final IntRange until(byte $this$until, byte to) {
        return new IntRange($this$until, to - 1);
    }

    public static final IntRange until(short $this$until, byte to) {
        return new IntRange($this$until, to - 1);
    }

    public static final CharRange until(char $this$until, char to) {
        return Intrinsics.compare((int) to, 0) <= 0 ? CharRange.Companion.getEMPTY() : new CharRange($this$until, (char) (to - 1));
    }

    public static final IntRange until(int $this$until, int to) {
        return to <= Integer.MIN_VALUE ? IntRange.Companion.getEMPTY() : new IntRange($this$until, to - 1);
    }

    public static final LongRange until(long $this$until, int to) {
        return new LongRange($this$until, to - 1);
    }

    public static final IntRange until(byte $this$until, int to) {
        return to <= Integer.MIN_VALUE ? IntRange.Companion.getEMPTY() : new IntRange($this$until, to - 1);
    }

    public static final IntRange until(short $this$until, int to) {
        return to <= Integer.MIN_VALUE ? IntRange.Companion.getEMPTY() : new IntRange($this$until, to - 1);
    }

    public static final LongRange until(int $this$until, long to) {
        return to <= Long.MIN_VALUE ? LongRange.Companion.getEMPTY() : new LongRange($this$until, to - 1);
    }

    public static final LongRange until(long $this$until, long to) {
        return to <= Long.MIN_VALUE ? LongRange.Companion.getEMPTY() : new LongRange($this$until, to - 1);
    }

    public static final LongRange until(byte $this$until, long to) {
        return to <= Long.MIN_VALUE ? LongRange.Companion.getEMPTY() : new LongRange($this$until, to - 1);
    }

    public static final LongRange until(short $this$until, long to) {
        return to <= Long.MIN_VALUE ? LongRange.Companion.getEMPTY() : new LongRange($this$until, to - 1);
    }

    public static final IntRange until(int $this$until, short to) {
        return new IntRange($this$until, to - 1);
    }

    public static final LongRange until(long $this$until, short to) {
        return new LongRange($this$until, to - 1);
    }

    public static final IntRange until(byte $this$until, short to) {
        return new IntRange($this$until, to - 1);
    }

    public static final IntRange until(short $this$until, short to) {
        return new IntRange($this$until, to - 1);
    }

    public static final <T extends Comparable<? super T>> T coerceAtLeast(T t, T minimumValue) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(minimumValue, "minimumValue");
        return t.compareTo(minimumValue) < 0 ? minimumValue : t;
    }

    public static final byte coerceAtLeast(byte $this$coerceAtLeast, byte minimumValue) {
        return $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
    }

    public static final short coerceAtLeast(short $this$coerceAtLeast, short minimumValue) {
        return $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
    }

    public static final int coerceAtLeast(int $this$coerceAtLeast, int minimumValue) {
        return $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
    }

    public static final long coerceAtLeast(long $this$coerceAtLeast, long minimumValue) {
        return $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
    }

    public static final float coerceAtLeast(float $this$coerceAtLeast, float minimumValue) {
        return $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
    }

    public static final double coerceAtLeast(double $this$coerceAtLeast, double minimumValue) {
        return $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
    }

    public static final <T extends Comparable<? super T>> T coerceAtMost(T t, T maximumValue) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(maximumValue, "maximumValue");
        return t.compareTo(maximumValue) > 0 ? maximumValue : t;
    }

    public static final byte coerceAtMost(byte $this$coerceAtMost, byte maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }

    public static final short coerceAtMost(short $this$coerceAtMost, short maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }

    public static final int coerceAtMost(int $this$coerceAtMost, int maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }

    public static final long coerceAtMost(long $this$coerceAtMost, long maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }

    public static final float coerceAtMost(float $this$coerceAtMost, float maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }

    public static final double coerceAtMost(double $this$coerceAtMost, double maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, T t2, T t3) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        if (t2 != null && t3 != null) {
            if (t2.compareTo(t3) > 0) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t3 + " is less than minimum " + t2 + '.');
            }
            if (t.compareTo(t2) < 0) {
                return t2;
            }
            if (t.compareTo(t3) > 0) {
                return t3;
            }
        } else if (t2 != null && t.compareTo(t2) < 0) {
            return t2;
        } else {
            if (t3 != null && t.compareTo(t3) > 0) {
                return t3;
            }
        }
        return t;
    }

    public static final byte coerceIn(byte $this$coerceIn, byte minimumValue, byte maximumValue) {
        if (minimumValue <= maximumValue) {
            return $this$coerceIn < minimumValue ? minimumValue : $this$coerceIn > maximumValue ? maximumValue : $this$coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) maximumValue) + " is less than minimum " + ((int) minimumValue) + '.');
    }

    public static final short coerceIn(short $this$coerceIn, short minimumValue, short maximumValue) {
        if (minimumValue <= maximumValue) {
            return $this$coerceIn < minimumValue ? minimumValue : $this$coerceIn > maximumValue ? maximumValue : $this$coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) maximumValue) + " is less than minimum " + ((int) minimumValue) + '.');
    }

    public static final int coerceIn(int $this$coerceIn, int minimumValue, int maximumValue) {
        if (minimumValue <= maximumValue) {
            return $this$coerceIn < minimumValue ? minimumValue : $this$coerceIn > maximumValue ? maximumValue : $this$coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
    }

    public static final long coerceIn(long $this$coerceIn, long minimumValue, long maximumValue) {
        if (minimumValue <= maximumValue) {
            return $this$coerceIn < minimumValue ? minimumValue : $this$coerceIn > maximumValue ? maximumValue : $this$coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
    }

    public static final float coerceIn(float $this$coerceIn, float minimumValue, float maximumValue) {
        if (minimumValue <= maximumValue) {
            return $this$coerceIn < minimumValue ? minimumValue : $this$coerceIn > maximumValue ? maximumValue : $this$coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
    }

    public static final double coerceIn(double $this$coerceIn, double minimumValue, double maximumValue) {
        if (minimumValue <= maximumValue) {
            return $this$coerceIn < minimumValue ? minimumValue : $this$coerceIn > maximumValue ? maximumValue : $this$coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedFloatingPointRange<T> range) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        return (!range.lessThanOrEquals(t, range.getStart()) || range.lessThanOrEquals(range.getStart(), t)) ? (!range.lessThanOrEquals(range.getEndInclusive(), t) || range.lessThanOrEquals(t, range.getEndInclusive())) ? t : range.getEndInclusive() : range.getStart();
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedRange<T> range) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return (T) RangesKt.coerceIn((Comparable) t, (ClosedFloatingPointRange) range);
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        return t.compareTo(range.getStart()) < 0 ? range.getStart() : t.compareTo(range.getEndInclusive()) > 0 ? range.getEndInclusive() : t;
    }

    public static final int coerceIn(int $this$coerceIn, ClosedRange<Integer> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((Number) RangesKt.coerceIn(Integer.valueOf($this$coerceIn), (ClosedFloatingPointRange<Integer>) range)).intValue();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        return $this$coerceIn < range.getStart().intValue() ? range.getStart().intValue() : $this$coerceIn > range.getEndInclusive().intValue() ? range.getEndInclusive().intValue() : $this$coerceIn;
    }

    public static final long coerceIn(long $this$coerceIn, ClosedRange<Long> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((Number) RangesKt.coerceIn(Long.valueOf($this$coerceIn), (ClosedFloatingPointRange<Long>) range)).longValue();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        return $this$coerceIn < range.getStart().longValue() ? range.getStart().longValue() : $this$coerceIn > range.getEndInclusive().longValue() ? range.getEndInclusive().longValue() : $this$coerceIn;
    }
}
