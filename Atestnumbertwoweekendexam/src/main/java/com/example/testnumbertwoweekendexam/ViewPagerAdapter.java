package com.example.testnumbertwoweekendexam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by admin on 2017/6/21.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] title = {"Afragment", "Bfragment", "Cfragment"};
    private  List<Fragment> list;

    public ViewPagerAdapter(FragmentManager supportFragmentManager, List<Fragment> list) {
        super(supportFragmentManager);

        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {


        return title[position];
    }
}
