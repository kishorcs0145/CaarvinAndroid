package com.caarvin.Api;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("http://3.111.2.163/api/Jobbvin/{userName}/{pass}")
    Call<APIResponse> getUserDetails(@Path("userName") String userName, @Path("pass") String pass);
}
