package com.gorkemozdemir.supermarketapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.gorkemozdemir.supermarketapplication.Firestore.sendinfoFirestore;

public class allMilk extends AppCompatActivity {
    TextView peynirText, kasarText,yumurtaText,sutText,tereyagText;
    Button peynirButton, kasarButton,yumurtaButton,sutButton,tereyagButton;
    ImageView peynirView, kasarView,yumurtaView,sutView,tereyagView;
    sendinfoFirestore sendinfo26,sendinfo27,sendinfo28,sendinfo29,sendinfo30;
    ElegantNumberButton numberButton26, numberButton27,numberButton28,numberButton29,numberButton30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_milk);
        peynirText = findViewById(R.id.peynirText);
        kasarText = findViewById(R.id.kasarText);
        yumurtaText = findViewById(R.id.yumurtaText);
        sutText = findViewById(R.id.sutText);
        tereyagText = findViewById(R.id.tereyagText);
        peynirButton = findViewById(R.id.peynirButton);
        kasarButton = findViewById(R.id.kasarButton);
        yumurtaButton = findViewById(R.id.yumurtaButton);
        sutButton = findViewById(R.id.sutButton);
        tereyagButton = findViewById(R.id.tereyagButton);
        peynirView = findViewById(R.id.peynirView);
        kasarView = findViewById(R.id.kasarView);
        yumurtaView = findViewById(R.id.yumurtaView);
        sutView = findViewById(R.id.sutView);
        tereyagView = findViewById(R.id.tereyagView);
        numberButton26 = findViewById(R.id.numberButton26);
        numberButton27 = findViewById(R.id.numberButton27);
        numberButton28 = findViewById(R.id.numberButton28);
        numberButton29 = findViewById(R.id.numberButton29);
        numberButton30 = findViewById(R.id.numberButton30);






    } public void addPeynir(View view){
        sendinfo26 = new sendinfoFirestore();
        String Sayac26 = numberButton26.getNumber();
        sendinfo26.sendInfo("Milks/peynir.jpg", "Peynir 500g.", "22", Sayac26, 22, "peynir");

    }
    public void addKasar(View view){
        sendinfo27 = new sendinfoFirestore();
        String Sayac27 = numberButton27.getNumber();
        sendinfo27.sendInfo("Milks/kasar.jpg", "Kaşar 500g.", "20", Sayac27, 20, "kasar");

    }
    public void addYumurta(View view){
        sendinfo28 = new sendinfoFirestore();
        String Sayac28 = numberButton27.getNumber();
        sendinfo28.sendInfo("Milks/yumurta.jpg", "Yumurta 15A.", "10", Sayac28, 10, "yumurta");

    }
    public void addSut(View view){
        sendinfo29 = new sendinfoFirestore();
        String Sayac29 = numberButton28.getNumber();
        sendinfo29.sendInfo("Milks/sut.jpg", "Süt 1 Lt", "9", Sayac29, 9, "sut");

    }
    public void addTereyag(View view){
        sendinfo30 = new sendinfoFirestore();
        String Sayac30 = numberButton30.getNumber();
        sendinfo30.sendInfo("Milks/tereyag.jpg", "Tereyağ 500g.", "42", Sayac30, 42, "tereyag");

    }





}
