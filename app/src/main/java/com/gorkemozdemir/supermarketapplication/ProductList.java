package com.gorkemozdemir.supermarketapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class ProductList extends AppCompatActivity {
    String mypref = "mypref";
    SharedPreferences pref1;
    private FeedRecyclerAdapter adapter;
    private FirebaseFirestore firebaseFirestore;
    ArrayList<String> Name;
    ArrayList<String> Number;
    ArrayList<String> Money;
    ProductHolder productHolder;
    RecyclerView recyclerVieww;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        Name = new ArrayList<>();
        Number = new ArrayList<>();
        Money = new ArrayList<>();

        firebaseFirestore = FirebaseFirestore.getInstance();
        recyclerVieww = findViewById(R.id.rcyc1);
        recyclerVieww.setLayoutManager(new LinearLayoutManager(this));
        productHolder = new ProductHolder(Name, Money, Number);
        recyclerVieww.setAdapter(productHolder);
        Intent intent = getIntent();
        String info = intent.getStringExtra("info");

        if (info.matches("meyve")){
            getDataF("Meyve");
        }else if (info.matches("sebze")){
            getDataF("Sebze");
        }else if (info.matches("et")){
            getDataF("Et");
        }else if (info.matches("balık")){
            getDataF("Balik");
        }else if (info.matches("kahvaltı")){
            getDataF("Kahvaltılık");
        }else if(info.matches("süt")){
            getDataF("Sut");
        }


    }

    public void getDataF(String Tur) {

        CollectionReference collectionReference = firebaseFirestore.collection(Tur);
        collectionReference.orderBy("Money", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(ProductList.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {
                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                        Map<String, Object> data = snapshot.getData();
                        String Namee = (String) data.get("Name");
                        String Imagee = (String) data.get("Url");
                        String Moneyy = (String) data.get("Money");
                        Name.add(Namee);
                        Money.add(Moneyy);
                        Number.add(Imagee);

                        productHolder.notifyDataSetChanged();
                    }
                }
            }
        });

    }


}
