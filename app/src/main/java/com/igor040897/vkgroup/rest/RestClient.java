package com.igor040897.vkgroup.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fanre on 8/21/2017.
 */

public class RestClient {
    public static final String VK_BASE_URI = "https://api.vk.com/method/";

    private Retrofit retrofit;

    public RestClient(){
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(VK_BASE_URI)
                .build();
    }

    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
