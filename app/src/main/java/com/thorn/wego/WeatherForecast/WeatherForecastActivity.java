package com.thorn.wego.WeatherForecast;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.thorn.wego.Element.WeatherForecastJson;
import com.thorn.wego.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class WeatherForecastActivity extends AppCompatActivity {
    private TextView city, temperature, condition, wind, humidity;
    private ImageView icon;
    private String provider;
    private Location location;
    private WeatherForecastJson weatherForecastJson = new WeatherForecastJson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_forecast);

        city = (TextView) findViewById(R.id.weather_city_name);
        temperature = (TextView) findViewById(R.id.weather_temperature);
        condition = (TextView) findViewById(R.id.weather_cond_text);
        wind = (TextView) findViewById(R.id.weather_wind);
        humidity = (TextView) findViewById(R.id.weather_hum);
        icon = (ImageView)findViewById(R.id.weather_cond_icon);

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
            String currentPosition = "latitude" + location.getLatitude() +
                    "\n" + "longitude is" + location.getLongitude();
            String url = formatUrl(location.getLatitude(),location.getLongitude());
            sendRequest(url);
            if(weatherForecastJson.getHeWeather6().size()!=0){
                city.setText(weatherForecastJson.getHeWeather6().get(0).getBasic().getLocation());
                temperature.setText(weatherForecastJson.getHeWeather6().get(0).getNow().getTmp());
                condition.setText(weatherForecastJson.getHeWeather6().get(0).getNow().getCond_txt());
                wind.setText(weatherForecastJson.getHeWeather6().get(0).getNow().getWind_sc());
                humidity.setText(weatherForecastJson.getHeWeather6().get(0).getNow().getHum());
                icon.setImageResource(getResources().getIdentifier("weather_"+ weatherForecastJson.getHeWeather6().get(0).getNow().getCond_code() , "drawable", getPackageName()));

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
