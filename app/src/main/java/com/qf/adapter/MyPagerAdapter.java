package com.qf.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qf.flag.RecommendedFragment;

/**
 * Created by lenovo on 2016/9/10.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    private int[] datas;
    public MyPagerAdapter(FragmentManager fm,int[] datas) {
        super(fm);
        this.datas = datas;
    }

    @Override
    public Fragment getItem(int position) {
        return RecommendedFragment.getInstance(datas[position]);
    }

    @Override
    public int getCount() {
        return datas.length;
    }
}
