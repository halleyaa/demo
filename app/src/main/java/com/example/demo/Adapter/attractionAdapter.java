package com.example.demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demo.Fragment.AttractionDetailFragment;
import com.example.demo.Model.Attraction;
import com.example.demo.R;
import com.example.demo.Utils.Utils;

import java.util.ArrayList;

public class attractionAdapter extends RecyclerView.Adapter<attractionAdapter.AttViewHolder> {

    private final ArrayList<Attraction> attractions;
    private final Context context;

    public  attractionAdapter(ArrayList<Attraction> attractions, Context context) {
        this.attractions = attractions;
        this.context = context;
    }

    public AttViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType){
        return new AttViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.travel_fragment, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull final AttViewHolder attViewHolder, final int pos){
        final Attraction attraction = attractions.get(pos);

        if(attraction.getAttImg() != null && attraction.getAttImg().size() != 0){
            Glide.with(context).load(attraction.getAttImg().get(0)).into(attViewHolder.attImg);
        }
        else{
            attViewHolder.attImg.setImageResource(R.drawable.ic_launcher_foreground);
        }
        attViewHolder.attName.setText(attraction.getAttName());
        attViewHolder.attAbout.setText(attraction.getAttIntroduction());

        attViewHolder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Utils.detailIntent(context, attraction, attViewHolder.attImg);
            }
        });
    }

    @Override
    public int getItemCount() {
        return attractions.size();
    }

    public static class AttViewHolder extends RecyclerView.ViewHolder{
        final ImageView attImg;
        final TextView attName;
        final TextView attAbout;
        final CardView cardView;

        AttViewHolder(@NonNull View itemView){
            super(itemView);

            // Fetching view IDs for view elements from resource
            attImg = itemView.findViewById(R.id.travel_image);
            attName = itemView.findViewById(R.id.travel_name);
            attAbout = itemView.findViewById(R.id.travel_about);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
