package com.gorkemozdemir.supermarketapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SignUpActivity extends AppCompatActivity {
    String userId ;
    EditText takeMail;
    EditText takePassword,takeTelephone,takeCity,takeName,takeBirth;
    Button SignUp;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        takeMail = findViewById(R.id.takeMail);
        takePassword = findViewById(R.id.takePassword);
        takeTelephone = findViewById(R.id.takeTelephone);
        takeCity = findViewById(R.id.takeCity);
        takeName = findViewById(R.id.takeName);
        takeBirth = findViewById(R.id.takeBirth);
        SignUp = findViewById(R.id.signUp);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();




    }
    public void signup(View view){
        String userBirth = takeBirth.getText().toString();
        String userName = takeName.getText().toString();
        String userMail = takeMail.getText().toString();
        String userPassword = takePassword.getText().toString();
        String userTelephone = takeTelephone.getText().toString();
        String userCity = takeCity.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(userMail,userPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(SignUpActivity.this,"User Created",Toast.LENGTH_LONG).show();
                String birth = takeBirth.getText().toString();
                String name = takeName.getText().toString();
                String telephone = takeTelephone.getText().toString();
                String city = takeCity.getText().toString();
                String Mail = takeMail.getText().toString();
                Map<String,Object> postData = new HashMap<>();
                postData.put("Name",name);
                postData.put("Mail",Mail);
                postData.put("telephone",telephone);
                postData.put("city",city);
                postData.put("birth",birth);
                userId =firebaseAuth.getCurrentUser().getUid();
                firebaseFirestore.collection("İnformations").document(userId).set(postData);
                Intent intent = new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(intent);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUpActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }


}
