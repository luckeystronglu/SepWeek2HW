package com.qf.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;


/**
 * 滚动视差的效果
 * Created by Ken on 2016/9/8.10:29
 */
public class MyPagerTransforme implements ViewPager.PageTransformer{
    private float move = 1f;
    private float move1 = 1.3f;
    private float move2 = 0.3f;
    @Override
    public void transformPage(View page, float position) {
        //获得需要控制的imageview
//        ImageView iv = (ImageView) page.findViewById(R.id.iv_pic);
//        //保证imageview停留在ViewPager中间
//        iv.setTranslationX(page.getWidth() * -position * move);
//
//        TextView tv = (TextView) page.findViewById(R.id.tv_name);
//        tv.setTranslationX(page.getWidth() * -position * move1);
//
//        TextView tv2 = (TextView) page.findViewById(R.id.tv_wd);
//        tv2.setTranslationX(page.getWidth() * -position * move2);
    }
}
