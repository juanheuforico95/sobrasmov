package com.example.pc.clase2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class juan1 extends AppCompatActivity {

    private TextView editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juan1);
        editText = (TextView)findViewById(R.id.editText);
        Intent intent =getIntent();
        editText.setText(intent.getStringExtra("texto"));
    }
    public void goBack(View v){
        Intent intent = new Intent();
        intent.putExtra("regreso","MENSAJE DE ACTIVIDAD 2");
        setResult(Activity.RESULT_OK, intent);
        finish();
     }
}
