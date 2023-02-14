package com.caarvin.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.caarvin.R;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SigninFragment extends MyApplicationFragment {

    Uri uri = null;
    View v;
    //ProgressDialog loading;
    Activity thisActivity;
    Resources res;
    String frgName="";

    FrameLayout frmRoot;

    private RelativeLayout rytSignUp;

    private TextView lblSigUp;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thisActivity = getActivity();
        res = thisActivity.getResources();
        v = inflater.inflate(R.layout.fragment_signin, null, false);
        init();
        return v;

    }

    private void init() {

        Log.d("SigninFragment","init Called");
        frgName="SigninFragment";
        frmRoot=(FrameLayout) thisActivity.findViewById(R.id.frmRoot);
        rytSignUp = (RelativeLayout) v.findViewById(R.id.rytSignUp);
        lblSigUp = (TextView) v.findViewById(R.id.lblSigUp);

        rytSignUp.setOnClickListener(new onClick());
        lblSigUp.setOnClickListener(new onClick());

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        Log.d("SigninFragment","onDetach Called");
        super.onDetach();


    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub

        super.onResume();
    }

    @Override
    public void onDestroy() {
        Log.d("SigninFragment","OnDestroy Called");
        super.onDestroy();

    }

    private void doBackPress() {


        getFragmentManager().popBackStackImmediate();
    }
    private class onClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {



                case R.id.rytSignUp:
                case R.id.lblSigUp:

                    Log.d("==>>","rytSignUp clicked");

                    //Fragment Call
                   FragmentManager fm3 = getParentFragmentManager();
                    FragmentTransaction transaction1 = fm3.beginTransaction();
                    transaction1.setCustomAnimations(R.anim.slide_in_left, 0);
                    SigUp frag1 = new SigUp();
                    transaction1.replace(R.id.frmRoot, frag1, "SigUp");
                    transaction1.addToBackStack("SigUp");
                    transaction1.commit();


                    //Fragment Checking
                       //open();

                    break;

                default:

                    break;

            }
        }
    }

    //Checking
    private void open() {


        LayoutInflater inflater = thisActivity.getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.inflate_categorylist, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(thisActivity);
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(true);
        final AlertDialog dialog = alert.create();
        dialog.show();

    }
}
