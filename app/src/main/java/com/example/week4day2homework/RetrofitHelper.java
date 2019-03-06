package com.example.week4day2homework;

import com.example.week4day2homework.Model.Package.UserResponse;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.week4day2homework.URLConstants.BASE_URL;
import static com.example.week4day2homework.URLConstants.PATH;
import static com.example.week4day2homework.URLConstants.QUERY_RESULTS;

public class RetrofitHelper {

    private Retrofit getRetrofitClient() {


        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public GetRandomUsers getUserResponse() {
        return getRetrofitClient().create(GetRandomUsers.class);

    }

    public Call<UserResponse> getRandomUsers(String numOfResponses) {

        return getUserResponse().getRandomUsers("10");

    }


    public interface GetRandomUsers {
        @GET(PATH)
        Call<UserResponse> getRandomUsers(@Query(QUERY_RESULTS) String numOfResponses);
    }
}