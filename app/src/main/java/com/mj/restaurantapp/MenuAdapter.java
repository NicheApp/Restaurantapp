package com.mj.restaurantapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ImageViewHolder> {
    public Context mContext;
    public List<Foodmenu> mUploads;
    public List<Foodmenu> mUploadscopy;

    public MenuAdapter(Context context, List<Foodmenu> uploads) {
        mContext = context;
        mUploads = uploads;
        mUploadscopy = new ArrayList<>(mUploads);
    }
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_menucard, parent, false);
        return new ImageViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {
        Foodmenu uploadCurrent = mUploads.get(position);
        holder.foodname.setText(uploadCurrent.getFoodname());
        holder.price.setText("₹ "+uploadCurrent.getPrice());
        holder.foodtype.setText(uploadCurrent.getFoodtype());
    }
    @Override
    public int getItemCount() {
        return mUploads.size();
    }
    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView foodname;
        public TextView price;
        public TextView foodtype;
        public TextView avl;
        public ImageViewHolder(View itemView) {
            super(itemView);
            foodname = itemView.findViewById(R.id.dishname);
            price= itemView.findViewById(R.id.price);
            foodtype= itemView.findViewById(R.id.foodtype);
            avl = itemView.findViewById(R.id.avl);
        }
    }
};