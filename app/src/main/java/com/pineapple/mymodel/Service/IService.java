package com.pineapple.mymodel.Service;

import com.pineapple.mymodel.Json.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.pineapple.mymodel.Service.IService.jsonName;

public interface IService {
    String jsonName = "\"/v1/current.json\"";

    @GET(jsonName)
    Call<Example> listRepos(@Query("key") String key, @Query("q") String q);
}
