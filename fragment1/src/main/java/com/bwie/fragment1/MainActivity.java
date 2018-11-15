package com.bwie.fragment1;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bwie.fragment1.fragment.FragmentFaxian;
import com.bwie.fragment1.fragment.FragmentHome;
import com.bwie.fragment1.fragment.FragmentMine;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vpZhu;
    private TabLayout tbBottom;
    private List<Fragment> mFragmentList;
    private List<String> mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        vpZhu = findViewById(R.id.vp_zhu);
        tbBottom = findViewById(R.id.tb_bottom);

        //创建Fragment集合
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new FragmentHome());
        mFragmentList.add(new FragmentMine());
        mFragmentList.add(new FragmentFaxian());

        //创建TabLayout集合
        mTitle = new ArrayList<>();
        mTitle.add("首页");
        mTitle.add("我的");
        mTitle.add("发现");

        vpZhu.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });
        tbBottom.setupWithViewPager(vpZhu);
        tbBottom.setTabMode(TabLayout.MODE_FIXED);





    }
}
