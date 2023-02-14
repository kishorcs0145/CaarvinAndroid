package com.caarvin.Utils;

import android.util.Log;

public class Config {

    private static final Config ourInstance = new Config();

    public static Config getInstance() {
        return ourInstance;
    }

    private Config() {
    }


    //demo url
    /* String SERVER_PATH="https://pritis-ecademy.com/handwriting_v1/api";
    String BASE_URL="/auth/login/";
    String VERSION="/v1/";

    //live url

   String SERVER_PATH="https://pritis-ecademy.com/api";
    String BASE_URL="/auth/login/";
    String VERSION="/v1/";*/

    //caarvin

    String SERVER_PATH="http://3.111.2.163/api/Jobbvin/";
 /*
    public String getSERVER_PATH() {
        return SERVER_PATH;
    }

  public String getBASE_URL() {
        Log.d("BaseUrl",""+SERVER_PATH+VERSION);
        return SERVER_PATH+VERSION;
    }*/


    public String getBASE_URL() {
        Log.d("BaseUrl",""+SERVER_PATH);
        return SERVER_PATH;
    }

    /*public String getLoginUrl(){ return BASE_URL+VERSION+"auth/login";}

    public String getLogoutUrl(){ return BASE_URL+VERSION+"auth/logout";}

    public String getForgotPwdUrl(){ return BASE_URL+VERSION+"auth/forgot_password";}*/
}
