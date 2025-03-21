package com.baseflow.geolocator.location;

import com.baseflow.geolocator.errors.ErrorCodes;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes2.dex */
public class FlutterLocationServiceListener implements LocationServiceListener {
    private MethodChannel.Result result;

    public FlutterLocationServiceListener(MethodChannel.Result result) {
        this.result = result;
    }

    @Override // com.baseflow.geolocator.location.LocationServiceListener
    public void onLocationServiceResult(boolean isEnabled) {
        this.result.success(Boolean.valueOf(isEnabled));
    }

    @Override // com.baseflow.geolocator.location.LocationServiceListener
    public void onLocationServiceError(ErrorCodes errorCode) {
        this.result.error(errorCode.toString(), errorCode.toDescription(), null);
    }
}
