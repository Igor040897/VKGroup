package com.igor040897.vkgroup.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.igor040897.vkgroup.CurrentUser;
import com.igor040897.vkgroup.mvp.view.MainView;

/**
 * Created by fanre on 8/14/2017.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    public void checkAuth() {
        if (!CurrentUser.isAuthorized()) {
            getViewState().startSignIn();
        } else {
            getViewState().signedId();
        }
    }
}
