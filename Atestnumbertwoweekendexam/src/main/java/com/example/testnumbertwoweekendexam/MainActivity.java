package com.example.testnumbertwoweekendexam;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.testnumbertwoweekendexam.Fragment.Afragment;
import com.example.testnumbertwoweekendexam.Fragment.Bfragment;
import com.example.testnumbertwoweekendexam.Fragment.Cfragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private List<Fragment> list;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

    }

    private void initData() {
        Afragment afragment = new Afragment();
        Bfragment bfragment = new Bfragment();
        Cfragment cfragment = new Cfragment();

        list = new ArrayList<>();

        list.add(afragment);
        list.add(bfragment);
        list.add(cfragment);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),list);

        viewPager.setAdapter(adapter);



    }

    private void initView() {

        viewPager = (ViewPager) findViewById(R.id.viewpager_demo);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_demo);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
