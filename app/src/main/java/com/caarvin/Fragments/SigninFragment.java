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
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.caarvin.Adapters.MyExpandableListAdapter;
import com.caarvin.Api.APIResponse;
import com.caarvin.Api.ApiClient;
import com.caarvin.Api.ApiInterface;
import com.caarvin.R;
import com.caarvin.Utils.Config;
import com.caarvin.Utils.Network;
import com.caarvin.Utils.Progress;
import com.caarvin.Utils.Utilities;
import com.caarvin.Utils.Validation;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SigninFragment extends MyApplicationFragment {

    Uri uri = null;
    View v;
    //ProgressDialog loading;
    Activity thisActivity;
    Resources res;
    String frgName="";

    FrameLayout frmRoot;

    private RelativeLayout rytSignUp,rytLogin,rytUser;

    private TextView lblSigUp,lblLogin,lblUserName,btnLogin;

    //for Expandable List

    //private List<String> groupList;
    //private List<String> childList;

    //Map<String, List<String>> mobileCollection;

    //ExpandableListView expandableListView;

    //ExpandableListAdapter expandableListAdapter;

    //for retrofit
    Retrofit retrofit;

    ApiInterface api;

    EditText username;

    EditText password;

    String userName="";

    String pass="";
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


        retrofit = new Retrofit.Builder()
                .baseUrl(Config.getInstance().getBASE_URL())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(ApiInterface.class);

        Log.d("SigninFragment","init Called");
        frgName="SigninFragment";
        frmRoot=(FrameLayout) thisActivity.findViewById(R.id.frmRoot);
        rytUser = (RelativeLayout) thisActivity.findViewById(R.id.rytUser);
        lblUserName = (TextView) thisActivity.findViewById(R.id.lblUserName);
        btnLogin = (TextView) thisActivity.findViewById(R.id.btnLogin);
        rytSignUp = (RelativeLayout) v.findViewById(R.id.rytSignUp);
        lblSigUp = (TextView) v.findViewById(R.id.lblSigUp);


        rytLogin = (RelativeLayout) v.findViewById(R.id.rytLogin);
        lblLogin = (TextView) v.findViewById(R.id.lblLogin);

        username = (EditText) v.findViewById(R.id.username);

        password = (EditText) v.findViewById(R.id.password);

        //expandableListView = (ExpandableListView) v.findViewById(R.id.elvMobiles);



        rytSignUp.setOnClickListener(new onClick());
        lblSigUp.setOnClickListener(new onClick());
        rytLogin.setOnClickListener(new onClick());
        lblLogin.setOnClickListener(new onClick());

        btnLogin.setVisibility(View.VISIBLE);
        rytUser.setVisibility(View.GONE);

        //groupList = new ArrayList<>();
        //createGroupList();
        //createCollection();

       /* expandableListAdapter = new MyExpandableListAdapter(thisActivity, groupList, mobileCollection);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;
            @Override
            public void onGroupExpand(int i) {
if(lastExpandedPosition !=-1 && i !=lastExpandedPosition){
    expandableListView.collapseGroup(lastExpandedPosition);
}
lastExpandedPosition=i;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String selected  = expandableListAdapter.getChild(i,i1).toString();
                Toast.makeText(thisActivity,"Selected "+selected,Toast.LENGTH_SHORT).show();
                return true;
            }
        });*/
    }

 /*   private void createCollection() {

        String[] samsungModels = {"Samsung Galaxy M21","Samsung Galaxy F41","Samsung Galaxy M51","Samsung Galaxy A50s"};

        String[] googleModels = {"Google Galaxy M21","Google Galaxy F41","Google Galaxy M51","Google Galaxy A50s"};

        mobileCollection = new HashMap<String, List<String>>();
        for(String group:groupList){
            if(group.equals("Samsung")){
                loadChild(samsungModels);
            }
            else{
                loadChild(googleModels);
            }
            mobileCollection.put(group,childList);
        }
    }

    private void loadChild(String[] mobileModels) {

        childList = new ArrayList<>();

        for(String model: mobileModels){
            childList.add(model);
        }

    }

    private void createGroupList() {

        groupList = new ArrayList<>();
        groupList.add("Samsung");
        groupList.add("Google");


    }*/

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

                case R.id.rytLogin:
                case R.id.lblLogin:

                    make_rotrofit_call_for_login();

                    break;


                case R.id.rytSignUp:
                case R.id.lblSigUp:

                    Log.d("==>>","rytSignUp clicked");

                    //Fragment Call
                  /* FragmentManager fm3 = getParentFragmentManager();
                    FragmentTransaction transaction1 = fm3.beginTransaction();
                    transaction1.setCustomAnimations(R.anim.slide_in_left, 0);
                    SigUp frag1 = new SigUp();
                    transaction1.replace(R.id.frmRoot, frag1, "SigUp");
                    transaction1.addToBackStack("SigUp");
                    transaction1.commit();*/


                    //Fragment Checking
                       //open();




                    break;

                default:

                    break;

            }
        }
    }

    private void make_rotrofit_call_for_login() {

        if (Network.getInstance().isNetwork(thisActivity)) {
                userName = username.getText().toString().trim();
                pass = password.getText().toString().trim();

            if (Validation.getInstance().isEmailEmpty(thisActivity, userName)) {
                Utilities.showToast(thisActivity, "Please Enter Username");
            }


            else if (Validation.getInstance().isPasswordEmpty(thisActivity, pass)) {
                Utilities.showToast(thisActivity, "Please Enter Password");
            }

            else{
                Progress.getInstance().show(thisActivity, getString(R.string.loading));
                ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<APIResponse> call = apiInterface.getUserDetails(userName,pass);
                call.enqueue(new Callback<APIResponse>() {
                    @Override
                    public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                        Progress.getInstance().hide();
                        Utilities.showToast(thisActivity,""+response.body().getMessage());
                        username.setText("");
                        password.setText("");
                        Log.e("==>>",""+response.body().getMessage());
                        Log.e("==>>",""+response.body().getStatus());
                        Log.e("==>>",""+response.body().getUserId());
/*try {
    String result = response.body().string();
    Log.e("==>>",""+result);
   *//* Log.e("==>>",""+result);
    Log.e("==>>",""+result);
    Log.e("==>>",""+result);*//*
    JSONObject jsonObject = new JSONObject(result);
    Log.e("==>>",""+jsonObject.getString("status"));
    Log.e("==>>",""+jsonObject.getString("userId"));
    Log.e("==>>",""+jsonObject.getString("messsage"));

}catch(Exception e){
    e.printStackTrace();
}*/

                        thisActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                btnLogin.setVisibility(View.GONE);
                                rytUser.setVisibility(View.VISIBLE);
                                lblUserName.setText(userName);

                                callHomeFragment();

                            }
                        });

                    }

                    @Override
                    public void onFailure(Call<APIResponse> call, Throwable t) {
                        Utilities.showToast(thisActivity,""+t.getMessage());
                        Progress.getInstance().hide();
                        username.setText("");
                        password.setText("");
                        btnLogin.setVisibility(View.VISIBLE);
                        rytUser.setVisibility(View.GONE);

                        Log.d("Response errorBody", String.valueOf(t.getMessage()));
                    }
                });
            }
        }
        else{
            Toast.makeText(thisActivity,getString(R.string.network_error),Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
        }
    }

    private void callHomeFragment() {

        FragmentManager fm3 = getParentFragmentManager();
        FragmentTransaction transaction1 = fm3.beginTransaction();
        transaction1.setCustomAnimations(R.anim.slide_in_right,0 );
        Homefragment frag1 = new Homefragment();
        transaction1.replace(R.id.frmRoot, frag1, "Homefragment");
        //transaction1.addToBackStack("SigUp");
        transaction1.commit();
    }

    //Checking
    /*private void open() {


        LayoutInflater inflater = thisActivity.getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.inflate_categorylist, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(thisActivity);
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(true);
        final AlertDialog dialog = alert.create();
        dialog.show();

    }*/
}
