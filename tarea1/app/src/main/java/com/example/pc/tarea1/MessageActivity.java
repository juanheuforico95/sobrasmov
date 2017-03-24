package com.example.pc.tarea1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    private EditText editTextMessage;
    private Button send;
    private static final int MAIN2_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        this.editTextMessage = (EditText)findViewById(R.id.editTextMessage);
        this.send = (Button) findViewById(R.id.send);
        this.send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                getBack(v);
            }
        });
    }

    public void getBack(View view){

        Toast.makeText(this, "MESSAGE SENT", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent, MAIN2_REQUEST_CODE);
        finish();

/*
        Intent i = new Intent();
        i.putExtra("regreso", "OK");
        i.putExtra("message", this.editTextMessage.getText().toString());
        setResult(Activity.RESULT_OK, i);
        finish();*/
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        // method that listens for an activity ending
        // Log.d("MAINACTIVITY", "REQUEST CODE: " + requestCode);
        if(requestCode == MAIN2_REQUEST_CODE && resultCode == Activity.RESULT_OK){

            Toast.makeText(this, data.getStringExtra("regreso"), Toast.LENGTH_SHORT).show();
        }
    }
}
