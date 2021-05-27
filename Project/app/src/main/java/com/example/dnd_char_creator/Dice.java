package com.example.dnd_char_creator;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

public class Dice {

    private Context context;
    private rollListener listener;
    public int results;

    public Dice(Context context, rollListener listener)
    {
        if (listener != null) {
            this.listener = listener;
        }
        this.context = context;
    }

    public void roll(){
        RequestQueue queue = Volley.newRequestQueue(context);

        String key = "here you place your API key";
        String url = "http://roll.diceapi.com/json/d6";   //" here you place the URL for your query";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject obj = new JSONObject(response);
                            //results = obj.getInt("value");
                            JSONArray diceArray = obj.getJSONArray("dice");
                            results = diceArray.getJSONObject(0).getInt("value");
                            listener.rollLoaded(results);
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //processJSON(response);
                        //listener.rollLoaded(results);
                    }
                }, new Response.ErrorListener()  {
            @Override
            public void onErrorResponse(VolleyError error){
                Log.e("ERROR", error.getMessage(), error);
            }
        });
        queue.add(stringRequest);
    }

    public void processJSON(String response){
        try{
            JSONObject obj = new JSONObject(response);
            results = obj.getInt("value");
            listener.rollLoaded(results);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public interface rollListener {
        public void rollLoaded(int results);
    }


}
