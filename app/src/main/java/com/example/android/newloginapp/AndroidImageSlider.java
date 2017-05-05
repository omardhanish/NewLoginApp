package com.example.android.newloginapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.example.android.newloginapp.Activities.SpinnerStateCitySelectorActivity;
import com.example.android.newloginapp.Adapters.AndroidImageApadter;

import java.util.Timer;
import java.util.TimerTask;



/**
 * Created by omar on 30-01-2017.
 */
public class AndroidImageSlider extends Activity {

    final static int NUM_PAGES = 6;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slider_image_xml);

//        RelativeLayout r = (RelativeLayout) findViewById(R.id.layoutClick);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPageAndroid);
        AndroidImageApadter adapterView = new AndroidImageApadter(this);
        viewPager.setAdapter(adapterView);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES-1) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer .schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 500, 2000);


        viewPager.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                finish();
                Intent intent = new Intent(AndroidImageSlider.this, SpinnerStateCitySelectorActivity.class);
                startActivity(intent);
                return false;
            }
        });

    }

}
