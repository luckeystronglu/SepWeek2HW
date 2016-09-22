package com.qf.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Ken on 2016/9/8.10:14
 */
public class DepthPageTransformer implements ViewPager.PageTransformer {
    private static float MIN_SCALE = 0.75f;

    public void transformPage(View view, float position) {
        //获得当前的item的宽度
        int pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)
            view.setAlpha(0);
        } else if (position <= 0) { // [-1,0]
            //当前的item往左移动
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);
        } else if (position <= 1) { // (0,1]
            // Fade the page out.
            view.setAlpha(1 - position);

            // 保证当前的view一直处于viewpager的中心位置
            view.setTranslationX(pageWidth * -position);//position = 1 -> -pageWidth

            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        } else { // (1,+Infinity]
            view.setAlpha(0);
        }
    }
}
