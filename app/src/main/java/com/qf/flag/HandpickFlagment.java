package com.qf.flag;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qf.adapter.MyPagerAdapter;
import com.qf.sepweek2hw.R;
import com.qf.transformer.MyTransformer;

/**
 * Created by lenovo on 2016/9/9.
 */
public class HandpickFlagment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private String[] datas = {"推荐", "饮食", "问答", "励志", "技巧"};
    private LinearLayout llTabs;
    private View zsq;
    private ViewPager viewPager;


    private int[] pages = {0,1,2,3,4};
    private MyPagerAdapter myPagerAdapter;


    private HorizontalScrollView hsv;

    private LinearLayout.LayoutParams zsqLp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.flagment_handpick, null);
        init(view);
        return view;
    }

    private void init(View view) {
        llTabs = (LinearLayout) view.findViewById(R.id.ll_tabs);
        zsq = view.findViewById(R.id.view);
        zsqLp = (LinearLayout.LayoutParams) zsq.getLayoutParams();
        zsqLp.width = 215;

        viewPager = (ViewPager) view.findViewById(R.id.handpick_vp);

        myPagerAdapter = new MyPagerAdapter(getChildFragmentManager(),pages);

        viewPager.setAdapter(myPagerAdapter);

        //设置viewpager中的fragment切换动画
        viewPager.setPageTransformer(true,new MyTransformer());

        viewPager.addOnPageChangeListener(this);

        hsv = (HorizontalScrollView) view.findViewById(R.id.hsv);


        //Tab部分
        for (int i = 0; i < datas.length; i++) {
            TextView textView = new TextView(getContext());
            textView.setText(datas[i]);
            textView.setPadding(15, 10, 15, 10);
            textView.setGravity(Gravity.CENTER);
            textView.setOnClickListener(this);
            textView.setTag(i);
            textView.setTextSize(18);
            if (i == 0) {
                textView.setTextColor(Color.RED);
            } else {
                textView.setTextColor(Color.GRAY);
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(215, ViewGroup.LayoutParams.WRAP_CONTENT);
            llTabs.addView(textView, layoutParams);
        }

    }


    /**
     * ViewPager 监听回调
     *
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //移动指示器
        int py = (int) (zsqLp.width * (position + positionOffset));
        zsqLp.leftMargin = py;
        zsq.setLayoutParams(zsqLp);

        //移动scrollview
        hsv.scrollTo(py - 100, 0);
    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < llTabs.getChildCount(); i++) {
            TextView view = (TextView) llTabs.getChildAt(i);
            if (position != i) {
                view.setTextColor(Color.GRAY);
            } else {
                view.setTextColor(Color.RED);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //Tab标题的点击事件
    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        viewPager.setCurrentItem(position);
    }



}
