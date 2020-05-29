package com.gorkemozdemir.supermarketapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.gorkemozdemir.supermarketapplication.Firestore.sendinfoFirestore;

public class allMeat extends AppCompatActivity {
    TextView kıymaText, kusbasıText,biftekText,tavukbText,tavukgText,kanatText;
    Button kıymaButton, kusbasıButton,biftekButton,tavukbButton,tavukgButton,kanatButton;
    ImageView kıymaView, kusbasıView,biftekView,tavukbView,tavukgView,kanatView;
    sendinfoFirestore sendinfo13,sendinfo14,sendinfo15,sendinfo16,sendinfo17,sendinfo18;
    ElegantNumberButton numberButton13, numberButton14,numberButton15,numberButton16,numberButton17,numberButton18;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_meat);
        kıymaText = findViewById(R.id.kıymaText);
        kusbasıText = findViewById(R.id.kusbasıText);
        biftekText = findViewById(R.id.biftekText);
        tavukbText= findViewById(R.id.tavukbText);
        tavukgText = findViewById(R.id.tavukgText);
        kanatText = findViewById(R.id.kanatText);
        kıymaButton = findViewById(R.id.kıymaButton);
        kusbasıButton = findViewById(R.id.kusbasıButton);
        biftekButton = findViewById(R.id.biftekButton);
        tavukbButton = findViewById(R.id.tavukbButton);
        tavukgButton = findViewById(R.id.tavukgButton);
        kanatButton = findViewById(R.id.kanatButton);
        kıymaView = findViewById(R.id.kıymaView);
        kusbasıView = findViewById(R.id.kusbasıView);
        biftekView = findViewById(R.id.biftekView);
        tavukbView = findViewById(R.id.tavukbView);
        tavukgView = findViewById(R.id.tavukgView);
        kanatView = findViewById(R.id.kanatView);
        numberButton13 = findViewById(R.id.numberButton13);
        numberButton14 = findViewById(R.id.numberButton14);
        numberButton15 = findViewById(R.id.numberButton15);
        numberButton16 = findViewById(R.id.numberButton16);
        numberButton17 = findViewById(R.id.numberButton17);
        numberButton18 = findViewById(R.id.numberButton18);

    }
    public void addKıyma(View view){
        sendinfo13 = new sendinfoFirestore();
        String Sayac13 = numberButton13.getNumber();
        sendinfo13.sendInfo("Meats/kiyma.jpg","Kıyma 250gr","15",Sayac13,15,"kıyma");

    }

    public void addKusbası(View view){
        sendinfo14 = new sendinfoFirestore();
        String Sayac14 = numberButton14.getNumber();
        sendinfo14.sendInfo("Meats/kusb.jpg","Kuşbaşı 500gr","25",Sayac14,25,"kusbası");

    }

    public void addBiftek(View view){
        sendinfo15 = new sendinfoFirestore();
        String Sayac15 = numberButton15.getNumber();
        sendinfo15.sendInfo("Meats/biftek.jpg","Biftek 250gr","18",Sayac15,18,"biftek");

    }
    public void addTavukb(View view){
        sendinfo16 = new sendinfoFirestore();
        String Sayac16 = numberButton16.getNumber();
        sendinfo16.sendInfo("Meats/tavk.jpg","Tavuk Bütün","18",Sayac16,18,"tavukb");

    }
    public void addTavukg(View view){
        sendinfo17 = new sendinfoFirestore();
        String Sayac17 = numberButton17.getNumber();
        sendinfo17.sendInfo("Meats/tavkg.jpg","Tavuk Göğsü 500g","12",Sayac17,12,"tavukg");

    }
    public void addKanat(View view){
        sendinfo18 = new sendinfoFirestore();
        String Sayac18 = numberButton18.getNumber();
        sendinfo18.sendInfo("Meats/kanat.jpg","Tavuk Kanat 500gr","15",Sayac18,15,"kanat");

    }


}
