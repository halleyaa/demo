package com.example.demo.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.Adapter.attractionAdapter;
import com.example.demo.Data.attractionData;
import com.example.demo.R;

public class attractionFragment extends Fragment {

    public static String lang;

    public attractionFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.travel_recycler_item, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemViewCacheSize(10);

        if(getContext() != null){
//            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            recyclerView.setAdapter(new attractionAdapter(attractionData.fetchAtrractionData(getContext(), "tw_json.json"), getContext()));
//            recyclerView.setAdapter(new attractionAdapter(attractionData.fetchAtrractionData(getContext(), lang), getContext()));
        }

    }

    public static void changeLanguage(@NonNull View view){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.removeAllViews();

    }
}
