package com.baseflow.geocoding;

import android.location.Address;
import java.util.List;
/* loaded from: classes2.dex */
public interface GeocodeListenerAdapter {
    void onError(String str);

    void onGeocode(List<Address> list);
}
