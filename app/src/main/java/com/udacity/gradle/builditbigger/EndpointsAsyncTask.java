package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;


/**
 * Created by harry on 12/28/2017.
 */

public class EndpointsAsyncTask extends AsyncTask<JokeListener, Void, String> {
    private static MyApi myApiService = null;
    private JokeListener mListener;

    @Override
    protected String doInBackground(JokeListener... jokeListeners) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-190505.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        mListener = jokeListeners[0];

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String result) {
        mListener.onJokeReceived(result);
    }
}
