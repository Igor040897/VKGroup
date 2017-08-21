package com.igor040897.vkgroup.rest.model.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanre on 8/21/2017.
 */

public class BaseItemResonse<T> {
    public Integer count;
    public List<T> items = new ArrayList<>();

    public Integer getCount(){
        return count;
    }

    public List<T> getItems() {
        return items;
    }
}
