package com.gorkemozdemir.supermarketapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.gorkemozdemir.supermarketapplication.Firestore.sendinfoFirestore;

public class allVegetables extends AppCompatActivity {
    TextView salatalıkText, domatesText,brokoliText,ıspanakText,patatesText,marulText;
    Button salatalıkButton, domatesButton,brokoliButton,ıspanakButton,patatesButton,marulButton;
    ImageView salatalıkView, domatesView,brokoliView,ıspanakView,patatesView,marulView;
    sendinfoFirestore sendinfo7,sendinfo8,sendinfo9,sendinfo10,sendinfo11,sendinfo12;
    ElegantNumberButton numberButton7, numberButton8,numberButton9,numberButton10,numberButton11,numberButton12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_vegetables);
        salatalıkText = findViewById(R.id.salatalıkText);
        domatesText = findViewById(R.id.domatesText);
        brokoliText = findViewById(R.id.brokoliText);
        ıspanakText = findViewById(R.id.ıspanakText);
        patatesText = findViewById(R.id.patatesText);
        marulText = findViewById(R.id.marulText);
        salatalıkButton = findViewById(R.id.salatalıkButton);
        domatesButton = findViewById(R.id.domatesButton);
        brokoliButton = findViewById(R.id.brokoliButton);
        ıspanakButton = findViewById(R.id.ıspanakButton);
        patatesButton = findViewById(R.id.patatesButton);
        marulButton = findViewById(R.id.marulButton);
        salatalıkView = findViewById(R.id.salatalıkView);
        domatesView = findViewById(R.id.domatesView);
        brokoliView = findViewById(R.id.brokoliView);
        ıspanakView = findViewById(R.id.ıspanakView);
        patatesView = findViewById(R.id.patatesView);
        marulView = findViewById(R.id.marulView);
        numberButton7 = findViewById(R.id.numberButton7);
        numberButton8 = findViewById(R.id.numberButton8);
        numberButton9 = findViewById(R.id.numberButton9);
        numberButton10 = findViewById(R.id.numberButton10);
        numberButton11 = findViewById(R.id.numberButton11);
        numberButton12 = findViewById(R.id.numberButton12);




    }

    public void addSalatalık(View view){
        sendinfo7 = new sendinfoFirestore();
        String Sayac7 = numberButton7.getNumber();
        sendinfo7.sendInfo("Vegetables/hiyar.jpg","Salatalık 500g.","9",Sayac7,9,"salatalık");

    }
    public void addDomates(View view){
        sendinfo8 = new sendinfoFirestore();
        String Sayac8 = numberButton8.getNumber();
        sendinfo8.sendInfo("Vegetables/domatess.jpg","Domates 500g.","11",Sayac8,11,"domates");

    }
    public void addBrokoli(View view){
        sendinfo9 = new sendinfoFirestore();
        String Sayac9 = numberButton9.getNumber();
        sendinfo9.sendInfo("Vegetables/brokoli.jpg","Brokoli 500g.","10",Sayac9,10,"brokoli");

    }

    public void addIspanak(View view){
        sendinfo10 = new sendinfoFirestore();
        String Sayac10 = numberButton10.getNumber();
        sendinfo10.sendInfo("Vegetables/ispanak.jpg","Ispanak 500g.","9",Sayac10,9,"ıspanak");

    }
    public void addPatates(View view){
        sendinfo11 = new sendinfoFirestore();
        String Sayac11 = numberButton11.getNumber();
        sendinfo11.sendInfo("Vegetables/patates.jpg","Patates 1kg.","5",Sayac11,5,"patates");

    }
    public void addMarul(View view){
        sendinfo12 = new sendinfoFirestore();
        String Sayac12 = numberButton12.getNumber();
        sendinfo12.sendInfo("Vegetables/marul.jpg","Marul Adet","6",Sayac12,6,"marul");
    }

}
