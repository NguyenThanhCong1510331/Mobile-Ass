package com.example.asus.ex3;

import android.content.Context;
import android.os.AsyncTask;

import com.example.asus.ex3.Util.HttpHandler;
import com.example.asus.ex3.Util.NotificationHelper;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.ref.WeakReference;

public class GetRelatedJobs extends AsyncTask<String, Void, Integer> {
    private WeakReference<Context> contextWeakReference;

    public GetRelatedJobs(Context context) {
        this.contextWeakReference = new WeakReference<>(context);
    }

    @Override
    protected Integer doInBackground(String... url) {
        HttpHandler sh = new HttpHandler();
        String jsonStr = sh.makeServiceCall(url[0]);
        if (jsonStr != null) {
            try {
                JSONArray jobs = new JSONArray(jsonStr);
                return jobs.length();
            } catch (final JSONException e) {
                return 0;
            }
        }
        return 0;
    }
    @Override
    protected void onPostExecute(Integer value) {
        super.onPostExecute(value);
        if (value > 0) {
            Context context = contextWeakReference.get();
            if (context != null) {
                new NotificationHelper(context).showNotification(value);
            }
        }
    }
}
