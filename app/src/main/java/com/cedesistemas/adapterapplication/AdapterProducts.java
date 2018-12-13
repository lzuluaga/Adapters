package com.cedesistemas.adapterapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterProducts extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Product> productArrayList;

    public AdapterProducts(ArrayList<Product> productArrayList){
        this.productArrayList = productArrayList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_products, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        CustomViewHolder customViewHolder = (CustomViewHolder) viewHolder;
        Product product = productArrayList.get(position);
        customViewHolder.textViewName.setText(product.getProductName());
        customViewHolder.textViewDescription.setText(product.getProductDescription());
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewName;
        private TextView textViewDescription;

         CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
    }


}
