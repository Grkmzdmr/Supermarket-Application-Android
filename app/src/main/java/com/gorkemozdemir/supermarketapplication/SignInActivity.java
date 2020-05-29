package com.gorkemozdemir.supermarketapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    EditText emailText;
    TextView textView;
    EditText passwordText;
    Button signin,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.resetP);
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.gosignup);
        firebaseAuth = firebaseAuth.getInstance();









    }

    public void signIn(View view){
        String userMail = emailText.getText().toString();
        String userPassword = passwordText.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(userMail,userPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent = new Intent(SignInActivity.this,FirstScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignInActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
    public void goSignUp(View view){
        Intent intent = new Intent(SignInActivity.this,SignUpActivity.class);
        startActivity(intent);
    }

    public void resetP(View view){
       Intent intent = new Intent(SignInActivity.this,resetPassword.class);
       startActivity(intent);
    }



}
