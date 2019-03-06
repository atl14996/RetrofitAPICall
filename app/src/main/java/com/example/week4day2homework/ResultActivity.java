package com.example.week4day2homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ResultActivity extends AppCompatActivity {
Intent passedIntent;
UserPOJO userPOJO;
TextView tvUserName;
TextView tvUserAddress;
TextView tvUserPhone;
ImageView imgLargeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        if(getIntent() != null) {
            passedIntent = getIntent();
            Bundle bundle = passedIntent.getExtras();
            userPOJO = bundle.getParcelable("user");
            imgLargeImage = findViewById(R.id.imgUserImage);
            tvUserName = findViewById(R.id.tvUserNameDisplay);
            tvUserAddress = findViewById(R.id.tvUserAddressDisplay);
            tvUserPhone = findViewById(R.id.tvUserPhoneDisplay);
            tvUserName.setText(userPOJO.getUserName());
            tvUserAddress.setText(userPOJO.getAddress());
            tvUserPhone.setText(userPOJO.getPhone());

            Glide.with(this).load(userPOJO.getLargeImage()).into(imgLargeImage);
        }
    }
}
