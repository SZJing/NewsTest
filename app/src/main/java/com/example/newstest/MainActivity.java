package com.example.newstest;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.newstest.fragment.Fragment_A;

public class MainActivity extends AppCompatActivity {

    private Fragment_A fragment;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = new Fragment_A();
        getFragmentManager().beginTransaction().add(R.id.fragment, fragment).commitAllowingStateLoss();
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    fragment.refreshNews();
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.more);
        }
        navigationView.setCheckedItem(R.id.new_0);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.new_0:
                        getFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
                        fragment = Fragment_A.newInstance("http://api.tianapi.com/wxnew/?key=d5e38f3cf90f844bc47b6c663481edfe&num=30");
                        getFragmentManager().beginTransaction().add(R.id.fragment, fragment).commitAllowingStateLoss();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.new_1:
                        getFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
                        fragment = Fragment_A.newInstance("http://api.tianapi.com/social/?key=d5e38f3cf90f844bc47b6c663481edfe&num=30");
                        getFragmentManager().beginTransaction().add(R.id.fragment, fragment).commitAllowingStateLoss();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.new_2:
                        getFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
                        fragment = Fragment_A.newInstance("http://api.tianapi.com/tiyu/?key=d5e38f3cf90f844bc47b6c663481edfe&num=30");
                        getFragmentManager().beginTransaction().add(R.id.fragment, fragment).commitAllowingStateLoss();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.new_3:
                        getFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
                        fragment = Fragment_A.newInstance("http://api.tianapi.com/nba/?key=d5e38f3cf90f844bc47b6c663481edfe&num=30");
                        getFragmentManager().beginTransaction().add(R.id.fragment, fragment).commitAllowingStateLoss();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.new_4:
                        getFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
                        fragment = Fragment_A.newInstance("http://api.tianapi.com/huabian/?key=d5e38f3cf90f844bc47b6c663481edfe&num=30");
                        getFragmentManager().beginTransaction().add(R.id.fragment, fragment).commitAllowingStateLoss();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.new_5:
                        getFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
                        fragment = Fragment_A.newInstance("http://api.tianapi.com/qiwen/?key=d5e38f3cf90f844bc47b6c663481edfe&num=30");
                        getFragmentManager().beginTransaction().add(R.id.fragment, fragment).commitAllowingStateLoss();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.new_6:
                        getFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
                        fragment = Fragment_A.newInstance("http://api.tianapi.com/meinv/?key=d5e38f3cf90f844bc47b6c663481edfe&num=30");
                        getFragmentManager().beginTransaction().add(R.id.fragment, fragment).commitAllowingStateLoss();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.new_7:
                        getFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
                        fragment = Fragment_A.newInstance("http://api.tianapi.com/startup/?key=d5e38f3cf90f844bc47b6c663481edfe&num=30");
                        getFragmentManager().beginTransaction().add(R.id.fragment, fragment).commitAllowingStateLoss();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.new_8:
                        getFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
                        fragment = Fragment_A.newInstance("http://api.tianapi.com/military/?key=d5e38f3cf90f844bc47b6c663481edfe&num=30");
                        getFragmentManager().beginTransaction().add(R.id.fragment, fragment).commitAllowingStateLoss();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.new_9:
                        getFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
                        fragment = Fragment_A.newInstance("http://api.tianapi.com/wxnew/?key=d5e38f3cf90f844bc47b6c663481edfe&num=30&src=新华日报&page=1");
                        getFragmentManager().beginTransaction().add(R.id.fragment, fragment).commitAllowingStateLoss();
                        drawerLayout.closeDrawers();
                        break;
                    default:

                }
                return true;
            }
        });
    }

        public boolean onOptionsItemSelected(MenuItem item){
            switch (item.getItemId()){
                case android.R.id.home:
                    drawerLayout.openDrawer(GravityCompat.START);
                    break;
                default:
            }
            return true;
        }

}
