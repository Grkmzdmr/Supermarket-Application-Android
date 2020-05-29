package com.gorkemozdemir.supermarketapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.gorkemozdemir.supermarketapplication.Firestore.sendinfoFirestore;

public class allBreakfast extends AppCompatActivity {
    TextView sucukText, zeytinText,fumeText,balText,pastırmaText;
    Button sucukButton, zeytinButton,fumeButton,balButton,pastırmaButton;
    ImageView sucukView, zeytinView,fumeView,balView,pastırmaView;
    sendinfoFirestore sendinfo21,sendinfo22,sendinfo23,sendinfo24,sendinfo25;
    ElegantNumberButton numberButton21, numberButton22,numberButton23,numberButton24,numberButton25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_breakfast);
        sucukText = findViewById(R.id.sucukText);
        zeytinText = findViewById(R.id.zeytinText);
        fumeText = findViewById(R.id.fumeText);
        balText = findViewById(R.id.balText);
        pastırmaText = findViewById(R.id.pastırmaText);
        sucukButton = findViewById(R.id.sucukButton);
        zeytinButton = findViewById(R.id.zeytinButton);
        fumeButton = findViewById(R.id.fumeButton);
        balButton = findViewById(R.id.balButton);
        pastırmaButton = findViewById(R.id.pastırmaButton);
        sucukView = findViewById(R.id.sucukView);
        zeytinView = findViewById(R.id.zeytinView);
        fumeView = findViewById(R.id.fumeView);
        balView = findViewById(R.id.balView);
        pastırmaView = findViewById(R.id.pastırmaView);
        numberButton21 = findViewById(R.id.numberButton21);
        numberButton22 = findViewById(R.id.numberButton22);
        numberButton23 = findViewById(R.id.numberButton23);
        numberButton24 = findViewById(R.id.numberButton24);
        numberButton25 = findViewById(R.id.numberButton25);

    }


    public void addSucuk(View view){
        sendinfo21 = new sendinfoFirestore();
        String Sayac21 = numberButton21.getNumber();
        sendinfo21.sendInfo("Breakfasts/sucuk.jpg", "Sucuk 500g.", "50", Sayac21, 50, "sucuk");

    }
    public void addZeytin(View view){
        sendinfo22 = new sendinfoFirestore();
        String Sayac22 = numberButton22.getNumber();
        sendinfo22.sendInfo("Breakfasts/zeytin.jpg", "Zeytin 500g.", "18", Sayac22, 18, "zeytin");

    }
    public void addFume(View view){
        sendinfo23 = new sendinfoFirestore();
        String Sayac23 = numberButton21.getNumber();
        sendinfo23.sendInfo("Breakfasts/fume.jpg", "Fume 500g.", "40", Sayac23, 40, "fume");

    }
    public void addBal(View view){
        sendinfo24 = new sendinfoFirestore();
        String Sayac24 = numberButton21.getNumber();
        sendinfo24.sendInfo("Breakfasts/bal.jpg", "Bal 250g.", "35", Sayac24, 35, "bal");

    }
    public void addPastırma(View view){
        sendinfo25 = new sendinfoFirestore();
        String Sayac25 = numberButton25.getNumber();
        sendinfo25.sendInfo("Breakfasts/pastirma.jpg", "Pastırma 100g.", "45", Sayac25, 45, "pastırma");

    }



}
