package com.gorkemozdemir.supermarketapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class addAdress extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;
    String userId;
    TextView textView;
    EditText takeNName,takeSName,takeNNumber,takeCCity,takeAAdress;
    Button kaydet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_adress);
        textView = findViewById(R.id.teslimatAdresi);
        takeNName = findViewById(R.id.takeNName);
        takeSName = findViewById(R.id.takeSName);
        takeNNumber = findViewById(R.id.takeNNumber);
        takeNNumber.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        takeCCity = findViewById(R.id.takeCCity);
        takeAAdress = findViewById(R.id.takeAAdress);
        kaydet = findViewById(R.id.kaydet);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();





    }
    public void kaydet(View view){
        String userNameAgain = takeNName.getText().toString();
        String userSNameAgain = takeSName.getText().toString();
        String userNumberAgain = takeNNumber.getText().toString();
        String userCityAgain = takeCCity.getText().toString();
        String userAdressAgain = takeAAdress.getText().toString();
        Map<String,Object> postData = new HashMap<>();
        postData.put("NameAgain",userNameAgain);
        postData.put("SNameAgain",userSNameAgain);
        postData.put("telephoneAgain",userNumberAgain);
        postData.put("cityAgain",userCityAgain);
        postData.put("adress",userAdressAgain);
        userId =firebaseAuth.getCurrentUser().getUid();
        firebaseFirestore.collection("Deliveryİnfo").document(userId).set(postData);
        Intent intent = new Intent(addAdress.this,Adress.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }


}
