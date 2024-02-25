package com.example.android.whowroteit.api;

import com.example.android.whowroteit.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceApi {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ServiceApi serviceApi = new Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ServiceApi.class);


    @GET("books/v1/volumes")
    Call<Book> getDataBook(@Query("q") String querry_params,
                           @Query("maxResults") int maxResults,
                           @Query("printType") String printType);
}
