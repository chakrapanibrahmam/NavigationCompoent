package com.example.employeetestjava.retrofit;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private RestClient(){

    }

    public static synchronized Retrofit getInstance(){
        return  new Retrofit.Builder()
                .baseUrl("https://quotable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public static <S> S createService(Class<S> serviceClass){
        return getInstance().create(serviceClass);
    }
}
