package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int itemIndex = intent.getIntExtra("itemIndex", -1);

        String[] categories = getResources().getStringArray(R.array.categories);
        TextView secondActivityTextView = findViewById(R.id.secondActivityTextView);
        secondActivityTextView.setText("You clicked on " + categories[itemIndex]);
    }
}