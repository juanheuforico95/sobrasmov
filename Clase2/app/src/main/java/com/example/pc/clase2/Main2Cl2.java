package com.example.pc.clase2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Cl2 extends AppCompatActivity {
    private static final int MAIN2_REQUEST_CODE = 0;
    private TextView textView;
    private EditText editText;
    private Button button1, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_cl2);
        textView = (TextView)findViewById(R.id.textView2);
        editText = (EditText)findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button2);
        button2 = (Button) findViewById(R.id.button3);

        textView.setText("Hey Guys");
        editText.setText("Salu2");
        button1.setText("Button 1");
        button2.setText("Button 2");
    }

    // first way to capture a button press
    //a method that can listen to it
    public void exampleClick (View v){


        //Content
        // - a class whose objects contain information about the devide
        // - 2 ways to access our current context
        // -- first way getApplicationContext
        // -- all applications extend Context - therefore you can use this


        Toast t = Toast.makeText(this, "THIS IS A TOAST", Toast.LENGTH_SHORT);
        t.show();
        Intent intent = new Intent(this, juan1.class);
        intent.putExtra("texto",editText.getText().toString());
        startActivityForResult(intent, MAIN2_REQUEST_CODE);


    }
    protected void onActivityresult(int requestCode, int resultCode, Intent data){
        Log.d("MAINACTIVITY","REQUEST CODE"+ requestCode);
        if(requestCode == MAIN2_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Toast.makeText(this, data.getStringExtra("regreso"), Toast.LENGTH_SHORT).show();
        }
    }
    }


