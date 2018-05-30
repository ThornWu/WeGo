package com.thorn.wego.Location.PositionDetail;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.thorn.wego.Element.GoogleNavigationJson;
import com.thorn.wego.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MapNavigationActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private GoogleNavigationJson googleNavigationJson = new GoogleNavigationJson();
    private SharedPreferences sp;
    private String provider;
    private Location location;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_navigation);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_navigation_map);
        mapFragment.getMapAsync(this);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        List<String> providerList = locationManager.getProviders(true);
        if (providerList.contains(LocationManager.GPS_PROVIDER)) {
            provider = LocationManager.GPS_PROVIDER;
        } else if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
            provider = LocationManager.NETWORK_PROVIDER;
        } else {
            //当没有可用的位置提供器时，提示用户,并结束程序
            Toast.makeText(this, "No Location Provider to use", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            location = locationManager.getLastKnownLocation(provider);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        if (location != null) {
            sp = getSharedPreferences("User", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("lat",String.valueOf(location.getLatitude()));
            editor.putString("lon",String.valueOf(location.getLongitude()));
            editor.commit();
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        //TODO:经纬度错误检查
        String startLat = sp.getString("lat","");
        String startLon = sp.getString("lon","");
        String destLat = getIntent().getExtras().get("destLat").toString();
        String destLon = getIntent().getExtras().get("destLon").toString();


        LatLng start = new LatLng(Double.parseDouble(startLat),Double.parseDouble(startLon));
        LatLng end = new LatLng(Double.parseDouble(destLat),Double.parseDouble(destLon));

        mMap.addMarker(new MarkerOptions().position(start).title("Start"));
        mMap.addMarker(new MarkerOptions().position(end).title("End"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start,14));

        String url = formatUrl(start, end);
        sendRequest(url);
        PolylineOptions rectOptions = new PolylineOptions();

        List<LatLng> posList = decodePoly(googleNavigationJson.getRoutes().get(0).getOverview_polyline().getPoints());
        rectOptions.addAll(posList);

        mMap.addPolyline(rectOptions);

    }

    private String formatUrl(LatLng origin, LatLng dest) {
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        String sensor = "sensor=false";
        String mode = "mode=driving";

        String parameters = str_origin + "&" + str_dest + "&" + sensor + "&" + mode;
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"
                + output + "?" + parameters;
        return url;
    }

    private void sendRequest(final String url){
        try{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpURLConnection connection = null;
                    try{

                        URL format_url = new URL(url);
                        connection = (HttpURLConnection) format_url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(5000);

                        InputStream in = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while((line = reader.readLine()) != null){
                            response.append(line);
                        }
                        googleNavigationJson = (GoogleNavigationJson) new Gson().fromJson(response.toString(),GoogleNavigationJson.class);

                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        if(connection != null){ connection.disconnect(); }
                    }
                }
            });
            thread.start();
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private List<LatLng> decodePoly(String encoded) {

        List<LatLng> poly = new ArrayList<LatLng>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }

        return poly;
    }

}
