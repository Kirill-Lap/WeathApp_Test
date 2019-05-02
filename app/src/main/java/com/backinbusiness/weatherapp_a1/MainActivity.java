package com.backinbusiness.weatherapp_a1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    private Switch humiditySwitch;
    private Switch windSwitch;
    private Switch pressureSwitch;
    private EditText cityTextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"onCreate", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onCreate");
        initItems();
        findViewById(R.id.toSecondActivityBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScreenSlideActivity.class);
                String str = cityTextBox.getText().toString();
                intent.putExtra("city", str);
                intent.putExtra("humidity", humiditySwitch.isChecked());
                intent.putExtra("wind", windSwitch.isChecked());
                intent.putExtra("pressure", pressureSwitch.isChecked());
                startActivity(intent);
            }
        });
    }

    private void initItems(){
        humiditySwitch = findViewById(R.id.humiditySwitch);
        windSwitch = findViewById(R.id.windSwitch);
        pressureSwitch = findViewById(R.id.solarSwitch);
        cityTextBox = findViewById(R.id.cityTextBox);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"onRestart", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onResume");
    }
}
