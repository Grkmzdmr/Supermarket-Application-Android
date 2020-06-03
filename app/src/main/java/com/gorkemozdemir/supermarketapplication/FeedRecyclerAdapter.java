package com.gorkemozdemir.supermarketapplication;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder> {
    private ArrayList<String> productNameList;
    private ArrayList<String> productNumberList;
    private ArrayList<String> productImageList;
    private ArrayList<String> productMoneyList;
    private ArrayList<String> productLastMoneyList;


    int toplam;
    FeedRecyclerAdapter feedRecyclerAdapter;

    public FeedRecyclerAdapter(ArrayList<String> productNameList, ArrayList<String> productNumberList, ArrayList<String> productImageList,ArrayList<String> productMoneyList,ArrayList<String> productLastMoneyList) {
        this.productNameList = productNameList;
        this.productNumberList = productNumberList;
        this.productImageList = productImageList;
        this.productMoneyList = productMoneyList;
        this.productLastMoneyList = productMoneyList;

    }

    @NonNull
    @Override
    public FeedRecyclerAdapter.PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row,parent,false);

        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedRecyclerAdapter.PostHolder holder, int position) {

        holder.textView1.setText(productNameList.get(position));
        holder.editText.setText(productNumberList.get(position));
        Picasso.get().load(productImageList.get(position)).into(holder.imageView);
        holder.changeproduct(position,holder);
        holder.editText.setText(productNumberList.get(position));
        holder.textView.setText(productLastMoneyList.get(position));







    }

    @Override
    public int getItemCount() {
        return productNameList.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,textView1;
        EditText editText;
        Button button;
        String UserId;
        FirebaseAuth firebaseAuth;

        private DocumentReference documentReference;
        private FirebaseFirestore firebaseFirestore;


        public PostHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.changeButton);
            imageView = itemView.findViewById(R.id.recycler_row_imageview);
            textView = itemView.findViewById(R.id.recycler_row_moneyText);
            textView1 = itemView.findViewById(R.id.recycler_row_nameText);
            editText = itemView.findViewById(R.id.recycler_row_numberText);
            firebaseAuth = FirebaseAuth.getInstance();
            firebaseFirestore = FirebaseFirestore.getInstance();
        }

        public void changeproduct(final int position, @NonNull final FeedRecyclerAdapter.PostHolder holder) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    UserId = firebaseAuth.getCurrentUser().getUid();
                    documentReference = firebaseFirestore.collection(UserId).document(productNameList.get(getAdapterPosition()));
                    final String number = editText.getText().toString();
                    final Map<String, Object> data = new HashMap<>();
                    int money = Integer.parseInt(number);
                    int realmoney = Integer.parseInt(productMoneyList.get(holder.getAdapterPosition()));
                    toplam = money * realmoney;
                    data.put("productNumber",number);
                    data.put("lastPay",toplam);

                    documentReference.update(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            editText.setText(number);
                            textView.setText(String.valueOf(toplam));
                            HashMap<String,Object> priceData = new HashMap<>();
                            priceData.put("price",String.valueOf(toplam));
                            documentReference = firebaseFirestore.collection(UserId).document();
                            documentReference.set(priceData);




                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });

                }

            });

        }

    }

}
