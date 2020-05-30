package com.gorkemozdemir.supermarketapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class LastScreen extends AppCompatActivity {
    Button button;
    ImageView delivery,smoke1;
    Animation right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_screen);
        button = findViewById(R.id.backhome);
        smoke1 = findViewById(R.id.smoke1);
        delivery = findViewById(R.id.delivery);
        right = AnimationUtils.loadAnimation(this, R.anim.rightoleft);
        delivery.setAnimation(right);
        smoke1.setAnimation(right);

    }


    public void backHome(View view){
        Intent intentToMain = new Intent(LastScreen.this,FirstScreen.class);
        startActivity(intentToMain);
        finish();
    }

}
