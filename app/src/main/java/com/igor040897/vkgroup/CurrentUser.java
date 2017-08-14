package com.igor040897.vkgroup;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;

/**
 * Created by fanre on 8/14/2017.
 */

public class CurrentUser {
    public static String getAccessToken(){
        if(VKAccessToken.currentToken() == null){
            return null;
        }
        return VKAccessToken.currentToken().accessToken;
    }

    public static String getId(){
        if(VKAccessToken.currentToken() == null){
            return null;
        }
        return VKAccessToken.currentToken().userId;
    }

    public static boolean isAuthorized(){
        return VKSdk.isLoggedIn()
                && VKAccessToken.currentToken() != null
                && !VKAccessToken.currentToken().isExpired();
    }
}