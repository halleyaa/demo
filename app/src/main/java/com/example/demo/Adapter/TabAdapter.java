package com.example.demo.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import java.util.ArrayList;
import java.util.List;

//public class TabAdapter extends FragmentPagerAdapter {
public class TabAdapter extends FragmentStateAdapter {
    // List variable to keep track of FragmentList and FragmentTitle
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

//    public TabAdapter(FragmentManager fm) {
    public TabAdapter(@NonNull FragmentActivity fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
//        return null;
        return mFragmentList.get(position);
    }

//    @Override
//    public Fragment getItem(int position) {
//        return mFragmentList.get(position);
//    }

    public void addFragment(Fragment fragment, String tabTitle) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(tabTitle);
    }

    @Override
    public int getItemCount() {
        return mFragmentList.size();
    }
}
