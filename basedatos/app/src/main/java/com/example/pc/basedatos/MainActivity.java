package com.example.pc.basedatos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {


    //2 things -
    // properties
    // local storage with SQLite
    // - SQLite lightweight DBMs, barebones SQL db, relational
    // (remote storage)

    private DBHelper db;
    private EditText editText;

    private Properties properties;
    private static final String PROPERTIES_FILE = "properties.xml";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);
        editText = (EditText)findViewById(R.id.editText);

        File file = new File(getFilesDir(), PROPERTIES_FILE);
        properties = new Properties();

        try {
            if (file.exists()) {

                FileInputStream fis = openFileInput(PROPERTIES_FILE);
                properties.loadFromXML(fis);
                fis.close();

                Log.i("ONCREATE", "LOADING FROM STORAGE");
                Toast.makeText(this, "LOADED FROM STORAGE", Toast.LENGTH_SHORT).show();
            } else {

                saveProperties();
            }
        }catch(IOException ioe){

            ioe.printStackTrace();
        }
    }

    private void saveProperties() throws IOException {

        FileOutputStream fos = openFileOutput(PROPERTIES_FILE, Context.MODE_PRIVATE);
        properties.storeToXML(fos, null);
        fos.close();

        Toast.makeText(this, "FILE SAVED TO STORAGE", Toast.LENGTH_SHORT).show();
    }

    public void add(View v){

        db.add(editText.getText().toString());
        Toast.makeText(this, "RECORD ADDED", Toast.LENGTH_SHORT).show();
    }

    public void find(View v){

        Toast.makeText(this,
                "found: " + db.find(editText.getText().toString()),
                Toast.LENGTH_SHORT).show();
    }

    public void delete(View v){

        Toast.makeText(this,
                "deleted: " + db.delete(editText.getText().toString()),
                Toast.LENGTH_SHORT).show();
    }

    public void saveProperty(View v){
        properties.setProperty("demo", editText.getText().toString());
        Toast.makeText(this, "PROPERTY SET", Toast.LENGTH_SHORT).show();
    }

    public void loadProperty(View v){

        Toast.makeText(this, properties.getProperty("demo"), Toast.LENGTH_SHORT).show();
    }

    public void saveToStorage(View v){

        try{
            saveProperties();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        Toast.makeText(this, "SAVED TO STORAGE", Toast.LENGTH_SHORT).show();
    }
}
