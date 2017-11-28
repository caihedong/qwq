package com.example.administrator.big_student_zuoye.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mList;
    private List<String> mTitle;

    public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> mList,List<String> mTitle) {
        super(fm);
        this.mList=mList;
        this.mTitle=mTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.isEmpty() ? 0 : mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
