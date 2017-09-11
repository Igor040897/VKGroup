package com.igor040897.vkgroup.di.module;

import com.igor040897.vkgroup.rest.RestClient;
import com.igor040897.vkgroup.rest.api.WallApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fanre on 8/21/2017.
 */

@Module
public class RestModel {
    private RestClient restClient;

    public RestModel(){
        restClient = new RestClient();
    }

    @Singleton
    @Provides
    public RestClient provideRestClient(){
        return restClient;
    }

    @Singleton
    @Provides
    public WallApi provideWallApi(){
        return restClient.createService(WallApi.class);
    }
}
