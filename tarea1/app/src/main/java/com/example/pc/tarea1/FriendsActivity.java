package com.example.pc.tarea1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
    }

    public void getBack(View view){

        Intent intent = new Intent();
        intent.putExtra("regreso", "OK");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
