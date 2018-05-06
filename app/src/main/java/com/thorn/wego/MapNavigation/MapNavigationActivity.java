package com.thorn.wego.MapNavigation;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
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

        LatLng start = new LatLng(40.036675, 116.32885);
        LatLng end = new LatLng(40.056675, 116.38885);

        mMap.addMarker(new MarkerOptions().position(start).title("Start"));
        mMap.addMarker(new MarkerOptions().position(end).title("End"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start,14));

        String url = formatUrl(start, end);
        sendRequest(url);
        PolylineOptions rectOptions = new PolylineOptions();
        for( int i = 0 ; i < googleNavigationJson.getRoutes().get(0).getLegs().get(0).getSteps().size() ; i++) {
            double lat = googleNavigationJson.getRoutes().get(0).getLegs().get(0).getSteps().get(i).getStart_location().getLat();
            double lon = googleNavigationJson.getRoutes().get(0).getLegs().get(0).getSteps().get(i).getStart_location().getLng();
            rectOptions.add(new LatLng(lat,lon));
        }
        rectOptions.add(end);
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

}
