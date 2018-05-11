package com.thorn.wego.PositionDetail;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.thorn.wego.Element.BasicNetworkJson;
import com.thorn.wego.Element.ImageTextIcon;
import com.thorn.wego.Element.PositionDetailJson;
import com.thorn.wego.MapNavigation.MapNavigationActivity;
import com.thorn.wego.PositionDetail.Adapter.PositionDetailIconAdapter;
import com.thorn.wego.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class PositionDetailActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private TextView position_name, position_address, position_category;
    private GridView gridNavigation;
    private LinkedList<ImageTextIcon> imageTextIconList;
    private PositionDetailIconAdapter positionDetailIconAdapter;
    private PositionDetailJson positionDetailJson = new PositionDetailJson();
    private BasicNetworkJson basicNetworkJson = new BasicNetworkJson();
    private Boolean isStarred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.position_detail_fragment);

        position_name = (TextView) findViewById(R.id.position_detail_name);
        position_address = (TextView) findViewById(R.id.position_detail_address);
        position_category = (TextView) findViewById(R.id.position_detail_category);

        String userid = getIntent().getExtras().get("userid").toString();
        String venueid = getIntent().getExtras().get("venueid").toString();
        String url = getResources().getString(R.string.service_url) + "positioninfo"+"?userid="+ userid+"&venueid="+venueid;

        sendRequest(url);

        position_name.setText(positionDetailJson.getVenuename());
        position_address.setText(positionDetailJson.getAddress());
        position_category.setText(positionDetailJson.getCategory());

        initView();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.position_detail_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        double lat = positionDetailJson.getLatitude();
        double lon = positionDetailJson.getLongitude();
        String text = positionDetailJson.getVenuename()==null? "No name" : positionDetailJson.getVenuename();

        // Add a marker in Sydney and move the camera
        LatLng pos = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(pos).title(text));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,16));

        // 不允许手势缩放
        mMap.getUiSettings().setZoomGesturesEnabled(false);

        // 不允许拖动地图
        mMap.getUiSettings().setScrollGesturesEnabled(false);

    }

    private void initView(){
        gridNavigation = (GridView) findViewById(R.id.position_detail_function);
        imageTextIconList = new LinkedList<ImageTextIcon>();

        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_navigation,"Navigation"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_signed,"Sign"));
        if(positionDetailJson.getIsstarred().equals("True")){
            imageTextIconList.add(new ImageTextIcon(R.drawable.ic_favorited,"Favorite"));
            isStarred = Boolean.TRUE;
        }else{
            imageTextIconList.add(new ImageTextIcon(R.drawable.ic_favorite,"Favorite"));
            isStarred = Boolean.FALSE;
        }

        positionDetailIconAdapter = new PositionDetailIconAdapter(PositionDetailActivity.this, imageTextIconList);
        gridNavigation.setAdapter(positionDetailIconAdapter);


        gridNavigation.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                if(imageTextIconList.get(position).getIconName().equals("Navigation")){
                    Intent intent = new Intent(PositionDetailActivity.this, MapNavigationActivity.class);
                    intent.putExtra("userid", "33");//给intent添加额外数据
                    intent.putExtra("destLat",positionDetailJson.getLatitude());
                    intent.putExtra("destLon",positionDetailJson.getLongitude());
                    startActivity(intent);
                }else if(imageTextIconList.get(position).getIconName().equals("Sign")){
                    String url =getResources().getString(R.string.service_url) + "sign" + "?userid=" + getIntent().getExtras().get("userid").toString() +
                            "&venueid=" + getIntent().getExtras().get("venueid").toString();
                    signAndFavorite(url);
                    Toast.makeText(PositionDetailActivity.this, basicNetworkJson.getText() ,Toast.LENGTH_SHORT).show();
                }else if(imageTextIconList.get(position).getIconName().equals("Favorite")){
                    if(isStarred == Boolean.TRUE){
                        String url =getResources().getString(R.string.service_url) + "favorite" + "?userid=" + getIntent().getExtras().get("userid").toString() +
                                "&venueid=" + getIntent().getExtras().get("venueid").toString() + "&action=delete";
                        signAndFavorite(url);
                    }else{
                        String url =getResources().getString(R.string.service_url) + "favorite" + "?userid=" + getIntent().getExtras().get("userid").toString() +
                                "&venueid=" + getIntent().getExtras().get("venueid").toString() + "&action=add";
                        signAndFavorite(url);
                    }
                    if(basicNetworkJson.getCode().equals("OK") && isStarred == Boolean.FALSE){
                        imageTextIconList.get(position).setIconId(R.drawable.ic_favorited);
                        isStarred = Boolean.TRUE;
                        positionDetailIconAdapter = new PositionDetailIconAdapter(PositionDetailActivity.this, imageTextIconList);
                        gridNavigation.setAdapter(positionDetailIconAdapter);
                    }else if(basicNetworkJson.getCode().equals("OK") && isStarred == Boolean.TRUE){
                        imageTextIconList.get(position).setIconId(R.drawable.ic_favorite);
                        isStarred = Boolean.FALSE;
                        positionDetailIconAdapter = new PositionDetailIconAdapter(PositionDetailActivity.this, imageTextIconList);
                        gridNavigation.setAdapter(positionDetailIconAdapter);
                    }
                    Toast.makeText(PositionDetailActivity.this, basicNetworkJson.getText() ,Toast.LENGTH_SHORT).show();
                }

            }

        });
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
                        positionDetailJson = (PositionDetailJson) new Gson().fromJson(response.toString(),PositionDetailJson.class);

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

    private void signAndFavorite(final String url){
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
                        basicNetworkJson = (BasicNetworkJson) new Gson().fromJson(response.toString(),BasicNetworkJson.class);

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
