package com.gorkemozdemir.supermarketapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class animation extends AppCompatActivity {
    ImageView organikText, mountView, sunView;
    Animation frombottom, fromtop, rightoleft;
    private static int Splash = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        organikText = findViewById(R.id.organiktext);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        rightoleft = AnimationUtils.loadAnimation(this, R.anim.rightoleft);
        organikText.setAnimation(frombottom);
        mountView = findViewById(R.id.mountView);
        mountView.setAnimation(frombottom);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        sunView = findViewById(R.id.sunView);
        sunView.setAnimation(fromtop);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intenttoFirst = new Intent(animation.this, FirstScreen.class);
                startActivity(intenttoFirst);
                finish();
            }
        }, Splash);


    }
}
