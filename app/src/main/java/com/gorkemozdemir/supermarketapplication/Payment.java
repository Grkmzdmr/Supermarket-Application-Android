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

public class Payment extends AppCompatActivity {
    EditText editText;
    Button button,button1;
    private DocumentReference documentReference;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;
    String UserId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        editText = findViewById(R.id.payadress);
        button = findViewById(R.id.paychangeadres);
        button1 = findViewById(R.id.golastt);
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        getDataFromAdress();
    }


    public void changeAdress2(View view){
        UserId = firebaseAuth.getCurrentUser().getUid();
        documentReference = firebaseFirestore.collection("Deliveryİnfo").document(UserId);
        String adress = editText.getText().toString();

        final Map<String, Object> newData2 = new HashMap<>();
        newData2.put("adress", adress);

        AlertDialog.Builder alert = new AlertDialog.Builder(Payment.this);
        alert.setTitle("Bilgilerinizi güncellemek istediğinizden emin misiniz ?");
        alert.setMessage("Güncellemek için EVET'e basın");
        alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                documentReference.update(newData2).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Payment.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }


        });
        alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Payment.this,"İşlem iptal edildi",Toast.LENGTH_LONG).show();

            }
        });
        alert.show();
    }

    public void getDataFromAdress(){
        UserId = firebaseAuth.getCurrentUser().getUid();
        documentReference = firebaseFirestore.collection("Deliveryİnfo").document(UserId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                editText.setText(documentSnapshot.getString("adress"));
            }
        });
    }

    public void goLast(View view){
        Intent intentoLastS = new Intent(Payment.this,LastScreen.class);
        startActivity(intentoLastS);
        finish();
    }
}




