package com.example.android.newloginapp.Listviews;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.newloginapp.Adapters.FragmentCustomAdapter;
import com.example.android.newloginapp.Adapters.FragmentCustomAdapterForRecycler;
import com.example.android.newloginapp.GetterSetters.HomeFragmentRowItem;
import com.example.android.newloginapp.R;
import com.example.android.newloginapp.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omar on 08-02-2017.
 */
public class HomeFragmentListViewActivity extends Fragment {

    private View rootView = null;
    String[] member_names;
    TypedArray profile_pics;
    String[] statues;
    String[] contactType;

    private List<HomeFragmentRowItem> rowItems = new ArrayList<>();
    private RecyclerView myRecyclerlistview;
    private FragmentCustomAdapterForRecycler mAdapter;


    public HomeFragmentListViewActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_view, container, false);


        member_names = getResources().getStringArray(R.array.names_array);

        profile_pics = getResources().obtainTypedArray(R.array.pics_array);

        statues = getResources().getStringArray(R.array.sta_array);

        contactType = getResources().getStringArray(R.array.contact_array);

        for (int i = 0; i < member_names.length; i++) {
            HomeFragmentRowItem item = new HomeFragmentRowItem(member_names[i],
                    profile_pics.getResourceId(i, -1), statues[i],
                    contactType[i]);
            rowItems.add(item);
        }

        myRecyclerlistview = (RecyclerView) rootView.findViewById(R.id.list);

        myRecyclerlistview.setBackgroundColor(getResources().getColor(R.color.white));

        mAdapter = new FragmentCustomAdapterForRecycler(rowItems);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        myRecyclerlistview.setLayoutManager(mLayoutManager);
        myRecyclerlistview.setAdapter(mAdapter);
        profile_pics.recycle();

        myRecyclerlistview.addOnItemTouchListener(new RecyclerTouchListener(getContext(), myRecyclerlistview, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                String[] item1 = getResources().getStringArray(R.array.ItemFood1);

                Intent i = new Intent(getContext() , HotelFoodItemListView.class);
                i.putExtra("item",item1);
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



//        myRecyclerlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//
//                String[] item1 = getResources().getStringArray(R.array.ItemFood1);
//
//                Intent i = new Intent(getContext() , HotelFoodItemListView.class);
//                i.putExtra("item",item1);
//                startActivity(i);
//            }
//        });

        return rootView;
    }
}
