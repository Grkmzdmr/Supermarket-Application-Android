package com.gorkemozdemir.supermarketapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import org.w3c.dom.Text;

public class FirstScreen extends AppCompatActivity {
    ImageView button;
    TextView login, textView2, textView3, textView4, textView5, textView6, textView7, textView;


    String UserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);


        textView2 = findViewById(R.id.goMeyveText);
        textView3 = findViewById(R.id.sebzeText);
        textView4 = findViewById(R.id.meatText);
        textView5 = findViewById(R.id.fishText);
        textView6 = findViewById(R.id.kahvaltiText);
        textView7 = findViewById(R.id.sütText);

        button = findViewById(R.id.goMeyve);
        login = findViewById(R.id.goaccount);
        ImageView login1 = findViewById(R.id.goaccount2);




    }
















    public void goaccount(View view) {
        Intent intent = new Intent(FirstScreen.this, Account.class);
        startActivity(intent);
    }

    public void goMeyve(View view) {
        Intent intent = new Intent(FirstScreen.this, allFruits.class);
        startActivity(intent);
    }

    public void goSebze(View view) {
        Intent intent = new Intent(FirstScreen.this, allVegetables.class);
        startActivity(intent);
    }

    public void goEt(View view) {
        Intent intent = new Intent(FirstScreen.this, allMeat.class);
        startActivity(intent);
    }

    public void goBalık(View view) {
        Intent intent = new Intent(FirstScreen.this, allFish.class);
        startActivity(intent);
    }

    public void goKahvaltılık(View view) {
        Intent intent = new Intent(FirstScreen.this, allBreakfast.class);
        startActivity(intent);
    }

    public void goSüt(View view) {
        Intent intent = new Intent(FirstScreen.this, allMilk.class);
        startActivity(intent);
    }

    public void goBucket(View view) {
        Intent intent = new Intent(FirstScreen.this,cartActivity.class);
        startActivity(intent);
    }
    public void goCampaign(View view){
        Intent intentToCamp = new Intent(FirstScreen.this,Campaign.class);
        startActivity(intentToCamp);
    }
}
