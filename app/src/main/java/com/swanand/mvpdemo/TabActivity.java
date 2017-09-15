package com.swanand.mvpdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.swanand.mvpdemo.adapters.TabPagerAdapter;

public class TabActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
    }

    public void setUpTabs(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        //set adapter to your ViewPager
        viewPager.setAdapter(new TabPagerAdapter(getSupportFragmentManager()));
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
