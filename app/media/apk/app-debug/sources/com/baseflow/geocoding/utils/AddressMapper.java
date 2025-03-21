package com.baseflow.geocoding.utils;

import android.location.Address;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class AddressMapper {
    public static List<Map<String, Object>> toAddressHashMapList(List<Address> addresses) {
        List<Map<String, Object>> hashMaps = new ArrayList<>(addresses.size());
        for (Address address : addresses) {
            Map<String, Object> hashMap = toAddressHashMap(address);
            hashMaps.add(hashMap);
        }
        return hashMaps;
    }

    private static Map<String, Object> toAddressHashMap(Address address) {
        Map<String, Object> placemark = new HashMap<>();
        String street = AddressLineParser.getStreet(address.getAddressLine(0));
        placemark.put("name", address.getFeatureName());
        placemark.put("street", street);
        placemark.put("isoCountryCode", address.getCountryCode());
        placemark.put("country", address.getCountryName());
        placemark.put("thoroughfare", address.getThoroughfare());
        placemark.put("subThoroughfare", address.getSubThoroughfare());
        placemark.put("postalCode", address.getPostalCode());
        placemark.put("administrativeArea", address.getAdminArea());
        placemark.put("subAdministrativeArea", address.getSubAdminArea());
        placemark.put("locality", address.getLocality());
        placemark.put("subLocality", address.getSubLocality());
        return placemark;
    }

    public static List<Map<String, Object>> toLocationHashMapList(List<Address> addresses) {
        List<Map<String, Object>> hashMaps = new ArrayList<>(addresses.size());
        for (Address address : addresses) {
            Map<String, Object> hashMap = toLocationHashmap(address);
            hashMaps.add(hashMap);
        }
        return hashMaps;
    }

    private static Map<String, Object> toLocationHashmap(Address address) {
        Map<String, Object> location = new HashMap<>();
        location.put("latitude", Double.valueOf(address.getLatitude()));
        location.put("longitude", Double.valueOf(address.getLongitude()));
        location.put("timestamp", Long.valueOf(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis()));
        return location;
    }
}
