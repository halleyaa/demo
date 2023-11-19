package com.example.demo;

import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.demo.Adapter.TabAdapter;
import com.example.demo.Adapter.attractionAdapter;
import com.example.demo.Data.attractionData;
import com.example.demo.Fragment.attEngFragment;
import com.example.demo.Fragment.attKoFragment;
import com.example.demo.Fragment.attractionFragment;
import com.example.demo.Model.Attraction;
import com.example.demo.Utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private TabAdapter tabAdapter;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabAdapter = new TabAdapter(this);
        tabAdapter.addFragment(new attractionFragment(), "tw");
        tabAdapter.addFragment(new attKoFragment(), "ko");
        tabAdapter.addFragment(new attEngFragment(), "eng");

        viewPager2 = findViewById(R.id.view_pager2);
        viewPager2.setAdapter(tabAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.translate_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.tw:
                tw();
                break;
            case R.id.ko:
                ko();
                break;
            case R.id.eng:
                eng();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void tw(){
        viewPager2.setCurrentItem(0);
        tabAdapter.getItemId(0);
    }

    private void ko(){
        viewPager2.setCurrentItem(1);
        tabAdapter.getItemId(1);
    }
    private void eng(){
        viewPager2.setCurrentItem(2);
        tabAdapter.getItemId(2);
    }
}