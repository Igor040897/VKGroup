package com.igor040897.vkgroup.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fanre on 8/21/2017.
 */

public class Full<T> {
    @SerializedName("response")
    @Expose
    public T response;
}
