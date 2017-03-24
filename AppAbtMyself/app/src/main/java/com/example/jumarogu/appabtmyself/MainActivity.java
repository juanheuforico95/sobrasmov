package com.example.jumarogu.appabtmyself;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);
    }

    public void buttonWasClicked(View v){

        Toast.makeText(this, "BUTTON WAS CLICKED", Toast.LENGTH_SHORT).show();

        // in android to open up a new activity you don't COMMAND
        // you ask!
        // Intent - request for activity
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("test", editText.getText().toString());
        startActivityForResult(intent, REQUEST_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){

            Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
        }
    }
}