package com.mj.restaurantapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    public  static FragmentManager fm;
    public  static List<Foodmenu> foodmenuList=new ArrayList<>();
    TextView title;
    Switch sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        title = findViewById(R.id.title);
        sw = findViewById(R.id.switch2);
        frameLayout = findViewById(R.id.flFragment);

       fm = getSupportFragmentManager();
       if(savedInstanceState==null){
           restfoodmenu_retrieve rtv = new restfoodmenu_retrieve(getApplicationContext());
           rtv.execute();
           setFragement(new Menu());
       }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu:
                        setFragement(new Menu());
                        return true;
                    case R.id.sales:
                        setFragement(new Sales());
                        return true;
                    default:
                        return false;
                }

            }
        });
    }
    private void setFragement(Fragment fragement) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flFragment,fragement);
        fragmentTransaction.commit();
    }
}