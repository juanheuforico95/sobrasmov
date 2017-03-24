import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by pc on 03/03/2017.
 */

public class JSONTask extends AsyncTask<String, Void, JSONObject> {
    @Override
    private JSONCallback listener;

    private  JSONTask (JSONCallback)
    protected JSONObject doInBackground(String... strings) {
        JSONObject result = null;
        try{
            URL url = new URL (strings [0]);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            if (connection.getResponseCode()== HttpURLConnection.HTTP_OK){
                InputStream is = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                StringBuilder sb = new StringBuilder();
                String curentline = "";
                while ((curentline = br.readLine()) != null){
                    sb.append(curentline);
                    Log.i("JSON TASK", curentline);
                }
                result = new JSONObject(sb.toString());

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }
    protected  void onPostExecute(JSONObject jsonObject)

}
