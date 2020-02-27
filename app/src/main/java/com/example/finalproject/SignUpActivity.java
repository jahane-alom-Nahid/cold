package com.example.finalproject;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText NameSignUpText,EmailSignUpText,PassWordSignUpText,RetypeSignUpPassText;
    private Button signUpBtn;
    private TextView SignInTextView;
    private FirebaseAuth mAuth;
    FirebaseFirestore fstore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        NameSignUpText=(EditText) findViewById(R.id.signUpEditTextId);
        EmailSignUpText=(EditText) findViewById(R.id.signupEmailId);
        PassWordSignUpText=(EditText) findViewById(R.id.signuppassId);
        RetypeSignUpPassText=(EditText) findViewById(R.id.signupRepassId);

        signUpBtn=(Button)findViewById(R.id.signupBtnId);
        SignInTextView=(TextView)findViewById(R.id.sign_InTextViewId);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();


        signUpBtn.setOnClickListener(this);
        SignInTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.signupBtnId:
                userRegister();
                break;
            case R.id.sign_InTextViewId:
                Intent Tintent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(Tintent);
                break;
        }

    }

    private void userRegister()
    {
        final String email = EmailSignUpText.getText().toString().trim();
        String Password = PassWordSignUpText.getText().toString().trim();
        final String Name = NameSignUpText.getText().toString().trim();
        final String RePass= RetypeSignUpPassText.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            EmailSignUpText.setError("Email Id Required.");
            return;
        }

        if (TextUtils.isEmpty(Password)){
            PassWordSignUpText.setError("Password is Required.");
            return;
        }

        if (Password.length()<6){
            PassWordSignUpText.setError("Password Must be >=6 Character.");
            return;
        }


        mAuth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                    userId = mAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = fstore.collection("users").document(userId);
                    Map<String, Object> user = new HashMap<>();
                    user.put("uName",Name);
                    user.put("email",email);
                    user.put("Rpass",RePass);
                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("TAG", "OnSuccess:User Profile isCreated " + userId);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("TAG", "OnFailure :" + e.toString());
                        }
                    });
                }
                else
                {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(SignUpActivity.this, "User Already Register", Toast.LENGTH_SHORT).show();
                    }
                    else
                        {
                    Toast.makeText(SignUpActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}
