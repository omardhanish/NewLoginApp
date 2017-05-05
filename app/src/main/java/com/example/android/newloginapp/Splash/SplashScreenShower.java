package com.example.android.newloginapp.Splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.android.newloginapp.AndroidImageSlider;
import com.example.android.newloginapp.R;

/**
 * Created by omar on 30-01-2017.
 */
public class SplashScreenShower extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_view_shower);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreenShower.this,AndroidImageSlider.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}
