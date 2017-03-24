package com.example.jumarogu.appabtmyself;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 2;
    private static final int REQUEST_CODE_MESSAGE = 0;
    private static final int REQUEST_CODE_HOBBY = 1;
    private TextView textView, textViewMessage, textViewHobby;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent i = getIntent();
        //Toast.makeText(this, i.getStringExtra("test"), Toast.LENGTH_SHORT).show();

        this.textView = (TextView)findViewById(R.id.textView);
        this.textViewMessage = (TextView)findViewById(R.id.textViewMessage);
        this.textViewHobby = (TextView)findViewById(R.id.textViewHobby);

        this.textView.setText("Hi, " + i.getStringExtra("test"));
    }

    public void messageActivity(View view) {

        Intent intent = new Intent(this, MessageActivity.class);
        startActivityForResult(intent, REQUEST_CODE_MESSAGE);
    }

    public void friendsActivity(View view) {

        Intent intent = new Intent(this, FriendsActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void hobbyActivity(View view) {

        Intent intent = new Intent(this, HobbyActivity.class);
        startActivityForResult(intent, REQUEST_CODE_HOBBY);
    }

    public void getBack(View view){

        Intent i = new Intent();
        i.putExtra("result", "OK");
        setResult(Activity.RESULT_OK, i);
        finish();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode == REQUEST_CODE_MESSAGE && resultCode == Activity.RESULT_OK){

            Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
            this.textViewMessage.setText(data.getStringExtra("message"));
        }
        else if(requestCode == REQUEST_CODE_HOBBY && resultCode == Activity.RESULT_OK) {

            Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
            this.textViewHobby.setText(data.getStringExtra("hobby"));
        }
        else if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
        }
    }
}
