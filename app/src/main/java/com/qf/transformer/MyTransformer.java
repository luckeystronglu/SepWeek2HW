package com.qf.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by lenovo on 2016/9/10.
 */
public class MyTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        //获取当前view的宽度
        int pageWidth = page.getWidth();

        // 保证当前的view一直处于viewpager的中心位置
       // page.setTranslationX(pageWidth * -position);//position = 1 -> -pageWidth

        if (position < 1){
            page.setTranslationX(pageWidth*(-position)*0.3f*position);
        }
    }
}
