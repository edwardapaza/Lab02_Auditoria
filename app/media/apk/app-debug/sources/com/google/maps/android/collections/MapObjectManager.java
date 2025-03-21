package com.google.maps.android.collections;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.collections.MapObjectManager.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class MapObjectManager<O, C extends Collection> {
    protected final GoogleMap mMap;
    private final Map<String, C> mNamedCollections = new HashMap();
    protected final Map<O, C> mAllObjects = new HashMap();

    public abstract C newCollection();

    protected abstract void removeObjectFromMap(O o);

    abstract void setListenersOnUiThread();

    public MapObjectManager(GoogleMap map) {
        this.mMap = map;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.maps.android.collections.MapObjectManager.1
            @Override // java.lang.Runnable
            public void run() {
                MapObjectManager.this.setListenersOnUiThread();
            }
        });
    }

    public C newCollection(String id) {
        if (this.mNamedCollections.get(id) != null) {
            throw new IllegalArgumentException("collection id is not unique: " + id);
        }
        C collection = newCollection();
        this.mNamedCollections.put(id, collection);
        return collection;
    }

    public C getCollection(String id) {
        return this.mNamedCollections.get(id);
    }

    public boolean remove(O object) {
        C collection = this.mAllObjects.get(object);
        return collection != null && collection.remove(object);
    }

    /* loaded from: classes.dex */
    public class Collection {
        private final Set<O> mObjects = new LinkedHashSet();

        public Collection() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void add(O object) {
            this.mObjects.add(object);
            MapObjectManager.this.mAllObjects.put(object, this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean remove(O object) {
            if (this.mObjects.remove(object)) {
                MapObjectManager.this.mAllObjects.remove(object);
                MapObjectManager.this.removeObjectFromMap(object);
                return true;
            }
            return false;
        }

        public void clear() {
            for (O object : this.mObjects) {
                MapObjectManager.this.removeObjectFromMap(object);
                MapObjectManager.this.mAllObjects.remove(object);
            }
            this.mObjects.clear();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public java.util.Collection<O> getObjects() {
            return Collections.unmodifiableCollection(this.mObjects);
        }
    }
}
