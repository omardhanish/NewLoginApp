package com.example.android.newloginapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.newloginapp.R;
import com.jaredrummler.materialspinner.MaterialSpinner;
/**
 * Created by omar on 06-02-2017.
 */
//implements AdapterView.OnItemSelectedListener
public class SpinnerStateCitySelectorActivity extends Activity  {


    MaterialSpinner   spinnerCountry , spinnerCity;
    Button submitButtonForStateCitySelectorSpinner,login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_city_state_selector);

        String[] SPINNERCOUNTRY = getResources().getStringArray(R.array.country_State);


        login = (Button) findViewById(R.id.loginhereinspinner);

        submitButtonForStateCitySelectorSpinner = (Button)findViewById(R.id.submitButtonForStateCitySelectorSpinner);

//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line, SPINNERCOUNTRY);

        spinnerCountry = (MaterialSpinner ) findViewById(R.id.spinnerState);

        spinnerCountry.setItems(SPINNERCOUNTRY);

        spinnerCity = (MaterialSpinner) findViewById(R.id.spinnerCity);



        spinnerCountry.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
               int pos = view.getSelectedIndex();
                if(pos==0){
                    String[] CITYTAMILNADU = getResources().getStringArray(R.array.city_Tamil_Nadu);
                    spinnerCity.setItems(CITYTAMILNADU);
                }
                if(pos==1){
                    String[] CITYKERELA = getResources().getStringArray(R.array.city_Kerela);
                    spinnerCity.setItems(CITYKERELA);
                }
                if(pos==2){
                    String[] CITYKARNATAKA = getResources().getStringArray(R.array.city_Karnataka);
                    spinnerCity.setItems(CITYKARNATAKA);
                }
            }
        });
        spinnerCountry.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {
            @Override
            public void onNothingSelected(MaterialSpinner spinner) {

            }
        });



//        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
//                adapterView.getItemAtPosition(pos);
//                if (pos == 0) {
//                    ArrayAdapter<CharSequence> adapter =  ArrayAdapter
//                            .createFromResource(SpinnerStateCitySelectorActivity.this, R.array.city_Tamil_Nadu,
//                                    android.R.layout.simple_spinner_dropdown_item);
//                    spinnerCity.setAdapter(adapter);
//                } else if (pos == 1) {
//                    ArrayAdapter<CharSequence> adapter = ArrayAdapter
//                            .createFromResource(SpinnerStateCitySelectorActivity.this, R.array.city_Kerela,
//                                    android.R.layout.simple_spinner_dropdown_item);
//                    spinnerCity.setAdapter(adapter);
//                } else if (pos == 2) {
//                    ArrayAdapter<CharSequence> adapter = ArrayAdapter
//                            .createFromResource(SpinnerStateCitySelectorActivity.this, R.array.city_Karnataka,
//                                    android.R.layout.simple_spinner_dropdown_item);
//                    spinnerCity.setAdapter(adapter);
//                }
////                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });




//        String[] list1 = getResources().getStringArray(R.array.country_State);
//
//        String[] list2 = getResources().getStringArray(R.array.city_Tamil_Nadu);
//
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_dropdown_item,list1);
//
//        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_dropdown_item,list2);

//        spinnerCountry.setAdapter(dataAdapter);
//        spinnerCity.setAdapter(dataAdapter1);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SpinnerStateCitySelectorActivity.this,TabLayoutActivity.class);
                startActivity(i);
            }
        });


        submitButtonForStateCitySelectorSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SpinnerStateCitySelectorActivity.this,MaintoEmptyAvtivity.class);
                startActivity(intent);
            }
        });

    }

//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        adapterView.getItemAtPosition(i);
//        if (i == 0) {
//            ArrayAdapter<CharSequence> adapter =  ArrayAdapter
//                    .createFromResource(this, R.array.city_Tamil_Nadu,
//                            android.R.layout.simple_spinner_dropdown_item);
//            spinnerCity.setAdapter(adapter);
//        } else if (i == 1) {
//            ArrayAdapter<CharSequence> adapter = ArrayAdapter
//                    .createFromResource(this, R.array.city_Kerela,
//                            android.R.layout.simple_spinner_dropdown_item);
//            spinnerCity.setAdapter(adapter);
//        } else if (i == 2) {
//            ArrayAdapter<CharSequence> adapter = ArrayAdapter
//                    .createFromResource(this, R.array.city_Karnataka,
//                            android.R.layout.simple_spinner_dropdown_item);
//            spinnerCity.setAdapter(adapter);
//        }
//    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
//                               long arg3) {
//        parent.getItemAtPosition(pos);
//        if (pos == 0) {
//            String[] CITYTAMILNADU = getResources().getStringArray(R.array.city_Tamil_Nadu);
//            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                    android.R.layout.simple_dropdown_item_1line, CITYTAMILNADU);
//            spinnerCity.setAdapter(adapter);
//        } else if (pos == 1) {
//            String[] CITYKERELA = getResources().getStringArray(R.array.city_Kerela);
//            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                    android.R.layout.simple_dropdown_item_1line, CITYKERELA);
//            spinnerCity.setAdapter(adapter);
//        } else if (pos == 2) {
//            String[] CITYKARNATAKA = getResources().getStringArray(R.array.city_Karnataka);
//            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                    android.R.layout.simple_dropdown_item_1line, CITYKARNATAKA);
//            spinnerCity.setAdapter(adapter);
//        }
////        parent.getItemAtPosition(pos);
//        if (pos == 0) {
//            ArrayAdapter<CharSequence> adapter =  ArrayAdapter
//                    .createFromResource(this, R.array.city_Tamil_Nadu,
//                            android.R.layout.simple_spinner_dropdown_item);
//            spinnerCity.setAdapter(adapter);
//        } else if (pos == 1) {
//            ArrayAdapter<CharSequence> adapter = ArrayAdapter
//                    .createFromResource(this, R.array.city_Kerela,
//                            android.R.layout.simple_spinner_dropdown_item);
//            spinnerCity.setAdapter(adapter);
//        } else if (pos == 2) {
//            ArrayAdapter<CharSequence> adapter = ArrayAdapter
//                    .createFromResource(this, R.array.city_Karnataka,
//                            android.R.layout.simple_spinner_dropdown_item);
//            spinnerCity.setAdapter(adapter);
//        }
//    }
//
//
//    @Override
//    public void onNothingSelected(AdapterView<?> arg0) {
//    }
}
