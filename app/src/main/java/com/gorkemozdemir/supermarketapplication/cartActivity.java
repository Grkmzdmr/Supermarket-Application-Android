package com.gorkemozdemir.supermarketapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class cartActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    ArrayList<String> productName;
    ArrayList<String> productImage;
    ArrayList<String> productNumber;
    ArrayList<String> productMoney;
    ArrayList<String> productLastMoney;

    EditText editText1;
    private FirebaseAuth auth;
    private DocumentReference documentReference;
    String UserId;
    private FirebaseAuth.AuthStateListener authStateListener;
    FeedRecyclerAdapter feedRecyclerAdapter;

    Button button;

    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        productName = new ArrayList<>();
        productImage = new ArrayList<>();
        productNumber = new ArrayList<>();
        productMoney = new ArrayList<>();
        productLastMoney = new ArrayList<>();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        editText1 = findViewById(R.id.recycler_row_numberText);




        recyclerView = findViewById(R.id.rcyc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        feedRecyclerAdapter = new FeedRecyclerAdapter(productName,productNumber,productImage,productMoney,productLastMoney);
        new ItemTouchHelper(itemDelete).attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(feedRecyclerAdapter);
        auth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null){
                    Intent intent = new Intent(cartActivity.this,CartNotLogin.class);
                    startActivity(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();

                }else if (user != null){
                    getDataFromFirebase();

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




    public void getDataFromFirebase(){
        UserId = firebaseAuth.getCurrentUser().getUid();
        CollectionReference collectionReference = firebaseFirestore.collection(UserId);
        collectionReference.orderBy("date", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e != null){
                    Toast.makeText(cartActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null){
                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()){
                        Map<String,Object> data = snapshot.getData();
                        String Name = (String) data.get("productName");
                        String Image = (String) data.get("downloadUrl");
                        String Number = (String) data.get("productNumber");
                        String Money = String.valueOf(data.get("productMoney"));
                        String lastMoney = String.valueOf(data.get("lastPay"));
                        productName.add(Name);
                        productImage.add(Image);
                        productMoney.add(Money);
                        productNumber.add(Number);
                        productLastMoney.add(lastMoney);



                        feedRecyclerAdapter.notifyDataSetChanged();
                    }
                }
            }
        });





    }
    ItemTouchHelper.SimpleCallback itemDelete = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT){

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            String Name = productName.get(viewHolder.getAdapterPosition());


            FirebaseFirestore.getInstance().collection(UserId).document(Name).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(cartActivity.this,"Ürün başarıyla sepetinizden silinmiştir.", Toast.LENGTH_SHORT).show();
                    Intent intentToCartagain = new Intent(cartActivity.this,cartActivity.class);
                    startActivity(intentToCartagain);
                    intentToCartagain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();


                }
            });

            feedRecyclerAdapter.notifyDataSetChanged();
        }
    };




   public void odemeEkranı(View view){
        Intent intent = new Intent(cartActivity.this,Payment.class);
        startActivity(intent);
        finish();
   }

}








