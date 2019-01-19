package com.example.stas.myapplication;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("iPhone XS", "New f**king iPhone from Apple", R.drawable.index));
        phones.add(new Phone("Pocophone F2", "New master from Xiaomi", R.drawable.index1));
        RecyclerView phonesRecycler = findViewById(R.id.phonesRecycler);
        phonesRecycler.setLayoutManager(new LinearLayoutManager(this));
        phonesRecycler.setAdapter(new PhoneRecycleAdapter(phones));
    }
}
