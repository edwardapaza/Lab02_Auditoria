package com.baseflow.geolocator.location;

import java.util.Map;
/* loaded from: classes2.dex */
public class AndroidIconResource {
    private final String defType;
    private final String name;

    public static AndroidIconResource parseArguments(Map<String, Object> arguments) {
        if (arguments == null) {
            return null;
        }
        String name = (String) arguments.get("name");
        String defType = (String) arguments.get("defType");
        return new AndroidIconResource(name, defType);
    }

    private AndroidIconResource(String name, String defType) {
        this.name = name;
        this.defType = defType;
    }

    public String getName() {
        return this.name;
    }

    public String getDefType() {
        return this.defType;
    }
}
