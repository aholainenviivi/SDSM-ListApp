package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int itemIndex = intent.getIntExtra("itemIndex", -1);

        int icons[] = {R.drawable.ironman_icon, R.drawable.ultimate_ironman_icon, R.drawable.hardcore_ironman_icon};

        ImageView secondActivityImageView = findViewById(R.id.secondActivityImageView);
        scaleImage(secondActivityImageView, icons[itemIndex]);
    }

    private void scaleImage(ImageView img, int icon) {
        Display display = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), icon, options);

        int imgWidth = options.outWidth;
        int displayWidth = display.getWidth();
        int ratio = Math.round((float) imgWidth / (float) displayWidth);
        options.inSampleSize = ratio;

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), icon, options);
        img.setImageBitmap(scaledImg);
    }

}