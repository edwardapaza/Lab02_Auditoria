package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.DispatchedContinuation;
/* compiled from: CancellableContinuation.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u001a3\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\n\u001a3\u0010\u000b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0007H\u0080Hø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0018\u0010\f\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"getOrCreateCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", ExifInterface.GPS_DIRECTION_TRUE, "delegate", "Lkotlin/coroutines/Continuation;", "suspendCancellableCoroutine", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendCancellableCoroutineReusable", "disposeOnCancellation", "handle", "Lkotlinx/coroutines/DisposableHandle;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CancellableContinuationKt {
    public static final <T> Object suspendCancellableCoroutine(Function1<? super CancellableContinuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellable = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable.initCancellability();
        function1.invoke(cancellable);
        Object result = cancellable.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private static final <T> Object suspendCancellableCoroutine$$forInline(Function1<? super CancellableContinuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        InlineMarker.mark(0);
        Continuation<? super T> uCont = continuation;
        CancellableContinuationImpl cancellable = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont), 1);
        cancellable.initCancellability();
        function1.invoke(cancellable);
        Object result = cancellable.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static final <T> Object suspendCancellableCoroutineReusable(Function1<? super CancellableContinuationImpl<? super T>, Unit> function1, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellable = getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            function1.invoke(cancellable);
            Object result = cancellable.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } catch (Throwable e) {
            cancellable.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw e;
        }
    }

    private static final <T> Object suspendCancellableCoroutineReusable$$forInline(Function1<? super CancellableContinuationImpl<? super T>, Unit> function1, Continuation<? super T> continuation) {
        InlineMarker.mark(0);
        Continuation<? super T> uCont = continuation;
        CancellableContinuationImpl cancellable = getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(uCont));
        try {
            function1.invoke(cancellable);
            Object result = cancellable.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            InlineMarker.mark(1);
            return result;
        } catch (Throwable e) {
            cancellable.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw e;
        }
    }

    public static final <T> CancellableContinuationImpl<T> getOrCreateCancellableContinuation(Continuation<? super T> continuation) {
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl<>(continuation, 1);
        }
        CancellableContinuationImpl it = ((DispatchedContinuation) continuation).claimReusableCancellableContinuation$kotlinx_coroutines_core();
        if (it != null) {
            if (!it.resetStateReusable()) {
                it = null;
            }
            if (it != null) {
                return it;
            }
        }
        return new CancellableContinuationImpl<>(continuation, 2);
    }

    public static final void disposeOnCancellation(CancellableContinuation<?> cancellableContinuation, DisposableHandle handle) {
        CancelHandlerBase $this$asHandler$iv = new DisposeOnCancel(handle);
        cancellableContinuation.invokeOnCancellation($this$asHandler$iv);
    }
}
