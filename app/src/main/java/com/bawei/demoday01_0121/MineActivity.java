package com.bawei.demoday01_0121;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        getSupportActionBar().hide();
        ImageView iv = findViewById(R.id.iv);

        Intent intent = getIntent();
        if (intent != null) {
            String headPic = intent.getStringExtra("headPic");
            Glide.with(this).load(headPic).into(iv);
        }


        TextView tvGo= findViewById(R.id.tv_go);
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MineActivity.this,LoginActivity.class),1);
            }
        });

    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);


    }
}
