package com.epitech.foodielife;

/**
 * Created by Tsy-jon on 30/04/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import org.json.*;
import com.loopj.android.http.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import cz.msebera.android.httpclient.Header;


/**
 * Created by LAU on 27/04/2017.
 */

public class RestClientUsage {
    private final Activity activity;
    public static boolean endRequestAll;

    public RestClientUsage(Activity activity)
    {
        this.endRequestAll = false;
        this.activity = activity;
    }
/*
    public void  register(RequestParams params) throws JSONException {
        RestClient.get("adduser", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject jsonObject)
            {

            }
        });
    }*/

    public void login(final String value) throws JSONException {
        RequestParams params = new RequestParams();
        params.put("token", value);

        RestClient.post("login", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.i("RestClientUsage", "OnSuccess");
                ((LoginActivity)activity).updateUserInfo(response);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject jsonObject)
            {
                Log.i("RCU - OnFailure", jsonObject.toString());
            }
        });
    }


    public void add_restaurant(UserClientInfo user, Restaurant restaurant)
    {
        RequestParams params = new RequestParams();
        params.put("token", user.getToken());
        params.put("restaurant", restaurant);
        RestClient.post("restaurant/add", params, new JsonHttpResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response)
        {
            Log.i("RestClientUsage", "OnSuccess");
            ((RestaurantFormActivity)activity).addRestaurantSuccess(response);
        }
        @Override
        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject jsonObject)
        {
            Log.i("RCU - OnFailure", jsonObject.toString());
        }
    });
    }
}
