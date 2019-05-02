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
import android.view.View;
import android.widget.TextView;

public class ScreenSlideActivity extends FragmentActivity {
    private static final int NUM_PAGES = 3;

    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    public static int[] weatherImgIds;
    private TextView cityText;
//    private TextView humidityText;
//    private TextView windText;
//    private  TextView pressureText;
    private boolean humidityFlag, windFlag, pressureFlag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        initData();
        initView();
    }


    private void initData(){
        weatherImgIds = new int[] {R.drawable.wi_01, R.drawable.wi_02, R.drawable.wi_03};
//        humidityText = findViewById(R.id.id_humidity_text);
//        windText = findViewById(R.id.id_wind_text);
//        pressureText = findViewById(R.id.id_pressure_text);
        cityText = findViewById(R.id.id_city_text);
    }


    public void initView() {
        Intent intent = getIntent();
        String str = intent.getStringExtra("city");
        cityText.setText(str);

        humidityFlag = intent.getBooleanExtra("humidity", false);
        windFlag = intent.getBooleanExtra("wind", false);
        pressureFlag = intent.getBooleanExtra("pressure", false);

//        if (intent.getBooleanExtra("pressure", false))
//            pressureText.setVisibility(View.VISIBLE);
//        else
//            pressureText.setVisibility(View.GONE);

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
            bundle.putBoolean("humidity", humidityFlag);
            bundle.putBoolean("wind", windFlag);
            bundle.putBoolean("pressure", pressureFlag);
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
