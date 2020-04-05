package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MyInterface {
    private ShareFragment shareFragment;
    private CaclFragment calcFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Button calcButton,shareButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shareFragment = new ShareFragment();
        calcFragment = new CaclFragment(this);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        initViews();
        addFragment(calcFragment);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(shareFragment);
            }
        });
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(calcFragment);
            }
        });
        Log.d("ololo", "onCreate: ");
    }

    private void initViews(){
        calcButton = findViewById(R.id.calculatorButton);
        shareButton = findViewById(R.id.shareButton);
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void addFragment(Fragment fragment){
        transaction.add(R.id.container,fragment).commit();
    }

    @Override
    public void save(String s) {
        Bundle bundle = new Bundle();
        bundle.putString("share", s);
        shareFragment.setArguments(bundle);
        Intent intent = new Intent(MainActivity.this,ShareFragment.class);
        startActivity(intent);
    }


    }


