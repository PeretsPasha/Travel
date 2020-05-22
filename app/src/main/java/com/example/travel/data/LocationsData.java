package com.example.travel.data;

import com.example.travel.models.TravelLocation;

import java.util.ArrayList;
import java.util.List;

public class LocationsData {

    List<TravelLocation> travelLocations = new ArrayList<>();

    public LocationsData() {

        TravelLocation travelLocationParis = new TravelLocation();
        travelLocationParis.imageUrl = "https://media-cdn.tripadvisor.com/media/photo-c/1024x250/17/15/6d/d6/paris.jpg";
        travelLocationParis.title = "Париж";
        travelLocationParis.location = "Франція";
        travelLocationParis.starRating = 4.8f;
        travelLocations.add(travelLocationParis);

        TravelLocation travelLocationLondon = new TravelLocation();
        travelLocationLondon.imageUrl = "https://www.history.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTYyNDg1MjE3MTI1Mjc5Mzk4/topic-london-gettyimages-760251843-promo.jpg";
        travelLocationLondon.title = "Лондон";
        travelLocationLondon.location = "Велика Британія";
        travelLocationLondon.starRating = 4.5f;
        travelLocations.add(travelLocationLondon);

        TravelLocation travelLocationTajMahal = new TravelLocation();
        travelLocationTajMahal.imageUrl = "https://tudam.ru/wp-content/uploads/2017/09/logo-2.jpg";
        travelLocationTajMahal.title = "Агра";
        travelLocationTajMahal.location = "Індія";
        travelLocationTajMahal.starRating = 4.4f;
        travelLocations.add(travelLocationTajMahal);

        TravelLocation travelLocationNewYork = new TravelLocation();
        travelLocationNewYork.imageUrl = "https://wallpaperstream.com/wallpapers/full/new-york-city/New-York-City-Skyline-HD-Wallpaper.jpg";
        travelLocationNewYork.title = "Нью-йорк";
        travelLocationNewYork.location = "США";
        travelLocationNewYork.starRating = 4.9f;
        travelLocations.add(travelLocationNewYork);

    }

    public List<TravelLocation> getTravelLocations(){
            return travelLocations;
    }
}
