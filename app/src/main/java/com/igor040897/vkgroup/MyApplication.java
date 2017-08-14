package com.igor040897.vkgroup;


import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by fanre on 8/14/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
