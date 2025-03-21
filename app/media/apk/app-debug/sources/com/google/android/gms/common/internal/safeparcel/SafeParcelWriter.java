package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(Parcel p) {
        return zza(p, 20293);
    }

    public static void finishObjectHeader(Parcel p, int start) {
        zzb(p, start);
    }

    public static void writeBigDecimal(Parcel p, int id, BigDecimal val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeByteArray(val.unscaledValue().toByteArray());
        p.writeInt(val.scale());
        zzb(p, zza);
    }

    public static void writeBigDecimalArray(Parcel p, int id, BigDecimal[] val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int length = val.length;
        p.writeInt(length);
        for (int i = 0; i < length; i++) {
            p.writeByteArray(val[i].unscaledValue().toByteArray());
            p.writeInt(val[i].scale());
        }
        zzb(p, zza);
    }

    public static void writeBigInteger(Parcel p, int id, BigInteger val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeByteArray(val.toByteArray());
        zzb(p, zza);
    }

    public static void writeBigIntegerArray(Parcel p, int id, BigInteger[] val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeInt(val.length);
        for (BigInteger bigInteger : val) {
            p.writeByteArray(bigInteger.toByteArray());
        }
        zzb(p, zza);
    }

    public static void writeBoolean(Parcel p, int id, boolean val) {
        zzc(p, id, 4);
        p.writeInt(val ? 1 : 0);
    }

    public static void writeBooleanArray(Parcel p, int id, boolean[] val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeBooleanArray(val);
        zzb(p, zza);
    }

    public static void writeBooleanList(Parcel p, int id, List<Boolean> list, boolean writeNull) {
        if (list == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = list.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeInt(list.get(i).booleanValue() ? 1 : 0);
        }
        zzb(p, zza);
    }

    public static void writeBooleanObject(Parcel p, int id, Boolean val, boolean writeNull) {
        if (val != null) {
            zzc(p, id, 4);
            p.writeInt(val.booleanValue() ? 1 : 0);
        } else if (writeNull) {
            zzc(p, id, 0);
        }
    }

    public static void writeBundle(Parcel p, int id, Bundle val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeBundle(val);
        zzb(p, zza);
    }

    public static void writeByte(Parcel p, int id, byte val) {
        zzc(p, id, 4);
        p.writeInt(val);
    }

    public static void writeByteArray(Parcel p, int id, byte[] buf, boolean writeNull) {
        if (buf == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeByteArray(buf);
        zzb(p, zza);
    }

    public static void writeByteArrayArray(Parcel p, int id, byte[][] buf, boolean writeNull) {
        if (buf == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeInt(buf.length);
        for (byte[] bArr : buf) {
            p.writeByteArray(bArr);
        }
        zzb(p, zza);
    }

    public static void writeByteArraySparseArray(Parcel p, int id, SparseArray<byte[]> sparseArray, boolean writeNull) {
        if (sparseArray == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = sparseArray.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeInt(sparseArray.keyAt(i));
            p.writeByteArray(sparseArray.valueAt(i));
        }
        zzb(p, zza);
    }

    public static void writeChar(Parcel p, int id, char val) {
        zzc(p, id, 4);
        p.writeInt(val);
    }

    public static void writeCharArray(Parcel p, int id, char[] val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeCharArray(val);
        zzb(p, zza);
    }

    public static void writeDouble(Parcel p, int id, double val) {
        zzc(p, id, 8);
        p.writeDouble(val);
    }

    public static void writeDoubleArray(Parcel p, int id, double[] val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeDoubleArray(val);
        zzb(p, zza);
    }

    public static void writeDoubleList(Parcel p, int id, List<Double> list, boolean writeNull) {
        if (list == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = list.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeDouble(list.get(i).doubleValue());
        }
        zzb(p, zza);
    }

    public static void writeDoubleObject(Parcel p, int id, Double val, boolean writeNull) {
        if (val != null) {
            zzc(p, id, 8);
            p.writeDouble(val.doubleValue());
        } else if (writeNull) {
            zzc(p, id, 0);
        }
    }

    public static void writeDoubleSparseArray(Parcel p, int id, SparseArray<Double> sparseArray, boolean writeNull) {
        if (sparseArray == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = sparseArray.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeInt(sparseArray.keyAt(i));
            p.writeDouble(sparseArray.valueAt(i).doubleValue());
        }
        zzb(p, zza);
    }

    public static void writeFloat(Parcel p, int id, float val) {
        zzc(p, id, 4);
        p.writeFloat(val);
    }

    public static void writeFloatArray(Parcel p, int id, float[] val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeFloatArray(val);
        zzb(p, zza);
    }

    public static void writeFloatList(Parcel p, int id, List<Float> list, boolean writeNull) {
        if (list == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = list.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeFloat(list.get(i).floatValue());
        }
        zzb(p, zza);
    }

    public static void writeFloatObject(Parcel p, int id, Float val, boolean writeNull) {
        if (val != null) {
            zzc(p, id, 4);
            p.writeFloat(val.floatValue());
        } else if (writeNull) {
            zzc(p, id, 0);
        }
    }

    public static void writeFloatSparseArray(Parcel p, int id, SparseArray<Float> sparseArray, boolean writeNull) {
        if (sparseArray == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = sparseArray.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeInt(sparseArray.keyAt(i));
            p.writeFloat(sparseArray.valueAt(i).floatValue());
        }
        zzb(p, zza);
    }

    public static void writeIBinder(Parcel p, int id, IBinder val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeStrongBinder(val);
        zzb(p, zza);
    }

    public static void writeIBinderArray(Parcel p, int id, IBinder[] val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeBinderArray(val);
        zzb(p, zza);
    }

    public static void writeIBinderList(Parcel p, int id, List<IBinder> list, boolean writeNull) {
        if (list == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeBinderList(list);
        zzb(p, zza);
    }

    public static void writeIBinderSparseArray(Parcel p, int id, SparseArray<IBinder> sparseArray, boolean writeNull) {
        if (sparseArray == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = sparseArray.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeInt(sparseArray.keyAt(i));
            p.writeStrongBinder(sparseArray.valueAt(i));
        }
        zzb(p, zza);
    }

    public static void writeInt(Parcel p, int id, int val) {
        zzc(p, id, 4);
        p.writeInt(val);
    }

    public static void writeIntArray(Parcel p, int id, int[] val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeIntArray(val);
        zzb(p, zza);
    }

    public static void writeIntegerList(Parcel p, int id, List<Integer> list, boolean writeNull) {
        if (list == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = list.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeInt(list.get(i).intValue());
        }
        zzb(p, zza);
    }

    public static void writeIntegerObject(Parcel p, int id, Integer val, boolean writeNull) {
        if (val != null) {
            zzc(p, id, 4);
            p.writeInt(val.intValue());
        } else if (writeNull) {
            zzc(p, id, 0);
        }
    }

    public static void writeList(Parcel p, int id, List list, boolean writeNull) {
        if (list == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeList(list);
        zzb(p, zza);
    }

    public static void writeLong(Parcel p, int id, long val) {
        zzc(p, id, 8);
        p.writeLong(val);
    }

    public static void writeLongArray(Parcel p, int id, long[] val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeLongArray(val);
        zzb(p, zza);
    }

    public static void writeLongList(Parcel p, int id, List<Long> list, boolean writeNull) {
        if (list == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = list.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeLong(list.get(i).longValue());
        }
        zzb(p, zza);
    }

    public static void writeLongObject(Parcel p, int id, Long val, boolean writeNull) {
        if (val != null) {
            zzc(p, id, 8);
            p.writeLong(val.longValue());
        } else if (writeNull) {
            zzc(p, id, 0);
        }
    }

    public static void writeParcel(Parcel p, int id, Parcel val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.appendFrom(val, 0, val.dataSize());
        zzb(p, zza);
    }

    public static void writeParcelArray(Parcel p, int id, Parcel[] val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeInt(val.length);
        for (Parcel parcel : val) {
            if (parcel != null) {
                p.writeInt(parcel.dataSize());
                p.appendFrom(parcel, 0, parcel.dataSize());
            } else {
                p.writeInt(0);
            }
        }
        zzb(p, zza);
    }

    public static void writeParcelList(Parcel p, int id, List<Parcel> list, boolean writeNull) {
        if (list == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = list.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            Parcel parcel = list.get(i);
            if (parcel != null) {
                p.writeInt(parcel.dataSize());
                p.appendFrom(parcel, 0, parcel.dataSize());
            } else {
                p.writeInt(0);
            }
        }
        zzb(p, zza);
    }

    public static void writeParcelSparseArray(Parcel p, int id, SparseArray<Parcel> sparseArray, boolean writeNull) {
        if (sparseArray == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = sparseArray.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeInt(sparseArray.keyAt(i));
            Parcel valueAt = sparseArray.valueAt(i);
            if (valueAt != null) {
                p.writeInt(valueAt.dataSize());
                p.appendFrom(valueAt, 0, valueAt.dataSize());
            } else {
                p.writeInt(0);
            }
        }
        zzb(p, zza);
    }

    public static void writeParcelable(Parcel p, int id, Parcelable val, int parcelableFlags, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        val.writeToParcel(p, parcelableFlags);
        zzb(p, zza);
    }

    public static void writePendingIntent(Parcel p, int id, PendingIntent val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        PendingIntent.writePendingIntentOrNullToParcel(val, p);
        zzb(p, zza);
    }

    public static void writeShort(Parcel p, int id, short val) {
        zzc(p, id, 4);
        p.writeInt(val);
    }

    public static void writeSparseBooleanArray(Parcel p, int id, SparseBooleanArray val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeSparseBooleanArray(val);
        zzb(p, zza);
    }

    public static void writeSparseIntArray(Parcel p, int id, SparseIntArray val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = val.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeInt(val.keyAt(i));
            p.writeInt(val.valueAt(i));
        }
        zzb(p, zza);
    }

    public static void writeSparseLongArray(Parcel p, int id, SparseLongArray val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = val.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeInt(val.keyAt(i));
            p.writeLong(val.valueAt(i));
        }
        zzb(p, zza);
    }

    public static void writeString(Parcel p, int id, String val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeString(val);
        zzb(p, zza);
    }

    public static void writeStringArray(Parcel p, int id, String[] val, boolean writeNull) {
        if (val == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeStringArray(val);
        zzb(p, zza);
    }

    public static void writeStringList(Parcel p, int id, List<String> list, boolean writeNull) {
        if (list == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeStringList(list);
        zzb(p, zza);
    }

    public static void writeStringSparseArray(Parcel p, int id, SparseArray<String> sparseArray, boolean writeNull) {
        if (sparseArray == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = sparseArray.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeInt(sparseArray.keyAt(i));
            p.writeString(sparseArray.valueAt(i));
        }
        zzb(p, zza);
    }

    public static <T extends Parcelable> void writeTypedArray(Parcel p, int id, T[] tArr, int parcelableFlags, boolean writeNull) {
        if (tArr == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        p.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                p.writeInt(0);
            } else {
                zzd(p, t, parcelableFlags);
            }
        }
        zzb(p, zza);
    }

    public static <T extends Parcelable> void writeTypedList(Parcel p, int id, List<T> list, boolean writeNull) {
        if (list == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = list.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            if (t == null) {
                p.writeInt(0);
            } else {
                zzd(p, t, 0);
            }
        }
        zzb(p, zza);
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel p, int id, SparseArray<T> sparseArray, boolean writeNull) {
        if (sparseArray == null) {
            if (writeNull) {
                zzc(p, id, 0);
                return;
            }
            return;
        }
        int zza = zza(p, id);
        int size = sparseArray.size();
        p.writeInt(size);
        for (int i = 0; i < size; i++) {
            p.writeInt(sparseArray.keyAt(i));
            T valueAt = sparseArray.valueAt(i);
            if (valueAt == null) {
                p.writeInt(0);
            } else {
                zzd(p, valueAt, 0);
            }
        }
        zzb(p, zza);
    }

    private static int zza(Parcel parcel, int i) {
        parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzb(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    private static void zzc(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    private static void zzd(Parcel parcel, Parcelable parcelable, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
