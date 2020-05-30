package com.gorkemozdemir.supermarketapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder> {
    private ArrayList<String> productNameList;
    private ArrayList<String> productNumberList;
    private ArrayList<String> productImageList;
    private ArrayList<String> productMoneyList;


    public FeedRecyclerAdapter(ArrayList<String> productNameList, ArrayList<String> productNumberList, ArrayList<String> productImageList,ArrayList<String> productMoneyList) {
        this.productNameList = productNameList;
        this.productNumberList = productNumberList;
        this.productImageList = productImageList;
        this.productMoneyList = productMoneyList;
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
        holder.textView.setText(productMoneyList.get(position));
        holder.textView1.setText(productNameList.get(position));
        holder.textView2.setText(productNumberList.get(position));
        Picasso.get().load(productImageList.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productNameList.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,textView1,textView2;


        public PostHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.recycler_row_imageview);
            textView = itemView.findViewById(R.id.recycler_row_moneyText);
            textView1 = itemView.findViewById(R.id.recycler_row_nameText);
            textView2 = itemView.findViewById(R.id.recycler_row_numberText);
        }




    }

}
