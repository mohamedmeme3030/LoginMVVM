package com.example.mohamedmeme.loginmvvm.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static Retrofit retrofitInstance;

    static Retrofit getInstance(){
        if(retrofitInstance==null){
            //build retrofit
             retrofitInstance = new Retrofit.Builder()
                    .baseUrl("http://hambozo.com/survey/api/moderator/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofitInstance;
    }

   public static AppServices getAPIs(){
        return getInstance().create(AppServices.class);
    }

}
