package com.qf.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Ken on 2016/9/8.9:55
 * google官方的特效
 */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static float MIN_SCALE = 0.85f;//设置item缩放最小到哪个比率
    private static float MIN_ALPHA = 0.5f;//设置item最小的透明度

    public void transformPage(View view, float position) {
        float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));//1 ~ 0.85
        // Scale the page down (between MIN_SCALE and 1)
        view.setScaleX(scaleFactor);
        view.setScaleY(scaleFactor);
    }
}
