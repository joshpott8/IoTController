package com.example.joshpotterton.iotcontroller;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

//Written By Josh Potterton - 10/08/2015

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 5;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private String[] mItemTitles= {"On", "Off", "Flicker", "Blink", "Flash", "Quit", "Shutdown Pi and Quit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.navitem, mItemTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener(this));

        mPager = (ViewPager) findViewById(R.id.viewPager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
    }

    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return ScreenSlidePageFragment.create(i);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener{
        private AppCompatActivity activity;

        public DrawerItemClickListener(AppCompatActivity act){
            activity = act;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           if(position < 5) {
               mPager.setCurrentItem(position);
               mDrawerLayout.closeDrawer(mDrawerList);
           }
           else{
                switch(position){
                    case 5:
                        Toast.makeText(getApplicationContext(), "Quit", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    case 6:
                        Toast.makeText(getApplicationContext(), "Shutdown Pi and Quit", Toast.LENGTH_SHORT).show();
                        //Handle shutting down pi
                        finish();
                        break;
                }
           }
        }
    }

}
