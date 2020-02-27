package com.bawei.demoday01_0121;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ViewPager viewPager = findViewById(R.id.vp);      //找控件
        final RadioGroup rg = findViewById(R.id.rg);//找控件
        final RadioButton rb11 = findViewById(R.id.rb1);//找控件
        final RadioButton rb22 = findViewById(R.id.rb2);//找控件
        RadioButton rb33 = findViewById(R.id.rb3);//找控件
        final RadioButton rb44 = findViewById(R.id.rb4);//找控件
        final RadioButton rb55 = findViewById(R.id.rb5);//找控件

        MyFragment m1 = MyFragment.getInstance("首页");       //创建fragment
        MyFragment m2 = MyFragment.getInstance("发现");//创建fragment
        MyFragment m3 = MyFragment.getInstance("购物车");//创建fragment
        MyFragment m4 = MyFragment.getInstance("列表");//创建fragment
        MyFragment m5 = MyFragment.getInstance("我的");//创建fragment

        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);

        //设置vp
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        //添加vp监听

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        final Drawable drawableH = getResources().getDrawable(R.drawable.common_tab_btn_home_n_xxhdpi);
        final Drawable drawableH1 = getResources().getDrawable(R.drawable.common_tab_btn_home_s_xxhdpi);
        final Drawable drawableC = getResources().getDrawable(R.drawable.common_tab_btn_circle_n_xxhdpi);
        final Drawable drawableC1 = getResources().getDrawable(R.drawable.common_tab_btn_circle_s_xxhdpi);
        final Drawable drawableL = getResources().getDrawable(R.drawable.common_tab_btn_list_n_xxhdi);
        final Drawable drawableL1 = getResources().getDrawable(R.drawable.common_tab_btn_list_s_xxhdpi);
        final Drawable drawableM = getResources().getDrawable(R.drawable.common_tab_btn_my_n_xxhdpi);
        final Drawable drawableM1 = getResources().getDrawable(R.drawable.common_tab_btn_my_s_xxhdpi);

        //设置rb监听
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb1:
                        viewPager.setCurrentItem(0);

                        rb11.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableH1, null, null);
                        rb22.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableC, null, null);
                        rb44.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableL, null, null);
                        rb55.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableM, null, null);
                        break;
                    case R.id.rb2:
                        viewPager.setCurrentItem(1);
                        rb11.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableH, null, null);
                        rb22.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableC1, null, null);
                        rb44.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableL, null, null);
                        rb55.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableM, null, null);
                        break;
                    case R.id.rb3:
                        viewPager.setCurrentItem(2);
                        rb11.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableH, null, null);
                        rb22.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableC, null, null);
                        rb44.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableL, null, null);
                        rb55.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableM, null, null);
                        break;
                    case R.id.rb4:
                        viewPager.setCurrentItem(3);

                        rb11.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableH, null, null);
                        rb22.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableC, null, null);
                        rb44.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableL1, null, null);
                        rb55.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableM, null, null);

                        break;
                    case R.id.rb5:
                        viewPager.setCurrentItem(4);
                        rb11.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableH, null, null);
                        rb22.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableC, null, null);
                        rb44.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableL, null, null);
                        rb55.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableM1, null, null);
                        break;
                }
            }
        });


        viewPager.setOffscreenPageLimit(list.size());
    }
}
