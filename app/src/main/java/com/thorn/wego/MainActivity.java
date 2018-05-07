package com.thorn.wego;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.thorn.wego.Fragment.AccountFragment;
import com.thorn.wego.Fragment.HomeFragment;
import com.thorn.wego.Fragment.ToolFragment;
import com.thorn.wego.Login.LoginActivity;
import com.thorn.wego.PositionListAdapter.PositionListActivity;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mNav;
    private Fragment[] mFragmentList;
    private FragmentManager fm;
    private FragmentTransaction transaction;

    private HomeFragment homeFragment;
    private AccountFragment accountFragment;
    private ToolFragment toolFragment;

    private SharedPreferences sp;

    private int lastShowFragment = 0;

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
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        String value = sp.getString("Userid","Null");
        if(value.equals("Null")){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

}
