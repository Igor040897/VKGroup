package com.igor040897.vkgroup.rest.api;

import com.igor040897.vkgroup.rest.model.response.BaseItemResonse;
import com.igor040897.vkgroup.rest.model.response.Full;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fanre on 8/21/2017.
 */

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Call<Full<BaseItemResonse>> get(@Query("owner_id") String ownerId,
                                    @Query("access_token") String accessToken,
                                    @Query("extended") Integer extended,
                                    @Query("v") String version);
}
