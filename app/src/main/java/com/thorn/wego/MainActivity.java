package com.thorn.wego;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.thorn.wego.Fragment.AccountFragment;
import com.thorn.wego.Fragment.HomeFragment;
import com.thorn.wego.Fragment.ToolFragment;
import com.thorn.wego.Login.LoginActivity;
import com.thorn.wego.PositionListAdapter.PositionListActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mNav;
    private Fragment[] mFragmentList;
    private FragmentManager fm;
    private FragmentTransaction transaction;

    private HomeFragment homeFragment;
    private AccountFragment accountFragment;
    private ToolFragment toolFragment;

    private SharedPreferences sp;
    private String provider;
    private Location location;

    private int lastShowFragment = 0;

    private static boolean isExit = false;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mNavListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.nav_home:
                    if (lastShowFragment != 0) {
                        selectFM(lastShowFragment, 0);
                        lastShowFragment = 0;
                    }
                    return true;
                case R.id.nav_tool:
                    if (lastShowFragment != 1) {
                        selectFM(lastShowFragment, 1);
                        lastShowFragment = 1;
                    }
                    return true;
                case R.id.nav_account:
                    if (lastShowFragment != 2) {
                        selectFM(lastShowFragment, 2);
                        lastShowFragment = 2;
                    }
                    return true;
            }
            return false;
        }
    };

    private void initView(){
        mNav = (BottomNavigationView) findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();

        accountFragment = new AccountFragment();
        toolFragment =new ToolFragment();

        mFragmentList = new Fragment[]{homeFragment, toolFragment, accountFragment};
        lastShowFragment = 0;
        mNav.setOnNavigationItemSelectedListener(mNavListener);
        getSupportFragmentManager().beginTransaction().add(R.id.main_framelayout, homeFragment,null).commit();
    }

    private void selectFM(int lastIndex, int index){
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(mFragmentList[lastIndex]);
        if (!mFragmentList[index].isAdded()) {
            transaction.add(R.id.main_framelayout, mFragmentList[index]);
        }
        transaction.show(mFragmentList[index]).commitAllowingStateLoss();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(),"Pleaser open you location services",Toast.LENGTH_SHORT).show();
            // 申请一个（或多个）权限，并提供用于回调返回的获取码（用户定义）
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        String value = sp.getString("userid","Null");
        if(value.equals("Null")){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else{
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
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("lat",String.valueOf(location.getLatitude()));
                editor.putString("lon",String.valueOf(location.getLongitude()));
                editor.commit();
            }
        }
    }


    @Override
    public void onBackPressed() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "Press back button again to exit the application", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            this.finish();
            System.exit(0);
        }
    }
}
