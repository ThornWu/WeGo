package com.thorn.wego.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.thorn.wego.Adapter.HomeNavigationIconAdapter;
import com.thorn.wego.Element.ImageTextIcon;
import com.thorn.wego.Element.PositionListItem;
import com.thorn.wego.Element.PositionListJson;
import com.thorn.wego.Element.WeatherForecastJson;
import com.thorn.wego.PositionDetail.PositionDetailActivity;
import com.thorn.wego.Adapter.PositionListItemAdapter;
import com.thorn.wego.PositionList.DiscoverListActivity;
import com.thorn.wego.PositionList.Presenter.IPositionListPresenter;
import com.thorn.wego.PositionList.Presenter.PositionListPresenter;
import com.thorn.wego.PositionList.SearchListActivity;
import com.thorn.wego.PositionList.View.IPositionListView;
import com.thorn.wego.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class HomeFragment extends Fragment implements IPositionListView {
    private View rootView;
    private GridView gridNavigation;
    private ListView homeDiscoverList;
    private TextView homeSearchText, homeDate, homeDay, homeTmp, homeCon, homeCity;
    private Button homeSearchSubmit;
    private RelativeLayout homeDiscoverLink;
    private LinkedList<ImageTextIcon> imageTextIconList;
    private HomeNavigationIconAdapter homeNavigationIconAdapter;
    private String provider;
    private Location location;
    private WeatherForecastJson weatherForecastJson = new WeatherForecastJson();
    private PositionListJson positionListJson = new PositionListJson();
    private SharedPreferences sp;
    private IPositionListPresenter iPositionListPresenter;
    private PositionListItemAdapter positionListItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(null == rootView){
            rootView = inflater.inflate(R.layout.home_fragment,container,false);
            initView(rootView);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if(null != parent){
            parent.removeView(rootView);
        }
        return rootView;
    }

    private void initView(View view){
        gridNavigation = (GridView) rootView.findViewById(R.id.home_grid_navigation);

        homeDate = (TextView) rootView.findViewById(R.id.home_date);
        homeDay = (TextView) rootView.findViewById(R.id.home_day);
        homeTmp = (TextView) rootView.findViewById(R.id.home_tempnum);
        homeCon = (TextView) rootView.findViewById(R.id.home_weather_cate);
        homeCity = (TextView) rootView.findViewById(R.id.home_city);

        homeSearchText = (TextView) rootView.findViewById(R.id.home_search_text);
        homeSearchSubmit = (Button) rootView.findViewById(R.id.home_search_submit);

        homeDiscoverLink = (RelativeLayout) rootView.findViewById(R.id.home_discover);
        homeDiscoverList = (ListView) rootView.findViewById(R.id.home_discover_list);
        imageTextIconList = new LinkedList<ImageTextIcon>();

        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_restaurant,"Restaurant"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_nightlife,"Nightlife"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_mall,"Mall"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_park,"Park"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_movie,"Movie"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_hotel,"Hotel"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_museum,"Museum"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_stadium,"Stadium"));

        homeNavigationIconAdapter = new HomeNavigationIconAdapter(getContext(), imageTextIconList);
        gridNavigation.setAdapter(homeNavigationIconAdapter);

        gridNavigation.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                Intent intent = new Intent(getContext(), SearchListActivity.class);
                intent.putExtra("keyword", String.valueOf(imageTextIconList.get(position).getIconName()));//给intent添加额外数据
                startActivity(intent);
            }

        });

        homeSearchSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(homeSearchText.getText().length()!=0){
                    Intent intent = new Intent(getContext(), SearchListActivity.class);
                    intent.putExtra("keyword", homeSearchText.getText());//给intent添加额外数据
                    startActivity(intent);
                    homeSearchText.setText("");
                }
            }
        });

        homeDiscoverLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DiscoverListActivity.class);
                startActivity(intent);
            }
        });

        Date date = new Date();
        String [] dateInfo = date.toString().split(" ");
        homeDate.setText(dateInfo[1] + " "+ dateInfo[2]);
        homeDay.setText(dateInfo[0]);

        LocationManager locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);

        List<String> providerList = locationManager.getProviders(true);
        if (providerList.contains(LocationManager.GPS_PROVIDER)) {
            provider = LocationManager.GPS_PROVIDER;
        } else if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
            provider = LocationManager.NETWORK_PROVIDER;
        } else {
            //当没有可用的位置提供器时，提示用户,并结束程序
            Toast.makeText(getContext(), "No Location Provider to use", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            location = locationManager.getLastKnownLocation(provider);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        if (location != null) {
            String currentPosition = "latitude" + location.getLatitude() +
                    "\n" + "longitude is" + location.getLongitude();
            String url = formatUrl(location.getLatitude(),location.getLongitude());
            sendRequest(url);
            if(weatherForecastJson.getHeWeather6().size()!=0){
                homeCity.setText(weatherForecastJson.getHeWeather6().get(0).getBasic().getLocation());
                homeTmp.setText(weatherForecastJson.getHeWeather6().get(0).getNow().getTmp());
                homeCon.setText(weatherForecastJson.getHeWeather6().get(0).getNow().getCond_txt());
                sp = this.getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                if(weatherForecastJson.getHeWeather6().get(0).getBasic().getLocation().toString().equals("Los Angeles")){
                    editor.putString("city","LA");
                }else{
                    editor.putString("city","NY");
                }
                editor.commit();
            }
        }


        iPositionListPresenter = new PositionListPresenter(this);

        positionListItemAdapter = new PositionListItemAdapter(iPositionListPresenter);
        homeDiscoverList.setAdapter(positionListItemAdapter);

        sp = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        String discoverUrl = getResources().getString(R.string.service_url) + "recommend" +
                "?userid=" + sp.getString("userid","Null") +
                "&city=" + sp.getString("city","") +
                "&lat=" + sp.getString("lat","") +
                "&lon=" + sp.getString("lon","") + "&timeid=0";
        iPositionListPresenter.loadDatas(discoverUrl);

        homeDiscoverList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), PositionDetailActivity.class);
                sp = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
                String userid = sp.getString("userid","Null");
                intent.putExtra("userid", userid);//给intent添加额外数据
                intent.putExtra("venueid", String.valueOf(positionListItemAdapter.getItem(position).getVenueid()));//给intent添加额外数据
                if(userid!="Null"){
                    startActivity(intent);
                }
            }
        });

    }


    @Override
    public void onGetDataList(List<PositionListItem> datas){
        positionListItemAdapter.setDatas(datas);
    }

    @Override
    public Activity onGetActivity(){return getActivity();}

    @Override
    public void onHiddenChanged(boolean hidden){
        if(!hidden){
            Date date = new Date();
            String [] dateInfo = date.toString().split(" ");
            homeDate.setText(dateInfo[1] + " "+ dateInfo[2]);
            homeDay.setText(dateInfo[0]);

            LocationManager locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);

            List<String> providerList = locationManager.getProviders(true);
            if (providerList.contains(LocationManager.GPS_PROVIDER)) {
                provider = LocationManager.GPS_PROVIDER;
            } else if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
                provider = LocationManager.NETWORK_PROVIDER;
            } else {
                //当没有可用的位置提供器时，提示用户,并结束程序
                Toast.makeText(getContext(), "No Location Provider to use", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                location = locationManager.getLastKnownLocation(provider);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
            if (location != null) {
                String currentPosition = "latitude" + location.getLatitude() +
                        "\n" + "longitude is" + location.getLongitude();
                String url = formatUrl(location.getLatitude(),location.getLongitude());
                sendRequest(url);
                if(weatherForecastJson.getHeWeather6().size()!=0){
                    homeCity.setText(weatherForecastJson.getHeWeather6().get(0).getBasic().getLocation());
                    homeTmp.setText(weatherForecastJson.getHeWeather6().get(0).getNow().getTmp());
                    homeCon.setText(weatherForecastJson.getHeWeather6().get(0).getNow().getCond_txt());
                    sp = this.getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    if(weatherForecastJson.getHeWeather6().get(0).getBasic().getLocation().toString().equals("Los Angeles")){
                        editor.putString("city","LA");
                    }else{
                        editor.putString("city","NY");
                    }
                    editor.commit();
                }
            }
        }

    }


    private String formatUrl(double lat, double lon){
        String url = getResources().getString(R.string.weather_url) +
                "?key=" + getResources().getString(R.string.weather_key) + "&lang=en" +
                "&location=" + String.valueOf(lon) + "," +String.valueOf(lat);
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
                        weatherForecastJson = (WeatherForecastJson) new Gson().fromJson(response.toString(),WeatherForecastJson.class);

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
