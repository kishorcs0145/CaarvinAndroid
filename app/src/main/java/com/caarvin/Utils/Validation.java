package com.caarvin.Utils;

import android.app.Activity;
import android.util.Patterns;

public class Validation {

    private static  Validation ourInstance = new Validation();

    public static  Validation getInstance(){
        return ourInstance;
    }


    public boolean isEmailEmpty(Activity activity, String email){

        if(email.toString().trim().equalsIgnoreCase("")){
            return  true;
        }else{
            return false;
        }


    }
    public boolean isEmail(Activity activity,String email){

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return  true;
        }else{
            return false;
        }


    }
    public boolean isPasswordEmpty(Activity activity,String password){

        if(password.toString().trim().equalsIgnoreCase("")){
            return  true;
        }else{
            return false;
        }


    }

    public boolean isFirstNameEmpty(Activity activity,String firstname){

        if(firstname.toString().trim().equalsIgnoreCase("")){
            return  true;
        }else{
            return false;
        }


    }


    public boolean isLastNameEmpty(Activity activity,String lastname){

        if(lastname.toString().trim().equalsIgnoreCase("")){
            return  true;
        }else{
            return false;
        }


    }


    public boolean isGenderEmpty(Activity activity,String gender){

        if(gender.toString().trim().equalsIgnoreCase("")){
            return  true;
        }else{
            return false;
        }


    }

    public boolean isBirthdayEmpty(Activity activity,String birthday){

        if(birthday.toString().trim().equalsIgnoreCase("")){
            return  true;
        }else{
            return false;
        }


    }

    public boolean isMobileNoEmpty(Activity activity,String mobile){

        if(mobile.toString().trim().equalsIgnoreCase("")){
            return  true;
        }else{
            return false;
        }


    }
}
