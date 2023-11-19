package com.example.demo.Data;

import android.content.Context;
import android.util.Log;

import com.example.demo.Model.Attraction;
import com.example.demo.Utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class attractionData {

    public static ArrayList<Attraction> fetchAtrractionData(Context context, String file){

        ArrayList<Attraction> attractions = new ArrayList<>();
        List<List<String>> images = new ArrayList<List<String>>();
        List<String> name = new ArrayList<>();
        List<String> introduction = new ArrayList<>();
        List<String> address = new ArrayList<>();
        List<String> modified = new ArrayList<>();
        List<String> url = new ArrayList<>();

        StringBuilder builder = Utils.readFile(file, context);
        JSONArray data = Utils.parseJson(builder.toString(), context);
        try{
            for(int i = 0; i < data.length(); i++){
                JSONObject item = data.getJSONObject(i);
                List<String> imgs = new ArrayList<>();
                JSONArray img = item.getJSONArray("images");
                for(int j = 0; j< img.length(); j++){
                    JSONObject imgsObj = img.getJSONObject(j);
                    imgs.add(imgsObj.getString("src"));
                }
                images.add(imgs);
                name.add(item.getString("name"));
                introduction.add(item.getString("introduction"));
                address.add(item.getString("address"));
                modified.add(item.getString("modified"));
                url.add(item.getString("url"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < name.size(); i++){
            Attraction attraction = new Attraction(images.get(i), name.get(i), introduction.get(i), address.get(i), modified.get(i), url.get(i));
            attractions.add(attraction);
        }
        return attractions;
    }

}
