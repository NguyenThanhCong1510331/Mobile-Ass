package com.example.asus.ex3.Activity;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.asus.ex3.Adapter.MainFragmentPagerAdapter;
import com.example.asus.ex3.Fragment.FavoriteFragment;
import com.example.asus.ex3.Fragment.HomeFragment;
import com.example.asus.ex3.Fragment.SearchFragment;
import com.example.asus.ex3.R;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

public class MainScreenActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,
        FavoriteFragment.OnFragmentInteractionListener, SearchFragment.OnFragmentInteractionListener {

    ViewPager mainViewPager;
    MainFragmentPagerAdapter mainFragmentPagerAdapter;
    TabLayout myTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewPager = findViewById(R.id.vp_horizontal_ntb);
        mainFragmentPagerAdapter = new MainFragmentPagerAdapter(this, getSupportFragmentManager());
        mainViewPager.setAdapter(mainFragmentPagerAdapter);
        myTabLayout = (TabLayout) findViewById(R.id.ntb_horizontal);
        myTabLayout.setupWithViewPager(mainViewPager);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
