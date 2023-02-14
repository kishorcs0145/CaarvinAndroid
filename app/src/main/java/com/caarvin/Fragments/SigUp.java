package com.caarvin.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.caarvin.R;

public class SigUp extends MyApplicationFragment {

    Uri uri = null;
    View v;
    //ProgressDialog loading;
    Activity thisActivity;
    Resources res;
    String frgName="";

    private FrameLayout frmRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thisActivity = getActivity();
        res = thisActivity.getResources();
        v = inflater.inflate(R.layout.fragment_signup, null, false);
        init();
        return v;

    }

    private void init() {

        Log.d("SignupFragment","init Called");
        frgName="SignupFragment";
        frmRoot=(FrameLayout) thisActivity.findViewById(R.id.frmRoot);

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
        Log.d("SignupFragment","onDetach Called");
        super.onDetach();


    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub

        super.onResume();
    }

    @Override
    public void onDestroy() {
        Log.d("SignupFragment","OnDestroy Called");
        super.onDestroy();

    }

    private void doBackPress() {


        getFragmentManager().popBackStackImmediate();
    }

}