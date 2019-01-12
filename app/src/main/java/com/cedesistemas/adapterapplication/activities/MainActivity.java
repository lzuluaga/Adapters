package com.cedesistemas.adapterapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cedesistemas.adapterapplication.models.Product;
import com.cedesistemas.adapterapplication.R;
import com.cedesistemas.adapterapplication.adapters.AdapterProducts;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;

    private AdapterProducts adapterProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView2 = findViewById(R.id.recyclerViewa);
        loadAdapter();
    }

    private void loadAdapter(){
        Product product = new Product();
        product.setProductName("Empanada");
        product.setProductDescription("Deliciosas empanadas a tan solo 1.000 pesitos");

        ArrayList<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);

        adapterProducts = new AdapterProducts(products);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterProducts);
    }
}
