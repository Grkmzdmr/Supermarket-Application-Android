package com.gorkemozdemir.supermarketapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class userInformations extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private DocumentReference documentReference,documentReference2;
    private FirebaseAuth firebaseAuth;
    String UserId;
    EditText cityText,nameText,mailText,telephoneText,birthText;
    TextView nameTag,cityTag,mailTag,telephoneTag,birthTag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_informations);

        nameTag = findViewById(R.id.nameTag);
        cityTag = findViewById(R.id.cityTag);
        mailTag = findViewById(R.id.mailTag);
        birthTag = findViewById(R.id.birthTag);
        telephoneTag = findViewById(R.id.telephoneTag);
        nameText = findViewById(R.id.nameText);
        cityText = findViewById(R.id.cityText);
        mailText = findViewById(R.id.mailText);
        birthText = findViewById(R.id.birthText);
        telephoneText = findViewById(R.id.telephoneText);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();


        getData();









    }


        public void getData(){
            UserId = firebaseAuth.getCurrentUser().getUid();
        final DocumentReference documentReference = firebaseFirestore.collection("İnformations").document(UserId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                nameText.setText(documentSnapshot.getString("Name"));
                mailText.setText(documentSnapshot.getString("Mail"));
                telephoneText.setText(documentSnapshot.getString("telephone"));
                birthText.setText(documentSnapshot.getString("birth"));
                cityText.setText(documentSnapshot.getString("city"));

            }
        });
        }

    public void guncelle(View view){
        UserId = firebaseAuth.getCurrentUser().getUid();
        documentReference = firebaseFirestore.collection("İnformations").document(UserId);
        documentReference2 = firebaseFirestore.collection("Deliveryİnfo").document(UserId);
        String maill = mailText.getText().toString();
        String namee = nameText.getText().toString();
        String birthh = birthText.getText().toString();
        String cityy = cityText.getText().toString();
        String numberr = telephoneText.getText().toString();
        final Map<String, Object> newData2 = new HashMap<>();
        newData2.put("NameAgain", namee);
        newData2.put("Name",namee);
        newData2.put("Mail", maill);
        newData2.put("city", cityy);
        newData2.put("cityAgain",cityy);
        newData2.put("birth", birthh);
        newData2.put("telephoneAgain", numberr);
        newData2.put("telephone",numberr);
        AlertDialog.Builder alert = new AlertDialog.Builder(userInformations.this);
        alert.setTitle("Bilgilerinizi güncellemek istediğinizden emin misiniz ?");
        alert.setMessage("Güncellemek için EVET'e basın");
        alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                documentReference2.update(newData2).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                    }
                });


                documentReference.update(newData2).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(userInformations.this, Account.class);
                        startActivity(intent);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(userInformations.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }


        });
        alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(userInformations.this,"İşlem iptal edildi",Toast.LENGTH_LONG).show();

            }
        });
        alert.show();

    }
        

}


