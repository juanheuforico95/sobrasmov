package com.example.jumarogu.appabtmyself;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HobbyActivity extends AppCompatActivity {

    private EditText editTextHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);

        this.editTextHobby = (EditText)findViewById(R.id.editTextHobby);
    }

    public void getBack(View view){

        Intent i = new Intent();
        i.putExtra("result", "OK");
        i.putExtra("hobby", this.editTextHobby.getText().toString());
        setResult(Activity.RESULT_OK, i);
        finish();
    }
}
