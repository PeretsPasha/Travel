package com.example.travel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Hi!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 locationsViewPager = findViewById(R.id.locationsViewPager);
        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelLocationEiffelTower = new TravelLocation();
        travelLocationEiffelTower.imageUrl = "https://fr.igotoworld.com/frontend/webcontent/websites/26/images/attractions/Eiffel-Tower/673_800x600_eiffel-tower.jpg";
        travelLocationEiffelTower.title = "Франція";
        travelLocationEiffelTower.location = "Ейфелева вежа";
        travelLocationEiffelTower.starRating = 4.8f;
        travelLocations.add(travelLocationEiffelTower);

        TravelLocation travelLocationMauntainView = new TravelLocation();
        travelLocationMauntainView.imageUrl = "https://w-dog.ru/wallpapers/3/6/498905481884605.jpg";
        travelLocationMauntainView.title = "Індонезія";
        travelLocationMauntainView.location = "Гірський вид";
        travelLocationMauntainView.starRating = 4.5f;
        travelLocations.add(travelLocationMauntainView);

        TravelLocation travelLocationTajMahal = new TravelLocation();
        travelLocationTajMahal.imageUrl = "https://tudam.ru/wp-content/uploads/2017/09/logo-2.jpg";
        travelLocationTajMahal.title = "Індія";
        travelLocationTajMahal.location = "Тадж Махал";
        travelLocationTajMahal.starRating = 4.4f;
        travelLocations.add(travelLocationTajMahal);

        TravelLocation travelLocationLakeView = new TravelLocation();
        travelLocationLakeView.imageUrl = "https://img5.goodfon.ru/wallpaper/nbig/1/df/cerulean-lake-mount-assiniboine-british-columbia-canada-ozer.jpg";
        travelLocationLakeView.title = "Канада";
        travelLocationLakeView.location = "Вид на озеро";
        travelLocationLakeView.starRating = 4.9f;
        travelLocations.add(travelLocationLakeView);

        locationsViewPager.setAdapter(new TravelLocationsAdapter(travelLocations));

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
}
