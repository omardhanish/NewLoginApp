package com.example.android.newloginapp.variousasynk;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.android.newloginapp.Activities.MainActivity;
import com.example.android.newloginapp.Activities.SpinnerStateCitySelectorActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by omar on 01-05-2017.
 */

public class LoginAsynk extends AsyncTask<String, String, String> {

    private Context context;
    ProgressDialog loading ;
    HttpURLConnection conn;
    URL url = null;
    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;
    JSONArray userdetail = null;

    public LoginAsynk(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        loading = ProgressDialog.show(context,"Logging in...","Wait...",false,false);
    }

    @Override
    protected String doInBackground(String... params) {
        try {

            // Enter URL address where your php file resides
//            url = new URL("http://192.168.0.102/user_login.php/");
            url = new URL("https://cakeandcookiecbe.000webhostapp.com/user_login.php/");

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "exception";
        }
        try {
            // Setup HttpURLConnection class to send and receive data from php and mysql
            conn = (HttpURLConnection)url.openConnection();
            conn.setReadTimeout(READ_TIMEOUT);
            conn.setConnectTimeout(CONNECTION_TIMEOUT);
            conn.setRequestMethod("POST");

            // setDoInput and setDoOutput method depict handling of both send and receive
            conn.setDoInput(true);
            conn.setDoOutput(true);

            // Append parameters to URL
            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("login_emailid", params[0])
                    .appendQueryParameter("login_password", params[1]);
            String query = builder.build().getEncodedQuery();

            // Open connection for sending data
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();
            conn.connect();

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            return "exception";
        }

        try {

            int response_code = conn.getResponseCode();

            // Check if successful connection made
            if (response_code == HttpURLConnection.HTTP_OK) {

                // Read data sent from server
                InputStream input = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                // Pass data to onPostExecute method
                return(result.toString());

            }else{

                return("unsuccessful");
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "exception";
        } finally {
            conn.disconnect();
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
                String query_result = jsonObj.getString("success");
                if(query_result.equals("1")) {
                    Toast.makeText(context, "login successful , congratulation", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,SpinnerStateCitySelectorActivity.class);
                    context.startActivity(intent);
//                    userdetail = jsonObj.getJSONArray("ttable");
//
//                    for(int i=0;i<userdetail.length();i++){
//                        JSONObject c = userdetail.getJSONObject(i);
//                        String id = c.getString("success");
//
//                        HashMap<String,String> persons = new HashMap<String,String>();
//
//                        persons.put("tagsuccesswhat",id);
//
//                    }
                }
                else if(query_result.equals("0")){
                    Toast.makeText(context, "something problem in php mysql....", Toast.LENGTH_SHORT).show();
                }

//                String query_result = jsonObj.getString("success");

//                if (query_result.equals(1)) {
//                    Toast.makeText(context, "Signin successful.", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(context, SpinnerStateCitySelectorActivity.class);
//                    context.startActivity(intent);
//                } else if (query_result.equals(0)) {
//                    Toast.makeText(context, "Signin failed.", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(context, "Some problem occured.", Toast.LENGTH_SHORT).show();
//                }
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context, "unknown problem occured , try later.", Toast.LENGTH_SHORT).show();
            }
        }
//        else {
//            Toast.makeText(context, "Check the internet.", Toast.LENGTH_SHORT).show();
//        }
    }

}
