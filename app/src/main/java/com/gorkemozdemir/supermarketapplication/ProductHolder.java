package com.gorkemozdemir.supermarketapplication;

import android.app.DownloadManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductHolder extends RecyclerView.Adapter<ProductHolder.ViewHolder>  {
    private ArrayList<String> productNames;
    private ArrayList<String> productMoney;
    private ArrayList<String> productDesc;



    public ProductHolder(ArrayList<String> productNames, ArrayList<String> productMoney, ArrayList<String> productDesc) {
        this.productNames = productNames;
        this.productMoney = productMoney;
        this.productDesc = productDesc;


    }

    @NonNull
    @Override
    public ProductHolder.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view1 = layoutInflater.inflate(R.layout.productdetails, parent, false);
        return new ViewHolder(view1);
    }



    @Override
    public void onBindViewHolder(@NonNull ProductHolder.ViewHolder holder, int position) {
        holder.text.setText(productNames.get(position));
        holder.text1.setText(productMoney.get(position));
        Picasso.get().load(productDesc.get(position)).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return productNames.size();
    }

    public void onBindViewHolder1(@NonNull ProductHolder.ViewHolder holder,int position) {
        productNames.get(holder.getAdapterPosition());
        productDesc.get(holder.getAdapterPosition());
        productMoney.get(holder.getAdapterPosition());
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text, text1,text2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.product_details_image);
            text = itemView.findViewById(R.id.nameee);
            text1 = itemView.findViewById(R.id.moneyyy);



        }
    }
}