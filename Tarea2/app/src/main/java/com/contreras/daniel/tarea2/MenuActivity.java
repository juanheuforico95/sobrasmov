package com.contreras.daniel.tarea2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private EditText hobby , friendName;
    private TextView nameTV;

    private DBHelper dataBase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent i = getIntent();

        //Initialize the interface references
        this.nameTV = (TextView)findViewById(R.id.nameTV);
        this.hobby = (EditText)findViewById(R.id.hobbyET);
        this.friendName = (EditText)findViewById(R.id.friendsET);

        this.nameTV.setText(i.getStringExtra("name")+" add friends and hobbys");

        dataBase = new DBHelper(this);
    }


    public void saveInDB(View v){
        dataBase.save(this.friendName.getText().toString(),this.hobby.getText().toString());
        Toast.makeText(this, "VALUES SAVED!", Toast.LENGTH_SHORT).show();
    }

    public void searchInDB(View v){
        int result = dataBase.find(this.friendName.getText().toString());
        Toast.makeText(this, "YOUR RESULT IS: "+ result, Toast.LENGTH_SHORT).show();
    }

    public void deleteInDB(View v){
        int result = dataBase.delete(Integer.parseInt(this.friendName.getText().toString()));
        Toast.makeText(this, "ROWS AFFECTED: " + result, Toast.LENGTH_SHORT).show();
    }
}
