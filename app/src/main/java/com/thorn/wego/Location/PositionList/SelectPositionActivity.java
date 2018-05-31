package com.thorn.wego.Location.PositionList;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.thorn.wego.R;


public class SelectPositionActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private SharedPreferences sp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_navigation);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_navigation_map);
        mapFragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        //TODO:经纬度错误检查
        String startLat = sp.getString("discoverLat","");
        String startLon = sp.getString("discoverLon","");

        LatLng start = new LatLng(Double.parseDouble(startLat),Double.parseDouble(startLon));

        mMap.addMarker(new MarkerOptions().position(start));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start,14));
        mMap.setOnCameraChangeListener(listener);
    }

    GoogleMap.OnCameraChangeListener listener = new GoogleMap.OnCameraChangeListener(){
        @Override
        public void onCameraChange(CameraPosition cp) {
            LatLng center = cp.target;
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(center));

            sp = getSharedPreferences("User", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("discoverLat",String.valueOf(center.latitude));
            editor.putString("discoverLon",String.valueOf(center.longitude));
            editor.commit();
        }
    };



}
