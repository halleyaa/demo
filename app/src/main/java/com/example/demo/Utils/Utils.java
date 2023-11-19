package com.example.demo.Utils;

import static com.example.demo.DetailActivity.INTENT_EXTRA;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import com.example.demo.DetailActivity;
import com.example.demo.MainActivity;
import com.example.demo.Model.Attraction;
import com.example.demo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class Utils {

    public static void detailIntent(Context context, Object object, ImageView imageView){
        Intent intent = new Intent(context, DetailActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((MainActivity) context,
                imageView, Objects.requireNonNull(ViewCompat.getTransitionName(imageView)));

        Attraction attraction = (Attraction) object;
        intent.putExtra(INTENT_EXTRA, attraction);

        context.startActivity(intent, options.toBundle());
    }

    public static void directionsIntent(Context context, String location) {
        if (location.length() <= 0) {
            Toast.makeText(context, "找無此地", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
        intent.setPackage("com.google.android.apps.maps");
        context.startActivity(intent);
    }

    public static StringBuilder readFile(String file, Context context){
        StringBuilder stringBuilder = new StringBuilder();
        try{
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(assetManager.open(file)));
            String line;
            while((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  stringBuilder;
    }

    public static JSONArray parseJson(String str, Context context){
        JSONArray data = new JSONArray();
        try{
            JSONObject jsonObject = new JSONObject(str);
             data = jsonObject.getJSONArray("data");
//            for(int i = 0; i < data.length(); i++){
//                JSONObject item = data.getJSONObject(i);
////                Log.i("ccc", item.getString("name"));
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
}
