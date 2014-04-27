package com.protodx.notifier;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Makes a GET request to URL
 */
public class LightLightsTask extends AsyncTask<String, Void, String> {

    private static final String TAG = "LightLightsTask";

    private static final boolean DBG = true;

    @Override
    protected String doInBackground(String... urls) {
        for (String url : urls) {
            if(DBG){
                Log.d(TAG, "doInBackground('"+url+"')");
            }

            DefaultHttpClient mClient = new DefaultHttpClient();
            HttpGet mHttpGet = new HttpGet(url);
            try {
                HttpResponse mResponse = mClient.execute(mHttpGet);
                return EntityUtils.toString(mResponse.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if(DBG){
            Log.d(TAG, "onPostExecute()");
        }
    }
}