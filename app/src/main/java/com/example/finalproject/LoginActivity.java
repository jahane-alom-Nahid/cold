package com.example.finalproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText EditTextName,passwordEditTextId;
    private Button signIn_button;
    private TextView signUpTextView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        EditTextName=(EditText) findViewById(R.id.loginEditTextId);
        passwordEditTextId=findViewById(R.id.passEditTextId);

        signIn_button=(Button)findViewById(R.id.loginButtontnId);
        signUpTextView=(TextView)findViewById(R.id.sign_UpTextViewId);
        mAuth = FirebaseAuth.getInstance();


        signIn_button.setOnClickListener(this);
        signUpTextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.loginButtontnId:
                UserLogin();
                break;

            case R.id.sign_UpTextViewId:

                Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void UserLogin(){

        String email= EditTextName.getText().toString().trim();
        String Password = passwordEditTextId.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            EditTextName.setError("Email Id Required.");
            return;
        }

        if (TextUtils.isEmpty(Password)){
            passwordEditTextId.setError("Password is Required.");
            return;
        }

        if (Password.length()<6){
            passwordEditTextId.setError("Password Must be >=6 Character.");
            return;
        }

        mAuth.signInWithEmailAndPassword(email,Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login SuccesFully.", Toast.LENGTH_SHORT).show();
                    Intent Button_intent=new Intent(LoginActivity.this,ServiceGridActivity.class);
                    startActivity(Button_intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "User Error.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
