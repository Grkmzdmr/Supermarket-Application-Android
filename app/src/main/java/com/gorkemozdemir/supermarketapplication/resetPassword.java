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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class resetPassword extends AppCompatActivity {

    TextView textInfo;
    EditText MailText;
    Button button;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        firebaseAuth = FirebaseAuth.getInstance();
        textInfo = findViewById(R.id.textInfo);
        MailText = findViewById(R.id.resetMail);
        button = findViewById(R.id.resetPasw);



    }
    public void resetPasw(View view){
        String email = MailText.getText().toString();
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(resetPassword.this,"Şifrenizi sıfırlamak için lütfen E-postanıza bakınız",Toast.LENGTH_LONG).show();
                    Intent intentToBack = new Intent(resetPassword.this,SignInActivity.class);
                    startActivity(intentToBack);

                }else{
                    Toast.makeText(resetPassword.this,"İşlemde hata oluştu lütfen tekrar deneyiniz!!",Toast.LENGTH_LONG).show();

                }
            }
        });
    }




}
