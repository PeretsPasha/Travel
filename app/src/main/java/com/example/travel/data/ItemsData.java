package com.example.travel.data;

import com.example.travel.R;
import com.example.travel.models.Ads;
import com.example.travel.models.Item;
import com.example.travel.models.News;
import com.example.travel.models.Trip;

import java.util.ArrayList;
import java.util.List;

public class ItemsData {

    private List<Item> items = new ArrayList<>();

    public ItemsData(int id) {

        if (id == 0) {

            Trip trip1 = new Trip(R.drawable.paris, "Париж", "fdgkjdвапвапвапвапfhkghdk");
            items.add(new Item(0, trip1));

            Ads ads1 = new Ads("dfsf", "sdfвапвапвапвапвапвапвапавпвапвапвавапавпвsf");
            items.add(new Item(1, ads1));

            News news1 = new News("dfgdf", "sdfвапвапвапвапвdfdsffdsfjkhsdkfdsfksdkjfkdsjkfkjsdfjksdkfkjsdkjfksdkfjksdjfkjsdkjfhапвапвапвапвапвапвпs");
            items.add(new Item(3, news1));

            Trip trip2 = new Trip(R.drawable.paris, "Париж", "fdgkjdfпвпвапвапвапвапвапвпhkghdk");
            items.add(new Item(0, trip2));

            Ads ads2 = new Ads("dfsf", "sdfвапвапвапвапвапвапвапвапвапвапвапвапвапвапавпвапsf");
            items.add(new Item(1, ads2));

            Trip trip3 = new Trip(R.drawable.paris, "Париж", "fdgkjdвапвапвапвапвапвfhkghdk");
            items.add(new Item(0, trip3));

            News news2 = new News("dfgdf", "sdвапвпвапвапвапвапвапвfdskfjksdljkfjklsdfjlsdkfjlksdjflksdjflksdjlfjsdklfjlsdsdfdsfапвпвапвапвапвапвапвапвапавпвапвапвапвапfs");
            items.add(new Item(3, news2));

            Trip trip4 = new Trip(R.drawable.paris, "Париж", "fdgkjdвапвапвапвапfhkghdk");
            items.add(new Item(0, trip4));

            Ads ads3 = new Ads("dfsf", "sdfвапвапвапвапвапвапвапавпвапвапвавапавпвsf");
            items.add(new Item(1, ads3));

            News news3 = new News("dfgdf", "sdfвапвапвапвапвапвапsdfsdfsdfksld;kfsdkl;fs;dkf;dslfkl;sdklfksd;lfk;lsd;lfksd;fl;sd;fk;lsdkfвапвапвапвапвпs");
            items.add(new Item(3, news3));

            Trip trip5 = new Trip(R.drawable.paris, "Париж", "fdgkjdfпвпвапвапвапвапвапвпhkghdk");
            items.add(new Item(0, trip5));

            Ads ads4 = new Ads("dfsf", "sdfвапвапвапвапвапвапвапвапвапвапвапвапвапвапавпвапsf");
            items.add(new Item(1, ads4));

            Trip trip6 = new Trip(R.drawable.paris, "Бора-бора", "fdgkjdвапвапвапвапвапвfhkghdk");
            items.add(new Item(0, trip6));

            News news4 = new News("dfgdf", "sdвапвпвапвапвапваdsfsdfsdl;fklsdl;f;sd;lfsd;lf;lsdkf;lsd;lfkl;dsksdkпвапвапвпвапвапвапвапвапвапвапавпвапвапвапвапfs");
            items.add(new Item(3, news4));

        } else if (id == 1){

            Trip trip5 = new Trip(R.drawable.london, "Лондон", "fdgkjdfпвпвапвапвапвапвапвпhkghdk");
            items.add(new Item(0, trip5));

            Ads ads4 = new Ads("dfsf", "sdfвапвапвапвапвапвапвапвапвапвапвапвапвапвапавпвапsf");
            items.add(new Item(1, ads4));

            Trip trip6 = new Trip(R.drawable.london, "Лондон", "fdgkjdвапвапвапвапвапвfhkghdk");
            items.add(new Item(0, trip6));

            News news4 = new News("dfgdf", "sdвапвпвапвапвапваdsfsdfsdl;fklsdl;f;sd;lfsd;lf;lsdkf;lsd;lfkl;dsksdkпвапвапвпвапвапвапвапвапвапвапавпвапвапвапвапfs");
            items.add(new Item(3, news4));

            News news3 = new News("dfgdf", "sdfвапвапвапвапвапвапsdfsdfsdfksld;kfsdkl;fs;dkf;dslfkl;sdklfksd;lfk;lsd;lfksd;fl;sd;fk;lsdkfвапвапвапвапвпs");
            items.add(new Item(3, news3));

            Trip trip1 = new Trip(R.drawable.london, "Лондон", "fdgkjdfпвпвапвапвапвапвапвпhkghdk");
            items.add(new Item(0, trip1));

            Ads ads2 = new Ads("dfsf", "sdfвапвапвапвапвапвапвапвапвапвапвапвапвапвапавпвапsf");
            items.add(new Item(1, ads2));

            Trip trip3 = new Trip(R.drawable.london, "Лондон", "fdgkjdвапвапвапвапвапвfhkghdk");
            items.add(new Item(0, trip3));

            News news2 = new News("dfgdf", "sdвапвпвапвапвапваdsfsdfsdl;fklsdl;f;sd;lfsd;lf;lsdkf;lsd;lfkl;dsksdkпвапвапвпвапвапвапвапвапвапвапавпвапвапвапвапfs");
            items.add(new Item(3, news2));

        } else if (id == 2){

            News news3 = new News("dfgdf", "sdfвапвапвапвапвапвапsdfsdfsdfksld;kfsdkl;fs;dkf;dslfkl;sdklfksd;lfk;lsd;lfksd;fl;sd;fk;lsdkfвапвапвапвапвпs");
            items.add(new Item(3, news3));

            Trip trip5 = new Trip(R.drawable.bali, "Балі", "fdgkjdfпвпвапвапвапвапвапвпhkghdk");
            items.add(new Item(0, trip5));

            Ads ads4 = new Ads("dfsf", "sdfвапвапвапвапвапвапвапвапвапвапвапвапвапвапавпвапsf");
            items.add(new Item(1, ads4));

            Trip trip6 = new Trip(R.drawable.bora, "Бора-бора", "fdgkjdвапвапвапвапвапвfhkghdk");
            items.add(new Item(0, trip6));

            News news4 = new News("dfgdf", "sdвапвпвапвапвапваdsfsdfsdl;fklsdl;f;sd;lfsd;lf;lsdkf;lsd;lfkl;dsksdkпвапвапвпвапвапвапвапвапвапвапавпвапвапвапвапfs");
            items.add(new Item(3, news4));

        }

    }

    public List<Item> getItems(){
        return items;
    }
}
