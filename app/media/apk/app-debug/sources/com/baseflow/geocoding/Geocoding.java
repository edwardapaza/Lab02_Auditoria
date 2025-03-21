package com.baseflow.geocoding;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
class Geocoding {
    private final Context androidContext;
    private Locale locale;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Geocoding(Context androidContext) {
        this.androidContext = androidContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLocaleIdentifier(Locale locale) {
        this.locale = locale;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPresent() {
        return Geocoder.isPresent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void placemarkFromAddress(String address, GeocodeListenerAdapter callback) {
        Geocoder geocoder = createGeocoder(this.androidContext, this.locale);
        if (Build.VERSION.SDK_INT >= 33) {
            getAddressesWithGeocodeListener(geocoder, address, 5, callback);
            return;
        }
        try {
            List<Address> addresses = deprecatedGetFromLocationName(geocoder, address);
            callback.onGeocode(addresses);
        } catch (IOException ex) {
            callback.onError(ex.getMessage());
        }
    }

    private List<Address> deprecatedGetFromLocationName(Geocoder geocoder, String address) throws IOException {
        return geocoder.getFromLocationName(address, 5);
    }

    private void getAddressesWithGeocodeListener(Geocoder geocoder, String address, int maxResults, final GeocodeListenerAdapter callback) {
        geocoder.getFromLocationName(address, maxResults, new Geocoder.GeocodeListener() { // from class: com.baseflow.geocoding.Geocoding.1
            public void onGeocode(List<Address> geocodedAddresses) {
                callback.onGeocode(geocodedAddresses);
            }

            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void placemarkFromCoordinates(double latitude, double longitude, GeocodeListenerAdapter callback) {
        Geocoder geocoder = createGeocoder(this.androidContext, this.locale);
        if (Build.VERSION.SDK_INT >= 33) {
            getLocationWithGeocodeListener(geocoder, latitude, longitude, 5, callback);
            return;
        }
        try {
            List<Address> addresses = deprecatedGetFromLocation(geocoder, latitude, longitude);
            callback.onGeocode(addresses);
        } catch (IOException ex) {
            callback.onError(ex.getMessage());
        }
    }

    private List<Address> deprecatedGetFromLocation(Geocoder geocoder, double latitude, double longitude) throws IOException {
        return geocoder.getFromLocation(latitude, longitude, 5);
    }

    private void getLocationWithGeocodeListener(Geocoder geocoder, double latitude, double longitude, int maxResults, final GeocodeListenerAdapter callback) {
        geocoder.getFromLocation(latitude, longitude, maxResults, new Geocoder.GeocodeListener() { // from class: com.baseflow.geocoding.Geocoding.2
            public void onGeocode(List<Address> geocodedAddresses) {
                callback.onGeocode(geocodedAddresses);
            }

            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        });
    }

    private static Geocoder createGeocoder(Context androidContext, Locale locale) {
        if (locale != null) {
            return new Geocoder(androidContext, locale);
        }
        return new Geocoder(androidContext);
    }
}
