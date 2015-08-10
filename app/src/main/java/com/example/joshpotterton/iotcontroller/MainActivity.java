package com.example.joshpotterton.iotcontroller;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//Written By Josh Potterton - 10/08/2015

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 5;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

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
            return new ScreenSlidePageFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}
