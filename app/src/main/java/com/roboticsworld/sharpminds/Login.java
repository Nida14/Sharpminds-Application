package com.roboticsworld.sharpminds;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.roboticsworld.sharpminds.shared_preference.shared_pref;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private ImageButton btRegister;
    Intent intentLogin,intentForgot;
    private EditText editTextEmail;
    private EditText editTextPassword;
    Button btnLogin;
    private TextView tvLogin,tvForgot,tvRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btRegister = findViewById(R.id.btRegister);
        btRegister.setOnClickListener(this);
        tvLogin = findViewById(R.id.tvLogin);
        tvRegister = findViewById(R.id.tvRegister);
        mAuth = FirebaseAuth.getInstance();

        editTextEmail = (EditText) findViewById(R.id.tvUsername);
        editTextPassword = (EditText) findViewById(R.id.tvPassword);
        tvForgot = findViewById(R.id.tvForgot);
        tvForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentForgot = new Intent(getBaseContext(), ResetPasswordActivity.class);
                startActivity(intentForgot);
            }
        });
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLogin();
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent   = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

        if(!new shared_pref(this).isUserLoginOut())
        {
            moveHome();
        }
    }

    public void getLogin()
    {
        String mail = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (mail.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(),"Please Verify All Field",Toast.LENGTH_SHORT).show();
        }
        else
        {
            signIn(mail,password);
        }
    }

    private void signIn(final String mail, final String password) {
        mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    btnLogin.setVisibility(View.VISIBLE);
                    new shared_pref(getApplicationContext()).savelogin_details(mail,password);
                    moveHome();
                }
                else {
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        if (v==btRegister){
            Intent intent   = new Intent(Login.this,Register.class);
            Pair[] pairs    = new Pair[1];
            pairs[0] = new Pair<View,String>(tvLogin,"tvLogin");
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
            startActivity(intent,activityOptions.toBundle());
        }
    }

    public void moveHome()
    {
        intentLogin = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intentLogin);
    }
}