package com.example.android.newloginapp.Listviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.newloginapp.Activities.HotelItemDetailViewActivity;
import com.example.android.newloginapp.R;

/**
 * Created by omar on 25-02-2017.
 */

public class HotelFoodItemListView extends Activity {

    RecyclerView viewlist;
    ListView mMyList;
    FrameLayout visibleimage,offer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list_view);

        Intent i = getIntent();

        String[] fooditem = i.getStringArrayExtra("item");


        viewlist = (RecyclerView)findViewById(R.id.list);
        viewlist.setVisibility(View.GONE);
        visibleimage = (FrameLayout)findViewById(R.id.imagevis);
        offer  = (FrameLayout)findViewById(R.id.offervis);

        visibleimage.setVisibility(View.VISIBLE);
        offer.setVisibility(View.VISIBLE);


        ArrayAdapter mAdapter = new ArrayAdapter<String>(this,
                R.layout.hotel_item_item_layout,fooditem);
        mMyList = (ListView) findViewById(R.id.list2);
        mMyList.setVisibility(View.VISIBLE);
        mMyList.setBackgroundColor(getResources().getColor(R.color.white));
        mMyList.setAdapter(mAdapter);

        mMyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                TextView main = (TextView) findViewById(R.id.textView2);
                String text = (mMyList.getItemAtPosition(position)).toString().trim();
                Intent i1 = new Intent(HotelFoodItemListView.this,HotelItemDetailViewActivity.class);
                i1.putExtra("main",text);
                startActivity(i1);
            }
        });



    }



}
