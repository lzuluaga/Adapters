package com.cedesistemas.adapterapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cedesistemas.adapterapplication.activities.DetailActivity;
import com.cedesistemas.adapterapplication.models.Product;
import com.cedesistemas.adapterapplication.R;

import java.util.ArrayList;

public class AdapterProducts extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Product> productArrayList;
    private Context context;

    public AdapterProducts(ArrayList<Product> productArrayList){
        this.productArrayList = productArrayList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context =  viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_products, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        CustomViewHolder customViewHolder = (CustomViewHolder) viewHolder;
        final Product product = productArrayList.get(position);
        customViewHolder.textViewName.setText(product.getProductName());
        customViewHolder.textViewDescription.setText(product.getBrand());
        customViewHolder.cardViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("prodcut", product);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewName;
        private TextView textViewDescription;
        private CardView cardViewItem;

         CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
             cardViewItem = itemView.findViewById(R.id.cardviewItem);
        }
    }


}
