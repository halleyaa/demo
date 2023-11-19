package com.example.demo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.demo.Model.Attraction;
import com.example.demo.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class AttractionDetailFragment extends AppCompatActivity implements View.OnClickListener {

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_fg_detail);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        String attImg = intent.getExtras().getString("attImg");
        String attName = intent.getExtras().getString("attName");
        String attAbout = intent.getExtras().getString("attAbout");

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle(attName);

//        ImageView imageView = (ImageView) findViewById(R.id.backdrop);
//        Glide.with(this).load(attImg).into(imageView);

        TextView about = (TextView) findViewById(R.id.aboutDetail);
        about.setText(attAbout);
    }

    @Override
    public void onClick(View view) {

    }
}
