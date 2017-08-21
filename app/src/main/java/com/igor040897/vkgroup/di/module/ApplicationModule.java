package com.igor040897.vkgroup.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fanre on 8/21/2017.
 */

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule(Application application){
        this.application = application;
    }

    @Singleton
    @Provides
    public Context provideContext(){
        return application;
    }
}
