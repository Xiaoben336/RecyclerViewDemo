package com.example.zjf.recyclerviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button btnHomeActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHomeActivity = (Button)findViewById(R.id.btnHomeActivity);
        btnHomeActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btnHomeActivity:
                intent.setClass(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.btnGridLayoutActivityy:
                intent.setClass(MainActivity.this,GridLayoutActivity.class);
                startActivity(intent);
                break;
        }
    }
}
