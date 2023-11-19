package com.example.demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.demo.databinding.ActivitySplashBinding;

public class activity_splash extends AppCompatActivity {

//    private ImageView logo;
    private TextView logo;
    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.logo);
        progressBar = findViewById(R.id.progressBar);

        Drawable drawable = getResources().getDrawable(R.drawable.taipei_travel);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth()/2, drawable.getIntrinsicHeight()/2);
        logo.setCompoundDrawables(null, drawable, null, null);

        logo.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);

        int START_TIME = 1500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation fade = AnimationUtils.loadAnimation(activity_splash.this, R.anim.fade_in);
                logo.startAnimation(fade);
                logo.setVisibility(View.VISIBLE);
            }
        }, START_TIME);

        int LAUNCH_TIME = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
                Intent intentMain = new Intent(activity_splash.this, MainActivity.class);
                startActivity(intentMain);

                finish();
            }
        }, LAUNCH_TIME);
    }
}