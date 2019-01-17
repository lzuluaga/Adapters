package com.cedesistemas.adapterapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable {


    @SerializedName("name")
    @Expose
    private String productName;

    @SerializedName("description")
    @Expose
    private String productDescription;

    @SerializedName("quantity")
    @Expose
    private int quantity;

    @SerializedName("price")
    @Expose
    private int price;

    @SerializedName("brand")
    @Expose
    private String brand;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

}
