package com.backinbusiness.weatherapp_a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScreenSlidePageFragment extends Fragment {

    private int pageNum=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            pageNum = bundle.getInt("page_number", 1);
        }
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page,container,false);
        initView(rootView, bundle);
        return rootView;
    }


    public void initView(ViewGroup rootView, Bundle bundle) {
        ImageView img = rootView.findViewById(R.id.id_gallery_item_image);
        img.setImageResource(ScreenSlideActivity.weatherImgIds[pageNum]);
        TextView txt = rootView.findViewById(R.id.id_gallery_item_text);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, pageNum);
        Date date = calendar.getTime();
        String str  = DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(date);
        txt.setText(str);

        TextView humidityText = rootView.findViewById(R.id.id_humidity_text);
        TextView windText = rootView.findViewById(R.id.id_wind_text);
        TextView pressureText = rootView.findViewById(R.id.id_pressure_text);

        if (bundle.getBoolean("humidity", false))
            humidityText.setVisibility(View.VISIBLE);
        else
            humidityText.setVisibility(View.GONE);

        if (bundle.getBoolean("pressure", false))
            pressureText.setVisibility(View.VISIBLE);
        else
            pressureText.setVisibility(View.GONE);

        if (bundle.getBoolean("wind", false))
            windText.setVisibility(View.VISIBLE);
        else
            windText.setVisibility(View.GONE);
    }

}
