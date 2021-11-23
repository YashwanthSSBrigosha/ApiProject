package com.example.apiproject.ApiPackage;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginService {

@Headers({"version:7","orgurl:brigosha.classroom.digital"})
@POST("/api/login/virtual-signin")
    Call<SignInResponse> signinApiCall(@Body SignInRequest signInRequest);
}
