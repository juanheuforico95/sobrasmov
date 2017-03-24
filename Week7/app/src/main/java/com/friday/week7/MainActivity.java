package com.friday.week7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JSONTask.JSONCallback,
        AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    private ArrayList<Student> source;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] example = {"Paquito", "Pacote", "Paco"};
        source = new ArrayList<Student>();
        source.add(new Student("El Yisus",3));
        source.add(new Student("fernando",0));


        // Adapter
        // Clases que traducen información en una estructura a widget
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                                                android.R.layout.simple_list_item_1,
                                                example);

        ListView list = (ListView)findViewById(R.id.listView);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        list.setAdapter(adapter2);
        spinner.setAdapter(adapter2);

        list.setOnItemClickListener(this);
        spinner.setOnItemSelectedListener(this);

    }

    public void request(View v){

        JSONTask task = new JSONTask(this);
        task.execute("https://api.github.com/", "hola", "amiguitos", "salu2", "vamos a bailar", "algo que esta perron");
    }

    public void testJSON(View v){

        try{
            String json = "[{'nombre': 'Lazaro', 'calificacion':0}, " +
                    "{'nombre': 'Rudy', 'calificacion':30}, " +
                    "{'nombre': 'Paquito', 'calificacion':-10}]";

            JSONArray array = new JSONArray(json);
            JSONObject lazaro = array.getJSONObject(0);
            Toast.makeText(this, lazaro.getInt("calificacion") + "", Toast.LENGTH_SHORT).show();

        }catch(JSONException je){

            je.printStackTrace();
        }
    }

    @Override
    public void taskDone(JSONObject jsonObject) {
        try {
            Toast.makeText(this,
                    jsonObject.getString("current_user_url"),
                    Toast.LENGTH_SHORT).show();
        }catch(JSONException je){

            je.printStackTrace();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,getString(R.string.toast)+ source.get(i).getName(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
