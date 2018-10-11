package com.example.zjf.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GridLayoutActivity extends Activity {
    private RecyclerView mRecyclerView;
    private List<String> mDates;
    private GridLayoutAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_recyclerview);
        initDate();
        mRecyclerView = (RecyclerView)findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));
        mRecyclerView.setAdapter(mAdapter = new GridLayoutAdapter());
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
    }
    private void initDate() {
        mDates = new ArrayList<String>();
        for (int i = 'A';i < 'z';i++){
            mDates.add("" + (char)i);
        }
    }

    class GridLayoutAdapter extends RecyclerView.Adapter<GridLayoutAdapter.GridViewHolder>{
        @NonNull
        @Override
        public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            GridViewHolder holder = new GridViewHolder(LayoutInflater.from(GridLayoutActivity.this).inflate(R.layout.item_home,parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
            holder.textView.setText(mDates.get(position));
        }

        @Override
        public int getItemCount() {
            return mDates.size();
        }

        class GridViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public GridViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.id_num);
            }
        }
    }
}
