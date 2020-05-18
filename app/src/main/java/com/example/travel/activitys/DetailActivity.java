package com.example.travel.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.travel.R;

public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        int image = bundle.getInt("image");
        textView.setText(name);
        imageView.setImageResource(image);
    }
}
