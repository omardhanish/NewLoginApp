package com.example.android.newloginapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.newloginapp.GetterSetters.GetterSetter;
import com.example.android.newloginapp.R;
import com.example.android.newloginapp.variousasynk.RegisterSignUpActivityAsynkTask;

/**
 * Created by omar on 31-01-2017.
 */
public class RegisteringClassActivity extends Fragment {
//    DataBaseHelperConnector dConnector = new DataBaseHelperConnector(this);
    GetterSetter form = new GetterSetter();

    public RegisteringClassActivity(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.registering_layout, container, false);

        final EditText firstName = (EditText) rootView.findViewById(R.id.editTextFirstName);
        if( firstName.getText().toString().length() == 0 )
            firstName.setError( "First name is required!" );

        final EditText lastName = (EditText) rootView.findViewById(R.id.editTextLastName);
        if( lastName.getText().toString().length() == 0 )
            lastName.setError( "Last name is required!" );

        final EditText pass = (EditText) rootView.findViewById(R.id.editTextPassword);
        if( pass.getText().toString().length() == 0 )
            pass.setError( "password is required!" );

        final EditText retypePass = (EditText) rootView.findViewById(R.id.editTextRetypePassword);
        if(retypePass.getText().toString().equals(pass))
            retypePass.setError( "password is not same!" );

        final EditText phone = (EditText) rootView.findViewById(R.id.editTextPhoneNumber);
        if( phone.getText().toString().length() == 0 )
            phone.setError( "Valid phonumber is required!" );

        final EditText email = (EditText) rootView.findViewById(R.id.editTextEmail);
        if( !android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches() )
            email.setError( "Email is required or does not match" );

        final EditText location = (EditText) rootView.findViewById(R.id.editTextLocation);
        if( location.getText().toString().length() == 0 )
            location.setError( "location is required!" );

        final EditText areaCode = (EditText) rootView.findViewById(R.id.editTextAreaCode);
        if( areaCode.getText().toString().length() == 0 )
            areaCode.setError( "area code is required" );

        final EditText address = (EditText) rootView.findViewById(R.id.editTextAddress);
        if( address.getText().toString().length() == 0 )
            address.setError( "address is required!" );






        Button submit = (Button) rootView.findViewById(R.id.buttonSubmit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName1 = firstName.getText().toString().trim();
                String lastName1 = lastName.getText().toString().trim();
                String pass1 = pass.getText().toString().trim();
                String retypePass1 = retypePass.getText().toString().trim();
                String phone1 = phone.getText().toString().trim();
                String email1 = email.getText().toString().trim();
                String location1 = location.getText().toString().trim();
                String areacode1 = areaCode.getText().toString().trim();
                String address1 = address.getText().toString().trim();


                new RegisterSignUpActivityAsynkTask(getContext()).execute(firstName1, lastName1,pass1,retypePass1,phone1,email1,location1,areacode1,address1);

            }
        });

//        submit.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//
//////            try to use else if with return statement below during app test ............
//
//                if( firstName.getText().toString().length() == 0){firstName.setError( "First name is required!" );return;}
//                else if( lastName.getText().toString().length() == 0) {lastName.setError("Last name is required!");return;}
//                else if( !android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches() ) {email.setError("Email is required or does not match");return;}
//                else if( phone.getText().toString().length() == 0) {phone.setError("Valid phonumber is required!");return;}
//                else if( add1.getText().toString().length() == 0) {add1.setError("Address is required!");return;}
//                else if( add2.getText().toString().length() == 0) {add2.setError("Address is required!");return;}
//                else if( username.getText().toString().length() == 0) {username.setError("Username is required!");return;}
//                else if( pass.getText().toString().length() == 0){pass.setError( "password is required!" );return;}
//
//
//                form.setFirstName(firstName.getEditableText().toString());
//                form.setLastName(lastName.getEditableText().toString());
//                form.setEmail(email.getEditableText().toString());
//                form.setPhone(phone.getEditableText().toString());
//                form.setAdd1(add1.getEditableText().toString());
//                form.setAdd2(add2.getEditableText().toString());
//                form.setUsername(username.getEditableText().toString());
//                form.setPassword(pass.getEditableText().toString());
//                dConnector.addRecord(form.getFirstName(), form.getLastName(), form.getEmail(), form.getPhone(), form.getAdd1(), form.getAdd2() , form.getUsername() ,form.getPassword());
//                Toast.makeText(getApplicationContext(), "Record successfully Added!", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(RegisteringClassActivity.this , MainActivity.class);
//                finish();
//                startActivity(intent);
//            }
//
//        });

        return rootView;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.registering_layout);
//    }
//
//
//
//    @Override
//    public void onBackPressed()
//    {
//        Intent intent = new Intent(this,MainActivity.class);
//        finish();
//        startActivity(intent);
//    }
}
