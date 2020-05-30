package com.gorkemozdemir.supermarketapplication.Firestore;

import android.net.Uri;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.jar.Attributes;

public class sendinfoFirestore {

     private StorageReference storageReference;
     private FirebaseAuth firebaseAuth;
     private FirebaseStorage firebaseStorage;
     private FirebaseFirestore firebaseFirestore;
     private DocumentReference documentReference;
     String UserID;
    public  void sendInfo(String photo, final String prodNam, final String prodMon, final String Sayac2, final int money, final String documentPath){
        firebaseStorage = FirebaseStorage.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        storageReference = firebaseStorage.getReference();
        firebaseFirestore = FirebaseFirestore.getInstance();
        StorageReference ref;
        ref = storageReference.child(photo);
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String downloadUrl = uri.toString();
                UserID = firebaseAuth.getCurrentUser().getUid();
                String productName = prodNam;
                String productMoney = prodMon;
                int realsayac = Integer.parseInt(Sayac2);
                int MONEY = money * realsayac;
                HashMap<String, Object> postData = new HashMap<>();
                postData.put("productName", productName);
                postData.put("productMoney", productMoney);
                postData.put("date", FieldValue.serverTimestamp());
                postData.put("downloadUrl",downloadUrl);
                postData.put("productNumber", Sayac2);
                postData.put("maxMoney", String.valueOf(MONEY));
                documentReference = firebaseFirestore.collection(UserID).document(documentPath);
                documentReference.set(postData);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }

    




}
