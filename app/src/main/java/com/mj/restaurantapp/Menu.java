package com.mj.restaurantapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.mj.restaurantapp.MainActivity.foodmenuList;


public class Menu extends Fragment {
    public RecyclerView recyclerView;
    public MenuAdapter menuAdapter;
    public FloatingActionButton floatingActionButton;
    Activity activity;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        floatingActionButton = view.findViewById(R.id.ft);

        activity = getActivity();
        recyclerView.setLayoutManager(new
                LinearLayoutManager(getActivity()));
        /*
         foodmenuList.add(new Foodmenu("Chowmein","240","Veg"));
        foodmenuList.add(new Foodmenu("food item","399","Veg"));
        foodmenuList.add(new Foodmenu("taste me tava","129","Veg"));
        foodmenuList.add(new Foodmenu("Chowmein","99","Veg"));
        foodmenuList.add(new Foodmenu("food item","49","Veg"));
        foodmenuList.add(new Foodmenu("taste me tava","49","Veg"));*/

        menuAdapter = new MenuAdapter(getActivity(), foodmenuList);
        recyclerView.setAdapter(menuAdapter);
        menuAdapter.notifyDataSetChanged();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Addnewfood addnewfood = new Addnewfood();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,new Addnewfood()).commit();
            }
        });
        return view;
    }
}

