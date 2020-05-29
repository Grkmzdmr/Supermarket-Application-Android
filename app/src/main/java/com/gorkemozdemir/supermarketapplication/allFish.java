package com.gorkemozdemir.supermarketapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.gorkemozdemir.supermarketapplication.Firestore.sendinfoFirestore;

public class allFish extends AppCompatActivity {
    TextView levrekText, cipuraText;
    Button levrekButton, cipuraButton;
    ImageView levrekView, cipuraView;
    sendinfoFirestore sendinfo19,sendinfo20;
    ElegantNumberButton numberButton19,numberButton20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_fish);
        levrekText = findViewById(R.id.levrekText);
        cipuraText = findViewById(R.id.cipuraText);
        levrekButton = findViewById(R.id.levrekButton);
        cipuraButton = findViewById(R.id.cipuraButton);
        levrekView = findViewById(R.id.levrekView);
        cipuraView = findViewById(R.id.cipuraView);
        numberButton19 = findViewById(R.id.numberButton19);
        numberButton20 = findViewById(R.id.numberButton20);
    }

    public void addLevrek(View view){
        sendinfo19 = new sendinfoFirestore();
        String Sayac19 = numberButton19.getNumber();
        sendinfo19.sendInfo("Fishs/levrek.jpg","Levrek 400gr","12",Sayac19,12,"levrek");

    }
    public void addCipura(View view){
        sendinfo20 = new sendinfoFirestore();
        String Sayac20 = numberButton20.getNumber();
        sendinfo20.sendInfo("Fishs/cipura.jpg","Çipura 600gr","22",Sayac20,22,"cipura");

    }

}
