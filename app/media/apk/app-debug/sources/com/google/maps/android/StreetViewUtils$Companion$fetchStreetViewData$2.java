package com.google.maps.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: StreetViewUtil.kt */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/google/maps/android/Status;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.google.maps.android.StreetViewUtils$Companion$fetchStreetViewData$2", f = "StreetViewUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class StreetViewUtils$Companion$fetchStreetViewData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Status>, Object> {
    final /* synthetic */ String $urlString;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreetViewUtils$Companion$fetchStreetViewData$2(String str, Continuation<? super StreetViewUtils$Companion$fetchStreetViewData$2> continuation) {
        super(2, continuation);
        this.$urlString = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreetViewUtils$Companion$fetchStreetViewData$2(this.$urlString, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Status> continuation) {
        return ((StreetViewUtils$Companion$fetchStreetViewData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResponseStreetView deserializeResponse;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    URL url = new URL(this.$urlString);
                    URLConnection openConnection = url.openConnection();
                    Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                    HttpURLConnection connection = (HttpURLConnection) openConnection;
                    connection.setRequestMethod("GET");
                    int responseCode = connection.getResponseCode();
                    if (responseCode == 200) {
                        InputStream inputStream = connection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        BufferedReader bufferedReader2 = bufferedReader;
                        BufferedReader it = bufferedReader2;
                        String responseString = TextStreamsKt.readText(it);
                        CloseableKt.closeFinally(bufferedReader2, null);
                        bufferedReader.close();
                        inputStream.close();
                        deserializeResponse = StreetViewUtils.Companion.deserializeResponse(responseString);
                        return deserializeResponse.getStatus();
                    }
                    throw new IOException("HTTP Error: " + responseCode);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new IOException("Network error: " + e.getMessage());
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
