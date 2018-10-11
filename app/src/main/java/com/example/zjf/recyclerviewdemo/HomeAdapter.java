/*
package com.example.zjf.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeAdapter extends RecyclerView.Adapter<HomeActivity.HomeAdapter.MyViewHolder> {
    @NonNull
    @Override
    public HomeActivity.HomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HomeActivity.HomeAdapter.MyViewHolder holder = new HomeActivity.HomeAdapter.MyViewHolder(LayoutInflater.from(HomeActivity.this).inflate(R.layout.item_home,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeActivity.HomeAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(mDates.get(position));
    }

    @Override
    public int getItemCount() {
        return mDates.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView)findViewById(R.id.id_num);
        }
    }
}
*/
