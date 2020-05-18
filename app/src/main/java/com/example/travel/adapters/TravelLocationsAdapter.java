package com.example.travel.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travel.R;
import com.example.travel.models.TravelLocation;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TravelLocationsAdapter extends RecyclerView.Adapter<TravelLocationsAdapter.TravelLocationViewHolder>{

    private List<TravelLocation> travelLocations;
    private OnClickItemListener listener;

    public TravelLocationsAdapter(List<TravelLocation> travelLocations) {
        this.travelLocations = travelLocations;
    }

    @NonNull
    @Override
    public TravelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TravelLocationViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_location, parent, false), listener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TravelLocationViewHolder holder, int position) {
            holder.setLocationData(travelLocations.get(position));
    }

    @Override
    public int getItemCount() {
        return travelLocations.size();
    }

    static class TravelLocationViewHolder extends RecyclerView.ViewHolder{

        private KenBurnsView kbvLocation;
        private TextView textTitle, textLocation, textStarRating;

         TravelLocationViewHolder(@NonNull View itemView, final OnClickItemListener listener) {
            super(itemView);
            kbvLocation = itemView.findViewById(R.id.kbvLocation);
            textTitle = itemView.findViewById(R.id.textTitle);
            textLocation = itemView.findViewById(R.id.textLocation);
            textStarRating = itemView.findViewById(R.id.textStarRating);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.onItemClick(position);
                }
            });
         }

         void setLocationData(TravelLocation travelLocation){
             Picasso.get().load(travelLocation.imageUrl).into(kbvLocation);
             textTitle.setText(travelLocation.title);
             textLocation.setText(travelLocation.location);
             textStarRating.setText(String.valueOf(travelLocation.starRating));
         }
    }

    public interface OnClickItemListener{
        void onItemClick(int position);
    }

    public void setOnClickListener(OnClickItemListener listener){
        this.listener = listener;
    }


}
