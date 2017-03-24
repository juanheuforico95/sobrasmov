package com.example.jumarogu.appabtmyself;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        this.editTextMessage = (EditText)findViewById(R.id.editTextMessage);
    }

    public void getBack(View view){

        Toast.makeText(this, "MESSAGE SENT", Toast.LENGTH_SHORT).show();

        Intent i = new Intent();
        i.putExtra("result", "OK");
        i.putExtra("message", this.editTextMessage.getText().toString());
        setResult(Activity.RESULT_OK, i);
        finish();
    }
}
