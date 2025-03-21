package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;
/* loaded from: classes.dex */
final class AutoValue_LibraryVersion extends LibraryVersion {
    private final String libraryName;
    private final String version;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LibraryVersion(String libraryName, String version) {
        if (libraryName == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.libraryName = libraryName;
        if (version == null) {
            throw new NullPointerException("Null version");
        }
        this.version = version;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    @Nonnull
    public String getLibraryName() {
        return this.libraryName;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    @Nonnull
    public String getVersion() {
        return this.version;
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.libraryName + ", version=" + this.version + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof LibraryVersion) {
            LibraryVersion that = (LibraryVersion) o;
            return this.libraryName.equals(that.getLibraryName()) && this.version.equals(that.getVersion());
        }
        return false;
    }

    public int hashCode() {
        int h$ = 1 * 1000003;
        return ((h$ ^ this.libraryName.hashCode()) * 1000003) ^ this.version.hashCode();
    }
}
