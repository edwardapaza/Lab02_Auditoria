package com.google.android.gms.internal.p001firebaseauthapi;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalh  reason: invalid package */
/* loaded from: classes.dex */
public class zzalh<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zza;
    private List<zzalo> zzb;
    private Map<K, V> zzc;
    private boolean zzd;
    private volatile zzalt zze;
    private Map<K, V> zzf;
    private volatile zzall zzg;

    private zzalh(int i5) {
        this.zza = i5;
        this.zzb = Collections.emptyList();
        this.zzc = Collections.emptyMap();
        this.zzf = Collections.emptyMap();
    }

    private final int zza(K k5) {
        int size = this.zzb.size() - 1;
        if (size >= 0) {
            int compareTo = k5.compareTo((Comparable) this.zzb.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i5 = 0;
        while (i5 <= size) {
            int i6 = (i5 + size) / 2;
            int compareTo2 = k5.compareTo((Comparable) this.zzb.get(i6).getKey());
            if (compareTo2 < 0) {
                size = i6 - 1;
            } else if (compareTo2 <= 0) {
                return i6;
            } else {
                i5 = i6 + 1;
            }
        }
        return -(i5 + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends zzaiu<FieldDescriptorType>> zzalh<FieldDescriptorType, Object> zza(int i5) {
        return new zzalg(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzc(int i5) {
        zzg();
        V v5 = (V) this.zzb.remove(i5).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzf().entrySet().iterator();
            this.zzb.add(new zzalo(this, it.next()));
            it.remove();
        }
        return v5;
    }

    private final SortedMap<K, V> zzf() {
        zzg();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzg();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((zzalh<K, V>) comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzalt(this);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        Object obj2;
        Object obj3;
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzalh) {
            zzalh zzalhVar = (zzalh) obj;
            int size = size();
            if (size != zzalhVar.size()) {
                return false;
            }
            int zzb = zzb();
            if (zzb != zzalhVar.zzb()) {
                obj2 = entrySet();
                obj3 = zzalhVar.entrySet();
            } else {
                for (int i5 = 0; i5 < zzb; i5++) {
                    if (!zzb(i5).equals(zzalhVar.zzb(i5))) {
                        return false;
                    }
                }
                if (zzb == size) {
                    return true;
                }
                obj2 = this.zzc;
                obj3 = zzalhVar.zzc;
            }
            return obj2.equals(obj3);
        }
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzalh<K, V>) comparable);
        return zza >= 0 ? (V) this.zzb.get(zza).getValue() : this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int zzb = zzb();
        int i5 = 0;
        for (int i6 = 0; i6 < zzb; i6++) {
            i5 += this.zzb.get(i6).hashCode();
        }
        return this.zzc.size() > 0 ? i5 + this.zzc.hashCode() : i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((zzalh<K, V>) ((Comparable) obj), (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzg();
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzalh<K, V>) comparable);
        if (zza >= 0) {
            return (V) zzc(zza);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzb.size() + this.zzc.size();
    }

    public final V zza(K k5, V v5) {
        zzg();
        int zza = zza((zzalh<K, V>) k5);
        if (zza >= 0) {
            return (V) this.zzb.get(zza).setValue(v5);
        }
        zzg();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i5 = -(zza + 1);
        if (i5 >= this.zza) {
            return zzf().put(k5, v5);
        }
        int size = this.zzb.size();
        int i6 = this.zza;
        if (size == i6) {
            zzalo remove = this.zzb.remove(i6 - 1);
            zzf().put((K) remove.getKey(), (V) remove.getValue());
        }
        this.zzb.add(i5, new zzalo(this, k5, v5));
        return null;
    }

    public void zza() {
        if (this.zzd) {
            return;
        }
        this.zzc = this.zzc.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzc);
        this.zzf = this.zzf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzf);
        this.zzd = true;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final Map.Entry<K, V> zzb(int i5) {
        return this.zzb.get(i5);
    }

    public final Iterable<Map.Entry<K, V>> zzc() {
        return this.zzc.isEmpty() ? zzaln.zza() : this.zzc.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzd() {
        if (this.zzg == null) {
            this.zzg = new zzall(this);
        }
        return this.zzg;
    }

    public final boolean zze() {
        return this.zzd;
    }
}
