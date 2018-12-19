package com.cedesistemas.adapterapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;

    private AdapterProducts adapterProducts;
    private Repository repository;



    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView2 = view.findViewById(R.id.recyclerViewa);
        repository = new Repository();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getProducts();
            }
        });
        thread.start();
        return view;
    }

    private void getProducts() {
        try{
            ArrayList<Product> products = repository.getProducts();
            loadAdapter(products);
        }catch(final IOException e){
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private  void loadAdapter(final ArrayList<Product> products){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapterProducts = new AdapterProducts(products);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapterProducts);
            }
        });
    }



}
