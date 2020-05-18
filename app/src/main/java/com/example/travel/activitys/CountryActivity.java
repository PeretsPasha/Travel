package com.example.travel.activitys;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travel.R;
import com.example.travel.adapters.TripsAdapter;
import com.example.travel.data.ItemsData;
import com.example.travel.models.Ads;
import com.example.travel.models.Item;
import com.example.travel.models.News;
import com.example.travel.models.Trip;

import java.util.ArrayList;
import java.util.List;

public class CountryActivity extends AppCompatActivity implements TripsAdapter.OnItemClickListener {

    private List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int id = bundle.getInt("id");

        ItemsData itemsData = new ItemsData(id);
        items = itemsData.getItems();

        TripsAdapter adapter = new TripsAdapter(items);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        if (position == 0){
            Item item = items.get(position);
            Trip trip = (Trip) item.getObject();
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("name", trip.getTripTitle());
            intent.putExtra("image", trip.getTripImage());
            startActivity(intent);
        } else if (position == 3){
            Item item = items.get(position);
            Trip trip = (Trip) item.getObject();
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("name", trip.getTripTitle());
            intent.putExtra("image", trip.getTripImage());
            startActivity(intent);
        }
    }
}
