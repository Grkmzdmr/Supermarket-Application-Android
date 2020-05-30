package com.gorkemozdemir.supermarketapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class Adress extends AppCompatActivity {
    private DocumentReference documentReference;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;
    String UserId;
    TextView textView,adressText;
    Button addAdress,changeAdress,deleteAdress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress);

        textView = findViewById(R.id.information);
        adressText = findViewById(R.id.adressText);
        addAdress = findViewById(R.id.addAdress);
        changeAdress = findViewById(R.id.changeAdress);
        deleteAdress = findViewById(R.id.deleteAdress);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        getDataFromAdress();


    }

    public void addAdress(View view){
        Intent intent = new Intent(Adress.this, com.gorkemozdemir.supermarketapplication.addAdress.class);
        startActivity(intent);
    }
    public void getDataFromAdress(){
        UserId = firebaseAuth.getCurrentUser().getUid();
        documentReference = firebaseFirestore.collection("Deliveryİnfo").document(UserId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                adressText.setText(documentSnapshot.getString("adress"));
            }
        });
    }

    public void changeAdress(View view){
        Intent intentToChangeAdress = new Intent(Adress.this,changeAdress.class);
        startActivity(intentToChangeAdress);
    }

    public void deleteAdress(View view) {
        UserId = firebaseAuth.getCurrentUser().getUid();
        documentReference = firebaseFirestore.collection("Deliveryİnfo").document(UserId);
        Map<String,Object> uptades = new HashMap<>();
        uptades.put("adress", FieldValue.delete());
        uptades.put("NameAgain",FieldValue.delete());
        uptades.put("SNameAgain",FieldValue.delete());
        uptades.put("cityAgain",FieldValue.delete());
        uptades.put("telephoneAgain",FieldValue.delete());


        documentReference.update(uptades).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                adressText.setText("GEÇERLİ BİR ADRESİNİZ YOK");
            }
        });

    }




}
