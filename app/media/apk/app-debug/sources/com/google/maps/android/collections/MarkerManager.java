package com.google.maps.android.collections;

import android.view.View;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.collections.MapObjectManager;
/* loaded from: classes.dex */
public class MarkerManager extends MapObjectManager<Marker, Collection> implements GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener, GoogleMap.InfoWindowAdapter, GoogleMap.OnInfoWindowLongClickListener {
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.MapObjectManager$Collection, com.google.maps.android.collections.MarkerManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection getCollection(String str) {
        return super.getCollection(str);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.MapObjectManager$Collection, com.google.maps.android.collections.MarkerManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection newCollection(String str) {
        return super.newCollection(str);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ boolean remove(Marker marker) {
        return super.remove(marker);
    }

    public MarkerManager(GoogleMap map) {
        super(map);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    void setListenersOnUiThread() {
        if (this.mMap != null) {
            this.mMap.setOnInfoWindowClickListener(this);
            this.mMap.setOnInfoWindowLongClickListener(this);
            this.mMap.setOnMarkerClickListener(this);
            this.mMap.setOnMarkerDragListener(this);
            this.mMap.setInfoWindowAdapter(this);
        }
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public Collection newCollection() {
        return new Collection();
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mInfoWindowAdapter == null) {
            return null;
        }
        return collection.mInfoWindowAdapter.getInfoWindow(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View getInfoContents(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mInfoWindowAdapter == null) {
            return null;
        }
        return collection.mInfoWindowAdapter.getInfoContents(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
    public void onInfoWindowClick(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mInfoWindowClickListener == null) {
            return;
        }
        collection.mInfoWindowClickListener.onInfoWindowClick(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowLongClickListener
    public void onInfoWindowLongClick(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mInfoWindowLongClickListener == null) {
            return;
        }
        collection.mInfoWindowLongClickListener.onInfoWindowLongClick(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mMarkerClickListener == null) {
            return false;
        }
        return collection.mMarkerClickListener.onMarkerClick(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragStart(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mMarkerDragListener == null) {
            return;
        }
        collection.mMarkerDragListener.onMarkerDragStart(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDrag(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mMarkerDragListener == null) {
            return;
        }
        collection.mMarkerDragListener.onMarkerDrag(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragEnd(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mMarkerDragListener == null) {
            return;
        }
        collection.mMarkerDragListener.onMarkerDragEnd(marker);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.maps.android.collections.MapObjectManager
    public void removeObjectFromMap(Marker object) {
        object.remove();
    }

    /* loaded from: classes.dex */
    public class Collection extends MapObjectManager.Collection {
        private GoogleMap.InfoWindowAdapter mInfoWindowAdapter;
        private GoogleMap.OnInfoWindowClickListener mInfoWindowClickListener;
        private GoogleMap.OnInfoWindowLongClickListener mInfoWindowLongClickListener;
        private GoogleMap.OnMarkerClickListener mMarkerClickListener;
        private GoogleMap.OnMarkerDragListener mMarkerDragListener;

        public Collection() {
            super();
        }

        public Marker addMarker(MarkerOptions opts) {
            Marker marker = MarkerManager.this.mMap.addMarker(opts);
            super.add(marker);
            return marker;
        }

        public void addAll(java.util.Collection<MarkerOptions> opts) {
            for (MarkerOptions opt : opts) {
                addMarker(opt);
            }
        }

        public void addAll(java.util.Collection<MarkerOptions> opts, boolean defaultVisible) {
            for (MarkerOptions opt : opts) {
                addMarker(opt).setVisible(defaultVisible);
            }
        }

        public void showAll() {
            for (Marker marker : getMarkers()) {
                marker.setVisible(true);
            }
        }

        public void hideAll() {
            for (Marker marker : getMarkers()) {
                marker.setVisible(false);
            }
        }

        public boolean remove(Marker marker) {
            return super.remove((Collection) marker);
        }

        public java.util.Collection<Marker> getMarkers() {
            return getObjects();
        }

        public void setOnInfoWindowClickListener(GoogleMap.OnInfoWindowClickListener infoWindowClickListener) {
            this.mInfoWindowClickListener = infoWindowClickListener;
        }

        public void setOnInfoWindowLongClickListener(GoogleMap.OnInfoWindowLongClickListener infoWindowLongClickListener) {
            this.mInfoWindowLongClickListener = infoWindowLongClickListener;
        }

        public void setOnMarkerClickListener(GoogleMap.OnMarkerClickListener markerClickListener) {
            this.mMarkerClickListener = markerClickListener;
        }

        public void setOnMarkerDragListener(GoogleMap.OnMarkerDragListener markerDragListener) {
            this.mMarkerDragListener = markerDragListener;
        }

        public void setInfoWindowAdapter(GoogleMap.InfoWindowAdapter infoWindowAdapter) {
            this.mInfoWindowAdapter = infoWindowAdapter;
        }
    }
}
