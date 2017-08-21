package com.igor040897.vkgroup.di.component;

import com.igor040897.vkgroup.di.module.ApplicationModule;
import com.igor040897.vkgroup.di.module.ManagerModule;
import com.igor040897.vkgroup.di.module.RestModel;
import com.igor040897.vkgroup.ui.activity.BaseActivity;
import com.igor040897.vkgroup.ui.activity.MainActivity;
import com.igor040897.vkgroup.ui.fragment.NewFeedFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by fanre on 8/21/2017.
 */

@Singleton
@Component (modules = {ApplicationModule.class, ManagerModule.class, RestModel.class})
public interface ApplicationComponent {

    //activities
    void inject(MainActivity activity);
    void inject(BaseActivity activity);

    //fragments
    void inject(NewFeedFragment fragment);
}
