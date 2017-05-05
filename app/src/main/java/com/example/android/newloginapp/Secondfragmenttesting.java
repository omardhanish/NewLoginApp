package com.example.android.newloginapp;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by omar on 10-02-2017.
 */
public class Secondfragmenttesting extends Fragment {

    public Secondfragmenttesting(){

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.second_layout_fragment_testing, container, false);
    }

}
