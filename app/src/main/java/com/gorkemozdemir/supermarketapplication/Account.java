package com.gorkemozdemir.supermarketapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Account extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;
    Button loginorcreate,myaccount,logout,myAdresses;
    TextView textView,textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        myAdresses = findViewById(R.id.myAdresses);
        loginorcreate = findViewById(R.id.loginorcreate);
        myaccount = findViewById(R.id.myaccount);
        logout = findViewById(R.id.logout);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        auth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null){
                    logout.setVisibility(View.GONE);
                    myaccount.setVisibility(View.GONE);
                    myAdresses.setVisibility(View.GONE);

                }else if (user != null){
                    loginorcreate.setVisibility(View.GONE);
                }
            }
        };


        }


    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authStateListener != null){
            auth.removeAuthStateListener(authStateListener);
        }
    }

    public void logOutt(View view){
        auth.signOut();
        Intent intent = new Intent(Account.this,FirstScreen.class);
        startActivity(intent);
        finish();
    }
    public void loginorcreate(View view){
        Intent intentToLogin = new Intent(Account.this,SignInActivity.class);
        startActivity(intentToLogin);
    }
    public void myaccount(View view){
        Intent intentToInformations = new Intent(Account.this,userInformations.class);
        startActivity(intentToInformations);

    }
    public void myAdress(View view){
        Intent intentToAdress = new Intent(Account.this,Adress.class);
        startActivity(intentToAdress);
    }

    }


