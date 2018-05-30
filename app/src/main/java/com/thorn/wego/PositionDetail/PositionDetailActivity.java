package com.thorn.wego.PositionDetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.thorn.wego.Element.BasicNetworkJson;
import com.thorn.wego.Element.ImageTextIcon;
import com.thorn.wego.Element.PositionDetailJson;
import com.thorn.wego.MapNavigation.MapNavigationActivity;
import com.thorn.wego.Adapter.PositionDetailIconAdapter;
import com.thorn.wego.PositionDetail.Presenter.IPositionPresenter;
import com.thorn.wego.PositionDetail.Presenter.PositionPresenter;
import com.thorn.wego.PositionDetail.View.IPositionView;
import com.thorn.wego.R;

import java.util.LinkedList;

public class PositionDetailActivity extends AppCompatActivity implements OnMapReadyCallback,IPositionView {
    private GoogleMap mMap;
    private TextView position_name, position_address, position_category;
    private GridView gridNavigation;
    private LinkedList<ImageTextIcon> imageTextIconList;
    private PositionDetailIconAdapter positionDetailIconAdapter;
    private PositionDetailJson positionDetailJson;
    private BasicNetworkJson basicNetworkJson;
    private Boolean isStarred;
    private IPositionPresenter iPositionPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.position_detail_fragment);

        iPositionPresenter = new PositionPresenter(this);

        position_name = (TextView) findViewById(R.id.position_detail_name);
        position_address = (TextView) findViewById(R.id.position_detail_address);
        position_category = (TextView) findViewById(R.id.position_detail_category);


        String url = getResources().getString(R.string.service_url) + "positioninfo"+
                "?userid="+ getIntent().getExtras().get("userid").toString()+
                "&venueid="+getIntent().getExtras().get("venueid").toString();
        positionDetailJson = iPositionPresenter.getPositionDetail(url);

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

    @Override
    public Activity onGetActivity(){return this;}

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
                    intent.putExtra("userid", getIntent().getExtras().get("userid").toString());//给intent添加额外数据
                    intent.putExtra("destLat",positionDetailJson.getLatitude());
                    intent.putExtra("destLon",positionDetailJson.getLongitude());
                    startActivity(intent);
                }else if(imageTextIconList.get(position).getIconName().equals("Sign")){
                    String url =getResources().getString(R.string.service_url) + "sign" + "?userid=" + getIntent().getExtras().get("userid").toString() +
                            "&venueid=" + getIntent().getExtras().get("venueid").toString();
                    basicNetworkJson = iPositionPresenter.doOperation(url);
                    Toast.makeText(PositionDetailActivity.this, basicNetworkJson.getText() ,Toast.LENGTH_SHORT).show();
                }else if(imageTextIconList.get(position).getIconName().equals("Favorite")){
                    if(isStarred == Boolean.TRUE){
                        String url =getResources().getString(R.string.service_url) + "favorite" + "?userid=" + getIntent().getExtras().get("userid").toString() +
                                "&venueid=" + getIntent().getExtras().get("venueid").toString() + "&action=delete";
                        basicNetworkJson = iPositionPresenter.doOperation(url);
                    }else{
                        String url =getResources().getString(R.string.service_url) + "favorite" + "?userid=" + getIntent().getExtras().get("userid").toString() +
                                "&venueid=" + getIntent().getExtras().get("venueid").toString() + "&action=add";
                        basicNetworkJson = iPositionPresenter.doOperation(url);
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
}
