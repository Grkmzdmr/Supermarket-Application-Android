package com.gorkemozdemir.supermarketapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
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
import java.util.Map;

public class userInformations extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
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
        
    }
}


