package com.example.apiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.apiproject.ApiPackage.ApiClient;
import com.example.apiproject.ApiPackage.LoginService;
import com.example.apiproject.ApiPackage.SignInRequest;
import com.example.apiproject.ApiPackage.SignInResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    SignInRequest signInRequest;
    SignInResponse signInResponse;
    Retrofit retrofit;
    LoginService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInit();
        login();
    }

    public void apiInit(){
        retrofit = ApiClient.getRetrofit();
        loginService = ApiClient.loginService();

    }

    public void login(){

        signInRequest = new SignInRequest("kallol.medhi@brigosha.com","1234",false);
        Call<SignInResponse> call = loginService.signinApiCall(signInRequest);
        call.enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }

                signInResponse = response.body();
                Toast.makeText(getApplicationContext(), signInResponse.user.name, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();

            }
        });

    }
}