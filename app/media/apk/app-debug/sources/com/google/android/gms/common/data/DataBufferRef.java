package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
/* compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* loaded from: classes.dex */
public abstract class DataBufferRef {
    protected final DataHolder mDataHolder;
    protected int mDataRow;
    private int zaa;

    public DataBufferRef(DataHolder holder, int dataRow) {
        this.mDataHolder = (DataHolder) Preconditions.checkNotNull(holder);
        zaa(dataRow);
    }

    protected void copyToBuffer(String column, CharArrayBuffer dataOut) {
        this.mDataHolder.zac(column, this.mDataRow, this.zaa, dataOut);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (Objects.equal(Integer.valueOf(dataBufferRef.mDataRow), Integer.valueOf(this.mDataRow)) && Objects.equal(Integer.valueOf(dataBufferRef.zaa), Integer.valueOf(this.zaa)) && dataBufferRef.mDataHolder == this.mDataHolder) {
                return true;
            }
        }
        return false;
    }

    protected boolean getBoolean(String column) {
        return this.mDataHolder.getBoolean(column, this.mDataRow, this.zaa);
    }

    protected byte[] getByteArray(String column) {
        return this.mDataHolder.getByteArray(column, this.mDataRow, this.zaa);
    }

    protected int getDataRow() {
        return this.mDataRow;
    }

    protected double getDouble(String column) {
        return this.mDataHolder.zaa(column, this.mDataRow, this.zaa);
    }

    protected float getFloat(String column) {
        return this.mDataHolder.zab(column, this.mDataRow, this.zaa);
    }

    protected int getInteger(String column) {
        return this.mDataHolder.getInteger(column, this.mDataRow, this.zaa);
    }

    protected long getLong(String column) {
        return this.mDataHolder.getLong(column, this.mDataRow, this.zaa);
    }

    protected String getString(String column) {
        return this.mDataHolder.getString(column, this.mDataRow, this.zaa);
    }

    public boolean hasColumn(String column) {
        return this.mDataHolder.hasColumn(column);
    }

    protected boolean hasNull(String column) {
        return this.mDataHolder.hasNull(column, this.mDataRow, this.zaa);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.zaa), this.mDataHolder);
    }

    public boolean isDataValid() {
        return !this.mDataHolder.isClosed();
    }

    protected Uri parseUri(String column) {
        String string = this.mDataHolder.getString(column, this.mDataRow, this.zaa);
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zaa(int i) {
        boolean z = false;
        if (i >= 0 && i < this.mDataHolder.getCount()) {
            z = true;
        }
        Preconditions.checkState(z);
        this.mDataRow = i;
        this.zaa = this.mDataHolder.getWindowIndex(i);
    }
}
