package com.caarvin;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.caarvin.Fragments.Homefragment;
import com.caarvin.Fragments.Privacyfragment;
import com.caarvin.Fragments.SigninFragment;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private FrameLayout frmRoot;

    private TextView btnLogin;

    private TextView lblPrivacy;

    private TextView lblUserName;

    Resources res;
    Activity thisActivity;

    int a=0;


    private EditText editText;

    private TextView textView1, textView2;

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {

            Log.d("==>>","onActivityResult");
            if(result!= null && result.getResultCode() == RESULT_OK){
                Place place = Autocomplete.getPlaceFromIntent(result.getData());
                editText.setText(place.getAddress());
                textView1.setText(String.format("Locality Name : %s",place.getName()));
                textView2.setText(String.valueOf(place.getLatLng()));
            }else if(result.getResultCode() == AutocompleteActivity.RESULT_ERROR){
                Status status= Autocomplete.getStatusFromIntent(result.getData());
                Log.d("==>>","onActivityResult RESULT_ERROR"+status);
                Toast.makeText(getApplicationContext(),status.getStatusMessage(),Toast.LENGTH_SHORT).show();
            }

        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        thisActivity = MainActivity.this;
        res = thisActivity.getResources();


        setContentView(R.layout.activity_main);

        String apiKey = getString(R.string.api_key);

        frmRoot = (FrameLayout) findViewById(R.id.frmRoot);

        btnLogin = (TextView) findViewById(R.id.btnLogin);

        lblPrivacy = (TextView) findViewById(R.id.lblPrivacy);

        editText = (EditText) findViewById(R.id.edit_text);

        textView1 = (TextView) findViewById(R.id.text_view1);

        textView2 = (TextView) findViewById(R.id.text_view2);

        lblUserName = (TextView)  findViewById(R.id.lblUserName);
        lblUserName.setMovementMethod(new ScrollingMovementMethod());

        if (savedInstanceState == null) {
            FragmentManager manager1 = getSupportFragmentManager();
            FragmentTransaction transaction1 = manager1.beginTransaction();
            transaction1.setCustomAnimations(R.anim.slide_in_left, 0);
            Homefragment frag1 = new Homefragment();
            transaction1.add(R.id.frmRoot, frag1, "Homefragment");
            //transaction1.addToBackStack("Privacyfragment");
            transaction1.commit();
        }

        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Write whatever to want to do after delay specified (1 sec)
                Log.d("fragmentInstance","init"+String.valueOf(getSupportFragmentManager().findFragmentById(R.id.frmRoot)));
            }
        }, 100);

        btnLogin.setOnClickListener(new onClick());
        lblPrivacy.setOnClickListener(new onClick());

        Places.initialize(thisActivity.getApplicationContext(),apiKey);



        editText.setFocusable(false);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Place.Field> fieldList = Arrays.asList(Place.Field.ADDRESS,Place.Field.LAT_LNG,Place.Field.NAME);

                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY,fieldList).build(MainActivity.this);

                //startActivityForResult(intent,100);

startForResult.launch(intent);


            }
        });
    }






    @Override
    public void onBackPressed() {
        //thisActivity.finish();

      /*  AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
        builder.setMessage("do you want to exit??")
                .setCancelable(true)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        thisActivity.finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();*/

        super.onBackPressed();
    }

    private class onClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {



                case R.id.btnLogin:




                    FragmentManager manager2 = getSupportFragmentManager();
                    FragmentTransaction transaction2 = manager2.beginTransaction();

                    Homefragment frag2 = new Homefragment();
                    transaction2.remove(frag2);

                    FragmentManager manager1 = getSupportFragmentManager();
                    FragmentTransaction transaction1 = manager1.beginTransaction();
                    transaction1.setCustomAnimations(R.anim.slide_in_left, 0);
                    SigninFragment frag1 = new SigninFragment();

                    transaction1.replace(R.id.frmRoot, frag1, "SigninFragment");
                        transaction1.commit();



                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Write whatever to want to do after delay specified (1 sec)
                            Log.d("fragmentInstance","btnLogin"+String.valueOf(getSupportFragmentManager().findFragmentById(R.id.frmRoot)));
                        }
                    }, 100);


                    break;

                case R.id.lblPrivacy:

                    FragmentManager managerhome2 = getSupportFragmentManager();
                    FragmentTransaction transactionhome2 = managerhome2.beginTransaction();
                    Homefragment fraghome2 = new Homefragment();
                    transactionhome2.remove(fraghome2);
                    FragmentManager manager3 = getSupportFragmentManager();
                    FragmentTransaction transaction3 = manager3.beginTransaction();
                    transaction3.setCustomAnimations(R.anim.slide_in_left, 0);
                    Privacyfragment frag3 = new Privacyfragment();
                    transaction3.replace(R.id.frmRoot, frag3, "Privacyfragment");
                    //transaction1.addToBackStack("Privacyfragment");
                    transaction3.commit();


                    final Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Write whatever to want to do after delay specified (1 sec)
                            Log.d("fragmentInstance","btnPrivacy"+String.valueOf(getSupportFragmentManager().findFragmentById(R.id.frmRoot)));
                        }
                    }, 100);




                    break;
                default:

                    break;

            }
        }
    }




  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK){
            Place place = Autocomplete.getPlaceFromIntent(data);
            editText.setText(place.getAddress());
            textView1.setText(String.format("Locality Name : %s",place.getName()));
            textView2.setText(String.valueOf(place.getLatLng()));
        }else if(resultCode == AutocompleteActivity.RESULT_ERROR){
            Status status= Autocomplete.getStatusFromIntent(data);
            Toast.makeText(getApplicationContext(),status.getStatusMessage(),Toast.LENGTH_SHORT).show();
        }
    }*/
}