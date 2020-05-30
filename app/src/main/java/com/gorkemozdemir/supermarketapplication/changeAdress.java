package com.gorkemozdemir.supermarketapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class changeAdress extends AppCompatActivity {
    TextView textView;
    EditText getName, getSName, getNumber, getCity, getAdress;
    private DocumentReference documentReference;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;
    String UserId;
    Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_adress);
        updateButton = findViewById(R.id.update);
        textView = findViewById(R.id.textVieww);
        getName = findViewById(R.id.getNName);
        getAdress = findViewById(R.id.getAAdress);
        getCity = findViewById(R.id.getCCity);
        getSName = findViewById(R.id.getSName);
        getNumber = findViewById(R.id.getNNumber);
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        getAdressData();


    }

    public void getAdressData() {
        UserId = firebaseAuth.getCurrentUser().getUid();
        documentReference = firebaseFirestore.collection("Deliveryİnfo").document(UserId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                    getName.setText(documentSnapshot.getString("NameAgain"));
                    getAdress.setText(documentSnapshot.getString("adress"));
                    getCity.setText(documentSnapshot.getString("cityAgain"));
                    getSName.setText(documentSnapshot.getString("SNameAgain"));
                    getNumber.setText(documentSnapshot.getString("telephoneAgain"));
            }
        });
    }

    public void update(View view) {
        UserId = firebaseAuth.getCurrentUser().getUid();
        documentReference = firebaseFirestore.collection("Deliveryİnfo").document(UserId);
        String adress = getAdress.getText().toString();
        String name = getName.getText().toString();
        String city = getCity.getText().toString();
        String lastname = getSName.getText().toString();
        String number = getNumber.getText().toString();
        final Map<String, Object> newData = new HashMap<>();
        newData.put("NameAgain", name);
        newData.put("adress", adress);
        newData.put("cityAgain", city);
        newData.put("SNameAgain", lastname);
        newData.put("telephoneAgain", number);
        AlertDialog.Builder alert = new AlertDialog.Builder(changeAdress.this);
        alert.setTitle("Bilgilerinizi güncellemek istediğinizden emin misiniz ?");
        alert.setMessage("Güncellemek için EVET'e basın");
        alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                documentReference.update(newData).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(changeAdress.this, Adress.class);
                        startActivity(intent);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(changeAdress.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }


        });
        alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(changeAdress.this,"İşlem iptal edildi",Toast.LENGTH_LONG).show();

            }
        });
        alert.show();
    }
}