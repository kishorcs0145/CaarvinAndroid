package com.caarvin.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caarvin.R;

public class Privacyfragment extends MyApplicationFragment {

    Uri uri = null;
    View v;
    //ProgressDialog loading;
    Activity thisActivity;
    Resources res;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thisActivity = getActivity();
        res = thisActivity.getResources();
        v = inflater.inflate(R.layout.fragment_privacy, null, false);
        init();
        return v;

    }

    private void init() {


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
        super.onDetach();

    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub


        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void doBackPress() {


        getFragmentManager().popBackStackImmediate();
    }
}
