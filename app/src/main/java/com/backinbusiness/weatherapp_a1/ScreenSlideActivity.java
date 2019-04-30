package com.backinbusiness.weatherapp_a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

public class ScreenSlideActivity extends FragmentActivity {
    private static final int NUM_PAGES = 3;

    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    public static int[] weatherImgIds;
    private TextView cityText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        initData();
        Intent intent = getIntent();
        String str = intent.getStringExtra("city");
        cityText.setText(str);
    }

    private void initData(){
        weatherImgIds = new int[] {R.drawable.wi_01, R.drawable.wi_02, R.drawable.wi_03};
        cityText = findViewById(R.id.id_city_text);
    }


    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem()-1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("page_number", i);
            ScreenSlidePageFragment sspf = new ScreenSlidePageFragment();
            sspf.setArguments(bundle);
            return sspf;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
