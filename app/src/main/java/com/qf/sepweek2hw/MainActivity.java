package com.qf.sepweek2hw;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qf.flag.ForumFlagment;
import com.qf.flag.HandpickFlagment;
import com.qf.utillibary.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.search)
    ImageView search;
    @Bind(R.id.handpick)
    RadioButton handpick;
    @Bind(R.id.forum)
    RadioButton forum;
    @Bind(R.id.tab_rg)
    RadioGroup tabRg;
    @Bind(R.id.fl_fragment)
    FrameLayout flFragment;


    @Override
    public int getContentViewId() {

        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        ButterKnife.bind(this);
        tabRg.setOnCheckedChangeListener(this);
        tabRg.getChildAt(0).performClick();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.handpick:
                handpick.setTextColor(getResources().getColor(R.color.colorAccent));
                forum.setTextColor(Color.WHITE);
                handpick.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                forum.setBackgroundColor(Color.GRAY);
                fragmentManager(R.id.fl_fragment,new HandpickFlagment(),"handpick");
                break;
            case R.id.forum:
                forum.setTextColor(getResources().getColor(R.color.colorAccent));
                handpick.setTextColor(Color.WHITE);
                forum.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                handpick.setBackgroundColor(Color.GRAY);
                fragmentManager(R.id.fl_fragment,new ForumFlagment(),"forum");
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}