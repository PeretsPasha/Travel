package com.example.travel.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travel.models.Item;
import com.example.travel.R;
import com.example.travel.models.Ads;
import com.example.travel.models.News;
import com.example.travel.models.Trip;

import java.util.List;

public class TripsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Item> items;
    private OnItemClickListener listener;

    public TripsAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == 0){
            return new TripViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_conteiner_trip,
                            parent,
                            false), listener
                    );
        } else if (viewType == 1){
            return new AdsViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_container_ads,
                            parent,
                            false)
                    );

        } else {
            return new NewsViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_container_nws,
                            parent,
                            false)
                    );
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == 0){
            Trip trip = (Trip) items.get(position).getObject();
            ((TripViewHolder) holder).setTripDate(trip);
        } else if (getItemViewType(position) == 1){
            Ads ads = (Ads) items.get(position).getObject();
            ((AdsViewHolder) holder).setAdsDate(ads);
        } else {
            News news = (News) items.get(position).getObject();
            ((NewsViewHolder) holder).setNewsDate(news);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }



    static class TripViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageTrip;
        private TextView textTripTitle, textTrip;

        public TripViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imageTrip = itemView.findViewById(R.id.imageTrip);
            textTripTitle = itemView.findViewById(R.id.textTripTitle);
            textTrip = itemView.findViewById(R.id.textTrip);

            textTripTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.onItemClick(position);
                }
            });

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (listener != null){
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION){
//                            listener.onItemClick(position);
//                        }
//                    }
//                }
//            });
        }

        void setTripDate(Trip trip){
            imageTrip.setImageResource(trip.getTripImage());
            textTripTitle.setText(trip.getTripTitle());
            textTrip.setText(trip.getTrip());
        }
    }

    static class AdsViewHolder extends RecyclerView.ViewHolder{

        private TextView textAdsTitle, textAds;

        public AdsViewHolder(@NonNull View itemView) {
            super(itemView);
            textAdsTitle = itemView.findViewById(R.id.textAdsTitle);
            textAds = itemView.findViewById(R.id.textAds);
        }

        void setAdsDate(Ads ads){
            textAdsTitle.setText(ads.getAdsTitle());
            textAds.setText(ads.getAds());
        }
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder{

        private TextView textNewsTitle, textNews;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            textNewsTitle = itemView.findViewById(R.id.textNewsTitle);
            textNews = itemView.findViewById(R.id.textNews);
        }

        void setNewsDate(News news){
            textNewsTitle.setText(news.getNewsTitle());
            textNews.setText(news.getNews());
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

}
