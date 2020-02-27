package com.example.finalproject;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter{

    private final List<Fragment> lsFragment = new ArrayList<>();
    private final List<String> latTitle = new ArrayList<>();


    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return lsFragment.get(i);
    }

    @Override
    public int getCount() {
        return latTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return latTitle.get(position);
    }





    public  void AddFragment (Fragment fragment,String title){
        lsFragment.add(fragment);
        latTitle.add(title);
    }
}
