package com.example.android.newloginapp.variousasynk;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by omar on 10-02-2017.
 */


public class RegisterSignUpActivityAsynkTask extends AsyncTask<String, Void, String> {


    private Context context;
    ProgressDialog loading;

    public RegisterSignUpActivityAsynkTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        loading = ProgressDialog.show(context,"Adding...","Wait...",false,false);
    }

    @Override
    protected String doInBackground(String... arg0) {
        String firstName1 = arg0[0];
        String lastName1 = arg0[1];
        String pass1 = arg0[2];
        String retypePass1 = arg0[3];
        String phone1 = arg0[4];
        String email1 = arg0[5];
        String location1 = arg0[6];
        String areaCode1 = arg0[7];
        String address1 = arg0[8];

        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try{
            data = "?firstname=" + URLEncoder.encode(firstName1, "UTF-8");
            data += "&lastname=" + URLEncoder.encode(lastName1, "UTF-8");
            data += "&password=" + URLEncoder.encode(pass1, "UTF-8");
            data += "&retype_password=" + URLEncoder.encode(retypePass1, "UTF-8");
            data += "&mobile_number=" + URLEncoder.encode(phone1, "UTF-8");
            data += "&Email_id=" + URLEncoder.encode(email1, "UTF-8");
            data += "&Loaction=" + URLEncoder.encode(location1, "UTF-8");
            data += "&areaCode=" + URLEncoder.encode(areaCode1, "UTF-8");
            data += "&address=" + URLEncoder.encode(address1, "UTF-8");


//            link = "http://192.168.0.102/registrationofuser.php/" + data;
            link = "https://cakeandcookiecbe.000webhostapp.com/registrationofuser.php/" + data;
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setReadTimeout(15000);
            con.setConnectTimeout(15000);
//            con.setRequestMethod("POST");
//            con.setDoInput(true);
//            con.setDoOutput(true);

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
            return result;

        }catch (Exception e){
            return new String("Exception: " + e.getMessage());
        }

    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        loading.dismiss();
        String jsonStr = result;
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String query_result = jsonObj.getString("query_result");
                if (query_result.equals("SUCCESS")) {
                    Toast.makeText(context, "Data inserted successfully. Signup successful.", Toast.LENGTH_SHORT).show();
                } else if (query_result.equals("FAILURE")) {
                    Toast.makeText(context, "Data could not be inserted. Signup failed.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Couldn't connect to remote database.", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context, "Error parsing JSON data.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
        }

    }

//    protected void onPostExecute(String result) {
//        String jsonStr = result;
//        if (jsonStr != null) {
//            try {
//                JSONObject jsonObj = new JSONObject(jsonStr);
//                String query_result = jsonObj.getString("query_result");
//                if (query_result.equals("SUCCESS")) {
//                    Toast.makeText(context, "Data inserted successfully. Signup successful.", Toast.LENGTH_SHORT).show();
//                } else if (query_result.equals("FAILURE")) {
//                    Toast.makeText(context, "Data could not be inserted. Signup failed.", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(context, "Couldn't connect to remote database.", Toast.LENGTH_SHORT).show();
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//                Toast.makeText(context, "Error parsing JSON data.", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(context, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
//        }
//
//    }
}
