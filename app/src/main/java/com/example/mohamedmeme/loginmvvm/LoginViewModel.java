package com.example.mohamedmeme.loginmvvm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mohamedmeme.loginmvvm.API.ApiManager;
import com.example.mohamedmeme.loginmvvm.API.Responses.LoginResponse;
import com.example.mohamedmeme.loginmvvm.API.Responses.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {


    MutableLiveData<User> user;

    public LoginViewModel() {
        user = new MutableLiveData<>();
    }

    public MutableLiveData<User> getUser() {
        return user;
    }

    public void Login(String username, String password) {

        ApiManager.getAPIs().Login(username, password)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                        if("success".equals(response.body().getStatus())){
                            user.postValue(response.body().getData());
                        }else{
                            user.postValue(null);
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });

    }
}
