package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] categories, descriptions;
    ListView ironmenListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        categories = resources.getStringArray(R.array.categories);
        descriptions = resources.getStringArray(R.array.descriptions);
        int icons[] = {R.drawable.ironman_icon, R.drawable.ultimate_ironman_icon, R.drawable.hardcore_ironman_icon};

        ironmenListView = findViewById(R.id.ironmenListView);
        ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), categories, descriptions, icons);
        ironmenListView.setAdapter(itemAdapter);

        ironmenListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("itemIndex", i);
                startActivity(intent);
            }
        });
    }
}