package com.igor040897.vkgroup;


import android.app.Application;

import com.igor040897.vkgroup.di.component.ApplicationComponent;
import com.igor040897.vkgroup.di.component.DaggerApplicationComponent;
import com.igor040897.vkgroup.di.module.ApplicationModule;
import com.vk.sdk.VKSdk;

/**
 * Created by fanre on 8/14/2017.
 */

public class MyApplication extends Application {
    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        VKSdk.initialize(this);
    }

    private void initComponent(){
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
