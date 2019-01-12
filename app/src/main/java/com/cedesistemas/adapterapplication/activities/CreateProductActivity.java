package com.cedesistemas.adapterapplication.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cedesistemas.adapterapplication.R;
import com.cedesistemas.adapterapplication.models.Product;
import com.cedesistemas.adapterapplication.repositories.Repository;

import java.io.IOException;

public class CreateProductActivity extends AppCompatActivity implements TextWatcher {

    private EditText product_etName;
    private EditText product_etDescription;
    private EditText product_etPrice;
    private EditText product_etQuantity;
    private EditText product_etBrand;
    private Button product_btnCreate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_product);
        loadView();
        loadEvents();
    }

    private void loadView() {
        product_etName = findViewById(R.id.product_etName);
        product_etName.addTextChangedListener(this);
        product_etDescription = findViewById(R.id.product_etDescription);
        product_etDescription.addTextChangedListener(this);
        product_etPrice = findViewById(R.id.product_etPrice);
        product_etPrice.addTextChangedListener(this);
        product_etQuantity = findViewById(R.id.product_etQuantity);
        product_etQuantity.addTextChangedListener(this);
        product_etBrand = findViewById(R.id.product_etBrand);
        product_etBrand.addTextChangedListener(this);
        product_btnCreate = findViewById(R.id.product_btnCreate);
    }

    private void loadEvents() {
        product_btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = new Product();
                product.setProductName(product_etName.getText().toString());
                product.setBrand(product_etBrand.getText().toString());
                product.setProductDescription(product_etDescription.getText().toString());
                product.setPrice(Integer.parseInt(product_etPrice.getText().toString()));
                product.setQuantity(Integer.parseInt(product_etQuantity.getText().toString()));

                createThreadCreateProduct(product);
            }
        });
    }

    private void createThreadCreateProduct(final Product product){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                createProduct(product);
            }
        });
        thread.start();
    }

    private void createProduct(Product product) {
        Repository repository = new Repository();
        try {
            repository.saveProducts(product);
            finish();
        } catch (final IOException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(CreateProductActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (product_etName.getText().toString().trim().isEmpty() || product_etBrand.getText().toString().trim().isEmpty()
                || product_etDescription.getText().toString().trim().isEmpty() ||
                product_etPrice.getText().toString().trim().isEmpty() ||
                product_etQuantity.getText().toString().trim().isEmpty()) {
            product_btnCreate.setEnabled(false);
            product_btnCreate.setBackgroundResource(R.color.colorGray);
        } else {
            product_btnCreate.setEnabled(true);
            product_btnCreate.setBackgroundResource(R.color.colorPrimaryDark);
        }

    }
}
