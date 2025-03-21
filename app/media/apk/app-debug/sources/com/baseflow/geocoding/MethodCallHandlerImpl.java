package com.baseflow.geocoding;

import android.location.Address;
import android.util.Log;
import com.baseflow.geocoding.utils.AddressMapper;
import com.baseflow.geocoding.utils.LocaleConverter;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private static final String TAG = "MethodCallHandlerImpl";
    private MethodChannel channel;
    private final Geocoding geocoding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodCallHandlerImpl(Geocoding geocoding) {
        this.geocoding = geocoding;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        char c;
        String str = call.method;
        switch (str.hashCode()) {
            case -1276560131:
                if (str.equals("placemarkFromCoordinates")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -898056143:
                if (str.equals("isPresent")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -533029387:
                if (str.equals("locationFromAddress")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 769355766:
                if (str.equals("placemarkFromAddress")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 930278181:
                if (str.equals("setLocaleIdentifier")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                setLocaleIdentifier(call, result);
                return;
            case 1:
                onLocationFromAddress(call, result);
                return;
            case 2:
                onPlacemarkFromAddress(call, result);
                return;
            case 3:
                onPlacemarkFromCoordinates(call, result);
                return;
            case 4:
                onIsPresent(call, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startListening(BinaryMessenger messenger) {
        if (this.channel != null) {
            Log.wtf(TAG, "Setting a method call handler before the last was disposed.");
            stopListening();
        }
        BinaryMessenger.TaskQueue taskQueue = messenger.makeBackgroundTaskQueue();
        MethodChannel methodChannel = new MethodChannel(messenger, "flutter.baseflow.com/geocoding", StandardMethodCodec.INSTANCE, taskQueue);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopListening() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Log.d(TAG, "Tried to stop listening when no MethodChannel had been initialized.");
            return;
        }
        methodChannel.setMethodCallHandler(null);
        this.channel = null;
    }

    private void setLocaleIdentifier(MethodCall call, MethodChannel.Result result) {
        String languageTag = (String) call.argument("localeIdentifier");
        this.geocoding.setLocaleIdentifier(LocaleConverter.fromLanguageTag(languageTag));
        result.success(true);
    }

    private void onLocationFromAddress(MethodCall call, final MethodChannel.Result result) {
        final String address = (String) call.argument("address");
        if (address == null || address.isEmpty()) {
            result.error("ARGUMENT_ERROR", "Supply a valid value for the 'address' parameter.", null);
        }
        this.geocoding.placemarkFromAddress(address, new GeocodeListenerAdapter() { // from class: com.baseflow.geocoding.MethodCallHandlerImpl.1
            @Override // com.baseflow.geocoding.GeocodeListenerAdapter
            public void onGeocode(List<Address> addresses) {
                if (addresses != null && addresses.size() > 0) {
                    result.success(AddressMapper.toLocationHashMapList(addresses));
                } else {
                    result.error("NOT_FOUND", String.format("No coordinates found for '%s'", address), null);
                }
            }

            @Override // com.baseflow.geocoding.GeocodeListenerAdapter
            public void onError(String errorMessage) {
                result.error("IO_ERROR", String.format(errorMessage, new Object[0]), null);
            }
        });
    }

    private void onPlacemarkFromAddress(MethodCall call, final MethodChannel.Result result) {
        final String address = (String) call.argument("address");
        if (address == null || address.isEmpty()) {
            result.error("ARGUMENT_ERROR", "Supply a valid value for the 'address' parameter.", null);
        }
        this.geocoding.placemarkFromAddress(address, new GeocodeListenerAdapter() { // from class: com.baseflow.geocoding.MethodCallHandlerImpl.2
            @Override // com.baseflow.geocoding.GeocodeListenerAdapter
            public void onGeocode(List<Address> addresses) {
                if (addresses != null && addresses.size() > 0) {
                    result.success(AddressMapper.toAddressHashMapList(addresses));
                } else {
                    result.error("NOT_FOUND", String.format("No coordinates found for '%s'", address), null);
                }
            }

            @Override // com.baseflow.geocoding.GeocodeListenerAdapter
            public void onError(String errorMessage) {
                result.error("IO_ERROR", String.format(errorMessage, new Object[0]), null);
            }
        });
    }

    private void onPlacemarkFromCoordinates(MethodCall call, final MethodChannel.Result result) {
        final double latitude = ((Double) call.argument("latitude")).doubleValue();
        final double longitude = ((Double) call.argument("longitude")).doubleValue();
        this.geocoding.placemarkFromCoordinates(latitude, longitude, new GeocodeListenerAdapter() { // from class: com.baseflow.geocoding.MethodCallHandlerImpl.3
            @Override // com.baseflow.geocoding.GeocodeListenerAdapter
            public void onGeocode(List<Address> addresses) {
                if (addresses != null && addresses.size() > 0) {
                    result.success(AddressMapper.toAddressHashMapList(addresses));
                } else {
                    result.error("NOT_FOUND", String.format(Locale.ENGLISH, "No address information found for supplied coordinates (latitude: %f, longitude: %f).", Double.valueOf(latitude), Double.valueOf(longitude)), null);
                }
            }

            @Override // com.baseflow.geocoding.GeocodeListenerAdapter
            public void onError(String errorMessage) {
                result.error("IO_ERROR", String.format(errorMessage, new Object[0]), null);
            }
        });
    }

    private void onIsPresent(MethodCall call, MethodChannel.Result result) {
        boolean isPresent = this.geocoding.isPresent();
        result.success(Boolean.valueOf(isPresent));
    }
}
