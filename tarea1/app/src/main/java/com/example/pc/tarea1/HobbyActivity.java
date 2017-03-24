package com.example.pc.tarea1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HobbyActivity extends AppCompatActivity {

    private EditText editTextHobby;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);

        this.editTextHobby = (EditText)findViewById(R.id.editText2);
        this.editTextHobby.setText("");
        this.back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                getBack(v);
            }
        });

    }

    public void getBack(View view){

        Intent i = new Intent();
        i.putExtra("regreso", "OK");
        i.putExtra("hobby", this.editTextHobby.getText().toString());
        setResult(Activity.RESULT_OK, i);
        finish();
    }
}
