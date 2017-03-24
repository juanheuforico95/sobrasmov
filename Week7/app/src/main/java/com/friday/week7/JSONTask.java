package com.friday.week7;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by gdaalumno on 3/3/17.
 */

// asyncTask
    //- behavior that runs concurrently
    //- 3 generic types
    // - first type : Input
    // - second type : Progress value
    // - third type : Output
public class JSONTask extends AsyncTask<String, Void, JSONObject> {

    private JSONCallback listener;

    public JSONTask(JSONCallback listener){
        this.listener = listener;
    }

    @Override
    protected JSONObject doInBackground(String... strings) {

        JSONObject result = null;

        try{

            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            // http code - 404, 500, 200
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){

                InputStream is = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                StringBuilder sb = new StringBuilder();
                String currentLine = "";

                while((currentLine = br.readLine()) != null){

                    sb.append(currentLine);
                    Log.i("JSON TASK", currentLine);
                }

                result = new JSONObject(sb.toString());
            }

        }catch(Exception e){

            e.printStackTrace();
        }

        return result;

    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
        listener.taskDone(jsonObject);
    }

    // callback
    public interface JSONCallback {
        void taskDone(JSONObject jsonObject);
    }
}
