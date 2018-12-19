package com.cedesistemas.adapterapplication;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IServices {

    @GET("products")
    Call<ArrayList<Product>> getProducts();
}
