package com.google.maps.android;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
/* compiled from: StreetViewUtil.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/maps/android/StreetViewUtils;", "", "()V", "Companion", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class StreetViewUtils {
    public static final Companion Companion = new Companion(null);

    /* compiled from: StreetViewUtil.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/google/maps/android/StreetViewUtils$Companion;", "", "()V", "deserializeResponse", "Lcom/google/maps/android/ResponseStreetView;", "responseString", "", "fetchStreetViewData", "Lcom/google/maps/android/Status;", "latLng", "Lcom/google/android/gms/maps/model/LatLng;", "apiKey", "(Lcom/google/android/gms/maps/model/LatLng;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object fetchStreetViewData(LatLng latLng, String apiKey, Continuation<? super Status> continuation) {
            String urlString = "https://maps.googleapis.com/maps/api/streetview/metadata?location=" + latLng.latitude + ',' + latLng.longitude + "&key=" + apiKey;
            return BuildersKt.withContext(Dispatchers.getIO(), new StreetViewUtils$Companion$fetchStreetViewData$2(urlString, null), continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ResponseStreetView deserializeResponse(String responseString) {
            JSONObject jsonObject = new JSONObject(responseString);
            String statusString = jsonObject.optString(NotificationCompat.CATEGORY_STATUS);
            Intrinsics.checkNotNullExpressionValue(statusString, "statusString");
            Status status = Status.valueOf(statusString);
            return new ResponseStreetView(status);
        }
    }
}
