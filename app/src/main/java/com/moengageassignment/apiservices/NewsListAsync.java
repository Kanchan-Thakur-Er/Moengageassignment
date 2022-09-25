package com.moengageassignment.apiservices;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.moengageassignment.activities.MainActivity;
import com.moengageassignment.config.Constant;
import com.moengageassignment.databinding.ActivityMainBinding;
import com.moengageassignment.models.Article;
import com.moengageassignment.models.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class NewsListAsync extends AsyncTask<String, String, String> {
    ArrayList<Article> userArray;
    ProgressDialog progressDialog;
    MainActivity activity;
    public NewsAsyncResponse newsAsyncResponse;
    ActivityMainBinding activityMainBinding;

    public NewsListAsync(NewsAsyncResponse newsAsyncResponse, MainActivity application) {
        this.newsAsyncResponse = newsAsyncResponse;
        this.activity=application;
    }
    @Override
    protected String doInBackground(String... params) {

        // Fetch data from the API in the background.

        String result = "";
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(Constant.BASE_URl);
                //open a URL coonnection

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader isw = new InputStreamReader(in);

                int data = isw.read();

                while (data != -1) {
                    result += (char) data;
                    data = isw.read();

                }

                // return the data to onPostExecute method
                return result;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Exception: " + e.getMessage();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {

        // dismiss the progress dialog after receiving data from API
       progressDialog.dismiss();
        try {

            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray1 = jsonObject.getJSONArray("articles");
            Gson gson = new Gson();
            Type userListType = new TypeToken<ArrayList<Article>>(){}.getType();
           userArray = gson.fromJson(jsonArray1.toString(), userListType);
            newsAsyncResponse.processFinish(userArray);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // display a progress dialog to show the user what is happening
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Data loading");
        progressDialog.setCancelable(false);
        progressDialog.show();


    }
    public interface NewsAsyncResponse {
        void processFinish( ArrayList<Article>  output);
    }

}