package com.example.android.newloginapp.Activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.newloginapp.DataBaseHelperConnector;
import com.example.android.newloginapp.R;
import com.example.android.newloginapp.variousasynk.LoginAsynk;

import java.util.List;

public class MainActivity extends Fragment {

     private EditText username;
     private EditText password;
     private Button login;
     int clickcount=0;

    public MainActivity(){

    }


    DataBaseHelperConnector databaseConnector = new DataBaseHelperConnector(getContext());

    List<String> userRecord;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        login = (Button) rootView.findViewById(R.id.buttonLogin);
        final TextView register = (TextView)rootView.findViewById(R.id.buttonRegister);
        final TextView forgotPass = (TextView)rootView.findViewById(R.id.buttonForgetPass);

        forgotPass.setVisibility(View.GONE);


        username = (EditText) rootView.findViewById(R.id.editTextUsername);
//        if( username.getText().toString().trim().equals("") ){
//            login.setEnabled(false);}
//        else {login.setEnabled(true);}

        password = (EditText) rootView.findViewById(R.id.editTextPass);
//        if( password.getText().toString().trim().equals("") ) {
////            password.setError( "Password is required!" );
//            login.setEnabled(false);}
//        else {login.setEnabled(true);}



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), RegisteringClassActivity.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                final String username1 = username.getText().toString();
                final String password1 = password.getText().toString();

                if( username1.length()==0) {username.setError("Username is required!");return;}
                else if( password1.length()==0){password.setError( "password is required!" );return;}

                new LoginAsynk(getContext()).execute(username1,password1);

                // final String uname = username.getText().toString().trim();
//                if (!isValidUserName(uname)) {
//                    username.setError("Invalid Email");
//                }
//
//                final String pass = password.getText().toString().trim();
//                if (!isValidPassword(pass)) {
//                    password.setError("Invalid Password");
//                }
//                if( username.getText().toString().length() == 0 ){username.setError("User name is required!");}
//
//                if( password.getText().toString().length() == 0 ){password.setError("User name is required!");}


//                try {
//
//                    userRecord = databaseConnector.getRecord(username.getEditableText().toString(), password.getEditableText().toString());
//
//
//                    if(userRecord.size()>0) {
//                        Intent intent = new Intent(getContext(), SpinnerStateCitySelectorActivity.class);
//
//                        Toast.makeText(getContext(), "Login Successfull , Congratulation!!!!!!!", Toast.LENGTH_SHORT).show();
//                        startActivity(intent);
//                    }
//
//                }
//
//                catch (Exception e) {
//                    clickcount = clickcount+1;
//                    if (clickcount>2) {
//                        username.setText(null);
//                        password.setText(null);
//                        Toast.makeText(getContext(), "check Username,password you entered!!!!!", Toast.LENGTH_SHORT).show();
//                        forgotPass.setVisibility(View.VISIBLE);
//                    }
//
//                    else{
//                        username.setText(null);
//                        password.setText(null);
//                        Toast.makeText(getContext(), "check Username,password you entered!!!!!", Toast.LENGTH_SHORT).show();
//                    }
//                    e.printStackTrace();
//                }

            }

        });
        return rootView;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

//
//    private boolean isValidUserName(String username) {
//        if (username.equals(null)) {
//            return true;
//        }
//        return false;
//    }
//
//    private boolean isValidPassword(String pass) {
//        if (pass.equals(null)) {
//            return true;
//        }
//        return false;
//    }

//    @Override
//    protected void onPause(){
//        super.onPause();
//        username.setText(null);
//        password.setText(null);
//    }


}
