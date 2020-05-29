package com.gorkemozdemir.supermarketapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CartNotLogin extends AppCompatActivity {
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_not_login);
        textView = findViewById(R.id.cartText);
        button = findViewById(R.id.cartLog);

    }


    public void CartLogin(View view){
        Intent intent = new Intent(CartNotLogin.this,SignInActivity.class);
        startActivity(intent);
    }

}
