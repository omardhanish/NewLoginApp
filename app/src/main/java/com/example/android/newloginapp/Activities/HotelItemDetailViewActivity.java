package com.example.android.newloginapp.Activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.newloginapp.R;


/**
 * Created by omar on 27-02-2017.
 */

public class HotelItemDetailViewActivity extends Activity {

    int minteger = 1;
    TextView hotelItemText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_item_detail_view);
        hotelItemText = (TextView) findViewById(R.id.hotelitemtextView);

        Intent i = getIntent();
        String get = i.getStringExtra("main");

        hotelItemText.setText(get);
    }

    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }public void decreaseInteger(View view) {
        minteger = minteger - 1;
        if(minteger<1){
            minteger = 1;
        }
        display(minteger);
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.integer_number);
        displayInteger.setText("" + number);
    }

}



