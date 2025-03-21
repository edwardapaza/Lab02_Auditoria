package com.google.firebase.installations.local;

import com.google.firebase.FirebaseApp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PersistedInstallation {
    private static final String AUTH_TOKEN_KEY = "AuthToken";
    private static final String EXPIRES_IN_SECONDS_KEY = "ExpiresInSecs";
    private static final String FIREBASE_INSTALLATION_ID_KEY = "Fid";
    private static final String FIS_ERROR_KEY = "FisError";
    private static final String PERSISTED_STATUS_KEY = "Status";
    private static final String REFRESH_TOKEN_KEY = "RefreshToken";
    private static final String SETTINGS_FILE_NAME_PREFIX = "PersistedInstallation";
    private static final String TOKEN_CREATION_TIME_IN_SECONDS_KEY = "TokenCreationEpochInSecs";
    private File dataFile;
    private final FirebaseApp firebaseApp;

    /* loaded from: classes.dex */
    public enum RegistrationStatus {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public PersistedInstallation(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    private File getDataFile() {
        if (this.dataFile == null) {
            synchronized (this) {
                if (this.dataFile == null) {
                    this.dataFile = new File(this.firebaseApp.getApplicationContext().getFilesDir(), "PersistedInstallation." + this.firebaseApp.getPersistenceKey() + ".json");
                }
            }
        }
        return this.dataFile;
    }

    public PersistedInstallationEntry readPersistedInstallationEntryValue() {
        JSONObject json = readJSONFromFile();
        String fid = json.optString(FIREBASE_INSTALLATION_ID_KEY, null);
        int status = json.optInt(PERSISTED_STATUS_KEY, RegistrationStatus.ATTEMPT_MIGRATION.ordinal());
        String authToken = json.optString(AUTH_TOKEN_KEY, null);
        String refreshToken = json.optString(REFRESH_TOKEN_KEY, null);
        long tokenCreationTime = json.optLong(TOKEN_CREATION_TIME_IN_SECONDS_KEY, 0L);
        long expiresIn = json.optLong(EXPIRES_IN_SECONDS_KEY, 0L);
        String fisError = json.optString(FIS_ERROR_KEY, null);
        PersistedInstallationEntry prefs = PersistedInstallationEntry.builder().setFirebaseInstallationId(fid).setRegistrationStatus(RegistrationStatus.values()[status]).setAuthToken(authToken).setRefreshToken(refreshToken).setTokenCreationEpochInSecs(tokenCreationTime).setExpiresInSecs(expiresIn).setFisError(fisError).build();
        return prefs;
    }

    private JSONObject readJSONFromFile() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] tmpBuf = new byte[16384];
        try {
            FileInputStream fis = new FileInputStream(getDataFile());
            while (true) {
                try {
                    int numRead = fis.read(tmpBuf, 0, tmpBuf.length);
                    if (numRead >= 0) {
                        baos.write(tmpBuf, 0, numRead);
                    } else {
                        JSONObject jSONObject = new JSONObject(baos.toString());
                        fis.close();
                        return jSONObject;
                    }
                } catch (Throwable th) {
                    try {
                        fis.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        } catch (IOException | JSONException e) {
            return new JSONObject();
        }
    }

    public PersistedInstallationEntry insertOrUpdatePersistedInstallationEntry(PersistedInstallationEntry prefs) {
        File tmpFile;
        try {
            JSONObject json = new JSONObject();
            json.put(FIREBASE_INSTALLATION_ID_KEY, prefs.getFirebaseInstallationId());
            json.put(PERSISTED_STATUS_KEY, prefs.getRegistrationStatus().ordinal());
            json.put(AUTH_TOKEN_KEY, prefs.getAuthToken());
            json.put(REFRESH_TOKEN_KEY, prefs.getRefreshToken());
            json.put(TOKEN_CREATION_TIME_IN_SECONDS_KEY, prefs.getTokenCreationEpochInSecs());
            json.put(EXPIRES_IN_SECONDS_KEY, prefs.getExpiresInSecs());
            json.put(FIS_ERROR_KEY, prefs.getFisError());
            tmpFile = File.createTempFile(SETTINGS_FILE_NAME_PREFIX, "tmp", this.firebaseApp.getApplicationContext().getFilesDir());
            FileOutputStream fos = new FileOutputStream(tmpFile);
            fos.write(json.toString().getBytes("UTF-8"));
            fos.close();
        } catch (IOException e) {
        } catch (JSONException e2) {
        }
        if (!tmpFile.renameTo(getDataFile())) {
            throw new IOException("unable to rename the tmpfile to PersistedInstallation");
        }
        return prefs;
    }

    public void clearForTesting() {
        getDataFile().delete();
    }
}
