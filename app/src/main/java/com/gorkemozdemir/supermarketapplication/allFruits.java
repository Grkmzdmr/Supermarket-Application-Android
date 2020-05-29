package com.gorkemozdemir.supermarketapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import com.gorkemozdemir.supermarketapplication.Firestore.sendinfoFirestore;

public class allFruits extends AppCompatActivity {


    TextView orangeText, elmaText,muzText,cilekText,ananasText,erikText;
    Button orangeButton, elmaButton,muzButton,cilekButton,ananasButton,erikButton;
    ImageView orangeView, elmaView,muzView,cilekView,ananasView,erikView;
    sendinfoFirestore sendinfo,sendinfo2,sendinfo3,sendinfo4,sendinfo5,sendinfo6;
    ElegantNumberButton numberButton, numberButton2,numberButton3,numberButton4,numberButton5,numberButton6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_fruits);
        elmaButton = findViewById(R.id.elmaButton);
        elmaText = findViewById(R.id.ElmaText);
        elmaView = findViewById(R.id.elmaView);
        orangeText = findViewById(R.id.portakalText);
        orangeButton = findViewById(R.id.portakalButton);
        orangeView = findViewById(R.id.portakalView);
        muzText = findViewById(R.id.muzText);
        muzButton = findViewById(R.id.muzButton);
        muzView = findViewById(R.id.muzView);
        cilekText = findViewById(R.id.cilekText);
        cilekButton = findViewById(R.id.cilekButton);
        cilekView = findViewById(R.id.cilekView);
        ananasText = findViewById(R.id.ananasText);
        ananasButton = findViewById(R.id.ananasButton);
        ananasView = findViewById(R.id.ananasView);
        erikText = findViewById(R.id.ErikText);
        erikButton = findViewById(R.id.erikButton);
        erikView = findViewById(R.id.erikView);
       // firebaseStorage = FirebaseStorage.getInstance();
      //  firebaseAuth = FirebaseAuth.getInstance();
       // storageReference = firebaseStorage.getReference();
       // firebaseFirestore = FirebaseFirestore.getInstance();
        numberButton = findViewById(R.id.numberButton);
        numberButton2 = findViewById(R.id.numberButton2);
        numberButton3 = findViewById(R.id.numberButton3);
        numberButton4 = findViewById(R.id.numberButton4);
        numberButton5 = findViewById(R.id.numberButton5);
        numberButton6 = findViewById(R.id.numberButton6);





    }







    public void addPortakal(View view) {
        sendinfo = new sendinfoFirestore();
        String Sayac = numberButton.getNumber();
        sendinfo.sendInfo("Fruits/portakal.jpg", "Portakal 500g.", "8", Sayac, 8, "portakal");


    }

    public void addElma(View view) {

        sendinfo2 = new sendinfoFirestore();
        String Sayac2 = numberButton2.getNumber();
        sendinfo2.sendInfo("Fruits/elma.jpg", "Elma 500g.", "5", Sayac2, 5, "elma");




    }

    public void addMuz(View view){
        sendinfo3 = new sendinfoFirestore();
        String Sayac3 = numberButton3.getNumber();
        sendinfo3.sendInfo("Fruits/muz.jpg","Muz 500g.","9",Sayac3,9,"muz");
    }


    public void addCilek(View view){
        sendinfo4 = new sendinfoFirestore();
        String Sayac4 = numberButton4.getNumber();
        sendinfo4.sendInfo("Fruits/cilek.jpg","Cilek 500g.","12",Sayac4,12,"cilek");

    }

    public void addAnanas(View view){
        sendinfo5 = new sendinfoFirestore();
        String Sayac5 = numberButton5.getNumber();
        sendinfo5.sendInfo("Fruits/ananas.jpg","Ananas Adet","14",Sayac5,14,"ananas");
    }
    public void addErik(View view){
        sendinfo6 = new sendinfoFirestore();
        String Sayac6 = numberButton6.getNumber();
        sendinfo6.sendInfo("Fruits/erik.jpg","Erik 500g.","15",Sayac6,15,"erik");
    }


    }

