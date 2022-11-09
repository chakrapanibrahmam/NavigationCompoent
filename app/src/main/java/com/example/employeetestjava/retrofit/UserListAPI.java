package com.example.employeetestjava.retrofit;

import com.example.employeetestjava.data.UserData;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;


public interface UserListAPI {
    @GET("/quotes")
    Call<UserData> getUserList();
}
