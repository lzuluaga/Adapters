package com.cedesistemas.adapterapplication.repositories;

import com.cedesistemas.adapterapplication.models.Product;
import com.cedesistemas.adapterapplication.services.ServicesFactory;
import com.cedesistemas.adapterapplication.services.IServices;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;


public class Repository {

    private IServices iServices;

    public Repository() {
        ServicesFactory servicesFactory = new ServicesFactory();
        iServices = (IServices) servicesFactory.getInstanceService(IServices.class);
    }

    public ArrayList<Product> getProducts() throws IOException{
        try{
            Call<ArrayList<Product>> call =  iServices.getProducts();
            Response<ArrayList<Product>> response = call.execute();
            if (response.errorBody() != null){
                throw  defaultError();
            }else{
                return response.body();
            }
        }catch(IOException e){
            throw defaultError();
        }
    }

    private IOException defaultError(){
        return new IOException("Ha ocurrido un error");
    }


}
