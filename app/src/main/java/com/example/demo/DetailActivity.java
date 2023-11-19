package com.example.demo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.demo.Fragment.AttDetailFragment;
import com.example.demo.Model.Attraction;

public class DetailActivity extends AppCompatActivity {

    public static final String INTENT_EXTRA  = "extras";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Object object = getIntent().getSerializableExtra(INTENT_EXTRA);
        Fragment fragment = null;
        fragment = AttDetailFragment.newInstance((Attraction) object);

        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
//        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }

}
