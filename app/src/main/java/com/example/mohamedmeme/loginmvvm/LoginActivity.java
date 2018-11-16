package com.example.mohamedmeme.loginmvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;

import com.example.mohamedmeme.loginmvvm.API.Responses.User;
import com.example.mohamedmeme.loginmvvm.Base.MyBaseActivity;

public class LoginActivity extends MyBaseActivity {

EditText username,password;
Button login;
LoginViewModel loginViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        loginViewModel=ViewModelProviders.of(this).get(LoginViewModel.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameString=username.getText().toString();
                String passwordString=password.getText().toString();
                loginViewModel.Login(usernameString,passwordString);
            }
        });


        loginViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if(user==null){
                    ShowMessage("Error","Login Failed");
                }else{
                    ShowMessage("Success","Login Success");
                }
            }
        });

    }

    private void initView() {
        username=findViewById(R.id.user_name);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
    }

}
