package com.example.pc.viernes17;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Pizza_Fragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override


    public  void callbackTest(String message){

    }
    public void swapFragments(View v){
        FragmentManager fm = getFragmentManager();
    }
}
