package com.caarvin.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.caarvin.R;

public class Privacyfragment extends MyApplicationFragment {

    Uri uri = null;
    View v;
    //ProgressDialog loading;
    Activity thisActivity;
    Resources res;

    private TextView lbl5;

    private FrameLayout frmRoot;


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

        Log.d("Privacy Fragment","init Called");

        lbl5 = (TextView) v.findViewById(R.id.lbl5);
        frmRoot=(FrameLayout) thisActivity.findViewById(R.id.frmRoot);
        lbl5.setMovementMethod(LinkMovementMethod.getInstance());


    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onAttach(Context context) {
        Log.d("Privacy Fragment","onAttach Called");
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        Log.d("Privacy Fragment","onDetach Called");
        super.onDetach();

    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub

        super.onResume();
    }

    @Override
    public void onDestroy() {
        Log.d("Privacy Fragment","onDestroy Called");
        super.onDestroy();
    }

    private void doBackPress() {


        getFragmentManager().popBackStackImmediate();
    }
}
