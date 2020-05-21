package com.example.travel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import com.example.travel.activitys.CountryActivity;
import com.example.travel.activitys.LoginActivity;
import com.example.travel.activitys.ProfileActivity;
import com.example.travel.adapters.TravelLocationsAdapter;
import com.example.travel.data.LocationsData;
import com.example.travel.models.TravelLocation;

import java.util.List;


public class MainActivity extends AppCompatActivity implements TravelLocationsAdapter.OnClickItemListener {

    TravelLocationsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 locationsViewPager = findViewById(R.id.locationsViewPager);

        LocationsData locationsData = new LocationsData();
        List<TravelLocation> travelLocations = locationsData.getTravelLocations();

        adapter = new TravelLocationsAdapter(travelLocations);
        adapter.setOnClickListener(this);

        CardView imageProfile = findViewById(R.id.cardProfilePicture);
        registerForContextMenu(imageProfile);

        locationsViewPager.setAdapter(adapter);

        locationsViewPager.setClipToPadding(false);
        locationsViewPager.setClipChildren(false);
        locationsViewPager.setOffscreenPageLimit(3);
        locationsViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });

        locationsViewPager.setPageTransformer(compositePageTransformer);
    }

    @Override
    public void onItemClick(int position) {
        if (position == 0){
            Intent intent = new Intent(getApplicationContext(), CountryActivity.class);
            intent.putExtra("id", position);
            startActivity(intent);
        } else if (position == 1){
            Intent intent = new Intent(getApplicationContext(), CountryActivity.class);
            intent.putExtra("id", position);
            startActivity(intent);
        } else if (position == 2){
            Intent intent = new Intent(getApplicationContext(), CountryActivity.class);
            intent.putExtra("id", position);
            startActivity(intent);
        } else if (position == 3){
            Intent intent = new Intent(getApplicationContext(), CountryActivity.class);
            intent.putExtra("id", position);
            startActivity(intent);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Авторизація");
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.option_1:
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                return true;
            case R.id.option_2:
                Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
