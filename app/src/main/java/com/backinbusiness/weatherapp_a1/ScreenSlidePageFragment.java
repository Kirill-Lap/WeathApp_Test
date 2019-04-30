package com.backinbusiness.weatherapp_a1;

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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        int pageNum=0;
        if (bundle != null) {
            pageNum = bundle.getInt("page_number", 1);
        }
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page,container,false);
        ImageView img = rootView.findViewById(R.id.id_gallery_item_image);
        img.setImageResource(ScreenSlideActivity.weatherImgIds[pageNum]);
        TextView txt = rootView.findViewById(R.id.id_gallery_item_text);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, pageNum);
        Date date = calendar.getTime();
        String str  = DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(date);
        txt.setText(str);
        return rootView;

    }
}
