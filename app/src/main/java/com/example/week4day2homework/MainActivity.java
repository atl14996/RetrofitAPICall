package com.example.week4day2homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.week4day2homework.Model.Package.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
MyRecyclerViewAdapter myRecyclerViewAdapter;
ArrayList<UserPOJO> userResponseArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(generateListOfUsers());
        recyclerView.setAdapter(myRecyclerViewAdapter);


        RetrofitHelper retrofitHelper = new RetrofitHelper();
        retrofitHelper.getRandomUsers("10").enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
int i;
                for(i=0; i <= 10; i++) {


                    String phone = response.body().getResults().get(i).getPhone();
                    String address = response.body().getResults().get(i).getLocation().getStreet() + " " + response.body().getResults().get(i).getLocation().getCity() + "  "
                            + response.body().getResults().get(i).getLocation().getState() + " " + response.body().getResults().get(i).getLocation().getPostcode();
                    String userName = response.body().getResults().get(i).getName().getFirst() + " " + response.body().getResults().get(i).getName().getLast();
                    String smallimage = response.body().getResults().get(i).getPicture().getThumbnail();
                    String largeImage = response.body().getResults().get(i).getPicture().getLarge();
                    userResponseArrayList.add(new UserPOJO(userName, address, phone, smallimage, largeImage));


                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }

    public ArrayList<UserPOJO> generateListOfUsers() {

        return userResponseArrayList;


    }
}
