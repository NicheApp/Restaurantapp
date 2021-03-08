package com.mj.restaurantapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class Addnewfood extends Fragment {
    public EditText itemname,itemprice,itemtype;
    Button add;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addnewfood, container, false);
        itemname = view.findViewById(R.id.ed1);
        itemprice = view.findViewById(R.id.ed2);
        itemtype = view.findViewById(R.id.ed3);
        add = view.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restfoodmenubackground rt =new restfoodmenubackground(getContext());
                rt.execute(itemname.getText().toString(),itemprice.getText().toString(),itemtype.getText().toString());
            }
        });
        return view;
    }
}

