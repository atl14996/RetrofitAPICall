package com.example.week4day2homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.week4day2homework.Model.Package.UserResponse;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    ArrayList<UserPOJO> userResponseArrayList;
    public MyRecyclerViewAdapter(ArrayList<UserPOJO> userArrayList) {

        this.userResponseArrayList = userArrayList;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item, viewGroup, false));
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        UserPOJO currentUser = userResponseArrayList.get(i);

        viewHolder.tvUserName.setText(currentUser.getUserName());
        viewHolder.tvAddress.setText(currentUser.getAddress());
        viewHolder.tvUserPhone.setText(currentUser.getPhone());
        Glide.with(viewHolder.itemView.getContext()).load(currentUser.getSmallImage()).into(viewHolder.imgUserImage);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putParcelable("user", userResponseArrayList.get(i));
                Intent intenttoStarDetails = new Intent(v.getContext(), ResultActivity.class);
                intenttoStarDetails.putExtras(bundle);
                v.getContext().startActivity(intenttoStarDetails);
            }


        });
    }

    @Override
    public int getItemCount() {
        return userResponseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName;
        TextView tvAddress;
        TextView tvUserPhone;
        ImageView imgUserImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvAddress = itemView.findViewById(R.id.tvUserAddress);
            tvUserPhone = itemView.findViewById(R.id.tvUserPhone);
            imgUserImage = itemView.findViewById(R.id.imgUserImageRV);
        }
    }
}
