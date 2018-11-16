package com.example.mohamedmeme.loginmvvm.API;

import com.example.mohamedmeme.loginmvvm.API.Responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AppServices {


    @POST("login")
    @FormUrlEncoded
    Call<LoginResponse> Login(@Field("user_name") String username,
                              @Field("password") String password);
}
