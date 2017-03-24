package com.example.pc.proyecto1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import objetos.firebasereferences;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference(firebasereferences.TUTORIAL_REFERENCE);
        Log.i("key",myref.getKey());

        Intent intent = new Intent(this, Main2Activity.class);

        intent.putExtra("helo", "soyhuapo");

//        startActivityForResult(intent, MAIN2_REQUEST_CODE);




    }
}
