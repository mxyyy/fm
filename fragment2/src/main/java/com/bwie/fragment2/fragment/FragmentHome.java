package com.bwie.fragment2.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.fragment2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2018/11/12
 * author:mxy(M)
 * function:
 */
public class FragmentHome extends Fragment {

    private ViewPager vpBanner;
    private List<String> mBanner;
    public static final int FLIAG = 123;

   private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == FLIAG){
                int currentItem = vpBanner.getCurrentItem();
                if (currentItem<mBanner.size()-1){
                    currentItem++;
                }else{
                    currentItem = 0;
                }
                vpBanner.setCurrentItem(currentItem);
                sendEmptyMessageDelayed(FLIAG,2000);

            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.item_home,container,false);
        vpBanner = v.findViewById(R.id.vp_banner);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //创建集合
        mBanner = new ArrayList<>();
        //添加
        mBanner.add("http://01.imgmini.eastday.com/mobile/20180512/20180512072505_0fe08f494e7c090764244e3581b3e5ca_5_mwpm_03200403.jpg");
        mBanner.add("http://01.imgmini.eastday.com/mobile/20180512/20180512072505_0fe08f494e7c090764244e3581b3e5ca_1_mwpm_03200403.jpg");
        mBanner.add("http://06.imgmini.eastday.com/mobile/20180512/20180512_38f5183808987be3783b180740d12a2a_cover_mwpm_03200403.jpg");
        vpBanner.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mBanner.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView img = new ImageView(getActivity());
                Glide.with(getActivity()).load(mBanner.get(position)).into(img);
                container.addView(img);
                return img;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });
        handler.sendEmptyMessageDelayed(FLIAG,2000);
    }
}
