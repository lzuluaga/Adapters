package com.cedesistemas.adapterapplication.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.cedesistemas.adapterapplication.fragments.OneFragment;
import com.cedesistemas.adapterapplication.R;
import com.cedesistemas.adapterapplication.fragments.TwoFragment;

public class Main2Activity extends AppCompatActivity {

    private TextView textViewOne;
    private TextView textViewTwo;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewOne = findViewById(R.id.textViewOne);
        textViewTwo = findViewById(R.id.textViewTwo);
        frameLayout = findViewById(R.id.frameLayout);

        textViewOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new OneFragment());
            }
        });

        textViewTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new TwoFragment());
            }
        });
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameLayout.getId(), fragment);
        transaction.commit();

    }
}
