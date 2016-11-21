package com.example.shruti5488.test.background;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.example.shruti5488.test.Services.DataService;
import com.example.shruti5488.test.activities.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by vinam on 11/21/2016.
 */

public class HouseAsyncTask extends AsyncTask<String, String, String> {

   // private ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
    InputStream inputStream = null;
    String result = "";

    String item_id = "";

    protected String doInBackground(String... params) {


        String response = null;

        try {
            Log.d("Hello", "Start try");
            //Log.d("Hello", "param" + params[0]);
            String reqUrl = params[0];
            item_id = params[1];
            if(item_id.equalsIgnoreCase("leg_house")){
                Log.d("Hello", "param id " + params[1]);
                URL url = new URL(reqUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                // read the response
                InputStream in = new BufferedInputStream(conn.getInputStream());
                //  Log.d("Hello", "try" + conn.getContentLength());
                response = convertStreamToString(in);
            }

            //  Log.d("Hello", "JSON recvd!" + response);

        } catch (MalformedURLException e) {
            Log.e("Hello", "MalformedURLException: " + e.getMessage());
            e.printStackTrace();
        } catch (ProtocolException e) {
            Log.e("Hello", "ProtocolException: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("Hello", "IOException: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            Log.e("Hello", "Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return response;

    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        // Log.d("Hello", "result recv" + s);
//            JSONArray jArray = null;
        try {
//                jArray = new JSONArray(s);

//                for (int i = 0; i < jArray.length(); i++) {
            Log.d("Hello","item id "+item_id);
              if (item_id.equalsIgnoreCase("leg_house")) {
                JSONObject jArray = new JSONObject(s);
//                        JSONObject jObject = jArray.getJSONObject(i);
                JSONArray jsonArray = jArray.getJSONArray("results");
                Log.d("Hello","leg house array sze "+ jsonArray.length());
                for (int j = 0; j < jsonArray.length(); j++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(j);
                    String first_name = jsonObject.getString("first_name");
                    String last_name = jsonObject.getString("last_name");
                    String name = last_name+", "+first_name;
                    String party = jsonObject.getString("party");
                    String state = jsonObject.getString("state_name");
                    String district = jsonObject.getString("district");
                    String stateName = "("+party+")"+state+" - District "+district;
                    String bioguideId = jsonObject.getString("bioguide_id");
                  //  Log.d("Hello","name of house " + name);
                    String image = "https://theunitedstates.io/images/congress/225x275/" + bioguideId  + ".jpg";
                    DataService.getInstance().setHouseList(image, name, stateName, district);
                }
            }

//                }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("Hello", "errror:  " + e.getMessage());
        }
    }
}
