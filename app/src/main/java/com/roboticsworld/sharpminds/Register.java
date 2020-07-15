package com.roboticsworld.sharpminds;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    EditText name,email,number,password,retypepassword;
    Button btnRegister;
    RadioButton btnMale,btnFemale;
    Intent intent;
//    RadioGroup radioGroup;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText) findViewById(R.id.tvName);
        email = (EditText) findViewById(R.id.tvEmail);
        number = (EditText) findViewById(R.id.tvNumber);
        password = (EditText) findViewById(R.id.tvPassword);
        retypepassword = (EditText) findViewById(R.id.tvRetypePassword);
//        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        intent = new Intent(this,Login.class);


        mAuth = FirebaseAuth.getInstance();//it will store status if someone is looged in or out signed in or out

        databaseReference= FirebaseDatabase.getInstance().getReference();
        //String value = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namePattern = "[a-zA-Z]+\\.?";
                String emailPattern = "[a-zA-Z0-9_.]+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}[.] {0,1}[a-zA-Z]+";
                String numberPattern = "^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$";
                final String getName = name.getText().toString();
                String getEmail = email.getText().toString();
                final String getNumber = number.getText().toString();
                String getPassword = password.getText().toString();
                String getRetypePassword = retypepassword.getText().toString();
                try{
                    if(name.length() != 0 && email.length() != 0 && number.length() != 0 && password.length() != 0 &&
                            retypepassword.length() != 0 && getPassword.matches(getRetypePassword)) {
                        if (getEmail.matches(emailPattern) && getName.matches(namePattern) && getNumber.matches(numberPattern)) {



                        mAuth.createUserWithEmailAndPassword(getEmail, getPassword)
                                .addOnCompleteListener( Register.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {


                                        if (task.isSuccessful()) {

                                            Map<String,String> mp=new HashMap<>();
                                            mp.put("Name",getName);
                                            mp.put("Phone",getNumber);
                                            FirebaseUser userId=mAuth.getCurrentUser();
                                            databaseReference.child("Users").child(userId.getUid()).setValue(mp);
                                            Intent intent=new Intent(Register.this,Login.class);
                                            startActivity(intent);
                                            Toast.makeText(getBaseContext(),"Successfully Registered",Toast.LENGTH_LONG).show();

                                        } else {
                                            Toast.makeText(getBaseContext(),"Something went wrong"+task.getException(),Toast.LENGTH_LONG).show();

                                        }

                                        // ...
                                    }


                                });

                        }
                    }
                    else if(getEmail.matches(emailPattern) != true){
                        email.setError("Invalid Pattern");
                    }
                    else if(getName.matches(namePattern) != true){
                        name.setError("Invalid Pattern");
                    }
                    else if(getNumber.matches(numberPattern) != true){
                        number.setError("Invalid Pattern");
                    }


                    else if(getName.length() == 0){
                        name.setError("Empty");

                    }
                    else if(getEmail.length() == 0){
                        email.setError("Empty");

                    }
                    else if(getNumber.length() == 0){
                        number.setError("Empty");

                    }
                    else if(getPassword.length() == 0){
                        password.setError("Empty");

                    }

                    else if(getRetypePassword.length() == 0){
                        retypepassword.setError("Empty");

                    }


                    else if(!getPassword.matches(getRetypePassword)){
                        Toast.makeText(Register.this,"Password doesn't match",Toast.LENGTH_LONG).show();

                    }

                }
                catch (Exception e){
                    Log.i("ERRORSIGNUP",e.getMessage());
                }

        }
        });


    }
}
