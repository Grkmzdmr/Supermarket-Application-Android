package com.gorkemozdemir.supermarketapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LastScreen extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_screen);
        button = findViewById(R.id.backhome);

    }


    public void backHome(View view){
        Intent intentToMain = new Intent(LastScreen.this,FirstScreen.class);
        startActivity(intentToMain);
        finish();
    }

}
