package com.friday.week5;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PizzaFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callbackTest(String message){

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void swapFragments(View v){

        FragmentManager fm = getFragmentManager();

        //Fragment2 f2 = Fragment2.newInstance("HOLA", "AMIGUITOS", "SALU2");
        PizzaFragment pizza = new PizzaFragment();

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.container, pizza, "pizza");
        transaction.commit();
    }

    public void removeFragments(View v){

        FragmentManager fm = getFragmentManager();
        PizzaFragment f = (PizzaFragment)fm.findFragmentByTag("pizza");

        if(f == null){

            Toast.makeText(this, "FRAGMENT IS NULL", Toast.LENGTH_SHORT).show();
            return;
        }

        f.logSomething("LA MUERTE HA LLEGADO.");

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.remove(f);
        transaction.commit();
    }
}
