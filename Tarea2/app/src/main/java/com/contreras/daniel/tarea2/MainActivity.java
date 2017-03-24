package com.contreras.daniel.tarea2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    private TextView greeting1, greeting2 , nameTV;
    private EditText name ;
    private Properties properties;
    private static final String myFile="properties.xml";

    private static final String greetingFileName = "secondGreeting.txt";
    private static final int MENU_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greeting1 = (TextView)findViewById(R.id.greetingsTV);
        greeting2 = (TextView)findViewById(R.id.greeting2);
        nameTV = (TextView)findViewById(R.id.nameTV);
        name = (EditText)findViewById(R.id.nameET);

        //loading the greetings
        try{
            //Greeting loaded from raw
            InputStream is = getResources().openRawResource(R.raw.greeting);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            //Greeting loaded from assets
            InputStream inputS = getAssets().open(greetingFileName);
            InputStreamReader inputSR = new InputStreamReader(inputS);
            BufferedReader secondBR = new BufferedReader(inputSR);

            this.greeting1.setText(br.readLine());
            this.greeting2.setText(secondBR.readLine());

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        //Loading the name
        File file  = new File(getFilesDir(),myFile);
        this.properties = new Properties();
        try{
            if(file.exists()){
                //Load the file
                FileInputStream fish = openFileInput(myFile);
                properties.loadFromXML(fish);
                fish.close();
                this.nameTV.setText(properties.getProperty("name"));
            }else{
                //Create the file
                FileOutputStream fosa = openFileOutput(myFile, Context.MODE_PRIVATE);
                properties.storeToXML(fosa,null);
                fosa.close();
                this.nameTV.setText("User");
            }

        }catch (Exception e){
            Log.wtf("MAIN","error loading file");
        }

    }

    public void saveName(View view){
        properties.setProperty("name",this.name.getText().toString());
        try {
            FileOutputStream fosa = openFileOutput(myFile, Context.MODE_PRIVATE);
            properties.storeToXML(fosa,null);
            fosa.close();
        }catch (Exception e){
            Log.wtf("MAIN", "Error loading file.");
        }
        this.nameTV.setText(properties.getProperty("name"));
    }

    public void changeToMenuActivity(View v){
        Intent i = new Intent(this,MenuActivity.class);
        i.putExtra("name",properties.getProperty("name"));
        startActivityForResult(i,MENU_ACTIVITY_REQUEST_CODE);
    }

}
