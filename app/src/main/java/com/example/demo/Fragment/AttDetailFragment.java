package com.example.demo.Fragment;

import static com.example.demo.DetailActivity.INTENT_EXTRA;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import com.example.demo.Model.Attraction;
import com.example.demo.R;
import com.example.demo.Utils.Utils;
import com.example.demo.WebActivity;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

public class AttDetailFragment extends Fragment implements View.OnClickListener {

    private Attraction attraction;
    private Activity activity;
    private AppCompatActivity appCompatActivity;

    public static AttDetailFragment newInstance(Attraction attraction){
        AttDetailFragment attDetailFragment = new AttDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(INTENT_EXTRA, attraction);
        attDetailFragment.setArguments(bundle);
        return attDetailFragment;
    }

    public void onCreate(@NonNull Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            Attraction attraction = (Attraction) getArguments().getSerializable(INTENT_EXTRA);
            if(attraction != null){
                this.attraction = attraction;
            }
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.travel_fg_detail, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        CollapsingToolbarLayout collapsingToolbar = view.findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle(attraction.getAttName());

        final Toolbar toolbar = view.findViewById(R.id.toolbar);
        activity = getActivity();
        appCompatActivity = (AppCompatActivity)activity;
        ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        ImageView imageView = view.findViewById(R.id.backdrop);
        ImageSlider imageSlider = view.findViewById(R.id.viewSlider);
        List<SlideModel> slideModels = new ArrayList<>();


        if(attraction.getAttImg() != null && attraction.getAttImg().size() != 0){
            for(int i =0; i < attraction.getAttImg().size(); i++){
                slideModels.add(new SlideModel(attraction.getAttImg().get(i), ScaleTypes.FIT));
            }
//            Glide.with(this).load(attraction.getAttImg().get(0)).into(imageView);
        }
        else{
            slideModels.add(new SlideModel(R.drawable.ic_launcher_foreground, ScaleTypes.FIT));
//            imageView.setImageResource(R.drawable.ic_launcher_foreground);
        }
        imageSlider.setImageList(slideModels);
//        Glide.with(this).load(attraction.getAttImg().get(0)).into(imageView);

        TextView about = view.findViewById(R.id.aboutDetail);
        about.setText(attraction.getAttIntroduction());
        TextView address = view.findViewById(R.id.address);
        address.setText(attraction.getAttAddress());
        address.setOnClickListener(this);
        TextView modified = view.findViewById(R.id.modified);
        modified.setText(attraction.getAttModified());
        TextView url = view.findViewById(R.id.url);
        url.setText(attraction.getAttUrl());
        url.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(getContext() != null){
            switch (view.getId()){
                case R.id.address:
                    Utils.directionsIntent(getContext(), attraction.getAttAddress());
                    break;
                case R.id.url:
                    Intent intent = new Intent(getContext(), WebActivity.class);
                    intent.putExtra("url", attraction.getAttUrl());
                    startActivity(intent);
                    break;
            }
        }

    }
}
