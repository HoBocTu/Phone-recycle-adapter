package com.example.stas.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Phone phone = getIntent().getParcelableExtra("phone");
        if (phone == null) System.out.printf("Error");
        ImageView image = findViewById(R.id.image);
        TextView name = findViewById(R.id.Name);
        TextView desk = findViewById(R.id.desk);
        image.setImageResource(phone.getImageResourceId());
        name.setText(phone.getName());
        desk.setText(phone.getDesk());
    }
}
